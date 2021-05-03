package com.course.server.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StuDto {

    /**
     * id
     */
    @ExcelProperty("学生id")
    private String id;

    /**
     * 名字
     */
    @ExcelProperty("名字")
    private String name;

    /**
     * 身份证号
     */
    @ExcelProperty("身份证号")
    private String idnumber;

    /**
     * 手机号码
     */
    @ExcelProperty("手机号码")
    private String phonenb;

    /**
     * 性别|枚举[StuSexEnum]：REGISTER("B", "男"), FORGET("G", "女")
     */
    @ExcelProperty("性别")
    private String sex;

    /**
     * 地址
     */
    @ExcelProperty("地址")
    private String address;

    /**
     * 年龄
     */
    @ExcelProperty("年龄")
    private String birthnb;

    /**
     * 专业
     */
    @ExcelProperty("专业")
    private String majorid;

    /**
     * 生成时间
     */
    @ExcelProperty("生成时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createAt;

    /**
     * 修改时间
     */
    @ExcelProperty("修改时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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