package org.katas.pomodoro;

public class ProveedorTiempoSistema implements ProveedorTiempo {

	public long getInstanteActual() {
		return System.currentTimeMillis();
	}

}
