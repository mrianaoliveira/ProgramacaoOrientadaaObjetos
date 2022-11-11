package agencia1;

public class Operacao {
	public int conta, id;
	public String descricao;
	public float valor, saldo;

	public String toString() {
		return  id+": "+descricao+":    +"+valor+":   "+saldo;
	}
	
	public Operacao (int id, int conta , String descricao, float valor, float saldo) {
		this.conta = conta;
	    this.id = id;
	    this.descricao = descricao;
	    this.valor = valor;
        this.saldo = saldo;
	}
}
