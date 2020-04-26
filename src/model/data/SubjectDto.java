package model.data;

public class SubjectDto {

	private String user;
	private int sid; // Subject Identifier Number
	private String subjectName;
	private String colorTag;
	private String teacher;
	private String desc; // description for a subject
	
	public SubjectDto(String user, int sid, String subjectNamed, String color, String teacher, String desc) {
		this.user = user;
		this.sid = sid;
		this.subjectName = subjectNamed;
		this.colorTag = color;
		this.teacher = teacher;
		this.desc = desc;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSubjectName() {
		return subjectName;
	}
	public void setName(String name) {
		this.subjectName = name;
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
