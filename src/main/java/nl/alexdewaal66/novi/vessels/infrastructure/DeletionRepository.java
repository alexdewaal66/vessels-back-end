package nl.alexdewaal66.novi.vessels.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeletionRepository
        extends JpaRepository<Deletion, Long>, DeletionRepositoryCustom {}

