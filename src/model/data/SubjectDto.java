package model.data;

public class SubjectDto {

	private String name;
	private String colorMarking;
	private int sid; // Subject Identifier Number
	private String teacher;
	private String desc; // description for this subject
	
	public SubjectDto(String subjectName, String color) {
		this.name = subjectName;
		this.colorMarking = color;
		this.sid = 0;
		this.teacher = "";
		this.desc = subjectName;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColorMarking() {
		return colorMarking;
	}
	public void setColorMarking(String colorMarking) {
		this.colorMarking = colorMarking;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int number) {
		sid = number;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
