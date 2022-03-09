package com.senla.course.mapper.impl;

import com.senla.course.dto.MessageDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageDtoMapper implements DtoMapper<Message, MessageDto> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public MessageDto toDto(Message message) {
        return mapper.map(message, MessageDto.class);
    }

    @Override
    public Message toEntity(MessageDto messageDto) {
        return mapper.map(messageDto, Message.class);
    }

    @Override
    public List<MessageDto> toDtoList(List<Message> messages) {
        return messages.stream()
                .map(message -> mapper.map(message, MessageDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Message> toEntityList(List<MessageDto> messageDtos) {
        return messageDtos.stream()
                .map(messageDto -> mapper.map(messageDto, Message.class))
                .collect(Collectors.toList());
    }

}