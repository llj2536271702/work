package com.jxd.borrow.sevice.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.borrow.dao.BorrowMapper;
import com.jxd.borrow.model.Borrow;
import com.jxd.borrow.model.BorrowInfo;
import com.jxd.borrow.model.Type;
import com.jxd.borrow.sevice.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class  BorrowServiceImpl implements IBorrowService {
    @Autowired
    BorrowMapper borrowMapper;

    @Override
    public boolean add(Borrow borrow) {
        return borrowMapper.add(borrow);
    }

    @Override
    public List<Type>  getAllType() {
        return borrowMapper.getAllType();
    }

    @Override
    public Map<String, Object> getPersonalBorrow(Map<String, String> quaryMap) {
        String  page = quaryMap.get("page");
        String limit = quaryMap.get("limit");
        String money1 = quaryMap.get("money");
        String typenos = quaryMap.get("typeno");//判空？？？
        String emponos = quaryMap.get("empno");
        int typeno = 0;
        Integer empno = Integer.parseInt(emponos);
        Double money = Double.valueOf(0);
        if(!"".equals(typenos)){
            typeno = Integer.parseInt(typenos);
        }
        if(!"".equals(money1)){
            money = Double.parseDouble(money1);

        }
        Map<String,Object> map = new HashMap(5);
        if(page != null && limit != null ){

            IPage<BorrowInfo> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<BorrowInfo> pageResult = borrowMapper.getPersonalBorrow(pages,money,typeno,empno);
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
    public boolean delBorrow(List<Integer> borrows) {

        return borrowMapper.delBorrow(borrows);
    }

    @Override
    public Map<String, Object> getAllBorrow(Map<String, String> quaryMap) {
        String  page = quaryMap.get("page");
        String limit = quaryMap.get("limit");
        String ename = quaryMap.get("ename");
        String typenos = quaryMap.get("typeno");//判空？？？
        int typeno = 0;
        if(!"".equals(typenos)){
            typeno = Integer.parseInt(typenos);
        }

        Map<String,Object> map = new HashMap(4);
        if(page != null && limit != null ){

            IPage<Map<String,Object>> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Map<String,Object>> pageResult = borrowMapper.getAllBorrow(pages,ename,typeno);
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
    public Map<String, Object> getAllBorrowAc(Map<String, String> quaryMap) {
        String  page = quaryMap.get("page");
        String limit = quaryMap.get("limit");
        String ename = quaryMap.get("ename");
        String typenos = quaryMap.get("typeno");//判空？？？
        int typeno = 0;
        if(!"".equals(typenos)){
            typeno = Integer.parseInt(typenos);
        }

        Map<String,Object> map = new HashMap(4);
        if(page != null && limit != null ){

            IPage<Map<String,Object>> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Map<String,Object>> pageResult = borrowMapper.getAllBorrowAc(pages,ename,typeno);
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
    public boolean updateBorrow(Borrow borrow) {
        return   borrowMapper.updateBorrow(borrow);
    }

    @Override
    public boolean changeBorrowState(Map<String, String> map) {
        return borrowMapper.changeBorrowState(map);
    }

    @Override
    public boolean changeBorrowState02(Map<String, String> map) {
        return borrowMapper.changeBorrowState02(map);
    }

    @Override
    public boolean passBorrowbyMana(Map<String,String>map) {

        return borrowMapper.passBorrowbyMana(map);
    }

    @Override
    public boolean passBorrowbyAc(Map<String, String> map) {
        return borrowMapper.passBorrowbyAc(map);
    }

    @Override
    public boolean nopassBorrowbyMana(Map<String,String> map) {
        return borrowMapper.nopassBorrowbyMana(map);
    }
    @Override
    public boolean nopassBorrowbyManaAc(Map<String,String> map) {
        return borrowMapper.nopassBorrowbyManaAc(map);
    }

    @Override
    public List<String> getBorrows(Map<String,String> map) {

        return borrowMapper.getBorrows(map);
    }

    @Override
    public boolean changeBorrowstatenoByMa(Map<String, String> map) {
        return borrowMapper.changeBorrowstatenoByMa(map);
    }

    @Override
    public boolean changeBorrowstatenoByAc(Map<String, String> map) {
        return borrowMapper.changeBorrowstatenoByAc(map);
    }

    @Override
    public boolean changeBorrowstatenoByMas(Map<String, String> map) {
        return borrowMapper.changeBorrowstatenoByMas(map);
    }


    @Override
    public boolean nopassborrowmoneybyMana(Map<String, String> map) {
        return borrowMapper.nopassborrowmoneybyMana( map);
    }

    @Override
    public boolean nopassborrowmoneybyAc(Map<String, String> map) {
        return borrowMapper.nopassborrowmoneybyAc(map);
    }
}
