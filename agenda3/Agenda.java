package agenda3;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

//Maps:
/* get: mostra os valores
 * keuSet mostra as chaves
 *  estancaidoMaps.put(""); // adiciona os coisas no maps 
 */

public class Agenda {
	private HashMap<String, Contact> contacts;
	private HashMap<String, Contact> bookmarks;
	
	public Agenda() {//metodo construdotr
		this.contacts = new HashMap<String, Contact>();
		this.bookmarks = new HashMap<String, Contact>();
		//criando os hashmap
	}
	
	public void addContact(String name, List<Fone> fones) {
		//do jeito que tava lá ma main, era necessário criar outra arraylist para colocar os 
		//dados dos pessoas
		Contact c = contacts.get(name); //atribuindo uma variavel ao contato
		if(c==null){ //se esse contato nao existir
			c=new Contact(name); //é criado um novo nome
			c.setFone(fones);//e um novo numero para esse contato
			contacts.put(name, c);//criando no fim, um novo contato
		}
		else {//senao
			System.out.println("o contato: " +name + " já existe");//o contato já existe
		}
		
	}	

	public void addContact(String name, String fone) {//criando agr o contato {do anterior}
		Contact contato = getContact(name); //atribuindo uma varial ao contato
		if(contato == null) {//se não existir
			contato = new Contact(name); //é criado outro contato
			contato.addFone(name, fone); //adicionando o nome e um fone
			//eh um complemento do método anetrior, no outro é criado o conto e 
			//aqui é preenchido 
		}
		else {//e como tem gente que tem dois numeros
			contato.addFone(name, fone);//eh adicionado o outro numero
		}
	}
	
	public boolean rmContact(String name) { //metodo pra remover o contato
		Contact contato = getContact(name); //atribuindo o nome do contato para a variavel contato
		if(contato == null) { //vendo se existe
			System.out.println("o contato nao existe"); //senoa, o contato não existe
			return false;
		}else{ //se o contator existir
			contacts.remove(name); //eh removido 
			if(contato.isStarred()) { //vendo se o contato esta nos favoritos
				bookmarks.remove(name); //se esta, eh tirado de lá também
			}
			return true;

		}
	}
	
	Contact getContact(String name) { //funcao que retorna todos os conatos
		for(String c : contacts.keySet()   ) { //olhando cada contato
			if(c.equals(name)) { // se o nome eh o mesmo nome da agenda
				return contacts.get(c); // eh retornado todos os contatos que tem na agenda
			}
		}
		return null; //senao tiver contato, eh retornado nullo
	}
	
	public void star(String name) { //funcao de bookmarkId
		//metodo pra saber se eh favorito
		Contact contato = contacts.get(name) ; //atribuindo uma varial ao nome do conatato
		if(contato == null) {// se nao existir 
			System.out.println("Fail:  contato " +name + " nao existe"); //eh printado isso
			return;
		}
		if(contato.isStarred() == false) { // olhando se o contato nao esta nos favoritos
			//caso nao esteja
			contato.setStarred(true); //agora esta
			bookmarks.put(name, contato);// adiciondo no hashmap
			return;
		}
		return;
	}
	
	public void unstar(String name) { //funcao de unbookmark
		//metodo desfavoritar 
		Contact contato = contacts.get(name); //criando um novo atributo para o contato
		if(contato == null) { //vendo se o contato existe
			System.out.println("o contato nao existe");
			return;
		}
		if(contato.isStarred() == true) {//se for verdadeiro {estiver nos favoritos
			contato.setStarred(false); //eh dado um false {dizendo que nao eh mais favorito
			bookmarks.remove(name);//e removendo no hashmap
		}
	}
	
	public ArrayList<Contact> getStarred() { //mesma função de getBookmarks
		//metodo para retornar os favoritos
		ArrayList<Contact> l = new ArrayList<Contact>(); //criando uma nova arraylist para colocar os favoritos
		for(String s : bookmarks.keySet()) { //percorrendo os favoritos
			Contact c = bookmarks.get(s); //de for favorito
			l.add(c); //adiciona nesse arraylist
		}

		return l;
	}
	
	public HashMap<String, Contact> getContacts() {
		return contacts;
	}

	public void setContacts(HashMap<String, Contact> contacts) {
		this.contacts = contacts;
	}

	public HashMap<String, Contact> getBookmarks() {
		return bookmarks;
	}

	@Override
	public String toString() {
		
		String s = "\n";
		for(String k : contacts.keySet()){
			Contact c  = contacts.get(k);
			s+= c.toString()+"\n";
		}
		//metodo para imprimir do jeito que se pede {os bookmarks}
		return s+"\n";
	}

}