package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.smhrd.model.LoginDAO;
import kr.smhrd.model.LoginVO;

public class LoginCheckController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberid = request.getParameter("memberid");
		String password = request.getParameter("password");

		LoginVO vo = new LoginVO();
		vo.setMemberid(memberid);
		vo.setPassword(password);

		LoginDAO dao = new LoginDAO();
		LoginVO loginVO = dao.loginMember(vo);

		PrintWriter out = response.getWriter();
		if (loginVO != null) {
			// 인증 성공 (1)
			System.out.println("yes");
			out.print("YES");
			// 객체 바인딩 : 로그인에 성공했다는 사실을 모든 웹페이지가 공유할 수 있도록 해야함
			// => 세션 바인딩
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", loginVO); // -> ${userVO}
		} else {
			// 인증 실패 (0)
			out.print("NO");
		}

		return null;
	}

}