package VSSB.BACKEND.data.product.dto.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import VSSB.BACKEND.data.product.domainObject.ProductDetailData;

public class GetAllProductResponseDto {
    private Integer pid;
    private String name;
    @JsonProperty("image_url")
    private String imageUrl;
    private BigDecimal price;
    @JsonProperty("has_stock")
    private boolean hasStock;
    
    public GetAllProductResponseDto(ProductDetailData data) {
        this.pid = data.getPid();
        this.name = data.getName();
        this.imageUrl = data.getImageUrl();
        this.price = data.getPrice();
        setHasStock(data.getStock());
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
    public boolean isHasStock() {
        return hasStock;
    }
    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }

    public void setHasStock(Integer stock) {
        this.hasStock = stock > 0;
    }

}
