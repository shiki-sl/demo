package com.shiki.domain.dao;

import com.shiki.domain.dto.SPerms;
import com.shiki.domain.dto.SPermsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 孙磊
 */
public interface SPermsExtMapper {
    /**
     *
     * @param roleId
     * @return
     */
    List<SPerms> findAllByRoleId(Integer roleId);

    /**
     *
     * @param userId
     * @return
     */
    List<String> findPermsByUserId(Integer userId);
}