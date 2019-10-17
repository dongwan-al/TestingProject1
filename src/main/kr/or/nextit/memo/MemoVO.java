package kr.or.nextit.memo;

import java.sql.Date;

public class MemoVO {
	long memo_id;
	String memo_contents;
	Date memo_create;
	Date memo_modify;
	
	
	public MemoVO() {
		
	}
	
	public MemoVO(long memo_id, String memo_contents, Date memo_create, Date memo_modify) {
		super();
		this.memo_id = memo_id;
		this.memo_contents = memo_contents;
		this.memo_create = memo_create;
		this.memo_modify = memo_modify;
	}




	public long getMemo_id() {
		return memo_id;
	}

	public void setMemo_id(long memo_id) {
		this.memo_id = memo_id;
	}

	public String getMemo_contents() {
		return memo_contents;
	}

	public void setMemo_contents(String memo_contents) {
		this.memo_contents = memo_contents;
	}

	public Date getMemo_create() {
		return memo_create;
	}

	public void setMemo_create(Date memo_create) {
		this.memo_create = memo_create;
	}

	public Date getMemo_modify() {
		return memo_modify;
	}

	public void setMemo_modify(Date memo_modify) {
		this.memo_modify = memo_modify;
	}

	@Override
	public String toString() {
		return "MemoVO [memo_id=" + memo_id + ", memo_contents=" + memo_contents + ", memo_create=" + memo_create
				+ ", memo_modify=" + memo_modify + "]";
	}



	
	
}
	
