package dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import model.Project;
import mvc.MySqlSessionFactory;

public class ProjectDaoTest {

	@Test
	public void testInsert() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao dao = session.getMapper(ProjectDao.class);
			Date now = new Date();

			Project project = new Project();
			project.setSerial_number(0);
			project.setProject_name("프로젝트 이름");
			project.setProject_content("프로젝트 내용");
			project.setStart_date(now);
			project.setEnd_date(now);
			project.setProject_progress("시작");
			dao.insert(project);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Test
	public void testUpdate() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao dao = session.getMapper(ProjectDao.class);
			Date now = new Date();

			Project project = new Project();
			project.setSerial_number(2);
			project.setProject_name("이름 프로젝트");
			project.setProject_content("내용 프로젝트");
			project.setStart_date(now);
			project.setEnd_date(now);
			project.setProject_progress("변경");
			dao.update(project);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Test
	public void testDelete() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao dao = session.getMapper(ProjectDao.class);

			dao.delete(3);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Test
	public void testList() {
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao dao = session.getMapper(ProjectDao.class);
			Project project = dao.selectByNo(6);
			System.out.println(project);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
