package com.woniu.po;

import java.util.Date;

public class Address {
	private Integer aid;
	private Integer lid;
	private String aname;
	private String atelephoneno;
	private String aprovince;
	private String acity;
	private String acounty;
	private String atown;
	private String addressinfos;
	private Date updatetime;
	private Date createtime;
	private Integer softdelete;
	/**
	 * @return the aid
	 */
	public Integer getAid() {
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(Integer aid) {
		this.aid = aid;
	}
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
	 * @return the aname
	 */
	public String getAname() {
		return aname;
	}
	/**
	 * @param aname the aname to set
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}
	/**
	 * @return the atelephoneno
	 */
	public String getAtelephoneno() {
		return atelephoneno;
	}
	/**
	 * @param atelephoneno the atelephoneno to set
	 */
	public void setAtelephoneno(String atelephoneno) {
		this.atelephoneno = atelephoneno;
	}
	/**
	 * @return the aprovince
	 */
	public String getAprovince() {
		return aprovince;
	}
	/**
	 * @param aprovince the aprovince to set
	 */
	public void setAprovince(String aprovince) {
		this.aprovince = aprovince;
	}
	/**
	 * @return the acity
	 */
	public String getAcity() {
		return acity;
	}
	/**
	 * @param acity the acity to set
	 */
	public void setAcity(String acity) {
		this.acity = acity;
	}
	/**
	 * @return the acounty
	 */
	public String getAcounty() {
		return acounty;
	}
	/**
	 * @param acounty the acounty to set
	 */
	public void setAcounty(String acounty) {
		this.acounty = acounty;
	}
	/**
	 * @return the atown
	 */
	public String getAtown() {
		return atown;
	}
	/**
	 * @param atown the atown to set
	 */
	public void setAtown(String atown) {
		this.atown = atown;
	}
	/**
	 * @return the addressinfos
	 */
	public String getAddressinfos() {
		return addressinfos;
	}
	/**
	 * @param addressinfos the addressinfos to set
	 */
	public void setAddressinfos(String addressinfos) {
		this.addressinfos = addressinfos;
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
	 * @return the createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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
	public Address(Integer aid, Integer lid, String aname, String atelephoneno, String aprovince, String acity,
			String acounty, String atown, String addressinfos, Date updatetime, Date createtime, Integer softdelete) {
		super();
		this.aid = aid;
		this.lid = lid;
		this.aname = aname;
		this.atelephoneno = atelephoneno;
		this.aprovince = aprovince;
		this.acity = acity;
		this.acounty = acounty;
		this.atown = atown;
		this.addressinfos = addressinfos;
		this.updatetime = updatetime;
		this.createtime = createtime;
		this.softdelete = softdelete;
	}
	public Address() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", lid=" + lid + ", aname=" + aname + ", atelephoneno=" + atelephoneno
				+ ", aprovince=" + aprovince + ", acity=" + acity + ", acounty=" + acounty + ", atown=" + atown
				+ ", addressinfos=" + addressinfos + ", updatetime=" + updatetime + ", createtime=" + createtime
				+ ", softdelete=" + softdelete + "]";
	}
	
	

}
