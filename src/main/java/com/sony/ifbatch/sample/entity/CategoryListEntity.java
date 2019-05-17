/*
 * (c) 2019 SONY Corporation All Rights Reserved.
 */

package com.sony.ifbatch.sample.entity;

import java.io.Serializable;

/**
 * (����)CategoryList�̃N���X�B
 *
 *
 */
public class CategoryListEntity implements Serializable {

	/** �V���A���o�[�W���� */
	private static final long serialVersionUID = 2630977899772075550L;

	/** BizID "Category"�Œ� */
	private String bizID;

	/** ���P�[��ID */
	private String localeId;

	/** �J�e�S��ID (FK) */
	private String categoryId;

	/** �J�e�S�����U�[�u�h�t���O */
	private int reservedFlag;

	/** ���[�J���J�e�S���t���O */
	private int localeCategoryFlag;

	/** �J�e�S���� */
	private String categoryName;

	/** �J�e�S�����[����(SITECORE����) */
	private String categoryRoleName;

	/** �J�e�S���X���b�O */
	private String slugs;

	/** ���я� */
	private int rank;

	/** ���f�����x���v���C�V���O�t���O */
	private String disableModelLevelPricing;

	/** ���S�A�Z�b�gID */
	private String brandLogoId;

	/** ���S�A�Z�b�gID */
	private String brandLogoReversedId;

	/** �J�e�S���摜�|�[�^���R���e���cID (FK) */
	private String imageId;

	/** �A�Z�b�g�t�@�C���p�X(����J) */
	private String previewImageFamilyLargePath;



}