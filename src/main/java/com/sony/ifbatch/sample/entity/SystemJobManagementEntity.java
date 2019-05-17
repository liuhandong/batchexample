/*
 * (c) 2019 SONY Corporation All Rights Reserved.
 */

package com.sony.ifbatch.sample.entity;

import java.io.Serializable;

/**
 * (情報域)システム_ジョブ管理のクラス。
 *
 * <h3>詳細</h3> (情報域)ユーザ番号情報一覧を格納する。
 *
 */
public class SystemJobManagementEntity implements Serializable {

	/** シリアルバージョン。 */
	private static final long serialVersionUID = 2630977899772075550L;

	/** ジョブ管理ID */
	private Long jobManagementId;

	/** ロケールID */
	private String localeId;

	/** カテゴリID(FK) */
	private String categoryId;

	/** ジョブタイプコード */
	private String jobTypeCode;

	/** ジョブステータスコード */
	private String jobStatusCode;

	/** エンティティータイプコード */
	private int entityTypeCode;

	/** エンティティーID */
	private String entityId;

	/** エンティティーバージョン番号 */
	private int entityVersionNumber;

	/** パラメータ1 */
	private String parameter1;

	/** パラメータ2 */
	private String parameter2;

	/** パラメータ3 */
	private String parameter3;

	/** パラメータ4 */
	private String parameter4;

	/** パラメータ5 */
	private String parameter5;

	/** パラメータ6 */
	private String parameter6;

	/** パラメータ7 */
	private String parameter7;

	/** パラメータ8 */
	private String parameter8;

	/** パラメータ9 */
	private String parameter9;

	/** パラメータ10 */
	private String parameter10;

	/** パラメータ11 */
	private String parameter11;

	/** パラメータ12 */
	private String parameter12;

	/** パラメータ13 */
	private String parameter13;

	/** パラメータ14 */
	private String parameter14;

	/** パラメータ15 */
	private String parameter15;

	/** パラメータ16 */
	private String parameter16;

	/** パラメータ17 */
	private String parameter17;

	/** パラメータ18 */
	private String parameter18;

	/** パラメータ19 */
	private String parameter19;

	/** パラメータ20 */
	private String parameter20;

	/** ジョブ開始日時 */
	private String jobStartTime;

	/** ジョブ終了日時 */
	private String jobEndTime;

	/** ジョブ実行者ID */
	private String jobExecutorId;

	/** 楽観排他制御列 */
	private int optimisticLockExKey;

	/** 削除フラグ */
	private int deleteFlag;

	/** 登録者ID */
	private String registUserId;

	/** 登録日時 */
	private String registDate;

	/** 最終更新者ID */
	private String updateUserId;

	/** 最終更新日時 */
	private String updateDate;

	public Long getJobManagementId() {
		return jobManagementId;
	}

	public void setJobManagementId(Long jobManagementId) {
		this.jobManagementId = jobManagementId;
	}

	public String getLocaleId() {
		return localeId;
	}

	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getJobTypeCode() {
		return jobTypeCode;
	}

	public void setJobTypeCode(String jobTypeCode) {
		this.jobTypeCode = jobTypeCode;
	}

	public String getJobStatusCode() {
		return jobStatusCode;
	}

	public void setJobStatusCode(String jobStatusCode) {
		this.jobStatusCode = jobStatusCode;
	}

	public int getEntityTypeCode() {
		return entityTypeCode;
	}

	public void setEntityTypeCode(int entityTypeCode) {
		this.entityTypeCode = entityTypeCode;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public int getEntityVersionNumber() {
		return entityVersionNumber;
	}

	public void setEntityVersionNumber(int entityVersionNumber) {
		this.entityVersionNumber = entityVersionNumber;
	}

	public String getParameter1() {
		return parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	public String getParameter2() {
		return parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	public String getParameter3() {
		return parameter3;
	}

	public void setParameter3(String parameter3) {
		this.parameter3 = parameter3;
	}

	public String getParameter4() {
		return parameter4;
	}

	public void setParameter4(String parameter4) {
		this.parameter4 = parameter4;
	}

	public String getParameter5() {
		return parameter5;
	}

	public void setParameter5(String parameter5) {
		this.parameter5 = parameter5;
	}

	public String getParameter6() {
		return parameter6;
	}

	public void setParameter6(String parameter6) {
		this.parameter6 = parameter6;
	}

	public String getParameter7() {
		return parameter7;
	}

	public void setParameter7(String parameter7) {
		this.parameter7 = parameter7;
	}

	public String getParameter8() {
		return parameter8;
	}

	public void setParameter8(String parameter8) {
		this.parameter8 = parameter8;
	}

	public String getParameter9() {
		return parameter9;
	}

	public void setParameter9(String parameter9) {
		this.parameter9 = parameter9;
	}

	public String getParameter10() {
		return parameter10;
	}

	public void setParameter10(String parameter10) {
		this.parameter10 = parameter10;
	}

	public String getParameter11() {
		return parameter11;
	}

	public void setParameter11(String parameter11) {
		this.parameter11 = parameter11;
	}

	public String getParameter12() {
		return parameter12;
	}

	public void setParameter12(String parameter12) {
		this.parameter12 = parameter12;
	}

	public String getParameter13() {
		return parameter13;
	}

	public void setParameter13(String parameter13) {
		this.parameter13 = parameter13;
	}

	public String getParameter14() {
		return parameter14;
	}

	public void setParameter14(String parameter14) {
		this.parameter14 = parameter14;
	}

	public String getParameter15() {
		return parameter15;
	}

	public void setParameter15(String parameter15) {
		this.parameter15 = parameter15;
	}

	public String getParameter16() {
		return parameter16;
	}

	public void setParameter16(String parameter16) {
		this.parameter16 = parameter16;
	}

	public String getParameter17() {
		return parameter17;
	}

	public void setParameter17(String parameter17) {
		this.parameter17 = parameter17;
	}

	public String getParameter18() {
		return parameter18;
	}

	public void setParameter18(String parameter18) {
		this.parameter18 = parameter18;
	}

	public String getParameter19() {
		return parameter19;
	}

	public void setParameter19(String parameter19) {
		this.parameter19 = parameter19;
	}

	public String getParameter20() {
		return parameter20;
	}

	public void setParameter20(String parameter20) {
		this.parameter20 = parameter20;
	}

	public String getJobStartTime() {
		return jobStartTime;
	}

	public void setJobStartTime(String jobStartTime) {
		this.jobStartTime = jobStartTime;
	}

	public String getJobEndTime() {
		return jobEndTime;
	}

	public void setJobEndTime(String jobEndTime) {
		this.jobEndTime = jobEndTime;
	}

	public String getJobExecutorId() {
		return jobExecutorId;
	}

	public void setJobExecutorId(String jobExecutorId) {
		this.jobExecutorId = jobExecutorId;
	}

	public int getOptimisticLockExKey() {
		return optimisticLockExKey;
	}

	public void setOptimisticLockExKey(int optimisticLockExKey) {
		this.optimisticLockExKey = optimisticLockExKey;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRegistUserId() {
		return registUserId;
	}

	public void setRegistUserId(String registUserId) {
		this.registUserId = registUserId;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/** 処理日時 */
//	private String ; // todo


}
