package models;

public class Reptil extends Animal {

	public Reptil(String codigoDeIdentificacion, String especie, String paisDeProcedencia, String observaciones,
			Sexo sexo, String alimentacionBasica) {
		super(codigoDeIdentificacion, especie, paisDeProcedencia, observaciones, sexo, alimentacionBasica);
		tipo = Tipo.REPTIL;
	}

}
