package br.com.prog2.trabalhofinal.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prog2.trabalhofinal.controller.HospedagemController;
import br.com.prog2.trabalhofinal.controller.HospedagemServicoController;
import br.com.prog2.trabalhofinal.controller.ServicoController;
import br.com.prog2.trabalhofinal.negocio.Hospedagem;
import br.com.prog2.trabalhofinal.negocio.HospedagemServico;
import br.com.prog2.trabalhofinal.negocio.Servico;
import br.com.prog2.trabalhofinal.util.Util;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class FrmHospedagemServico extends JFrame {
	private JPanel contentPane;
	private JTable tblConsulta;
	private JComboBox cbxCodHospedagem;
	private JComboBox cbxCodServico;
	private List<Hospedagem> listaHospedagem;
	private List<Servico> listaServico;
	private JTextField txtValorServico;
	private JFormattedTextField txtDataServico;
	private MaskFormatter mascaraData = null;
	
	private void buscar(){
		List<HospedagemServico> listaHosSer = new ArrayList<>();
		HospedagemServicoController cit = new HospedagemServicoController();
		listaHosSer = cit.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1;i >= 0;i--){
			tbm.removeRow(i);;
		}
		int i = 0;
		for (HospedagemServico hs : listaHosSer) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(hs.getCodHospedagem(), i, 0);
			tblConsulta.setValueAt(hs.getCodServico(), i, 1);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(hs.getDataServico()), i, 2);
			tblConsulta.setValueAt(hs.getValorServico(), i, 3);
			i++;
		}
				
	}
	private void buscarHospedagem(List<HospedagemServico> listaHospedagem){
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1;i >= 0;i--){
			tbm.removeRow(i);;
		}
		int i = 0;
		for (HospedagemServico hs : listaHospedagem) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(hs.getCodHospedagem(), i, 0);
			tblConsulta.setValueAt(hs.getCodServico(), i, 1);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(hs.getDataServico()), i, 2);
			tblConsulta.setValueAt(hs.getValorServico(), i, 3);
			i++;
		}
				
	}
	private void buscarServico(List<HospedagemServico> listaServico){
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1;i >= 0;i--){
			tbm.removeRow(i);;
		}
		int i = 0;
		for (HospedagemServico hs : listaServico) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(hs.getCodHospedagem(), i, 0);
			tblConsulta.setValueAt(hs.getCodServico(), i, 1);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(hs.getDataServico()), i, 2);
			tblConsulta.setValueAt(hs.getValorServico(), i, 3);
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
					FrmHospedagemServico frame = new FrmHospedagemServico();
					frame.setTitle("Cadastro de Servico do Chalé");
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
	public FrmHospedagemServico() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
				.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
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
		
		JLabel lblCodHospedagem = new JLabel("Código Hospedagem");
		
		JLabel lblCodServico = new JLabel("Código Serviço");
		
		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setHorizontalAlignment(SwingConstants.LEFT);
		lblMensagem.setForeground(Color.BLUE);
		
		String aux = "Nenhum";
		
		HospedagemController cc = new HospedagemController();
		listaHospedagem = cc.listarTodos();
		cbxCodHospedagem = new JComboBox();
		
		cbxCodHospedagem.addItem(aux);
		for(Hospedagem c : listaHospedagem){
			cbxCodHospedagem.addItem(c.getCodHospedagem());
		}
		
		ServicoController ic = new ServicoController();
		listaServico = ic.listarTodos();
		cbxCodServico = new JComboBox();
		
		cbxCodServico.addItem(aux);
		for(Servico i : listaServico){
			cbxCodServico.addItem(i.getCodServico());
		}
		
		JLabel lblDataServio = new JLabel("Data Serviço");
		
		JLabel lblValorServio = new JLabel("Valor Serviço");
		
		txtValorServico = new JTextField();
		txtValorServico.setColumns(10);
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtDataServico = new JFormattedTextField(mascaraData);
		
		JLabel lblDdmmaa = new JLabel("dd/mm/aa");
		lblDdmmaa.setForeground(Color.RED);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodHospedagem)
								.addComponent(lblCodServico))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxCodServico, 0, 186, Short.MAX_VALUE)
								.addComponent(cbxCodHospedagem, 0, 186, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataServio)
								.addComponent(lblValorServio))
							.addGap(66)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtValorServico, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
								.addComponent(txtDataServico, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDdmmaa)
					.addGap(204))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodHospedagem)
						.addComponent(cbxCodHospedagem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodServico)
						.addComponent(cbxCodServico, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataServio)
						.addComponent(lblDdmmaa)
						.addComponent(txtDataServico, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorServio)
						.addComponent(txtValorServico, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblMensagem)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HospedagemServico hs = new HospedagemServico();
				HospedagemServicoController hsc = new HospedagemServicoController();
				hs.setCodHospedagem(Integer.parseInt(cbxCodHospedagem.getSelectedItem().toString()));
				hs.setCodServico(Integer.parseInt(cbxCodServico.getSelectedItem().toString()));
				hs.setDataServico(Util.formatarDataDeGuiParaLocalDate(txtDataServico.getText()));
				hs.setValorServico(Double.parseDouble(txtValorServico.getText()));
				lblMensagem.setText(hsc.inserir(hs));
				buscar();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				HospedagemServico hs = new HospedagemServico();
				HospedagemServicoController hsc = new HospedagemServicoController();
				hs.setCodHospedagem(Integer.parseInt(cbxCodHospedagem.getSelectedItem().toString()));
				hs.setCodServico(Integer.parseInt(cbxCodServico.getSelectedItem().toString()));
				Object[] opcoes = { "Sim", "Nao" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse Servico da Hospedagem?",
						"Exclusao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(hsc.excluir(hs));
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
				cbxCodHospedagem.setSelectedItem(aux);
				cbxCodServico.setSelectedItem(aux);
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
				FrmHospedagemServico.this.dispose();
			}
		});
		
		HospedagemServicoController hsc = new HospedagemServicoController();
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cbxCodHospedagem.getSelectedItem().toString().equals(aux)){
					buscarServico(hsc.pesquisarPorCodHospedagem(Integer.parseInt(cbxCodServico.getSelectedItem().toString())));
				} else if(cbxCodServico.getSelectedItem().toString().equals(aux)){
					buscarHospedagem(hsc.pesquisarPorCodServico(Integer.parseInt(cbxCodHospedagem.getSelectedItem().toString())));
				} 
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HospedagemServico hs = new HospedagemServico();
				HospedagemServicoController hsc = new HospedagemServicoController();
				hs.setCodHospedagem(Integer.parseInt(cbxCodHospedagem.getSelectedItem().toString()));
				hs.setCodServico(Integer.parseInt(cbxCodServico.getSelectedItem().toString()));
				hs.setDataServico(Util.formatarDataDeGuiParaLocalDate(txtDataServico.getText()));
				hs.setValorServico(Double.parseDouble(txtValorServico.getText()));
				lblMensagem.setText(hsc.alterar(hs));
				buscar();
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
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
						.addComponent(btnPesquisar)
						.addComponent(btnVisualizar)
						.addComponent(btnExcluir)
						.addComponent(btnAlterar))
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
				cbxCodHospedagem.setSelectedItem(tblConsulta.getValueAt(linha, 0));
				cbxCodServico.setSelectedItem(tblConsulta.getValueAt(linha, 1));
				txtDataServico.setText(tblConsulta.getValueAt(linha, 2).toString());
				txtDataServico.setText(tblConsulta.getValueAt(linha, 2).toString());
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Hospedagem", "C\u00F3digo Servi\u00E7o", "Data Servi\u00E7o", "Valor Servi\u00E7o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(193);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(152);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(123);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(156);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
