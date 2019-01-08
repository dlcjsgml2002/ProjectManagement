package dao;

import java.sql.SQLException;
import java.util.List;

import model.Project;

public interface ProjectDao {
	public int insert(Project project) throws SQLException;

	public List<Project> select() throws SQLException;

	public Project selectByNo(int serial_number) throws SQLException;

	public int delete(int serial_number) throws SQLException;

	public int update(Project project) throws SQLException;

	public int selectLastNo() throws SQLException;
}
