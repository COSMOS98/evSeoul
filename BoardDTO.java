package com.evseoul.biz.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {	
	private int SEQ = 0;
	private String TITLE = "";
	private String WRITER = "";
	private String CONTENT = "";
	private Date REGDATE = null;
	private int CNT = 0;
	private String REG_DT = "";
	private String REG_TM = "";
	
	public BoardDTO() {
	}

	public String getREG_DT() {
		if(REGDATE != null) {
			SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
			return format.format(REGDATE);
		} else {
			return "";
		}
	}

	public String getREG_TM() {
		if(REGDATE != null) {
			SimpleDateFormat format = new SimpleDateFormat ("HH:mm:ss");
			return format.format(REGDATE);
		} else {
			return "";
		}
	}

}
