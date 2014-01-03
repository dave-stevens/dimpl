package dimpl.swing;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dimpl.Event;
import dimpl.Library;
import dimpl.Media;

public class SwingLibrary extends JPanel implements Observer {

	public Event mediaClicked = new Event();
	
	public SwingLibrary(String name, Library library) {

		setLayout(new BorderLayout());
		
		JLabel nameLabel = new JLabel(name);
		add(nameLabel, BorderLayout.NORTH);
		
		// Display all the media
		for (Media media : library.all()) {
			SwingMedia swingMedia = new SwingMedia(media);
			add(swingMedia, BorderLayout.CENTER);
			swingMedia.clicked.addObserver(this);
		}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Media media = ((Media)arg1);
		if (media != null) {
			mediaClicked.raise(media);
		}
	}
	
}
