package io.qunhao.okr.repo;

import io.qunhao.okr.entity.OkrEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "okr", path = "okr")
public interface OkrRepo extends PagingAndSortingRepository<OkrEntity, Long> {
    List<OkrEntity> findByOwner(@Param("owner") String name);
    List<OkrEntity> findByOwnerId(@Param("ownerId") Long ownerId);
}
