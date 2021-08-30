package kr.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.book.domain.BookVO;

@Mapper
public class BookMapper {

	public List<BookVO> bookListAjax(); 

	public List<BookVO> bookList(); 

}
