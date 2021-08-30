package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.linker.JavaAdapterFactory;
import kr.smhrd.util.MyUtil;

// JaveEE API(rt.jar)
// JaveEE API(웹용 API)
@WebServlet("/Web.do")
public class HapController extends HttpServlet{
	// 오버라이딩
	public  void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		
		// 폼 파라메터 를 가져오기
		int su1 =Integer.parseInt(req.getParameter("su1"));
		int su2 =Integer.parseInt(req.getParameter("su2"));
		
		MyUtil my = new MyUtil();
		int sum = my.hab(su1,su2);
		
		//MIME(마임타입) - 응답의 경우
		// 이 content 어떤 타티이빚  에 알려줌
		res.setContentType("text/html;charset = euc-kr");
		// 요청한 클라이언트에   응답하기 
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border ='1'>");
		out.println("<tr>");
		out.println("<td>총합</td>");
		out.println("<td>"+sum+"</td>");			
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
