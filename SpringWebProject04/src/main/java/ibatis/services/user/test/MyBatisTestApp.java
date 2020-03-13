package ibatis.services.user.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.service.domain.User;

public class MyBatisTestApp {

	public static void main(String[] args) {
		try {
			Reader reader = Resources.getResourceAsReader("sql/mybatis-config.xml");
			
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			List<User> userList = sqlSession.selectList("userMapper.selectUserList");
			sqlSession.close();
			
			for(User user : userList) {
				System.out.println(user.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
