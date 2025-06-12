package com.example.product.dto;

import com.example.product.dao.ProductDao;
import com.example.product.model.data.ProductData;
import com.example.product.model.form.ProductForm;
import com.example.product.pojo.ProductPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDto {
    @Autowired
    private ProductDao dao;

    public void addProduct(ProductForm form) {
        ProductPojo addPojo = DtoHelper.convertPojoToForm(form);
        if(!dao.existsById(form.getSkuId())) {
            dao.insert(addPojo);
        }
    }

    public List<ProductData> getAllProduct() {
        List<ProductPojo> pojoList = dao.findAll();
        return DtoHelper.convertPojoToDataList(pojoList);
    }

    public ProductData getProductById(String id) {
        Optional<ProductPojo> pojo = dao.findById(id);
        if(pojo.isPresent())
            return DtoHelper.convertPojoToData(pojo.get());
        return null;
    }
}
