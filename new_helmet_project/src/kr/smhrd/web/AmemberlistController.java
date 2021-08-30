package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.smhrd.model.LoginDAO;
import kr.smhrd.model.LoginVO;

public class AmemberlistController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("접속성공?");
		LoginDAO dao = new LoginDAO();
		List<LoginVO> list = dao.memberlist();
		
		

		Gson g = new Gson();
		String amlist = g.toJson(list);
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println(amlist);

		return null;
	}

}
