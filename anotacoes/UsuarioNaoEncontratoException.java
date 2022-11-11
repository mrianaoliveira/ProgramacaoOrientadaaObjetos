package anotacoes;

public class UsuarioNaoEncontratoException extends RuntimeException{
	//caso o suaurio nao existe
	public UsuarioNaoEncontratoException (String message) {
		super(message);
	}
}
