package controller;

import java.util.ArrayList;
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
	private List<SubjectDto> subjectList;
	private List<String> subjectNamesList;
	private Map<Integer, SubjectDto> subjectMap;
	
	public SubjectController(String user) {
		this.user = user;
		this.initSubject = new InitSubject();
		this.subjectDao = new SubjectDao();
		this.subjectDto = new SubjectDto(user, 0, "", "", "", "");
		this.subjectList = new ArrayList<>();
	}
	
	public SubjectDto getSubjectDto() {
		return subjectDto;
	}
	
	public int addSubject(int sid, String subjectNamed, String color, String teacher, String desc) {
		subjectDto = new SubjectDto(user, sid, subjectNamed, color, teacher, desc);
		int numOfSub = subjectDao.readNumOfSub(subjectDto);
		
		if(numOfSub > 0 && numOfSub < 10) {
			int result = subjectDao.insertSubject(subjectDto);
			if(result == 1) {
				updateHasSub(subjectDto);
			}
			
			subjectList = initSubject.addSubject(subjectDto);
			
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
	
	public List<String> getSubjectNames() {
		subjectNamesList = initSubject.getSubjectNames(subjectList);
		return subjectNamesList;
	}
	
	public Map<Integer, SubjectDto> readSubject() {
		subjectMap = subjectDao.readSubject(subjectDto);
		return subjectMap;
	}
}







