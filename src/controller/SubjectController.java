package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.data.SubjectDao;
import model.data.SubjectDto;
import model.logic.InitSubject;

public class SubjectController {
	
	private String user;
	private SubjectDao subjectDao;
	private SubjectDto subjectDto;
	private InitSubject initSubject;
	private List<String> subjectNamesList;
	private Map<Integer, SubjectDto> subjectMap;
	
	public SubjectController(String user) {
		this.user = user;
		this.subjectDao = new SubjectDao();
		this.subjectDto = new SubjectDto(user, 0, "", "", "", "");
		this.initSubject = new InitSubject();
		this.subjectNamesList = new ArrayList<>();
		this.subjectMap = new HashMap<>();
	}
	
	public SubjectDto getSubjectDto() {
		return subjectDto;
	}
	
	public int addSubject(int sid, String subjectNamed, String color, String teacher, String desc) {
		subjectDto = new SubjectDto(user, sid, subjectNamed, color, teacher, desc);
		int numOfSub = subjectDao.readNumOfSub(subjectDto);
		
		if(numOfSub >= 0 && numOfSub < 10) {
			int result = subjectDao.insertSubject(subjectDto);
			if(result == 1) {
				updateHasSub(subjectDto);
			}
			
			return result;
			
		} else if(numOfSub >= 10) {
			return 10;
		} else {
			return -1;
		}
	}
	
	public void updateHasSub(SubjectDto sub) {
		subjectDao.updateHasSub(sub);
	}
	
	public Map<Integer, SubjectDto> readSubject() {
		subjectMap = subjectDao.readSubject(subjectDto);
		return subjectMap;
	}
	
	public List<String> getSubjectNames() {
		subjectNamesList = initSubject.getSubjectNames(subjectMap);
		return subjectNamesList;
	}
}







