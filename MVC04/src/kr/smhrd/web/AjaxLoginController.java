package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.UserVO;

public class AjaxLoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		
		UserVO vo = new UserVO();
		vo.setUser_id(user_id);
		vo.setPassword(password);
		
		BoardDAOMybatis dao = new BoardDAOMybatis();
		UserVO userVO =dao.loginMember(vo);
		
		PrintWriter out = response.getWriter();
		
		if(userVO!=null) {
			out.print("YES");  //인증성공,   객체 바인딩: 로그인에 성공했다는 사실을 모든 웹페이지가 공유할수있도록 해야한다.
			
			HttpSession session = request.getSession();  //메모리에 세션을 만들어서 로그인에 성공했다는사실을 저장.
			session.setAttribute("userVO", userVO);      //userVO를 바인딩.
			//request.setAttribute("userVO", userVO);      // 이렇게 이름이같을때.   
		}else {
			out.print("NO");   //인증실패
		}
		
		return null;
	}

}
