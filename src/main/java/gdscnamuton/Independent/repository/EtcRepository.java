package gdscnamuton.Independent.repository;

import gdscnamuton.Independent.entity.Etc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EtcRepository extends JpaRepository<Etc, UUID> {


}