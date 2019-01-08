package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.CommandHandler;
import service.ProjectService;

public class ProjectDeleteHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			String serial_number = req.getParameter("no");
			int no = Integer.parseInt(serial_number);
			ProjectService service = ProjectService.getInstance();
			service.deleteProject(no);
			return "/WEB-INF/view/projectListForm.jsp";
		}
		return null;
	}
}
