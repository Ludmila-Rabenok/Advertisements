package com.senla.course.service;

import com.senla.course.dto.CommentDto;
import com.senla.course.model.Comment;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CommentService {

    Comment getById(Long id);

    List<Comment> getAll();

    Comment save(CommentDto commentDto);

    Boolean update(CommentDto commentDto, Long id);

    boolean deleteById(Long id);

    List<Comment> findCommentsByAdvertisement_Id(Long id);
}
