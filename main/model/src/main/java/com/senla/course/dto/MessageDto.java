package com.senla.course.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageDto {

    private Long id;
    private Long userFromId;
    private Long userToId;
    private String content;
    private LocalDateTime messageTime;
}
