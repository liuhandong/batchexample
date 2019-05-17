/*
 * (c) 2019 SONY Corporation All Rights Reserved.
 */

package com.sony.ifbatch.sample.entity;

import java.io.Serializable;

/**
 * (����)IconMaster�̃N���X�B
 *
 *
 */
public class IconMasterEntity implements Serializable {

	/** �V���A���o�[�W���� */
	private static final long serialVersionUID = 2630977899772075550L;

	/** ���P�[��ID */
	private String localeId;

	/** BizID "Icon"�Œ� */
	private String bizID;

	/** �A�Z�b�gID (FK) */
	private String iconId;

	/** �A�Z�b�g�t�@�C����(����J) */
	private String previewIconPath;

	/** �A�Z�b�g�t�@�C���p�X(���J) */
	private String publishIconPath;

	/** ALT�e�L�X�g */
	private String altText;

	/** �L���v�V���� */
	private String caption;


}