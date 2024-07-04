package dev.projeto_categoria_produto.service;

import dev.projeto_categoria_produto.domain.category.Category;
import dev.projeto_categoria_produto.domain.category.CategoryDTO;
import dev.projeto_categoria_produto.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category insert(CategoryDTO categoryDTO){
        Category newcategory = new Category();

        newcategory.setTitle(categoryDTO.title());
        newcategory.setDescription(categoryDTO.description());

        return categoryRepository.save(newcategory);

    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(String id){
        return categoryRepository.findById(id);
    }


    public Category update(String id, CategoryDTO categoryDTO) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);  //Buscar a categoria pelo id
        //E verificar se ela existe

        if (optionalCategory.isPresent()) { //Se categoria for encontrada
            Category category = optionalCategory.get();


            if (!categoryDTO.title().isEmpty()) { // Atualizar o campo title se não estiver vazio
                category.setTitle(categoryDTO.title());
            }

            if (!categoryDTO.description().isEmpty()) {
                category.setDescription(categoryDTO.description());
            }

            return categoryRepository.save(category); // Salvar a categoria atualizada no repositório


        } else {
            throw new EntityNotFoundException("Categoria não encontreda com id: " + id);
        }
    }


    public void delete (String id){
        Optional<Category> deleteCategory = categoryRepository.findById(id);
        if(deleteCategory.isPresent()){
            categoryRepository.delete(deleteCategory.get());

        }else {
            throw new EntityNotFoundException("Categoria não encontreda com id: " + id);

        }

    }
}