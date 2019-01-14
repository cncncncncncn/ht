package com.example.demo.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Student {
private int uid;
private String uname;
@JSONField(format="yyyy-MM-dd")
private Date birth;
private int gradeid;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
public int getGradeid() {
	return gradeid;
}
public void setGradeid(int gradeid) {
	this.gradeid = gradeid;
}

}
