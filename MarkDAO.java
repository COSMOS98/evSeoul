package com.evseoul.biz.mark;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MarkDAO {
	private SqlSession mybatis;

	public MarkDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionIntance();
	}

	public void insertMark(MarkVO vo) {
		mybatis.insert("MarkDAO.insertMark", vo);
		mybatis.commit();
	}

	public List<MarkVO> getMarkList(MarkVO vo) {
		return mybatis.selectList("MarkDAO.getMarkList", vo);
	}

	public List<MarkVO> getMark(String getMark) {
		return mybatis.selectList("MarkDAO.getMark", getMark);
	}

	public List<MarkVO> getMapDetail(int NO) {
		return mybatis.selectList("MarkDAO.getMapDetail", NO);
	}

}