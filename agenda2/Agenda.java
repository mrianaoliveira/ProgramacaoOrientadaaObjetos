package agenda2;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private ArrayList<Contact> contatos;
	
	public Agenda() {
		contatos = new ArrayList<Contact>(); //criando o array
	}

	@Override
	public String toString() {
		//pra imprimir do jeito que pede
		String s = "\n";
		for(int i = 0; i < contatos.size(); i++) {
			Contact c = contatos.get(i);
			s += c.toString();
		}
		return s;
	}

	public void addContact(String name, List<Fone> fones) { //metodo para adicionar o contato
		Contact cont = getContato(name); //procurando o nome do caba
		if(cont == null) { //se naõ existir
			cont = new Contact(name); //vai criar um novo fone
			for(Fone f : fones){ //percorrendo a lsit de fone
				cont.addFone(f.getLabel(),f.getNumber()); //criando um contatoc com a operadora e o numero
			}
			contatos.add(cont); //adicionando na no arraylist
		} else { //se o contato já existir
			for(Fone f : fones) { //vai percorrer
				cont.addFone(f.getLabel(), f.getNumber()); // e adicionar uma nova operadora e um novo numero
			}
		}
	}

	public boolean rmContact(String name) { //metodo para remover o contato
		Contact contat = getContato(name); //procurando o nome do rapaz
		if(contat == null) {//se for nulo, não existe
			System.out.println("o contato nao existe"); //e vai isso
			return false;
		} //senao
		contatos.remove(contat);// o contato eh removido
		return true;
	}
	
	private int findContact(String name) { //meotod para procuraar o nome que desejas
		for(int i = 0 ; i < contatos.size(); i++){ //pecorrendo todos os contatos
			Contact c = contatos.get(i); // criando uma varial para procurar o nome
			if(c.getName().equals(name)){//se o nome for igual ao nome que deseja procurar
				return i;//ira retornar o nome de quem procura
			}
		}
		return -1;//fazendo comm que procure em todo os contatos
	}
	
    public ArrayList<Contact> search(String label){ //metodo para pesquisar
    	//metodo para pesquisar só contatos especificos, que irá adicionar em outro array
        ArrayList<Contact> pesquisar = new ArrayList<Contact>(); //criando um novo array da pesquisa 
        for(Contact cont : contatos){ //percorrrendo todos os contatos
            if(cont.toString().indexOf(label) != -1) //se o que desejas for achado
                pesquisar.add(cont); //sera adicionado no array
        }
		if(pesquisar.size()>0) //pesquisando todos os contatos que o caba queira procurar
			return pesquisar; //retornando os contatos
        else
			return null; //ou nada, se não for achado
    }
    

	public Contact getContato(String nome) { //meotodo para pesquisar o nome
		for(Contact c : contatos){ //percorrendo o array
			if(nome.equals(c.getName())){ //se o nome que desejas for igual
				return c;//ira retornar esse nome
			}
		}
		return null;
	}

	public void setContato(ArrayList<Contact> contato) {
		this.contatos = contato;
	}

	public void rmFone(String name, int index) { //metodo para remover o contato
		Contact c = getContato(name); //criando uma variavel para procurar esse contato
		if(c != null) //se ese contato exitir
			c.rmFone(name, index); //sera removido
		else//senao
			System.out.println("Contato não existente");//o contato nao existe 
	}
}