package dev.projeto_categoria_produto.service;

import dev.projeto_categoria_produto.domain.category.Category;
import dev.projeto_categoria_produto.domain.category.CategoryDTO;
import dev.projeto_categoria_produto.domain.category.CategoryNotFoundException;
import dev.projeto_categoria_produto.domain.product.Product;
import dev.projeto_categoria_produto.domain.product.ProductDTO;
import dev.projeto_categoria_produto.domain.product.ProductNotFoundException;
import dev.projeto_categoria_produto.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;


    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }


    public Product insert(ProductDTO productDTO) {
        categoryService.findById(productDTO.categoryId()).orElseThrow();
        Product product = new Product(productDTO);

        productRepository.save(product);

        return product;
    }


    public List<Product> findAlll() {
        return productRepository.findAll();
    }


    public Product update(Long id, ProductDTO productDTO) {

        Product existingProduct = productRepository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Produto não encontrado com o ID: " + id));

        categoryService.findById(productDTO.categoryId()).orElseThrow(() ->
                new CategoryNotFoundException("Categoria não existe"));

        if (!productDTO.title().isEmpty()) existingProduct.setTitle(productDTO.title());
        if (!productDTO.description().isEmpty()) existingProduct.setDescription(productDTO.description());
        if (productDTO.price() != null) existingProduct.setPrice(productDTO.price());
        if (!(productDTO.categoryId() == null)) existingProduct.setCategory(productDTO.categoryId());

        productRepository.save(existingProduct);

        return existingProduct;

    }

    public void delete(Long id){
        Product product = productRepository.findById(id).orElseThrow(()->
                new ProductNotFoundException("Esse produto não existe"));

        productRepository.delete(product);

    }


}






















