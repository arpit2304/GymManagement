package Controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DBUtil.DataBaseFunctions;
import Object.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataBaseFunctions dbUtil;

	@Resource(name = "jdbc/Java3FinalProject")
	private DataSource dataSource;

	public void init() throws ServletException {

		super.init();

		try {
			dbUtil = new DataBaseFunctions(dataSource);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			//try getting the user from db
			User user = dbUtil.findUser(request.getParameter("username"), request.getParameter("password"));
			
			if(user == null) {
				//if no user found at all, reroute to unlogged page
				String message = "User not found or credentials not right";
				request.setAttribute("message", message);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/GymBoiUnLogged.jsp");
				dispatcher.forward(request,response);
			}else if(user.isAdmin() == false && user.isTrainer() == false){
				//if a user is found but they arent an admin or trainer
				
				/*Cookie[] cookies = request.getCookies();
				Cookie newCookie;
				if(cookies==null || cookies.length==0) {
					newCookie = new Cookie("fName", user.getfName());
					newCookie.setMaxAge(100);
					response.addCookie(newCookie);
					newCookie = new Cookie("userName", user.getUserName());
					newCookie.setMaxAge(100);
					response.addCookie(newCookie);
				}else {
					for (Cookie cookie : request.getCookies()) {
					    cookie.setValue("");
					    cookie.setMaxAge(0);
					    cookie.setPath("/");

					    response.addCookie(cookie);
					}
					newCookie = new Cookie("fName", user.getfName());
					newCookie.setMaxAge(100);
					response.addCookie(newCookie);
					newCookie = new Cookie("userName", user.getUserName());
					newCookie.setMaxAge(100);
					response.addCookie(newCookie);
				}*/
				request.setAttribute("fName", user.getfName());
				request.setAttribute("userName", user.getUserName());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/GymBoiUserPortal.jsp");
				dispatcher.forward(request,response);
			}else if(user.isAdmin() == true && user.isTrainer() == false) {
				//if it is an admin send to the admin home page
				request.setAttribute("userGeneric", user.getfName());
				request.setAttribute("userID", user.getUserName());
				request.setAttribute("command", "LIST");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/GymBoiAdminPortal.jsp");
				dispatcher.forward(request,response);
			}else if(user.isTrainer() == true && user.isAdmin() == false) {
				//if it is an trainer send to the trainer home page
				request.setAttribute("userGeneric", user.getfName());
				request.setAttribute("userName", user.getUserName());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/GymBoiTrainerPortal.jsp");
				dispatcher.forward(request,response);
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
