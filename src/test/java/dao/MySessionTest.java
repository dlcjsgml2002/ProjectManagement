package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import mvc.MySqlSessionFactory;

public class MySessionTest {

	@Test
	public void testSession() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
