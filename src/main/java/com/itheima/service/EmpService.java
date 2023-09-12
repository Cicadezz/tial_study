package com.itheima.service;

import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    /**
     * 条件分页查询
     * @param page：查询页码
     * @param pageSize：页码展示数量
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
    void delete(List<Integer> ids);
}
