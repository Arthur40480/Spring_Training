package fr.ldnr;

import java.util.List;
import java.util.Optional;

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
		Category smartphone = categoryRepository.save(new Category("Smartphone"));
//		Category pc = categoryRepository.save(new Category("PC"));
//		Category tablet = categoryRepository.save(new Category("Tablet"));
//		
//		articleRepository.save(new Article("Samsung", "S10", 250, smartphone));
//		articleRepository.save(new Article("Apple", "18", 800, smartphone));
//		articleRepository.save(new Article("Xiaomi", "MI10", 80, smartphone));
//		
//		articleRepository.save(new Article("Samsung", "GalaxyTab", 450, tablet));	
//		articleRepository.save(new Article("Apple", "Ipad", 1200, tablet));	
//		
//		articleRepository.save(new Article("Asus", "R510", 2000, pc));	
		
//		for(Article article: articleRepository.findByCategoryId(Long.valueOf(8))) {
//			System.out.println(article);
//		}
		
// 		EXERCICE 1.2	
//		displayArticleById(Long.valueOf(10));
//		displayAllArticle();
		
// 		EXERCICE 1.3
//		List<Article> articleList = displayArticleByDescriptionAndBrand("Ipad", "Apple");
//		System.out.println(articleList);
		
// 		EXERCICE 1.4
//		deleteArticleById(Long.valueOf(10));
		
// 		EXERCICE 1.5
//		updateArticleById(Long.valueOf(9), new Article("Motorola", "modèle1", 30, smartphone));
		
// 		EXERCICE 1.6
//		displayCategoryByNameAsc();
//		displayCategoryByNameDesc();

		
	}
	
	/**
	 * Renvoi un article via sont ID
	 * @param articleId
	 */
	private void displayArticleById(Long articleId) { 
	    Article article = articleRepository.findById(articleId).orElse(null);
	    if (article != null) {  
	        System.out.println("Article trouvé : " + article);
	    } else {
	        System.out.println("Article non trouvé !");
	    }
	}
	
	private void displayAllArticle() {
		List<Article> articleList = articleRepository.findAll();
		for(Article article : articleList) {
			System.out.println(article);
		}
	}
	
	/**
	 * Renvoi une liste d'Article via leurs description et leurs marque
	 * @param description
	 * @param brand
	 * @return articleList
	 */
	private List<Article> displayArticleByDescriptionAndBrand(String description, String brand) {
		List<Article> articleList = articleRepository.findByDescriptionAndBrand(description, brand);
		if(articleList.isEmpty()) {
			System.out.println("Aucun article trouver");
			return articleList;
		}else {
			return articleList;
			}
		}
	
	/**
	 * Supprime un article via son ID
	 * @param articleId
	 */
	private void deleteArticleById(Long articleId) {
		articleRepository.deleteById(articleId);
	}
	
	/**
	 * Met à jour un article via sont ID
	 * @param articleId
	 * @param updateArticleData
	 */
	private void updateArticleById(Long articleId, Article updateArticleData) {
		Article articleToUpdate = articleRepository.findById(articleId).orElse(null);
		if(articleToUpdate!= null) {
//			articleToUpdate.setDescription(updateArticleData.getDescription());
//			articleToUpdate.setBrand(updateArticleData.getBrand());
//			articleToUpdate.setPrice(updateArticleData.getPrice());
//			articleToUpdate.setCategory(updateArticleData.getCategory());
//			
//			articleRepository.save(articleToUpdate);
			articleRepository.updateArticle(updateArticleData.getDescription(), updateArticleData.getBrand(), updateArticleData.getPrice(), updateArticleData.getCategory().getId(), articleId);
			
			System.out.println("Article mis à jour avec succès :" + articleToUpdate);
		}else {
			System.out.println("Mise à jour impossible, aucun article trouvé");

		}
	}
	
	/**
	 * Affiche les catégory par ordre croissant
	 */
	private void displayCategoryByNameAsc() {
		List<Category> categoryList = categoryRepository.findAllByOrderByNameAsc();
		if(categoryList.isEmpty()) {
			System.out.println("Aucune catégorie");
		}else {
			for(Category category : categoryList) {
				System.out.println(category);
			}
		}
	}
	
	/**
	 * Affiche les catégory par ordre décroissant
	 */
	private void displayCategoryByNameDesc() {
		List<Category> categoryList = categoryRepository.findAllByOrderByNameDesc();
		if(categoryList.isEmpty()) {
			System.out.println("Aucune catégorie");
		}else {
			for(Category category : categoryList) {
				System.out.println(category);
			}
		}
	}
}