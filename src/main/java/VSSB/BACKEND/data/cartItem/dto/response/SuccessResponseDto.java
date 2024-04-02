package VSSB.BACKEND.data.cartItem.dto.response;

public class SuccessResponseDto {
    private String result;

    public SuccessResponseDto() {
        setResult();
    }

    public String getResult() {
        return result;
    }

    public void setResult() {
        this.result = "success";
    }

    

}
