package dimpl.swing;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dimpl.Media;
import dimpl.MediaQueue;

public class SwingMediaQueue extends JPanel {

	public SwingMediaQueue(MediaQueue mediaQueue) {
		
		setLayout(new BorderLayout());
		
		// Display the peeked item
		Media media = mediaQueue.peek();
		if (media == null) {
			// Name label
			JLabel emptyLabel = new JLabel("<empty>");
			add(emptyLabel, BorderLayout.NORTH);
		} else {
			SwingMedia swingMedia = new SwingMedia(media);
			add(swingMedia, BorderLayout.NORTH);
		}
		
	}
	
}
