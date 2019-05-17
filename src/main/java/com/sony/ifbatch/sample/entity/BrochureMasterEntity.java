/*
 * (c) 2019 SONY Corporation All Rights Reserved.
 */

package com.sony.ifbatch.sample.entity;

import java.io.Serializable;

/**
 * (����)BrochureMaster�̃N���X�B
 *
 *
 */
public class BrochureMasterEntity implements Serializable {

	/** �V���A���o�[�W���� */
	private static final long serialVersionUID = 2630977899772075550L;

	/** ���P�[��ID */
	private String localeId;

	/** BizID "Brochrer"�Œ� */
	private String bizID;

	/** �u���[�V���[ID */
	private String brochureId;

	/** �u���[�V���[Title */
	private String brochureTitle;

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

	/** �摜ALT�e�L�X�g*/
	private String altText;

	/** �摜�L���v�V���� */
	private String caption;

	/** �A�Z�b�g�t�@�C���p�X(���J) */
	private String brochureLink;

	/** �t�@�C���^�C�v */
	private String fileType;

	/** �t�@�C���T�C�Y */
	private String fileSize;


}