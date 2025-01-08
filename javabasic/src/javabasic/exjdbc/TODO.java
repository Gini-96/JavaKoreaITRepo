package javabasic.exjdbc;

import java.io.Serializable;
import java.sql.Timestamp;

public class TODO implements Serializable{

	private static final long serialVersionUID = 7561009257743068633L;

	private int tdno;
	private Timestamp tddate;
	private String tdwriter;
	private String tdcontent;
	private String tdyn;
	
	public TODO() {
	}
	
	public TODO(int tdno, Timestamp tddate, String tdwriter, String tdcontent, String tdyn) {
		super();
		this.tdno = tdno;
		this.tddate = tddate;
		this.tdwriter = tdwriter;
		this.tdcontent = tdcontent;
		this.tdyn = tdyn;
	}

	public int getTdno() {
		return tdno;
	}

	public void setTdno(int tdno) {
		this.tdno = tdno;
	}

	public Timestamp getTddate() {
		return tddate;
	}

	public void setTddate(Timestamp tddate) {
		this.tddate = tddate;
	}

	public String getTdwriter() {
		return tdwriter;
	}

	public void setTdwriter(String tdwriter) {
		this.tdwriter = tdwriter;
	}

	public String getTdcontent() {
		return tdcontent;
	}

	public void setTdcontent(String tdcontent) {
		this.tdcontent = tdcontent;
	}

	public String getTdyn() {
		return tdyn;
	}

	public void setTdyn(String tdyn) {
		this.tdyn = tdyn;
	}

	@Override
	public String toString() {
		return "TODO [tdno=" + tdno + ", tddate=" + tddate + ", tdwriter=" + tdwriter + ", tdcontent=" + tdcontent
				+ ", tdyn=" + tdyn + "]";
	}
	
	
	
	
}
