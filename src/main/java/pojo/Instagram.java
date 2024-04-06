package pojo;

public class Instagram {
	private int id;
	   private String  title;
	   private String first_name;
	   private String last_name;
	   
	public String toString() {
		return "Instagram [id=" + id + ", title=" + title + ", first_name=" + first_name + ", last_name=" + last_name
				+ "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
