//CLASSE FUNCIONARIO

package salario;

public abstract class Funcionario {
	protected String nome;
	protected int max_diarias; //maximo de dias q pode receber
	protected int qtd_diarias; //maximo de dirias q ja recebeu
	protected double bonus; //qnt de bonu recebeu
	protected double salario;
	
	Funcionario(String nome, int max_diarias) { //metodo contrutor 
		this.nome = nome;
		this.max_diarias = max_diarias;
		this.qtd_diarias = 0;
		this.bonus = 0;
		this.salario = 0;
	}

	public void adicionarDiaria() { //metodo adicionar diaria 
		//vendo se a quantidade maxima de diras eh maior que a quantidade de diaria do caba
		if(this.getQtd_diarias() <= this.getMax_diarias()) { //senao for, então pode ter diaira
			this.setSalario(this.getSalario() + 100); //adicionando 100 ao salario
			qtd_diarias++; //e aumetando a quantidade de diarias
		}
		else {//senao, significa que a diaria eh maior que a permitida 
			System.out.println("Limite de diarias atigindas");
		}
	}
	
	public void adicionarBonus(double bonus) {//metodo para adicionar bonus
		this.setSalario(this.getSalario() + bonus ); //adicionando o bonus ao salario
	}
	
	abstract double calcSalario(); //metodo abstrato para calcular o salario
	
	//set e get
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMax_diarias() {
		return max_diarias;
	}
	public void setMax_diarias(int max_diarias) {
		this.max_diarias = max_diarias;
	}
	public int getQtd_diarias() {
		return qtd_diarias;
	}
	public void setQtd_diarias(int qtd_diarias) {
		this.qtd_diarias = qtd_diarias;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}

//CLASSE UNIVERSIDADE

package salario;

import java.util.ArrayList;

public class Universidade {
	private ArrayList<Funcionario> funcionarios;
	
	Universidade() {
		funcionarios = new ArrayList<>(); //criando o array
	}
	
	public void addFuncionario(Funcionario funcionario) { //metodo adicionando funcionario 
		funcionarios.add(funcionario);//adicionando no array 
	}
	
	public void removerFuncionario(String nome) {//metodo removendo funcionario
		for(Funcionario f : funcionarios) {//percorrendo todo o array
			if(f.getNome() == null) {//se o nome q procura for igual a nulo
				System.out.println("Funcionario nao existe");//significa q o funcionario nao existe
				return;
			}// se nao
			else if(f.getNome().equals(nome)){//e novamente procurado o nome que desejas no vetor
				funcionarios.remove(f);//e eh removido
				return;
			}
		}
	}
	
	public void distribuirBonus(float valor) {//metodo distribuir bonos 
		double total = valor/(funcionarios.size()); //atribuindo um novo atributo, q ira pegar o valor do bonus
		// e dividir com todos os funcionarios
		for(Funcionario f : funcionarios) {//percorrendo todo o array
			f.adicionarBonus(total);//e adicionando o valor
		}
	}

	public String toString() {//to string
		String s = "";
		for(Funcionario f: funcionarios) { //percorrendo todo o array
			s += f.toString() + "\n";//e pegando cada funcionario, atribuindo os toString das outras classe e pulando uma linha
		}
		return s;//retornando o que foi citado acima
	}
	
	//set e get
	public ArrayList<Funcionario> getFuncionario() {
		return funcionarios;
	}

	public void setFuncionario(ArrayList<Funcionario> funcionario) {
		this.funcionarios = funcionario;
	}
}


//CLASSE PROFESSOR

package salario;

public class Professor extends Funcionario {
	private char classe;
	
	Professor(String nome, char classe) {//construtor
		super(nome, 2);//sobrepondo o contsturor do funcincionario
		this.classe = classe;
 	}
	
	@Override
	public double calcSalario() {//calculando o salario
		double valor = getQtd_diarias() * 100 + getBonus();//adicionaod as diarias e o bonus
		valor += ((classe - 'A') * 2000) + 3000;//calculando o salario:
		//o - 'A' significa que ira diminuir - 1, caso nao encontre a classe q deseja, até achar
		//achado é multiplicado ppor 2000 (ex: classe A: 0 * 2000) e adicionando a 3000 no valor;
		return this.salario = valor;// e o salario vai receber esse valor
	}
	
	public void adicionarDiaria() {//adicionando diarias 
		//vendo se a quantidade maxima de diras eh maior que a quantidade de diaria do caba
		if(this.getQtd_diarias() <= this.getMax_diarias()) { //senao for, então pode ter diaira
			this.setSalario(this.getSalario() + 100); //adicionando 100 ao salario
			qtd_diarias++; //e aumetando a quantidade de diarias
		}
		else {//senao, significa que a diaria eh maior que a permitida 
			System.out.println("Limite de diarias atigindas");
		}
	}
	
	public void adicionarBonus(double bonus) {//metodo adicioanr bonus
		this.setSalario(this.getSalario() + bonus );//pega o salario e adiciona ao bonus
	}
	
