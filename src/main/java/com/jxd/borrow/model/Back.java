package com.jxd.borrow.model;


public class Back {
   private Integer backno;//还款编号

    private Double money;//总借款金额
   private String view;//还款审批时的意见
   private String backtime;//本次部分还款时间
   private Integer backstateno;//还款状态
   private Integer empno;
   private Double moneyleft;//剩多少钱没还
   private Double moneycurrent;//本次还多少钱
   private Integer borrowno;

    public Back() {
    }



    public Integer getBackno() {
        return backno;
    }

    public void setBackno(Integer backno) {
        this.backno = backno;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getBacktime() {
        return backtime;
    }

    public void setBacktime(String backtime) {
        this.backtime = backtime;
    }

    public Integer getBackstateno() {
        return backstateno;
    }

    public void setBackstateno(Integer backstateno) {
        this.backstateno = backstateno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Double getMoneyleft() {
        return moneyleft;
    }

    public void setMoneyleft(Double moneyleft) {
        this.moneyleft = moneyleft;
    }

    public Double getMoneycurrent() {
        return moneycurrent;
    }

    public void setMoneycurrent(Double moneycurrent) {
        this.moneycurrent = moneycurrent;
    }

    public Integer getBorrowno() {
        return borrowno;
    }

    public void setBorrowno(Integer borrowno) {
        this.borrowno = borrowno;
    }




    public Back(Integer backno, Double money, String view, String backtime, Integer backstateno, Integer empno, Double moneyleft, Double moneycurrent, Integer borrowno) {
        this.backno = backno;
        this.money = money;
        this.view = view;
        this.backtime = backtime;
        this.backstateno = backstateno;
        this.empno = empno;
        this.moneyleft = moneyleft;
        this.moneycurrent = moneycurrent;
        this.borrowno = borrowno;
    }

    @Override
    public String toString() {
        return "Back{" +
                "backno=" + backno +
                ", money=" + money +
                ", view='" + view + '\'' +
                ", backtime='" + backtime + '\'' +
                ", backstateno=" + backstateno +
                ", empno=" + empno +
                ", moneyleft=" + moneyleft +
                ", moneycurrent=" + moneycurrent +
                ", borrowno=" + borrowno +
                '}';
    }
}
