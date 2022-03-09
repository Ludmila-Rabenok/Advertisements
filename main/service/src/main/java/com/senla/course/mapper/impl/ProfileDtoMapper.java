package com.senla.course.mapper.impl;

import com.senla.course.dto.AdvertisementDto;
import com.senla.course.dto.ProfileDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Advertisement;
import com.senla.course.model.Profile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileDtoMapper implements DtoMapper<Profile, ProfileDto> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public ProfileDto toDto(Profile profile) {
        return mapper.map(profile, ProfileDto.class);
    }

    @Override
    public Profile toEntity(ProfileDto profileDto) {
        return mapper.map(profileDto, Profile.class);
    }

    @Override
    public List<ProfileDto> toDtoList(List<Profile> profiles){
        return profiles.stream()
                .map(profile -> mapper.map(profile,ProfileDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Profile> toEntityList(List<ProfileDto> profileDtos){
        return profileDtos.stream()
                .map(profileDto -> mapper.map(profileDto,Profile.class))
                .collect(Collectors.toList());
    }
}
