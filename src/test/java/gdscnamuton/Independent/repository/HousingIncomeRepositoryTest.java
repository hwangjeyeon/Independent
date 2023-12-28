package gdscnamuton.Independent.repository;

import gdscnamuton.Independent.entity.HousingIncome;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * - 주거 및 소득 테이블과 잘 연결되는지 확인
 */
@Slf4j
@SpringBootTest
class HousingIncomeRepositoryTest {

    @Autowired
    HousingIncomeRepository housingIncomeRepository;



    @BeforeEach
    public void before(){
        HousingIncome housingIncome = new HousingIncome();

        housingIncome.setName("정부지원사업");
        housingIncome.setRegion("서울시 동작구");
        housingIncome.setOrganization("정부24");
        housingIncome.setStartPeriod("2024-01-01");
        housingIncome.setEndPeriod("2024-01-31");
        housingIncome.setLinks("http://02.koent.or.kr/bbs/board.php?bo_table=02school");

        housingIncomeRepository.save(housingIncome);

    }

    @Test
    @Transactional
    public void test1(){

        // When
        List<HousingIncome> findLists = housingIncomeRepository.findAll();

        for (HousingIncome findList : findLists) {
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