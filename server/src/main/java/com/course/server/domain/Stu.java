package com.course.server.domain;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;
/*@ExcelProperty作用是描述设置excel表格的头部*/

public class Stu {
    @ExcelProperty("学生id")
    private String id;

    @ExcelProperty("名字")
    private String name;

    @ExcelProperty("身份证号")
    private String idnumber;
    @ExcelProperty("电话号码")
    private String phonenb;
    @ExcelProperty("性别")
    private String sex;
    @ExcelProperty("地址")
    private String address;
    @ExcelProperty("年龄")
    private String birthnb;
    @ExcelProperty("专业")
    private String majorid;
    @ExcelProperty("生成时间")
    private Date createAt;
    @ExcelProperty("更改时间")
    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPhonenb() {
        return phonenb;
    }

    public void setPhonenb(String phonenb) {
        this.phonenb = phonenb;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthnb() {
        return birthnb;
    }

    public void setBirthnb(String birthnb) {
        this.birthnb = birthnb;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", idnumber=").append(idnumber);
        sb.append(", phonenb=").append(phonenb);
        sb.append(", sex=").append(sex);
        sb.append(", address=").append(address);
        sb.append(", birthnb=").append(birthnb);
        sb.append(", majorid=").append(majorid);
        sb.append(", createAt=").append(createAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append("]");
        return sb.toString();
    }
}