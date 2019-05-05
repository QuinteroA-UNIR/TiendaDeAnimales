package models;

public abstract class Animal {
	
	public String codigoDeIdentificacion;
	
	public String especie;
	
	public String paisDeProcedencia;
	
	public String observaciones;
	
	public String alimentacionBasica;
	
	public Sexo sexo;
	
	protected Tipo tipo;
	
	public Tipo getTipo() {
		return tipo;
	}


	public Animal(String codigoDeIdentificacion, String especie, String paisDeProcedencia, String observaciones,
			Sexo sexo, String alimentacionBasica) {
		this.codigoDeIdentificacion = codigoDeIdentificacion;
		this.especie = especie;
		this.paisDeProcedencia = paisDeProcedencia;
		this.observaciones = observaciones;
		this.sexo = sexo;
		this.alimentacionBasica = alimentacionBasica;
	}


	@Override
	public String toString() {
		return codigoDeIdentificacion + " - " + especie;
	}
}
