package dev.projeto_categoria_produto.controller;

import dev.projeto_categoria_produto.domain.category.Category;
import dev.projeto_categoria_produto.domain.category.CategoryDTO;
import dev.projeto_categoria_produto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriyController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryDTO){
        Category newCategory = categoryService.insert(categoryDTO);
        return ResponseEntity.ok().body(newCategory);

    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok().body(categories);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable String id) {
        Optional<Category> category = categoryService.findById(id);
       if(category.isPresent()){
           return ResponseEntity.ok().body(category.get());
       } else {
           return ResponseEntity.notFound().build();

       }
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> update(@PathVariable String id, @RequestBody CategoryDTO categoryDTO){
        Category updateCategory = categoryService.update(id, categoryDTO);
        return ResponseEntity.ok().body(updateCategory);

    }


    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }










}
