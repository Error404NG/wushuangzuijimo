package com.woniu.po;

import java.util.Date;

public class Login {
	
	private Integer lid;
	private String lname;
	private String lpwd;
	private Integer rid;
	private Date updatetime;
	private Date createdtime;
	private Integer softdelete;
	/**
	 * @return the lid
	 */
	public Integer getLid() {
		return lid;
	}
	/**
	 * @param lid the lid to set
	 */
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the lpwd
	 */
	public String getLpwd() {
		return lpwd;
	}
	/**
	 * @param lpwd the lpwd to set
	 */
	public void setLpwd(String lpwd) {
		this.lpwd = lpwd;
	}
	/**
	 * @return the rid
	 */
	public Integer getRid() {
		return rid;
	}
	/**
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	/**
	 * @return the updatetime
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * @param updatetime the updatetime to set
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * @return the createdtime
	 */
	public Date getCreatedtime() {
		return createdtime;
	}
	/**
	 * @param createdtime the createdtime to set
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
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
	public Login(Integer lid, String lname, String lpwd, Integer rid, Date updatetime, Date createdtime,
			Integer softdelete) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.lpwd = lpwd;
		this.rid = rid;
		this.updatetime = updatetime;
		this.createdtime = createdtime;
		this.softdelete = softdelete;
	}
	public Login() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Login [lid=" + lid + ", lname=" + lname + ", lpwd=" + lpwd + ", rid=" + rid + ", updatetime="
				+ updatetime + ", createdtime=" + createdtime + ", softdelete=" + softdelete + "]";
	}
		
	

}
