package fr.ldnr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import fr.ldnr.dao.ArticleRepository;
import fr.ldnr.dao.CategoryRepository;
import fr.ldnr.entities.Article;
import fr.ldnr.entities.Category;

@SpringBootApplication
public class SpringShopJpaApplication implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringShopJpaApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception {
//		categoryRepository.save(new Category("Smartphone"));
//		articleRepository.save(new Article("Samsung", "S10", 800));
//		articleRepository.save(new Article("Apple", "18", 8000));		
		for(Article article : articleRepository.findByBrandContainsAndPriceGreaterThan("Sam",250)) {
			System.out.println(article.toString());
		}
	}

}
