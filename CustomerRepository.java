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
public class CustomerRepository {
	@Autowired
	SqlSession sqlsession;
	
	public CustomerRepository() {
	}
	
	/** customer **/
	public List<BoardDTO> getNoticeListPaging(Criteria cri) {
		List<BoardDTO> result = new ArrayList<BoardDTO>();
		CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
		try {
			result = mapper.getNoticeListPaging(cri);
		} catch (Exception e) {
			System.out.println("getNoticeListPaging ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	public int getNoticeListCnt(Criteria cri) {
		int result = 0;
		CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
		try {
			result = mapper.getNoticeListCnt(cri);
		} catch (Exception e) {
			System.out.println("getNoticeListCnt ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	public BoardDTO getNoticeDetail(BoardDTO dto) {
		BoardDTO result = null;
		CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
		try {
			result = mapper.getNoticeDetail(dto);
		} catch (Exception e) {
			System.out.println("getNoticeDetail ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	public int insertNotice(BoardDTO dto) {
		int result = 0;
		CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
		try {
			result = mapper.insertNotice(dto);
		} catch (Exception e) {
			System.out.println("insertNotice ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	public int updateNotice(BoardDTO dto) {
		int result = 0;
		CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
		try {
			result = mapper.updateNotice(dto);	
		} catch (Exception e) {
			System.out.println("updateNotice ERR:" + e.getMessage());
			return result;
		}
		return result;
	}	
	public int deleteNotice(BoardDTO dto) {
		int result = 0;
		CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
		try {
			result = mapper.deleteNotice(dto);	
		} catch (Exception e) {
			System.out.println("deleteNotice ERR:" + e.getMessage());
			return result;
		}
		return result;
	}	
	public int updateNoticeCnt(BoardDTO dto) {
		int result = 0;
		CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
		try {
			result = mapper.updateNoticeCnt(dto);
		} catch (Exception e) {
			System.out.println("updateNoticeCnt ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	
	// FAQ
	public List<PostDTO> getFaqListPaging(Criteria cri) {
		List<PostDTO> result = new ArrayList<PostDTO>();
		CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
		try {
			result = mapper.getFaqListPaging(cri);
		} catch (Exception e) {
			System.out.println("getFaqListPaging ERR:" + e.getMessage());
			return result;
		}
		return result;
	}	
	public int getFaqListCnt(Criteria cri) {
		int result = 0;
		CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
		try {
			result = mapper.getFaqListCnt(cri);
		} catch (Exception e) {
			System.out.println("getFaqListCnt ERR:" + e.getMessage());
			return result;
		}
		return result;
	}
	
}
