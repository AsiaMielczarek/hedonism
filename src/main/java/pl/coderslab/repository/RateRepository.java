package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Rate;

public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query(value = "SELECT AVG(r.rate) FROM rates AS r WHERE r.place_id = ?1", nativeQuery = true)
    Double GetAvgRating(Long id);

}
