package com.liuyiming.service;

import com.liuyiming.dao.DepartmentMapper;
import com.liuyiming.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAllDept() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
