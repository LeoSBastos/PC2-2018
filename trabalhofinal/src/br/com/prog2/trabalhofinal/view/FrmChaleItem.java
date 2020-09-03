package br.com.prog2.trabalhofinal.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import br.com.prog2.trabalhofinal.controller.ChaleController;
import br.com.prog2.trabalhofinal.controller.ChaleItemController;
import br.com.prog2.trabalhofinal.controller.ItemController;
import br.com.prog2.trabalhofinal.negocio.Chale;
import br.com.prog2.trabalhofinal.negocio.ChaleItem;
import br.com.prog2.trabalhofinal.negocio.Item;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmChaleItem extends JFrame {

	private JPanel contentPane;
	private JTable tblConsulta;
	private JComboBox cbxCodChale;
	private JComboBox cbxNomeItem;
	private List<Chale> listaChale;
	private List<Item> listaItem;
	
	private void buscar(){
		List<ChaleItem> listaChaIt = new ArrayList<>();
		ChaleItemController cit = new ChaleItemController();
		listaChaIt = cit.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1;i >= 0;i--){
			tbm.removeRow(i);;
		}
		int i = 0;
		for (ChaleItem ci : listaChaIt) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(ci.getCodChale(), i, 0);
			tblConsulta.setValueAt(ci.getNomeItem(), i, 1);
			i++;
		}
				
	}
	private void buscarChale(List<ChaleItem> listaChale){
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1;i >= 0;i--){
			tbm.removeRow(i);;
		}
		int i = 0;
		for (ChaleItem ch : listaChale) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(ch.getCodChale(), i, 0);
			tblConsulta.setValueAt(ch.getNomeItem(), i, 1);
			i++;
		}
				
	}
	private void buscarItem(List<ChaleItem> listaItem){
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1;i >= 0;i--){
			tbm.removeRow(i);;
		}
		int i = 0;
		for (ChaleItem it : listaItem) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(it.getCodChale(), i, 0);
			tblConsulta.setValueAt(it.getNomeItem(),i, 1);
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
					FrmChaleItem frame = new FrmChaleItem();
					frame.setTitle("Cadastro de Item do Chalé");
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
	public FrmChaleItem() {
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
		
		JLabel lblCodChale = new JLabel("Código Chalé");
		
		JLabel lblNomeItem = new JLabel("Nome Item");
		
		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setHorizontalAlignment(SwingConstants.LEFT);
		lblMensagem.setForeground(Color.BLUE);
		
		String aux = "Nenhum";
		
		ChaleController cc = new ChaleController();
		listaChale = cc.listarTodos();
		cbxCodChale = new JComboBox();
		
		cbxCodChale.addItem(aux);
		for(Chale c : listaChale){
			cbxCodChale.addItem(c.getCodChale());
		}
		
		ItemController ic = new ItemController();
		listaItem = ic.listarTodos();
		cbxNomeItem = new JComboBox();
		
		cbxNomeItem.addItem(aux);
		for(Item i : listaItem){
			cbxNomeItem.addItem(i.getNomeItem());
		}
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodChale)
								.addComponent(lblNomeItem))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxCodChale, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxNomeItem, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
							.addGap(164)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodChale)
						.addComponent(cbxCodChale, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeItem)
						.addComponent(cbxNomeItem, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(106)
					.addComponent(lblMensagem)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		ChaleItemController cic = new ChaleItemController();
		List<ChaleItem> listaChaleItem = new ArrayList<>();
		listaChaleItem = cic.listarTodos();
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChaleItem ci = new ChaleItem();
				ChaleItemController cic = new ChaleItemController();
				ci.setCodChale(Integer.parseInt(cbxCodChale.getSelectedItem().toString()));
				ci.setNomeItem(cbxNomeItem.getSelectedItem().toString());
				lblMensagem.setText(cic.inserir(ci));
				buscar();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				ChaleItem ci = new ChaleItem();
				ChaleItemController cic = new ChaleItemController();
				ci.setCodChale(Integer.parseInt(cbxCodChale.getSelectedItem().toString()));
				ci.setNomeItem(cbxNomeItem.getSelectedItem().toString());
				Object[] opcoes = { "Sim", "Nao" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse Item do Chale?",
						"Exclusao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(cic.excluir(ci));
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
				cbxCodChale.setSelectedItem(aux);
				cbxNomeItem.setSelectedItem(aux);
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
				FrmChaleItem.this.dispose();
			}
		});
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cbxCodChale.getSelectedItem().toString().equals(aux)){
					buscarItem(cic.pesquisarPorNomeItem(cbxNomeItem.getSelectedItem().toString()));
				} else if(cbxNomeItem.getSelectedItem().toString().equals(aux)){
					buscarChale(cic.pesquisarPorcodChale(Integer.parseInt(cbxCodChale.getSelectedItem().toString())));
				} 
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnVisualizar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
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
						.addComponent(btnSair)
						.addComponent(btnLimpar)
						.addComponent(btnExcluir)
						.addComponent(btnVisualizar)
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
				cbxCodChale.setSelectedItem(tblConsulta.getValueAt(linha, 0));
				cbxNomeItem.setSelectedItem(tblConsulta.getValueAt(linha, 1));
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Chal\u00E9", "Nome Item"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(155);
		tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(469);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
