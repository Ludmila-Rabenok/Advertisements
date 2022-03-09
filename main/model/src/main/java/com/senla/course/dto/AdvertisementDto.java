package com.senla.course.dto;

import com.senla.course.enums.Category;
import com.senla.course.enums.Condition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertisementDto {

    private Long id;
    private String header;
    private Category category;
    private Long price;
    private String description;
    private Condition condition;
    private Boolean sales;
    private Long userId;
}
