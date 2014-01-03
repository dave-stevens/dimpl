import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import dimpl.IController;
import dimpl.IPlayer;
import dimpl.Library;
import dimpl.Media;
import dimpl.jmf.JMFPlayer;
import dimpl.swing.SwingController;
import dimpl.swing.SwingLibrary;
import dimpl.swing.SwingPlayer;


public class SwingControllerPanel extends JFrame implements Observer {

	private List<IController> controllers = new ArrayList<IController>();
	private List<IPlayer> players = new ArrayList<IPlayer>();
	
	public SwingControllerPanel() {
		setTitle("dimpl.swing");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		// Add a player panel JMFPlayer
		IPlayer player = new JMFPlayer();
		addPlayer("Default player", player);
		
		// Add a library for browsing
		Library library = new Library();
		library.add(new Media(10, "Equinox", SwingController.class.getResource("/equinox-48KHz.wav")));
		addLibrary("Samples library", library);
		
		pack();
//		// Add a player panel
//		IPlayer player = addPlayer("PLAYER", new JMFPlayer());
//		
//		// Queue up a track
//		try {
//			player.mediaQueue().push(new Media(10, "Test", new URL("file://home/dave/Downloads/equinox-48KHz.wav")));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void addController(String name, IController controller) {
		controllers.add(controller);
		SwingController swingController = new SwingController(name, controller);
		swingController.setAlignmentX(LEFT_ALIGNMENT);
		getContentPane().add(swingController);
	}
	
	public void addPlayer(String name, IPlayer player) {
		SwingPlayer swingPlayer = new SwingPlayer(name, player);
		swingPlayer.setAlignmentX(LEFT_ALIGNMENT);
		getContentPane().add(swingPlayer);
		players.add(player);
	}
	
	public void addLibrary(String name, Library library) {
		SwingLibrary swingLibrary = new SwingLibrary(name, library);
		swingLibrary.setAlignmentX(LEFT_ALIGNMENT);
		swingLibrary.mediaClicked.addObserver(this);
		getContentPane().add(swingLibrary, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SwingControllerPanel main = new SwingControllerPanel();
				main.setVisible(true);
			}
		});
		
	}

	@Override
	public void update(Observable o, Object arg) {
		Media media = (Media)arg;
		if (media != null) {
			for (IPlayer player : players) {
				player.prepare(media);
				player.start();
			}
		}
	}
}
