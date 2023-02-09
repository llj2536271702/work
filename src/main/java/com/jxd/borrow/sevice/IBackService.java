package com.jxd.borrow.sevice;

import com.jxd.borrow.model.Back;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface IBackService {
    Back getBackbyNo(Map<String,String> map);
    //IPage<Back> getBackList(IPage<Back> page);
    Map<String,Object> getBackList(Map<String,String> map);
    boolean delBack(List<Integer> backs);
    //经理
    Map<String,Object> getBackAllList(Map<String,String> map);
    Map<String,Object> getBackAllListAc(Map<String,String> map);
   /* boolean add(Map<String,String> map);*/
    Map<String ,String> tobackmoney(Map<String,String> map);
    /*addBack(borrow)*/
    //部门审核借款后插入还款数据
    Boolean addBack(Map<String,String> map);
        //财务审核通过了
    //财务审核时，如果是直接财务审核，borrowno = 3 经过部门的=4
    //经过部门的要该两个表都改变状态 只经过财务的新建表，并且修改borrow的状态
    //addorschangeBack
    boolean addBackByAc(Map<String,String> map );
    boolean addBackByMa(Map<String,String> map);

    boolean changeBackstateno(Map<String,String> map);
    //

    //用户提交还款后，提交给部门或者财务进行待审核，改状态
   // backService.changeBackstatenoByMa(map)
    boolean changeBackstatenoByMa(Map<String,String> map);
    boolean changeBackstatenoByAc(Map<String,String> map);

    //财务审核还款 通过
    boolean passBackbyAc(Map<String,String> map,boolean flag);
    //不通过
    boolean nopassBackbyAc(Map<String,String>map);
    //部门审核还款 通过
    boolean passBackbyMa(Map<String,String> map);
    public boolean nopassBackbyMa(Map<String, String> map);


    public boolean changeBackstatenoByMas(Map<String,String> map);



}
