package anotacoes;

public class DoisUsuariosIguaisException extends RuntimeException {
	//o snehor nao colocou na main mas lá na ataividade dizia que nao poderia haver dois username igual
	//entao aqui ta o bendito
	public DoisUsuariosIguaisException(String message) {
		super(message);
	}
}
