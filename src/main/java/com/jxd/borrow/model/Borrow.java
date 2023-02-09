package com.jxd.borrow.model;

public class Borrow {
    private Integer borrowno;
    private Double money;
    private String reason;
    private String borrowtime;
    private Integer borrowstateno;
    private Integer empno;
    private Integer typeno;
    private String view;

    public Borrow() {
    }

    public Borrow(Integer borrowno, Double money, String reason, String borrowtime, Integer borrowstateno, Integer empno, Integer typeno, String view) {
        this.borrowno = borrowno;
        this.money = money;
        this.reason = reason;
        this.borrowtime = borrowtime;
        this.borrowstateno = borrowstateno;
        this.empno = empno;
        this.typeno = typeno;
        this.view = view;
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

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowno=" + borrowno +
                ", money=" + money +
                ", reason='" + reason + '\'' +
                ", borrowtime='" + borrowtime + '\'' +
                ", borrowstateno=" + borrowstateno +
                ", empno=" + empno +
                ", typeno=" + typeno +
                ", view='" + view + '\'' +
                '}';
    }
}
