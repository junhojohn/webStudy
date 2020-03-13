package ibatis.services.user.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.service.domain.User;

public class MyBatisTestApp03 {

	public static void main(String[] args) {
		try {
			Reader reader = Resources.getResourceAsReader("sql/mybatis-config01.xml");
			
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();

			System.out.println("================INSERT================");
			User newUser = new User("test", "test", "test", 20, 1);
			int result = sqlSession.insert("userMapper03.insertUser", newUser);
			System.out.println("result:" + result);
			
			System.out.println("================INSERT RESULT================");
			List userList = sqlSession.selectList("userMapper03.selectUserList");
			for(Object user : userList) {
				if(user instanceof User) {
					System.out.println(user.toString());					
				}
			}
			
			System.out.println("================UPDATE================");
			newUser.setName("test2");
			newUser.setPwd("test2");
			newUser.setAge(30);
			newUser.setGrade(0);
			result = sqlSession.update("userMapper03.updateUser", newUser);
			System.out.println("result:" + result);
			
			System.out.println("================UPDATE RESULT================");
			userList = sqlSession.selectList("userMapper03.selectUserList");
			for(Object user : userList) {
				if(user instanceof User) {
					System.out.println(user.toString());
				}
			}
			
			System.out.println("================DELETE================");
			result = sqlSession.delete("userMapper03.deleteUser", newUser);
			System.out.println("result:" + result);
			
			System.out.println("================DELETE RESULT================");
			userList = sqlSession.selectList("userMapper03.selectUserList");
			for(Object user : userList) {
				if(user instanceof User) {
					System.out.println(user.toString());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
