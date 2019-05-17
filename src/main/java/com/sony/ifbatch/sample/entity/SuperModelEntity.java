/*
 * (c) 2019 SONY Corporation All Rights Reserved.
 */

package com.sony.ifbatch.sample.entity;

import java.io.Serializable;


public class SuperModelEntity implements Serializable {


	private static final long serialVersionUID = 2630977899772075550L;


	private String localeId;


	private String superModelId;


	private String bizID;


	private String webPageSunriseDate;


	private String webPageSunsetDate;


	private String pvtKey;


	private String externalId;


	private String tier;


	public String getLocaleId() {
		return localeId;
	}


	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}


	public String getSuperModelId() {
		return superModelId;
	}


	public void setSuperModelId(String superModelId) {
		this.superModelId = superModelId;
	}


	public String getBizID() {
		return bizID;
	}


	public void setBizID(String bizID) {
		this.bizID = bizID;
	}


	public String getWebPageSunriseDate() {
		return webPageSunriseDate;
	}


	public void setWebPageSunriseDate(String webPageSunriseDate) {
		this.webPageSunriseDate = webPageSunriseDate;
	}


	public String getWebPageSunsetDate() {
		return webPageSunsetDate;
	}


	public void setWebPageSunsetDate(String webPageSunsetDate) {
		this.webPageSunsetDate = webPageSunsetDate;
	}


	public String getPvtKey() {
		return pvtKey;
	}


	public void setPvtKey(String pvtKey) {
		this.pvtKey = pvtKey;
	}


	public String getExternalId() {
		return externalId;
	}


	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}


	public String getTier() {
		return tier;
	}


	public void setTier(String tier) {
		this.tier = tier;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}