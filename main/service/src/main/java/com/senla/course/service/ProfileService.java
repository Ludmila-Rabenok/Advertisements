package com.senla.course.service;

import com.senla.course.dto.ProfileDto;
import com.senla.course.model.Profile;

import java.util.List;

public interface ProfileService {

    Profile getById(Long id);

    List<Profile> getAll();

    Profile save(ProfileDto profileDto);

    Boolean update(ProfileDto profileDto, Long id);

    boolean deleteById(Long id);
}
