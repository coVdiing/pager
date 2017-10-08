package org.fkit.domain;

import java.io.Serializable;

public class User implements Serializable {
	private Integer id;		//id ����
	private String name;	//����
	private String sex;		//�Ա�
	private String description;		//����
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
