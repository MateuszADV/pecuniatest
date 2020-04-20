package pl.mateusz.pecuniatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mateusz.pecuniatest.models.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
