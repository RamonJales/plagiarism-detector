package application;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Signature;
import model.entities.Text;

public class MainProgram {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		try (Scanner sc = new Scanner(System.in);){
			
			//read the main signature
			Signature mainSignature = UI.readMainSignature(sc);
			
			//reads all texts and puts them into a list
			List<Text> texts = UI.readTexts(sc);
			
			//search for which text is infected
			int position = UI.serarchInfected(texts, mainSignature, sc);
			
			System.out.println("The author of text " + (position + 1) + " is infected with COH-PIAH!");
			sc.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}