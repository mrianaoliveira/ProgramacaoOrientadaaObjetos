package agenda3;

import agenda3.Fone;

public class Fone {
	private String label, number;
	
	public Fone(String label, int number) {//metodo contrutor 
		this.label = label; //label: operadora ou fixo {porque eu tava pensando q era outra coisa 	
		this.number = Integer.toString(number);
	}

	public Fone(String label, String number) {//metodo contrutor 
		this.label = label; //label: operadora ou fixo {porque eu tava pensando q era outra coisa 	
		this.number = number;
	}
	
	public static boolean  validate(String number) { 
		//metodo para validar o numero
		String validacao = "0123456789"; //parametro passado como é o certo a ser seguido
		for(int v = 0; v < number.length(); v++) { //o v passando na string, vendo cada numero
			char c = number.charAt(v); //vendo se o caractere esta lá string, de um por um 
			if(validacao.indexOf(c) == -1) {  //vendo se ta lá na validação, 
				//se de -1, eh porque nao achaou o numero
				System.out.println("Fone invalido"); //nao deu certo
				return false;
			}
		}
		return true; //deu certo mah
	}
	
	@Override
	public String toString() {
		//to string para imprimir o label e o numer do caba
		return this.label + ":" + this.number;
	}
	
	//métodos get e sets
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
}