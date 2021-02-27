import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Analyser extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel inputNormas;
	private JLabel labelNorma;
	private JComboBox<String> comboNormas;

	private JPanel inputEstado;
	private JLabel labelEstado;
	private JComboBox<String> comboEstado;

	private JPanel inputDiametro;
	private JLabel labelDiametro;
	private JComboBox<Double> comboDiametro;

	private JPanel inputRazao;
	private JLabel labelRazao;
	private JComboBox<Double> comboVazao;

	private JPanel inputComprimento;
	private JLabel labelcomprimento;
	private JComboBox<Double> comboComprimento;

	private JPanel inputFluido;
	private JLabel labelFluido;
	private JComboBox<String> comboFluido;

	private JPanel inputFluidoAtributos;
	private JLabel labelTemperatura;
	private JTextField textFieldTemperatura;
	private JLabel labelPressao;
	private JTextField textFieldPressao;
	private JLabel labelVazao;
	private JTextField textFieldVazao;
	
	private JPanel botoes;
	private JButton buttonGerar;
	private JButton buttonFechar;
	private JPanel filler;

	private String normaSelecionada;

	public Analyser(String string) {
		super(string);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		criaInputNormas();
		criaInputEstado();
		criaInputDiametro();
		criaInputRazao();
		criaInputComprimento();
		criaInputFluido();
		criaInputFluidoAtributos();
		criaFiller();
		criaBotoes();

		adicionaPanels();

	}

	private void adicionaPanels() {
		add(inputNormas);
		add(inputEstado);
		add(inputDiametro);
		add(inputComprimento);
		add(inputRazao);
		add(inputFluido);
		add(inputFluidoAtributos);
		add(filler);
		add(botoes);
	}

	private void criaInputNormas() {
		inputNormas = new JPanel(new GridLayout(1, 0));

		labelNorma = new JLabel("Norma: ");
		inputNormas.add(labelNorma);

		comboNormas = new JComboBox<>();
		comboNormas.addItem("ASTM A-249");
		comboNormas.addItem("ASTM A-269");
		comboNormas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				normaSelecionada = (String) comboNormas.getSelectedItem();
				if (normaSelecionada.equals("ASTM A-249")) {
					comboDiametro.removeAllItems();
					comboDiametro.addItem(19.05);
					comboDiametro.addItem(25.40);
					comboDiametro.addItem(38.10);
					comboDiametro.addItem(50.80);
				} else {
					comboDiametro.removeAllItems();
					comboDiametro.addItem(15.88);
					comboDiametro.addItem(19.05);
					comboDiametro.addItem(25.40);
					comboDiametro.addItem(31.75);
				}
			}
		});
		inputNormas.add(comboNormas);
	}

	private void criaInputEstado() {
		inputEstado = new JPanel(new GridLayout(1, 0));
		labelEstado = new JLabel("Estado do material: ");
		inputEstado.add(labelEstado);
		comboEstado = new JComboBox<>();
		comboEstado.addItem("Velho");
		comboEstado.addItem("Novo");
		inputEstado.add(comboEstado);
	}

	private void criaInputDiametro() {
		inputDiametro = new JPanel(new GridLayout(1, 0));
		labelDiametro = new JLabel("Diâmetro interno: ");
		inputDiametro.add(labelDiametro);

		normaSelecionada = (String) comboNormas.getSelectedItem();

		comboDiametro = new JComboBox<Double>();

		comboDiametro.addItem(19.05);
		comboDiametro.addItem(25.40);
		comboDiametro.addItem(38.10);
		comboDiametro.addItem(50.80);

		inputDiametro.add(comboDiametro);
	}

	private void criaInputRazao() {
		inputRazao = new JPanel(new GridLayout(1, 0));
		labelRazao = new JLabel("Razao diametro interno e externo (De/Det): ");
		inputRazao.add(labelRazao);

		comboVazao = new JComboBox<Double>();
		comboVazao.addItem(0.4);
		comboVazao.addItem(0.6);
		inputRazao.add(comboVazao);
	}

	private void criaInputComprimento() {
		inputComprimento = new JPanel(new GridLayout(1, 0));
		labelcomprimento = new JLabel("Comprimento da tubulação em [m]: ");
		inputComprimento.add(labelcomprimento);

		comboComprimento = new JComboBox<Double>();
		comboComprimento.addItem(5.0);
		comboComprimento.addItem(7.5);
		comboComprimento.addItem(10.0);
		inputComprimento.add(comboComprimento);
	}

	private void criaInputFluido() {
		inputFluido = new JPanel(new GridLayout(1, 0));
		labelFluido = new JLabel("Razao diametro interno e externo (De/Det): ");
		inputFluido.add(labelFluido);

		comboFluido = new JComboBox<String>();
		comboFluido.addItem("Água líquida");
		comboFluido.addItem("Óleo de motor");
		inputFluido.add(comboFluido);

		criaInputFluidoAtributos();
	}

	private void criaInputFluidoAtributos() {
		inputFluidoAtributos = new JPanel(new GridLayout(3, 0));
		labelTemperatura = new JLabel("Temperatura (Tq,e) em [\u00B0C]:");
		inputFluidoAtributos.add(labelTemperatura);

		textFieldTemperatura = new JTextField(2);
		inputFluidoAtributos.add(textFieldTemperatura);

		labelPressao = new JLabel("Pressão (Pq,e) em [kPa]:");
		inputFluidoAtributos.add(labelPressao);

		textFieldPressao = new JTextField(2);
		inputFluidoAtributos.add(textFieldPressao);

		labelVazao = new JLabel("Vazão (ṁq,e) em [m³/s]:");
		inputFluidoAtributos.add(labelVazao);

		textFieldVazao = new JTextField(2);
		inputFluidoAtributos.add(textFieldVazao);
	}

	private void criaFiller() {
		filler = new JPanel(new GridLayout(1, 0));
		JButton fillerButton = new JButton();
		fillerButton.setVisible(false);
		filler.add(fillerButton);
		JButton fillerButton2 = new JButton();
		fillerButton2.setVisible(false);
		filler.add(fillerButton2);
	}

	private void criaBotoes() {
		botoes = new JPanel(new GridLayout(1, 0));
		buttonGerar = new JButton("Gerar Relatório");
		buttonGerar.addActionListener(this);
		botoes.add(buttonGerar);

		buttonFechar = new JButton("Fechar");
		buttonFechar.addActionListener(e -> System.exit(0));
		botoes.add(buttonFechar);
	}

	public Tubulacao criaTubulacao() {
		String norma = (String) comboNormas.getSelectedItem();
		String estado = (String) comboEstado.getSelectedItem();
		double rugosidade = (estado.equals("Novo")) ? 0.0015 : 0.01;
		double diametro = (double) comboDiametro.getSelectedItem();
		double espessura = (norma.contains("249")) ? 1.65 : 1.50;
		double comprimento = (double) comboComprimento.getSelectedItem();
		
		String nome = (String) comboFluido.getSelectedItem();
		double temperatura = Double.valueOf(textFieldTemperatura.getText());
		double pressao = Double.valueOf(textFieldPressao.getText());
		double vazao = Double.valueOf(textFieldVazao.getText());
		Fluido fluidoQuente = new Fluido(nome, temperatura, pressao, vazao);
		
		return new Tubulacao(norma, estado, rugosidade, diametro, espessura, comprimento, fluidoQuente);
	}
	
	private double converteKelvinToCelsius(double kelvin) {
		return kelvin - 273;
	}

	public static void main(String[] args) {
		JFrame frame = new Analyser("Analyser");

		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(criaTubulacao());
	}
}
