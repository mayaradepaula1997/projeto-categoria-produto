package dev.projeto_categoria_produto.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_product")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private String category;

    public Product (){

    }

    public Product(Long id, String title, String description, Integer price,String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product(ProductDTO productDTO) {
        this.title = productDTO.title();
        this.description = productDTO.description();
        this.price = productDTO.price();
        this.category = productDTO.categoryId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
