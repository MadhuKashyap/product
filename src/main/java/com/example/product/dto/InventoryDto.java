package com.example.product.dto;

import com.example.product.dao.InventoryDao;
import com.example.product.model.data.InventoryData;
import com.example.product.pojo.InventoryPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InventoryDto {
    @Autowired
    private InventoryDao dao;

    public List<InventoryData> getInventoryById(List<String> products) throws Exception {
        List<InventoryData> inventoryList = new ArrayList<>();
        for(String skuId : products) {
            InventoryPojo pojo = dao.findBySkuId(skuId);
            if(Objects.nonNull(pojo)) {
                inventoryList.add(DtoHelper.convertInventoryPojoToData(pojo));
            } else {
                throw new Exception("Missing sku : " + skuId);
            }
        }
        return inventoryList;
    }
}
