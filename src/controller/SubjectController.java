package controller;

import java.util.ArrayList;
import java.util.List;

import model.data.SubjectDB;
import model.data.SubjectDto;
import model.logic.InitSubject;

public class SubjectController {
	
	private String user;
	private SubjectDB subjectDb;
	private SubjectDto subjectDto;
	private InitSubject initSubject;
	private List<SubjectDto> subjectList;
	private List<String> subjectNamesList;
	
	public SubjectController(String user) {
		this.user = user;
		this.initSubject = new InitSubject();
		this.subjectDb = new SubjectDB();
		this.subjectList = new ArrayList<>();
	}
	
	public int addSubject(int sid, String subjectNamed, String color, String teacher, String desc) {
		subjectDto = new SubjectDto(user, sid, subjectNamed, color, teacher, desc);
		subjectList = initSubject.addSubject(subjectDto);
		
		return 0;
	}
	
	public List<String> getSubjectNames() {
		subjectNamesList = initSubject.getSubjectNames(subjectList);
		return subjectNamesList;
	}
}







