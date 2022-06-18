package stockcardmvc;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class View {
	
	 private JFrame frame;
	 private JLabel StockCodeLabel;
	 private JLabel StockNameLabel;
	 private JLabel StockTypeLabel;
	 private JLabel unitLabel;
	 private JLabel barcodeLabel;
	 private JLabel kdvTypeLabel;
	 private JLabel descriptionLabel;
	 private JLabel olusturmaTarihiLabel;
	 private JLabel searchLabel;
	 public static DefaultTableModel model;
	 public static JTable table; 
	 
	 public static JTextField StockCodeTextfield;
	 public static JTextField StockNameTextfieldl;
	 public static JComboBox StockTypeTextfield;
	 public static JComboBox unitTextfield;
	 public static JTextField barcodeTextfield;
	 public static JTextField searchTextfield;
	 public static JComboBox kdvTypeTextfield;
	 public static JTextArea descriptionTextfield;
	 public static JFormattedTextField olusturmaTarihiTextfield;

	 private JButton addButton;
	 private JButton deleteButton;
	 private JButton updateButton;
	 private JButton searchButton;
	 
	 public int selectedRow;
	 
	 public View() {
		 
		  frame = new JFrame("Stok Kartý");
		  frame.getContentPane().setLayout(new BorderLayout());
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(800,600);
		  frame.setLocationRelativeTo(null);
		  frame.setVisible(true);
		  frame.setResizable(false);

		  
		  // Create UI elements
		  setStockCodeLabel(new JLabel("Stok Kodu :"));
		  setStockNameLabel(new JLabel("Stok Adý :"));
		  setStockTypeLabel(new JLabel("Stok Tipi :"));
		  setUnitLabel(new JLabel("Birimi :"));
		  setBarcodeLabel(new JLabel("Barkodu :"));
		  setKdvTypeLabel(new JLabel("KDV Tipi :"));
		  setDescriptionLabel(new JLabel("Açýklama :"));
		  setOlusturmaTarihiLabel(new JLabel("Oluþturma Tarihi :"));
		  setSearchLabel(new JLabel("Ara"));
		  
		  setStockCodeTextfield(new JTextField());
		  setStockNameTextfieldl(new JTextField());
		  setStockTypeTextfield(new JComboBox());
		  StockTypeTextfield.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "30", "40", "50"}));
		  setUnitTextfield(new JComboBox());
		  unitTextfield.setModel(new DefaultComboBoxModel(new String[] {"Birim A", "Birim B", "Birim C"}));
		  setBarcodeTextfield(new JTextField());
		  setKdvTypeTextfield(new JComboBox());
		  kdvTypeTextfield.setModel(new DefaultComboBoxModel(new String[] {"8", "18"}));
		  setDescriptionTextfield(new JTextArea());
		  setOlusturmaTarihiTextfield(new JFormattedTextField());
		  setSearchTextfield(new JTextField());
		  
		  
		  setAddButton(new JButton("Ekle"));
		  setDeleteButton(new JButton("Sil"));
		  setUpdateButton(new JButton("Güncelle"));
		  setSearchButton(new JButton("Ara"));
		  
		  
		  // Add UI element to frame
		
		  GroupLayout layout = new GroupLayout(frame.getContentPane());
		  layout.setAutoCreateGaps(true);
		  layout.setAutoCreateContainerGaps(true);
		  
		  layout.setHorizontalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    		.addComponent(StockCodeLabel)
		    		.addComponent(StockNameLabel)
		    		.addComponent(StockTypeLabel)
		    		.addComponent(unitLabel)
		    		.addComponent(barcodeLabel)
		    		.addComponent(kdvTypeLabel)
		    		.addComponent(descriptionLabel)
		    		.addComponent(olusturmaTarihiLabel)
		    		.addComponent(addButton)
		    		.addComponent(searchLabel))

		    
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    		.addComponent(StockCodeTextfield)
		    		.addComponent(StockNameTextfieldl)
		    		.addComponent(StockTypeTextfield)
		    		.addComponent(unitTextfield)
		    		.addComponent(barcodeTextfield)
		    		.addComponent(kdvTypeTextfield)
		    		.addComponent(descriptionTextfield)
		    		.addComponent(olusturmaTarihiTextfield)
		    		.addComponent(deleteButton)
		    		.addComponent(searchTextfield))
		    
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    		.addComponent(updateButton)
		    		.addComponent(searchButton)));
		  
		  layout.setVerticalGroup(layout.createSequentialGroup()
				  
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    		.addComponent(StockCodeLabel)
		    		.addComponent(StockCodeTextfield))	    
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(StockNameLabel)
		    		.addComponent(StockNameTextfieldl))
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    		.addComponent(StockTypeLabel)
				    .addComponent(StockTypeTextfield))
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    		.addComponent(unitLabel)
				    .addComponent(unitTextfield))
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(barcodeLabel)
				    .addComponent(barcodeTextfield))
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(kdvTypeLabel)
					.addComponent(kdvTypeTextfield))
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    		.addComponent(descriptionLabel)
		    		.addComponent(descriptionTextfield, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    		.addComponent(olusturmaTarihiLabel)
    				.addComponent(olusturmaTarihiTextfield))	    		
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    		.addComponent(addButton)
		    		.addComponent(deleteButton)
		    		.addComponent(updateButton))	    
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    		.addComponent(searchLabel)
		    		.addComponent(searchTextfield)
		    		.addComponent(searchButton)));
		    	

		  layout.linkSize(SwingConstants.HORIZONTAL, addButton, deleteButton);
		  layout.linkSize(SwingConstants.HORIZONTAL, updateButton, searchButton);
		  
		  frame.getContentPane().setLayout(layout);
		  
		  	JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 350, 768, 250);
			frame.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			Object[] columns = {"Stok Kodu", "Stok Adý", "Stok Tipi", "Birimi", "Barkodu", "KDV Tipi", "Açýklama", "Oluþturma Tarihi"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			table.setModel(model);
		 }


	public JLabel getStockCodeLabel() {
		return StockCodeLabel;
	}

	public void setStockCodeLabel(JLabel stockCodeLabel) {
		StockCodeLabel = stockCodeLabel;
	}

	public JLabel getStockNameLabel() {
		return StockNameLabel;
	}

	public void setStockNameLabel(JLabel stockNameLabel) {
		StockNameLabel = stockNameLabel;
	}

	public JLabel getStockTypeLabel() {
		return StockTypeLabel;
	}

	public void setStockTypeLabel(JLabel stockTypeLabel) {
		StockTypeLabel = stockTypeLabel;
	}

	public JLabel getUnitLabel() {
		return unitLabel;
	}

	public void setUnitLabel(JLabel unitLabel) {
		this.unitLabel = unitLabel;
	}

	public JLabel getBarcodeLabel() {
		return barcodeLabel;
	}

	public void setBarcodeLabel(JLabel barcodeLabel) {
		this.barcodeLabel = barcodeLabel;
	}

	public JLabel getKdvTypeLabel() {
		return kdvTypeLabel;
	}

	public void setKdvTypeLabel(JLabel kdvTypeLabel) {
		this.kdvTypeLabel = kdvTypeLabel;
	}

	public JLabel getDescriptionLabel() {
		return descriptionLabel;
	}

	public void setDescriptionLabel(JLabel descriptionLabel) {
		this.descriptionLabel = descriptionLabel;
	}

	public JLabel getOlusturmaTarihiLabel() {
		return olusturmaTarihiLabel;
	}

	public void setOlusturmaTarihiLabel(JLabel olusturmaTarihiLabel) {
		this.olusturmaTarihiLabel = olusturmaTarihiLabel;
	}
	
	public JLabel setSearchLabel() {
		return searchLabel;
	}

	public void setSearchLabel(JLabel searchLabel) {
		this.searchLabel = searchLabel;
	}

	public String getStockCodeTextfield() {
		return StockCodeTextfield.getText();
	}
	
	public void setStockCodeTextfield(JTextField stockCodeTextfield) {
		StockCodeTextfield = stockCodeTextfield;
	}

	public JTextField getStockNameTextfieldl() {
		return StockNameTextfieldl;
	}

	public void setStockNameTextfieldl(JTextField stockNameTextfieldl) {
		StockNameTextfieldl = stockNameTextfieldl;
	}

	public JComboBox getStockTypeTextfield() {
		return StockTypeTextfield;
	}

	public void setStockTypeTextfield(JComboBox stockTypeTextfield) {
		StockTypeTextfield = stockTypeTextfield;
	}

	public JComboBox getUnitTextfield() {
		return unitTextfield;
	}

	public void setUnitTextfield(JComboBox unitTextfield) {
		this.unitTextfield = unitTextfield;
	}

	public JTextField getBarcodeTextfield() {
		return barcodeTextfield;
	}

	public void setBarcodeTextfield(JTextField barcodeTextfield) {
		this.barcodeTextfield = barcodeTextfield;
	}

	public JComboBox getKdvTypeTextfield() {
		return kdvTypeTextfield;
	}

	public void setKdvTypeTextfield(JComboBox kdvTypeTextfield) {
		this.kdvTypeTextfield = kdvTypeTextfield;
	}

	public JTextArea getDescriptionTextfield() {
		return descriptionTextfield;
	}

	public void setDescriptionTextfield(JTextArea descriptionTextfield) {
		this.descriptionTextfield = descriptionTextfield;
	}

	public JTextField getOlusturmaTarihiTextfield() {
		return olusturmaTarihiTextfield;
	}

	public void setOlusturmaTarihiTextfield(JFormattedTextField olusturmaTarihiTextfield) {
		this.olusturmaTarihiTextfield = olusturmaTarihiTextfield;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public JButton getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}
	
	public JTextField getSearchTextfield() {
		return searchTextfield;
	}

	public void setSearchTextfield(JTextField searchTextfield) {
		this.searchTextfield = searchTextfield;
	}
}