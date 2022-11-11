package agencia2;

import java.util.HashMap; //fazendo com hashmap pq >>> que arraylist

public class Cliente {
	
	protected String id;
	protected HashMap <Integer, Conta> contas;
	
	public Cliente(String id) { //construtor
		this.id = id;
		contas = new HashMap<Integer, Conta>();
		//e por hoje é só pessoal
	}
}

