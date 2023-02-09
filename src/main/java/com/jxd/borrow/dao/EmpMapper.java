package com.jxd.borrow.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.borrow.model.Emp;
import com.jxd.borrow.model.EmpInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface EmpMapper {
     //登录
     Map<String,Object> login(@Param("name") String name,@Param("password") String password);

     //管理员获取所有员工的信息
     IPage<EmpInfo> getAllEmpInfo(IPage<EmpInfo> page, @Param("ename") String ename, @Param("deptno") Integer deptno  );
     boolean add(Emp emp );
     boolean update(Emp emp);

    boolean delbatch(List<Integer> empnos);
     //删除之前查询员工的借款状态
     List<String>selestate(List<Integer> empnos);
      List<String> selectborrownos(List<Integer> empnos);
      List<String> selectbacknos(List<Integer> empnos);

      List<String> getAllName();

      Map<String,Object> getEmpInfo(int empno);
      boolean updateinfo(Map<String,String> map);
      boolean setPassword(Map<String,String> map);

}
