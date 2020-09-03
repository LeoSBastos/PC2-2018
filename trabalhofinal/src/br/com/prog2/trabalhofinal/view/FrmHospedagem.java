package br.com.prog2.trabalhofinal.view;

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

import br.com.prog2.trabalhofinal.controller.HospedagemController;
import br.com.prog2.trabalhofinal.negocio.Hospedagem;
import br.com.prog2.trabalhofinal.util.Util;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;

public class FrmHospedagem extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodCliente;
	private JTextField txtCodChale;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataFim;
	private JTable tblConsulta;
	private JTextField txtQtdPessoas;
	private JTextField txtDesconto;
	private JTextField txtValorFinal;
	private MaskFormatter mascaraData = null;
	
	private void buscar(){
		List<Hospedagem> listaHos = new ArrayList<>();
		HospedagemController ch = new HospedagemController();
		listaHos = ch.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1;i >= 0;i--){
			tbm.removeRow(i);;
		}
		int i = 0;
		for (Hospedagem h : listaHos) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(h.getCodHospedagem(), i, 0);
			tblConsulta.setValueAt(h.getCodChale(), i, 1);
			tblConsulta.setValueAt(h.getCodCliente(), i, 2);
			tblConsulta.setValueAt(Util.formatarEstadoParaGui(h.getEstado()), i, 3);
			tblConsulta.setValueAt(h.getDataInicio(), i, 4);
			tblConsulta.setValueAt(h.getDataFim(), i, 5);
			tblConsulta.setValueAt(h.getQtdPessoas(), i, 6);
			tblConsulta.setValueAt(h.getDesconto(), i, 7);
			tblConsulta.setValueAt(h.getValorFinal(), i, 8);
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
					FrmHospedagem frame = new FrmHospedagem();
					frame.setTitle("Cadastro de Hospedagem");
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
	public FrmHospedagem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 851, 716);
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
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel lblCodChale = new JLabel("Código Chalé");
		
		JLabel lblCodCliente = new JLabel("Código Cliente");
		
		JLabel lblDataInicio = new JLabel("Data Início");
		
		JLabel lblDataFim = new JLabel("Data Fim");
		
		txtCodCliente = new JTextField();
		txtCodCliente.setColumns(10);
		
		txtCodChale = new JTextField();
		txtCodChale.setColumns(10);
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtDataInicio = new JFormattedTextField(mascaraData);
		txtDataInicio.setColumns(10);
		
		txtDataFim = new JFormattedTextField(mascaraData);
		txtDataFim.setColumns(10);
		
		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setHorizontalAlignment(SwingConstants.LEFT);
		lblMensagem.setForeground(Color.BLUE);
		
		JLabel lblDdmmaaaa = new JLabel("dd/mm/aaaa");
		lblDdmmaaaa.setForeground(Color.RED);
		
		JLabel lblDdmmaaaa_1 = new JLabel("dd/mm/aaaa");
		lblDdmmaaaa_1.setForeground(Color.RED);
		
		JLabel lblQtdPessoas = new JLabel("Qtd Pessoas");
		
		txtQtdPessoas = new JTextField();
		txtQtdPessoas.setColumns(10);
		
		JLabel lblDesconto = new JLabel("Desconto");
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		
		JLabel lblValorFinal = new JLabel("Valor Final");
		
		txtValorFinal = new JTextField();
		txtValorFinal.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		
		JComboBox cbxEstado = new JComboBox();
		cbxEstado.setModel(new DefaultComboBoxModel(new String[] {"Reservado", "Hospedado"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodCliente)
								.addComponent(lblDataInicio)
								.addComponent(lblDataFim)
								.addComponent(lblCodChale)
								.addComponent(lblQtdPessoas)
								.addComponent(lblDesconto)
								.addComponent(lblValorFinal)
								.addComponent(lblEstado))
							.addGap(14)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxEstado, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValorFinal, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtQtdPessoas, Alignment.LEADING)
										.addComponent(txtCodCliente, Alignment.LEADING)
										.addComponent(txtCodChale, Alignment.LEADING)
										.addComponent(txtDataFim, Alignment.LEADING)
										.addComponent(txtDataInicio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDdmmaaaa_1)
										.addComponent(lblDdmmaaaa)))))
						.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
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
						.addComponent(lblCodChale)
						.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataInicio)
						.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDdmmaaaa))
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataFim)
						.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDdmmaaaa_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQtdPessoas)
						.addComponent(txtQtdPessoas, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesconto)
						.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtValorFinal, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValorFinal))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(cbxEstado, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(lblMensagem)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController ch = new HospedagemController();
				hos.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
				hos.setCodChale(Integer.parseInt(txtCodChale.getText()));
				hos.setQtdPessoas(Integer.parseInt(txtQtdPessoas.getText()));
				hos.setEstado(Util.formatarGuiParaEstado(cbxEstado.getSelectedItem().toString()));
				hos.setValorFinal(Double.parseDouble(txtValorFinal.getText()));
				if(!txtDataInicio.getText().equals("")){
					hos.setDataInicio(Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText()));
				}else{
					hos.setDataInicio(null);
				}
				if(!txtDataFim.getText().equals("")){
					hos.setDataFim(Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText()));
				} else {
					hos.setDataFim(null);
				}
				if(!txtDesconto.getText().equals("")){
					hos.setDesconto(Double.parseDouble(txtDesconto.getText()));
				} else {
					hos.setDesconto(null);
				}
				lblMensagem.setText(ch.inserir(hos));
				buscar();
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController ch = new HospedagemController();
				hos.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
				hos.setCodChale(Integer.parseInt(txtCodChale.getText()));
				hos.setQtdPessoas(Integer.parseInt(txtQtdPessoas.getText()));
				hos.setEstado(Util.formatarGuiParaEstado(cbxEstado.getSelectedItem().toString()));
				hos.setValorFinal(Double.parseDouble(txtValorFinal.getText()));
				if(!txtDataInicio.getText().equals("")){
					hos.setDataInicio(Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText()));
				}else{
					hos.setDataInicio(null);
				}
				if(!txtDataFim.getText().equals("")){
					hos.setDataFim(Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText()));
				} else {
					hos.setDataFim(null);
				}
				if(!txtDesconto.getText().equals("")){
					hos.setDesconto(Double.parseDouble(txtDesconto.getText()));
				} else {
					hos.setDesconto(null);
				}
				lblMensagem.setText(ch.alterar(hos));
				buscar();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				Hospedagem hos = new Hospedagem();
				HospedagemController ch = new HospedagemController();
				hos.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
				hos.setCodChale(Integer.parseInt(txtCodChale.getText()));
				hos = ch.pesquisarCodHospedagem(hos);
				Object[] opcoes = { "Sim", "Nao" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse Hospedagem?",
						"Exclusao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(ch.excluir(hos));
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
				txtCodChale.setText("");
				txtCodCliente.setText("");
				txtDataInicio.setText("");
				txtDataFim.setText("");
				txtQtdPessoas.setText("");
				txtDesconto.setText("");
				txtValorFinal.setText("");
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
				FrmHospedagem.this.dispose();
			}
		});
		
		JButton btnPesquisar = new JButton("Pesquisar");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnVisualizar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair)
					.addContainerGap())
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
						.addComponent(btnLimpar)
						.addComponent(btnPesquisar))
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
				txtCodChale.setText(tblConsulta.getValueAt(linha, 1).toString());
				txtCodCliente.setText(tblConsulta.getValueAt(linha, 2).toString());
				cbxEstado.setSelectedItem(tblConsulta.getValueAt(linha, 3).toString());
				txtDataInicio.setText(tblConsulta.getValueAt(linha, 4).toString());
				txtDataFim.setText(tblConsulta.getValueAt(linha, 5).toString());
				txtQtdPessoas.setText(tblConsulta.getValueAt(linha, 6).toString());
				txtDesconto.setText(tblConsulta.getValueAt(linha, 7).toString());
				txtValorFinal.setText(tblConsulta.getValueAt(linha, 8).toString());
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Hospedagem", "C\u00F3digo Chal\u00E9", "C\u00F3dgio Cliente", "Estado", "Data Inicio", "Data Fim", "Qtd Pessoas", "Desconto", "Valor Final"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(139);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(123);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(117);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(122);
		tblConsulta.getColumnModel().getColumn(5).setResizable(false);
		tblConsulta.getColumnModel().getColumn(5).setPreferredWidth(95);
		tblConsulta.getColumnModel().getColumn(6).setResizable(false);
		tblConsulta.getColumnModel().getColumn(7).setResizable(false);
		tblConsulta.getColumnModel().getColumn(8).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}