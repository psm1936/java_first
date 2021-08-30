package kr.smhrd.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;

import kr.smhrd.web.Controller;

@WebServlet("*.do")

// FrontController 패턴 
public class BoardFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 1. 클라이언트가 어떤 요청을 했는지 알아보는것
		// http://127.0.0.1:8081/MVC02/list.do
		String reqUrl = request.getRequestURI();
		System.out.println(reqUrl);
		String cpath = request.getContextPath();
		System.out.println(cpath);

		// 섭스트링으로 가고자 하는곳을 알아낼수 있다.
		String command = reqUrl.substring(cpath.length());
		System.out.println(command);

		// 2. 요청에 따른 분기작업 (if~else if~)
		BoardDAO dao = new BoardDAO();
		Controller controller= null;
		String view = null;
		
		// HandlerMapping (핸들러 매핑)
		HandlerMapping mappings = new HandlerMapping();
		controller = mappings.getController(command);
		// -----------------------------------------------
		view = controller.requestHandler(request, response);
		if(view!=null) {
			if(view.indexOf("redirect:/")!=-1) {
				response.sendRedirect(view.split(":/")[1]); //  redirect:/list.do
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeUrl(view)); // boardList
				rd.forward(request, response);			
			}							
			
		}
		
	}

}
