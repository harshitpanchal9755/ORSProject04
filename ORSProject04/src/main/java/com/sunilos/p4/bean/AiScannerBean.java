package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AiScannerBean extends BaseBean {

	private long id;
	private String name;
	private String type;
	private String description;
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		try {
			this.setName(rs.getString("name"));
			this.setType(rs.getString("type"));
			this.setDescription(rs.getString("description"));
			this.setStatus(rs.getString("status"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
