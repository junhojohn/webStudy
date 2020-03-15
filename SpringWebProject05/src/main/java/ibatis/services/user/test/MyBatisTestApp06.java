package ibatis.services.user.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.domain.User;

public class MyBatisTestApp06 {

	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();

			System.out.println("============INSERT============");
			User newUser = new User("test4", "test4", "test4", 30, 5);
			sqlSession.insert("userMapper06.addUser01", newUser);
			
			System.out.println("============INSERT RESULT1(selectUser01)============");
			Object result = sqlSession.selectOne("userMapper06.selectUser01", newUser);
			System.out.println(result.toString());
			
			System.out.println("============INSERT RESULT2(selectUserList01)============");
			List userList = sqlSession.selectList("userMapper06.selectUserList01", newUser);
			SqlSessionFactoryBean.printList(userList);
			
			System.out.println("============DELETE============");
			sqlSession.delete("userMapper06.deleteUser01", newUser);
			System.out.println("============DELETE RESULT(selectUserList02)============");
			userList = sqlSession.selectList("userMapper06.selectUserList02", newUser);
			SqlSessionFactoryBean.printList(userList);			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
