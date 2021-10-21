package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Signature;
import model.entities.Text;
import model.services.SignatureServices;

public class MainProgram {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Text> texts = new ArrayList<>();
		List<Double> results = new ArrayList<>();
		
		//read the main signature
		System.out.println("Welcome to the automatic COH-PIAH detector.");
		System.out.println("Enter the typical signature of an infected student:");
		System.out.println();
		
		System.out.print("Enter the average word size: ");
		double wal = sc.nextDouble();
		
		System.out.print("Enter the Type-Token relational: ");
		double ttr = sc.nextDouble();
		
		System.out.print("Enter the Hapax Legomana reason: ");
		double hlr = sc.nextDouble();
		
		System.out.print("Enter the average sentence size: ");
		double sal = sc.nextDouble();
		
		System.out.print("Enter the average sentence complexity: ");
		double sac = sc.nextDouble();
	
		System.out.print("Enter average phrase size: ");
		double pal = sc.nextDouble();
		
		Signature mainSignature = new Signature(wal, ttr, hlr, sal, sac, pal);
		
		//reads all texts and puts them into a list
		int count = 1;
		String text = " ";
		
		sc.nextLine();
		
		while(!(text.equals(""))) {
			System.out.print("Type text "+ count +"(type enter to exit): ");
			text = sc.nextLine();
			texts.add(new Text(text, null, null, null, null, null));
			count += 1;
		}
		texts.remove(texts.size() - 1);
		
		//search for which text is infected
		for (Text text1 : texts) {
			Signature secondSignature = SignatureServices.signatureCalculation(text1.getText());
			double similarity = SignatureServices.compareSignature(secondSignature, mainSignature);
			results.add(similarity);
		}
		
		double infected = Collections.min(results);
		int position = results.indexOf(infected);
		
		System.out.println("The author of text " + (position + 1) + " is infected with COH-PIAH!");
		
		sc.close();
	}
}
