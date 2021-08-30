package kr.smhrd.frontcontroller;

import java.util.HashMap;

import kr.smhrd.web.BoardDeleteController;
import kr.smhrd.web.BoardListController;
import kr.smhrd.web.BoardRegisterController;
import kr.smhrd.web.BoardRegisterFormController;
import kr.smhrd.web.BoardUpdateController;
import kr.smhrd.web.BoardcontentController;
import kr.smhrd.web.Controller;

public class HandlerMapping {
	// 핸들러매핑: 어떤일을 하는지 물어보는 사람.
	// 검색 빠르게 하기 위해서
	private HashMap<String,Controller> mappings;
	
	public HandlerMapping() {
		
		mappings = new HashMap<String, Controller>();
		// XML 설정파일로 보낼수 있다.
		mappings.put("/list.do", new BoardListController());
		mappings.put("/register.do", new BoardRegisterController());
		mappings.put("/registerForm.do", new BoardRegisterFormController());
		mappings.put("/update.do", new BoardUpdateController());
		mappings.put("/content.do", new BoardcontentController());
		mappings.put("/delete.do", new BoardDeleteController());
		// 새로운 요청을 추가하고->POJO를 새롭게 만든다.
		// ex)mappings.put("/login.do", new BoardLoginController());
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
