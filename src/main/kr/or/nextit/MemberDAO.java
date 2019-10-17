package kr.or.nextit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	// 게시판 구조 select 2개 , insert, update, delete
	public List<MemberVO> selectMemberList() throws Exception {
		// 1. DB 드라이버 로딩
		// 2. DB 연결
		// 3. 쿼리 만들기
		// 4. 쿼리 전송
		// 5. 결과 받기
		// 6. 자원 반납
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement statement = connection.prepareStatement("select * from member");
		ResultSet resultSet = statement.executeQuery();
		List<MemberVO> list = new ArrayList<MemberVO>();
		while (resultSet.next()) {
			String memId = resultSet.getString("mem_id");
			String memName = resultSet.getString("mem_name");
			String memHp = resultSet.getString("mem_hp");
			String memMail = resultSet.getString("mem_mail");
			list.add(new MemberVO(memId, memName,memHp,memMail));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;		
	}
	//위 클래스에 있는 목록중 하나
	public MemberVO selectMember(String id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement statement = connection.prepareStatement("select * from member where mem_id = ?");
		statement.setString(1,id);
		ResultSet resultSet = statement.executeQuery();
		MemberVO vo = null;
		while (resultSet.next()) {
			String memId = resultSet.getString("mem_id");
			String memName = resultSet.getString("mem_name");
			String memHp = resultSet.getString("mem_hp");
			String memMail = resultSet.getString("mem_mail");
			vo = new MemberVO(memId , memName , memHp, memMail);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;

	}
	//insert,update,delete 는 resultSet 필요없음
	public void insertMember(MemberVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		String sql =  "insert into member (MEM_ID ,MEM_NAME,MEM_PASS,MEM_MAIL,MEM_HP,MEM_ADD1,MEM_ADD2,MEM_BIR,MEM_ZIP,MEM_REGNO1,MEM_REGNO2, MEM_COMTEL,MEM_HOMETEL) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql );
		statement.setString(1,vo.getMemId());
		statement.setString(2,vo.getMemName());
		statement.setString(3,vo.getMemPass());
		statement.setString(4,vo.getMemMail());
		statement.setString(5,vo.getMemHp());
		statement.setString(6,vo.getMemadd1());
		statement.setString(7,vo.getMemadd2());
		statement.setString(8,vo.getMembir());
		statement.setString(9,vo.getMemzip());
		statement.setString(10,vo.getMemreg1());
		statement.setString(11,vo.getMemreg2());
		statement.setString(12,vo.getMemComtel());
		statement.setString(13,vo.getMemHometel());
		statement.executeUpdate();

		statement.close();
		connection.close();

	}
	public void updateMember(MemberVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement statement = connection.prepareStatement("update member set=? where =? ");
		statement.setString(1,vo.getMemId());
		statement.setString(2,vo.getMemName());
		statement.setString(3,vo.getMemPass());
		statement.setString(4,vo.getMemMail());
		statement.setString(5,vo.getMemHp());
		statement.setString(6,vo.getMemadd1());
		statement.setString(7,vo.getMemadd2());
		statement.setString(8,vo.getMembir());
		statement.setString(9,vo.getMemzip());
		statement.setString(10,vo.getMemreg1());
		statement.setString(11,vo.getMemreg2());
		statement.setString(12,vo.getMemComtel());
		statement.setString(13,vo.getMemHometel());
		statement.executeUpdate();

		statement.close();
		connection.close();

		
	}
	public void deleteMember(String id) {
	
	}
}	
