package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Project;
import mvc.CommandHandler;
import service.ProjectService;

public class ProjectReadHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			String serial_number = req.getParameter("no");
			int no = Integer.parseInt(serial_number);
			ProjectService service = ProjectService.getInstance();
			Project project = service.selectProjectByNo(no);
			
			req.setAttribute("no", project.getSerial_number());
			req.setAttribute("name", project.getProject_name());
			req.setAttribute("content", project.getProject_content());
			req.setAttribute("start", project.getStart_date());
			req.setAttribute("end", project.getEnd_date());
			req.setAttribute("progress", project.getProject_progress());

			return "/WEB-INF/view/projectReadForm.jsp";
		}
		return null;
	}

}
