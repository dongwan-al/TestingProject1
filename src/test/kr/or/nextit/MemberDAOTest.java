package kr.or.nextit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.sql.SQLDataException;
import java.util.List;

import org.junit.Test;

public class MemberDAOTest {

	@Test
	public void testSelectMemberList() throws Exception {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.selectMemberList();
//		assertTrue(list.size() == 24);
//		assertTrue(list.get(7).getMemId().equals("h001"));
	}

	@Test
	public void testSelectMember() throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.selectMember("p001");
//		assertTrue(vo.getMemName().equals("오성순"));
		assertThat(vo.getMemName(), is(not("유성순")));
		
	}

	@Test(expected = SQLDataException.class)
	public void testInsertMember() throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMemId("qwer");
		vo.setMemPass("qwer");
		vo.setMemName("홍길동");
		vo.setMemadd1("대전광역시");
		vo.setMemadd2("넥스트아이티");
		vo.setMemreg1("999999");
		vo.setMemreg2("1234567");
		vo.setMemHometel("043-1234-1234");
		vo.setMemComtel("042-789-1234");
		vo.setMemzip("ddd");
		vo.setMemMail("mem@naver.com");
		int size = dao.selectMemberList().size();
		dao.insertMember(vo);
		assertThat(dao.selectMemberList().size(), is(size +1));
		dao.insertMember(vo);
		
	}

	@Test
	public void testUpdateMember() {

	}

	@Test
	public void testDeleteMember() {

	}

}
