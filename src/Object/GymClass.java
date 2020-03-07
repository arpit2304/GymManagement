package Object;

public class GymClass {
	private int id;
	private String name;
	private String desc;
	private String trainername;
	private String date;
	private String time;
	private String spots;
	
	public GymClass(int id, String name, String desc, String trainername, String date, String time, String spots) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.trainername = trainername;
		this.date = date;
		this.time = time;
		this.spots = spots;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the trainername
	 */
	public String getTrainername() {
		return trainername;
	}

	/**
	 * @param trainername the trainername to set
	 */
	public void setTrainername(String trainername) {
		this.trainername = trainername;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the spots
	 */
	public String getSpots() {
		return spots;
	}

	/**
	 * @param spots the spots to set
	 */
	public void setSpots(String spots) {
		this.spots = spots;
	}
}
