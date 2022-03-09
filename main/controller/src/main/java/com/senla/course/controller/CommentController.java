package com.senla.course.controller;

import com.senla.course.dto.CommentDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Comment;
import com.senla.course.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    private final DtoMapper<Comment, CommentDto> mapper;

    @Autowired
    public CommentController(CommentService commentService, DtoMapper<Comment, CommentDto> mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> showCommentById(@PathVariable Long id) {
        Comment comment = commentService.getById(id);
        CommentDto commentDto = mapper.toDto(comment);
        return ResponseEntity.ok(commentDto);
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> showAllComment() {
        List<Comment> comments = commentService.getAll();
        List<CommentDto> commentDtos = mapper.toDtoList(comments);
        return ResponseEntity.ok(commentDtos);
    }

    @PostMapping
    public ResponseEntity<CommentDto> createNewComment(@RequestBody CommentDto commentDto) {
        commentService.save(commentDto);
        return ResponseEntity.ok(commentDto);
    }

    @PutMapping
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto) {
        Long id = commentDto.getId();
        commentService.update(commentDto, id);
        return ResponseEntity.ok(commentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        commentService.deleteById(id);
        return ResponseEntity.ok("Comment with ID =  " + id + " was delete");
    }

    @GetMapping("/byAdvertisementIdAndSortByTime/{id}")
    public ResponseEntity<List<CommentDto>> showCommentsByAdvertisement_Id(@PathVariable Long id) {
        List<Comment> comments = commentService.findCommentsByAdvertisement_Id(id);
        List<CommentDto> commentDtos = mapper.toDtoList(comments);
        return ResponseEntity.ok(commentDtos);
    }

}
