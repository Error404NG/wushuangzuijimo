package com.woniu.po;

public class Role {
	
	private Integer rid;
	private String rname;
	private Integer softdelete;
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
	 * @return the rname
	 */
	public String getRname() {
		return rname;
	}
	/**
	 * @param rname the rname to set
	 */
	public void setRname(String rname) {
		this.rname = rname;
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
	public Role(Integer rid, String rname, Integer softdelete) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.softdelete = softdelete;
	}
	public Role() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + ", softdelete=" + softdelete + "]";
	}
	
	
	

}
