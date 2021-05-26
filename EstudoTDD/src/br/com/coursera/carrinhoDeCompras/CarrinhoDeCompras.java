package br.com.coursera.carrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
		
	private List<Produto> itens = new ArrayList<Produto>();
	private List<IObservadorCarrinho> observadores = new ArrayList<>();
	
	public void adicionaProduto(Produto produto) {
		itens.add(produto);
		for (IObservadorCarrinho observador : observadores) {
			try {
				observador.produtoAdicionado(produto.getNome(), produto.getValor());
			} catch (Exception e) {}
		}
	}
	
	public int total() {
		int total = 0;
		for (Produto produto : itens)
			total += produto.getValor();
		return total;
	}

	public void adicionarObservador(IObservadorCarrinho observador) {
		this.observadores.add(observador);
	}
}
