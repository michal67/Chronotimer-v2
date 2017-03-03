import java.io.File;
public class Driver {
	public static void main(String[] args) {
		CTController control = new CTController();
		Scanner userPrompt = new Scanner(System.in);
		boolean fileBeenRead = false;
		
		if(!control.controlFromFile()){
			Simulator simulator = new Simulator(false);
			for(String nextLine = userPrompt.nextLine(); !nextLine.equalsIgnoreCase("EXIT"); nextLine = userPrompt.nextLine())
				simulator.input(nextLine.split(" "));
		}
		else{
			while(!fileBeenRead){
				System.out.print("Enter the full file directory: ");
				try{
					BufferedReader reader = new BufferedReader(new FileReader(userPrompt.nextLine()));
					Simulator simulator = new Simulator(true);
				
					for(String nextLine = reader.nextLine(); nextLine != null && !nextLine.equalsIgnoreCase("EXIT"); nextLine = reader.nextLine())
						simulator.input(nextLine.split(" "));
					fileBeenRead = true;
				}
				catch (FileNotFoundException e)
					System.out.println("Invalid filepath");
			}
		}
	}
}
