/**
 * 
 */
package org.hs.pforzheim.ti.rlrc;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;


public class MainPanel extends Thread {

	private JFrame frame;
	
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel window = new MainPanel();
					window.frame.setVisible(true);
					//window.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(1280, 800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		ObserverPanel observerPanel = new ObserverPanel();
		GridBagConstraints gbc_observerPanel = new GridBagConstraints();
		gbc_observerPanel.insets = new Insets(0, 0, 0, 5);
		gbc_observerPanel.gridx = 0;
		gbc_observerPanel.gridy = 0;
		frame.getContentPane().add(observerPanel, gbc_observerPanel);
		
		Observer3DPanel observer3DPanel = new Observer3DPanel();
		GridBagConstraints gbc_observer3DPanel = new GridBagConstraints();
		gbc_observer3DPanel.gridx = 1;
		gbc_observer3DPanel.gridy = 0;
		frame.getContentPane().add(observer3DPanel, gbc_observer3DPanel);
		
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}