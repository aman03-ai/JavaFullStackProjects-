package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "utable")
public class UserEntity {
	@Id
	@Column
	private int id;
	@Column
	private String uname;
	@Column
	private String pass;
	@Column
	private long contact;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(int id, String uname, String pass, long contact) {
		super();
		this.id = id;
		this.uname = uname;
		this.pass = pass;
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", uname=" + uname + ", pass=" + pass + ", contact=" + contact + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

}
