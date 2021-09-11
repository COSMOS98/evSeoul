package com.evseoul.biz.service;

import java.util.List;

import com.evseoul.biz.mark.MarkVO;

public interface MarkService {
   public List<MarkVO> getMarkList(MarkVO vo);

   public List<MarkVO> getMapDetail(int NO);

}