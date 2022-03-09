package com.senla.course.repository;

import com.senla.course.model.Message;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findMessagesByUserFromIdAndUserToIdOrUserFromIdAndUserToId(Long id1, Long id2, Long id3, Long id4, Sort sort);
}
