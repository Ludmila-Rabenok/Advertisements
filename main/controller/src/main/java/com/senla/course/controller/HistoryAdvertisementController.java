package com.senla.course.controller;

import com.senla.course.dto.HistoryAdvertisementDto;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.HistoryAdvertisement;
import com.senla.course.service.HistoryAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history_advertisements")
public class HistoryAdvertisementController {

    private final HistoryAdvertisementService historyAdvertisementService;
    private final DtoMapper<HistoryAdvertisement, HistoryAdvertisementDto> mapper;

    @Autowired
    public HistoryAdvertisementController(HistoryAdvertisementService historyAdvertisementService,
                                          DtoMapper<HistoryAdvertisement, HistoryAdvertisementDto> mapper) {
        this.historyAdvertisementService = historyAdvertisementService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryAdvertisementDto> showHistoryAdvertisementById(@PathVariable Long id) {
        HistoryAdvertisement historyAdvertisement = historyAdvertisementService.getById(id);
        HistoryAdvertisementDto historyAdvertisementDto = mapper.toDto(historyAdvertisement);
        return ResponseEntity.ok(historyAdvertisementDto);
    }

    @GetMapping
    public ResponseEntity<List<HistoryAdvertisementDto>> showAllHistoryAdvertisement() {
        List<HistoryAdvertisement> historyAdvertisements = historyAdvertisementService.getAll();
        List<HistoryAdvertisementDto> historyAdvertisementDtos = mapper.toDtoList(historyAdvertisements);
        return ResponseEntity.ok(historyAdvertisementDtos);
    }

    @PostMapping
    public ResponseEntity<HistoryAdvertisementDto> createNewHistoryAdvertisement
            (@RequestBody HistoryAdvertisementDto historyAdvertisementDto) {
        historyAdvertisementService.save(historyAdvertisementDto);
        return ResponseEntity.ok(historyAdvertisementDto);
    }

    @PutMapping
    public ResponseEntity<HistoryAdvertisementDto> updateHistoryAdvertisement
            (@RequestBody HistoryAdvertisementDto historyAdvertisementDto) {
        Long id = historyAdvertisementDto.getId();
        historyAdvertisementService.update(historyAdvertisementDto, id);
        return ResponseEntity.ok(historyAdvertisementDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        historyAdvertisementService.deleteById(id);
        return ResponseEntity.ok("History advertisement with ID =  " + id + " was delete");
    }
}
