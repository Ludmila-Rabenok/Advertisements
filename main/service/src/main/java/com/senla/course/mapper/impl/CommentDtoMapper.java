package com.senla.course.mapper.impl;

import com.senla.course.dto.CommentDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentDtoMapper implements DtoMapper<Comment, CommentDto> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public CommentDto toDto(Comment comment) {
        return mapper.map(comment, CommentDto.class);
    }

    @Override
    public Comment toEntity(CommentDto commentDto) {
        return mapper.map(commentDto, Comment.class);
    }

    @Override
    public List<CommentDto> toDtoList(List<Comment> comments) {
        return comments.stream()
                .map(comment -> mapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Comment> toEntityList(List<CommentDto> commentDtos) {
        return commentDtos.stream()
                .map(commentDto -> mapper.map(commentDto, Comment.class))
                .collect(Collectors.toList());
    }

}