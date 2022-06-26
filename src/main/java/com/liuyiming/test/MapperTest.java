package com.liuyiming.test;

import com.liuyiming.dao.DepartmentMapper;
import com.liuyiming.dao.EmployeeMapper;
import com.liuyiming.pojo.Department;
import com.liuyiming.pojo.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testCRUD() {
        //创建springIOC容器
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取mapper
//        DepartmentMapper mapper = context.getBean(DepartmentMapper.class);
//        System.out.println(departmentMapper);
//        int i1 = departmentMapper.insertSelective(new Department(null, "开发部"));
//        int i2 = departmentMapper.insertSelective(new Department(null, "测试部"));

//        employeeMapper.insertSelective(new Employee(null,"张三","M","zhangsan@163.com",1));
//        employeeMapper.insertSelective(new Employee(null,"李四","M","lisi@163.com",2));

//        for (){
//            employeeMapper.insertSelective(new Employee(null,"李四","M","lisi@163.com",2));
//        }

        //批量新增
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0;i<1000;i++){
            String uuid = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new Employee(null,uuid,"M",uuid+"@163.com",1));
            System.out.println();
        }
    }
}
