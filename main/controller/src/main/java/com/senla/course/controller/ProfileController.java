package com.senla.course.controller;

import com.senla.course.dto.ProfileDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Profile;
import com.senla.course.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;
    private final DtoMapper<Profile, ProfileDto> mapper;

    @Autowired
    public ProfileController(ProfileService profileService, DtoMapper<Profile, ProfileDto> mapper) {
        this.profileService = profileService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> showProfileById(@PathVariable Long id) {
        Profile profile = profileService.getById(id);
        ProfileDto profileDto = mapper.toDto(profile);
        return ResponseEntity.ok(profileDto);
    }

    @GetMapping
    public ResponseEntity<List<ProfileDto>> showAllProfile() {
        List<Profile> profiles = profileService.getAll();
        List<ProfileDto> profileDtos = mapper.toDtoList(profiles);
        return ResponseEntity.ok(profileDtos);
    }

    @PostMapping
    public ResponseEntity<ProfileDto> createNewProfile(@RequestBody ProfileDto profileDto) {
        profileService.save(profileDto);
        return ResponseEntity.ok(profileDto);
    }

    @PutMapping
    public ResponseEntity<ProfileDto> updateProfile(@RequestBody ProfileDto profileDto) {
        Long id = profileDto.getId();
        profileService.update(profileDto, id);
        return ResponseEntity.ok(profileDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        profileService.deleteById(id);
        return ResponseEntity.ok("Profile with ID =  " + id + " was delete");
    }
}
