package com.senla.course.repository;

import com.senla.course.model.Comment;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByAdvertisement_Id(Long id, Sort sort);





}
