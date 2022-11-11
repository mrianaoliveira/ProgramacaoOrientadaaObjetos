package agencia2;

public class ContaPoupanca extends Conta {
	protected float rendimento;

	public ContaPoupanca(int id, String idCliente) {
		super(id, idCliente);
		this.type = "CP"; //definindo q a conta eh poupanca
	}
	
	@Override
	public void atualizacaomensal() {//metodo de atualizacao mensal
		float novosaldo = (this.saldo * 1)/100;//eh vendo q valor vai da porque estava correndo juros
		this.setSaldo(this.getSaldo() + novosaldo);//e adicionado ao valor atual
	}
	
	//set e get

	public float getRendimento() {
		return rendimento;
	}

	public void setRendimento(float rendimento) {
		this.rendimento = rendimento;
	}
}
