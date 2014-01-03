package dimpl.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dimpl.IController;
import dimpl.IPlayer;

public class SwingController extends JPanel {

	private IController controller;
	/**
	 * Create the panel.
	 */
	public SwingController(String name, IController controller) {
		// Set up the controller panel
		setToolTipText("dimpl.swing.SwingController");

		this.controller = controller;
		
		setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		// Name label
		JLabel nameLabel = new JLabel(name);
		topPanel.add(nameLabel);
		
		// Connect to a new player button
		JButton connectButton = new JButton();
		connectButton.setText("connect...");
		topPanel.add(connectButton);
		connectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Connect button hit - show a list of players available from the playermanager
				onConnectClicked();
			}
		});
		
		// List the connected players
		int i = 0;
		for (IPlayer player : controller.players()) {
			add(new SwingPlayer(Integer.toString(i++), player), BorderLayout.CENTER);
		}
	}

	private void onConnectClicked() {
		System.out.println("onConnectClicked()");
	}
}
