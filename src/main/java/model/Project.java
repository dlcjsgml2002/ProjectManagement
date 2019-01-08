package model;

import java.util.Date;

public class Project {
	private int serial_number;
	private String project_name;
	private String project_content;
	private Date start_date;
	private Date end_date;
	private String project_progress;

	public Project() {}

	public Project(int serial_number, String project_name, String project_content, Date start_date, Date end_date,
			String project_progress) {
		this.serial_number = serial_number;
		this.project_name = project_name;
		this.project_content = project_content;
		this.start_date = start_date;
		this.end_date = end_date;
		this.project_progress = project_progress;
	}

	public int getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_content() {
		return project_content;
	}

	public void setProject_content(String project_content) {
		this.project_content = project_content;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getProject_progress() {
		return project_progress;
	}

	public void setProject_progress(String project_progress) {
		this.project_progress = project_progress;
	}

	@Override
	public String toString() {
		return String.format(
				"Project [serial_number=%s, project_name=%s, project_content=%s, start_date=%s, end_date=%s, project_progress=%s]",
				serial_number, project_name, project_content, start_date, end_date, project_progress);
	}
}
