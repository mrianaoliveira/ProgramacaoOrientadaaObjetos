package agencia2;

import java.util.HashMap;
//usando hahsmpa porque arraylist tava era me deixando ariada, no começo dava bom e no fim tava
//dando mais erro que num sei nem oq

public class Agencia {
	//iniciando os hahsmpa
	protected HashMap <String, Cliente> clientes;
	protected HashMap <Integer, Conta> contas;
	protected int nextid; //criando uma variavel para que possa criar as duas contas {poupanca e a concorrente}
	
	public Agencia() {
		//criando so hahsmap
		clientes = new HashMap<String, Cliente>();
		contas = new HashMap<Integer, Conta>();
		this.nextid = 0; //comecando do 0, porque no exercicio começa com 0
	}

	public void adicionarCliente(String id) { //metodo para adicionar cliente
		if(clientes.get(id) == null) { //vendo se indice não existe, caso não exista 
			Cliente cliente = new Cliente(id); //criando uma nova conta
			Conta corrente = new ContaCorrente(nextid++, id); //dessa conta, é criando uma conta corrente
			Conta poupanca = new ContaPoupanca(nextid++, id); //e depois uma conta poupança
			
			clientes.put(id, cliente); //eh adicionado no hashmap
			contas.put(corrente.id, corrente);//sendo assim, eh adicionado um id para cada conta, na corrente
			contas.put(poupanca.id, poupanca); //e na poupança
		}
	}
	
	public void depositar(int indice, float value) { //metodo depositar o dinheiro
		if(contas.containsKey(indice)) { //procurando a chave {vulgo indice}
			Conta conta = contas.get(indice); //se a conta for achada,
			conta.depositar(value);//eh adicionado no valor da vonta
		}
		else {//se nao
			System.out.println("A conta nao foi encontrada/naoexiste");//a conta nao existe
		}
	}
	
	public void sacar(int indice, float value) {//metodo sacar
		if(contas.containsKey(indice)) {//procurando o indice
			Conta conta = contas.get(indice);//se a conta for achada
			conta.sacar(value);//eh sacado da conta
		}
		else {//se nao
			System.out.println("a conta nao foi encontrada/nao existe");//a conta nao existe
		}
	}
	
	public void transferir(int indice1, int indice2, float value) { //meotodo trasnferir
		if(contas.containsKey(indice1) && contas.containsKey(indice2)) {//procurando o indice
			Conta c1 = contas.get(indice1); //se a conta existe
			Conta c2 = contas.get(indice2);//se a conta existe
			c1.sacar(value);//eh tirardo o valor da conta1
			c1.transferir(c2, value);// e adicionado o valor na conta 2
		}
		else {//senao
			System.out.println("A conta nao existe");//a conta nao existe
		}
	}
	
	public void atualizar() {//metodo atualizar
		for(Conta c : contas.values()) { //para cada Conta c ira peccorer o valor
			if(c.equals("CC")) {//se a conta for corrente
				ContaCorrente corrente = (ContaCorrente) contas.get(c.id);//a conta eh achada {buscada pelo indice}
				corrente.atualizacaomensal();//e eh atualizado
			} 
			else if(c.equals("CP")) {// se a conta for poupanca
				ContaPoupanca poupanca = (ContaPoupanca) contas.get(c.id);// a conta eh achada {buscando pelo indice
				poupanca.atualizacaomensal();//e eh atualizada lá
			}
		}
	}
	
	@Override
	public String toString() {//metodo para ficar bonito no console 
		String resul = "";
		for(Conta c : contas.values()) {
			resul += c + "\n";
		}
		return resul;
	}
	//get e se
	public HashMap<String, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashMap<String, Cliente> clientes) {
		this.clientes = clientes;
	}

	public HashMap<Integer, Conta> getContas() {
		return contas;
	}

	public void setContas(HashMap<Integer, Conta> contas) {
		this.contas = contas;
	}

	public int getNextid() {
		return nextid;
	}

	public void setNextid(int nextid) {
		this.nextid = nextid;
	}
	//getConta, depois de ajeitar a cambiarra, deu certo
	public Conta getConta(int id) {
		return contas.get(id);
		/*ps: eu tiha feito isso mas o compilador fez o favor de da erro ai acabou que apaguei
		 * ai depois de tentar entender a iscandilice q eu fiz, resolvi tentar de novo e acabou q deu certo
		 * {ps2: ódio mortal, dor de cabeça a toa
		 */
	}
}