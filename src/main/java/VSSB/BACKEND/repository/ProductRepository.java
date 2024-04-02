package VSSB.BACKEND.repository;

import org.springframework.data.repository.CrudRepository;

import VSSB.BACKEND.data.product.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
    
}
