package com.woniu.po;

public class OrderItem {
	private Integer oiid;
	private Integer oid;
	private String gname;
	private Double gprice;
	private String gpic;
	private Integer oicount;
	private Integer softdelete;
	/**
	 * @return the oiid
	 */
	public Integer getOiid() {
		return oiid;
	}	
	/**
	 * @param oiid the oiid to set
	 */
	public void setOiid(Integer oiid) {
		this.oiid = oiid;
	}
	/**
	 * @return the oid
	 */
	public Integer getOid() {
		return oid;
	}
	/**
	 * @param oid the oid to set
	 */
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	/**
	 * @return the gname
	 */
	public String getGname() {
		return gname;
	}
	/**
	 * @param gname the gname to set
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}
	/**
	 * @return the gprice
	 */
	public double getGprice() {
		return gprice;
	}
	/**
	 * @param gprice the gprice to set
	 */
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	/**
	 * @return the gpic
	 */
	public String getGpic() {
		return gpic;
	}
	/**
	 * @param gpic the gpic to set
	 */
	public void setGpic(String gpic) {
		this.gpic = gpic;
	}
	/**
	 * @return the oicount
	 */
	public Integer getOicount() {
		return oicount;
	}
	/**
	 * @param oicount the oicount to set
	 */
	public void setOicount(Integer oicount) {
		this.oicount = oicount;
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
	public OrderItem(Integer oiid, Integer oid, String gname, double gprice, String gpic, Integer oicount,
			Integer softdelete) {
		super();
		this.oiid = oiid;
		this.oid = oid;
		this.gname = gname;
		this.gprice = gprice;
		this.gpic = gpic;
		this.oicount = oicount;
		this.softdelete = softdelete;
	}
	public OrderItem() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderItem [oiid=" + oiid + ", oid=" + oid + ", gname=" + gname + ", gprice=" + gprice + ", gpic=" + gpic
				+ ", oicount=" + oicount + ", softdelete=" + softdelete + "]";
	}
	
	
	

}
