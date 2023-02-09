package com.jxd.borrow.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.borrow.model.Back;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BackMapper {

    boolean add(Map<String,String> map);

    //mana 还款管理
    //backAllList
IPage<Map<String,Object>> getBackAllList(IPage<Map<String,Object>> page,@Param("ename") String ename,@Param("start") String start,@Param("end") String end);
IPage<Map<String,Object>> getBackAllListAc(IPage<Map<String,Object>> page,@Param("ename") String ename,@Param("start") String start,@Param("end") String end);

    
     boolean delBack (List<Integer> backs);
    Back getBackbyNo(Map<String,String> map);

    IPage<Map<String,Object>> getBackList(IPage<Map<String,Object>> page,@Param("borrowno")Integer borrowno,@Param("empno")Integer empno);
    boolean passBackUpdate(Map<String ,String> map );
    boolean passBackInsert(Map<String ,String> map);
    boolean nopassBack(Map<String,String> map);

    int selectBackno(Map<String ,String> map);
  /*  boolean insertBacknew(Map<String,String> map);*/
    Double seleMoneyleft(int backno);
    boolean updateBackstateno(Map<String,String> map );

    //财务审核时，如果是3-5直接财务，加个back表  如果4 经过部门 ，修改状态

    boolean changeBackstatenoByAc(Map<String,String> map);
    boolean changeBackstatenoByAcstre(Map<String,String> map);
    boolean changeBorrowstateByAc(Map<String,String> map);

    boolean addBackByAc(Map<String,String> map);
    boolean addBackByMa(Map<String,String>  map);

   /* public boolean  changeBackstatenoByMa(Map<String, String> map) {

    public boolean  changeBackstatenoByAcs(Map<String, String> map) {
*/
    boolean   changeBackstatenoByMa(Map<String, String> map);
    boolean  changeBackstatenoByAcs(Map<String, String> map);

    //财务审核是否还款是否通过
    //    s大于2000
    boolean passBackbyAc(Map<String,String> map);
    boolean passBackbyAcs(Map<String,String> map);

    boolean nopassBackbyAc(Map<String,String> map);

    boolean passBackbyMa(Map<String,String> map);
    boolean nopassBackbyMa(Map<String,String>map);
    boolean changeBackstatenoByMas(Map<String,String> map );


}

