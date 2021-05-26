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
	
	@Test
	public void escutaAdicaoDeProduto() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		
		carrinho.adicionarObservador(mock);
		carrinho.adicionaProduto(new Produto("tenis", 100));
		
		mock.verificaRecebimentoProduto("tenis", 100);
	}
	
	@Test
	public void adicionarDoisObservadores() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		
		carrinho.adicionarObservador(mock1);
		carrinho.adicionarObservador(mock2);
		
		carrinho.adicionaProduto(new Produto("tenis", 100));
		mock1.verificaRecebimentoProduto("tenis", 100);
		mock2.verificaRecebimentoProduto("tenis", 100);
	}
	
	@Test
	public void continuaNotificandoComErroEmObservador() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		mock2.queroQueVoceDeErro();
		
		MockObservadorCarrinho mock3 = new MockObservadorCarrinho();
		
		carrinho.adicionarObservador(mock1);
		carrinho.adicionarObservador(mock2);
		carrinho.adicionarObservador(mock3);
		
		carrinho.adicionaProduto(new Produto("tenis", 100));
		mock1.verificaRecebimentoProduto("tenis", 100);
		mock3.verificaRecebimentoProduto("tenis", 100);
	}
}
