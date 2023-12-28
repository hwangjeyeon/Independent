package gdscnamuton.Independent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Getter
@Setter
@Table(name = "EDUCATION_EMPLOYMENT")
public class EducationEmployment {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String region;
    private String organization;
    @Column(name = "START_PERIOD")
    private String startPeriod;
    @Column(name = "END_PERIOD")
    private String endPeriod;
    private String links;
}