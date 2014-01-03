import java.net.MalformedURLException;
import java.net.URL;

import dimpl.Media;
import dimpl.jmf.JMFPlayer;
import dimpl.jws.service.JWSPlayerPublisher;

public class JWSPublishJMFPlayer {

	public static void main(String[] args) {

		JMFPlayer player = new JMFPlayer();
		new JWSPlayerPublisher(player).publish("http://localhost:8765/WS/JWSPlayer");
		
	}

}
