package com.shiki.domain.dao;

import com.shiki.domain.dto.SText;
import com.shiki.domain.dto.STextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface STextMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int countByExample(STextExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int deleteByExample(STextExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int deleteByPrimaryKey(Long textId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int insert(SText record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int insertSelective(SText record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    List<SText> selectByExampleWithBLOBs(STextExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    List<SText> selectByExample(STextExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    SText selectByPrimaryKey(Long textId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int updateByExampleSelective(@Param("record") SText record, @Param("example") STextExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") SText record, @Param("example") STextExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int updateByExample(@Param("record") SText record, @Param("example") STextExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int updateByPrimaryKeySelective(SText record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(SText record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_text
     *
     * @mbggenerated Thu Jun 27 16:12:35 CST 2019
     */
    int updateByPrimaryKey(SText record);
}