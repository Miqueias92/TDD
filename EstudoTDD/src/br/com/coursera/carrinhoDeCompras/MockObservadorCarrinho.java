package br.com.coursera.carrinhoDeCompras;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockObservadorCarrinho implements IObservadorCarrinho {

	private String nomeRecebido;
	private int valorRecebido;
	private boolean darErro = false;
	
	@Override
	public void produtoAdicionado(String nome, int valor) {
		if (darErro) 
			throw new RuntimeException("Problema simulado pelo Mock");
		nomeRecebido = nome;
		valorRecebido = valor;
	}
	
	public void verificaRecebimentoProduto(String nomeEsperado, int valorEsperado) {
		assertEquals(nomeEsperado, nomeRecebido);
		assertEquals(valorEsperado, valorRecebido);
	}

	public void queroQueVoceDeErro() {
		darErro = true;
	}
}