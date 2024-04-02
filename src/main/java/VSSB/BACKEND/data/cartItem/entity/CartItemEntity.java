package VSSB.BACKEND.data.cartItem.entity;

import VSSB.BACKEND.data.product.entity.ProductEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    @ManyToOne
    @JoinColumn(name = "pid", nullable = false)
    private ProductEntity product;
    @Column(nullable = false)
    private Integer quantity;
    
    public CartItemEntity() {
    }

    
    public CartItemEntity(ProductEntity product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }


    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public ProductEntity getProduct() {
        return product;
    }
    public void setProduct(ProductEntity product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    

}
