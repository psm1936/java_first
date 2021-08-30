package kr.smhrd.frontcontroller;

import java.util.HashMap;

import kr.smhrd.web.AjaxLoginController;
import kr.smhrd.web.AjaxLogoutController;
import kr.smhrd.web.Controller;


public class HandlerMapping {
   private HashMap<String, Controller> mappings;

   //XML 설정 파일
   public HandlerMapping() {//생성자 메서드
      mappings=new HashMap<String, Controller>();
      mappings.put("/ajaxlogin.do", new AjaxLoginController());
      mappings.put("/ajaxlogout.do", new AjaxLogoutController());
      //새로운 요청이 들어오면 이곳에 추가하고 -> POJO를 새롭게 만든다.
   }
   public Controller getController(String command) {
      return mappings.get(command);
   }
}
