package com.evseoul.biz.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evseoul.biz.dto.BoardDTO;
import com.evseoul.biz.dto.Criteria;
import com.evseoul.biz.dto.PostDTO;

@Repository
public class InfoRepository {
	@Autowired
	SqlSession sqlsession;
	
	public InfoRepository() {
	}
	
	/** info **/
	public List<BoardDTO> getNewsListPaging(Criteria cri) {
		List<BoardDTO> result = new ArrayList<BoardDTO>();
		InfoMapper mapper = sqlsession.getMapper(InfoMapper.class);
		try {
			result = mapper.getNewsListPaging(cri);
		} catch (Exception e) {
			System.out.println("getNewsListPaging ERR:" + e.getMessage());
			return result;
		}
		return result;
	}	
	public int getNewsListCnt(Criteria cri) {
		int result = 0;
		InfoMapper mapper = sqlsession.getMapper(InfoMapper.class);
		try {
			result = mapper.getNewsListCnt(cri);
		} catch (Exception e) {
			System.out.println("getNewsListCnt ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	public BoardDTO getNewsDetail(BoardDTO dto) {
		BoardDTO result = null;
		InfoMapper mapper = sqlsession.getMapper(InfoMapper.class);
		try {
			result = mapper.getNewsDetail(dto);
		} catch (Exception e) {
			System.out.println("getNewsDetail ERR:" + e.getMessage());
			return result;
		}
		return result;
	}	
	public int insertNews(BoardDTO dto) {
		int result = 0;
		InfoMapper mapper = sqlsession.getMapper(InfoMapper.class);
		try {
			result = mapper.insertNews(dto);
		} catch (Exception e) {
			System.out.println("insertNews ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	public int updateNews(BoardDTO dto) {
		int result = 0;
		InfoMapper mapper = sqlsession.getMapper(InfoMapper.class);
		try {
			result = mapper.updateNews(dto);	
		} catch (Exception e) {
			System.out.println("updateNews ERR:" + e.getMessage());
			return result;
		}
		return result;
	}	
	public int deleteNews(BoardDTO dto) {
		int result = 0;
		InfoMapper mapper = sqlsession.getMapper(InfoMapper.class);
		try {
			result = mapper.deleteNews(dto);	
		} catch (Exception e) {
			System.out.println("deleteNews ERR:" + e.getMessage());
			return result;
		}
		return result;
	}	
	public int updateNewsCnt(BoardDTO dto) {
		int result = 0;
		InfoMapper mapper = sqlsession.getMapper(InfoMapper.class);
		try {
			result = mapper.updateNewsCnt(dto);
		} catch (Exception e) {
			System.out.println("updateNewsCnt ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	
	// dictionary
	public List<PostDTO> getDictionaryListPaging(Criteria cri) {
		List<PostDTO> result = new ArrayList<PostDTO>();
		InfoMapper mapper = sqlsession.getMapper(InfoMapper.class);
		try {
			result = mapper.getDictionaryListPaging(cri);
		} catch (Exception e) {
			System.out.println("getDictionaryListPaging ERR:" + e.getMessage());
			return result;
		}
		return result;
	}	
	public int getDictionaryListCnt(Criteria cri) {
		int result = 0;
		InfoMapper mapper = sqlsession.getMapper(InfoMapper.class);
		try {
			result = mapper.getDictionaryListCnt(cri);
		} catch (Exception e) {
			System.out.println("getDictionaryListCnt ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	
}
