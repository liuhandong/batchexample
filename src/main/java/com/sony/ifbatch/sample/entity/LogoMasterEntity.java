/*
 * (c) 2019 SONY Corporation All Rights Reserved.
 */

package com.sony.ifbatch.sample.entity;

import java.io.Serializable;

/**
 * (����)LogoMaster�̃N���X�B
 *
 *
 */
public class LogoMasterEntity implements Serializable {

	/** �V���A���o�[�W���� */
	private static final long serialVersionUID = 2630977899772075550L;

	/** ���P�[��ID */
	private String localeId;

	/** BizID "Logo"�Œ� */
	private String bizID;

	/** �A�Z�b�gID (FK) */
	private String logoId;

	/** �A�Z�b�g�t�@�C����(����J) */
	private String previewImageFamilyLargePath;

	/** �A�Z�b�g�t�@�C����(����J) */
	private String previewImageFamilyMediumPath;

	/** �A�Z�b�g�t�@�C����(����J) */
	private String previewImageFamilySmallPath;

	/** �A�Z�b�g�t�@�C���p�X(���J) */
	private String publishImageFamilyLargePath;

	/** �A�Z�b�g�t�@�C���p�X(���J) */
	private String publishImageFamilyMediumPath;

	/** �A�Z�b�g�t�@�C���p�X(���J) */
	private String publishImageFamilySmallPath;

	/** ALT�e�L�X�g */
	private String altText;

	/** �L���v�V���� */
	private String caption;

}