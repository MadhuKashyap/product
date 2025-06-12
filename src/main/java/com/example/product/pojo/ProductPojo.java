package com.example.product.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
@Getter
@Setter
public class ProductPojo {
    @Id
    private String skuId;
    private String name;
    private Double price;
    private String category;

}
