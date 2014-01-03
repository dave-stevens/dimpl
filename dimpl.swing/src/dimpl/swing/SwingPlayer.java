package dimpl.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dimpl.IPlayer;
import dimpl.Library;
import dimpl.MediaQueue;

public class SwingPlayer extends JPanel implements ActionListener {

	IPlayer player;
	JButton rewindButton;
	JButton startButton;
	JButton pauseButton;
	JButton stopButton;
	JButton skipButton;
	/**
	 * Create the panel.
	 * @param string 
	 */
	public SwingPlayer(String name, IPlayer player) {
		// Set up the controller panel
		setToolTipText("dimpl.swing.SwingPlayer");

		this.player = player;

		setLayout(new BorderLayout());
		
		// Name label
		JLabel nameLabel = new JLabel(name);
		add(nameLabel, BorderLayout.NORTH);

		// Add control buttons in a JPanel toolbar
		JPanel controlButtons = new JPanel();
		controlButtons.setLayout(new GridLayout(1, 5));
		// Rewind button
		rewindButton = new JButton(new ImageIcon(SwingPlayer.class.getResource("/rewind.png")));
		rewindButton.setToolTipText("Rewind");
		rewindButton.setPreferredSize(new Dimension(64, 64));
		controlButtons.add(rewindButton);
		rewindButton.addActionListener(this);
		// Play button
		startButton = new JButton(new ImageIcon(SwingPlayer.class.getResource("/start.png")));
		startButton.setToolTipText("Start");
		startButton.setPreferredSize(new Dimension(64, 64));
		controlButtons.add(startButton);
		startButton.addActionListener(this);
		// Pause button
		pauseButton = new JButton(new ImageIcon(SwingPlayer.class.getResource("/pause.png")));
		pauseButton.setToolTipText("Pause");
		pauseButton.setPreferredSize(new Dimension(64, 64));
		controlButtons.add(pauseButton);
		pauseButton.addActionListener(this);
		// Stop button
		stopButton = new JButton(new ImageIcon(SwingPlayer.class.getResource("/stop.png")));
		stopButton.setToolTipText("Stop");
		stopButton.setPreferredSize(new Dimension(64, 64));
		controlButtons.add(stopButton);
		stopButton.addActionListener(this);
		// Skip button
		skipButton = new JButton(new ImageIcon(SwingPlayer.class.getResource("/skip.png")));
		skipButton.setToolTipText("Skip");
		skipButton.setPreferredSize(new Dimension(64, 64));
		controlButtons.add(skipButton);
		skipButton.addActionListener(this);

		add(controlButtons, BorderLayout.CENTER);
		
		// Media playing
		SwingMedia swingMedia = new SwingMedia(player.playing());
		add(swingMedia, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == rewindButton) {
			player.rewind();
		} else if (arg0.getSource() == startButton) {
			player.start();
		} else if (arg0.getSource() == pauseButton) {
			player.pause();
		} else if (arg0.getSource() == stopButton) {
			player.stop();
		} else if (arg0.getSource() == skipButton) {
			player.skip();
		}
	}
}
