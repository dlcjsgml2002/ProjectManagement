package handler;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Project;
import mvc.CommandHandler;
import service.ProjectService;

public class ProjectUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			String serial_number = req.getParameter("no");
			int no = Integer.parseInt(serial_number);
			ProjectService service = ProjectService.getInstance();
			Project project = service.selectProjectByNo(no);
			req.setAttribute("project", project);

			return "/WEB-INF/view/projectUpdateForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String serial_number = req.getParameter("no");
			System.out.println(serial_number);
			int no = Integer.parseInt(serial_number);
			String project_name = req.getParameter("name");
			String project_content = req.getParameter("content");
			String start_date = req.getParameter("start");
			String end_date = req.getParameter("end");
			String project_progress = req.getParameter("progress");

			ProjectService service = ProjectService.getInstance();
			Project project = new Project();
			project.setSerial_number(no);
			project.setProject_name(project_name);
			project.setProject_content(project_content);
			project.setStart_date(sdf.parse(start_date));
			project.setEnd_date(sdf.parse(end_date));
			project.setProject_progress(project_progress);

			service.updateArticle(project);
			return "/WEB-INF/view/projectReadForm.jsp";
		}
		return null;
	}
}
