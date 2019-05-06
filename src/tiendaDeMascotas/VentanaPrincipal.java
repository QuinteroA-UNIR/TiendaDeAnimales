package tiendaDeMascotas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import models.Animal;
import models.AnimalListRenderer;
import models.Pajaro;
import models.Pez;
import models.Reptil;
import models.Sexo;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaPrincipal {

	private Animal animalSeleccionado;
	private AnimalListRenderer listRenderer = new AnimalListRenderer();
	private JFrame mainFrame;
	private JTextField codigoInput;
	private JTextField alimentacionInput;
	private JTextField especieInput;
	private JTextArea observacionesInput;
	private JRadioButton rdbtnPajaro;
	private JRadioButton rdbtnPez;
	private JRadioButton rdbtnReptil;
	private JRadioButton rdbtnMacho;
	private JRadioButton rdbtnHembra;
	private JButton btnGuardarCambios;
	private JList<Pajaro> listPajaros;
	private JList<Pez> listPeces;
	private JList<Reptil> listReptiles;
	private JButton btnAddPajaro;
	private JButton btnDelPajaro;
	private JButton btnAddPez;
	private JButton btnDelPez;
	private JButton btnAddReptil;
	private JButton btnDelReptil;
	
	private DefaultListModel<Pez> peces = new DefaultListModel<Pez>();
	
	private DefaultListModel<Pajaro> pajaros = new DefaultListModel<Pajaro>();
	private DefaultListModel<Reptil> reptiles = new DefaultListModel<Reptil>();

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
		peces.addElement(new Pez("001","Payaso","AU", "Solo agua fría", Sexo.HEMBRA, "Pienso"));
		peces.addElement(new Pez("002","Dorado","ES", "", Sexo.MACHO, "Pienso"));
		peces.addElement(new Pez("004","Tetra","JP", "Agua dulce", Sexo.HEMBRA, "Pienso"));
		
		pajaros.addElement(new Pajaro("001","Guacamaya","VE", "Solo agua fría", Sexo.HEMBRA, "Semillas de maiz"));
		pajaros.addElement(new Pajaro("002","Canario","ES", "", Sexo.MACHO, "Semillas"));
		pajaros.addElement(new Pajaro("004","Turpial","VE", "Agua dulce", Sexo.HEMBRA, "Semillas de girasol"));
		
		reptiles.addElement(new Reptil("001","Dragon de Komodo","AU", "Solo agua fría", Sexo.HEMBRA, "Si coõ"));
		reptiles.addElement(new Reptil("002","Cascabel","CO", "", Sexo.MACHO, "Comida"));
		reptiles.addElement(new Reptil("004","Perenquen","ES", "Agua dulce", Sexo.HEMBRA, "Insectos"));
		initialize();
		toggleInformationInputs(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//main frame
		mainFrame = new JFrame();
		mainFrame.setResizable(false);
		mainFrame.setTitle("Tienda de Mascotas");
		mainFrame.setBounds(100, 100, 700, 450);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		//information panel
		JPanel informationPanel = new JPanel();
		informationPanel.setBounds(25, 176, 648, 250);
		informationPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mainFrame.getContentPane().add(informationPanel);
		informationPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(10, 32, 61, 16);
		informationPanel.add(lblCodigo);
		
		codigoInput = new JTextField();
		codigoInput.getDocument().addDocumentListener(listener);
		codigoInput.setBounds(65, 27, 130, 42);
		informationPanel.add(codigoInput);
		codigoInput.setColumns(10);
		
		JLabel lblAlimentacion = new JLabel("Alimentación");
		lblAlimentacion.setBounds(10, 86, 91, 16);
		informationPanel.add(lblAlimentacion);
		
		alimentacionInput = new JTextField();
		alimentacionInput.getDocument().addDocumentListener(listener);
		alimentacionInput.setBounds(114, 81, 341, 42);
		informationPanel.add(alimentacionInput);
		alimentacionInput.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(10, 146, 103, 16);
		informationPanel.add(lblObservaciones);
		
		observacionesInput = new JTextArea();
		observacionesInput.getDocument().addDocumentListener(listener);
		observacionesInput.setBorder(UIManager.getBorder("TextField.border"));
		observacionesInput.setBounds(114, 146, 341, 95);
		informationPanel.add(observacionesInput);
		
		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setBounds(207, 32, 61, 16);
		informationPanel.add(lblEspecie);
		
		especieInput = new JTextField();
		especieInput.getDocument().addDocumentListener(listener);
		especieInput.setBounds(280, 27, 175, 42);
		informationPanel.add(especieInput);
		especieInput.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(478, 32, 61, 16);
		informationPanel.add(lblTipo);
		
		rdbtnPajaro = new JRadioButton("Pájaro");
		rdbtnPajaro.setBounds(551, 28, 76, 23);
		informationPanel.add(rdbtnPajaro);
		
		rdbtnPez = new JRadioButton("Pez");
		rdbtnPez.setBounds(551, 52, 76, 23);
		informationPanel.add(rdbtnPez);
		
		rdbtnReptil = new JRadioButton("Reptil");
		rdbtnReptil.setBounds(551, 76, 76, 23);
		informationPanel.add(rdbtnReptil);
		
		JLabel lblGenero = new JLabel("Género:");
		lblGenero.setBounds(478, 146, 61, 16);
		informationPanel.add(lblGenero);
		
		rdbtnMacho = new JRadioButton("Macho");
		rdbtnMacho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeGender();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				changeGender();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				changeGender();
			}
			private void changeGender() {
				if (!rdbtnMacho.isEnabled()) { return; }
				rdbtnHembra.setSelected(false);
				rdbtnMacho.setSelected(true);
				Sexo selectedSex = rdbtnHembra.isSelected() ? Sexo.HEMBRA : Sexo.MACHO;
				if (!animalSeleccionado.sexo.equals(selectedSex)) {
					btnGuardarCambios.setEnabled(true);
				} else {
					btnGuardarCambios.setEnabled(false);
				}
			}
		});
		rdbtnMacho.setBounds(551, 142, 76, 23);
		informationPanel.add(rdbtnMacho);
		
		rdbtnHembra = new JRadioButton("Hembra");
		rdbtnHembra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeGender();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				changeGender();
			}
			public void mouseReleased(MouseEvent e) {
				changeGender();
			}
			private void changeGender() {
				if (!rdbtnHembra.isEnabled()) { return; }
				rdbtnMacho.setSelected(false);
				rdbtnHembra.setSelected(true);
				Sexo selectedSex = rdbtnHembra.isSelected() ? Sexo.HEMBRA : Sexo.MACHO;
				if (!animalSeleccionado.sexo.equals(selectedSex)) {
					btnGuardarCambios.setEnabled(true);
				} else {
					btnGuardarCambios.setEnabled(false);
				}
				
			}
		});
		rdbtnHembra.setBounds(551, 166, 91, 23);
		informationPanel.add(rdbtnHembra);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveChanges();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				saveChanges();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				saveChanges();
			}
			private void saveChanges() {
				Sexo selectedSex = rdbtnHembra.isSelected() ? Sexo.HEMBRA : Sexo.MACHO;
				animalSeleccionado.codigoDeIdentificacion = codigoInput.getText();
				animalSeleccionado.alimentacionBasica = alimentacionInput.getText();
				animalSeleccionado.observaciones = observacionesInput.getText();
				animalSeleccionado.especie = especieInput.getText();
				animalSeleccionado.sexo = selectedSex;
				int index;
				switch (animalSeleccionado.getTipo()) {
				case PEZ:
					index = listPeces.getSelectedIndex();
					peces.set(index, (Pez)animalSeleccionado);
					break;
				case PAJARO:
					index = listPajaros.getSelectedIndex();
					pajaros.set(index, (Pajaro)animalSeleccionado);
					break;
				default:
					index = listReptiles.getSelectedIndex();
					reptiles.set(index, (Reptil)animalSeleccionado);
					break;
				}
				
				
				btnGuardarCambios.setEnabled(false);
			}
		});
		btnGuardarCambios.setBounds(478, 201, 152, 40);
		btnGuardarCambios.setEnabled(false);
		informationPanel.add(btnGuardarCambios);
		
		//pajaros
		JLabel lblPajaros = new JLabel("Pájaros");
		lblPajaros.setBounds(25, 10, 61, 16);
		mainFrame.getContentPane().add(lblPajaros);
		
		listPajaros = new JList<>(pajaros);
		listPajaros.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = listPajaros.getSelectedIndex();
				if (index >= 0 && index < pajaros.size()) {
					Pajaro pajaro = pajaros.get(index);
					fillInformationPanel(pajaro);
				}
				
			}
		});
		listPajaros.setCellRenderer(listRenderer);
		listPajaros.setBounds(25, 44, 200, 120);
		mainFrame.getContentPane().add(listPajaros);
		
		//peces
		JLabel lblPeces = new JLabel("Peces");
		lblPeces.setBounds(250, 10, 61, 16);
		mainFrame.getContentPane().add(lblPeces);
		
		listPeces = new JList<>(peces);
		listPeces.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = listPeces.getSelectedIndex();
				if (index >= 0 && index < pajaros.size()) {
					Pez pez = peces.get(index);
					fillInformationPanel(pez);
				}
				
			}
		});
		listPeces.setCellRenderer(listRenderer);
		listPeces.setBounds(250, 44, 200, 120);
		mainFrame.getContentPane().add(listPeces);
		
		//reptiles
		JLabel lblReptiles = new JLabel("Reptiles");
		lblReptiles.setBounds(475, 10, 61, 16);
		mainFrame.getContentPane().add(lblReptiles);
		
		listReptiles = new JList<>(reptiles);
		listReptiles.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = listReptiles.getSelectedIndex();
				if (index >= 0 && index < pajaros.size()) {
					Reptil reptil = reptiles.get(index);
					fillInformationPanel(reptil);	
				}
			}
		});
		listReptiles.setCellRenderer(listRenderer);
		listReptiles.setBounds(473, 44, 200, 120);
		mainFrame.getContentPane().add(listReptiles);
		
		btnAddPajaro = new JButton("+");
		btnAddPajaro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toggleInformationInputs(true);
			}
		});
		btnAddPajaro.setForeground(Color.BLUE);
		btnAddPajaro.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnAddPajaro.setBorderPainted(false);
		btnAddPajaro.setBorder(null);
		btnAddPajaro.setBounds(181, 6, 20, 20);
		mainFrame.getContentPane().add(btnAddPajaro);
		
		btnDelPajaro = new JButton("-");
		btnDelPajaro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deletePajaro();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				deletePajaro();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				deletePajaro();
			}
			private void deletePajaro() {
				fillInformationPanel(null);
				pajaros.removeElement(animalSeleccionado);
				animalSeleccionado = null;
			}
		});
		btnDelPajaro.setForeground(Color.RED);
		btnDelPajaro.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnDelPajaro.setBorderPainted(false);
		btnDelPajaro.setBorder(null);
		btnDelPajaro.setBounds(205, 6, 20, 20);
		btnDelPajaro.setEnabled(false);
		mainFrame.getContentPane().add(btnDelPajaro);
		
		btnAddPez = new JButton("+");
		btnAddPez.setForeground(Color.BLUE);
		btnAddPez.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnAddPez.setBorderPainted(false);
		btnAddPez.setBorder(null);
		btnAddPez.setBounds(406, 10, 20, 20);
		mainFrame.getContentPane().add(btnAddPez);
		
		btnDelPez = new JButton("-");
		btnDelPez.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deletePez();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				deletePez();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				deletePez();
			}
			private void deletePez() {
				fillInformationPanel(null);
				peces.removeElement(animalSeleccionado);
				animalSeleccionado = null;
			}
		});
		btnDelPez.setForeground(Color.RED);
		btnDelPez.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnDelPez.setEnabled(false);
		btnDelPez.setBorderPainted(false);
		btnDelPez.setBorder(null);
		btnDelPez.setBounds(430, 10, 20, 20);
		mainFrame.getContentPane().add(btnDelPez);
		
		btnAddReptil = new JButton("+");
		btnAddReptil.setForeground(Color.BLUE);
		btnAddReptil.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnAddReptil.setBorderPainted(false);
		btnAddReptil.setBorder(null);
		btnAddReptil.setBounds(629, 10, 20, 20);
		mainFrame.getContentPane().add(btnAddReptil);
		
		btnDelReptil = new JButton("-");
		btnDelReptil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteReptil();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				deleteReptil();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				deleteReptil();
			}
			private void deleteReptil() {
				fillInformationPanel(null);
				reptiles.removeElement(animalSeleccionado);
				animalSeleccionado = null;
			}
		});
		btnDelReptil.setForeground(Color.RED);
		btnDelReptil.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnDelReptil.setEnabled(false);
		btnDelReptil.setBorderPainted(false);
		btnDelReptil.setBorder(null);
		btnDelReptil.setBounds(653, 10, 20, 20);
		mainFrame.getContentPane().add(btnDelReptil);
	}
	
	private DocumentListener listener = new DocumentListener() {

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateFieldState();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateFieldState();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateFieldState();
        }

        protected void updateFieldState() {
            if (!animalSeleccionado.codigoDeIdentificacion.equals(codigoInput.getText()) ||
        			!animalSeleccionado.especie.equals(especieInput.getText()) ||
        			!animalSeleccionado.alimentacionBasica.equals(alimentacionInput.getText()) ||
					!animalSeleccionado.observaciones.equals(observacionesInput.getText())
					){
            	btnGuardarCambios.setEnabled(true);
            } else {
            	btnGuardarCambios.setEnabled(false);
            }
        }
    };
	
    
    private void toggleInformationInputs(boolean enabled) {
    	codigoInput.setEnabled(enabled);
    	especieInput.setEnabled(enabled);
    	alimentacionInput.setEnabled(enabled);
    	observacionesInput.setEnabled(enabled);
    	rdbtnPajaro.setEnabled(enabled);
    	rdbtnPez.setEnabled(enabled);
    	rdbtnReptil.setEnabled(enabled);
    	rdbtnHembra.setEnabled(enabled);
    	rdbtnMacho.setEnabled(enabled);
    	if (!enabled) {
	    	rdbtnPajaro.setSelected(false);
	    	rdbtnReptil.setSelected(false);
	    	rdbtnPez.setSelected(false);
	    	rdbtnMacho.setSelected(false);
			rdbtnHembra.setSelected(false);
			btnGuardarCambios.setEnabled(false);
    	}
    }
	
	
	private void fillInformationPanel(Animal animal) {
		if (animal == null) {
			codigoInput.setText("");
			alimentacionInput.setText("");
			observacionesInput.setText("");
			especieInput.setText("");
			toggleInformationInputs(false);
			return;
		}
		toggleInformationInputs(true);
		animalSeleccionado = animal;
		codigoInput.setText(animal.codigoDeIdentificacion);
		alimentacionInput.setText(animal.alimentacionBasica);
		observacionesInput.setText(animal.observaciones);
		especieInput.setText(animal.especie);
		
		switch (animal.getTipo()) {
		case PEZ:
			if (!listReptiles.isSelectionEmpty()) {
				listReptiles.clearSelection();
			}
			if (!listPajaros.isSelectionEmpty()) {
				listPajaros.clearSelection();
			}
			btnDelPajaro.setEnabled(false);
			btnDelReptil.setEnabled(false);
			btnDelPez.setEnabled(true);
			rdbtnPajaro.setSelected(false);
			rdbtnPajaro.setEnabled(false);
			rdbtnReptil.setSelected(false);
			rdbtnReptil.setEnabled(false);
			rdbtnPez.setSelected(true);
			rdbtnPez.setEnabled(true);
			break;
		case PAJARO:
			if (!listPeces.isSelectionEmpty()) {
				listPeces.clearSelection();
			}
			if (!listReptiles.isSelectionEmpty()) {
				listReptiles.clearSelection();
			}
			btnDelReptil.setEnabled(false);
			btnDelPez.setEnabled(false);
			btnDelPajaro.setEnabled(true);
			rdbtnPez.setSelected(false);
			rdbtnPez.setEnabled(false);
			rdbtnReptil.setSelected(false);
			rdbtnReptil.setEnabled(false);
			rdbtnPajaro.setSelected(true);
			rdbtnPajaro.setEnabled(true);
			break;
		default:
			if (!listPeces.isSelectionEmpty()) {
				listPeces.clearSelection();
			}
			if (!listPajaros.isSelectionEmpty()) {
				listPajaros.clearSelection();
			}
			btnDelPez.setEnabled(false);
			btnDelPajaro.setEnabled(false);
			btnDelReptil.setEnabled(true);
			rdbtnPez.setSelected(false);
			rdbtnPez.setEnabled(false);
			rdbtnPajaro.setSelected(false);
			rdbtnPajaro.setEnabled(false);
			rdbtnReptil.setSelected(true);
			rdbtnReptil.setEnabled(true);
			break;
		}
		
		switch (animal.sexo) {
		case MACHO:
			rdbtnHembra.setSelected(false);
			rdbtnMacho.setSelected(true);
			break;
		default:
			rdbtnMacho.setSelected(false);
			rdbtnHembra.setSelected(true);
			break;
		}
	}
	
	
}
