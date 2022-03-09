package com.senla.course.service;

import com.senla.course.dto.MessageDto;
import com.senla.course.model.Message;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface MessageService {

    Message getById(Long id);

    List<Message> getAll();

    Message save(MessageDto messageDto);

    Boolean update(MessageDto messageDto, Long id);

    boolean deleteById(Long id);

    List<Message> findMessagesByUserFromIdAndUserToIdOrUserFromIdAndUserToId (Long id1, Long id2, Long id3, Long id4);
}
