package com.evseoul.biz.dto;

import lombok.Data;

@Data
public class PageDTO {
  private final int pageCount=5;
  private int startPage; 
  private int endPage;	
  private boolean prev, next; 

  private int total;
  private Criteria cri;
  
  public PageDTO(Criteria cri, int total) {
	  this.cri=cri;		
      this.total=total; 
      
      this.endPage=(int)(Math.ceil(cri.getPageNum()/(double) pageCount))*pageCount;
      this.startPage=this.endPage-(pageCount-1);
      
      int realEnd=(int)(Math.ceil((total*1.0)/cri.getAmount()));
      
      if (realEnd<=this.endPage) {
        this.endPage=realEnd;	
      }
      
      this.prev=this.startPage>1;
      this.next=this.endPage<realEnd;
  }
  
}