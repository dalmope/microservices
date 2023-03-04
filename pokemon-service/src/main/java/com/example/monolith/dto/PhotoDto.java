package com.example.monolith.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {
    private String id;
    private String photo;

    public PhotoDto(String photo){
        this.photo = photo;
    }

}
