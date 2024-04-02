package VSSB.BACKEND.data.cartItem.dto.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import VSSB.BACKEND.data.cartItem.domainObject.CartItemDetailData;


public class CartItemResponseDto {
    private Integer pid;
    private String name;
    @JsonProperty("image_url")
    private String imageUrl;
    private BigDecimal price;
    @JsonProperty("cart_quantity")
    private Integer quantity;
    
    public CartItemResponseDto(CartItemDetailData data) {
        this.pid = data.getProduct().getPid();
        this.name = data.getProduct().getName();
        this.imageUrl = data.getProduct().getImageUrl();
        this.price = data.getProduct().getPrice();
        this.quantity = data.getQuantity();
    }

    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
}



