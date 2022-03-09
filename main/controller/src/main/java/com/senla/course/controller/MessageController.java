package com.senla.course.controller;

import com.senla.course.dto.MessageDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Message;
import com.senla.course.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;
    private final DtoMapper<Message, MessageDto> mapper;

    @Autowired
    public MessageController(MessageService messageService, DtoMapper<Message, MessageDto> mapper) {
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> showMessageById(@PathVariable Long id) {
        Message message = messageService.getById(id);
        MessageDto messageDto = mapper.toDto(message);
        return ResponseEntity.ok(messageDto);
    }

    @GetMapping
    public ResponseEntity<List<MessageDto>> showAllMessage() {
        List<Message> messages = messageService.getAll();
        List<MessageDto> messageDtos = mapper.toDtoList(messages);
        return ResponseEntity.ok(messageDtos);
    }

    @PostMapping
    public ResponseEntity<MessageDto> createNewMessage(@RequestBody MessageDto messageDto) {
        messageService.save(messageDto);
        return ResponseEntity.ok(messageDto);
    }

    @PutMapping
    public ResponseEntity<MessageDto> updateMessage(@RequestBody MessageDto messageDto) {
        Long id = messageDto.getId();
        messageService.update(messageDto, id);
        return ResponseEntity.ok(messageDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        messageService.deleteById(id);
        return ResponseEntity.ok("Message with ID =  " + id + " was delete");
    }

    @GetMapping("/betweenUsers/{id1}/{id2}")
    public ResponseEntity<List<MessageDto>> showMessagesBetweenUsers(@PathVariable Long id1, @PathVariable Long id2){
        List<Message> messages = messageService.findMessagesByUserFromIdAndUserToIdOrUserFromIdAndUserToId(id1,id2,id2,id1);
        List<MessageDto> messageDtos = mapper.toDtoList(messages);
        return ResponseEntity.ok(messageDtos);
    }
}
