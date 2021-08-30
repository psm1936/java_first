package kr.smhrd.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAOMybatis {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {// 초기화 블럭
		try {
			String resource = "kr/smhrd/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}//static
	//
	public List<BoardVO> boardList(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		 List<BoardVO> list = sqlSession.selectList("boardList");
		 sqlSession.close(); // 반납
		 return list;
	}
	public int boardInsert(BoardVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("boardInsert", vo);
		sqlSession.commit(); //완료
		sqlSession.close();  //반납
		return cnt;
	}
	public int boardDelete(int idx) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.delete("boardDelete", idx);
		sqlSession.commit(); //완료
		sqlSession.close();  //반납
		return cnt;
	}
	public BoardVO boardContent(int idx) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardVO vo = sqlSession.selectOne("boardContent", idx);
		sqlSession.close(); //반납
		return vo;
	}
	public int boardUpdate(BoardVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.update("boardUpdate", vo);
		sqlSession.commit(); //완료
		sqlSession.close(); //반납
		return cnt;
	}
	
	public UserVO loginMember(UserVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		vo = sqlSession.selectOne("loginMember",vo);
		sqlSession.close();
		
		return vo;
		
	}
	
	
}
