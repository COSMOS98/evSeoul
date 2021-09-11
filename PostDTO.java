package com.evseoul.biz.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PostDTO {
	private int SEQ = 0;
	private String TITLE = "";
	private String CONTENT = "";
	private Date REGDATE = null;
	
	private String SEARCH = "";
	private String KEYWORD = "";
	
	public PostDTO() {
	}

}
