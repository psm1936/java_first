package kr.smhrd.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCheckController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 세션 로그아웃 하는 방법 -> 기존에 만들어진 세션 가져오기 !
		HttpSession session = request.getSession();
		session.invalidate(); // 만들어진 세션 끊기

		return null;
	}

}