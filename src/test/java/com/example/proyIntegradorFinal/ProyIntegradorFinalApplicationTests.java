package com.example.proyIntegradorFinal;

import com.example.proyIntegradorFinal.exceptions.ResourceNotFoundException;
import com.example.proyIntegradorFinal.repository.OdontologoRepository;
import com.example.proyIntegradorFinal.service.OdontologoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ProyIntegradorFinalApplicationTests {

	@Test
	@DisplayName("Si el odontologo no existe, se tira la excepcion Resourse not found")
	void test() {
		//GIVEN
		var repository=mock(OdontologoRepository.class);
		when(repository.findById(anyInt())).thenReturn((Optional.empty()));
		var service = new OdontologoService(repository);


		//WHEN y THEN

		assertThrows(ResourceNotFoundException.class,() -> service.eliminar(3));


	}

}
