import java.io.File;
public class Driver {
	public static void main(String[] args) {
		CTController control = new CTController();
		Simulator simulator = new Simulator();
		Scanner userPrompt = new Scanner(System.in);
		
		if(!control.controlFromFile()){
			while(true)
				simulator.input(userPrompt.nextLine());
		}
		else{
			System.out.print("Enter the full file directory: ");
			try{
				BufferedReader reader = new BufferedReader(new FileReader(userPrompt.nextLine()));
			}
			catch (FileNotFoundException e)
		}
	}
}
