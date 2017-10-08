package org.fkit.domain;

import java.io.Serializable;

public class User implements Serializable {
	private Integer id;		//id 主键
	private String name;	//姓名
	private String sex;		//性别
	private String description;		//描述
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", description=" + description + "]";
	}
	
}
