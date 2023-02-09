package com.jxd.borrow.model;


//e.ename,e.name,e.job,e.hiredate,d.deptname,e.idnumber,e.phone
public class EmpInfo {
    private Integer empno;
    private String ename;
    private String name;
    private String job;
    private String hiredate;
    private String deptname;
    private Integer idnumber;
    private String phone;



    public EmpInfo() {
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Integer getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(Integer idnumber) {
        this.idnumber = idnumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public EmpInfo(Integer empno, String ename, String name, String job, String hiredate, String deptname, Integer idnumber, String phone) {
        this.empno = empno;
        this.ename = ename;
        this.name = name;
        this.job = job;
        this.hiredate = hiredate;
        this.deptname = deptname;
        this.idnumber = idnumber;
        this.phone = phone;

    }

    @Override
    public String toString() {
        return "EmpInfo{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", deptname='" + deptname + '\'' +
                ", idnumber=" + idnumber +
                ", phone='" + phone + '\'' +
                '}';
    }
}
