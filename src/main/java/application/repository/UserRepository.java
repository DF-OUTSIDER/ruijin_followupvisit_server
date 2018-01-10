package application.repository;

import application.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
    @Query("select distinct u from UserEntity u where u.userName=:username")
    UserEntity findByUserNameEquals(@NotNull @Param("username") String username);
}