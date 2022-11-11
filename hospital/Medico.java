package hospital;

import java.util.HashMap;
import java.util.Collection;

public class Medico implements IMedico {
	
	private String id, especialidade; //nome e especialidade do medico
	private HashMap<String, IPaciente> pacientes; //hashmap pra implementar os pacientes
	
	Medico(String id, String especialidade) { //construtor passando o nome e a especialidade
		this.id = id;
		this.especialidade = especialidade;
		pacientes = new HashMap<String, IPaciente>(); //definindo o hashmap
	}

	@Override
	public String getId() { //get do nome do medico
		return id;
	}

	@Override
	public void addPaciente(IPaciente paciente) { //adicionando o paciente no hospital
		pacientes.put(paciente.getId(),(IPaciente) paciente); //adicionando o nome do caba em paciente
	}

	@Override
	public void removerPaciente(String idPaciente) { //removendo o homi
		IPaciente paciente = pacientes.get(idPaciente); //mecorrendo o hahsmap de pacientes
		if(paciente == null) { //vendo se o pacienete eh nulo
			System.out.println("Paciente nao existe");//ou seja nao existe
			return;
		}
		else {//senao
			pacientes.remove(idPaciente); //removendo o paciente da classe Paciente
			pacientes.remove(getId());//removendo o paciente do hahsmap
			return;
		}
	}

	@Override
	public String getClasse() {
		return null;
	}
	
	public String toString() {//printar do jeito lindo lá
		String s = "";
		s += "Medico: " + this.id + ", epecialidade: " + this.especialidade + ", pacientes: [";
		for(IPaciente paciente : pacientes.values()) {//percorrendo o hahsmap dos pacientes
			s += paciente.getId() +  " ";//q eh pra adicionar do jeito q pede (com os pacientes na frente)
		}
		return s + "]";
	}
	
	public Collection<IPaciente> getPacientes() {
		return pacientes.values();
	}
	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<String, IPaciente> getPacientes1() {
		return pacientes;
	}

	public void setPacientes(HashMap<String, IPaciente> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public Collection<IPaciente> getPaciente() {
		return pacientes.values();
	}
}
