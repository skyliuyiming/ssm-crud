package com.liuyiming.dao;

import com.liuyiming.pojo.Employee;
import com.liuyiming.pojo.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    int countByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    int deleteByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    int deleteByPrimaryKey(Integer empId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    Employee selectByPrimaryKey(Integer empId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Sun Jun 19 15:06:17 CST 2022
     */
    int updateByPrimaryKey(Employee record);



    List<Employee> selectByExampleWithDept(EmployeeExample example);

    Employee selectByPrimaryKeyWithDept(Integer empId);
}