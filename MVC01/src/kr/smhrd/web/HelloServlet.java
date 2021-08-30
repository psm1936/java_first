package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;// WEB 에서 실행할수 있는 클래스가 됨

// Servlet(서블릿) : 100% 자바로 된 웹프로그래밍
@WebServlet("/hs.do")
public class HelloServlet extends HttpServlet {// 상속->web에서 실행가능
	                         //요청 객체                           응답 객체
	public  void service(HttpServletRequest req,HttpServletResponse res) 
		throws ServletException, IOException{
			
			// HelloServlet 이라는 문자열을 출력해보자
			req.setAttribute("name", "Thymeleaf");
			RequestDispatcher rd = req.getRequestDispatcher("leaf.html");
			rd.forward(req, res);
		
			/*
			 * PrintWriter out = res.getWriter();
			 * 
			 * out.println("<html>"); out.println("<body>"); out.println("HelloServlet");
			 * out.println("</body>"); out.println("</html>");
			 */
		
		}
		
	}

