package agenda2;

public class Fone {
	public String label, number;
	
	public static boolean validate(String number) { //validar o numero
		String validacao = "0123456789"; //o  numero que eh o certo a ser telefonado
		for(int v = 0; v < number.length(); v++) { //percorrendo caractere por caractere,
			char c = number.charAt(v); //vendo se o caractere esta na medida de ser telefonado
			if(validacao.indexOf(c) == -1) { //vendo se esta de acordo com que tem lá na validação
				//se de -1 é porque nao achou o caractere que estavamos procurando 
				System.out.println("fail: fone invalido"); //nao dando certo :(
				return false;
			}
		}
		return true; //senao, deu certo \o/
	}

	@Override
	public String toString() {
		return this.label + ":" + this.number;
	}

	public Fone(String label, String number) {
		this.label = label;
		this.number = number;
	}
	public Fone(String label, int number) {
		this.label = label;
		this.number = Integer.toString(number);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}