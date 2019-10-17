package kr.or.nextit;
//bean, dto, 
public class MemberVO {
	private String memId;
	private String memName;
	private String memPass;
	private String memHp;
	private String memMail;
	private String memreg1;
	private String memreg2;
	private String membir;
	private String memzip;
	private String memadd1;
	private String memadd2;
	private String memHometel;
	private String memComtel;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemHp() {
		return memHp;
	}
	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemreg1() {
		return memreg1;
	}
	public void setMemreg1(String memreg1) {
		this.memreg1 = memreg1;
	}
	public String getMemreg2() {
		return memreg2;
	}
	public void setMemreg2(String memreg2) {
		this.memreg2 = memreg2;
	}
	public String getMembir() {
		return membir;
	}
	public void setMembir(String membir) {
		this.membir = membir;
	}
	public String getMemzip() {
		return memzip;
	}
	public void setMemzip(String memzip) {
		this.memzip = memzip;
	}
	public String getMemadd1() {
		return memadd1;
	}
	public void setMemadd1(String memadd1) {
		this.memadd1 = memadd1;
	}
	public String getMemadd2() {
		return memadd2;
	}
	public void setMemadd2(String memadd2) {
		this.memadd2 = memadd2;
	}
	public String getMemHometel() {
		return memHometel;
	}
	public void setMemHometel(String memHometel) {
		this.memHometel = memHometel;
	}
	public String getMemComtel() {
		return memComtel;
	}
	public void setMemComtel(String memComtel) {
		this.memComtel = memComtel;
	}
	
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memName=" + memName + ", memPass=" + memPass + ", memHp=" + memHp
				+ ", memMail=" + memMail + ", memreg1=" + memreg1 + ", memreg2=" + memreg2 + ", membir=" + membir
				+ ", memzip=" + memzip + ", memadd1=" + memadd1 + ", memadd2=" + memadd2 + ", memHometel=" + memHometel
				+ ", memComtel=" + memComtel + "]";
	}
	public MemberVO(String memId, String memName, String memHp, String memMail) {
		this.memId = memId;
		this.memName = memName;
		this.memHp = memHp;
		this.memMail = memMail;
	}
	public MemberVO() {
	}

	
}
