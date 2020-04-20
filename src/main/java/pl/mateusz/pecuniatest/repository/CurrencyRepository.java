package pl.mateusz.pecuniatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mateusz.pecuniatest.models.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
