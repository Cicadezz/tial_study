package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     * @return
     */

    List<Dept> seletelist();
    void deleteDeptById(Integer id);
    void addDept(Dept dept);
    void updateDept(Dept dept);
}
