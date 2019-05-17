/*
 * (c) 2019 SONY Corporation All Rights Reserved.
 */

package com.sony.ifbatch.sample.entity;

import java.io.Serializable;

/**
 * (����)MenuCategoryList�̃N���X�B
 *
 *
 */
public class MenuCategoryListEntity implements Serializable {

	/** �V���A���o�[�W���� */
	private static final long serialVersionUID = 2630977899772075550L;

	/** ���P�[��ID */
	private String localeId;

	/** BizID "MenuCategory"�Œ� */
	private String bizID;

	/** �A�Z�b�gID (FK) */
	private String logoId;

	/** �J�e�S��ID */
	private String level1CategoryId;

	/** �J�e�S���\���� */
	private String level1CategoryName;

	/** ���я� */
	private int rank;

}