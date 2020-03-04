package com.junhojohn.core.models;

/**
 * User 정보를 담는 모델
 * @author junhojohn
 *
 */
public class UserVO {

	/**사용자 ID**/
	private String id;
	/**사용자 비밀번호**/
	private String pwd;
	/**DB로부터 조회성공 시**/
	private boolean isActive;
	
	/**
	 * Default Constructor
	 */
	public UserVO() {
	}

	/**
	 * 사용자 ID를 얻는다.
	 * @return 사용자 ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * 사용자 ID를 세팅한다.
	 * @param 사용자 ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 사용자 비밀번호를 얻는다.
	 * @return 사용자 비밀번호
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * 사용자 비밀번호를 세팅한다.
	 * @param 사용자 비밀번호
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 사용자 정보를 DB로부터 조회에 성공했는지 여부를 얻는다.
	 * @return 조회 성공 시 true, 실패 시 false
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * 사용자 정보를 DB로부터 조회에 성공했는지 여부를 세팅한다.
	 * @param 조회 성공 시 true, 실패 시 false
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
