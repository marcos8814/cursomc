package com.atomsistemas.cursomc.domain.enuns;

public enum EstadoPagamento {
 
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3,"Cancelado");
	
	private int cod;
	private String descrição;
	
	private EstadoPagamento(int cod, String descriscao) {
		
		this.cod =cod;
		this.descrição = descriscao;
		
	}

	public int getCod() {
		return cod;
	}

	public String getDescrição() {
		return descrição;
	}
	
	public static EstadoPagamento toEnun(Integer cod) {
		 
		if (cod == null) {
			
		}
		for(EstadoPagamento x : EstadoPagamento.values()) {
			
			return x;
		}
		
	  

	 throw new IllegalArgumentException("Id inválido:" + cod );
	
   }

}
