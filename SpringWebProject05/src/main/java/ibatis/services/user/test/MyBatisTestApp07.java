package ibatis.services.user.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.domain.User;

public class MyBatisTestApp07 {

	public static void main(String[] args) {
		try {

			SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
			
			System.out.println("==============SELECT ALL==============");
			List userList = sqlSession.selectList("userMapper07.selectUserList01");
			SqlSessionFactoryBean.printList(userList);
			
			System.out.println("==============INSERT==============");
			User newUser = new User("test5", "test5", "test5", 40, 8);
			sqlSession.insert("userMapper07.addUser01", newUser);

			System.out.println("==============INSERT RESULT(selectUser01)==============");
			Object result = sqlSession.selectOne("userMapper07.selectUser01", newUser);
			System.out.println(result.toString());
			
			System.out.println("==============INSERT RESULT(selectUser02)==============");
			result = sqlSession.selectOne("userMapper07.selectUser02", newUser);
			System.out.println(result.toString());
			
			System.out.println("==============INSERT RESULT(selectUserList01)==============");
			userList = sqlSession.selectList("userMapper07.selectUserList01");
			SqlSessionFactoryBean.printList(userList);
			
			System.out.println("==============DELETE==============");
			sqlSession.delete("userMapper07.deleteUser01", newUser);
			
			System.out.println("==============DELETE RESULT(selectUserList01)==============");
			userList = sqlSession.selectList("userMapper07.selectUserList01");
			SqlSessionFactoryBean.printList(userList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
