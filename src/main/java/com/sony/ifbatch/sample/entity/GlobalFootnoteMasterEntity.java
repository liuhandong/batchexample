/*
 * (c) 2019 SONY Corporation All Rights Reserved.
 */

package com.sony.ifbatch.sample.entity;

import java.io.Serializable;

/**
 * (����)GallerySuperModelRank�̃N���X�B
 *
 *
 */
public class GlobalFootnoteMasterEntity implements Serializable {

	/** �V���A���o�[�W���� */
	private static final long serialVersionUID = 2630977899772075550L;

	/** ���P�[��ID */
	private String localeId;

	/** BizID "Category"�Œ� */
	private String bizID;

	/** ����ID (FK) */
	private String footNoteCaptionId;

	/** ���߃e�L�X�g */
	private String footNoteCaption;

}