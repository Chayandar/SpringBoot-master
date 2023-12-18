package com.example.autospringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AutoRepositoryTests {

    @Autowired
    private AutoRepository autoRepository;

    @Test
    public void testFindByModelIgnoreCase() {
        Auto auto = new Auto("Лада", "Ларгус", "Да", "250000");
        autoRepository.save(auto);

        List<Auto> retrievedAutos = autoRepository.findByModelIgnoreCase("Ларгус");

        assertEquals(1, retrievedAutos.size(), "Ожидается машина с указанной маркой");
        assertEquals(auto.getModel(), retrievedAutos.get(0).getModel());
    }
}