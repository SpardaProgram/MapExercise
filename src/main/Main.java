package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entity.Candidatos;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		List<Candidatos> c = new ArrayList<>();
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Map<String, String> infoCandidatos = new LinkedHashMap<>();
			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int number = Integer.parseInt(fields[1]);
				c.add(new Candidatos(name, number));
				line = br.readLine();
			}

			for (Candidatos can : c) {
				if (infoCandidatos.containsKey(can.getName())) {

					int i = Integer.parseInt(infoCandidatos.get(can.getName()));
					i += can.getNumber();

					infoCandidatos.put(can.getName(), "" + i);

				} else {

					infoCandidatos.put(can.getName(), "" + can.getNumber());

				}
			}
			for(String key : infoCandidatos.keySet()) {
				System.out.println(key+ ": "+infoCandidatos.get(key));
			}
				
			

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}
