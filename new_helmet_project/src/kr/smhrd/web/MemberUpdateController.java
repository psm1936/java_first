package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.smhrd.model.LoginDAO;
import kr.smhrd.model.LoginVO;

public class MemberUpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String memberid = request.getParameter("memberid");
		String password = request.getParameter("password");
		String membername = request.getParameter("membername");
		String memberage = request.getParameter("memberage");
		String memberphone = request.getParameter("memberphone");

		LoginVO vo = new LoginVO(); // 객체 만들기
		vo.setMemberid(memberid);
		System.out.println(memberid);
		vo.setPassword(password);
		vo.setMembername(membername);
		vo.setMemberage(memberage);
		vo.setMemberphone(memberphone);

		String view = null;

		LoginDAO dao = new LoginDAO();

		int cnt = dao.memberUpdate(vo);
		
		if (cnt != 0) {
			HttpSession session = request.getSession();
			LoginVO vo2 = (LoginVO) session.getAttribute("loginVO");
			vo2.setPassword(password);
			vo2.setMembername(membername);
			vo2.setMemberage(memberage);
			vo2.setMemberphone(memberphone);
			session.setAttribute("loginVO", vo2);
		} else {
			System.out.println("no");
		}
		PrintWriter out = response.getWriter();
		out.println(cnt); // $.ajax() -> 형식적으로 응답 : success

		return null;
	}

}
