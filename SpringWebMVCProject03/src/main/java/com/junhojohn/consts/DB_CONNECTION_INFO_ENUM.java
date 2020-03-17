package com.junhojohn.consts;

/**
 * DB 드라이버 연결 관련 설정 정보를 매핑한 ENUM 클래스
 * @author junhojohn
 *
 */
public enum DB_CONNECTION_INFO_ENUM {

	ORACLE_DB_URL("ORACLE_DB_URL", "jdbc:oracle:thin:@127.0.0.1:1521:junhojohn"),
	ORACLE_DB_ID("ORACLE_DB_ID", "SYSTEM"),
	ORACLE_DB_PWD("ORACLE_DB_PWD", "Wnsgh3535"),
	ORACLE_DB_DRIVER("ORACLE_DB_DRIVER", "oracle.jdbc.driver.OracleDriver");
	
	private String key;
	private String value;
	
	private DB_CONNECTION_INFO_ENUM(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
