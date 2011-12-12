package org.katas.pomodoro.ui;


public class PomodoroUIAssembler {
	
	VentanaPrincipal ventana;
	Thread threadPrincipal;
	
	public void startup() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				crearVentanaPrincipal();				
			}
			
		};
		this.threadPrincipal = new Thread(runnable);
		this.threadPrincipal.start();
		System.out.println("Fin del método startup.");
	}
	
	void crearVentanaPrincipal() {
		System.out.println("Creando la ventana principal");
		ventana = new VentanaPrincipal();
		System.out.println("Ventana principal instanciada");
		ventana.setVisible(true);
		System.out.println("Ventana principal mostrada en pantalla");
	}
	
	
	
	public void shutdown() {
		System.out.println("Cerrando la ventana principal");
		ventana.dispose();
	}
}
