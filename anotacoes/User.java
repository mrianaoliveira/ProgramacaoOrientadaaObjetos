package anotacoes;

import java.util.HashMap;

public class User {
	private String username, password;
	private HashMap<String, Note> notas;
	
	User(String username, String password) {
		this.username = username;
		this.password = password;
		notas = new HashMap<String, Note>();
	}
	
	public void addNote(String title, String content) { //adicioanando as notas
		Note nota = new Note(title, content);//criando uma nova nota
		notas.put(title, nota);
		notas.put(content, nota);
		//adicioando no hashmap
	}
	
	public void rmNote(int index) {//removendo as notas
		for(int i =0; i <= notas.size(); i++) {//percorrendo o hahsmap
			if(i == index) {//vendo se eh a q o caba quer
				this.notas.remove(index);//removendo
			}
		}
	}

	public String toString() { //tostring pra ficar lindo
		return "Usuario: " + this.getUsername() + " " + this.getPassword();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<String, Note> getNotas() {
		return notas;
	}

	public void setNotas(HashMap<String, Note> notas) {
		this.notas = notas;
	}
}
