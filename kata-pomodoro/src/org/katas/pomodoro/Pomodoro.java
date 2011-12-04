package org.katas.pomodoro;

public class Pomodoro {
	
	private Tiempo duracion = null;
	private Tiempo restante = null;
	private long marca = 0;
	
	public Pomodoro() {
		duracion = new Tiempo(00,25,00);
		try {
			restante = (Tiempo) duracion.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public Tiempo start() {
		this.marca = System.currentTimeMillis();
		return restante;
	}

	public void setDuracion(Tiempo duracion) {
		this.duracion = duracion;
		this.reset();
	}

	public Tiempo getTiempoRestante() {
		long ahora = System.currentTimeMillis();
		if (marca == 0)
			return restante;
		long diferencia = (ahora - marca);
		restante.restar(diferencia);
		return restante;
	}

	public Tiempo stop() {
		return getTiempoRestante();
	}

	public Tiempo reset() {
		try {
			this.restante = duracion.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return this.restante;
	}

}
