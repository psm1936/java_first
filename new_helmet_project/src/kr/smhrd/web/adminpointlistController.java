package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.smhrd.model.LoginDAO;
import kr.smhrd.model.PointVO;

public class adminpointlistController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		LoginDAO dao = new LoginDAO();
		List<PointVO> list = dao.adminpointlist();

		Gson g = new Gson();
		String plist = g.toJson(list);
		System.out.println(plist);
		PrintWriter out = response.getWriter();
		out.println(plist);

		return null;
	}

}
