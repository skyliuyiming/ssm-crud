package com.liuyiming.controller;

import com.liuyiming.bean.Msg;
import com.liuyiming.pojo.Department;
import com.liuyiming.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 返回所有的部门信息
     */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getAllDept() {
        List<Department> list = departmentService.getAllDept();
        return Msg.success().add("deptList", list);
    }
}
