package tiendaDeMascotas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.AbstractListModel;

public class VentanaPrincipal {

	private JFrame mainFrame;
	private Animal[] peces = {
			new Animal("Espada"),
			new Animal("Tiburon"),
			new Animal("Payaso")
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//main frame
		mainFrame = new JFrame();
		mainFrame.setResizable(false);
		mainFrame.setTitle("Tienda de Mascotas");
		mainFrame.setBounds(100, 100, 700, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		//information panel
		JPanel informationPanel = new JPanel();
		informationPanel.setBounds(25, 176, 648, 300);
		informationPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mainFrame.getContentPane().add(informationPanel);
		informationPanel.setLayout(null);
		
		//pajaros
		JLabel lblPajaros = new JLabel("Pájaros");
		lblPajaros.setBounds(25, 10, 61, 16);
		mainFrame.getContentPane().add(lblPajaros);
		
		JList listPajaros = new JList();
		listPajaros.setBounds(25, 44, 200, 120);
		mainFrame.getContentPane().add(listPajaros);
		
		//peces
		JLabel lblPeces = new JLabel("Peces");
		lblPeces.setBounds(250, 10, 61, 16);
		mainFrame.getContentPane().add(lblPeces);
		
		JList listPeces = new JList(peces);
		listPeces.setCellRenderer(new AnimalListRenderer());
		listPeces.setBounds(250, 44, 200, 120);
		mainFrame.getContentPane().add(listPeces);
		
		//reptiles
		JLabel lblReptiles = new JLabel("Reptiles");
		lblReptiles.setBounds(475, 10, 61, 16);
		mainFrame.getContentPane().add(lblReptiles);
		
		JList listReptiles = new JList();
		listReptiles.setBounds(473, 44, 200, 120);
		mainFrame.getContentPane().add(listReptiles);
		
	}
}
