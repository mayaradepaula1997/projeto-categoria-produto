package dev.projeto_categoria_produto.controller;

import dev.projeto_categoria_produto.domain.product.Product;
import dev.projeto_categoria_produto.domain.product.ProductDTO;
import dev.projeto_categoria_produto.domain.product.ProductNotFoundException;
import dev.projeto_categoria_produto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value ="/api/produtos")
public class ProductController {

    @Autowired
    private ProductService productService;

  @PostMapping
  private ResponseEntity<Product> insert(@RequestBody ProductDTO productDTO){
      Product newProduct = productService.insert(productDTO);
      return ResponseEntity.ok().body(newProduct);
  }



  @GetMapping
    private ResponseEntity<List<Product>> findAll() {
      List<Product> products = productService.findAlll();
      return ResponseEntity.ok().body(products);

  }

  @PutMapping(value = "/{id}")
    private ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
      Product product = productService.update(id, productDTO);
      return ResponseEntity.ok().body(product);
  }


  @DeleteMapping(value = "/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
     productService.delete(id);
     return ResponseEntity.noContent().build();
  }

}
