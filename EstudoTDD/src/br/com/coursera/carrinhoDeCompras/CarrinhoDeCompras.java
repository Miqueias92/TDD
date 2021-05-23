package br.com.coursera.carrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
		
	private List<Produto> itens = new ArrayList<Produto>();
	
	public void adicionaProduto(Produto produto) {
		itens.add(produto);
	}
	
	public int total() {
		int total = 0;
		for (Produto produto : itens)
			total += produto.getValor();
		return total;
	}
}
