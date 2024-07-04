package dev.projeto_categoria_produto.domain.product;

public class ProductNotFoundException  extends  RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
