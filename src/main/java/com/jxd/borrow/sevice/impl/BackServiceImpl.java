package com.jxd.borrow.sevice.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.borrow.dao.BackMapper;
import com.jxd.borrow.dao.BorrowMapper;
import com.jxd.borrow.model.Back;
import com.jxd.borrow.model.BorrowInfo;
import com.jxd.borrow.sevice.IBackService;
import com.jxd.borrow.sevice.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BackServiceImpl implements IBackService {
    @Autowired
    BackMapper backMapper;
    @Autowired
    BorrowMapper borrowMapper;
    @Override
    public Back getBackbyNo(Map<String,String> map) {
        return backMapper.getBackbyNo(map);
    }
        public Map<String, Object> getBackList(Map<String, String> quaryMap) {
            String  page = quaryMap.get("page");
            String limit = quaryMap.get("limit");
            String borrownos = quaryMap.get("borrowno");
            String empnos = quaryMap.get("empno");//判空？？？
            Integer borrowno = 0;

            if(!"".equals(borrownos)){
                borrowno = Integer.parseInt(borrownos);
            }
            Integer empno = Integer.parseInt(empnos);

            Map<String,Object> map = new HashMap(4);
            if(page != null && limit != null ){

                IPage<Map<String,Object>> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));

                IPage<Map<String,Object>> pageResult = backMapper.getBackList(pages,borrowno,empno);

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
    public boolean delBack(List<Integer> backs) {
        return backMapper.delBack(backs);
    }

    @Override
    public Map<String, Object> getBackAllList(Map<String, String> quaryMap) {
        String  page = quaryMap.get("page");
        String limit = quaryMap.get("limit");
        String ename= quaryMap.get("ename");
        String start = quaryMap.get("start");
        String end = quaryMap.get("end");
        Map<String,Object> map = new HashMap(5);
        if(page != null && limit != null ){
            IPage<Map<String,Object>> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Map<String,Object>> pageResult = backMapper.getBackAllList(pages,ename,start,end);

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
    public Map<String, Object> getBackAllListAc(Map<String, String> quaryMap) {
        String  page = quaryMap.get("page");
        String limit = quaryMap.get("limit");
        String ename= quaryMap.get("ename");
        String start = quaryMap.get("start");
        String end = quaryMap.get("end");
        Map<String,Object> map = new HashMap(5);
        if(page != null && limit != null ){
            IPage<Map<String,Object>> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Map<String,Object>> pageResult = backMapper.getBackAllListAc(pages,ename,start,end);

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
    public Map<String,String> tobackmoney(Map<String, String> map) {
        double moneyleft = 0;
        int backno = backMapper.selectBackno(map);
        if(backno == 0){
            moneyleft = Double.parseDouble(map.get("money"));
        }else{

         moneyleft = backMapper.seleMoneyleft(backno);
        }

        Map<String,String> m = new HashMap<>();
        m.put("backno",backno+"");
        m.put("moneyleft",moneyleft+"");
        return  m;
    }

    @Override
    public Boolean addBack(Map<String, String> map) {
        return backMapper.add(map);
    }

    @Override
    public boolean addBackByAc(Map<String, String> map) {
       return  backMapper.addBackByAc(map);
    }

    @Override
    public boolean addBackByMa(Map<String, String> map) {
        return backMapper.addBackByMa(map);
    }



    @Override
    public boolean changeBackstateno(Map<String, String> map) {
        return backMapper.updateBackstateno(map);
    }


    //用户提交还款后，提交给部门或者财务进行待审核，改状态
    @Override
    public boolean changeBackstatenoByMa(Map<String, String> map) {

        return backMapper.changeBackstatenoByMa(map);
    }

    @Override
    public boolean changeBackstatenoByAc(Map<String, String> map) {
        return backMapper.changeBackstatenoByAcs(map);
    }

    //财务审核还款是否通过
    @Override
    public boolean passBackbyAc(Map<String, String> map,boolean flag) {
        if(flag){
           flag = true;//是全部还款
           backMapper.passBackbyAc(map);
           //修改borrow表的值
            borrowMapper.passBorrowStateCaseBack(map);

        }else{
            flag = true;
            backMapper.passBackbyAcs(map);
            borrowMapper.passBorrowStateCaseBacks(map);
        }
        return flag;
    }
    //财务审核还款  不通过
    @Override
    public boolean nopassBackbyAc(Map<String, String> map) {

        return backMapper.nopassBackbyAc(map);
    }

    @Override
    public boolean passBackbyMa(Map<String, String> map) {
        return backMapper.passBackbyMa(map);
    }

    @Override
    public boolean nopassBackbyMa(Map<String, String> map) {
        return backMapper.nopassBackbyMa(map);
    }

    @Override
    public boolean changeBackstatenoByMas(Map<String, String> map) {
        return backMapper.changeBackstatenoByMas(map);
    }


}
