package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    //不使用PageHelper。原始操作
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1.获取总记录数
        long count = empMapper.count();
        //2.获取分页查询结果列表
        Integer start = (page-1)*pageSize;//计算起始索引
        List<Emp> empList = empMapper.list(start,pageSize , name ,gender ,begin ,end);

        //3.封装PageBean对象
        PageBean pageBean = new PageBean(count,empList);
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        //删除操作
        empMapper.delete(ids);
    }


}
