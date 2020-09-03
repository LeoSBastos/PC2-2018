package br.com.prog2.trabalhofinal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.prog2.trabalhofinal.controller.ChaleController;
import br.com.prog2.trabalhofinal.negocio.Chale;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class FrmChale extends JFrame {

	private JPanel contentPane;
	private JTextField txtLocalizacao;
	private JTextField txtCapacidade;
	private JTextField txtValorAltaEstacao;
	private JTextField txtValorBaixaEstacao;
	private JTable tblConsulta;
	
	private void buscar(){
		List<Chale> listaCha = new ArrayList<>();
		ChaleController cc = new ChaleController();
		listaCha = cc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1;i >= 0;i--){
			tbm.removeRow(i);;
		}
		int i = 0;
		for (Chale c : listaCha) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(c.getCodChale(), i, 0);
			tblConsulta.setValueAt(c.getLocalizacao(), i, 1);
			tblConsulta.setValueAt(c.getValorAltaEstacao(), i, 2);
			tblConsulta.setValueAt(c.getValorBaixaEstacao(), i, 3);
			tblConsulta.setValueAt(c.getCapacidade(), i, 4);
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
					FrmChale frame = new FrmChale();
					frame.setTitle("Cadastro de Chalé");
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
	public FrmChale() {
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
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE))
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
		
		JLabel lblLocalizao = new JLabel("Localização");
		
		JLabel lblCapacidade = new JLabel("Capacidade");
		
		JLabel lblValorAltaEstao = new JLabel("Valor Alta Estação");
		
		JLabel lblValorBaixaEstao = new JLabel("Valor Baixa Estação");
		
		txtLocalizacao = new JTextField();
		txtLocalizacao.setColumns(10);
		
		txtCapacidade = new JTextField();
		txtCapacidade.setColumns(10);
		
		txtValorAltaEstacao = new JTextField();
		txtValorAltaEstacao.setColumns(10);
		
		txtValorBaixaEstacao = new JTextField();
		txtValorBaixaEstacao.setColumns(10);
		
		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setHorizontalAlignment(SwingConstants.LEFT);
		lblMensagem.setForeground(Color.BLUE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLocalizao)
								.addComponent(lblCapacidade)
								.addComponent(lblValorAltaEstao)
								.addComponent(lblValorBaixaEstao))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtLocalizacao, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtValorBaixaEstacao, Alignment.LEADING)
									.addComponent(txtValorAltaEstacao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
						.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalizao)
						.addComponent(txtLocalizacao, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCapacidade)
						.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorAltaEstao)
						.addComponent(txtValorAltaEstacao, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorBaixaEstao)
						.addComponent(txtValorBaixaEstacao, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMensagem)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		ChaleController cc = new ChaleController();
		List<Chale> listaCha = new ArrayList<Chale>();
		listaCha = cc.listarTodos();
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale ch = new Chale();
				ChaleController cc = new ChaleController();
				ch.setLocalizacao(txtLocalizacao.getText());
				if(!txtValorAltaEstacao.getText().equals("")){
					ch.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
				}else{
					ch.setValorAltaEstacao(null);
				}
				if(!txtValorBaixaEstacao.getText().equals("")){
					ch.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));
				} else {
					ch.setValorBaixaEstacao(null);
				}
				ch.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
				lblMensagem.setText(cc.inserir(ch));
				buscar();
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale ch = new Chale();
				ChaleController cc = new ChaleController();
				ch.setLocalizacao(txtLocalizacao.getText());
				ch.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
				ch = cc.pesquisarCodChale(ch);
				if(!txtValorAltaEstacao.getText().equals("")){
					ch.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
				}else{
					ch.setValorAltaEstacao(null);
				}
				if(!txtValorBaixaEstacao.getText().equals("")){
					ch.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));
				} else {
					ch.setValorBaixaEstacao(null);
				}
				lblMensagem.setText(cc.alterar(ch));
				buscar();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				Chale ch = new Chale();
				ChaleController cc = new ChaleController();
				ch.setLocalizacao(txtLocalizacao.getText());
				ch.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
				ch = cc.pesquisarCodChale(ch);
				Object[] opcoes = { "Sim", "Nao" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse Chale?",
						"Exclusao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(cc.excluir(ch));
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
				txtCapacidade.setText("");
				txtLocalizacao.setText("");
				txtValorAltaEstacao.setText("");
				txtValorBaixaEstacao.setText("");
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
				FrmChale.this.dispose();
			}
		});
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
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
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
						.addComponent(btnLimpar))
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
				txtLocalizacao.setText(tblConsulta.getValueAt(linha, 1).toString());
				txtValorAltaEstacao.setText(tblConsulta.getValueAt(linha, 2).toString());
				txtValorBaixaEstacao.setText(tblConsulta.getValueAt(linha, 3).toString());
				txtCapacidade.setText(tblConsulta.getValueAt(linha, 4).toString());
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Chal\u00E9", "Localiza\u00E7\u00E3o", "Valor Alta Esta\u00E7\u00E3o", "Valor Baixa Esta\u00E7\u00E3o", "Capacidade"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(146);
		tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(139);
		tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(146);
		tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(95);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
