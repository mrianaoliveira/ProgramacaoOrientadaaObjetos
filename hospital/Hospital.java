package hospital;

import java.util.HashMap;

public class Hospital {
	private HashMap<String, IPaciente> pacientes;
	private HashMap<String, IMedico> medicos;
	
	Hospital(){
		//iniciando os hahsmpap
		pacientes = new HashMap<String, IPaciente>();
		medicos = new HashMap<String, IMedico>();
	}
	
	public void removerPaciente(String id) {//removendo paciente pelo nome
		IPaciente paciente = pacientes.get(id); //pecorrendo o hahsmpa
		if(paciente == null) {//vendo se aquele apciente existe
			System.out.println("Paciente nao existe");//nao existe, paia viu
			return;
		}
		//agora, ja que o paciente existe, eh verificado se o medico ta la 
		for(IMedico medico : paciente.getMedicos()) {
			pacientes.remove(id);//removendo o paciente do hahsmap
			medico.removerPaciente(id); //removendo o medico do paciente
			return;
		}
	}
	
	public void removerMedico(String id) {//removendo o medico pelo nome
		IMedico medico = medicos.get(id);//pecorrendo o hahsmap
		if(medico == null) {//vendo se o medico existe
			System.out.println("Esse medico nao existe");//e o pobi nao existe
			return;
		}
		//que aqui no caso, o medico vai existir e vai ta atendendo algum paciente
		for(IPaciente paciente : medico.getPaciente()) {//pecorrendo o hahsmap do pacientes
			paciente.removerMedico(id);//removendo o medico dos pacientes
			medicos.remove(id);//removendo o paciente do hashmap do paciente
			return;
		}
	}
	
	public void addPaciente(Paciente paciente) {//adicionando paciente
		pacientes.put(paciente.getId(), (IPaciente) paciente);//eh adicionando o nome do paciente na chave do hahsmap
		//e sendo acessado por paciente (da interface IPaciente)
	}
	
	public void addMedico(Medico medico) {
		medicos.put(medico.getId(), (IMedico) medico);//eh adicionando o nome do medico na chave do hahsmap
		//e sendo acessado por medico (da interface IMedico)
	}
	
	public void vincular(String nomeMedico, String nomePaciente) { //metodo para juntar os pacientes com os medicos q dao certo
		IMedico medico = medicos.get(nomeMedico);//pecorrendo o hahsmap
		IPaciente paciente = pacientes.get(nomePaciente);//pecorrendo o hahsmap
		
		if(medico == null) {//vendo se o medico existe
			System.out.println("Esse medico nao existe");
			return;
		}
		else if(paciente == null) {//vendo se o paciente existe
			System.out.println("Esse paciente nao existe \n");
			return;
		}
		else {//se ambos exististirem
			pacientes.get(nomePaciente).addMedico(medico);
			medicos.get(nomeMedico).addPaciente(paciente);
			//eh adicionado o pacinete no medico e o medico no paciente 
		}
		
	}
	
	public void showAll() {//uma toString diferente 
		for(IMedico medico : medicos.values()) {//pecorrendo o hashmap com os seus valores
			System.out.println(medico.toString());//atribuindo a toString das outra classe
		}
		for(IPaciente paciente : pacientes.values()) {//ando pelo hahsmap
			System.out.println(paciente.toString());//atribuindo a toString a outra classe
		}
	}
	
	@Override
	public String toString() {//toString
		String s = "";
		for(IPaciente paciente : pacientes.values()) {
			s += paciente.toString() + " \n";
		}
		for(IMedico medico : medicos.values()) {
			s += medico.toString() + " \n";
		}
		
		return s;
	}

	public HashMap<String, IPaciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(HashMap<String, IPaciente> pacientes) {
		this.pacientes = pacientes;
	}
	public HashMap<String, IMedico> getMedicos() {
		return medicos;
	}
	public void setMedicos(HashMap<String, IMedico> medicos) {
		this.medicos = medicos;
	}
}
