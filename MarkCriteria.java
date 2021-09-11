package com.evseoul.biz.mark;

public class MarkCriteria {
	private String keyword="";

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString(){
		return "MarkCriteria [keyword=" + keyword + "]";
	}
}
