package org.katas.pomodoro;

public class ProveedorTiempoMock implements ProveedorTiempo {
	
	private long ahora; 

	@Override
	public long getInstanteActual() {
		return ahora;
	}
	
	public void setInstanteActual(long milisegundos) {
		this.ahora = milisegundos;
	}

}
