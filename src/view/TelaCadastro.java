package view;

import controller.GerenciarUsuarios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TelaCadastro {
	ImageIcon iconeJanela = new ImageIcon("material/imagens/diario.png");
	ImageIcon iconeCadeado = new ImageIcon("material/imagens/cadeado.png");
	ImageIcon iconeChave = new ImageIcon("material/imagens/chave.png");
	ImageIcon iconeMarcador = new ImageIcon("material/imagens/marcador.png");
	ImageIcon iconeCadastrar = new ImageIcon("material/imagens/cadastrar.png");
	ImageIcon iconeVoltar = new ImageIcon("material/imagens/voltar.png");
	
	private JFrame frame;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
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
	public TelaCadastro() {
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
		Border borda = BorderFactory.createLineBorder(Color.black,3);
		Border bordaFina = BorderFactory.createLineBorder(Color.black,1);
		Border bordaLogin = BorderFactory.createLineBorder(Color.decode("#FADC60"),3);
		
		JPanel panel = new JPanel(); // 1/2 linha amarela
		panel.setBounds(0, 73, 95, 47);
		panel.setBackground(Color.decode("#F2C12E"));
		panel.setBorder(borda);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel(); // 2/2 linha amarela
		panel_1.setBounds(0, 202, 95, 47);
		panel_1.setBackground(Color.decode("#F2C12E"));
		panel_1.setBorder(borda);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel(); // capa laranja
		panel_2.setBounds(0, 0, 784, 361);
		panel_2.setBackground(Color.decode("#9B3C2F"));
		panel_2.setBorder(borda);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel(); // Branco container
		panel_3.setBounds(103, 294, 681, 56);
		panel_3.setBackground(Color.decode("#EFEDEE"));
		panel_3.setBorder(borda);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel(); // paginas cinzas 1/2
		panel_4.setBounds(10, 11, 661, 10);
		panel_4.setBackground(Color.decode("#D2D2D2"));
		panel_3.add(panel_4);
		
		JPanel panel_5 = new JPanel(); // paginas cinzas 1/2
		panel_5.setBounds(10, 35, 661, 10);
		panel_5.setBackground(Color.decode("#D2D2D2"));
		panel_3.add(panel_5);
		
		JPanel panel_6 = new JPanel(); // capa clara
		panel_6.setBounds(103, 0, 681, 293);
		panel_6.setBackground(Color.decode("#AD4F3D"));
		panel_6.setBorder(bordaFina);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel(); // tirinha da capa
		panel_7.setBounds(469, 110, 212, 84);
		panel_7.setBackground(Color.decode("#C86D5C"));
		panel_7.setBorder(borda);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(""); //cadeado
		lblNewLabel.setBounds(0, 0, 72, 84);
		lblNewLabel.setIcon(iconeChave);
		lblNewLabel.setBorder(bordaLogin);
		panel_7.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(""); // marcador azul
		lblNewLabel_1.setBounds(10, 0, 76, 67);
		lblNewLabel_1.setIcon(iconeMarcador);
		panel_6.add(lblNewLabel_1);
		
		txtLogin = new JTextField(); // campo Login
		txtLogin.setBounds(230, 113, 134, 20);
		panel_6.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField(); // campo Senha
		txtSenha.setBounds(230, 144, 134, 20);
		panel_6.add(txtSenha);
		txtSenha.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(230, 178, 134, 20);
		panel_6.add(txtNome);
		
		JButton cadastrarBotao = new JButton(""); // botao chave login
		cadastrarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telaLogin = new TelaLogin();
				String login = txtLogin.getText();
				String senha = new String(((JPasswordField) txtSenha).getPassword());
				String nome = txtNome.getText();
				GerenciarUsuarios gerenciarUsuarios = new GerenciarUsuarios();
				int validacao = gerenciarUsuarios.validarCadastro(login);
				
				if( validacao == 1) {
					JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
					gerenciarUsuarios.cadastrar(login, senha, nome);
					telaLogin.show();
					frame.dispose();
				}else if(validacao == 2) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar! Login já existente!");
				}else if(validacao == 0){
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar!");
				}
			}
		});
		cadastrarBotao.setBounds(398, 121, 67, 60);
		cadastrarBotao.setIcon(iconeCadastrar);
		cadastrarBotao.setBackground(Color.decode("#AD4F3D"));
		cadastrarBotao.setBorder(bordaLogin);
		panel_6.add(cadastrarBotao);
		
		JLabel lblNewLabel_2 = new JLabel("Login:"); // label login
		lblNewLabel_2.setBounds(155, 115, 46, 14);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN,15));
		lblNewLabel_2.setForeground(Color.white);
		panel_6.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Senha:"); // label senha
		lblNewLabel_3.setBounds(155, 147, 46, 14);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN,15));
		lblNewLabel_3.setForeground(Color.white);
		panel_6.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CADASTRO"); // título
		lblNewLabel_4.setBounds(173, 25, 282, 67);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN,50));
		lblNewLabel_4.setForeground(Color.white);
		panel_6.add(lblNewLabel_4);
		
		JButton voltarLoginBotao = new JButton("");
		voltarLoginBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin login = new TelaLogin();
				login.show();
				frame.dispose();
			}
		});
		voltarLoginBotao.setBounds(247, 219, 67, 60);
		voltarLoginBotao.setIcon(iconeVoltar);
		voltarLoginBotao.setBackground(Color.decode("#AD4F3D"));
		voltarLoginBotao.setBorder(bordaLogin);
		panel_6.add(voltarLoginBotao);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nome:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(155, 180, 46, 14);
		panel_6.add(lblNewLabel_3_1);
		
	}

	//-----------------------
	@SuppressWarnings("deprecation")
	public void show() {
		frame.show(); // abre a pagina
	}
}
