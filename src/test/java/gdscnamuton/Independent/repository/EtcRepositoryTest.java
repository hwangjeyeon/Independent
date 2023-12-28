package gdscnamuton.Independent.repository;

import gdscnamuton.Independent.entity.Etc;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * - 기타 테이블과 잘 연결되는지 확인
 */
@Slf4j
@SpringBootTest
class EtcRepositoryTest {

    @Autowired
    EtcRepository etcRepository;

    @BeforeEach
    public void before(){
        Etc etc = new Etc();

        etc.setName("국비지원");
        etc.setRegion("서울시 성북구");
        etc.setOrganization("구글");
        etc.setStartPeriod("2026-01-01");
        etc.setEndPeriod("2030-01-31");
        etc.setLinks("http://google.co.kr");

        etcRepository.save(etc);
    }


    @Test
    @Transactional
    public void test1(){
        List<Etc> findLists = etcRepository.findAll();

        for (Etc findList : findLists) {
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