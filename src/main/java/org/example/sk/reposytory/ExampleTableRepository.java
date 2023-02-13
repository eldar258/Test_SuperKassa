package org.example.sk.reposytory;

import java.util.Optional;
import org.example.sk.model.entity.ExampleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ExampleTableRepository extends JpaRepository<ExampleTable, Long> {

    Optional<ExampleTable> findById(long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE sk_example_table SET obj = jsonb_set(obj, '{current}', CAST(CAST((CAST((obj->>'current') AS integer) + CAST(:add AS integer)) AS text) AS jsonb), false) WHERE id = :id", nativeQuery = true)
    int updateCurrent(@Param("id") Long id, @Param("add") int add);
}