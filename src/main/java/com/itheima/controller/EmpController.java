package com.itheima.controller;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {

         log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize,name, gender, begin, end);
         PageBean pageBean = empService.page(page, pageSize,name, gender, begin, end);

        return Result.success(pageBean);

    }

    @DeleteMapping("/{ids}")
    public Result delet(@PathVariable List<Integer> ids){
        log.info("删除员工");
        empService.delete(ids);
        return Result.success();

    }



}
