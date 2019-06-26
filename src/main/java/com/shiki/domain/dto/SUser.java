package com.shiki.domain.dto;

import java.io.Serializable;

public class SUser implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user.user_id
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user.username
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user.password
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table s_user
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user.user_id
     *
     * @return the value of s_user.user_id
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user.user_id
     *
     * @param userId the value for s_user.user_id
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user.username
     *
     * @return the value of s_user.username
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user.username
     *
     * @param username the value for s_user.username
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user.password
     *
     * @return the value of s_user.password
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user.password
     *
     * @param password the value for s_user.password
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}