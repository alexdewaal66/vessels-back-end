package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.GenericEntity;
import nl.alexdewaal66.novi.vessels.model.ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity> extends JpaRepository<T, Long> {
    Collection<ProjectId> findAllBy();
}
