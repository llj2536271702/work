package com.jxd.borrow.sevice;

import com.jxd.borrow.model.Dept;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IDeptService
 * @Description TODO
 * @Author llj
 * @Date 2023/1/29 17:55
 * @Version 1.0
 */

public interface IDeptService {
    List<Dept> getAllDept();
    Map<String,Object> getAllDeptInfo(Map<String,String> map);
    boolean add(Dept dept);
    boolean update(Dept dept);
    boolean deleteDept(Map<String,String> dept);
}

