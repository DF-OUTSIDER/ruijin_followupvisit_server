package application.repository;

import application.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
    UserEntity findByUserNameEquals(@NotNull String username);
}