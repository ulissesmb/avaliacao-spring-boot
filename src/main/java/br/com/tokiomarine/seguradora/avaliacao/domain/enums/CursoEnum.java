package br.com.tokiomarine.seguradora.avaliacao.domain.enums;

import java.util.Arrays;

public enum CursoEnum {
	
	ENGENHARIA_COMPUTACAO("Engenharia da Computação", "EC"),
	CIENCIAS_COMPUTACAO("Ciência da Computação", "CC"),
	ANALISE_DADOS("Análise de Dados","AD"),
	TECNOLOGO_COMPUTACAO("Técnologo da Computação", "TC");
	
	private String alias;
	private String key;
	
	private CursoEnum(String alias, String key) {
		this.alias = alias;
		this.key = key;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	public static CursoEnum findByKey(String key){
		return Arrays.asList(CursoEnum.values()).stream()
				.filter(f -> f.getKey().equals(key))
				.findFirst().orElse(null);
	}	

}
