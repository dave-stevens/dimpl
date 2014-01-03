package dimpl.swing;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dimpl.Event;
import dimpl.Media;

public class SwingMedia extends JPanel implements MouseListener {

	private Media media;
	public Event clicked = new Event();
	
	public SwingMedia(Media media) {
		
		if (media != null) {
			this.media = media;
			setLayout(new BorderLayout());
		
			// Name label
			JLabel nameLabel = new JLabel(media.name());
			add(nameLabel, BorderLayout.CENTER);
		
			// Duration label
			JLabel durationLabel = new JLabel(Double.toString(media.duration()));
			add(durationLabel, BorderLayout.EAST);
		
			// URL as tooltip
			setToolTipText(media.url().toString());
			addMouseListener(this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("mouseClicked");
		clicked.raise(media);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println("mouseExited");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("mouseReleased");
	}

}
