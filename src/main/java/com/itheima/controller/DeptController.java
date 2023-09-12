package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        //调用service查询部门数据

        List<Dept> deptList = deptService.seletelist();

        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id){
        log.info("根据id删除部门数据");

        deptService.deleteDept(id);

        return Result.success();
    }

    @PostMapping
    public Result insertdept(@RequestBody Dept dept){
        log.info("添加部门数据");

        deptService.addDept(dept);

        return Result.success();
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        log.info("修改id部门的名称");
        deptService.updateDept(dept);
        return Result.success();

    }

}
