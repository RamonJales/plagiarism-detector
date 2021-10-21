package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import model.entities.Signature;
import model.entities.Text;
import model.services.SignatureServices;

public class UI {
	
	public static Signature readMainSignature(Scanner sc) {
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
		
		return new Signature(wal, ttr, hlr, sal, sac, pal);
	}
	
	public static List<Text> readTexts(Scanner sc) {
		List<Text> texts = new ArrayList<>();
		
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
		return texts;
	}
	
	public static int serarchInfected(List<Text> texts, Signature mainSignature, Scanner sc) {
		List<Double> results = new ArrayList<>();
		
		for (Text text : texts) {
			Signature secondSignature = SignatureServices.signatureCalculation(text.getText());
			double similarity = SignatureServices.compareSignature(secondSignature, mainSignature);
			results.add(similarity);
		}
		double infected = Collections.min(results);
		
		return results.indexOf(infected);
	}
}
