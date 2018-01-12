package application.repository;

import application.entity.RoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
    /**
     * find all roles by uri equals. start without '/'
     *
     * @param uri
     * @return
     */
    @Query(value = "select r from RoleEntity r " +
            "inner join r.roleOperationsByRoleId ro " +
            "where ro.operationByOperationId.url=:uri")
    Stream<RoleEntity> findUriRoles(@Param("uri") String uri);
}
