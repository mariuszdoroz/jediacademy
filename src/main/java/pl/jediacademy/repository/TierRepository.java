package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jediacademy.model.Tier;

@Repository
public interface TierRepository  extends JpaRepository<Tier,Long> {

    Tier findTierByTiername(String tiername);
}
