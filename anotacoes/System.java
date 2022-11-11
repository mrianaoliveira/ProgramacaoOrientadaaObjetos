package anotacoes;

import java.util.HashMap;

public class System {
	
	private  HashMap<String, User> usuario;
	private HashMap<String, Note> notas;//eu sei q era pr ausar vetor mas eu acho mais top assim e fica mais facil pra mim
	private LoginManager loginManager;
	
	public System() {
		usuario = new HashMap<String, User>();
		notas = new HashMap<String, Note>();
		//iniciando os hashmap
	}
	
	public void addNote(String title, String content) {//adicionado as notas
		Note nota = new Note(title, content);//criando uma nova nota
		notas.put(title, nota);
		notas.put(content, nota);
		//adicionado nos hashmap
	}
	
	public void addUser(String username, String password) throws Exception{//adicionaod o usuario
		User user = new User(username, password);//crianod um novo usario
		if(this.usuario.containsKey(username)) {//vendo se  nome ja existe
			throw new Exception("Macho pelo amor de dois ja outro tem um com esse nome");//ja existe
		}
		this.usuario.put(username, user);
		this.usuario.put(password, user);
		//se nao eh adicionado la no usuaior
	}
	
	public String getUsername() { //pra mostrar tosos os usuaiross
		String s = "";
		for(User u : usuario.values()) { //percorrendo o usuairos
			s += u.toString() + "\n";
		}
		for(Note n : notas.values()) {//e as notas
			s +=n.toString();
		}
		return s;
	}
	
	public HashMap<String, User> getUsuario() {
		return usuario;
	}
	public void setUsuario(HashMap<String, User> usuario) {
		this.usuario = usuario;
	}
	public LoginManager getLoginManager() {
		return loginManager;
	}
	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}
}
