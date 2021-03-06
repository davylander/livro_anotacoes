package view;


import controller.Diario;
import controller.GerenciarAnotacoes;

import java.awt.*;
//import java.awt.event.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {
	
	ImageIcon iconeJanela = new ImageIcon("material/imagens/diario.png");
	ImageIcon iconeMarcador = new ImageIcon("material/imagens/marcador.png");
	ImageIcon iconePagina = new ImageIcon("material/imagens/linhas.jpg");
	ImageIcon iconeSalvar = new ImageIcon("material/imagens/salvar.png");
	ImageIcon iconeEditar = new ImageIcon("material/imagens/editar.png");
	ImageIcon iconeDeletar = new ImageIcon("material/imagens/deletar.png");
	
	Diario diario = new Diario();
	GerenciarAnotacoes anotacoes = new GerenciarAnotacoes();
	
	private JFrame frame;
	private JTable table;
	private JTextField txtTitulo;
	private JTextArea txtTexto;
	
	public int token;

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
		
		/*TelaPrincipal window = new TelaPrincipal();
		window.frame.setVisible(true);*/
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
		//token = diario.getTokenId();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		token = diario.retornaToken();
		
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
		panelVisualizar.setBackground(Color.decode("#F8EEC8"));
		frame.getContentPane().add(panelVisualizar);
		panelVisualizar.setLayout(null);
		
		JLabel labelPaginaEsquerda = new JLabel("");
		labelPaginaEsquerda.setBounds(10, 11, 357, 36);
		labelPaginaEsquerda.setIcon(iconePagina);
		panelVisualizar.add(labelPaginaEsquerda);
		
		table = new JTable();
		table.setBounds(10, 328, 357, -178);
		panelVisualizar.add(table);
		
		JLabel labelPaginaEsquerda_1 = new JLabel("");
		labelPaginaEsquerda_1.setBounds(10, 99, 357, 36);
		labelPaginaEsquerda_1.setIcon(iconePagina);
		panelVisualizar.add(labelPaginaEsquerda_1);
		
		JButton editarBotao = new JButton("edit");
		editarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		editarBotao.setBackground(Color.decode("#FEF9E4"));
		editarBotao.setBounds(65, 47, 57, 51);
		editarBotao.setIcon(iconeEditar);
		panelVisualizar.add(editarBotao);
		
		JButton deletarBotao = new JButton("deleta");
		deletarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < anotacoes.listarAnotacoes(token).size(); i ++) {
					System.out.println(
						"ID: " + anotacoes.listarAnotacoes(token).get(i).getId() +"\n"+
						"Data: " + anotacoes.listarAnotacoes(token).get(i).getData() +"\n"+
						"Titulo: " +	anotacoes.listarAnotacoes(token).get(i).getTitulo() +"\n"+
						"Texto: " +	anotacoes.listarAnotacoes(token).get(i).getTexto() +"\n"+
						"Usuario ID: " +	anotacoes.listarAnotacoes(token).get(i).getUsuarioId()
										);
				}
			}
		});
		deletarBotao.setBackground(Color.decode("#FEF9E4"));
		deletarBotao.setIcon(iconeDeletar);
		deletarBotao.setBounds(254, 47, 57, 51);
		panelVisualizar.add(deletarBotao);
		
		
		//--------------------Lado Direito---------------------------
		JPanel panelInserir= new JPanel();
		panelInserir.setBounds(397, 11, 377, 339);
		panelInserir.setBackground(Color.decode("#F8EEC8"));
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
		
		JButton enviarBotao = new JButton("");
		enviarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = txtTitulo.getText();
				String texto = txtTexto.getText();
				if(diario.checarSalvamentoAnotacao(token) == true && token > 0) {
					JOptionPane.showMessageDialog(null, "Anota??o salva!");
					anotacoes.salvarAnotacao(titulo, texto, token);
					txtTitulo.setText("");
					txtTexto.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Falha ao salvar anota??o!");
					txtTitulo.setText("");
					txtTexto.setText("");
				}
			}
		});
		enviarBotao.setBounds(10, 277, 57, 51);
		enviarBotao.setBackground(Color.decode("#FEF9E4"));
		enviarBotao.setIcon(iconeSalvar);
		panelInserir.add(enviarBotao);
		
		
		// ___________________________________________________________________________________________________________________________________________
	}
	
	@SuppressWarnings("deprecation")
	public void show() {
		frame.show(); // abre a pagina
	}
	
	
}
