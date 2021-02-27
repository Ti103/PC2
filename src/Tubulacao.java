public class Tubulacao {
	private final String MATERIAL = "Aço Inoxidavel AISI 304";

	private String norma;
	private String estado;
	private double rugosidade;
	private double diametroInterno;
	private double espessura;
	private double comprimento;
	private Fluido fluido;

	public Tubulacao(String norma, String estado, double rugosidade, double diametroInterno, double espessura,
			double comprimento, Fluido fluido) {
		this.norma = norma;
		this.estado = estado;
		this.rugosidade = rugosidade;
		this.diametroInterno = diametroInterno;
		this.espessura = espessura;
		this.comprimento = comprimento;
		this.fluido = fluido;
	}

	public String getNorma() {
		return norma;
	}

	public void setNorma(String norma) {
		this.norma = norma;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getRugosidade() {
		return rugosidade;
	}

	public void setRugosidade(double rugosidade) {
		this.rugosidade = rugosidade;
	}

	public double getDiametroInterno() {
		return diametroInterno;
	}

	public void setDiametroInterno(double diametroInterno) {
		this.diametroInterno = diametroInterno;
	}

	public double getEspessura() {
		return espessura;
	}

	public void setEspessura(double espessura) {
		this.espessura = espessura;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public Fluido getFluidoQuente() {
		return fluido;
	}

	public void setFluidoQuente(Fluido fluidoQuente) {
		this.fluido = fluidoQuente;
	}

	public String getMaterial() {
		return MATERIAL;
	}

	@Override
	public String toString() {
		return "norma = " + norma + " \nestado = " + estado + " \nrugosidade = " + rugosidade + " \ndiametroInterno = "
				+ diametroInterno + " \nespessura = " + espessura + " \ncomprimento = " + comprimento
				+ " \nfluidoQuente = " + fluido;
	}

	public double calcularRugosidadeRelativa() {
		return rugosidade / diametroInterno;
	}

	public double calcularDiametroExterno() {
		return diametroInterno + 2 * espessura;
	}
	
	//diametro casco

	public double calcularDiametroHidraulico(double razaoDiametro) {
		double de = calcularDiametroExterno();
		double dte = de / razaoDiametro;

		return dte - de;
	}

//	public double calcularCmin() {
//		double cf = fluidoFrio.calcularCapacidadeCalorifica();
//		double cq = fluido.calcularCapacidadeCalorifica();
//		System.err.println("Arquivo não encontrado");
//		if (cf < cq) {
//			return cf;
//		} else {
//			return cq;
//		}
//	}

//	public double calcularCmax() {
//		double cf = fluidoFrio.calcularCapacidadeCalorifica();
//		double cq = fluido.calcularCapacidadeCalorifica();
//		System.err.println("Arquivo não encontrado");
//		if (cf < cq) {
//			return cq;
//		} else {
//			return cf;
//		}
//	}
//
//	public double calcularRazaoCr() {
//		return calcularCmin() / calcularCmax();
//	}
//
//	public double calcularQmax() {
//		double diferencaTermica = (fluidoFrio.getTemperatura() - fluido.getTemperatura());
//		return calcularCmin() * diferencaTermica;
//	}

	public double calcularNumeroDeReynoldsQuente(Fluido fluido) {
//		double d = 0;
		
		LerArquivo lerArquivo = new LerArquivo();
		double viscosidade = lerArquivo.searchInFile("Viscosidade", fluido.getTemperatura());
		double num = 4 * fluido.getVazao();
		double deno = Math.PI * diametroInterno * viscosidade;
		double rDi = num / deno;

		if (rDi <= 2300) {
			fluido.setTipoEscoamento("laminar");
		} else if (rDi <= 4000) {
			fluido.setTipoEscoamento("transição");
		} else {
			fluido.setTipoEscoamento("turbulento");
		}
		return rDi;
	}


}
