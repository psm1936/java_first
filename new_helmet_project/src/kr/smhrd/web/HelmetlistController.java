package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.smhrd.model.HelmetVO;
import kr.smhrd.model.LoginDAO;
import kr.smhrd.model.PointVO;

public class HelmetlistController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("접속성공?");
		LoginDAO dao = new LoginDAO();
		List<HelmetVO> list = dao.helmetlist();

		Gson g = new Gson();
		String hlist = g.toJson(list);
		System.out.println(hlist);
		PrintWriter out = response.getWriter();
		out.println(hlist);

		return null;

	}

}
