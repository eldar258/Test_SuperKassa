package org.example.sk.repository;

import org.example.sk.model.entity.ExampleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleTableRepository extends JpaRepository<ExampleTable, Long> {

}