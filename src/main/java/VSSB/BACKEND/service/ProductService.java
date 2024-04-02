package VSSB.BACKEND.service;

import java.util.List;

import VSSB.BACKEND.data.product.domainObject.ProductDetailData;
import VSSB.BACKEND.data.product.entity.ProductEntity;

public interface ProductService {
    public List<ProductDetailData> getAllProduct();
    public ProductDetailData getProductByPid(Integer pid);
    public ProductEntity getEntityByPid(Integer pid);
}
