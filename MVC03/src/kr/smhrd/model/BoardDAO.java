package kr.smhrd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// JDBC -> X -> MyBatis Framework
public class BoardDAO {
	private PreparedStatement ps;
	private ResultSet rs;

	private static Connection getConnect() throws Exception {

		String URL = "jdbc:mysql://localhost:3306/mysql";
		String user = "root";
		String password = "12345";
		// MySQL Driver Loading(jar)
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, user, password);
		return conn;

	}

	// boardList()
	public List<BoardVO> boardList() throws Exception {
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = getConnect();
		String SQL = "select idx,title,count,contents,writer,DATE_FORMAT(indate,'%Y-%m-%d') AS indate from tbl_board;";
		ps = conn.prepareStatement(SQL);
		rs = ps.executeQuery();

		while (rs.next()) {
			int idx = rs.getInt("idx");
			String title = rs.getString("title");
			int count = rs.getInt("count");
			String contents = rs.getString("contents");
			String writer = rs.getString("writer");
			String indate = rs.getString("indate");
			BoardVO vo = new BoardVO();
			vo.setIdx(idx);
			vo.setTitle(title);
			vo.setContents(contents);
			vo.setCount(count);
			vo.setWriter(writer);
			vo.setIndate(indate); // Date -> String
			list.add(vo);

		}
		return list;
	}

	// boardInsert()
	public int boardInsert(BoardVO vo) throws Exception {
		Connection conn = getConnect();
		String SQL = "insert into tbl_board(title, contents, writer) values(?, ?, ?)";
		ps = conn.prepareStatement(SQL);
		ps.setString(1, vo.getTitle());
		ps.setString(2, vo.getContents());
		ps.setString(3, vo.getWriter());
		int cnt = ps.executeUpdate();
		return cnt;
	}

	// boardDelete()
	public int boardDelete(int idx) throws Exception {
		Connection conn = getConnect();
		String SQL = "delete from tbl_board where idx = ?";
		ps = conn.prepareStatement(SQL);
		ps.setInt(1, idx);
		int cnt = ps.executeUpdate();
		return cnt;
	}

	public BoardVO boardContent(int idx) throws Exception {
		Connection conn = getConnect();
		String SQL = "select idx,title,count, contents,writer,DATE_FORMAT(indate,'%Y-%m-%d') AS indate from tbl_board " + 
		" where idx=?";
		ps = conn.prepareStatement(SQL);
		ps.setInt(1, idx);
		rs = ps.executeQuery();
		BoardVO vo = null;
		if (rs.next()) {
			// vo에 묶는다.
			idx = rs.getInt("idx");
			String title = rs.getString("title");
			String contents = rs.getString("contents");
			String writer = rs.getString("writer");
			String indate = rs.getString("indate");
			int count = rs.getInt("count");			
			vo = new BoardVO();
			vo.setIdx(idx);
			vo.setTitle(title);
			vo.setContents(contents);
			vo.setWriter(writer);
			vo.setCount(count);
			vo.setIndate(indate);
		}
		return vo;

	}
	
	public int boardUpdate(BoardVO vo) throws Exception {
		
		Connection conn = getConnect();
		String SQL = "update tbl_board set title=?, contents =? where idx =?";
		ps= conn.prepareStatement(SQL);
		ps.setString(1, vo.getTitle());
		ps.setNString(2, vo.getContents());
		ps.setInt(3, vo.getIdx());
		int cnt = ps.executeUpdate();
		return cnt;
		
	}

}
/*
 * JDBC -> (JAVA+SQL) : 유지보수가 어렵다. (SQL문장 수정), 개발속도도 느리다. ->
 * (JAVA)<---분리--->(SQL:파일(메머파일-XML))
 * 
 * 
 * 
 * 
 */