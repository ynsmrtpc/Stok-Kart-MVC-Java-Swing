package stockcardmvc;


public class App {
	
	
	public static void main(String[] args) {
		
		Model m = new Model(null, "stokkodu", 0, null, null, 0, null);
		View v = new View();		
		Controller c = new Controller(m, v);
		c.initController();
		m.addTabletoUI();
		c.CopytoFields();
	}
}