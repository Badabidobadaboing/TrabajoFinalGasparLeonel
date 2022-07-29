package ar.edu.unju.edm.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Entity
@Component
public class Pelicula {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer idPelicula;
	    @NotEmpty(message = "El nombre no puede estar en vacio")
	    private String nombre;
	    @NotEmpty(message = "El tipo de pelicula no puede estar en vacio")
	    private String tipoPelicula;
	    @Size(min = 0 ,max = 200, message = "No debe superar los 200 caracteres")
	    @NotEmpty(message = "Escriba una breve descripcion del curso")
	    private String descripcion;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate fechaInicio;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate fechaFinal;
	    @Positive(message = "No puede tener 0 hrs")
	    private int duracion;
	    @Positive(message = "No puede tener 0 hrs")
	    private int horario1;
	    @Positive(message = "No puede tener 0 hrs")
	    private int horario2;
	    @Positive(message = "No puede tener 0 hrs")
	    private int horario3;
	    @Positive(message = "Debe tener al menos 1 sala")
	    private int sala;
	    @Lob
		@Column(name = "prod_imagen", columnDefinition = "LONGBLOB")
		private String imagen;
		private Boolean estado;
		@Column
		private Integer numeroDeComentarios=0;
		
		/*
		 * 
		@OneToMany(mappedBy = "poi", cascade = CascadeType.ALL)
		private List<UserPeliculaValor> valoracionesComentarios;
		
        public List<UserPeliculaValor> getValoracionesComentarios() {
			return valoracionesComentarios;
		}

		public void setValoracionesComentarios(List<UserPeliculaValor> valoracionesComentarios) {
			this.valoracionesComentarios = valoracionesComentarios;
		}*/

public Integer getNumeroDeComentarios() {
			return numeroDeComentarios;
		}

		public void setNumeroDeComentarios(Integer numeroDeComentarios) {
			this.numeroDeComentarios = numeroDeComentarios;
		}

public Pelicula() {
	// TODO Auto-generated constructor stub
}

public Integer getIdPelicula() {
	return idPelicula;
}

public void setIdPelicula(Integer idPelicula) {
	this.idPelicula = idPelicula;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getTipoPelicula() {
	return tipoPelicula;
}
public void setTipoPelicula(String tipoPelicula) {
	this.tipoPelicula = tipoPelicula;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public LocalDate getFechaInicio() {
	return fechaInicio;
}
public void setFechaInicio(LocalDate fechaInicio) {
	this.fechaInicio = fechaInicio;
}
public LocalDate getFechaFinal() {
	return fechaFinal;
}
public void setFechaFinal(LocalDate fechaFinal) {
	this.fechaFinal = fechaFinal;
}
public int getDuracion() {
	return duracion;
}
public void setDuracion(int duracion) {
	this.duracion = duracion;
}
public int getHorario1() {
	return horario1;
}
public void setHorario1(int horario1) {
	this.horario1 = horario1;
}
public int getHorario2() {
	return horario2;
}
public void setHorario2(int horario2) {
	this.horario2 = horario2;
}
public int getHorario3() {
	return horario3;
}
public void setHorario3(int horario3) {
	this.horario3 = horario3;
}
public int getSala() {
	return sala;
}
public void setSala(int sala) {
	this.sala = sala;
}
public String getImagen() {
	return imagen;
}
public void setImagen(String imagen) {
	this.imagen = imagen;
}
public Boolean getEstado() {
	return estado;
}
public void setEstado(Boolean estado) {
	this.estado = estado;
}      
          
}
