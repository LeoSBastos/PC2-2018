package br.com.prog2.rh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prog2.rh.controller.DependenteController;
import br.com.prog2.rh.controller.EmpregadoController;
import br.com.prog2.rh.negocio.Dependente;
import br.com.prog2.rh.negocio.Empregado;
import br.com.prog2.rh.util.Util;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;

public class FrmDependente extends JFrame {

	private JPanel contentPane;
	private JTable tblConsulta;
	private JTextField txtNome;
	private JLabel lblMensagem;
	private MaskFormatter mascaraData = null;
	private JFormattedTextField txtDataNascimento;
	private JComboBox cbxEmpregado;
	private JComboBox cbxGrau;
	private List<Empregado> listaEmp;

	private void mostrarDados() {
		List<Dependente> listaDep = new ArrayList<>();
		DependenteController dc = new DependenteController();
		listaDep = dc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
			tbm.removeRow(i);
		}
		int i = 0;
		for (Dependente dp : listaDep) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(dp.getCpfEmpregado(), i, 0);
			tblConsulta.setValueAt(dp.getNome(), i, 1);
			tblConsulta.setValueAt(dp.getGrauParentesco(), i, 2);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(dp.getDataNascimento()), i, 3);
			i++;
		}
		lblMensagem.setText("Consulta total realizada com sucesso");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDependente frame = new FrmDependente();
					frame.setTitle("Cadastro dos Dependentes");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public FrmDependente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 644, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(12)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dependente dep = new Dependente();
				DependenteController dc = new DependenteController();
				Integer pos = 0;
				for (Empregado e1 : listaEmp) {
					if (e1.getNome().equals(cbxEmpregado.getSelectedItem()))
						pos = listaEmp.indexOf(e1);
				}
				dep.setCpfEmpregado(listaEmp.get(pos).getCpf());
				dep.setNome(txtNome.getText());
				dep.setGrauParentesco(cbxGrau.getSelectedItem().toString());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataNascimento.getText());
				dep.setDataNascimento(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				lblMensagem.setText(dc.inserir(dep));
				mostrarDados();
			}
		});
		btnInserir.setHorizontalAlignment(SwingConstants.LEADING);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dependente dep = new Dependente();
				DependenteController dc = new DependenteController();
				Integer pos = 0;
				for (Empregado e1 : listaEmp) {
					if (e1.getNome().equals(cbxEmpregado.getSelectedItem()))
						pos = listaEmp.indexOf(e1);
				}
				dep.setCpfEmpregado(listaEmp.get(pos).getCpf());
				dep.setNome(txtNome.getText());
				dep.setGrauParentesco(cbxGrau.getSelectedItem().toString());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataNascimento.getText());
				dep.setDataNascimento(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				lblMensagem.setText(dc.alterar(dep));
				mostrarDados();
			}
		});
		btnAlterar.setHorizontalAlignment(SwingConstants.LEFT);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dependente dep = new Dependente();
				DependenteController dc = new DependenteController();
				Integer pos = 0;
				for (Empregado e1 : listaEmp) {
					if (e1.getNome().equals(cbxEmpregado.getSelectedItem()))
						pos = listaEmp.indexOf(e1);
				}
				dep.setCpfEmpregado(listaEmp.get(pos).getCpf());
				dep.setNome(txtNome.getText());
				Object[] opcoes = { "Sim", "Nao" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse Dependente: " + txtNome.getText() + "?",
						"Exclusao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(dc.excluir(dep));
				} else {
					lblMensagem.setText("Exclusao cancelada");
				}
				mostrarDados();
			}
		});
		btnExcluir.setHorizontalAlignment(SwingConstants.LEFT);

		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarDados();
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmDependente.this.dispose();
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNome.setText("");
				txtDataNascimento.setText("");
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
					tbm.removeRow(i);
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnVisualizar)
					.addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnVisualizar)
						.addComponent(btnSair)
						.addComponent(btnLimpar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JLabel lblEmpregado = new JLabel("Empregado");
		lblEmpregado.setVerticalAlignment(SwingConstants.TOP);

		JLabel lblNome = new JLabel("Nome");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		JLabel lblGrau = new JLabel("Grau de Parentesco");

		JLabel lblDataNascimento = new JLabel("Data de Nascimento");

		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setForeground(Color.RED);

		EmpregadoController ec = new EmpregadoController();
		listaEmp = ec.listarTodos();
		cbxEmpregado = new JComboBox();
		for (Empregado e : listaEmp) {
			cbxEmpregado.addItem(e.getNome());
		}
		cbxEmpregado.setEditable(true);

		cbxGrau = new JComboBox();
		cbxGrau.setModel(new DefaultComboBoxModel(
				new String[] { "Filho", "Filha", "Enteado", "Enteada", "Pai", "M\u00E3e", "Agregado" }));

		JLabel lblDdmmaa = new JLabel("dd/mm/aaaa");
		lblDdmmaa.setForeground(Color.RED);

		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtDataNascimento = new JFormattedTextField(mascaraData);

		JButton button = new JButton("..");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmEmpregado fe = new FrmEmpregado();
				fe.setVisible(true);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNome)
								.addComponent(lblGrau).addComponent(lblDataNascimento).addComponent(lblEmpregado))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxEmpregado, 0, 479, Short.MAX_VALUE).addComponent(txtNome, 479, 479,
										479)
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtDataNascimento)
												.addComponent(cbxGrau, 0, 166, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDdmmaa))))
						.addComponent(lblMensagem))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(button)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxEmpregado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmpregado).addComponent(button))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNome).addComponent(txtNome,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblGrau).addComponent(cbxGrau,
						GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblDataNascimento)
						.addComponent(lblDdmmaa).addComponent(txtDataNascimento, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE).addComponent(lblMensagem)
				.addContainerGap()));
		panel.setLayout(gl_panel);

		JScrollPane scrollPane = new JScrollPane();

		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					Integer linha = tblConsulta.getSelectedRow();
					String cpfEmpregado = tblConsulta.getValueAt(linha, 0).toString();
					String nome = tblConsulta.getValueAt(linha, 1).toString();
					String grauParente = tblConsulta.getValueAt(linha, 2).toString();
					String dataNasc = tblConsulta.getValueAt(linha, 3).toString();
					txtNome.setText(nome);
					cbxGrau.setSelectedItem(grauParente);
					txtDataNascimento.setText(dataNasc);
					Integer pos = 0;
					for(Empregado e : listaEmp){
						if(e.getCpf().equals(tblConsulta.getValueAt(linha, 0))){
							pos = listaEmp.indexOf(e);
						}
					}
					cbxEmpregado.setSelectedItem(listaEmp.get(pos).getNome());
			}
		});
		tblConsulta.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Empregado", "Nome", "Grau Parentesco", "Data Nascimento" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(94);
		tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(99);
		scrollPane.setViewportView(tblConsulta);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_2.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE).addGap(24)));
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
