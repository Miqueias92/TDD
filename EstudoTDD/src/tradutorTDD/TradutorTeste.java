package tradutorTDD;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TradutorTeste {

	private Tradutor tradutor;
	
	@Before
	public void criarTradutor() {
		tradutor = new Tradutor();
	}
	
	@Test
	public void tradutorSemPalavras() {
		assertTrue(tradutor.estaVazio());
	}
	
	@Test
	public void tradutorUmaPalavra() {
		tradutor.adicionaTraducao("bom", "good");
		
		assertFalse(tradutor.estaVazio());
		assertEquals("good", tradutor.traduzir("bom"));
	}
	
	@Test
	public void tradutorDuasPalavras() {
		tradutor.adicionaTraducao("bom", "good");
		tradutor.adicionaTraducao("mau", "bad");
		
		assertEquals("good", tradutor.traduzir("bom"));
		assertEquals("bad", tradutor.traduzir("mau"));
	}
	
	@Test
	public void tradutorDuasTraducoesMesmaPalavras() {
		tradutor.adicionaTraducao("bom", "good");
		tradutor.adicionaTraducao("bom", "nice");
		assertEquals("good, nice", tradutor.traduzir("bom"));
	}
	
	@Test
	public void tradutorFrase() {
		tradutor.adicionaTraducao("guerra", "war");
		tradutor.adicionaTraducao("é", "is");
		tradutor.adicionaTraducao("ruim", "bad");
		
		assertEquals("war is bad", tradutor.traduzirFrase("guerra é ruim"));
	}
	
	@Test
	public void tradutorFraseComDuasTraducoesMesmaPalavra() {
		tradutor.adicionaTraducao("paz", "peace");
		tradutor.adicionaTraducao("é", "is");
		tradutor.adicionaTraducao("bom", "good");
		tradutor.adicionaTraducao("bom", "nice");
		
		assertEquals("peace is good", tradutor.traduzirFrase("paz é bom"));
	}
}
