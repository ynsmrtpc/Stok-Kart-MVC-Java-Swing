package stockcardmvc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model m, View v) {
		model = m;
		view = v;
	}

	public void initController() {
		view.getAddButton().addActionListener(e -> add());
		view.getDeleteButton().addActionListener(e -> delete());
		view.getUpdateButton().addActionListener(e -> update());
		view.getSearchButton().addActionListener(e -> search());
	}

	private void add() {
		model.addDatabase(View.StockCodeTextfield.getText(),View.StockNameTextfieldl.getText(),
				View.StockTypeTextfield.getSelectedIndex(),String.valueOf(View.unitTextfield.getSelectedItem()),
				View.barcodeTextfield.getText(),View.kdvTypeTextfield.getSelectedIndex(),
				View.descriptionTextfield.getText()); 
		
		model.delAllTable();
		model.addTabletoUI();
	}
	
	private void delete() {
		model.deleteDatabase(View.table.getSelectedRow());
	}
	
	public void CopytoFields() {
		View.table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = View.table.getSelectedRow();
				View.StockCodeTextfield.setText(View.model.getValueAt(i, 0).toString());
				View.StockNameTextfieldl.setText(View.model.getValueAt(i, 1).toString());
				View.StockTypeTextfield.setSelectedItem(View.model.getValueAt(i, 2));
				View.unitTextfield.setSelectedItem(View.model.getValueAt(i, 3));
				View.barcodeTextfield.setText(View.model.getValueAt(i, 4).toString());
				View.kdvTypeTextfield.setSelectedItem(View.model.getValueAt(i, 5));
				View.descriptionTextfield.setText(View.model.getValueAt(i, 6).toString());
				view.getOlusturmaTarihiTextfield().setText(View.model.getValueAt(i, 7).toString());
			}
		});
	}
	
	private void update() {
		int i = View.table.getSelectedRow();
		String stokkodu = View.table.getModel().getValueAt(i, 0).toString();
		
		if(i >= 0) {
			View.model.setValueAt(View.StockCodeTextfield.getText(),i,0);
			View.model.setValueAt(View.StockNameTextfieldl.getText(),i,1);
			View.model.setValueAt(View.StockTypeTextfield.getSelectedItem(),i,2);
			View.model.setValueAt(View.unitTextfield.getSelectedItem(),i,3);
			View.model.setValueAt(View.barcodeTextfield.getText(),i,4);
			View.model.setValueAt(View.kdvTypeTextfield.getSelectedItem(),i,5);
			View.model.setValueAt(View.descriptionTextfield.getText(),i,6);
			
			model.updateDatabase(stokkodu,View.StockNameTextfieldl.getText(),
					View.StockTypeTextfield.getSelectedIndex(),String.valueOf(View.unitTextfield.getSelectedItem()),
					View.barcodeTextfield.getText(),View.kdvTypeTextfield.getSelectedIndex(),
					View.descriptionTextfield.getText());
		} else { 
			JOptionPane.showMessageDialog(null, "Lütfen Tablodan Bir Veri Seçiniz!");
		}

	}
	private void search() {
		model.search(View.searchTextfield.getText());
	}
	
}