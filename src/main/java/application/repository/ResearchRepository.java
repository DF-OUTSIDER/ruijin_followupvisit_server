package application.repository;

import application.entity.ResearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ResearchRepository extends JpaRepository<ResearchEntity, String> {
    @Query(value = "select r from ResearchEntity r inner join r.userResearchesByResearchId ur where ur.userId=:userId order by r.createDate asc ")
    Stream<ResearchEntity> findResearchEntitiesByUserId(@Param("userId") String userId);
}
