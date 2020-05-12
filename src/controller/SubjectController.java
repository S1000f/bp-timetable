package controller;

import java.util.ArrayList;
import java.util.List;

import model.data.SubjectDao;
import model.data.SubjectDto;
import model.logic.InitSubject;

public class SubjectController {
	
	private String user;
	private SubjectDao subjectDao;
	private SubjectDto subjectDto;
	private InitSubject initSubject;
	private List<SubjectDto> subjectList;
	private List<String> subjectNamesList;
	
	public SubjectController(String user) {
		this.user = user;
		this.initSubject = new InitSubject();
		this.subjectDao = new SubjectDao();
		this.subjectList = new ArrayList<>();
	}
	
	public int addSubject(int sid, String subjectNamed, String color, String teacher, String desc) {
		subjectDto = new SubjectDto(user, sid, subjectNamed, color, teacher, desc);
		int result = subjectDao.insertSubject(subjectDto);
		//
		System.out.println(result);
		subjectList = initSubject.addSubject(subjectDto);
		
		return result;
	}
	
	public List<String> getSubjectNames() {
		subjectNamesList = initSubject.getSubjectNames(subjectList);
		return subjectNamesList;
	}
}







