package com.senla.course.service;

import com.senla.course.dto.AdvertisementDto;
import com.senla.course.enums.Category;
import com.senla.course.enums.Condition;
import com.senla.course.model.Advertisement;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AdvertisementService {

    Advertisement getById(Long id);

    List<Advertisement> getAll();

    Advertisement save(AdvertisementDto advertisementDto);

    Boolean update(AdvertisementDto advertisementDto, Long id);

    boolean deleteById(Long id);

    List<Advertisement> findAdvertisementsByCategoryEquals(Category category);

    List<Advertisement> findAdvertisementsByConditionEquals(Condition condition);

    List<Advertisement> findAdvertisementsByPriceBefore(Long price);

    List<Advertisement> findAdvertisementsByPriceAfter(Long price);

    List<Advertisement> findAdvertisementsByPriceEquals(Long price);

    List<Advertisement> findAdvertisementsBySales(Boolean sales);

    List<Advertisement> findAdvertisementsByUserId(Long id);

    Long countAdvertisementsByUser_Id(Long id);

    List<Advertisement> findAllSortByHeader ();

    List<Advertisement> findAllSortByPrice ();

    List<Advertisement> findAllByPaidAndRatingAndTime();

    List<Advertisement> findAdvertisementsByUserIdAndSalesTrue(Long userId);

}
