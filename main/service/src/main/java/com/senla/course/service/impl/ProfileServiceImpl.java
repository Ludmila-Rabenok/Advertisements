package com.senla.course.service.impl;

import com.senla.course.dto.ProfileDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Profile;
import com.senla.course.repository.ProfileRepository;
import com.senla.course.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final DtoMapper<Profile, ProfileDto> mapper;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository, DtoMapper<Profile, ProfileDto> mapper) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
    }
    @Override
    public Profile getById(Long id) {
        Profile profile = null;
        Optional<Profile> optional = profileRepository.findById(id);
        if (optional.isPresent()) {
            profile = optional.get();
        }
        return profile;
    }

    @Override
    public List<Profile> getAll() {
        List<Profile> profiles = profileRepository.findAll();
        return profiles;
    }

    @Override
    public Profile save(ProfileDto profileDto) {
        Profile profile = mapper.toEntity(profileDto);
        profileRepository.save(profile);
        return profile;
    }

    @Override
    public Boolean update(ProfileDto profileDto, Long id) {
        Profile profile = mapper.toEntity(profileDto);
        if(profileRepository.existsById(id)) {
            profileRepository.save(profile);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
