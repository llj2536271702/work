package com.jxd.borrow.model;

/**
 * @ClassName BorrowInfo
 * @Description TODO
 * @Author llj
 * @Date 2023/2/2 11:34
 * @Version 1.0
 */

public class BorrowInfo {

    private Integer borrowno;
    private Double money;
    private String reason;
    private String borrowtime;
    private Integer borrowstateno;
    private Integer empno;
    private Integer typeno;
    private String typeinfo;
    private String borrowstateinfo;

    public BorrowInfo(Integer borrowno, Double money, String reason, String borrowtime, Integer borrowstateno, Integer empno, Integer typeno, String typeinfo, String borrowstateinfo) {
        this.borrowno = borrowno;
        this.money = money;
        this.reason = reason;
        this.borrowtime = borrowtime;
        this.borrowstateno = borrowstateno;
        this.empno = empno;
        this.typeno = typeno;
        this.typeinfo = typeinfo;
        this.borrowstateinfo = borrowstateinfo;
    }

    public BorrowInfo() {
    }

    public Integer getBorrowno() {
        return borrowno;
    }

    public void setBorrowno(Integer borrowno) {
        this.borrowno = borrowno;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }

    public Integer getBorrowstateno() {
        return borrowstateno;
    }

    public void setBorrowstateno(Integer borrowstateno) {
        this.borrowstateno = borrowstateno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Integer getTypeno() {
        return typeno;
    }

    public void setTypeno(Integer typeno) {
        this.typeno = typeno;
    }

    public String getTypeinfo() {
        return typeinfo;
    }

    public void setTypeinfo(String typeinfo) {
        this.typeinfo = typeinfo;
    }

    public String getBorrowstateinfo() {
        return borrowstateinfo;
    }

    public void setBorrowstateinfo(String borrowstateinfo) {
        this.borrowstateinfo = borrowstateinfo;
    }

    @Override
    public String toString() {
        return "BorrowInfo{" +
                "borrowno=" + borrowno +
                ", money=" + money +
                ", reason='" + reason + '\'' +
                ", borrowtime='" + borrowtime + '\'' +
                ", borrowstateno=" + borrowstateno +
                ", empno=" + empno +
                ", typeno=" + typeno +
                ", typeinfo='" + typeinfo + '\'' +
                ", borrowstateinfo='" + borrowstateinfo + '\'' +
                '}';
    }
}
