package kr.co.summary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.summary.dao.NewsDAO;
import kr.co.summary.domain.NewsVO;


// 구현부인 NewsServiceImpl를 작성
@Service
public class NewsServiceImpl implements NewsService{

	@Inject
	private NewsDAO dao;

	@Override
	public void newswrite(NewsVO newsVO) throws Exception {
		dao.newswrite(newsVO);
	}

	//  여기서dao.list(); 는 dao에있는 list()함수를 호출해서 반환하겠다는 것
	@Override
	public List<NewsVO> list() throws Exception {
		
		return dao.list();
	}
}
