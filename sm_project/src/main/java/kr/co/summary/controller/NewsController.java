package kr.co.summary.controller;

import javax.inject.Inject;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.summary.domain.NewsVO;
import kr.co.summary.service.NewsService;

@Controller
@RequestMapping("/news/*")
public class NewsController {
	
private static final org.slf4j.Logger logger =  LoggerFactory.getLogger(NewsController.class);
	
	@Inject
	NewsService service;
	
	// 게시판 글 작성 화면
	@RequestMapping(value = "/news/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
		
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/news/write", method = RequestMethod.POST)
	public String write(NewsVO newsVO) throws Exception{
		logger.info("write");
		
		service.newswrite(newsVO);
		
		return "redirect:/";
	}
	
	// 뉴스게시판 목록 조회
	// NewsController로 들어와서 URL은 /list으로 정하고
	// 오라클 -> 다오 -> 서비스 -> 컨트롤러로 가져온 데이터들을 jsp에 뿌려주는 작업을 해야한다!
	// model은 데이터를 담을 그릇이고 addAttribute("list",service.list())는 service.list()에 담긴 데이터를 "list"라는 이름으로 담을거다!
	// 라고생각하면된다
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		logger.info("list");
			
		model.addAttribute("list",service.list());
			
			
		return "news/list";
			
		}
	
	
}
