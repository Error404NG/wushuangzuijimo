package com.woniu.po;

public class Goods {
	private Integer gid;
	private String gname;
	private Double gprice;
	private Integer ginventory;
	private String gpic;
	private String gdescribe;
	private Integer gtid;
	private Integer gsoftdel;
	/**
	 * @return the gid
	 */
	public Integer getGid() {
		return gid;
	}
	/**
	 * @param gid the gid to set
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
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
	public Double getGprice() {
		return gprice;
	}
	/**
	 * @param gprice the gprice to set
	 */
	public void setGprice(Double gprice) {
		this.gprice = gprice;
	}
	/**
	 * @return the ginventory
	 */
	public Integer getGinventory() {
		return ginventory;
	}
	/**
	 * @param ginventory the ginventory to set
	 */
	public void setGinventory(Integer ginventory) {
		this.ginventory = ginventory;
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
	 * @return the gdescribe
	 */
	public String getGdescribe() {
		return gdescribe;
	}
	/**
	 * @param gdescribe the gdescribe to set
	 */
	public void setGdescribe(String gdescribe) {
		this.gdescribe = gdescribe;
	}
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
	 * @return the gsoftdel
	 */
	public Integer getGsoftdel() {
		return gsoftdel;
	}
	/**
	 * @param gsoftdel the gsoftdel to set
	 */
	public void setGsoftdel(Integer gsoftdel) {
		this.gsoftdel = gsoftdel;
	}
	public Goods(Integer gid, String gname, Double gprice, Integer ginventory, String gpic, String gdescribe,
			Integer gtid, Integer gsoftdel) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
		this.ginventory = ginventory;
		this.gpic = gpic;
		this.gdescribe = gdescribe;
		this.gtid = gtid;
		this.gsoftdel = gsoftdel;
	}
	public Goods() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gprice=" + gprice + ", ginventory=" + ginventory
				+ ", gpic=" + gpic + ", gdescribe=" + gdescribe + ", gtid=" + gtid + ", gsoftdel=" + gsoftdel + "]";
	}
	
	
	
	
	
	
	
	

}
