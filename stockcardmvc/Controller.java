package stockcardmvc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class Controller {
	private Model model;
	private View view;
	private String stokkodu,stokkadi, birimi, barkodu, aciklama;
	private int stoktipi;
	private double kdvtipi;
	
	
	public Controller(Model m, View v) {
		model = m;
		view = v;
		initView();
	}
	
	public void initView() {
		
		stokkodu = view.StockCodeTextfield.getText();
		stokkadi = view.StockNameTextfieldl.getText();
		stoktipi = view.StockTypeTextfield.getSelectedIndex();
		birimi = String.valueOf(view.unitTextfield.getSelectedIndex());
		barkodu = view.barcodeTextfield.getText();
		kdvtipi = view.kdvTypeTextfield.getSelectedIndex();
		aciklama = view.descriptionTextfield.getText();

	}
	
	public void initController() {
		view.getAddButton().addActionListener(e -> add());
		view.getDeleteButton().addActionListener(e -> delete());
		view.getUpdateButton().addActionListener(e -> update());
		view.getSearchButton().addActionListener(e -> search());
	}

	private void add() {
		model.addDatabase(view.StockCodeTextfield.getText(),view.StockNameTextfieldl.getText(),
				view.StockTypeTextfield.getSelectedIndex(),String.valueOf(view.unitTextfield.getSelectedItem()),
				view.barcodeTextfield.getText(),view.kdvTypeTextfield.getSelectedIndex(),
				view.descriptionTextfield.getText()); 
	}
	
	private void delete() {
		model.deleteDatabase(view.table.getSelectedRow());
	}
	
	public void CopytoFields() {
		view.table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = view.table.getSelectedRow();
				view.StockCodeTextfield.setText(view.model.getValueAt(i, 0).toString());
				view.StockNameTextfieldl.setText(view.model.getValueAt(i, 1).toString());
				view.StockTypeTextfield.setSelectedItem(view.model.getValueAt(i, 2));
				view.unitTextfield.setSelectedItem(view.model.getValueAt(i, 3));
				view.barcodeTextfield.setText(view.model.getValueAt(i, 4).toString());
				view.kdvTypeTextfield.setSelectedItem(view.model.getValueAt(i, 5));
				view.descriptionTextfield.setText(view.model.getValueAt(i, 6).toString());
			}
		});
	}
	
	private void update() {
		int i = view.table.getSelectedRow();
		String stokkodu = View.table.getModel().getValueAt(i, 0).toString();
		System.out.print(stokkodu);
		
		if(i >= 0) {
			view.model.setValueAt(view.StockCodeTextfield.getText(),i,0);
			view.model.setValueAt(view.StockNameTextfieldl.getText(),i,1);
			view.model.setValueAt(view.StockTypeTextfield.getSelectedItem(),i,2);
			view.model.setValueAt(view.unitTextfield.getSelectedItem(),i,3);
			view.model.setValueAt(view.barcodeTextfield.getText(),i,4);
			view.model.setValueAt(view.kdvTypeTextfield.getSelectedItem(),i,5);
			view.model.setValueAt(view.descriptionTextfield.getText(),i,6);
			
			model.updateDatabase(stokkodu,view.StockNameTextfieldl.getText(),
					view.StockTypeTextfield.getSelectedIndex(),String.valueOf(view.unitTextfield.getSelectedItem()),
					view.barcodeTextfield.getText(),view.kdvTypeTextfield.getSelectedIndex(),view.descriptionTextfield.getText());
		} else { 
			JOptionPane.showMessageDialog(null, "Lütfen Tablodan Bir Veri Seçiniz!");
		}

	}
	private void search() {
		
		model.search(view.searchTextfield.getText());
	}
	
}