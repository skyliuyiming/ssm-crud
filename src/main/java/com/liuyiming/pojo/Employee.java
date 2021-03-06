package com.liuyiming.pojo;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;

public class Employee {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_emp.emp_id
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    private Integer empId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_emp.emp_name
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})",message="用户名必须是2-5位中文或者6-16位英文和数字组合")
    private String empName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_emp.gender
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_emp.email
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    //@Email
    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",message="邮箱格式不正确")
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_emp.d_id
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    private Integer dId;

    private Department department;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_emp.emp_id
     *
     * @return the value of tbl_emp.emp_id
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_emp.emp_id
     *
     * @param empId the value for tbl_emp.emp_id
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_emp.emp_name
     *
     * @return the value of tbl_emp.emp_name
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_emp.emp_name
     *
     * @param empName the value for tbl_emp.emp_name
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_emp.gender
     *
     * @return the value of tbl_emp.gender
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_emp.gender
     *
     * @param gender the value for tbl_emp.gender
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_emp.email
     *
     * @return the value of tbl_emp.email
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_emp.email
     *
     * @param email the value for tbl_emp.email
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_emp.d_id
     *
     * @return the value of tbl_emp.d_id
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    public Integer getdId() {
        return dId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_emp.d_id
     *
     * @param dId the value for tbl_emp.d_id
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    public void setdId(Integer dId) {
        this.dId = dId;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {
    }

    public Employee(Integer empId, String empName, String gender, String email, Integer dId) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dId=" + dId +
                ", department=" + department +
                '}';
    }
}