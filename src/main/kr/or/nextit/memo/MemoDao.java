package kr.or.nextit.memo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class MemoDao {
	public List<MemoVO> selectMemoList() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM MEMO");
		ResultSet resultSet = statement.executeQuery();
		List<MemoVO> list = new ArrayList<MemoVO>();
		while (resultSet.next()) {
			long memoId = resultSet.getLong("memo_id");
			String memocon = resultSet.getString("memo_contents");
			Date memocre = resultSet.getDate("memo_create_date");
			Date memomod = resultSet.getDate("memo_modify_date");
			list.add(new MemoVO(memoId,memocon,memocre,memomod));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;		

	}
	public MemoVO selectMemo(int id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM MEMO WHERE MEMO_ID = ?");
		statement.setInt(1, id); // ? 의 값
		ResultSet resultSet = statement.executeQuery();
		MemoVO vo = new MemoVO();
		while (resultSet.next()) {
			long memoId = resultSet.getLong("memo_id");
			String memocon = resultSet.getString("memo_contents");
			Date memocre = resultSet.getDate("memo_create_date");
			Date memomod = resultSet.getDate("memo_modify_date");
			vo = new MemoVO(memoId,memocon,memocre,memomod);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;		

	}
	public int insertMemo(MemoVO vo) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement statement = connection.prepareStatement("INSERT INTO MEMO(MEMO_ID, MEMO_CONTENTS) VALUES (SEQ_MEMO.nextval, ?)");
		statement.setString(1, vo.getMemo_contents());
		int update = statement.executeUpdate();
		statement.close();
		connection.close();
		return update;		

	}
	public int updateMemo(MemoVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement statement = connection.prepareStatement("UPDATE MEM SET MEMO_CONTENTS = ? , MEMO_MODIFY_DATE = SYSDATE WHERE MEMO_ID =? ");
		statement.setString(1, vo.getMemo_contents());
		statement.setLong(2, vo.getMemo_id());
		int update = statement.executeUpdate();
		statement.close();
		connection.close();
	

		return update;
	}
	public int deleteMemo(int id) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement statement = connection.prepareStatement("delete from memo WHERE MEMO_ID =? ");
		statement.setLong(1, id);
	
		int update = statement.executeUpdate();
		statement.close();
		connection.close();
	

		return update;
	}
}
