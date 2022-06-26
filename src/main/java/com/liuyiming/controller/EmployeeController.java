package com.liuyiming.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuyiming.bean.Msg;
import com.liuyiming.pojo.Employee;
import com.liuyiming.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<Employee> list = employeeService.getAll();
        PageInfo pageInfo = new PageInfo(list, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "list";
    }

    @ResponseBody
    @RequestMapping("/emps")
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Employee> list = employeeService.getAll();
        PageInfo pageInfo = new PageInfo(list, 5);
        return Msg.success().add("pageInfo", pageInfo);
    }


    /**
     * 员工保存
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg savaEmp(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println("错误的字段名：" + error.getField());
                System.out.println("错误的信息：" + error.getDefaultMessage());
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Msg.fail().add("errorField", map);
        } else {
            employeeService.savaEmp(employee);
            return Msg.success();
        }
    }

    @RequestMapping("/checkuser")
    @ResponseBody
    public Msg checkUser(@RequestParam(value = "empName") String empName) {
        //判断用户名是否合法
        String regName = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if (!empName.matches(regName)) {
            return Msg.fail().add("va_msg", "**********用户名可以是2-5位中文或者6-16位英文和数字组合**********");
        }
        Boolean b = employeeService.checkUser(empName);
        if (b) {
            return Msg.success();
        }
        return Msg.fail().add("va_msg", "**********用户名不可用**********");
    }

    /**
     * 根据id查询员工
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmp(id);
        return Msg.success().add("emp", employee);
    }

    /**
     * 员工更新方法
     *
     * @param employee
     * @return Employee{empId=1030, empName='null', gender='null', email='null', dId=null, department=null}
     * 如果直接发送ajax=PUT请求，封装的数据都是null,请求体重有数据，但是emp对象封装不上
     * <p>
     * 1、封装不上原因：tomcat：将请求体的数据，封装成map，
     * 2、request.getParameter("empName")就会从这个map中取值
     * 3、springMVC封装POJO对象时，会把pojo中每个属性的值，request.getParameter("email");
     * <p>
     * ajax发送put请求出现的问题，因为put请求不能直接发送，put请求体中的数据拿不到，tomcat一看是put请求，就不会封装请求体数据为map，只有post形似的请求才封装请求体为map
     * 我们要能支持直接发送put请求，还要求封装请求体中的数据
     * 要配置上HttpPutFormContentFilter
     * 作用：
     * 将请求体中的数据解析包装成一个map，
     * request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
     */
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg save(Employee employee) {
        System.out.println(employee);
        employeeService.updateEmp(employee);
        return Msg.success();
    }


    /**
     * 删除，可以以批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmp(@PathVariable("ids") String ids) {
        if (ids.contains("-")) {
            String[] ids_arr = ids.split("-");
            //组装id
            List<Integer> list = new ArrayList<Integer>();
            for (String string : ids_arr) {
                int id = Integer.parseInt(string);
                list.add(id);
            }
            employeeService.deleteBatch(list);
        } else {
            Integer id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }

        return Msg.success();
    }

}
