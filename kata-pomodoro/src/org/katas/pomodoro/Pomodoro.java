package org.katas.pomodoro;

public class Pomodoro {
	
	private Tiempo duracion = null;
	private Tiempo restante = null;
	private long marca = -1;
	ProveedorTiempo proveedorTiempo;
	
	
	public Pomodoro() {
		duracion = new Tiempo(00,25,00);
		this.reset();
	}

	public Tiempo start() {
		this.marca = proveedorTiempo.getInstanteActual();
		return restante;
	}

	public void setDuracion(Tiempo duracion) {
		this.duracion = duracion;
		this.reset();
	}

	public Tiempo getTiempoRestante() {
		long ahora = proveedorTiempo.getInstanteActual();
		if (marca == -1)
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

	public void setProveedorTiempo(ProveedorTiempo proveedorTiempo) {
		this.proveedorTiempo = proveedorTiempo;
	}

}
