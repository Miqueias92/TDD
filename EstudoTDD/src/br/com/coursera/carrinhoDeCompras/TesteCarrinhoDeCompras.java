package br.com.coursera.carrinhoDeCompras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteCarrinhoDeCompras {

	@Test
	void totalCarrinhoDeCompras() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionaProduto(new Produto("tenis", 100));
		carrinho.adicionaProduto(new Produto("camiseta", 50));
		carrinho.adicionaProduto(new Produto("bermuda", 70));
		
		assertEquals(220, carrinho.total());
	}
}
