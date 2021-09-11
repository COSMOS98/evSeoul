package com.evseoul.biz.repository;

import java.util.List;

import com.evseoul.biz.dto.BoardDTO;
import com.evseoul.biz.dto.Criteria;
import com.evseoul.biz.dto.PostDTO;

public interface InfoMapper {
	
	/** info **/
	public List<BoardDTO> getNewsListPaging(Criteria cri);
	public int getNewsListCnt(Criteria cri);
	public BoardDTO getNewsDetail(BoardDTO dto);
	public int insertNews(BoardDTO dto);
	public int updateNews(BoardDTO dto);
	public int deleteNews(BoardDTO dto);	
	public int updateNewsCnt(BoardDTO dto);
	
	public List<PostDTO> getDictionaryListPaging(Criteria cri);
	public int getDictionaryListCnt(Criteria cri);
	
}
