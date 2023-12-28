package gdscnamuton.Independent.service;


import gdscnamuton.Independent.entity.EducationEmployment;
import gdscnamuton.Independent.entity.Etc;
import gdscnamuton.Independent.entity.HousingIncome;
import gdscnamuton.Independent.repository.EducationEmploymentRepository;
import gdscnamuton.Independent.repository.EtcRepository;
import gdscnamuton.Independent.repository.HousingIncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryClassificationService {



    private final EducationEmploymentRepository educationEmploymentRepository;
    private final HousingIncomeRepository housingIncomeRepository;
    private final EtcRepository etcRepository;


    /**
     * 컨트롤러로 넘긴 카테고리 정보를 토대로 어떤 테이블에 접근해야하는지 판단하여, 적절한 메소드 실행
     * 반환 타입이 category 파라미터에 따라 다르므로 제네릭의 와일드카드 '?'을 활용함
     */
    public List<?> findCategory(String category){
        if(category.equals("EducationEmployment")){
            return findEducationEmployments();
        }

        if(category.equals("HousingIncome")){
            return findHousingIncomes();
        }

        if(category.equals("Etc")){
            return findEtcs();
        }

        if(category.equals("All")){
            return findAlls();
        }
        return null;
    }


    /**
     *
     * @return: educationEmployment 엔티티 정보를 모두 전달
     */
    private List<EducationEmployment> findEducationEmployments(){
        return educationEmploymentRepository.findAll();
    }


    /**
     *
     * @return housingIncome 엔티티 정보를 모두 전달
     */
    private List<HousingIncome> findHousingIncomes(){
        return housingIncomeRepository.findAll();
    }

    /**
     *
     * @return etc 정보를 엔티티 모두 전달
     */
    private List<Etc> findEtcs(){
        return etcRepository.findAll();
    }

    /**
     *
     * @return 모든 엔티티 정보를 받아 전달
     * 이때 각 엔티티가 리스트로 되어있기 때문에 리스트의 리스트 형으로 전달한다.
     */
    private List<List<?>> findAlls(){
        List<List<?>> finds = new ArrayList<>();
        finds.add(findEducationEmployments());
        finds.add(findHousingIncomes());
        finds.add(findEtcs());
        return finds;
    }

}