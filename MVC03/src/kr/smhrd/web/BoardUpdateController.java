package kr.smhrd.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;



public class BoardUpdateController implements Controller {
	
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		// 파라메터 수집(VO)
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		int idx =Integer.parseInt(req.getParameter("idx"));

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setIdx(idx);
		String view = null;
				
		BoardDAO dao = new BoardDAO();
		try {
			int cnt = dao.boardUpdate(vo);
			if(cnt>0) {
				//res.sendRedirect("list.do");
				view = "redirect:/list.do";
			}else {
				throw new ServletException("error");
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return view;
		
	}

}
