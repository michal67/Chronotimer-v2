package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException {
		CTController control = new CTController();
		Scanner userPrompt = new Scanner(System.in);
		boolean fileBeenRead = false;

		if (!control.controlFromFile()) {
			Simulator simulator = new Simulator(false);
			for (String nextLine = userPrompt.nextLine(); !nextLine.equalsIgnoreCase("EXIT"); nextLine = userPrompt
					.nextLine())
				simulator.input(nextLine.split("\\s+"));
		} else {
			while (!fileBeenRead) {
				System.out.print("Enter the full file directory: ");
				try {
					BufferedReader reader = new BufferedReader(new FileReader(userPrompt.nextLine()));
					Simulator simulator = new Simulator(true);

					for (String nextLine = reader.readLine(); nextLine != null
							&& !nextLine.equalsIgnoreCase("EXIT"); nextLine = reader.readLine())
						simulator.input(nextLine.split("\\s+"));
					fileBeenRead = true;
					reader.close();
				} catch (FileNotFoundException e) {
					System.out.println("Invalid filepath");
				}
			}
		}
	}
}
