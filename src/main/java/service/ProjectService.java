package service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.ProjectDao;
import model.Project;
import mvc.MySqlSessionFactory;

public class ProjectService {
	private static ProjectService service = new ProjectService();

	public static ProjectService getInstance() {
		return service;
	}

	public int insertProject(String project_name, String project_content, Date start_date, Date end_date,
			String project_progress) {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao projectDao = session.getMapper(ProjectDao.class);
			Project project = new Project(0, project_name, project_content, start_date, end_date, project_progress);

			projectDao.insert(project);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	public Project selectProjectByNo(int serial_number) {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao projectDao = session.getMapper(ProjectDao.class);

			Project project = projectDao.selectByNo(serial_number);

			return project;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public void deleteProject(int serial_number) {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao projectDao = session.getMapper(ProjectDao.class);

			projectDao.delete(serial_number);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateArticle(Project project) throws SQLException {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao projectDao = session.getMapper(ProjectDao.class);

			projectDao.update(project);
			session.commit();
		} finally {
			session.close();
		}
	}

	public List<Project> projectList() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao dao = session.getMapper(ProjectDao.class);
			return dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
