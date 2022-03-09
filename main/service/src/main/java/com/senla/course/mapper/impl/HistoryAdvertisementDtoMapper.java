package com.senla.course.mapper.impl;

import com.senla.course.dto.HistoryAdvertisementDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.HistoryAdvertisement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryAdvertisementDtoMapper implements DtoMapper<HistoryAdvertisement, HistoryAdvertisementDto> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public HistoryAdvertisementDto toDto(HistoryAdvertisement historyAdvertisement) {
        return mapper.map(historyAdvertisement, HistoryAdvertisementDto.class);
    }

    @Override
    public HistoryAdvertisement toEntity(HistoryAdvertisementDto historyAdvertisementDto) {
        return mapper.map(historyAdvertisementDto, HistoryAdvertisement.class);
    }

    @Override
    public List<HistoryAdvertisementDto> toDtoList(List<HistoryAdvertisement> historyAdvertisements) {
        return historyAdvertisements.stream()
                .map(historyAdvertisement -> mapper.map(historyAdvertisement, HistoryAdvertisementDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<HistoryAdvertisement> toEntityList(List<HistoryAdvertisementDto> historyAdvertisementDtos) {
        return historyAdvertisementDtos.stream()
                .map(historyAdvertisementDto -> mapper.map(historyAdvertisementDto, HistoryAdvertisement.class))
                .collect(Collectors.toList());
    }
}
