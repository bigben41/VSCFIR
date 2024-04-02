package VSSB.BACKEND.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VSSB.BACKEND.data.product.domainObject.ProductDetailData;
import VSSB.BACKEND.data.product.dto.response.GetAllProductResponseDto;
import VSSB.BACKEND.data.product.dto.response.ProductDetailResponseDto;
import VSSB.BACKEND.service.ProductService;

@RestController
@RequestMapping("/public/product")
public class productApi {
    private ProductService productService;

    
    public productApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<GetAllProductResponseDto> getAllProduct(){
        List<GetAllProductResponseDto> responseDtoList = new ArrayList<>();
        
        for(ProductDetailData data : productService.getAllProduct()){
            responseDtoList.add(new GetAllProductResponseDto(data));
        }

        return responseDtoList;
    }

    @GetMapping("/{id}")
    public ProductDetailResponseDto getProductByPid (@PathVariable(name = "id") Integer pid){
        return new ProductDetailResponseDto(productService.getProductByPid(pid));
    }
}
