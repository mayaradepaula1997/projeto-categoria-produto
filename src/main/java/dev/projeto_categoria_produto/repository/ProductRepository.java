package dev.projeto_categoria_produto.repository;

import dev.projeto_categoria_produto.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
