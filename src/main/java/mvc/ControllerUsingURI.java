package mvc;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerUsingURI extends HttpServlet {
	// command , class map
	private HashMap<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);

		try (FileReader fis = new FileReader(configFilePath)) {
			prop.load(fis);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next(); // 프로퍼티 키, /simple.do 프로퍼티
														// 키에 해당하는 값,
														// mvc.simple.SimpleHandler
			String handlerClassName = prop.getProperty(command);

			try {
				Class<?> handlerClass = Class.forName(handlerClassName); // 문자를
																			// 클래스화
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance(); // 클래스
																								// 생성
				commandHandlerMap.put(command, handlerInstance);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청 들어온 uri를 가지고 옴, /chapter16MVC/simple.do
		String command = request.getRequestURI();
		if (command.indexOf(request.getContextPath()) == 0) {
			// command 뽑기 /simple.do
			command = command.substring(request.getContextPath().length());
		}

		// simple.do에 해당하는 SimpleHandler 클래스 옴
		CommandHandler handler = commandHandlerMap.get(command);
		if (handler == null) { // 커맨드에 해당하는 클래스 없을 경우
			handler = new NullHandler();
		}

		String viewPage = null;
		try {
			viewPage = handler.process(request, response); // simpleForm.jsp
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		if (viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
