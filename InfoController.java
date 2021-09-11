package com.evseoul.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evseoul.biz.dto.BoardDTO;
import com.evseoul.biz.dto.Criteria;
import com.evseoul.biz.dto.PageDTO;
import com.evseoul.biz.repository.InfoRepository;

@Controller
public class InfoController {
	@Autowired
	InfoRepository repo;

	public InfoController() {
	}

	/** info **/
	@RequestMapping(value = "/getNews.do", method = RequestMethod.GET)
	public String getNewsListPaging(Criteria cri, Model model) {
		model.addAttribute("newsList", repo.getNewsListPaging(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, repo.getNewsListCnt(cri)));
		return "info/news";
	}

	@RequestMapping(value = "/getNewsDetail.do", method = RequestMethod.GET)
	public String getNewsDetail(BoardDTO dto, Model model) {
		repo.updateNewsCnt(dto);
		model.addAttribute("news", repo.getNewsDetail(dto));
		return "info/newsDetail";
	}

	@RequestMapping(value = "/getNewsInsertForm.do", method = RequestMethod.GET)
	public String getNewsInsertForm() {
		return "info/newsWrite";
	}

	@RequestMapping(value = "/insertNews.do", method = RequestMethod.POST)
	public String insertNews(BoardDTO dto) {
		repo.insertNews(dto);
		return "redirect:/getNews.do";
	}

	@RequestMapping(value = "/getNewsUpdateForm.do", method = RequestMethod.GET)
	public String getNewsUpdateForm(BoardDTO dto, Model model) {
		model.addAttribute("news", repo.getNewsDetail(dto));
		return "info/newsUpdate";
	}

	@RequestMapping(value = "/updateNews.do", method = RequestMethod.POST)
	public String updateNews(BoardDTO dto) {
		repo.updateNews(dto);
		return "redirect:/getNews.do";
	}

	@RequestMapping(value = "/deleteNews.do", method = RequestMethod.GET)
	public String deleteNews(BoardDTO dto) {
		repo.deleteNews(dto);
		return "redirect:/getNews.do";
	}

	// dictionary
	@RequestMapping(value = "/getDicList.do", method = RequestMethod.GET)
	public String getDictionaryListPaging(Criteria cri, Model model) {
		model.addAttribute("dictionary", repo.getDictionaryListPaging(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, repo.getDictionaryListCnt(cri)));
		return "info/dictionary";
	}

}
