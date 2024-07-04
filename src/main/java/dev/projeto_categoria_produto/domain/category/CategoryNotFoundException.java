package dev.projeto_categoria_produto.domain.category;

public class CategoryNotFoundException extends  RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
