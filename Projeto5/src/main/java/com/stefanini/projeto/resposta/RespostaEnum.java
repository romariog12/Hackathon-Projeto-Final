package com.stefanini.projeto.resposta;

public enum RespostaEnum {
	
	SAVE(1),
	UPDATE(2),
	DELETE(3),
	CADASTRO_EXISTENTE(4);
	
	private int value;
	
	private RespostaEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

}
