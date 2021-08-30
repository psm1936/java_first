package kr.smhrd.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registerForm.do")
public class BoardRegisterFormController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//글쓰기 화면으로 이동
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/boardForm.jsp");
		rd.forward(request, response);
	}

}
