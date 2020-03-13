package ibatis.services.user.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.service.domain.User;

public class MyBatisTestApp01 {

	public static void main(String[] args) {

		// mybatis-config01.xml: MyBatis Framework의 핵심 Meta Data
		// userMapper01.xml: SQL을 갖는 Meta Data
		try {
			// 1. Declare field
			Reader reader 						= null;
			SqlSession sqlSession 				= null;
			List<User> selectList 				= null;
			SqlSessionFactory sqlSessionFactory = null;

			// 2. xml meta data 읽는 Stream 생성
			reader = Resources.getResourceAsReader("sql/mybatis-config01.xml");
			// 3. Reader 객체를 이용하여 xml meta data에 설정된 각 정보를 접근. sqlSession을 생성하는 SqlSessionFactory 인스턴스 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// 4. SqlSessionFactory를 통해 auto commit true인 SqlSession 인스턴스 생성
			sqlSession = sqlSessionFactory.openSession();
			
			// 5. 모든 User DB 정보 가져오기
			System.out.println("========userMapper01.selectUserList========");
			selectList = sqlSession.selectList("userMapper01.selectUserList");
			for(User user : selectList) {
				System.out.println(user.toString());
			}
			
			// 6. 특정 User DB 정보 가져오기
			System.out.println("========userMapper01.selectUser========");
			Object user = sqlSession.selectOne("userMapper01.selectUser", selectList.get(0).getId());
			if(user instanceof User) {
				System.out.println(user.toString());
			}
			
			// 6. 특정 User의 AGE DB 정보 가져오기
			System.out.println("========userMapper01.findUserAge========");
			Object age = sqlSession.selectOne("userMapper01.findUserAge", selectList.get(2));
			if(age instanceof Integer) {
				System.out.println("found " + selectList.get(2) + " name : " + age);
			}
			
			// 7. AGE 정보로 모든 User DB 정보 가져오기
			System.out.println("========userMapper01.selectUserListByAge========");
			Object tempUserNameList = sqlSession.selectList("userMapper01.selectUserListByAge", selectList.get(4).getAge());
			if(tempUserNameList instanceof List) {
				List userNameList = (List)tempUserNameList;
				for(Object userName : userNameList) {
					System.out.println(userName + " age is " + selectList.get(4).getAge());
				}
			}
			
			// 8. 자원 닫기
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
