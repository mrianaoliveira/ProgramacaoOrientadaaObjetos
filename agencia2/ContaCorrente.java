package agencia2;

public class ContaCorrente extends Conta {
	protected float tarifamensal = 20;
	
	public ContaCorrente(int id, String idCliente) {
		super(id, idCliente);
		this.type = "CC";//defininco q a conta eh corrente
	}
	
	@Override
	public void atualizacaomensal() {//metodo para atualizar
		this.setSaldo(this.getSaldo() - tarifamensal);//do saldo atual, eh diminuido -20 {lá da linha 4}
	}
	
	//get e set
	public float getTarifamensal() {
		return tarifamensal;
	}

	public void setTarifamensal(float tarifamensal) {
		this.tarifamensal = tarifamensal;
	}
	
	
}
