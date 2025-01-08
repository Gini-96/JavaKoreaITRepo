package javabasic.jdbc.board.main;

import javabasic.jdbc.board.service.ArticleService;
import javabasic.jdbc.board.service.impl.ArticleServiceImpl;

public class ArticleMain {

	public static void main(String[] args) {

		ArticleService articleService = new ArticleServiceImpl();
		
//		System.out.println(articleService.listArticle());

//		System.out.println(articleService.getArticle(2));
		
//		articleService.registArticle(new Article(0, "고양이","냐옹이",null,0,0,null,"HONG",1));

//		articleService.modifyArticle(new Article(21, "new고양이","new냐옹이",null,0,0,"N",null,0));
		
		articleService.removeArticle(21);
		
	}
	
}
