package anotacoes;

public class SenhaInvalidaException  extends RuntimeException{
	//pra ver a senha eh a certa {aqui nao eh}
	public SenhaInvalidaException(String message) {
		super(message);
	}
}
