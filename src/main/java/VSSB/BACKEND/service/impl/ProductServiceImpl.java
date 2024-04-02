package VSSB.BACKEND.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import VSSB.BACKEND.data.product.domainObject.ProductDetailData;
import VSSB.BACKEND.data.product.entity.ProductEntity;
import VSSB.BACKEND.exception.product.ProductNotFoundException;
import VSSB.BACKEND.repository.ProductRepository;
import VSSB.BACKEND.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDetailData> getAllProduct(){
        List<ProductDetailData> productDetailDataList = new ArrayList<>();

        for(ProductEntity entity: productRepository.findAll()){
            productDetailDataList.add(new ProductDetailData(entity));
        }

        return productDetailDataList;
    }

    @Override
    public ProductDetailData getProductByPid(Integer pid){
        return new ProductDetailData(getEntityByPid(pid));
    }

    @Override
    public ProductEntity getEntityByPid(Integer pid){
        return productRepository.findById(pid).orElseThrow(ProductNotFoundException::new);
    }
}
