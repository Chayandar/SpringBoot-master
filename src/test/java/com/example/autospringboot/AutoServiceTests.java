package com.example.autospringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AutoServiceTests {

	@Autowired
	private AutoService autoService;

	@MockBean
	private AutoRepository autoRepository;

	@Test
	public void testGetAllAutos() {
		List<Auto> auto = new ArrayList<>();
		auto.add(new Auto("Ниссан", "Скайлайн", "Да", "35000"));
		auto.add(new Auto("Мазда", "Эрикс 7", "Да", "40000"));

		when(autoRepository.findAll()).thenReturn(auto);

		List<Auto> retrievedAutos = autoService.getAllAuto();
		assertEquals(2, retrievedAutos.size(), "Expected 2 auto");
		System.out.println("Retrieved auto: " + retrievedAutos);
	}

	@Test
	public void testGetAutoById() {
		Long id = 1L;
		Auto auto = new Auto("Ниссан", "Скайлайн", "Да", "35000");
		auto.setId(id);

		when(autoRepository.findById(id)).thenReturn(Optional.of(auto));

		assertEquals(auto, autoService.getAutoById(id).orElse(null));
	}

	@Test
	public void testAddAuto() {
		Auto auto = new Auto("Ниссан", "Скайлайн", "Да", "35000");

		autoService.addAuto(auto);

		verify(autoRepository, times(1)).save(auto);
	}

	@Test
	public void testUpdateAuto() {
		Long id = 1L;
		Auto auto = new Auto("Изменено", "Изменено", "Изменено", "35000");
		auto.setId(id);

		autoService.updateAuto(auto);

		verify(autoRepository, times(1)).save(auto);
	}

	@Test
	public void testDeleteAuto() {
		Long id = 1L;

		autoService.deleteAuto(id);

		verify(autoRepository, times(1)).deleteById(id);
	}

	@Test
	public void testFindAutosByModel() {
		String model = "Скайлайн";
		List<Auto> auto = new ArrayList<>();
		auto.add(new Auto("Ниссан", "Скайлайн", "Да", "35000"));

		when(autoRepository.findByModelIgnoreCase(model)).thenReturn(auto);

		assertEquals(1, autoService.findAutoByModel(model).size());
	}
}