	//set e get
	@Override
	public String toString() {//metodo tostring
		this.salario = calcSalario() + getBonus();//dizendo que o salario eh igual ao calculo do salario + os bonus
		return "Professor " +this.getNome() + ", classe " + this.classe + ", salario: " + this.getSalario();
	}
	
	public char getClasse() {
		return classe;
	}

	public void setClasse(char classe) {
		this.classe = classe;
	}
}


//CLASSE TERCEIRIZADO

package salario;

public class Terceirizado  extends Funcionario{
	private int horas_trab;
	private boolean insalubre;
	
	Terceirizado(String nome, int horas_trab, boolean insalubre) {//construtor
		super(nome, 0);//sobrepondo o construtor do funcionario
		this.horas_trab = horas_trab;
		this.insalubre = insalubre;
	}
	
	@Override
	public double calcSalario() {//metodo calculando salario
		//o salario de terceirizado eh calculo multiplicado as horas por 4
		this.setSalario(4 * this.getHoras_trab());
		if(this.insalubre == true) {// se for insalubre
			this.setSalario(this.getSalario() + 500 + this.getBonus());//significa que sera adicionado 500 na conta do homi
			//ps: nao entendi o que siginifica esse insalubre
		}
		return this.getSalario();//retornando o salario 
	}
	
	public void adicionarDiaria() {//meotod adicionando diaria
		System.out.println("\nfail: terceirizado nao pode receber diaria");//tercerizado nao pode receber diaria :(
	}
	
	public void adicionarBonus(double bonus) {//adicioanr bonus
		this.setSalario(this.getSalario() + bonus );//adicioando ao salario o bonus
	}
	
	public String toString() {
		this.salario = calcSalario() + getBonus();//dizendo que o salario eh igual ao calculo do salario + os bonus
		return "\nTerceirizado " + this.getNome() + ", horas trabalhadas " + this.getHoras_trab() + ", insalubre? "
			+ this.isInsalubre() + ", salario: " + this.getSalario();
	}
	
	//get e set
	public int getHoras_trab() {
		return horas_trab;
	}
	public void setHoras_trab(int horas_trab) {
		this.horas_trab = horas_trab;
	}
	public boolean isInsalubre() {
		return insalubre;
	}
	public void setInsalubre(boolean insalubre) {
		this.insalubre = insalubre;
	}
}


//CLASSE STA

package salario;

public class STA extends Funcionario {
private int nivel;
	
	STA(String nome, int nivel) {
		super(nome, 1);
		this.nivel = nivel;
	}
	
	@Override
	public double calcSalario() {//metodo calculando o salario
		double valor = getQtd_diarias() * 100 + getBonus();//somano as diarias + o bonus
		valor += (3000 + (300 * nivel)); //adicionado 3000 e somando com 300 * nivel do caba
		return valor;//retornando o valor real e oficial 
	}
	
	public void adicionarDiaria() {//metodo adicionar diaria
		//vendo se a quantidade maxima de diras eh maior que a quantidade de diaria do caba
		if(this.getQtd_diarias() <= this.getMax_diarias()) { //senao for, então pode ter diaira
			this.setSalario(this.getSalario() + 100); //adicionando 100 ao salario
			qtd_diarias++; //e aumetando a quantidade de diarias
		}
		else {//senao, significa que a diaria eh maior que a permitida 
			System.out.println("Limite de diarias atigindas");
		}
	}
	
	public void adicionarBonus(double bonus) {//metodo adicionar bonus
		this.setSalario(this.getSalario() + bonus ); //adicioando ao salario o bonus
	}
	
	@Override
	public String toString() {
		this.salario = calcSalario() + getBonus(); //dizendo que o salario eh igual ao calculo do salario + os bonus
		return "\nSTA " + this.getNome() + ", nivel " + this.getNivel() + ", salario: " + this.getSalario();
	}
	
	//set e get
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}


//A MAIN {ALTERADO PORQUE OS METODOS ESTAVAM ESCRITOS DE OUTRO JEITO, MAS DEU CERTO NO FIM (:

package salario;

public class Main {

	public static void main(String[] args) {
		Universidade universidade = new Universidade();
		Professor david = new Professor("David", 'C');
		
		universidade.addFuncionario(david);
		universidade.addFuncionario(new Professor("Elvis", 'D'));
		STA gilmario = new STA("Gilmario", 3);
		universidade.addFuncionario(gilmario);
		Terceirizado helder = new Terceirizado("Helder", 40, true);
		universidade.addFuncionario(helder);
		System.out.println(universidade);
		
		universidade.removerFuncionario("elvis");
		System.out.println(universidade);
		
		david.adicionarDiaria();
		david.adicionarDiaria();
		david.adicionarDiaria();
		
		System.out.println(david);
		
		gilmario.adicionarDiaria();
		gilmario.adicionarDiaria();
		System.out.println(gilmario);
		
		helder.adicionarDiaria();
		
		universidade.distribuirBonus(600.0f);
		System.out.println(gilmario);	
	}
}

