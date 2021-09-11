package com.evseoul.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evseoul.biz.dto.BoardDTO;
import com.evseoul.biz.dto.Criteria;
import com.evseoul.biz.dto.PageDTO;
import com.evseoul.biz.repository.CustomerRepository;

@Controller
public class CustomerController {
	@Autowired
	CustomerRepository repo;
	
	public CustomerController() {
	}
	
	/** customer **/
	@RequestMapping(value = "/getNotice.do", method = RequestMethod.GET)
	 public String getNoticeListPaging(Criteria cri, Model model) {
		 model.addAttribute("noticeList", repo.getNoticeListPaging(cri)); 
		 model.addAttribute("pageMaker", new PageDTO(cri, repo.getNoticeListCnt(cri))); 		 
		 return "customer/notice";
	 }
	
	@RequestMapping(value = "/getNoticeDetail.do", method = RequestMethod.GET)
	public String getNoticeDetail(BoardDTO dto, Model model) {
		repo.updateNoticeCnt(dto);
		model.addAttribute("notice", repo.getNoticeDetail(dto)); 
		return "customer/noticeDetail";  
	}
	
	@RequestMapping(value = "/getNoticeInsertForm.do", method = RequestMethod.GET)
	public String getNoticeInsertForm() {
		return "customer/noticeWrite";  
	}
	
	@RequestMapping(value = "/insertNotice.do", method = RequestMethod.POST)
	public String insertNotice(BoardDTO dto) {
		repo.insertNotice(dto); 
		return "redirect:/getNotice.do";
	}
	
	@RequestMapping(value = "/getNoticeUpdateForm.do", method = RequestMethod.GET)
	public String getNoticeUpdateForm(BoardDTO dto, Model model) {
		model.addAttribute("notice", repo.getNoticeDetail(dto));
		return "customer/noticeUpdate";  
	}
	
	@RequestMapping(value = "/updateNotice.do", method = RequestMethod.POST)
	public String updateNotice(BoardDTO dto) {
		repo.updateNotice(dto);
		return "redirect:/getNotice.do"; 
	}
	
	@RequestMapping(value = "/deleteNotice.do", method = RequestMethod.GET)
	public String deleteNotice(BoardDTO dto) {
		repo.deleteNotice(dto); 
		return "redirect:/getNotice.do";
	}
	
	// FAQ
	@RequestMapping(value = "/getFaqList.do", method = RequestMethod.GET)
	 public String getFaqListPaging(Criteria cri, Model model) {
		model.addAttribute("faq", repo.getFaqListPaging(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, repo.getFaqListCnt(cri))); 		 
		return "customer/faq";
	 }
	
}
