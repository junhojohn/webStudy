package ibatis.services.user.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.domain.User;

public class MyBatisTestApp08 {

	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
			
			System.out.println("==============SELECT ALL==============");
			List userList = sqlSession.selectList("userMapper08.selectUserList01");
			SqlSessionFactoryBean.printList(userList);
			
			System.out.println("==============INSERT==============");
			User newUser = new User("test08", "test08", "test08", 50, 9);
			sqlSession.insert("userMapper08.insertUser01", newUser);
			
			System.out.println("==============INSERT RESULT(selectUser01)==============");
			Object result = sqlSession.selectOne("userMapper08.selectUser01", newUser);
			System.out.println(result.toString());
			
			System.out.println("==============UPDATE==============");
			newUser.setName("modify08");
			newUser.setPwd("modify08");
			newUser.setAge(55);
			newUser.setGrade(10);
			sqlSession.update("userMapper08.updateUser01", newUser);
			
			System.out.println("==============UPDATE RESULT(selectUser02)==============");
			result = sqlSession.selectOne("userMapper08.selectUser02", newUser);
			System.out.println(result.toString());

			System.out.println("==============DELETE==============");
			sqlSession.delete("userMapper08.deleteUser01", newUser);

			System.out.println("==============SELECT ALL==============");
			userList = sqlSession.selectList("userMapper08.selectUserList01");
			SqlSessionFactoryBean.printList(userList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
