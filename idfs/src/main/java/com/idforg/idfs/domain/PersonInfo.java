package com.idforg.idfs.domain;

public class PersonInfo{
    /** 身份证号 */
    private String people_id;

    /** 姓名 */
    private String name;

    /** 性别 */
    private char sex;

    /** 手机号码 */
    private String phoneNumber;

    /** 健康状态 */
    private char status;

    /** 归属地编码 */
    private String ancestors;

    /** 住址 */
    private String address;

    public String getPeople_id() {
        return people_id;
    }

    public void setPeople_id(String people_id) {
        this.people_id = people_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
