package io.qunhao.okr.repo;

import io.qunhao.okr.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByIdIn(List<Long> userIds);

    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

}
