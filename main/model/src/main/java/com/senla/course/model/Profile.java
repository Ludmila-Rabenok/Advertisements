package com.senla.course.model;

import com.senla.course.enums.Region;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@javax.persistence.Entity
@Table(name = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Profile extends Entity{

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "region")
    private Region region;
}
