package com.jxd.borrow.sevice.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.borrow.dao.DeptMapper;
import com.jxd.borrow.model.Dept;
import com.jxd.borrow.sevice.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DeptServiceImpl implements IDeptService {
 @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }

    @Override
    public Map<String, Object> getAllDeptInfo(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String deptname = queryMap.get("deptname");
        Map<String,Object> map = new HashMap(3);
        if(page != null && limit != null ){
            IPage<Map<String,Object>> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Map<String,Object>> pageResult = deptMapper.getAllDeptInfo(pages,deptname);
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
    public boolean add(Dept dept) {
        return deptMapper.add(dept);
    }

    @Override
    public boolean update(Dept dept) {
        System.out.println(deptMapper.update(dept));
        return deptMapper.update(dept);
    }

    @Override
    public boolean deleteDept(Map<String,String>dept) {

        return deptMapper.deleteDept(dept);
    }

}
