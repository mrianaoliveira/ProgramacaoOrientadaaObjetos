package anotacoes;

public class UsuarioNaoLogadoException extends RuntimeException{
	//usuairo nao esta onde devia ta {ou nao existe
	public UsuarioNaoLogadoException(String message) {
		super(message);
	}
}
