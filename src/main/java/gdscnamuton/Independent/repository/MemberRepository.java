package gdscnamuton.Independent.repository;

import gdscnamuton.Independent.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {

    List<Member> findByMemberId(String id);
    List<Member> findByPassword(String password);
}