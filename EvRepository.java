package com.evseoul.biz.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evseoul.biz.dto.BoardDTO;
import com.evseoul.biz.dto.EvDTO;

@Repository
public class EvRepository {
	@Autowired
	SqlSession sqlsession;
	
	public EvRepository() {
	}
	
	public List<BoardDTO> getIndexNotice() {
		List<BoardDTO> result = new ArrayList<BoardDTO>();
		EvMapper mapper = sqlsession.getMapper(EvMapper.class);
		try {
			result = mapper.getIndexNotice();
		} catch (Exception e) {
			System.out.println("getIndexNotice ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	
	public int getMark(EvDTO dto){
		int result=0;
		EvMapper mapper=sqlsession.getMapper(EvMapper.class);
		try{
			result=mapper.getMarkList(dto);
			System.out.println("repository mark" + dto);
			System.out.println("repository result" + result);
		}catch(Exception e){
			System.out.println("getMark ERR : " + e.getMessage());
			return result;
		}
		return result;
	}
	
}
