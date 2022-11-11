//CLASSE DoisUsuariosIguaisException

public class DoisUsuariosIguaisException extends RuntimeException {
	//o snehor nao colocou na main mas lá na ataividade dizia que nao poderia haver dois username igual
	//entao aqui ta o bendito
	public DoisUsuariosIguaisException(String message) {
		super(message);
	}
}

//CLASSE LOGINMANAGER

import java.util.HashMap;

public class LoginManager {
	private HashMap<String , User> usuarios;
	private User corretUser;
	
	public LoginManager(HashMap<String, User> usuarios, User corretUser) {
		super();
		this.usuarios = usuarios;
		this.corretUser = corretUser;
	}
	
	public void login(String username, String password) throws RuntimeException {//metodo de login
		if(!this.usuarios.containsKey(password)) { //vendo se a senha eh a certa
			throw new SenhaInvalidaException("Senha incorreta, abestado");
		}
		else if(!this.usuarios.containsKey(username)) {//vendo se o nome eh o ceerto
			throw new UsuarioNaoLogadoException("Macho pelo amor de dois ja outro tem um com esse nome");
		} 
		else {//senoa eh acionado no hashmap
			this.usuarios.put(username, corretUser);
			this.usuarios.put(password, corretUser);
		}
	}
	
	public void logout() throws RuntimeException {//meotdo para ver se tem alguem
		if(this.getCorretUser() == null) {//vendo se n tem ninguem
			throw new UsuarioNaoLogadoException("Tem ninguem aqui nao corno");
		}
	}
	
	public HashMap<String, User> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(HashMap<String, User> usuarios) {
		this.usuarios = usuarios;
	}
	public User getCorretUser() {
		return corretUser;
	}
	public void setCorretUser(User corretUser) {
		this.corretUser = corretUser;
	}
}


//CLASSE NOTE

public class Note {
	
	private String title, contenet;
	
	Note(String title, String contenet) {
		this.title = title;
		this.contenet = contenet;
		//construtor
	}
	
	public String toString() {//a toString pra sair lindo
		return this.getTitle() + ":" + this.getContenet();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContenet() {
		return contenet;
	}

	public void setContenet(String contenet) {
		this.contenet = contenet;
	}
}

//CLASSE SenhaInvalidaException

public class SenhaInvalidaException  extends RuntimeException{
	//pra ver a senha eh a certa {aqui nao eh}
	public SenhaInvalidaException(String message) {
		super(message);
	}
}


//CLASSE SYSTEM

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

//CLASSE USER

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


//CLASSE UsuarioNaoEncontratoException 

public class UsuarioNaoEncontratoException extends RuntimeException{
	//caso o suaurio nao existe
	public UsuarioNaoEncontratoException (String message) {
		super(message);
	}
}

//CLASSEUsuarioNaoLogadoException 

public class UsuarioNaoLogadoException extends RuntimeException{
	//usuairo nao esta onde devia ta {ou nao existe
	public UsuarioNaoLogadoException(String message) {
		super(message);
	}
}


//CLASSE MAIN

public class Main {
	public static void main(String[] args) throws Exception {
		
		System system = new System();
		system.addUser("david", "123");
		system.addUser("luana", "541");
		java.lang.System.out.println(system.getUsername());
		
		try {
			system.getLoginManager().login("david", "144");
		}catch(SenhaInvalidaException e) {
			java.lang.System.out.println("fail: senha invalida");
		}catch(UsuarioNaoEncontratoException e) {
			java.lang.System.out.println("fail: usuario nao encontrado");
		}

		try {
			system.getLoginManager().login("davi", "123");
		}catch(SenhaInvalidaException e) {
			java.lang.System.out.println("fail: senha invalida");
		}catch(UsuarioNaoEncontratoException e) {
			java.lang.System.out.println("fail: usuario nao encontrado");
		}
		
		try {
			system.getLoginManager().login("david", "123");
		}catch(SenhaInvalidaException e) {
			java.lang.System.out.println("fail: senha invalida");
		}catch(UsuarioNaoEncontratoException e) {
			java.lang.System.out.println("fail: usuario nao encontrado");
		}
		
		try {
			system.getLoginManager().logout();
		}catch(UsuarioNaoLogadoException e) {
			java.lang.System.out.println("fail: ninguem logado");
		}
		
		try {
			system.getLoginManager().logout();
		}catch(UsuarioNaoLogadoException e) {
			java.lang.System.out.println("fail: ninguem logado");
		}
		
		try {
			system.getLoginManager().login("david", "123");
		}catch(SenhaInvalidaException e) {
			java.lang.System.out.println("fail: senha invalida");
		}catch(UsuarioNaoEncontratoException e) {
			java.lang.System.out.println("fail: usuario nao encontrado");
		}
		
		try {
			system.addNote("compras", "comprar banana ovo xilito mexirica e melancia");
			system.addNote("farmacia", "comprar tilenol, omeprazol, doril e soro");
			java.lang.System.out.println(system.getLoginManager().getCorretUser());
			system.getLoginManager().logout();
		}catch(UsuarioNaoLogadoException e) {
			java.lang.System.out.println("fail: ninguem logado");
		}
//		user: david
//		[0:compras:comprar banana ovo xilito mexirica e melancia]
//		[1:farmacia:comprar tilenol, omeprazol, doril e soro]
		
		try {
			system.getLoginManager().login("luana", "541");
		}catch(SenhaInvalidaException e) {
			java.lang.System.out.println("fail: senha invalida");
		}catch(UsuarioNaoEncontratoException e) {
			java.lang.System.out.println("fail: usuario nao encontrado");
		}
		
		try {			
			system.addNote("filmes_favoritos ", "moana, ariel, bela adormecida");
			system.addNote("cores ", "azul, vermelho, verde, anil");
			java.lang.System.out.println(system.getLoginManager().getCorretUser());
			system.getLoginManager().logout();
		}catch(UsuarioNaoLogadoException e) {
			java.lang.System.out.println("fail: ninguem logado");
		}
//		user: luana
//		[0:filmes_favoritos:moana, ariel, bela adormecida]
//		[1:cores:azul, vermelho, verde, anil]
		
		try {
			system.getLoginManager().login("david", "123");
		}catch(SenhaInvalidaException e) {
			java.lang.System.out.println("fail: senha invalida");
		}catch(UsuarioNaoEncontratoException e) {
			java.lang.System.out.println("fail: usuario nao encontrado");
		}
		
		try {
			java.lang.System.out.println(system.getLoginManager().getCorretUser());
		}catch(UsuarioNaoLogadoException e) {
			java.lang.System.out.println("fail: ninguem logado");
		}
//		user: david
//		[0:compras:comprar banana ovo xilito mexirica e melancia]
//		[1:farmacia:comprar tilenol, omeprazol, doril e soro]
		
	}
}

