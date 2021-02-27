import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LerArquivo {
	private Scanner input;
	
	public void openFile(String filename) {
		try {
			input = new Scanner(new File(filename));			
		} catch (FileNotFoundException exception) {
			System.err.println("Arquivo não encontrado");
		}
	}
	
	public double searchInFile(String coluna, double temperatura) {
		double menorVariacao = Double.MAX_VALUE;
		String[] bestLine = {};
		String line = input.nextLine();
		List<String> colunas = Arrays.asList(line.split(","));
		int index = colunas.indexOf(coluna);
		try {
			while((line = input.nextLine()) != null) {
				String[] values = line.split(",");
				if(temperatura == Double.valueOf(values[0])){
					return Double.valueOf(values[index]);
				}
				double diferenca = temperatura - Double.valueOf(values[0]);
				if(diferenca < 0) {
					diferenca *= -1;
				}
				if(diferenca < menorVariacao) {
					menorVariacao = diferenca;
					bestLine = values;
				}
			}			
		}catch(Exception e) {
			line = null;
		}
		return Double.valueOf(bestLine[index]);
	}
	
	public void closeFile() {
		if(input != null) {
			input.close();
		}
	}
}
