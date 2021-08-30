package kr.smhrd.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.LoginDAO;
import kr.smhrd.web.Controller;

@WebServlet("*.go")
public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 클라이언트가 어떤 요청을 했는지 알아보는 것
		// http://127.0.0.1:8081/MVC02/list.do
		request.setCharacterEncoding("utf-8");

		// requrl = 주소 전체
		String requrl = request.getRequestURI();
		System.out.println(requrl);

		// cpath = MVC02
		String cpath = request.getContextPath();
		System.out.println(cpath);

		// command = requrl의 cpath까지 자르는거 !
		// 결론은 list.do만 남음 !
		String command = requrl.substring(cpath.length());
		System.out.println(command);

		// 2.요청에 따른 분기작업(if~else if~)
		LoginDAO dao = new LoginDAO();

		Controller controller = null;
		String view = null;

		HandlerMapping mappings = new HandlerMapping();
		controller = mappings.getController(command);

		view = controller.requestHandler(request, response);

		if (view != null) {
			if (view.indexOf("redirect:/") != -1) {
				response.sendRedirect(view.split(":/")[1]);
			} else { 
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeUrl(view));
				rd.forward(request, response);
			}
		}
	}

}
