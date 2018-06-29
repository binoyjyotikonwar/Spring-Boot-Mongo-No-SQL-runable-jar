package com.exp.user.model;
import com.exp.user.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	String msg;
	
	@JsonView(Views.Public.class)
	String code;

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	
}
