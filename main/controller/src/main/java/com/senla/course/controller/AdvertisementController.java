package com.senla.course.controller;

import com.senla.course.dto.AdvertisementDto;
import com.senla.course.enums.Category;
import com.senla.course.enums.Condition;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Advertisement;
import com.senla.course.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

    private final AdvertisementService advertisementService;
    private final DtoMapper<Advertisement, AdvertisementDto> mapper;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService,
                                   DtoMapper<Advertisement, AdvertisementDto> mapper) {
        this.advertisementService = advertisementService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementDto> showAdvertisementById(@PathVariable Long id) {
        Advertisement advertisement = advertisementService.getById(id);
        AdvertisementDto advertisementDto = mapper.toDto(advertisement);
        return ResponseEntity.ok(advertisementDto);
    }

    @GetMapping
    public ResponseEntity<List<AdvertisementDto>> showAllAdvertisement() {
        List<Advertisement> advertisements = advertisementService.getAll();
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }

    @PostMapping
    public ResponseEntity<AdvertisementDto> createNewAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        advertisementService.save(advertisementDto);
        return ResponseEntity.ok(advertisementDto);
    }

    @PutMapping
    public ResponseEntity<AdvertisementDto> updateAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        Long id = advertisementDto.getId();
        advertisementService.update(advertisementDto, id);
        return ResponseEntity.ok(advertisementDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        advertisementService.deleteById(id);
        return ResponseEntity.ok("Advertisement with ID =  " + id + " was delete");
    }

    @GetMapping("/byCategoryEquals/{category}")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsByCategoryEquals(@PathVariable Category category) {
        List<Advertisement> advertisements = advertisementService.findAdvertisementsByCategoryEquals(category);
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }

    @GetMapping("/byConditionEquals/{condition}")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsByConditionEquals(@PathVariable Condition condition) {
        List<Advertisement> advertisements = advertisementService.findAdvertisementsByConditionEquals(condition);
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }

    @GetMapping("/byPriceBefore/{price}")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsByPriceBefore(@PathVariable Long price) {
        List<Advertisement> advertisements = advertisementService.findAdvertisementsByPriceBefore(price);
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }

    @GetMapping("/byPriceAfter/{price}")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsByPriceAfter(@PathVariable Long price) {
        List<Advertisement> advertisements = advertisementService.findAdvertisementsByPriceAfter(price);
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }

    @GetMapping("/byPriceEquals/{price}")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsByPriceEquals(@PathVariable Long price) {
        List<Advertisement> advertisements = advertisementService.findAdvertisementsByPriceEquals(price);
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }

    @GetMapping("/bySales/{sales}")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsBySales(@PathVariable Boolean sales) {
        List<Advertisement> advertisements = advertisementService.findAdvertisementsBySales(sales);
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }

    @GetMapping("/byUserId/{id}")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsByUserId(@PathVariable Long id) {
        List<Advertisement> advertisements = advertisementService.findAdvertisementsByUserId(id);
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }

    @GetMapping("/countByUser/{id}")
    public ResponseEntity<Long> countAdvertisementsByUser_Id(@PathVariable Long id) {
        Long countAdvertisementsByUser = advertisementService.countAdvertisementsByUser_Id(id);
        return ResponseEntity.ok(countAdvertisementsByUser);
    }

    @GetMapping("/sortByHeader")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsSortByHeader(){
        List<Advertisement> advertisements = advertisementService.findAllSortByHeader();
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }

    @GetMapping("/sortByPrice")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsSortByPrice(){
        List<Advertisement> advertisements = advertisementService.findAllSortByPrice();
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }
    @GetMapping("/sortByPaidRatingTime")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsSortByPaidAndRatingAndTime(){
        List<Advertisement> advertisements = advertisementService.findAllByPaidAndRatingAndTime();
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }
    @GetMapping("/bySalesTrue/{id}")
    public ResponseEntity<List<AdvertisementDto>> showAdvertisementsByUserIdWhereSalesTrue(@PathVariable Long id){
        List<Advertisement> advertisements = advertisementService.findAdvertisementsByUserIdAndSalesTrue(id);
        List<AdvertisementDto> advertisementDtos = mapper.toDtoList(advertisements);
        return ResponseEntity.ok(advertisementDtos);
    }


}
