package org.r7d.misc;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MResponseEntity<T> {

    private T data;
    private Integer status;

    // Default no-argument constructor (required for Jackson)
    public MResponseEntity() {
    }

    public static <T> MResponseEntity<T> okResponse(T data) {
        MResponseEntity<T> mResponseEntity = new MResponseEntity<>();
        mResponseEntity.status = 200;
        mResponseEntity.data = data;
        return mResponseEntity;
    }

}