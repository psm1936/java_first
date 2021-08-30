package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mysql.fabric.xmlrpc.base.Member;

import kr.smhrd.model.LoginDAO;
import kr.smhrd.model.LoginVO;

public class JoinController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberid = request.getParameter("memberid");// 파라메터값이 join 받아오는건지 아니면 sql문
		String membername = request.getParameter("membername");
		String memberage = request.getParameter("memberage");
		String password = request.getParameter("password");
		String memberphone = request.getParameter("memberphone");

		LoginVO vo = new LoginVO();
		vo.setMemberid(memberid);
		vo.setMembername(membername);
		vo.setMemberage(memberage);
		vo.setPassword(password);
		vo.setMemberphone(memberphone);
		String view = null;

		LoginDAO dao = new LoginDAO();
		LoginVO loginVO = dao.memberInsert(vo);
		// int cnt=dao.memberInsert(vo);
		PrintWriter out = response.getWriter();
		out.print(loginVO);
		if (loginVO != null) {
			out.print("YES");
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", loginVO);
		} else {
			out.print("NO");
		}
		// out.println(cnt);

		return null;

	}

}
