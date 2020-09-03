package br.com.prog2.rh.view;

import java.awt.BorderLayout;

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

import br.com.prog2.rh.controller.EmpregadoController;
import br.com.prog2.rh.negocio.Empregado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class FrmEmpregado extends JFrame {

	private JPanel contentPane;
	private JTable tblConsulta;
	private JTextField txtCPF;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtSalario;
	private JLabel lblMensagem;

	private void pesquisar() {
		List<Empregado> listaEmp = new ArrayList<>();
		EmpregadoController ec = new EmpregadoController();
		listaEmp = ec.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
			tbm.removeRow(i);
		}
		int i = 0;
		for (Empregado ep : listaEmp) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(ep.getCpf(), i, 0);
			tblConsulta.setValueAt(ep.getNome(), i, 1);
			tblConsulta.setValueAt(ep.getIdade(), i, 2);
			tblConsulta.setValueAt(ep.getSalario(), i, 3);
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
					FrmEmpregado frame = new FrmEmpregado();
					frame.setTitle("Cadastro de Empregados");
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
	public FrmEmpregado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Empregado emp = new Empregado();
				Empregado emp1 = new Empregado();
				EmpregadoController ec = new EmpregadoController();
				emp.setCpf(txtCPF.getText());
				emp.setNome(txtNome.getText());
				emp.setIdade(Integer.parseInt(txtIdade.getText()));
				emp.setSalario(Double.parseDouble(txtSalario.getText()));
				emp1 = ec.pesquisarPorCpf(emp.getCpf());
				if (emp1 != null) {
					txtCPF.setText(emp1.getCpf());
					txtNome.setText(emp1.getNome());
					txtIdade.setText(String.valueOf(emp1.getIdade()));
					txtSalario.setText(String.valueOf(emp1.getSalario()));
					JOptionPane.showMessageDialog(null, "Ja existe um empregado com este cpf");
				} else {
					lblMensagem.setText(ec.inserir(emp));
				}
				pesquisar();
			}
		});
		btnInserir.setHorizontalAlignment(SwingConstants.LEADING);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Empregado emp = new Empregado();
				EmpregadoController ec = new EmpregadoController();
				emp.setCpf(txtCPF.getText());
				emp.setNome(txtNome.getText());
				emp.setIdade(Integer.parseInt(txtIdade.getText()));
				emp.setSalario(Double.parseDouble(txtSalario.getText()));
				lblMensagem.setText(ec.alterar(emp));
				pesquisar();
			}
		});
		btnAlterar.setHorizontalAlignment(SwingConstants.LEFT);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Empregado emp = new Empregado();
				EmpregadoController ec = new EmpregadoController();
				emp.setCpf(txtCPF.getText());
				Object[] opcoes = { "Sim", "Nao" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse empregado: " + txtNome.getText() + "?",
						"Exclusao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(ec.excluir(emp));
				} else {
					lblMensagem.setText("Exclusao cancelada");
				}
				pesquisar();
			}
		});
		btnExcluir.setHorizontalAlignment(SwingConstants.LEFT);

		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisar();
			}
		});

		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String cpf = tblConsulta.getValueAt(linha, 0).toString();
				String nome = tblConsulta.getValueAt(linha, 1).toString();
				String idade = tblConsulta.getValueAt(linha, 2).toString();
				String salario = tblConsulta.getValueAt(linha, 3).toString();
				txtCPF.setText(cpf);
				txtNome.setText(nome);
				txtIdade.setText(idade);
				txtSalario.setText(salario);
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmEmpregado.this.dispose();
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCPF.setText("");
				txtNome.setText("");
				txtIdade.setText("");
				txtSalario.setText("");
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
					tbm.removeRow(i);
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnVisualizar)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnConsulta)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLimpar).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSair)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnInserir)
								.addComponent(btnAlterar).addComponent(btnExcluir).addComponent(btnVisualizar)
								.addComponent(btnConsulta).addComponent(btnSair).addComponent(btnLimpar))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setVerticalAlignment(SwingConstants.TOP);

		txtCPF = new JTextField();
		txtCPF.setColumns(10);

		JLabel lblNome = new JLabel("Nome");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		JLabel lblIdade = new JLabel("Idade");

		txtIdade = new JTextField();
		txtIdade.setColumns(10);

		JLabel lblSalario = new JLabel("Salario");

		txtSalario = new JTextField();
		txtSalario.setColumns(10);

		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setForeground(Color.RED);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblIdade)
									.addComponent(lblNome))
								.addComponent(lblCpf))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
								.addComponent(txtIdade, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
								.addComponent(txtCPF, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
								.addComponent(txtSalario, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)))
						.addComponent(lblMensagem)
						.addComponent(lblSalario))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdade)
						.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSalario)
						.addComponent(txtSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(lblMensagem)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		JScrollPane scrollPane = new JScrollPane();

		tblConsulta = new JTable();
		tblConsulta
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CPF", "Nome", "Idade", "Salario" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, Integer.class, Double.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		scrollPane.setViewportView(tblConsulta);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
