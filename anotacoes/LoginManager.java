package anotacoes;

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
