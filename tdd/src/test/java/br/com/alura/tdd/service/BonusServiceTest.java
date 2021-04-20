package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		
		// primeira forma de testar exception
	  // assertThrows(IllegalArgumentException.class,
    //				() -> service.calcularBonus(new Funcionario("Miqueias", LocalDate.now(), new BigDecimal("25000"))));
	
		// segunda forma de testar com exception
		try {
			service.calcularBonus(new Funcionario("Miqueias", LocalDate.now(), new BigDecimal("25000")));
			fail("Não deu a exception");
		} catch (Exception e) {
			assertEquals("Funcionario com salário maior que R$ 10000, não pode receber bonus", e.getMessage());
		}
		
	}
	
	@Test
	void bonusDeveriaSer10PorcentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Miqueias", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorcentoParaSalarioDeDezMilReais() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Miqueias", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}
	
}
