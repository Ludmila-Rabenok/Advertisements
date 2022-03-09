package com.senla.course.model;

import com.senla.course.enums.Category;
import com.senla.course.enums.Condition;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "advertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Advertisement extends com.senla.course.model.Entity {

    @Column(name = "header")
    private String header;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Column(name = "price")
    private Long price;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition")
    private Condition condition;

    @Column(name = "sales")
    private Boolean sales;

    @ManyToOne
//            (
//            cascade = {CascadeType.DETACH,CascadeType.MERGE,
//            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(//cascade = CascadeType.ALL,
            mappedBy = "advertisement")
    private List<Comment> comments;

    public void addCommentToAnnouncement(Comment comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
        comment.setAdvertisement(this);
    }

}
