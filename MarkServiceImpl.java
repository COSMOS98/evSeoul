package com.evseoul.biz.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evseoul.biz.mark.MarkDAO;
import com.evseoul.biz.mark.MarkVO;

@Service
public class MarkServiceImpl implements MarkService {
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<MarkVO> getMarkList(MarkVO vo) {
		MarkDAO dao = new MarkDAO();
		List<MarkVO> list = dao.getMarkList(vo);

		return list;
	}

	@Override
	public List<MarkVO> getMapDetail(int NO) {

		MarkDAO dao = new MarkDAO();
		List<MarkVO> list = dao.getMapDetail(NO);

		return list;
	}

}
