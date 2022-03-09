package com.senla.course.service.impl;

import com.senla.course.dto.MessageDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Message;
import com.senla.course.repository.MessageRepository;
import com.senla.course.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final DtoMapper<Message, MessageDto> mapper;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, DtoMapper<Message, MessageDto> mapper) {
        this.messageRepository = messageRepository;
        this.mapper = mapper;
    }
    @Override
    public Message getById(Long id) {
        Message message = null;
        Optional<Message> optional = messageRepository.findById(id);
        if (optional.isPresent()) {
            message = optional.get();
        }
        return message;
    }

    @Override
    public List<Message> getAll() {
        List<Message> messages = messageRepository.findAll();
        return messages;
    }

    @Override
    public Message save(MessageDto messageDto) {
        Message message = mapper.toEntity(messageDto);
        messageRepository.save(message);
        return message;
    }

    @Override
    public Boolean update(MessageDto messageDto, Long id) {
        Message message = mapper.toEntity(messageDto);
        if(messageRepository.existsById(id)) {
            messageRepository.save(message);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Message> findMessagesByUserFromIdAndUserToIdOrUserFromIdAndUserToId(Long id1, Long id2,
                                                                                    Long id3, Long id4) {
        List<Message> messages = messageRepository.findMessagesByUserFromIdAndUserToIdOrUserFromIdAndUserToId(
                id1, id2, id3, id4, Sort.by("MessageTime"));
        return messages;
    }
}
