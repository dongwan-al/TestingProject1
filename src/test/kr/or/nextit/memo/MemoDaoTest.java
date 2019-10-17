package kr.or.nextit.memo;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Test;

public class MemoDaoTest {

	@Test
	public void test() throws Exception {
		MemoDao dao = new MemoDao();
		List<MemoVO> list = dao.selectMemoList();
		int size = list.size();
//		assertThat(list.size(), is(0));
		MemoVO vo = new MemoVO();
		vo.setMemo_contents("두번째 메모");
		dao.insertMemo(vo);
		List<MemoVO> list2 = dao.selectMemoList();
		
		assertThat(list2.size(), is(size + 1));
//		assertThat(vo, is(dao.selectMemo((int) vo.getMemo_id())));
	}
	
	@Test
	public void testUpdateMemo() throws Exception {
		MemoDao dao = new MemoDao();
		MemoVO vo = new MemoVO();
		vo.setMemo_id(2);
		vo.setMemo_contents("바뀐 데이터");
		dao.updateMemo(vo);
		//결과 테스트
		assertThat(dao.selectMemo((int) vo.getMemo_id()).getMemo_contents(), is("바뀐 데이터"));
	}
	
	@Test
	public void testdeleteMemo() throws Exception {
		MemoDao dao = new MemoDao();
		MemoVO vo = new MemoVO();
		vo.setMemo_id(0);
		vo.setMemo_contents(null);
		dao.deleteMemo(vo);
		assertThat(dao.deleteMemo((int) vo.getMemo_id()).get , is());
	}
	
}
