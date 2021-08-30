package kr.smhrd.web;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.smhrd.domain.BoardVO;
import kr.smhrd.domain.SearchVO;
import kr.smhrd.mapper.BoardMapper;

// POJO
@Controller
public class BoardController { // new BoardController(); -> Spring Container(DI)
	
	//@Autowired // DI
	@Inject
	// @Resource("boardMapper")
	private BoardMapper boardMapper;
	// 게시판 리스트를 가져오는 동작
	// HandlerMapping 을 한다.
	
	@RequestMapping("/boardList.do")
	public void boardList(Model model) {  // void면 위의url:boardList.do와 boardList.jsp의 이름이 같기에 보내준다.
		
		List<BoardVO> list = boardMapper.boardList();
		model.addAttribute("list", list);		
		//request.setAttribute("list", list);  // 객체 바인딩 -> ModelAndView -> Model(*)
				
		//return "boardList";  // --> ViewResolvser --> /WEB-INF/views/boardList.jsp
	}
	
	@RequestMapping("/boardListAjax.do")
	public @ResponseBody List<BoardVO> boardListAjax() {
		List<BoardVO> list = boardMapper.boardListAjax(); //게시판 전체리스트 가져오기
		return list; //객체를 리턴  ---{JSON API}--->String 변환 -->응답
	}
	
	@RequestMapping("/boardForm.do")
	public void boardForm() {   
		//return "boardForm"; // boardForm.jsp
	}
	
	@RequestMapping("/boardInsert.do")
	public String boardInsert(BoardVO vo) { // 파라미터 수집(자동) ->new boardvo
		boardMapper.boardInsert(vo);
		return "redirect:/boardList.do";		
	}
	
	@RequestMapping("/boardContent.do")
	public void boardContent(int idx, Model model) { // 파라미터 수집(자동) ->new boardvo		
		
		BoardVO vo = boardMapper.boardContent(idx);
		model.addAttribute("vo", vo);
		
		//return "boardContent"; // boardContent.jsp		
	}
	
	@RequestMapping("/boardDelete.do")
	public String boardDelete(int idx) { // 파라미터 수집(자동) ->new boardvo	
		
		boardMapper.boardDelete(idx);		
		return "redirect:/boardList.do"; 
	}
	
	@RequestMapping("/boardDeleteAjax.do")
	public @ResponseBody int boardDeleteAjax(int idx) { // 파라미터 수집(자동) ->new boardvo	
		int cnt=boardMapper.boardDeleteAjax(idx);		
		return cnt; 
	}
	
//	@RequestMapping("/boardDeleteAjax.do")
//	public @ResponseBody int boardDeleteAjax(@RequestParam("idx") int idx) { // 파라미터 수집(자동) ->new boardvo	
//		int cnt=boardMapper.boardDeleteAjax(idx);		
//		return cnt; 
//	}
	
	
	@RequestMapping("/boardUpdate.do")
	public String boardUpdate(BoardVO vo) {
		boardMapper.boardUpdate(vo);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("/boardSearch.do")
	public String boardSearch(SearchVO vo, Model model) {
		List<BoardVO> list = boardMapper.boardSearch(vo);
		model.addAttribute("list", list);
		return "boardList";
	}
	
	
	
}
