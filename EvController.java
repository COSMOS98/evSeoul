package com.evseoul.biz.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evseoul.biz.mark.MarkVO;
import com.evseoul.biz.repository.EvRepository;
import com.evseoul.biz.service.MarkService;

@Controller
public class EvController {
	@Autowired
	EvRepository repo;
	@Autowired
	MarkService service;
	
	public EvController() {
	}
	
	/** index **/
	@RequestMapping(value = "/getIndex.do", method = RequestMethod.GET)
	public String getIndex(Model model) {
		model.addAttribute("noticeList", repo.getIndexNotice());
		MarkVO vo = new MarkVO();		
		model.addAttribute("list", service.getMarkList(vo));
		return "index";  
	}
	
	/** intro **/
	@RequestMapping(value = "/getIntro.do", method = RequestMethod.GET)
	public String getIntro() {
		return "intro/intro";  
	}
	@RequestMapping(value = "/getEffect.do", method = RequestMethod.GET)
	public String getEffect() {
		return "intro/effect";  
	}
	@RequestMapping(value = "/getEvData.do", method = RequestMethod.GET)
	public String getEvData() {
		return "intro/evData";  
	}
	
	
	/** map detail **/	
	@RequestMapping(value = "/getList.do", method = RequestMethod.GET)
	public String getlist() {
		return "list";  
	}

	@ResponseBody
	@RequestMapping(value = "/getPublicData.do", method = RequestMethod.POST)
	public String getPublicData(HttpServletRequest request, HttpServletResponse response, Object command, BindException error) {	
		URL url = null;
		HttpURLConnection con = null;
		StringBuffer req = new StringBuffer();
		StringBuffer ret = new StringBuffer();
		
		try {
			Enumeration<String> keys = request.getParameterNames(); 
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				String val = request.getParameter(key);
				if(key.equalsIgnoreCase("base_url")) {
					req.insert(0, val+"?");
				} else {
					req.append("&"+key+"="+val);
				}
			}
			url = new URL(req.toString());  
			con = (HttpURLConnection)url.openConnection();
			con.setDoOutput(true);
			con.connect();
		} catch(Exception e) {
			System.out.println("getPublicData ERR:" + e.getMessage());
		}
		
		try {
			String strData = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			while ((strData = br.readLine()) != null) {
				ret.append(strData);
			}	
		} catch(Exception e) {
			System.out.println("getPublicData ERR:" + e.getMessage());
		}
		return ret.toString();  
	}
	
}
