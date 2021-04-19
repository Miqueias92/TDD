package br.com.alura.tdd;

public class CalculadoraTestes {
	
	public static void main(String[] args) {
		Calculadora cal = new Calculadora();
		int soma = cal.somar(3, 7);
		System.out.println("Soma: " + soma);
		
		soma = cal.somar(3, 0);
		System.out.println("Soma: " + soma);
		
		soma = cal.somar(0, 0);
		System.out.println("Soma: " + soma);
		
		soma = cal.somar(3, -1);
		System.out.println("Soma: " + soma);
	}
}
