package br.com.prog2.trabalhofinal.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
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

import br.com.prog2.trabalhofinal.controller.TelefoneController;
import br.com.prog2.trabalhofinal.negocio.Telefone;
import br.com.prog2.trabalhofinal.util.Util;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;

public class FrmTelefone extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodCliente;
	private JFormattedTextField txtTelefone;
	private JTable tblConsulta;
	private MaskFormatter mascaraData = null;
	
	private void buscar(){
		List<Telefone> listaTel = new ArrayList<>();
		TelefoneController tc = new TelefoneController();
		listaTel = tc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1;i >= 0;i--){
			tbm.removeRow(i);;
		}
		int i = 0;
		for (Telefone tel : listaTel) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(tel.getCodCliente(), i, 0);
			tblConsulta.setValueAt(tel.getTelefone(), i, 1);
			tblConsulta.setValueAt(Util.formatarTipoTelefoneParaGui(tel.getTipoTelefone()), i, 2);
			i++;
		}
				
	}
	
	private void buscarCodCliente(Telefone t){
		TelefoneController tc = new TelefoneController();
		List<Telefone> listaTel = tc.pesquisarPorCodCliente(t.getCodCliente());
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1;i >= 0;i--){
			tbm.removeRow(i);;
		}
		int i = 0;
		for (Telefone tel : listaTel) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(tel.getCodCliente(), i, 0);
			tblConsulta.setValueAt(tel.getTelefone(), i, 1);
			tblConsulta.setValueAt(Util.formatarTipoTelefoneParaGui(tel.getTipoTelefone()), i, 2);
			i++;
		}
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTelefone frame = new FrmTelefone();
					frame.setTitle("Cadastro de Telefone");
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
	public FrmTelefone() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 496);
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblCodCliente = new JLabel("Código Cliente");
		
		JLabel lblTelefone = new JLabel("Telefone");
		
		txtCodCliente = new JTextField();
		txtCodCliente.setColumns(10);
		try {
			mascaraData = new MaskFormatter("#####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtTelefone = new JFormattedTextField(mascaraData);
		txtTelefone.setColumns(10);
		
		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setHorizontalAlignment(SwingConstants.LEFT);
		lblMensagem.setForeground(Color.BLUE);
		
		JLabel lblTipoTelefone = new JLabel("Tipo Telefone");
		
		JComboBox cbxTipoTelefone = new JComboBox();
		cbxTipoTelefone.setModel(new DefaultComboBoxModel(new String[] {"Fixo", "Movel"}));
		
		JLabel lblxxXxxxxxxxx = new JLabel("XXXXX-XXXX");
		lblxxXxxxxxxxx.setForeground(Color.RED);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodCliente)
								.addComponent(lblTelefone)
								.addComponent(lblTipoTelefone))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxTipoTelefone, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtTelefone)
									.addComponent(txtCodCliente, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblxxXxxxxxxxx)
							.addGap(170)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodCliente)
						.addComponent(txtCodCliente, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblxxXxxxxxxxx))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoTelefone)
						.addComponent(cbxTipoTelefone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(79)
					.addComponent(lblMensagem)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Telefone tel = new Telefone();
				TelefoneController tc = new TelefoneController();
				tel.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
				tel.setTelefone(txtTelefone.getText());
				tel.setTipoTelefone(Util.formatarGuiParaTipoTelefone(cbxTipoTelefone.getSelectedItem().toString()));
				lblMensagem.setText(tc.inserir(tel));
				buscar();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				Telefone tel = new Telefone();
				TelefoneController tc = new TelefoneController();
				tel.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
				tel.setTelefone(txtTelefone.getText());
				tel.setTipoTelefone(Util.formatarGuiParaTipoTelefone(cbxTipoTelefone.getSelectedItem().toString()));
				Object[] opcoes = { "Sim", "Nao" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse Telefone?",
						"Exclusao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(tc.excluir(tel));
				} else {
					lblMensagem.setText("Exclusao cancelada");
				}
				buscar();
			}
		});
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				buscar();
				
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodCliente.setText("");
				txtTelefone.setText("");
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
					tbm.removeRow(i);
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmTelefone.this.dispose();
			}
		});
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Telefone tel = new Telefone();
				tel.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
				buscarCodCliente(tel);
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnVisualizar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesquisar)
					.addGap(24)
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSair)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnExcluir)
						.addComponent(btnVisualizar)
						.addComponent(btnPesquisar)
						.addComponent(btnLimpar)
						.addComponent(btnSair))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				txtCodCliente.setText(tblConsulta.getValueAt(linha, 0).toString());
				txtTelefone.setText(tblConsulta.getValueAt(linha, 1).toString());
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Cliente", "Telefone", "Tipo Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(114);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(253);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(256);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}