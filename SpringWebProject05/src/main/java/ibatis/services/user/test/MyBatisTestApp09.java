package ibatis.services.user.test;

import java.util.ArrayList;

import mybatis.service.domain.Search;

import org.apache.ibatis.session.SqlSession;

/*
 * FileName : IBatisTestApp09.java
  */
public class MyBatisTestApp09 {
	
	///main method
	public static void main(String[] args) throws Exception{
	
		//==> SqlSessionFactoryBean.getSqlSession()을 이용 SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("\n");

		System.out.println("\n==================================\n");
		//==> Test 용 Search instance 생성 
		Search search = new Search();
		
		//1. userMapper09.selectUser02 Test 
		ArrayList<String> arrayList = new ArrayList<String>();
		search.setIdList( arrayList );
		System.out.println(":: 1. selectUserList02(SELECT)  ? ");
		SqlSessionFactoryBean.printList( sqlSession.selectList("userMapper09.selectUser02",search) );
		
		//2. userMapper09.selectUser04 Test 
		arrayList.add("user01");
		arrayList.add("user02");
		System.out.println(":: 2. selectUserList04(SELECT)  ? ");
		SqlSessionFactoryBean.printList( sqlSession.selectList("userMapper09.selectUser04",search) );
		
		//3. userMapper09.selectUser01 Test
		String [] userName = new String[2];
		search.setNameList(userName);
		System.out.println(":: 3. selectUser01(SELECT)  ? ");
		SqlSessionFactoryBean.printList( sqlSession.selectList("userMapper09.selectUser01",search) );
		
		//4. userMapper09.getUserList03 Test
		userName[ 0 ] = "홍길동iba";
		userName[ 1 ] = "주몽";
		search.setNameList(userName);
		System.out.println(":: 4. selectUser03(SELECT)  ? ");
		SqlSessionFactoryBean.printList( sqlSession.selectList("userMapper09.selectUser03",search) );
		
		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
		
	}//end of main
}//end of class