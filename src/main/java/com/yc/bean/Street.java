package com.yc.bean;

public class Street {
	private Integer id;
	private String name;
	private String district_id;
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
	public String getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(String district_id) {
		this.district_id = district_id;
	}
	@Override
	public String toString() {
		return "Street [id=" + id + ", name=" + name + ", district_id="
				+ district_id + "]";
	}

}
