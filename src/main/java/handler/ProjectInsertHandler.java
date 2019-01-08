package handler;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.CommandHandler;
import service.ProjectService;

public class ProjectInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/projectInsertForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String project_name = req.getParameter("name");
			String project_content = req.getParameter("content");
			String start_date = req.getParameter("start");
			String end_date = req.getParameter("end");
			String project_progress = req.getParameter("progress");

			ProjectService service = ProjectService.getInstance();
			int error = service.insertProject(project_name, project_content, sdf.parse(start_date), sdf.parse(end_date),
					project_progress);

			if (error < 0) {
				System.out.println("error : " + error);
			}

			return "/WEB-INF/view/projectInsertSuccess.jsp";
		}
		return null;
	}
}
