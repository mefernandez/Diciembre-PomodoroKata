package org.katas.pomodoro;

public class RelojMock implements Reloj {
	
	private long ahora; 

	@Override
	public long getInstanteActual() {
		return ahora;
	}
	
	public void setInstanteActual(long milisegundos) {
		this.ahora = milisegundos;
	}

}
