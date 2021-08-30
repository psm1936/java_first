package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;


public class BoardRegisterController implements Controller {
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 요청객체에 한글을 인코딩처리(한글 안깨지개함.)
		req.setCharacterEncoding("utf-8");

		// 파라메터 수집(VO)
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String writer = req.getParameter("writer");

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setWriter(writer);
		String view = null;
		
		
		BoardDAO dao = new BoardDAO();
		try {
			int cnt = dao.boardInsert(vo);
			if (cnt>0) {
				// 저장성공후 -> 다시 리스트 페이지로 가기(/list.do)
				//res.sendRedirect("list.do");
				view ="redirect:/list.do";
			}else {
				throw new ServletException("error"); // 예외 처리
			}
		} catch (Exception e) {
			e.printStackTrace();
		} {
			
		}
		return view;
	}
}

		/*ArrayList<BoardVO> list = new ArrayList<BoardVO>();
	      list.add(vo);
	      list.add(vo);
	      list.add(vo);
		
		
		
		System.out.println(vo); // vo.toString() 안써줘도 생략이 가능

		// 받은 데이터를 클라이언트에 응답
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>제목</th>");
		out.println("<th>내용</th>");
		out.println("<th>작성자</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			out.println("<tr>");
			out.println("<td>"+vo.getTitle()+"</td>");
			out.println("<td>"+vo.getContents().replaceAll("\n", "<br>")+"</td>");
			out.println("<td>"+vo.getWriter()+"</td>");
			out.println("</tr>");
		}
		
		
		out.println("</tbody>");
		out.println("</table>");

	}
*/

