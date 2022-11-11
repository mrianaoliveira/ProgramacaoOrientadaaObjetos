package agencia2;

public class Conta {
	protected int id; //num de conta
	protected float saldo;
	protected String idCliente;//nome do caba 
	protected String type; //tipo de conta
	
	public Conta(int id, String idCliente) { //construtor
		this.id = id;
		this.saldo = 0;
		this.idCliente = idCliente;
		this.type = "";
	}	
	
	public void sacar(float value) {//metodo sacar
		if(this.type.equals("CP")) {//vendo se a cconta é a poupanca
			if((this.saldo-value) > 0) {//se for e o saldo - valor for mair q 0
				this.setSaldo(getSaldo() - value); //entao é feito o saque
			} 
			else {//se nao
				System.out.println("Saldo insuficiante \n");//nao eh feito o saque porque o saldo é menor q o esperado
			}
		}
		else if(this.type.equals("CC")) {//vendo se a conta eh a corrente
			this.setSaldo(this.getSaldo() - value);//se for, ai eh realiazado o saque
		}
	}
	
	public void depositar(float value) {//metodo depositar
		if(this.type.equals("CP")) {//vendo se a conta eh poupanca
			this.setSaldo(this.getSaldo() + value);//se for ai eh feito o o deposito
		}
		else if(this.type.equals("CC")) { //vendo se a onta eh corrente
			this.setSaldo(this.getSaldo() + value);//se for ai eh feito o deposito
		}
	}
	
	public void transferir(Conta other, float value) { 
		//metodo transferir, passando uma conta e o valor
		other.setSaldo(this.getSaldo() + value); //o valor da outra conta, somando com o valor passado pela primeira conta
	}
	
	public void atualizacaomensal() { //metodo para atualizar a conta {vulgo saldo}
		if(this.type.equals("CC")) { //vendo se a conta é a conrrente
			this.setSaldo(getSaldo() - 20); //se for, é dimunuido 20 reais do saldo atual
		} 
		else if(this.type.equals("CP")){// se a conta for a poupanca
			float novosaldo = (this.saldo * 1)/100;//eh feito a porcentagem pra saber quanto lucrou
			this.setSaldo(this.getSaldo() + novosaldo);//e adicionado ao saldo atual
		}
	}
	
	@Override
	public String toString() {//metodo toString, printar bonito lá
		return "[" + this.getId() + ":" + this.getIdCliente() + ":" + this.getSaldo() + ":" + this.getType() + "]";
	}
	//get e set

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
