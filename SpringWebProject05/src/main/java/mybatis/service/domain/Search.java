package mybatis.service.domain;

import java.util.ArrayList;

/*
 * FileName : Search.java
 *   ㅇ Dynamic SQL 구성시  <foreach> elements 를 이용 반복적 구문생성시 전달되는 
 *       Collection List , Array 갖는 ValueObeject  
  */
public class Search {
	///Field
	private String[] nameList;
	private ArrayList<String> idList;
	private String searchCondition;
	
	///Constructor
	public Search() {
	}
	
	///Method
	public String[] getNameList() {
		return nameList;
	}

	public void setNameList(String[] nameList) {
		this.nameList = nameList;
	}

	public ArrayList<String> getIdList() {
		return idList;
	}

	public void setIdList(ArrayList<String> idList) {
		this.idList = idList;
	}
	
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
}//end of class