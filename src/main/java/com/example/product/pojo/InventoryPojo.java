package com.example.product.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory")
@Getter
@Setter
public class InventoryPojo {
    @Id
    private long id;
    private String skuId;
    private int qty;
}
