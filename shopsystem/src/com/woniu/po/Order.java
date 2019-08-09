package com.woniu.po;

import java.util.Date;

public class Order {
	private Integer oid;
	private String orderno;
	private String payno;
	private Integer lid;
	private Integer aid;
	private Integer state;
	private Date updatetime;
	private Date createtime;
	private Integer softdelete;
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
	 * @return the orderno
	 */
	public String getOrderno() {
		return orderno;
	}
	/**
	 * @param orderno the orderno to set
	 */
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	/**
	 * @return the payno
	 */
	public String getPayno() {
		return payno;
	}
	/**
	 * @param payno the payno to set
	 */
	public void setPayno(String payno) {
		this.payno = payno;
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
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
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
	public Order(Integer oid, String orderno, String payno, Integer lid, Integer aid, Integer state, Date updatetime,
			Date createtime, Integer softdelete) {
		super();
		this.oid = oid;
		this.orderno = orderno;
		this.payno = payno;
		this.lid = lid;
		this.aid = aid;
		this.state = state;
		this.updatetime = updatetime;
		this.createtime = createtime;
		this.softdelete = softdelete;
	}
	public Order() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", orderno=" + orderno + ", payno=" + payno + ", lid=" + lid + ", aid=" + aid
				+ ", state=" + state + ", updatetime=" + updatetime + ", createtime=" + createtime + ", softdelete="
				+ softdelete + "]";
	}
	
	

}
