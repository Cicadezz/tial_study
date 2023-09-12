package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    //不使用PageHelper。原始操作
    public long count();
    public List<Emp> list(Integer start, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
    void delete(List<Integer> ids);
}
