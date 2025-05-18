package main;

public class App {

	public static void main(String[] args) {
		try {
			Window window = new Window();
		} catch (Exception err) {
			System.out.println(err.getLocalizedMessage());
		}
		
	}
}
