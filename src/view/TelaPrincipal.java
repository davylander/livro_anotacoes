package view;

import java.awt.*;
//import java.awt.event.*;

import javax.swing.*;

public class TelaPrincipal {

	ImageIcon iconeJanela = new ImageIcon("material/imagens/diario.png");
	ImageIcon iconeMarcador = new ImageIcon("material/imagens/marcador.png");
	ImageIcon iconePagina = new ImageIcon("material/imagens/linhas.jpg");
	
	private JFrame frame;
	private JTable table;
	private JTextField txtTitulo;
	private JTextArea txtTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(iconeJanela.getImage());
		frame.getContentPane().setBackground(Color.decode("#A6453C"));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		// ______________________________________________________________PARTE ARTISTICA______________________________________________________________
		//--------------------Lado Esquerdo---------------------------
		JPanel panelVisualizar = new JPanel();
		panelVisualizar.setBounds(10, 11, 377, 339);
		frame.getContentPane().add(panelVisualizar);
		panelVisualizar.setLayout(null);
		
		JLabel labelPaginaEsquerda = new JLabel("");
		labelPaginaEsquerda.setBounds(10, 11, 357, 36);
		labelPaginaEsquerda.setIcon(iconePagina);
		panelVisualizar.add(labelPaginaEsquerda);
		
		table = new JTable();
		table.setBounds(10, 325, 357, -304);
		panelVisualizar.add(table);
		
		JLabel labelPaginaEsquerda_1 = new JLabel("");
		labelPaginaEsquerda_1.setBounds(10, 94, 357, 36);
		labelPaginaEsquerda_1.setIcon(iconePagina);
		panelVisualizar.add(labelPaginaEsquerda_1);
		
		
		//--------------------Lado Direito---------------------------
		JPanel panelInserir= new JPanel();
		panelInserir.setBounds(397, 11, 377, 339);
		frame.getContentPane().add(panelInserir);
		panelInserir.setLayout(null);
		
		JLabel labelPaginaDireita = new JLabel("");
		labelPaginaDireita.setBounds(10, 11, 357, 36);
		labelPaginaDireita.setIcon(iconePagina);
		panelInserir.add(labelPaginaDireita);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(88, 58, 279, 26);
		panelInserir.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel labelPaginaDireita_1 = new JLabel("");
		labelPaginaDireita_1.setBounds(10, 95, 357, 36);
		labelPaginaDireita_1.setIcon(iconePagina);
		panelInserir.add(labelPaginaDireita_1);
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo:");
		lblNewLabel.setBounds(10, 58, 68, 26);
		panelInserir.add(lblNewLabel);
		
		txtTexto = new JTextArea();
		txtTexto.setBounds(88, 142, 279, 186);
		panelInserir.add(txtTexto);
		txtTexto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Anota\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(10, 142, 68, 26);
		panelInserir.add(lblNewLabel_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(299, 142, 17, 186);
		panelInserir.add(scrollBar);
		
		
		// ___________________________________________________________________________________________________________________________________________
	}
	
	@SuppressWarnings("deprecation")
	public void show() {
		frame.show(); // abre a pagina
	}
}
