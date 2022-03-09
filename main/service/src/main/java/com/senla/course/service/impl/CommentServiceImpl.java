package com.senla.course.service.impl;

import com.senla.course.dto.CommentDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Comment;
import com.senla.course.repository.CommentRepository;
import com.senla.course.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final DtoMapper<Comment, CommentDto> mapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, DtoMapper<Comment, CommentDto> mapper) {
        this.commentRepository = commentRepository;
        this.mapper = mapper;
    }

    @Override
    public Comment getById(Long id) {
        Comment comment = null;
        Optional<Comment> optional = commentRepository.findById(id);
        if (optional.isPresent()) {
            comment = optional.get();
        }
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments;
    }

    @Override
    public Comment save(CommentDto commentDto) {
        Comment comment = mapper.toEntity(commentDto);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Boolean update(CommentDto commentDto, Long id) {
        Comment comment = mapper.toEntity(commentDto);
        if (commentRepository.existsById(id)) {
            commentRepository.save(comment);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Comment> findCommentsByAdvertisement_Id(Long id) {
        List<Comment> comments = commentRepository.findCommentsByAdvertisement_Id(id, Sort.by("CommentTime"));
        return comments;
    }
}
