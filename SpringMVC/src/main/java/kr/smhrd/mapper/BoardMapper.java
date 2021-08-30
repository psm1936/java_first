package kr.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.smhrd.domain.BoardVO;
import kr.smhrd.domain.SearchVO;

@Mapper
public interface BoardMapper {
	// SQL -> X -> SQL MAPPER FILE(XML)
	
	public List<BoardVO> boardList(); 
	
	@Select("select*from tbl_board order by idx desc")
	public List<BoardVO> boardListAjax(); 
	public void boardInsert(BoardVO vo); // Insert
	
	@Select("select * from tbl_board where idx=#{idx}")
	public BoardVO boardContent(int idx); // select sql	

	public void boardDelete(int idx);
	public int boardDeleteAjax(int idx);
	
	@Update("Update tbl_board set title=#{title}, contents=#{contents} where idx=#{idx}")
	public void boardUpdate(BoardVO vo);
	
	public List<BoardVO> boardSearch(SearchVO vo);
	
}
