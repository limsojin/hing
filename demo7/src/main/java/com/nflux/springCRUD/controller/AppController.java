package com.nflux.springCRUD.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nflux.springCRUD.model.Member;
import com.nflux.springCRUD.services.MemberServices;

@Controller
public class AppController{
	@Autowired
	MemberServices services;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Member>listMember = services.listAll();
		System.out.println(listMember.toString());
		model.addAttribute("ListMember",listMember);
		return "index";
		
	}
	
	@RequestMapping("/newAccount")
	public String newMemberPage() {
		return "newAccount"; 
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String createOrUpdateEmployee(@ModelAttribute Member member ) {
		System.out.println(member.toString());
		services.save(member);
		return "redirect:/"; 
	}
	

	@RequestMapping("edit/{id}")
	public ModelAndView showEditMemberPage(@PathVariable (name="id") Long id) {
		ModelAndView mav = new ModelAndView("edit_member");
		Member member=services.get(id);
		mav.addObject("member",member);
		return mav;
	}
	
	@RequestMapping(value="/success", method=RequestMethod.POST)
	public String saveMember(@ModelAttribute Member member ) {
		services.save(member);
		return "redirect:/";
	}

	@RequestMapping("delete/{id}")
	public String deleteMemberPage(@PathVariable (name="id") Long id) {
		services.delete(id);
		return "redirect:/";
	}
	
}


