package fr.ldnr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ldnr.entities.Article;


public interface ArticleRepository extends JpaRepository<Article, Long> {
	public List<Article> findByBrand(String brand);
}
