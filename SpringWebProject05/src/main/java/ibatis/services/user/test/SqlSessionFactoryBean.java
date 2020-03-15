package ibatis.services.user.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * SqlSession을 생성하는 공통적 코딩 모듈
 * 테스트를 편하게 하기 위한 공통적 코딩 모듈
 * @author 82109
 *
 */
public class SqlSessionFactoryBean {

	/**
	 * 유틸성 공통 모듈이기 때문에 생성자를 통한 객체 인스턴스 생성을 금한다.
	 * 대신 static factory method를 제공한다.
	 */
	private SqlSessionFactoryBean() {
		
	}
	
	/**
	 * mybatis-config.xml : MyBatis Framework의 핵심 Meta Data
	 * xxxMapper.xml: SQL 정보를 갖는 Meta Data
	 * Meta Data 설정된 정보를 접근, 사용가능한 SqlSession Instance를 리턴하는 static factory method
	 * @return org.apache.ibatis.session.SqlSession
	 * @throws IOException
	 */
	public static SqlSession getSqlSession() throws IOException{
		
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config01.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		return sqlSessionFactory.openSession();
		
	}
	
	/**
	 * List 에 저장된 item들을 출력한다.
	 * @param list
	 */
	public static void printList(List list) {
		if(list == null || list.size() == 0) {
			return;
		}
		
		for(Object item : list) {
			System.out.println(item.toString());
		}
		System.out.println("\n");
	}
}
