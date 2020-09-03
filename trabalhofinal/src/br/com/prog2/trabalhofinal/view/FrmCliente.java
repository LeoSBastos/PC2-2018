package br.com.prog2.trabalhofinal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prog2.trabalhofinal.controller.ClienteController;
import br.com.prog2.trabalhofinal.negocio.Cliente;
import br.com.prog2.trabalhofinal.util.Util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class FrmCliente extends JFrame {
	
	private JLabel lblMensagem;
	private JPanel contentPane;
	private JTable tblConsulta;
	private JTextField txtNomeCliente;
	private JTextField txtRgCliente;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtCep;
	JFormattedTextField txtNascimento;
	private JTextField txtCodigo;
	private MaskFormatter mascaraData = null;
	private Util data;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setTitle("Cadastro de Clientes");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 525);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
						.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 672, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
		);

		JScrollPane scrollPane = new JScrollPane();

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(201))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(32)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
					.addContainerGap())
		);

		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				
				String codigo = tblConsulta.getValueAt(linha, 0).toString();
				String nome = tblConsulta.getValueAt(linha, 1).toString();
				String rg = tblConsulta.getValueAt(linha, 2).toString();
				String endereco = tblConsulta.getValueAt(linha, 3).toString();
				String bairro = tblConsulta.getValueAt(linha, 4).toString();
				String cidade = tblConsulta.getValueAt(linha, 5).toString();
				String estado = tblConsulta.getValueAt(linha, 6).toString();
				String cep = tblConsulta.getValueAt(linha, 7).toString();
				String nascimento = tblConsulta.getValueAt(linha, 8).toString();	
				
				
				try {
					if(!nascimento.equals("-")) {
						DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");
						Date date;
						date = formatUS.parse(nascimento);
						DateFormat formatBR = new SimpleDateFormat("dd/mm/yyyy");
						String nascimentoFormatado = formatBR.format(date);
						txtNascimento.setText(nascimentoFormatado);
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				//Depois formata data
				
				txtCodigo.setText(codigo);
				txtNomeCliente.setText(nome);
				txtRgCliente.setText(rg);
				txtEndereco.setText(endereco);
				txtBairro.setText(bairro);
				txtCidade.setText(cidade);
				txtEstado.setText(estado);
				txtCep.setText(cep);
				
				
			}
		});
		tblConsulta.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome", "RG",
				"Endere\u00E7o", "Bairro", "Cidade", "Estado", "CEP", "Data de Nascimento" }));
		scrollPane_1.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController cc = new ClienteController();

				cli.setNomeCliente(txtNomeCliente.getText());
				cli.setRgCliente(txtRgCliente.getText());
				cli.setEnderecoCliente((txtEndereco.getText()));
				cli.setBairroCliente(txtBairro.getText());
				cli.setCidadeCliente(txtCidade.getText());
				cli.setEstadoCliente(txtEstado.getText());
				cli.setCepCliente(txtCep.getText());
				cli.setNascimentoCliente(Util.formatarDataDeGuiParaLocalDate((txtNascimento.getText())));
				
				lblMensagem.setText(cc.inserir(cli));
				pesquisar();
			}
		});

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController cc = new ClienteController();

				cli.setCodCliente(Integer.parseInt(txtCodigo.getText()));
				cli.setNomeCliente(txtNomeCliente.getText());
				cli.setRgCliente(txtRgCliente.getText());
				cli.setEnderecoCliente(txtEndereco.getText());
				cli.setBairroCliente(txtBairro.getText());
				cli.setCidadeCliente(txtCidade.getText());
				cli.setEstadoCliente(txtEstado.getText());
				cli.setCepCliente(txtCep.getText());
				cli.setNascimentoCliente(LocalDate.parse(txtNascimento.getText()));
				
				lblMensagem.setText(cc.alterar(cli));
				pesquisar();
			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController cc = new ClienteController();
				cli.setNomeCliente(txtNomeCliente.getText());
				cli.setCodCliente(Integer.parseInt(txtCodigo.getText()));
				
				Object[] opcoes = { "Sim", "N�o" };
				int i = JOptionPane.showOptionDialog(null,"Deseja excluir o Cliente: "+txtNomeCliente.getText()+"?",
				"Exclus�o",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,	null, opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
					lblMensagem.setText(cc.excluir(cli));
				}
				pesquisar();
			}
		});

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisar();
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodigo.setText("");
				txtNomeCliente.setText("");
				txtRgCliente.setText("");
				txtEndereco.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtEstado.setText("");
				txtCep.setText("");
				txtNascimento.setText("");
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();

				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
					tbm.removeRow(i);
				}
				pesquisar();
			}
			
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmCliente.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE).addComponent(btnInserir)
						.addGap(40).addComponent(btnAlterar).addGap(33).addComponent(btnExcluir).addGap(35)
						.addComponent(btnPesquisar).addGap(33).addComponent(btnLimpar).addGap(32).addComponent(btnSair)
						.addGap(55)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnSair)
								.addComponent(btnLimpar).addComponent(btnPesquisar).addComponent(btnExcluir)
								.addComponent(btnAlterar).addComponent(btnInserir))
						.addContainerGap(18, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNome = new JLabel("Nome:");

		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);

		JLabel lblRg = new JLabel("RG:");

		txtRgCliente = new JTextField();
		txtRgCliente.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");

		txtBairro = new JTextField();
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");

		txtCidade = new JTextField();
		txtCidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");

		txtEstado = new JTextField();
		txtEstado.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");

		txtCep = new JTextField();
		txtCep.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		
		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setForeground(Color.BLUE);
		
		
		try {
	            mascaraData = new MaskFormatter("##/##/####");
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        txtNascimento = new JFormattedTextField(mascaraData);
	   

	      
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(lblRg)
								.addComponent(lblEndereo)
								.addComponent(lblBairro)
								.addComponent(lblCidade))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtRgCliente, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblDataDeNascimento)
									.addGap(18)
									.addComponent(txtNascimento, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtNomeCliente, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtCidade, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblEstado)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
											.addGap(128))
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtEndereco, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
												.addComponent(txtBairro, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblCep)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblCdigo)
											.addGap(18)
											.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))))
						.addComponent(lblMensagem))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(txtNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRg)
						.addComponent(txtRgCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataDeNascimento)
						.addComponent(txtNascimento, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCep)
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCdigo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCidade)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMensagem)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void pesquisar(){
		List<Cliente> listaCli = new ArrayList();
		ClienteController cli = new ClienteController();
		listaCli = cli.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
			tbm.removeRow(i);
		}
		int i = 0;
		for (Cliente cl : listaCli) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(cl.getCodCliente(), i, 0);
			tblConsulta.setValueAt(cl.getNomeCliente(), i, 1);
			tblConsulta.setValueAt(cl.getRgCliente(), i, 2);
			if(cl.getEnderecoCliente()!= null) {

				tblConsulta.setValueAt(cl.getEnderecoCliente(), i, 3);
			}else {
				tblConsulta.setValueAt("-", i, 3);
			}
			if(cl.getBairroCliente() != null) {
				tblConsulta.setValueAt(cl.getBairroCliente(), i, 4);
			}else {
				tblConsulta.setValueAt("-", i, 4);
			}
			
			if(cl.getCidadeCliente() != null) {
				tblConsulta.setValueAt(cl.getCidadeCliente(), i, 5);
			}else {
				tblConsulta.setValueAt("-", i, 5);
			}
			
			if(cl.getEstadoCliente() != null) {
				tblConsulta.setValueAt(cl.getEstadoCliente(), i, 6);
			}else {
				tblConsulta.setValueAt("-", i, 6);
			}
			if(cl.getCepCliente()!= null) {
				tblConsulta.setValueAt(cl.getCepCliente(), i, 7);
			}else {
				tblConsulta.setValueAt("-", i, 7);
			}
			if(cl.getNascimentoCliente()!= null) {
				tblConsulta.setValueAt(cl.getNascimentoCliente(), i, 8);
			}else {
				tblConsulta.setValueAt("-", i, 8);
			}
			i++;
		}
		
	}
}
