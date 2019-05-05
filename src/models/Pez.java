package models;

public class Pez extends Animal {
	

	public Pez(String codigoDeIdentificacion, String especie, String paisDeProcedencia, String observaciones, Sexo sexo,
			String alimentacionBasica) {
		super(codigoDeIdentificacion, especie, paisDeProcedencia, observaciones, sexo, alimentacionBasica);
		tipo = Tipo.PEZ;
	}

}
