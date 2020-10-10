package com.example.demo.domain.bi;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private ResponseHead head;

    private T body;

}
