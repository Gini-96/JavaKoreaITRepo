package javabasic.jdbc.board.main;

import javabasic.jdbc.board.service.ReplyService;
import javabasic.jdbc.board.service.impl.ReplyServiceImpl;

public class ReplyMain {

	public static void main(String[] args) {
		
		ReplyService replyService = new ReplyServiceImpl();
		
//		System.out.println(replyService.listReply());

//		System.out.println(replyService.getReply(1));
		
//		replyService.registReply(new Reply(0,"작성된댓글",null,null,"HONG",1));

//		replyService.modifyReply(new Reply(21,"작성고수정된댓글",null,"N",null,0));
		
		replyService.removeReply(21);
		
	}
	
}
