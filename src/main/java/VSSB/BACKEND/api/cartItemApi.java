package VSSB.BACKEND.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VSSB.BACKEND.data.cartItem.domainObject.CartItemDetailData;
import VSSB.BACKEND.data.cartItem.dto.response.CartItemResponseDto;
import VSSB.BACKEND.data.cartItem.dto.response.SuccessResponseDto;
import VSSB.BACKEND.service.CartItemService;

@RestController
@RequestMapping("/cart")

public class cartItemApi {
    private CartItemService cartItemService;

    public cartItemApi(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PutMapping("/{pid}/{quantity}")
    public SuccessResponseDto addCartItem(@PathVariable(name = "pid") int pid, @PathVariable (name = "quantity") int quantity){
        cartItemService.addCartItem(pid, quantity);
        return new SuccessResponseDto();
    }

    @GetMapping
    public List<CartItemResponseDto> getAllCartItem () {
        List<CartItemResponseDto> cartItemResponseDtoList = new ArrayList<>();
        for(CartItemDetailData data : cartItemService.getAllCartItem()){
            cartItemResponseDtoList.add(new CartItemResponseDto(data));
        }
        return cartItemResponseDtoList;
    }

    @PatchMapping("/{pid}/{quantity}")
    public CartItemResponseDto patchCartItemQuantity(@PathVariable(name = "pid") int pid, @PathVariable(name = "quantity") int quantity){
        return new CartItemResponseDto(cartItemService.patchCartItemQuantity(pid, quantity));
    }

    @DeleteMapping("/{pid}")
    public SuccessResponseDto deleteCartItem (@PathVariable(name = "pid") int pid){
        cartItemService.deleteCartItem(pid);
        return new SuccessResponseDto();
    }
}
