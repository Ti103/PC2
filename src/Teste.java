import java.io.FileNotFoundException;

public class Teste {
	public static void main(String[] args) throws FileNotFoundException {
		LerArquivo lerArquivo = new LerArquivo();
		lerArquivo.openFile("files/propriedades_agua_saturada.csv");
		double inFile = lerArquivo.searchInFile("Pressao", 294);
		System.out.println(inFile);
	}
}
