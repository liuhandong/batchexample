package com.sony.ifbatch.sample.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sony.ifbatch.sample.entity.SuperModelEntity;;

/**
 * 詳細情報リポジトリ。
 *
 */
@Repository
public interface SuperModelRepository {

    /**
     * 情報の更新。
     *
     * @param SuperModelEntity 更新する情報
     */
	SuperModelEntity selectSuperModel(@Param("localeId") String localeId,@Param("superModelId") String superModelId);
    
    int updateSuperModel(SuperModelEntity superModelEntity);
    
    List<SuperModelEntity> selectSuperModelAll();
}
