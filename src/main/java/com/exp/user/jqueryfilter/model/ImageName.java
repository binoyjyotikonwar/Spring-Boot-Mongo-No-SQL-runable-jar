package com.exp.user.jqueryfilter.model;

public class ImageName {
	
	private String name;
	private String secondname;
	
		
	public ImageName(){}
	
	public ImageName(Long id, String name, Integer age){
		this.name = name;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	/**
	 * @return the secondname
	 */
	public String getSecondname() {
		return secondname;
	}

	/**
	 * @param secondname the secondname to set
	 */
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	@Override
	public String toString() {
		return "Customer {name:" + name + "}";
	}

}