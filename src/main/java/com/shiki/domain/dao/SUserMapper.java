package com.shiki.domain.dao;

import com.shiki.domain.dto.SUser;
import com.shiki.domain.dto.SUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int countByExample(SUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int deleteByExample(SUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int insert(SUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int insertSelective(SUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    List<SUser> selectByExample(SUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    SUser selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int updateByExampleSelective(@Param("record") SUser record, @Param("example") SUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int updateByExample(@Param("record") SUser record, @Param("example") SUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int updateByPrimaryKeySelective(SUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int updateByPrimaryKey(SUser record);
}