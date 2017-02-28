import java.io.File;
public class Driver {
	public static void main(String[] args) {
		CTController control = new CTController();
		Simulator simulator = new Simulator();
		Scanner userPrompt = new Scanner(System.in);
		boolean fileBeenRead = false;
		String nextLine;
		
		if(!control.controlFromFile()){
			while(true)
				simulator.input(userPrompt.nextLine());
		}
		while(!fileBeenRead){
			System.out.print("Enter the full file directory: ");
			try{
				BufferedReader reader = new BufferedReader(new FileReader(userPrompt.nextLine()));
				for(String nextLine = reader.nextLine(); nextLine != null; nextLine = reader.nextLine())
					simulator.input(nextLine);
			}
			catch (FileNotFoundException e){
				System.out.println("Invalid filepath");
			}
		}
	}
}
