package com.jxd.borrow.model;

/**
 * 普通员工和所有员工
 */

public class Emp {
    private Integer empno;
    private String name;//用

    // 户的登录名
    private String ename;//用户真实姓名
    private String job;
    private String  hiredate;
    private Integer deptno ;
    private String sex;
    private Integer limits;//1 2 3 4 权限，区分是管理员，员工，财务，部门领导
    private String  password;
    private Integer state;//1 有借款未还或者有待审核的东西，0 没有
    private String phone;
    private String idnumber;

    public Emp() {
    }

    public Emp(Integer empno, String name, String ename, String job, String hiredate, Integer deptno, String sex, Integer limits, String password, Integer state, String phone, String idnumber) {
        this.empno = empno;
        this.name = name;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.deptno = deptno;
        this.sex = sex;
        this.limits = limits;
        this.password = password;
        this.state = state;
        this.phone = phone;
        this.idnumber = idnumber;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", name='" + name + '\'' +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", deptno=" + deptno +
                ", sex='" + sex + '\'' +
                ", limits=" + limits +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", phone='" + phone + '\'' +
                ", idnumber='" + idnumber + '\'' +
                '}';
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getLimits() {
        return limits;
    }

    public void setLimits(Integer limits) {
        this.limits = limits;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }
}
