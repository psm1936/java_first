package kr.smhrd.frontcontroller;

import java.util.HashMap;

import kr.smhrd.web.AjaxBoardDeleteController;
import kr.smhrd.web.AjaxBoardListController;
import kr.smhrd.web.AjaxBoardRegisterController;
import kr.smhrd.web.AjaxBoardUpdateController;
import kr.smhrd.web.AjaxBoardcontentController;
import kr.smhrd.web.AjaxLoginController;
import kr.smhrd.web.AjaxLogoutController;
import kr.smhrd.web.BoardDeleteController;
import kr.smhrd.web.BoardListController;
import kr.smhrd.web.BoardLoginController;
import kr.smhrd.web.BoardLogoutController;
import kr.smhrd.web.BoardRegisterController;
import kr.smhrd.web.BoardRegisterFormController;
import kr.smhrd.web.BoardUpdateController;
import kr.smhrd.web.BoardcontentController;
import kr.smhrd.web.CalcController;
import kr.smhrd.web.Controller;

public class HandlerMapping {
	// 핸들러매핑: 어떤일을 하는지 물어보는 사람.
	// 검색 빠르게 하기 위해서
	private HashMap<String,Controller> mappings;
	
	public HandlerMapping() {
		
		mappings = new HashMap<String, Controller>();
		// XML 설정파일로 보낼수 있다.
		mappings.put("/list.do", new BoardListController());
		mappings.put("/ajaxlist.do", new AjaxBoardListController());
		mappings.put("/register.do", new BoardRegisterController());
		mappings.put("/ajaxregister.do", new AjaxBoardRegisterController());		
		mappings.put("/registerForm.do", new BoardRegisterFormController());
		mappings.put("/ajaxupdate.do", new AjaxBoardUpdateController());
		mappings.put("/update.do", new BoardUpdateController());
		mappings.put("/content.do", new BoardcontentController());
		mappings.put("/ajaxcontent.do", new AjaxBoardcontentController());		
		mappings.put("/delete.do", new BoardDeleteController());
		mappings.put("/ajaxdelete.do", new AjaxBoardDeleteController());
		mappings.put("/calc.do", new CalcController());
		mappings.put("/ajaxlogin.do", new AjaxLoginController());
		mappings.put("/ajaxlogout.do", new AjaxLogoutController());
		
		mappings.put("/login.do", new BoardLoginController());
		mappings.put("/logout.do", new BoardLogoutController());
	}
	public Controller getController(String command) {
		return mappings.get(command);  // command 입력받아 핸들러매핑에서 찾고 컨트롤러에 전해준다.
	}
	
	
		
	/*// HandlerMapping (핸들러 매핑)
			if (command.equals("/list.do")) {
				controller = new BoardListController();				
			} else if (command.equals("/register.do")) {
				controller = new BoardRegisterController();					
			} else if (command.equals("/registerForm.do")) {
				controller = new BoardRegisterFormController();			
			} else if (command.equals("/update.do")) {
				controller = new BoardUpdateController();	
			} else if (command.equals("/content.do")) {
				controller = new BoardcontentController();	
			} else if (command.equals("/delete.do")) {
				controller = new BoardDeleteController();	
		*/
	
}
