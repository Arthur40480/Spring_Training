package fr.ldnr.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ldnr.entities.Category;



public interface CategoryRepository  extends JpaRepository<Category, Long>{
	public Optional<Category> findByName(String categoryName);
	public List<Category> findAllByOrderByNameAsc();
	public List<Category> findAllByOrderByNameDesc();
}
