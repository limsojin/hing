package com.nflux.springCRUD.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nflux.springCRUD.model.Member;
import com.nflux.springCRUD.repository.MemberRepository;
import com.sun.net.httpserver.Authenticator.Result;

@Service
public class MemberServices{
	
	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> listAll(){
		return memberRepository.findAll();
	}
	public Member get(Long id) {
		return memberRepository.findById(id).get();
	}
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	public void save(Member member) {
		Member result = memberRepository.save(member);
        result.toString();	        
	}


}