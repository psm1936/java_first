package kr.smhrd.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.util.BoardDAO;


@WebServlet("/delete.do")
public class BoardDeleteController extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx =Integer.parseInt(request.getParameter("idx"));
		BoardDAO dao = new BoardDAO();
		try {
			int cnt = dao.boardDelete(idx);
			// redirect
			if(cnt > 0) {
				response.sendRedirect("list.do");
			}else {
				throw new ServletException("error"); //was(Tomcat)
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
