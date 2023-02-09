package com.jxd.borrow.sevice;

import com.jxd.borrow.model.Borrow;
import com.jxd.borrow.model.Type;

import java.util.List;
import java.util.Map;

public interface IBorrowService {
    //借款
    boolean add(Borrow borrow);
    //借款时，查找类型
    List<Type> getAllType();
    Map<String,Object> getPersonalBorrow(Map<String,String> map);
//    boolean add(Borrow borrow);、
    //用户删除自己的借款记录
    boolean delBorrow(List<Integer> borrows);
    Map<String,Object> getAllBorrow(Map<String,String> map);
    Map<String,Object> getAllBorrowAc(Map<String,String> map);
    boolean updateBorrow(Borrow borrow);

    boolean changeBorrowState(Map<String,String> map );

    boolean changeBorrowState02(Map<String,String> map );
    boolean passBorrowbyMana(Map<String,String> map);
    boolean passBorrowbyAc(Map<String,String> map);

    boolean nopassBorrowbyMana(Map<String,String> map);
    boolean nopassBorrowbyManaAc(Map<String,String> map);


    List<String> getBorrows(Map<String,String> map);
    boolean changeBorrowstatenoByMa(Map<String,String> map);
    boolean changeBorrowstatenoByAc(Map<String,String> map);
    public boolean changeBorrowstatenoByMas(Map<String,String> map);
    boolean nopassborrowmoneybyMana(Map<String,String> map);
    boolean nopassborrowmoneybyAc(Map<String,String> map);




}
