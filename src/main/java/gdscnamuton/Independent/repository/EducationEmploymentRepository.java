package gdscnamuton.Independent.repository;

import gdscnamuton.Independent.entity.EducationEmployment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EducationEmploymentRepository extends JpaRepository<EducationEmployment, UUID> {
}