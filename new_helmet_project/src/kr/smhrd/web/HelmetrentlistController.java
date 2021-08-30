package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.smhrd.model.LoginDAO;
import kr.smhrd.model.RentVO;

public class HelmetrentlistController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("접속성공?");

		String memberid = request.getParameter("memberid");
		LoginDAO dao = new LoginDAO();
		List<RentVO> list = dao.rentlist(memberid);

		Gson g = new Gson();
		String plist = g.toJson(list);
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println(plist);

		return null;

	}
}
