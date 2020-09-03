package br.com.prog2.trabalhofinal.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 404);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCliente fcl = new FrmCliente();
				fcl.setVisible(true);
				}
		});
		mnCadastro.add(mntmCliente);
		
		JMenuItem mntmChal = new JMenuItem("Chalé");
		mntmChal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmChale fc = new FrmChale();
				fc.setVisible(true);
			}
		});
		mnCadastro.add(mntmChal);
		
		JMenuItem mntmHospedagem = new JMenuItem("Hospedagem");
		mntmHospedagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmHospedagem fh = new FrmHospedagem();
				fh.setVisible(true);
			}
		});
		mnCadastro.add(mntmHospedagem);
		
		JMenuItem mntmTelefone = new JMenuItem("Telefone");
		mntmTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTelefone ft = new FrmTelefone();
				ft.setVisible(true);
			}
		});
		mnCadastro.add(mntmTelefone);
		
		JMenuItem mntmServio = new JMenuItem("Serviço");
		mntmServio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmServico fs = new FrmServico();
				fs.setVisible(true);
			}
		});
		mnCadastro.add(mntmServio);
		
		JMenuItem mntmItem = new JMenuItem("Item");
		mntmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmItem fi = new FrmItem();
				fi.setVisible(true);
			}
		});
		
		mnCadastro.add(mntmItem);
		
		JMenuItem mntmChalitem = new JMenuItem("Item do Chalé");
		mntmChalitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmChaleItem fci = new FrmChaleItem();
				fci.setVisible(true);
			}
		});
		
		mnCadastro.add(mntmChalitem);
		
		JMenuItem mntmHospedagemservio = new JMenuItem("HospedagemServiço");
		mntmHospedagemservio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmHospedagemServico fhs = new FrmHospedagemServico();
				fhs.setVisible(true);
			}
		});
		mnCadastro.add(mntmHospedagemservio);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnCadastro.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 438, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 261, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
