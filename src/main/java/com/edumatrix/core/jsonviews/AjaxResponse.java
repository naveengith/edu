package com.edumatrix.core.jsonviews;

import com.fasterxml.jackson.annotation.JsonView;



public class AjaxResponse {
	
	@JsonView(Views.Public.class)
	String code;
	
	@JsonView(Views.Public.class)
	String msg;
	
	@JsonView(Views.Public.class)
	String content;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "AjaxResponse [code=" + code + ", msg=" + msg + ", content=" + content + "]";
	}

	
}
