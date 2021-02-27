public class Fluido {
	private String nome;
	private double temperatura;
	private double pressao;
	private double vazao;
	private String tipoEscoamento;

	public Fluido(String nome, double temperatura, double pressao, double vazao) {
		this.nome = nome;
		this.temperatura = temperatura;
		this.pressao = pressao;
		this.vazao = vazao;
	}

	public Fluido(String nome, double temperatura, double pressao) {
		this.nome = nome;
		this.temperatura = temperatura;
		this.pressao = pressao;
	}

	public String getNome() {
		return nome;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public double getPressao() {
		return pressao;
	}

	public double getVazao() {
		return vazao;
	}

	public void setVazao(double vazao) {
		this.vazao = vazao;
	}

	public String getTipoEscoamento() {
		return tipoEscoamento;
	}

	public void setTipoEscoamento(String tipoEscoamento) {
		this.tipoEscoamento = tipoEscoamento;
	}

	public double calcularCapacidadeCalorifica() {
		LerArquivo lerArquivo = new LerArquivo();
		lerArquivo.openFile("files/propriedades_agua_saturada.csv");
		double calorEspecifico = lerArquivo.searchInFile("Calor Especifico", temperatura);
		lerArquivo.closeFile();
		return calorEspecifico * vazao;
	}

	public double calcularNumeroDePrandtl() {
		LerArquivo lerArquivo = new LerArquivo();
		lerArquivo.openFile("files/propriedades_agua_saturada.csv");
		double calorEspecifico = lerArquivo.searchInFile("Calor Especifico", temperatura);
		double viscosidade = lerArquivo.searchInFile("Viscosidade", temperatura);
		double condutividade = lerArquivo.searchInFile("Condutividade Termica", temperatura);
		lerArquivo.closeFile();
		return (calorEspecifico * viscosidade) / condutividade;
	}

	
	


}
