package com.jxd.borrow.controller;

import com.jxd.borrow.model.*;
import com.jxd.borrow.sevice.IBackService;
import com.jxd.borrow.sevice.IBorrowService;
import com.jxd.borrow.sevice.IDeptService;
import com.jxd.borrow.sevice.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private IBorrowService borrowService;
    @Autowired
    private IBackService backService;
    @Autowired
    private IEmpService iEmpService ;

    //登录
    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody Emp emp){
        System.out.println(emp);
        System.out.println(iEmpService.login(emp.getName(),emp.getPassword()));
        return iEmpService.login(emp.getName(),emp.getPassword());
    }
    //管理员获取所有员工的信息 或者是按条件查询
    @RequestMapping("/list")
    public Map<String, Object> list(@RequestBody Map<String,String> map){
        return iEmpService.getAllEmpInfo(map);
    }

    //管理员获所有部门类型
    @Autowired
    IDeptService deptService;
    @RequestMapping("/deptList")
    public List<Dept> getAllDept(){
        return deptService.getAllDept();
    }

    //管理员获取所有部门信息 或者是搜索
    @RequestMapping("/getAllDeptInfo")
    public Map<String,Object> getAllDeptInfo(@RequestBody Map<String,String> map){

        return deptService.getAllDeptInfo(map);
    }

    //管理员新增员工信息
    @RequestMapping("/addEmp")
    public String add(@RequestBody Emp emp){
        if(iEmpService.add(emp)){
            return "success";
        }else{
            return "false";
        }
    }

    //管理员修改员工信息
    @RequestMapping("/updateEmp")
    public String update(@RequestBody Emp emp){
        if(iEmpService.update(emp)){
            return "success";
        }else{
            return "false";
        }
    }

    //管理员删除员工
    @RequestMapping("/delbatch")
    public String delbatch(@RequestBody List<Integer> empnos){
        if(iEmpService.delbatch(empnos)){
            return  "success";
        }else{
            return "false";
        }
    }

    //管理员增加部门
    @RequestMapping("/addDept")
    public String addDept(@RequestBody Dept dept){
        if(deptService.add(dept)){
            return "success";
        }else{
            return "false";
        }
    }

    //管理员修改部门
    @RequestMapping("/updateDept")
    public String updateDept(@RequestBody Dept dept){
        if(deptService.update(dept)){
            return "success";
        }else{
            return  "false";
        }
    }


    //管理员删除部门
    @RequestMapping("/deleteDept")
    public String deleteDept(@RequestBody Map<String,String> dept){
        String countemp = dept.get("countemp");
        if(!"0".equals(countemp)){
            return "nodelete";
        }else {
            if (deptService.deleteDept(dept)) {
                return "success";
            }else{
                return "false";
            }
        }
    }

    //用户借款 但是没提交
    @RequestMapping("/addBorrow")
    public String addBorrow(@RequestBody Borrow borrow){
        if(borrowService.add(borrow)){
            return "success";
        }else{
            return "false";
        }
    }

    //用户提交借款申请
    //borrowstateno 从1到2 或者从1到3
    @RequestMapping("/submitborrow")
    public String changeBorrowState(@RequestBody Map<String,String>map ){
        String moneystr = map.get("money");
        Integer money = Integer.parseInt(moneystr);
        if(money >= 2000){
            if(borrowService.changeBorrowState(map)){
                return "success";
            }else{
                return "false";
            }
        }else{
            if(borrowService.changeBorrowState02(map)){
                return "success";
            }else{
                return "false";
            }
        }
    }
    //用户修改借款申请
    @RequestMapping("/updateBorrow")
    public String updateBorrow(@RequestBody Borrow borrow){
        if(borrowService.updateBorrow(borrow)){
            return "success";
        }else{
            return "false";
        }
    }
    //上边是用户的借款申请发送

    //部门获取所有的类型信息
    @RequestMapping("/typelist")
    public List<Type> getTypeList(){
        return borrowService.getAllType();

    }

    //borrowlist
    //条件查询员工信息
    @RequestMapping("/borrowlist")
    public Map<String,Object> getAllBorrow(@RequestBody Map<String,String> map){

        return borrowService.getPersonalBorrow(map);

    }


    //用户删除自己的借款记录
    @RequestMapping("/delBorrow")
    public String delBorrow(@RequestBody List<Integer> borrownos){

        if(borrowService.delBorrow(borrownos)){
            return "success";
        }else{
            return "false";
        }
    }
    //用户点击还款，弹出框
    @RequestMapping("/tobackmoney")
    public Map<String,String> tobackmoney(@RequestBody Map<String,String> map){
        return backService.tobackmoney(map);
    }

    //用户向提交还款时
    @RequestMapping("/submitback")
    public String submitback (@RequestBody Map<String,String> map){

        String moneystr = map.get("money");
        Integer money = Integer.parseInt(moneystr);
        if(money >= 2000){ //先向经理提交
            if(backService.changeBackstatenoByMa(map) && borrowService.changeBorrowstatenoByMa(map)){
                //
                return "success";
            }else{
                return "false";
            }
        }else{
            if(backService.changeBackstatenoByAc(map) && borrowService.changeBorrowstatenoByAc(map)){
                return "success";
            }else{
                return "false";
            }
        }


    }

    //部门查询员工借款信息，展示所有借款信息
    @RequestMapping("/borrowAllList")
    public Map<String,Object> borrowAllList(@RequestBody Map<String,String> map ){

        return borrowService.getAllBorrow(map);
    }
    //财务查询员工借款信息，展示所有借款信息
    @RequestMapping("/borrowAllListAc")
    public Map<String,Object> borrowAllListAc(@RequestBody Map<String,String> map ){

        return borrowService.getAllBorrowAc(map);
    }


    //部门查询员工还款信息，展示所有的还款信息
    @RequestMapping("/backAllList")
    public Map<String,Object> getAllBackList(@RequestBody Map<String,String> map){
        return backService.getBackAllList(map);
    }
    //财务查询员工还款信息，展示所有的还款信息
    @RequestMapping("/backAllListAc")
    public Map<String,Object> getAllBackListAc(@RequestBody Map<String,String> map){
        return backService.getBackAllListAc(map);
    }

    //部门审核借款通过
    @RequestMapping("/passborrow")
    public String passBorrowbyMana(@RequestBody Map<String,String> map){
        if(borrowService.passBorrowbyMana(map) ){
          //  backService.addBack(map) ;
        return "success";
        }else{
            return "false";
        }
    }

    //财务审核借款通过  改变两个表的状态
    @RequestMapping("/passborrowac")
    public String passBorrowbyAc(@RequestBody Map<String,String> map){
        int borrowstateno = Integer.parseInt(map.get("borrowstateno"));
        String flag = "false";
        //只需财务审核
        if(borrowstateno == 3){
            //改变borrow表状态，增加一个新的back表
            borrowService.passBorrowbyAc(map);
            backService.addBackByAc(map);
            flag = "success";

        }else if(borrowstateno == 4){
            borrowService.passBorrowbyAc(map);
            backService.addBackByMa(map);
            //改变两个表的状态
            flag = "success";

        }
        return flag;


    }
    //部门审核借款不通过
    @RequestMapping("/nopassborrow")
    public String nopassBorrowbyMana(@RequestBody Map<String,String> map){
        if(borrowService.nopassborrowmoneybyMana(map)){
            return "success";
        }else{
            return "false";
        }
    }
    //财务审核借款不通过
    @RequestMapping("/nopassborrowac")
    public String nopassBorrowbyManaAc(@RequestBody Map<String,String> map){
        System.out.println(map);
        if(borrowService.nopassborrowmoneybyAc(map)){
            return "success";
        }else{
            return "false";
        }
    }
    //部门通过还款,需要改变两个表的状态，而不是新建表
    @RequestMapping("/passback")
    public String passBackbyMana(@RequestBody Map<String ,String> map ){
        if(borrowService.changeBorrowstatenoByMas(map) && backService.changeBackstatenoByMas(map)){
            return "success";
        }else{
            return "false";
        }
    }

    //财务通过还款
    @RequestMapping("/passbackac")
    public String passBackbyAc(@RequestBody Map<String ,String> map ){
        int moneyleft = Integer.parseInt(map.get("moneyleft"));
        int moneycurrent = Integer.parseInt(map.get("moneycurrent"));
        boolean flag = false;
        //全部通过还款
        if(moneyleft == moneycurrent){
            flag = true;
        }
        if(backService.passBackbyAc(map,flag)){
            return "success";
        }
        return "false";
    }

    //部门审核还款不通过
    @RequestMapping("/nopassback")
    public String nopassBack(@RequestBody Map<String,String> map){
        if(backService.nopassBackbyMa(map) && borrowService.nopassBorrowbyMana(map)){
            return "success";
        }
        return "false";
    }
    //财务还款不通过
    @RequestMapping("/nopassbackac")
    public String nopassBackbyAc(@RequestBody Map<String,String> map){
        if(backService.nopassBackbyAc(map) && borrowService.nopassBorrowbyManaAc(map)){
            return "success";
        }
        return "false";

    }
    @RequestMapping("/delBack")
    public String delBack(@RequestBody List<Integer> backnos ){
        if(backService.delBack(backnos)){
            return "success";
        }else{
            return "false";
        }
    }
    ///updateBorrow
    @RequestMapping("/getBorrownos")
    public List<String> getBorrows(@RequestBody Map<String,String> map){
        return borrowService.getBorrows(map);
    }
    @RequestMapping("/getbackbyno")
    public Back getBackbyNo(@RequestBody Map<String,String> map){
        return backService.getBackbyNo(map);

    }
    @RequestMapping("/backList")
    public Map<String,Object> getBackList(@RequestBody Map<String,String> map){
        return backService.getBackList(map);
    }

    //管理员新增用户时 用户名的重名验证

    @RequestMapping("/getallname")
    public List<String> getAllName(){
        return iEmpService.getAllEmpName();
    }

//获取员工info
    @RequestMapping("/getInfo")
    public Map<String,Object> getInfo( Integer empno){
       /* Integer empnos = Integer.parseInt(empno);*/
        return iEmpService.getEmpInfo(empno);

    }
 //员工修改个人信息
    //updateinfo
    @RequestMapping("/updateinfo")
    public String updateinfo(@RequestBody Map<String,String> map){
        if(iEmpService.updateinfo(map)){
            return "success";
        }else{
            return "false";
        }
    }
    @RequestMapping("/setPassword")
    public String setPassword(@RequestBody Map<String,String> map){
        if(iEmpService.setPassword(map)){
            return "success";
        }else{
            return "false";
        }
    }
}
