package com.example.product.dto;

import com.example.product.model.data.InventoryData;
import com.example.product.model.data.ProductData;
import com.example.product.model.form.ProductForm;
import com.example.product.pojo.InventoryPojo;
import com.example.product.pojo.ProductPojo;

import java.util.ArrayList;
import java.util.List;

public class DtoHelper {
    public static ProductPojo convertPojoToForm(ProductForm form) {
        ProductPojo pojo = new ProductPojo();
        pojo.setSkuId(form.getSkuId());
        pojo.setName(form.getName());
        pojo.setPrice(form.getPrice());
        return pojo;
    }

    public static List<ProductData> convertPojoToDataList(List<ProductPojo> pojoList) {
        List<ProductData> dataList = new ArrayList<>();
        for (ProductPojo pojo : pojoList) {
            ProductData data = new ProductData();
            data.setSkuId(pojo.getSkuId());
            data.setName(pojo.getName());
            data.setPrice(pojo.getPrice());
            data.setCategory(pojo.getCategory());
            dataList.add(data);
        }
        return dataList;
    }

    public static ProductData convertPojoToData(ProductPojo pojo) {
        ProductData data = new ProductData();
        data.setSkuId(pojo.getSkuId());
        data.setName(pojo.getName());
        data.setPrice(pojo.getPrice());
        data.setCategory(pojo.getCategory());
        return data;
    }

    public static InventoryData convertInventoryPojoToData(InventoryPojo pojo) {
        InventoryData data = new InventoryData();
        data.setSkuId(pojo.getSkuId());
        data.setQty(pojo.getQty());
        return data;
    }
}
