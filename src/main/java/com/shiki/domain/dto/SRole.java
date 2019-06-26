package com.shiki.domain.dto;

import java.io.Serializable;

public class SRole implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_role.role_id
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_role.role_name
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table s_role
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role.role_id
     *
     * @return the value of s_role.role_id
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role.role_id
     *
     * @param roleId the value for s_role.role_id
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role.role_name
     *
     * @return the value of s_role.role_name
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role.role_name
     *
     * @param roleName the value for s_role.role_name
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Jun 24 14:11:35 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}