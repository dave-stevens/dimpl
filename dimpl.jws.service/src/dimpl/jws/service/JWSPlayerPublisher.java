package dimpl.jws.service;

import javax.xml.ws.Endpoint;

import dimpl.IPlayer;

public class JWSPlayerPublisher {

	private JWSPlayer player;
	private Endpoint endpoint;
	
	public JWSPlayerPublisher(IPlayer player) {
		this.player = new JWSPlayer(player);
	}

	public void publish(String address) {
		if (endpoint == null) {
			endpoint = Endpoint.publish(address, player);
		}
	}

	public void stop() {
		if (endpoint != null) {
			endpoint.stop();
			endpoint = null;
		}
	}
}
