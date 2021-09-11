package com.evseoul.biz.repository;

import java.util.List;

import com.evseoul.biz.dto.BoardDTO;
import com.evseoul.biz.dto.Criteria;
import com.evseoul.biz.dto.PostDTO;

public interface CustomerMapper {
	
	/** customer **/
	public List<BoardDTO> getNoticeListPaging(Criteria cri);
	public int getNoticeListCnt(Criteria cri);	
	public BoardDTO getNoticeDetail(BoardDTO dto);
	public int insertNotice(BoardDTO dto);
	public int updateNotice(BoardDTO dto);
	public int deleteNotice(BoardDTO dto);
	public int updateNoticeCnt(BoardDTO dto);
	
	public List<PostDTO> getFaqListPaging(Criteria cri);
	public int getFaqListCnt(Criteria cri);	

}
