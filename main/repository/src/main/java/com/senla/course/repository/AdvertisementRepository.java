package com.senla.course.repository;

import com.senla.course.enums.Category;
import com.senla.course.enums.Condition;
import com.senla.course.model.Advertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findAdvertisementsByCategoryEquals(Category category);

    List<Advertisement> findAdvertisementsByConditionEquals(Condition condition);

    List<Advertisement> findAdvertisementsByPriceBefore(Long price);

    List<Advertisement> findAdvertisementsByPriceAfter(Long price);

    List<Advertisement> findAdvertisementsByPriceEquals(Long price);

    List<Advertisement> findAdvertisementsBySales(Boolean sales);

    List<Advertisement> findAdvertisementsByUserId(Long id);

    Long countAdvertisementsByUser_Id(Long id);

    List<Advertisement> findAll (Sort sort);

    @Query(
            value = "select a.id , a.header , a.category , a.price , a.description , a.condition , a.sales , a.user_id  \n" +
                    "  from advertisement a join users u  on a.user_id  = u.id\n" +
                    "  join history_advertisement ha on ha .advertisement_id = a.id \n" +
                    "  order by ha.paid_for_top DESC, u.rating DESC, ha.advertisement_time ",
            nativeQuery = true)
    List<Advertisement> findAllByPaidAndRatingAndTime();

    List<Advertisement> findAdvertisementsByUserIdAndSalesEquals(Long userId, Boolean sales);

}
