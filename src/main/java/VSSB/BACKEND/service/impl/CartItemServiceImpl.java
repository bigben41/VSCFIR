package VSSB.BACKEND.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import VSSB.BACKEND.data.cartItem.domainObject.CartItemDetailData;
import VSSB.BACKEND.data.cartItem.entity.CartItemEntity;
// import VSSB.BACKEND.data.product.entity.ProductEntity;
import VSSB.BACKEND.exception.cartItem.CartItemNotFoundException;
import VSSB.BACKEND.repository.CartItemRepository;
import VSSB.BACKEND.service.CartItemService;
import VSSB.BACKEND.service.ProductService;

@Service
public class CartItemServiceImpl implements CartItemService {
    private CartItemRepository cartItemRepository;
    private ProductService productService;

    public CartItemServiceImpl(CartItemRepository cartItemRepository, ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
    }

    @Override
    public void addCartItem(int pid, int quantity){
        if(existsByPid(pid)){
            CartItemEntity cartItemEntity = getEntityByPid(pid);
            cartItemEntity.setQuantity(cartItemEntity.getQuantity() + quantity);
            cartItemRepository.save(cartItemEntity);
        } else {
            // ProductEntity productEntity = productService.getEntityByPid(pid);
            // CartItemEntity cartItemEntity = new CartItemEntity(productEntity, quantity);
            // cartItemRepository.save(cartItemEntity);
            
            cartItemRepository.save(new CartItemEntity(productService.getEntityByPid(pid), quantity));
        }
    }

    @Override
    public List<CartItemDetailData> getAllCartItem(){
        List<CartItemDetailData> cartItemDetailDataList = new ArrayList<>();
        for (CartItemEntity entity: cartItemRepository.findAll()){
            cartItemDetailDataList.add(new CartItemDetailData(entity));
        }
        return cartItemDetailDataList;
    }

    @Override
    public CartItemDetailData patchCartItemQuantity(int pid, int quantity) {       
        CartItemEntity cartItemEntity = getEntityByPid(pid);
        cartItemEntity.setQuantity(quantity);
                   
        return new CartItemDetailData(cartItemRepository.save(cartItemEntity));
    }

    @Override
    public void deleteCartItem(int pid){
        cartItemRepository.delete(getEntityByPid(pid));        
    }

    public boolean existsByPid (Integer pid) {
        return cartItemRepository.existsByProduct_pid(pid);
    }

    public CartItemEntity getEntityByPid (Integer pid){
        return cartItemRepository.findByProduct_pid(pid).orElseThrow(CartItemNotFoundException::new);
    }
}
