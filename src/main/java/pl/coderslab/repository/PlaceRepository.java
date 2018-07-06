package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Place;
import pl.coderslab.entity.Type;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findFirstById(Long id);

    List<Place> findAllByCity(String city);

    List<Place> findAllByTypeAndCity(Type type, String city);

    Place findByName(String name);

    List<Place> findAllByUserId(Long id);

}
