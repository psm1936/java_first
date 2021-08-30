package kr.co.summary.dao;

import java.util.List;

import kr.co.summary.domain.NewsVO;

public interface NewsDAO {

	// 뉴스작성
	public void newswrite(NewsVO newsVO) throws Exception;
	
	// 뉴스 목록조회
	// newsMapper와 연결되는 코드
	public List<NewsVO> list() throws Exception;
}
