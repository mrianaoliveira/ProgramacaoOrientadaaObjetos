package hospital;

import java.util.Collection;
import java.util.HashMap;

public class Paciente implements IPaciente{
	
	private String id, diagnostico; //id = nome
	private HashMap<String, IMedico> medicos;
	
	Paciente(String id, String diagnostico) {//construtor com o nome e o diagnostico
		this.id = id;
		this.diagnostico = diagnostico;
		medicos = new HashMap<String, IMedico>();
	}

	@Override
	public String getId() {//get do id
		return id;
	}

	@Override
	public void addMedico(IMedico medico) {//adicionando o medico
		medicos.put(medico.getId(), medico);//adicioando o medico pelo nome no paciente
	}

	@Override
	public void removerMedico(String idMedico) {//removendo o medico
		IMedico medico = medicos.get(idMedico);//pecorrendo o hahsmap dos medicos
		if(medico == null) {
			System.out.println("Esse medico nao existe");
			//opa, o medico n existe
			return;	
		}
		else {//aqui existe 
			medicos.remove(idMedico); //removendo do hashmap
			medico.removerPaciente(getId()); //removendo o medico do paciente
			return;
		}
	}
	
	public String toString() {//toString
		String s = "";
		s += "Paciente: " + this.id + ", doenca: " + this.diagnostico + ", medicos: [";
		for(IMedico medico : medicos.values()) {
			s += medico.getId() + " ";
		}
		return s +"]";
	}

	@Override
	public String getDiagnostico() {
		return diagnostico;
	}

	@Override
	public Collection<IMedico> getMedicos() {
		return medicos.values();
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

}
