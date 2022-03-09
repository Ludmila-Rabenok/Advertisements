package com.senla.course.service.impl;

import com.senla.course.dto.AdvertisementDto;
import com.senla.course.enums.Category;
import com.senla.course.enums.Condition;
import com.senla.course.mapper.DtoMapper;
import com.senla.course.model.Advertisement;
import com.senla.course.repository.AdvertisementRepository;
import com.senla.course.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final DtoMapper<Advertisement, AdvertisementDto> mapper;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository,
                                    DtoMapper<Advertisement, AdvertisementDto> mapper) {
        this.advertisementRepository = advertisementRepository;
        this.mapper = mapper;
    }

    @Override
    public Advertisement getById(Long id) {
        Advertisement advertisement = null;
        Optional<Advertisement> optional = advertisementRepository.findById(id);
        if (optional.isPresent()) {
            advertisement = optional.get();
        }
        return advertisement;
    }

    @Override
    public List<Advertisement> getAll() {
        List<Advertisement> advertisements = advertisementRepository.findAll();
        return advertisements;
    }

    @Override
    public Advertisement save(AdvertisementDto advertisementDto) {
        Advertisement advertisement = mapper.toEntity(advertisementDto);
        advertisementRepository.save(advertisement);
        return advertisement;
    }

    @Override
    public Boolean update(AdvertisementDto advertisementDto, Long id) {
        Advertisement advertisement = mapper.toEntity(advertisementDto);
        if (advertisementRepository.existsById(id)) {
            advertisementRepository.save(advertisement);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        if (advertisementRepository.existsById(id)) {
            advertisementRepository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public List<Advertisement> findAdvertisementsByCategoryEquals(Category category) {
        List<Advertisement> advertisements = advertisementRepository.findAdvertisementsByCategoryEquals(category);
        return advertisements;
    }

    @Override
    public List<Advertisement> findAdvertisementsByConditionEquals(Condition condition){
        List<Advertisement> advertisements = advertisementRepository.findAdvertisementsByConditionEquals(condition);
        return advertisements;
    }

    @Override
    public List<Advertisement> findAdvertisementsByPriceBefore(Long price) {
        List<Advertisement> advertisements = advertisementRepository.findAdvertisementsByPriceBefore(price);
        return advertisements;
    }

    @Override
    public List<Advertisement> findAdvertisementsByPriceAfter(Long price) {
        List<Advertisement> advertisements = advertisementRepository.findAdvertisementsByPriceAfter(price);
        return advertisements;
    }

    @Override
    public List<Advertisement> findAdvertisementsByPriceEquals(Long price) {
        List<Advertisement> advertisements = advertisementRepository.findAdvertisementsByPriceEquals(price);
        return advertisements;
    }

    @Override
    public List<Advertisement> findAdvertisementsBySales(Boolean sales) {
        List<Advertisement> advertisements = advertisementRepository.findAdvertisementsBySales(sales);
        return advertisements;
    }

    @Override
    public List<Advertisement> findAdvertisementsByUserId(Long id) {
        List<Advertisement> advertisements = advertisementRepository.findAdvertisementsByUserId(id);
        return advertisements;
    }

    @Override
    public Long countAdvertisementsByUser_Id(Long id) {
        Long countAdvertisementsByUser  = advertisementRepository.countAdvertisementsByUser_Id(id);
        return countAdvertisementsByUser;
    }

    @Override
    public List<Advertisement> findAllSortByHeader() {
        List<Advertisement> advertisements = advertisementRepository.findAll(Sort.by("Header"));
        return advertisements;
    }

    @Override
    public List<Advertisement> findAllSortByPrice() {
        List<Advertisement> advertisements = advertisementRepository.findAll(Sort.by("Price"));
        return advertisements;
    }

    @Override
    public List<Advertisement> findAllByPaidAndRatingAndTime() {
        List<Advertisement> advertisements = advertisementRepository.findAllByPaidAndRatingAndTime();
        return advertisements;
    }

    @Override
    public List<Advertisement> findAdvertisementsByUserIdAndSalesTrue(Long userId) {
        List<Advertisement> advertisements = advertisementRepository.findAdvertisementsByUserIdAndSalesEquals(userId,true);
        return advertisements;
    }
}
