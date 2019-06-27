package com.shiki.domain.dao;

import com.shiki.domain.dto.SRole;
import com.shiki.domain.dto.SRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 孙磊
 */
public interface SRoleExtMapper {
    /**
     *
     * @param userId
     * @return
     */
    List<SRole> findAllByUserId(Integer userId);
}