package VSSB.BACKEND.data.cartItem.domainObject;

import VSSB.BACKEND.data.cartItem.entity.CartItemEntity;
import VSSB.BACKEND.data.product.domainObject.ProductDetailData;

public class CartItemDetailData {
    private Integer cid;
    private ProductDetailData product;
    private Integer quantity;
    
    
    public CartItemDetailData(CartItemEntity entity) {
        this.cid = entity.getCid();
        this.product = new ProductDetailData(entity.getProduct());
        this.quantity = entity.getQuantity();
    }

    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDetailData getProduct() {
        return product;
    }

    public void setProduct(ProductDetailData product) {
        this.product = product;
    }
}


