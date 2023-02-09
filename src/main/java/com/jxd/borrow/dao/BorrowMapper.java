package com.jxd.borrow.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.borrow.model.Borrow;
import com.jxd.borrow.model.BorrowInfo;
import com.jxd.borrow.model.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BorrowMapper {
/*    boolean add(Borrow borrow);*/
    boolean add(Borrow borrow);
    IPage<BorrowInfo> getPersonalBorrow(IPage<BorrowInfo> page , @Param("money") Double money, @Param("typeno") Integer typeno,@Param("empno") Integer empno  );
    List<Type> getAllType();
    //    boolean add(Borrow borrow);
    boolean delBorrow (List<Integer> borrows);
    //
    IPage<Map<String,Object>> getAllBorrow(IPage<Map<String,Object>> page,@Param("ename")String ename,@Param("typeno")Integer typeno);
    IPage<Map<String,Object>> getAllBorrowAc(IPage<Map<String,Object>> page,@Param("ename")String ename,@Param("typeno")Integer typeno);

    boolean updateBorrow(Borrow borrow);

    boolean  changeBorrowState(Map<String,String> map );

    boolean changeBorrowState02(Map<String,String> map );
    //部门通过
    boolean passBorrowbyMana(Map<String,String> map);
    //财务通过 设置borrow状态 3-> 5  4-> 5
    boolean passBorrowbyAc(Map<String,String> map);
    boolean nopassBorrowbyMana(Map<String,String>map);
    //借款
    boolean nopassBorrowbyManaAc(Map<String,String> map);

    List<String> getBorrows(Map<String,String> map );

    //财务通过还款时，修改borrow的状态值
    boolean  passBorrowStateCaseBack(Map<String,String> map);
    boolean  passBorrowStateCaseBacks(Map<String,String> map);

    boolean changeBorrowstatenoByMa(Map<String,String> map);
    boolean changeBorrowstatenoByAc(Map<String,String> map);

    boolean changeBorrowstatenoByMas(Map<String,String> map);

    boolean nopassborrowmoneybyMana(Map<String,String> map);
    boolean nopassborrowmoneybyAc(Map<String,String> map);





}
