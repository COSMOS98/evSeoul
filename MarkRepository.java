package com.evseoul.biz.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evseoul.biz.mark.MarkDAO;
import com.evseoul.biz.mark.MarkVO;

@Repository
public class MarkRepository implements MarkMapper {
	@Autowired
	SqlSession sqlsession;

	public MarkRepository() {
	}

	@Override
	public List<MarkVO> getMark(String getMark) {
		MarkDAO dao = new MarkDAO();
		List<MarkVO> list = dao.getMark(getMark);

		return list;
	}

}
