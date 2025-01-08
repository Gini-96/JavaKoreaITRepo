package javabasic.jdbc.board.main;

import javabasic.jdbc.board.service.AfileService;
import javabasic.jdbc.board.service.impl.AfileServiceImpl;

public class AfileMain {

	public static void main(String[] args) {
		
		AfileService afileService = new AfileServiceImpl();
		
//		System.out.println(afileService.listAfile());
		
//		System.out.println(afileService.getAfile(1));
		
//		afileService.registAfile(new Afile(0, "냥서버파일","냥고객파일", null,null,1));

//		afileService.modifyAfile(new Afile(21, "new냥서버파일","new냥고객파일", null,"N",0));
		
		afileService.removeAfile(21);
		
	}
	
}
