package com.evseoul.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evseoul.biz.mark.MarkDAO;
import com.evseoul.biz.mark.MarkVO;
import com.evseoul.biz.service.MarkMapper;
import com.evseoul.biz.service.MarkRepository;
import com.evseoul.biz.service.MarkService;

@Controller
public class StationController {
	@Autowired
	MarkService service;
	MarkDAO dao;

	@Autowired
	MarkRepository repo;
	MarkMapper mapper;

	@RequestMapping(value = { "/index", "/getIndex.do", " " })
	public String get_List2(Model model) {
		MarkVO vo = new MarkVO();

		System.out.println("호출 되고 있는지 확인");

		model.addAttribute("list", service.getMarkList(vo));

		System.out.println("Controller vo" + vo);
		System.out.println("Controller Service" + service.getMarkList(vo));
		System.out.println(model);
		return "index";
	}

	@RequestMapping("/list")
	public String get_List(Model model) {
		MarkVO vo = new MarkVO();

		model.addAttribute("list", service.getMarkList(vo));

		System.out.println("Controller vo" + vo);
		System.out.println("Controller Service" + service.getMarkList(vo));
		return "list";
	}

	@RequestMapping("getMapDetail.do")
	public String getMapDetail(int NO, MarkVO vo, Model model) {
		System.out.println("controller getMapDetail : " + NO);

		List<MarkVO> list = service.getMapDetail(NO);

		System.out.println("찾은 데이터 : " + list.get(0).getNo());

		model.addAttribute("list", list);

		return "detail";
	}

	@RequestMapping("getMark.do")
	public String getMark(MarkVO vo, Model model, String getMark) {
		System.out.println("선택값 : " + getMark);
		List<MarkVO> list = repo.getMark(getMark);

		// 여기서 Mapper에 vo를 넘긴 이유가 있었던 건가요?
		// 아니요...제가 스프링을 잘 이해를 못해서 다른것들을 보고 했는데 아하!
		// 넵 자 여기서는 getMark값이 사용자가 웹상에서 선택한 값이죠?넵
		// 넵 그러면 우리가 mapping.xml에 넘길려면 사용자가 선택한 값을 넘겨야 해요
		// 그러면 지금 mapper.getMark 라는 메소드는 저 데이터를 처리할수 없으니까 데이터형을 변경해주어야 하구요
		// 흠.. 지금 스프링 구조가 조금 이상하게 되어있네요 이것들 지금 변경하면 너무 시간이 걸리니까 데이터 처리만 도와드릴께요넵

		System.out.println("찾은 데이터 : " + list.get(0));
		model.addAttribute("list2", list);
		try {

			// model.addAttribute("list", mapper.getMark(vo));
		} catch (Exception e) {
			System.out.println("addattribute err : " + e.getMessage());
		}

		return "list";
	}

}
