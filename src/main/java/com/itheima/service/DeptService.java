package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> seletelist();

    /**
     * 根据id删除部门数据
     */
    void deleteDept(Integer id);

    /**
     * 添加数据
     * @param dept
     */
    void addDept(Dept dept);

    /**
     * 更新数据
     * @param dept
     */
    void updateDept(Dept dept);
}
