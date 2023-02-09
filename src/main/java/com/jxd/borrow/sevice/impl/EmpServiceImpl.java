package com.jxd.borrow.sevice.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.borrow.dao.EmpMapper;
import com.jxd.borrow.model.Emp;
import com.jxd.borrow.model.EmpInfo;
import com.jxd.borrow.sevice.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements IEmpService  {
  @Autowired
    private EmpMapper empMapper ;
  //登录
    @Override
    public Map<String,Object> login(String name, String password) {
        Map<String,Object> emp = empMapper.login(name, password);
        return emp;
    }

    //管理员获取所有员工的信息 或者是按条件查询
    @Override
    public Map<String, Object> getAllEmpInfo(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String ename = queryMap.get("ename");
        String deptnos = queryMap.get("deptno");
        int deptno = 0;
        if(!"".equals(deptnos)){
            deptno = Integer.parseInt(deptnos);
        }
        Map<String,Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<EmpInfo> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<EmpInfo> pageResult = empMapper.getAllEmpInfo(pages,ename,deptno);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data",(Object)null);
            map.put("code","500");
            map.put("msg","参数不符");
            map.put("count",(Object)null);
            return map;
        }
    }
    @Override
    public boolean add(Emp emp) {
        return empMapper.add(emp);
    }

    @Override
    public boolean update(Emp emp) {
        return empMapper.update(emp);
    }

    //删除员工
    //删除之前判断

    @Override
    public boolean delbatch(List<Integer> empnos) {
        /*   List<String> selectborrownos(List<Integer> empnos);
      List<String> selectbacknos(List<Integer> empnos);*/
        List<String> borrownos = empMapper.selectborrownos(empnos);
        List<String> backnos = empMapper.selectbacknos(empnos);
        int index1 = borrownos.indexOf("0");
        int index2 = borrownos.indexOf("0");
        if(index1 != -1 || index2 != -1){
            return true;
        }else{
           if( empMapper.delbatch(empnos)){
               return false;
           }else{
               return false;
           }

        }
      /*  List<String> states = empMapper.selestate(empnos);

        int index = states.indexOf("0");
        if(index !=-1 ){
            return false;
        }
        return empMapper.delbatch(empnos);
*/


    }

    @Override
    public List<String> getAllEmpName() {
        return empMapper.getAllName();
    }

    @Override
    public Map<String,Object> getEmpInfo(int empno) {
        return empMapper.getEmpInfo(empno);
    }

    @Override
    public boolean updateinfo(Map<String,String> map) {
        return empMapper.updateinfo(map);
    }

    @Override
    public boolean setPassword(Map<String, String> map) {
        return empMapper.setPassword(map);
    }


}
