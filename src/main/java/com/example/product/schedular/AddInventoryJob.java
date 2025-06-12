package com.example.product.schedular;

import com.example.product.dao.InventoryDao;
import com.example.product.dao.ProductDao;
import com.example.product.pojo.InventoryPojo;
import com.example.product.pojo.ProductPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Objects;


public class AddInventoryJob {

    @Autowired
    private ProductDao dao;

    @Autowired
    private InventoryDao inventoryDao;
    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void runJob() {
        List<ProductPojo> list = dao.findAll();
        for(ProductPojo pojo : list) {
            InventoryPojo inventoryPojo = inventoryDao.findBySkuId(pojo.getSkuId());
            if(Objects.nonNull(inventoryPojo)) {
                    inventoryPojo.setQty(inventoryPojo.getQty() < 10 ? 10 : inventoryPojo.getQty());
            }
        }

    }
}
