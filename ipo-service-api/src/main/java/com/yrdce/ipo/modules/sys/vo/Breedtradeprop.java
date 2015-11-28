package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.util.Date;

public class Breedtradeprop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7228217064948327405L;

	private Date modifytime;

	private Long breedid;

	private Short sectionid;

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Long getBreedid() {
		return breedid;
	}

	public void setBreedid(Long breedid) {
		this.breedid = breedid;
	}

	public Short getSectionid() {
		return sectionid;
	}

	public void setSectionid(Short sectionid) {
		this.sectionid = sectionid;
	}

}
