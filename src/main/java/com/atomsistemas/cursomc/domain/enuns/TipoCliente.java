package com.atomsistemas.cursomc.domain.enuns;

public enum TipoCliente {
	
	PESSOAFISICA(1,"Pessoa Fisica"),
	PESSOAJURIDICA(2,"Pessoa Juridica");
	
	private int cod;
	private String descrição;
	
	private TipoCliente(int cod, String descriscao) {
		
		this.cod =cod;
		this.descrição = descriscao;
		
	}

	public int getCod() {
		return cod;
	}

	public String getDescrição() {
		return descrição;
	}
	
	public static TipoCliente toEnun(Integer cod) {
		 
		if (cod == null) {
			
		}
		for(TipoCliente x : TipoCliente.values()) {
			
			return x;
		}
		
	  

	 throw new IllegalArgumentException("Id inválido:" + cod );
	
   }

}
