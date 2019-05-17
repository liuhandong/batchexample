/*
 * (c) 2019 SONY Corporation All Rights Reserved.
 */

package com.sony.ifbatch.sample.entity;

import java.io.Serializable;

/**
 * (����)CompatibleRankMaster�̃N���X�B
 * CompatibleCategoryList �ƍ��킹�ĂP�ŏ\���B
 * ���O�́ACompatibleRankMaster �ŁA���e�́ACompatibleCategoryList�̂��̂��쐬����B
 *
 */
public class CompatibleRankMasterEntity implements Serializable {

	/** �V���A���o�[�W���� */
	private static final long serialVersionUID = 2630977899772075550L;

	/** ���P�[��ID */
	private String localeId;

	/** BizID "CompatibleRank"�Œ� */
	private String bizID;

	/** �J�e�S��ID (FK) */
	private String middleCategoryID;

	/** �e�J�e�S��ID (FK) */
	private String categoryID;

	/** �֘A���J�e�S��ID (FK) */
	private String subCategoryID;

	/** �֘A���J�e�S�����я� */
	private int rank;

	/** �֘A���i���ёւ����ڃR�[�h */
	private String superModelRankType;

	/** ���ѕς����� */
	private String orderType;

}