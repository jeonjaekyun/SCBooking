package com.jm.scbooking.controller.main;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jm.scbooking.model.qa.dto.QaDTO;
import com.jm.scbooking.service.qa.QaService;

@Controller
@RequestMapping("main/QA")
public class QAController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(QAController.class);
	
	@Inject
	QaService qaService;
	
	@RequestMapping("/")
	public String list(Model model) {
		List<QaDTO> list = qaService.list();
		logger.info("QA List : "+list);
		model.addAttribute("list",list);
		return "main/QA";
	}
	
	@RequestMapping(value="/newBoard", method=RequestMethod.GET)
	public String newBoard() {
		return "main/newBoard";
	}
	
	@RequestMapping(value="/newBoard", method=RequestMethod.POST)
	public String newBoardPost(@ModelAttribute QaDTO dto) {
		qaService.newBoard(dto);
		return "redirect:/main/QA/";
	}
	
	@RequestMapping(value="/readBoard")
	public String readBoard(@RequestParam int bno, Model model) {
		logger.info("bno:"+bno);
		model.addAttribute("qaDto",qaService.readBoard(bno));
		return "main/readBoard";
	}
}
