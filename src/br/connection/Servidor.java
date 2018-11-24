package br.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;


public class Servidor implements Runnable {

	private ObjectOutputStream objectOutputStream = null;
	private ObjectInputStream objectInputStream = null;
	private InputStream inputStream = null;
	private OutputStream outputStream = null;

	private Thread runServidor = null;
	private ServerSocket serverSocket = null;
	public volatile static boolean statusServidor = false;
	private int portaServidor = 5555;


	public Servidor(int porta) {
		this.runServidor = null;
		this.serverSocket = null;
		this.statusServidor = false;
		this.portaServidor = porta;
	}

	public Thread getRunServidor() {
		return runServidor;
	}

	public void setRunServidor(Thread runServidor) {
		this.runServidor = runServidor;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public boolean getStatusServidor() {
		return statusServidor;
	}

	public void setStatusServidor(boolean statusServidor) {
		this.statusServidor = statusServidor;
	}

	public int getPortaServidor() {
		return portaServidor;
	}

	public void setPortaServidor(int portaServidor) {
		this.portaServidor = portaServidor;
	}

	public synchronized void startServer() throws IOException {
		if (runServidor == null) {
			this.serverSocket = new ServerSocket(this.portaServidor);
			this.runServidor = new Thread(this, "Thread-Servidor");
			this.runServidor.start();
			this.statusServidor = true;
		}
	}

	public synchronized void stopServer() throws IOException {

		if (serverSocket != null && runServidor != null) {
			this.statusServidor = false;
			this.runServidor.interrupt();
			this.runServidor = null;
			try {
				this.serverSocket.close();

			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
