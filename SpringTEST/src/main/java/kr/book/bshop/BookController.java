package kr.book.bshop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.book.domain.BookVO;
import kr.book.mapper.BookMapper;

@Controller
public class BookController {
	
	@Inject
	private BookMapper bookMapper;	
	
	@RequestMapping("/bookListAjax.do")
	public @ResponseBody List<BookVO> bookListAjax() {
		List<BookVO> list = bookMapper.bookListAjax();
		return list; 
	}
	
	@RequestMapping("/bookList.do")
	public String bookList(Model model) {  // void면 위의url:boardList.do와 boardList.jsp의 이름이 같기에 보내준다.
		
		List<BookVO> list = bookMapper.bookList();
		model.addAttribute("list", list);
		return "bookList";
		
	}
	
	
}
