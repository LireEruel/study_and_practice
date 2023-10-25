package com.ssafy.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/article")
public class BoardController {
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
//	@GetMapping("/write")
//	public String write(@RequestParam Map<String, String> map, Model model) {
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key",  map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "board/write";
//	}
	
	
	@GetMapping("/write")
	public String write(@RequestParam(value = "pgno", required= false, defaultValue= "1")String pgno ,
			@RequestParam(value = "key", required= false, defaultValue= "1")String key, 
			@RequestParam(value = "word", required= false, defaultValue= "")String word,
			Model model
	){
		model.addAttribute("pgno", pgno);
		model.addAttribute("key", key);
		model.addAttribute("word", word);
		return "board/write";
	}
	
	
	
	@PostMapping("/write")
	public String write(BoardDto boardDto, HttpSession session, RedirectAttributes redirectAttributes, Map<String,String> map) throws Exception {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		boardDto.setUserId(memberDto.getUserId());
		logger.debug("write boardDto : {} {}", boardDto, map);
		boardService.writeArticle(boardDto);
		redirectAttributes.addAttribute("pgno", map.get("pgno"));
		redirectAttributes.addAttribute("key", map.get("key"));
		redirectAttributes.addAttribute("word", map.get("word"));
		return "redirect:/article/list";
	}
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map)throws Exception {
		List<BoardDto> list = boardService.listArticle(map);
		PageNavigation pageNavigation = boardService.makePageNavigation(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("articles", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("board/list");
		return mav;
	}
}
