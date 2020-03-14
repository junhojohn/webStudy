package ibatis.services.user.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.service.domain.User;

public class MyBatisTestApp05 {

	public static void main(String[] args) {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("sql/mybatis-config01.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			System.out.println("===============INSERT===============");
			User user = new User("test3", "test3", "test3", 27, 4);
			sqlSession.insert("userMapper05.addUser", user);

			System.out.println("===============INSERTED USER by selectUser01===============");
			Object result01 = sqlSession.selectOne("userMapper05.selectUser01", user.getId());
			if(result01 instanceof User) {
				System.out.println(result01.toString());
			}
			
			System.out.println("===============INSERTED USER by selectUser02===============");
			Object result02 = sqlSession.selectOne("userMapper05.selectUser02", user.getId());
			if(result02 instanceof User) {
				System.out.println(result02.toString());
			}
			
			System.out.println("===============INSERT RESULT===============");
			List userList = sqlSession.selectList("userMapper05.selectUserList");
			for(Object userItem : userList) {
				System.out.println(userItem.toString());
			}
			
			System.out.println("===============DELETE===============");
			sqlSession.delete("userMapper05.deleteUser", user.getId());
			
			System.out.println("===============DELETE RESULT===============");
			userList = sqlSession.selectList("userMapper05.selectUserList");
			for(Object userItem : userList) {
				System.out.println(userItem.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
