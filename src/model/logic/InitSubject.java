package model.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.data.SubjectDto;

public class InitSubject {
	
	private List<SubjectDto> subjectList;
	
	public InitSubject() {
		this.subjectList = new ArrayList<>();
	}
	
	public List<SubjectDto> addSubject(SubjectDto subject) {
		subjectList.add(subject);
		return subjectList;
	}
	
	public List<String> getSubjectNames(Map<Integer, SubjectDto> subjectMap) {
		List<String> list = new ArrayList<>();
		
		for(int i = 1; i <= subjectMap.size(); i++) {
			list.add(subjectMap.get(i).getSubjectName());
		}
		
		return list;
	}
	
	
}
