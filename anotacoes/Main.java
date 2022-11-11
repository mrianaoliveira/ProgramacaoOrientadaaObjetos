package anotacoes;

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
