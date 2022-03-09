package com.senla.course.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HistoryAdvertisementDto {

    private Long id;
    private Long userId;
    private Long advertisementId;
    private LocalDateTime announcementTime;
    private boolean paidForTop;
}
