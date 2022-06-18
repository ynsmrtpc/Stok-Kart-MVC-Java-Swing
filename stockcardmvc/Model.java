package stockcardmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

public class Model {
	// deðiþkenler ve getter setter methodlarý tanýmlanmasý
	
		private String StockCode;
		private String StockName;
		private int StockType;
		private String unit;
		private String barcode;
		private double kdvType;
		private String description;
		public Object[] row; 
		
		public Model(String StockCode,String StockName,int StockType,String unit,String barcode,double kdvType,String description) {
			this.setStockCode(StockCode);
			this.setStockName(StockName);
			this.setStockType(StockType);
			this.setUnit(unit);
			this.setBarcode(barcode);
			this.setKdvType(kdvType);
			this.setDescription(description);
		}

		public String getStockCode() {
			return StockCode;
		}

		public void setStockCode(String stockCode) {
			StockCode = stockCode;
		}

		public String getStockName() {
			return StockName;
		}

		public void setStockName(String stockName) {
			StockName = stockName;
		}

		public int getStockType() {
			return StockType;
		}

		public void setStockType(int stockType) {
			StockType = stockType;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getBarcode() {
			return barcode;
		}

		public void setBarcode(String barcode) {
			this.barcode = barcode;
		}

		public double getKdvType() {
			return kdvType;
		}

		public void setKdvType(double kdvType) {
			this.kdvType = kdvType;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		public static Connection getConnection() {
			Connection con = null;
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/stockcardschema","root","");
			} catch (Exception e) {
				System.out.println("SQLException: " + e.getMessage());
			    System.out.println("SQLState: " + ((SQLException) e).getSQLState());
			    System.out.println("VendorError: " + ((SQLException) e).getErrorCode());
			}
			return con;
		}
		
		public void addDatabase(String stokkodu,String stokadi,int stoktipi,String birimi,String barkodu,double kdvtipi,String aciklama) {
			PreparedStatement ps;
			String query = "INSERT INTO `stockcard` "
					+ "(`stokkodu`,`stokadi`,`stoktipi`, `birimi`,`barkodu`,`kdvtipi`, `aciklama`) "
					+ "VALUES (?,?,?,?,?,?,?)";
			try {
				ps = getConnection().prepareStatement(query);
				ps.setString(1, stokkodu);
				ps.setString(2,stokadi);
				ps.setInt(3, stoktipi);
				ps.setString(4,birimi);
				ps.setString(5,barkodu);
				ps.setDouble(6,kdvtipi);
				ps.setString(7,aciklama);
				
				if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "New Product Add");
					}

				} catch(Exception e) { JOptionPane.showMessageDialog(null, e); }

		}
		
		public void addTabletoUI() {
			java.sql.Statement ps;
			String query = "SELECT * FROM `stockcard` ";
			
			try {
				ps = getConnection().createStatement();
				ResultSet rs = ps.executeQuery(query);
				
				while(rs.next()) {
							            
		    		row = new Object[8];
					row[0] = rs.getString(1);
					row[1] = rs.getString(2);
					row[2] = rs.getString(3);
					row[3] = rs.getString(4);
					row[4] = rs.getString(5);
					row[5] = rs.getString(6);
					row[6] = rs.getString(7);
					row[7] = rs.getString(8);
					
					View.model.addRow(row);  
				} 
			} catch(Exception e) { JOptionPane.showMessageDialog(null, e.getMessage()); }
		}
		
	public void deleteDatabase(int selectedRow) {
	
			String i = View.table.getModel().getValueAt(selectedRow, 0).toString();
			System.out.print(i);
						
			if (selectedRow >= 0) {
				try {
					java.sql.Statement ps;
					
					String query = String.format("DELETE FROM `stockcard` WHERE stokkodu='%s'",i);
					ps = getConnection().createStatement();
					ps.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Product Deleted");
					
					View.model.removeRow(selectedRow);

				} catch (Exception e)  { JOptionPane.showMessageDialog(null, e); }

			} else {
				JOptionPane.showMessageDialog(null, "Lütfen Tablodan Bir Veri Seçiniz!");
			}		
	}
	
	public void updateDatabase(String stokChange,String stockName,int stockTipi,
			String unit,String barkod,double kdvTipi,String aciklama) {
		
		try {
		java.sql.Statement ps;
		
		String query = String.format("UPDATE `stockcard` SET stokadi='%s',"
				+ "stoktipi=%d, birimi='%s', barkodu='%s', kdvtipi=%f, "
				+ "aciklama='%s' WHERE stokkodu='%s'",
				stockName,stockTipi,unit,barkod,kdvTipi,aciklama,stokChange);

		ps = getConnection().createStatement();
		ps.executeUpdate(query);

		} catch(Exception e){ JOptionPane.showMessageDialog(null, e); }	
	}
	
	public void search(String stokkodu) {
		java.sql.Statement ps;
		String query = String.format("SELECT * FROM `stockcard` WHERE stokkodu='%s'",stokkodu);

		try {
			ps = getConnection().createStatement();
			ResultSet rs = ps.executeQuery(query);
            
            if(rs.next()) {
            	String stokcode = rs.getString(1);
            	String stokadi = rs.getString(2);
            	int stoktipi = rs.getInt(3);
            	String birimi  = rs.getString(4);
            	String barkodu   = rs.getString(5);
            	double kdvtipi  = rs.getDouble(6);
            	String aciklama = rs.getString(7);
            	String date  = rs.getString(8);
            	
				int i = View.table.getSelectedRow();
				View.StockCodeTextfield.setText(stokcode);
				View.StockNameTextfieldl.setText(stokadi);
				View.StockTypeTextfield.setSelectedItem(stoktipi);
				View.unitTextfield.setSelectedItem(birimi);
				View.barcodeTextfield.setText(barkodu);
				View.kdvTypeTextfield.setSelectedItem(kdvtipi);
				View.descriptionTextfield.setText(aciklama);
				View.olusturmaTarihiTextfield.setText(date);
				
            } else { JOptionPane.showMessageDialog(null, "Ürün Bulunamadý!");   }
		
		} catch(Exception e) { JOptionPane.showMessageDialog(null, e); }
	}

}