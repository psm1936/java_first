package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.BoardVO;

public class AjaxBoardRegisterController implements Controller{

   @Override
   public String requestHandler(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      response.setContentType("text/json;charset=euc-kr");// 프린트라이터 마임타입 (한글안깨지게)
      BoardDAOMybatis dao = new BoardDAOMybatis();
      String title = request.getParameter("title");
      String contents = request.getParameter("contents");
      String writer = request.getParameter("writer");
      BoardVO vo = new BoardVO(); //객체만들기
      vo.setTitle(title);
      vo.setContents(contents);
      vo.setWriter(writer);
      String view = null;
      int cnt = dao.boardInsert(vo);
      PrintWriter out = response.getWriter();
      out.println(cnt);
      
      return null;
   }

}