package model.data;

public class SubjectDto {

	private String name;
	private String colorTag;
	private int sid; // Subject Identifier Number
	private String teacher;
	private String desc; // description for a subject
	
	public SubjectDto(String subjectNamed, String color) {
		this.name = subjectNamed;
		this.colorTag = color;
		this.sid = 0;
		this.teacher = "";
		this.desc = subjectNamed;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColorTag() {
		return colorTag;
	}
	public void setColorMarking(String colorTag) {
		this.colorTag = colorTag;
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
