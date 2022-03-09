package com.senla.course.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history_advertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class HistoryAdvertisement extends com.senla.course.model.Entity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
//            (cascade = CascadeType.ALL)
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;

    @CreationTimestamp
    @Column(name = "advertisement_time")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime announcementTime;

    @Column(name = "paid_for_top")
    private boolean paidForTop;
}
