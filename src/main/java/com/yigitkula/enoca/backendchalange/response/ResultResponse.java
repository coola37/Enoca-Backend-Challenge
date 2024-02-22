package com.yigitkula.enoca.backendchalange.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultResponse<T> {
    private T payload;
    private Double totalPrice;
}
