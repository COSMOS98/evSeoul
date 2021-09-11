package com.evseoul.biz.repository;

import java.util.List;

import com.evseoul.biz.dto.BoardDTO;
import com.evseoul.biz.dto.EvDTO;

public interface EvMapper {
	public List<BoardDTO> getIndexNotice();
	public int getMarkList(EvDTO dto);
}
