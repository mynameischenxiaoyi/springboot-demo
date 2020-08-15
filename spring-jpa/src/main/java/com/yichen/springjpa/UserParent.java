package com.yichen.springjpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_user_parent")
public class UserParent implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//strategy=GenerationType.IDENTITY 自增长
    @Column(name="id")
    private Integer id;

    @Column(name="userid")
    private Integer userid;

    @Column(name="father_name")
    private String fatherName;

    @Column(name="mather_name")
    private String matherName;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMatherName() {
        return matherName;
    }

    public void setMatherName(String matherName) {
        this.matherName = matherName;
    }

    @Override
    public String toString() {
        return "UsersParent{" +
                "userid=" + userid +
                ", fatherName='" + fatherName + '\'' +
                ", matherName=" + matherName +
                '}';
    }
}