package VSSB.BACKEND.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import VSSB.BACKEND.data.cartItem.entity.CartItemEntity;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer>{
    boolean existsByProduct_pid (Integer pid);
    Optional<CartItemEntity> findByProduct_pid (Integer pid);
}
