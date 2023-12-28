package gdscnamuton.Independent.repository;

import gdscnamuton.Independent.entity.EducationEmployment;
import gdscnamuton.Independent.entity.HousingIncome;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


/**
 * - 교육 및 취업 테이블과 잘 연결되는지 확인
 */
@Slf4j
@SpringBootTest
class EducationEmploymentRepositoryTest {

    @Autowired
    EducationEmploymentRepository educationEmploymentRepository;

    @BeforeEach
    public void before(){
        EducationEmployment educationEmployment = new EducationEmployment();

        educationEmployment.setName("정부지원교육");
        educationEmployment.setRegion("서울시 강남구");
        educationEmployment.setOrganization("청와대");
        educationEmployment.setStartPeriod("2023-01-01");
        educationEmployment.setEndPeriod("2025-01-31");
        educationEmployment.setLinks("http://02.koent.or.kr");

        educationEmploymentRepository.save(educationEmployment);

    }

    @Test
    @Transactional
    public void test1(){
        // When
        List<EducationEmployment> findLists = educationEmploymentRepository.findAll();

        for (EducationEmployment findList : findLists) {
            log.info("name = {}",findList.getName());
            log.info("region = {}", findList.getRegion());
            log.info("organization = {}", findList.getOrganization());
            log.info("startPeriod = {}", findList.getStartPeriod());
            log.info("endPeriod = {}", findList.getEndPeriod());
            log.info("links = {}", findList.getLinks());
        }

        assertThat(findLists).isNotNull();
    }

}