package com.example.autospringboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
    public List<Auto> findByModelIgnoreCase (String model);
    public List<Auto> findByModelContainingIgnoreCase(String fragment);

}