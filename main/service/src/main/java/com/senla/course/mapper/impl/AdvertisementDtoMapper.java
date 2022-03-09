package com.senla.course.mapper.impl;

import com.senla.course.dto.AdvertisementDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Advertisement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementDtoMapper implements DtoMapper<Advertisement, AdvertisementDto> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public AdvertisementDto toDto(Advertisement advertisement) {
        return mapper.map(advertisement, AdvertisementDto.class);
    }

    @Override
    public Advertisement toEntity(AdvertisementDto advertisementDto) {
        return mapper.map(advertisementDto,Advertisement.class);
    }

    @Override
    public List<AdvertisementDto> toDtoList(List<Advertisement> advertisements){
        return advertisements.stream()
                .map(advertisement -> mapper.map(advertisement,AdvertisementDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Advertisement> toEntityList(List<AdvertisementDto> advertisementDtos){
        return advertisementDtos.stream()
                .map(advertisementDto -> mapper.map(advertisementDto,Advertisement.class))
                .collect(Collectors.toList());
    }
}
