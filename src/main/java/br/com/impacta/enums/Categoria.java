package br.com.impacta.enums;

public enum Categoria {
	ALIMENTACAO("Alimentacao"),
	TRANSPORTE("Transporte"),
	VESTUARIO("Vestuário"),
	MORADIA("Moradia"),
	LAZER("Lazer"),
	COMPRAS("Compras"),
	DIVERSOS("Diversos"),
	CUIDADOS_PESSOAIS("Cuidados Pessoais");
	
	private String nome;
	
	Categoria(String nome){
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

}
