package com.senla.course.service.impl;

import com.senla.course.dto.HistoryAdvertisementDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.HistoryAdvertisement;
import com.senla.course.repository.HistoryAdvertisementRepository;
import com.senla.course.service.HistoryAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryAdvertisementServiceImpl implements HistoryAdvertisementService {

    private final HistoryAdvertisementRepository historyAdvertisementRepository;
    private final DtoMapper<HistoryAdvertisement, HistoryAdvertisementDto> mapper;

    @Autowired
    public HistoryAdvertisementServiceImpl(HistoryAdvertisementRepository historyAdvertisementRepository,
                                           DtoMapper<HistoryAdvertisement, HistoryAdvertisementDto> mapper) {
        this.historyAdvertisementRepository = historyAdvertisementRepository;
        this.mapper = mapper;
    }
    @Override
    public HistoryAdvertisement getById(Long id) {
        HistoryAdvertisement historyAdvertisement = null;
        Optional<HistoryAdvertisement> optional = historyAdvertisementRepository.findById(id);
        if (optional.isPresent()) {
            historyAdvertisement = optional.get();
        }
        return historyAdvertisement;
    }

    @Override
    public List<HistoryAdvertisement> getAll() {
        List<HistoryAdvertisement> historyAdvertisements = historyAdvertisementRepository.findAll();
        return historyAdvertisements;
    }

    @Override
    public HistoryAdvertisement save(HistoryAdvertisementDto historyAdvertisementDto) {
        HistoryAdvertisement historyAdvertisement = mapper.toEntity(historyAdvertisementDto);
        historyAdvertisementRepository.save(historyAdvertisement);
        return historyAdvertisement;
    }

    @Override
    public Boolean update(HistoryAdvertisementDto historyAdvertisementDto, Long id) {
        HistoryAdvertisement historyAdvertisement = mapper.toEntity(historyAdvertisementDto);
        if(historyAdvertisementRepository.existsById(id)) {
            historyAdvertisementRepository.save(historyAdvertisement);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        if (historyAdvertisementRepository.existsById(id)) {
            historyAdvertisementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
