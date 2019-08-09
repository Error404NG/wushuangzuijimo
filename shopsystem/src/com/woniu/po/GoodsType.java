package com.woniu.po;

public class GoodsType {
	
	private Integer gtid;
	private String gtname;
	private String gtpic;
	private String gtdescript;
	private Integer gtforetypeno;
	private	Integer softdelete;
	/**
	 * @return the gtid
	 */
	public Integer getGtid() {
		return gtid;
	}
	/**
	 * @param gtid the gtid to set
	 */
	public void setGtid(Integer gtid) {
		this.gtid = gtid;
	}
	/**
	 * @return the gtname
	 */
	public String getGtname() {
		return gtname;
	}
	/**
	 * @param gtname the gtname to set
	 */
	public void setGtname(String gtname) {
		this.gtname = gtname;
	}
	/**
	 * @return the gtpic
	 */
	public String getGtpic() {
		return gtpic;
	}
	/**
	 * @param gtpic the gtpic to set
	 */
	public void setGtpic(String gtpic) {
		this.gtpic = gtpic;
	}
	/**
	 * @return the gtdescript
	 */
	public String getGtdescript() {
		return gtdescript;
	}
	/**
	 * @param gtdescript the gtdescript to set
	 */
	public void setGtdescript(String gtdescript) {
		this.gtdescript = gtdescript;
	}
	/**
	 * @return the gtforetypeno
	 */
	public Integer getGtforetypeno() {
		return gtforetypeno;
	}
	/**
	 * @param gtforetypeno the gtforetypeno to set
	 */
	public void setGtforetypeno(Integer gtforetypeno) {
		this.gtforetypeno = gtforetypeno;
	}
	/**
	 * @return the softdelete
	 */
	public Integer getSoftdelete() {
		return softdelete;
	}
	/**
	 * @param softdelete the softdelete to set
	 */
	public void setSoftdelete(Integer softdelete) {
		this.softdelete = softdelete;
	}
	public GoodsType(Integer gtid, String gtname, String gtpic, String gtdescript, Integer gtforetypeno,
			Integer softdelete) {
		super();
		this.gtid = gtid;
		this.gtname = gtname;
		this.gtpic = gtpic;
		this.gtdescript = gtdescript;
		this.gtforetypeno = gtforetypeno;
		this.softdelete = softdelete;
	}
	public GoodsType() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GoodsType [gtid=" + gtid + ", gtname=" + gtname + ", gtpic=" + gtpic + ", gtdescript=" + gtdescript
				+ ", gtforetypeno=" + gtforetypeno + ", softdelete=" + softdelete + "]";
	}
	
	
	
	

}
