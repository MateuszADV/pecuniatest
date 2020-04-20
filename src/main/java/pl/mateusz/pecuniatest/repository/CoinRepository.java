package pl.mateusz.pecuniatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mateusz.pecuniatest.models.Coin;

public interface CoinRepository extends JpaRepository<Coin, Long> {
}
