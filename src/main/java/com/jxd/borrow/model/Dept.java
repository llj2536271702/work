package com.jxd.borrow.model;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author llj
 * @Date 2023/1/29 17:46
 * @Version 1.0
 */

public class Dept {
    private Integer deptno;
    private String deptname;
    private String createtime;

    public Dept(Integer deptno, String deptname, String createtime) {
        this.deptno = deptno;
        this.deptname = deptname;
        this.createtime = createtime;
    }

    public Dept() {
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", deptname='" + deptname + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
