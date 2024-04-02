package VSSB.BACKEND.service;

import java.util.List;

import VSSB.BACKEND.data.cartItem.domainObject.CartItemDetailData;

public interface CartItemService {
    public void addCartItem(int pid, int quantity);
    public List<CartItemDetailData> getAllCartItem();
    public CartItemDetailData patchCartItemQuantity(int pid, int quantity);
    public void deleteCartItem(int pid);
}
