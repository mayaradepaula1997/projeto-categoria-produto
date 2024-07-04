package dev.projeto_categoria_produto.repository;

import dev.projeto_categoria_produto.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
