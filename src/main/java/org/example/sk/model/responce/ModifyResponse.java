package org.example.sk.model.responce;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ModifyResponse {
    private int statusCode;
    private int current;
}
