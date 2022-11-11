package agencia1;

import java.util.ArrayList; 
import java.util.Arrays;

public class ContaBancaria {
	private int idNext, numero;
	private float saldo;
	private ArrayList<Operacao> extrato; 
	
	public ContaBancaria(int numero) {
		if(this.numero == 0) {
			this.numero = numero;
			this.saldo = 0;
			this.idNext = 1;
			this.extrato = new ArrayList<Operacao>(); 
		} 
		else {
			this.numero = 0;
			this.saldo = 0;
			this.idNext = 1;
			this.extrato = new ArrayList<Operacao>(); 
		}

	}
	
	public void adicionarOperacao(String descricao, float valor) {
		Operacao op = new Operacao(this.idNext,this.numero, descricao,valor,this.saldo);
		extrato.add(op);
		idNext++;
	}
	
	public Boolean Depositar(float valor) {
		if(valor > 0) {
			this.saldo += valor;
			adicionarOperacao("Deposito", valor);
			return true;
		}
		else {
			System.out.println("fail: valor invalido");
			return false;
		}
	}
	
	public Boolean Tarifa(float valor) {
		this.saldo -= valor;
		adicionarOperacao("Tarifa", -valor);
		return true;
	}
	
	public void extornar(int...args) {
		for(int i : args) {
			if(i < 0 || i >= extrato.size()) {
				System.out.println("Indice: " + i + " não eh uma tarifa");
			} else if("tarifa".equals(extrato.get(i).descricao)) {
				saldo -= extrato.get(i).valor;
				adicionarOperacao("extorno", -extrato.get(i).valor);
				System.out.println("Extorno feito com sucesso");
			}
			else {
				System.out.println("Indice " + i + " invalido"); //senao, é invalido
			}
		}
	}

	public ArrayList<Operacao> extrato() { //metdo para mostrar todos os extratos
		//metodozim pra retornar o extrato
		//q vai puxar o jeito do toString lá da classe Operacao
		return extrato;
	}
	
	public ArrayList<Operacao> extratoN(int n) { //metodo pra mostrar só terminados extratos
		int size = extrato.size(); //aqui verifica o tamanho do extrato
		ArrayList<Operacao> novo = new ArrayList<Operacao>(); //criando um novo array
		//pq quer em lista, ai ta convertendo
		for(int i=size-n; i<size; i++ ){ //percorrendo o array
			Operacao o = extrato.get(i); //achando os determidos extratos que a pessoa quer
			novo.add(o); // adicionando lá no novo array criando a 4 linhas antes
		}
		return novo; //retornando o novo array
	}
	
	public String toString() {
		return "conta:"+this.numero+" saldo:"+this.saldo;
		//aqui serve pra printar a conta que pede lá na main
		//esse é pra mostrar como ta o andamento da conta
		//não o extrato 
	}
	
	//isso aqui serviu pra me situar durante o código :D
	//add: adiconar alguma coisa no arrays
	//size: ver qnts tem
	//contains: ver se tem determinado objeto
	//remove: remover
	//euqals: se two objetos são iguais
	
	//set e gets
	
	public int getIdNext() {
		return idNext;
	}

	public void setIdNext(int idNext) {
		this.idNext = idNext;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Operacao> getExtrato() {
		return extrato;
	}

	public void setExtrato(ArrayList<Operacao> extrato) {
		this.extrato = extrato;
	}
	

	
}
