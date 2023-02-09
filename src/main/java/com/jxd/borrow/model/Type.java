package com.jxd.borrow.model;

/**
 * @ClassName Type
 * @Description TODO
 * @Author llj
 * @Date 2023/2/2 14:35
 * @Version 1.0
 */

public class Type {
    private Integer typeno;
    private String typeinfo;

    public Type(Integer typeno, String typeinfo) {

        this.typeno = typeno;
        this.typeinfo = typeinfo;
    }

    public Type() {
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

    @Override
    public String toString() {
        return "Type{" +
                "typeno=" + typeno +
                ", typeinfo='" + typeinfo + '\'' +
                '}';
    }
}
