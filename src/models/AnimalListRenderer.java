package models;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class AnimalListRenderer extends JLabel implements ListCellRenderer<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	
	public AnimalListRenderer() {
		setOpaque(true);
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		    Animal entry = (Animal) value;
		    setText(entry.toString());
		    if (isSelected) {
		      setBackground(HIGHLIGHT_COLOR);
		      setForeground(Color.white);
		    } else {
		      setBackground(Color.white);
		      setForeground(Color.black);
		    }
		    return this;
		  }
	
}