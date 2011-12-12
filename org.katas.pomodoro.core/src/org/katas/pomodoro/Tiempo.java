package org.katas.pomodoro;

public class Tiempo {
	
	private int horas;
	private int minutos;
	private int segundos;

	public Tiempo(int horas, int minutos, int segundos) {
		super();
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	public Tiempo() {
		// TODO Auto-generated constructor stub
	}

	public int getHoras() {
		return horas;
	}
	public int getMinutos() {
		return minutos;
	}
	public int getSegundos() {
		return segundos;
	}

	public void restar(long milisegundos) {
		this.horas =  this.horas - (int)(milisegundos / (1000 * 60 * 60));
		this.minutos = this.minutos - (int)(milisegundos / (1000 * 60));
		this.segundos = this.segundos - (int)(milisegundos / (1000));
		if (this.horas < 0)
			this.horas = 0;
		if (this.minutos < 0)
			this.minutos = 0;
		if (this.segundos < 0)
			this.segundos = 0;
	}
	
	@Override
	protected Tiempo clone() throws CloneNotSupportedException {
		Tiempo tiempo = new Tiempo();
		tiempo.horas = this.horas;
		tiempo.minutos = this.minutos;
		tiempo.segundos = this.segundos;
		return tiempo;
	}


}
