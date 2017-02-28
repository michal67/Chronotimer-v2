import java.io.File;
public class Driver {
	public static void main(String[] args) {
		CTController control = new CTController();
		Simulator simulator = new Simulator();
		Scanner userPrompt = new Scanner(System.in);
		boolean fileBeenRead = false;
		
		if(!control.controlFromFile()){
			for(String nextLine = userPrompt.nextLine(); !nextLine.equalsIgnoreCase("EXIT"); nextLine = userPrompt.nextLine())
				simulator.input(nextLine);
		}
		while(!fileBeenRead){
			System.out.print("Enter the full file directory: ");
			try{
				BufferedReader reader = new BufferedReader(new FileReader(userPrompt.nextLine()));
				for(String nextLine = reader.nextLine(); nextLine != null; nextLine = reader.nextLine())
					simulator.input(nextLine);
				fileBeenRead = true;
			}
			catch (FileNotFoundException e)
				System.out.println("Invalid filepath");
		}
	}
}
