package com.senla.course.service;

import com.senla.course.dto.HistoryAdvertisementDto;
import com.senla.course.model.HistoryAdvertisement;

import java.util.List;

public interface HistoryAdvertisementService {

    HistoryAdvertisement getById(Long id);

    List<HistoryAdvertisement> getAll();

    HistoryAdvertisement save(HistoryAdvertisementDto historyAdvertisementDto);

    Boolean update(HistoryAdvertisementDto historyAdvertisementDto, Long id);

    boolean deleteById(Long id);
}
