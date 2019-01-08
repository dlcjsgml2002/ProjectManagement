package handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Project;
import mvc.CommandHandler;
import service.ProjectService;

public class ProjectListHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			ProjectService service = ProjectService.getInstance();
			List<Project> list = service.projectList();
			req.setAttribute("list", list);

			return "/WEB-INF/view/projectListForm.jsp";
		}
		return null;
	}
}
