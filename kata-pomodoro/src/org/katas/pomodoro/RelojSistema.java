package org.katas.pomodoro;

public class RelojSistema implements Reloj {

	public long getInstanteActual() {
		return System.currentTimeMillis();
	}

}
