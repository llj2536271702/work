package com.jxd.borrow.sevice;

import com.jxd.borrow.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IEmpService {
    //登录
    Map<String,Object> login(String name, String password);

    //管理员获取所有员工的信息 或者是按条件查询
    Map<String,Object> getAllEmpInfo(Map<String ,String> map);
    //管理员新增员工
    boolean add(Emp emp);
    //管理员修改员工信息
    boolean update(Emp emp);
    //管理员删除员工信息
    boolean delbatch(List<Integer> empno);
    //删除之前查询员工的借款状态
    List<String> getAllEmpName();

    Map<String,Object> getEmpInfo(int empno);

    boolean updateinfo(Map<String,String> map);
    boolean setPassword(Map<String,String> map) ;

}
