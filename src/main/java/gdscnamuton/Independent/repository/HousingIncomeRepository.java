package gdscnamuton.Independent.repository;

import gdscnamuton.Independent.entity.HousingIncome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HousingIncomeRepository extends JpaRepository<HousingIncome, UUID> {
}