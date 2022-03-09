package com.senla.course.dto;

import com.senla.course.enums.Region;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDto {

    private Long id;
    private String name;
    private int phoneNumber;
    private Region region;
}
