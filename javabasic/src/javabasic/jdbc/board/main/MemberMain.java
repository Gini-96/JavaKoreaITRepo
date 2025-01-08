package javabasic.jdbc.board.main;


import javabasic.jdbc.board.service.MemberService;
import javabasic.jdbc.board.service.impl.MemberServiceImpl;

public class MemberMain {

	public static void main(String[] args) {
		
		MemberService memberService = new MemberServiceImpl();
		
		
//		System.out.println(memberService.listMember());
		
//		System.out.println(memberService.getMember("HONG"));
		
//		memberService.registMember(new Member("JANG","JANG","장보고",null,null));
		
//		memberService.modifyMember(new Member("JANG","JANG","장보구옴",null,"N"));
		
		memberService.removeMember("JANG");
	
		
	}// main
	
}// class
