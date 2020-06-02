package com.talentnxg.talentnxgapi.response;

public class DefaultResponse {
	private Integer code;
	private String status;
	
	
	private Object data;
	
	public DefaultResponse() {}
	
	public DefaultResponse(Integer code, String status,Object data) {
		this.code= code;
		this.status=status;
		this.data=data;
	}
		
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
