package com.jxd.borrow.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.borrow.model.Dept;
import com.jxd.borrow.model.Emp;
import com.jxd.borrow.model.EmpInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptMapper {

    //获取部门信息
 List<Dept>  getAllDept();
//获取所有部门信息
  IPage<Map<String,Object>> getAllDeptInfo(IPage<Map<String,Object>> page, @Param("deptname") String deptname);
    boolean add(Dept dept);
    boolean update(Dept dept);
    boolean deleteDept(Map<String,String> dept);
    //删除部门前判断一下人数

}
