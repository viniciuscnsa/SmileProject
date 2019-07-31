package gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import main.SmileProject;

@SuppressWarnings("serial")
public class mainScreen extends JPanel {


	protected JFrame frmSmileGame = new JFrame();

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public mainScreen(String path1,String path2,String path3) throws IOException {
		setBorder(new TitledBorder(null, "SmileGame", TitledBorder.LEFT, TitledBorder.TOP, null, null));

		main.SmileProject game = new main.SmileProject();

		
		frmSmileGame.setResizable(false);
		frmSmileGame.setTitle("Smile Game");
		frmSmileGame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmSmileGame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(0, 130));
		frmSmileGame.getContentPane().add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("21px"),
				ColumnSpec.decode("159px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("245px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("65px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("191px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("130px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("92px"),},
				new RowSpec[] {
						FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("23px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lblCliqueNoRosto = new JLabel("Clique no rosto que est\u00E1 sorrindo");
		northPanel.add(lblCliqueNoRosto, "2, 2, 3, 1, left, center");

		JLabel lblCasoNoExistam = new JLabel("Caso n\u00E3o existam sorrisos, clique no bot\u00E3o 'Reload'");
		northPanel.add(lblCasoNoExistam, "2, 4, 3, 1, left, center");

		JLabel lblCasoExistaMais = new JLabel("Se existir mais de um sorriso escolha um");
		northPanel.add(lblCasoExistaMais, "2, 6, 3, 1, left, center");

		JLabel lblPontos = new JLabel("Acertos: " + String.valueOf(game.right));
		northPanel.add(lblPontos, "2, 10, left, center");

		JLabel lblErros = new JLabel("Erros: " + String.valueOf(game.wrong));
		northPanel.add(lblErros, "4, 10, left, center");


		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(950, 450));
		centerPanel.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(300, 500));
		BufferedImage image = ImageIO.read(new File(SmileProject.path1));
		JLabel label = new JLabel(new ImageIcon(image));
		panel_1.add(label);
		centerPanel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(300, 500));
		BufferedImage image2 = ImageIO.read(new File(SmileProject.path2));
		JLabel label2 = new JLabel(new ImageIcon(image2));
		panel_2.add(label2);
		centerPanel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(300, 500));
		BufferedImage image3 = ImageIO.read(new File(SmileProject.path3));
		JLabel label3 = new JLabel(new ImageIcon(image3));
		panel_3.add(label3);
		centerPanel.add(panel_3);

		//events
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.awnser(SmileProject.path1);
				lblPontos.setText("Acertos: " + String.valueOf(game.right));
				lblErros.setText("Erros: " + String.valueOf(game.wrong));
				SmileProject.randomImages();
				BufferedImage img1;
				BufferedImage img2;
				BufferedImage img3;
				try {
					img1 = ImageIO.read(new File(SmileProject.path1));
					img2 = ImageIO.read(new File(SmileProject.path2));
					img3 = ImageIO.read(new File(SmileProject.path3));
					label.setIcon(new ImageIcon(img1));
					label2.setIcon(new ImageIcon(img2));
					label3.setIcon(new ImageIcon(img3));
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.awnser(SmileProject.path2);
				lblPontos.setText("Acertos: " + String.valueOf(game.right));
				lblErros.setText("Erros: " + String.valueOf(game.wrong));
				SmileProject.randomImages();
				BufferedImage img1;
				BufferedImage img2;
				BufferedImage img3;
				try {
					img1 = ImageIO.read(new File(SmileProject.path1));
					img2 = ImageIO.read(new File(SmileProject.path2));
					img3 = ImageIO.read(new File(SmileProject.path3));
					label.setIcon(new ImageIcon(img1));
					label2.setIcon(new ImageIcon(img2));
					label3.setIcon(new ImageIcon(img3));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.awnser(SmileProject.path3);
				lblPontos.setText("Acertos: " + String.valueOf(game.right));
				lblErros.setText("Erros: " + String.valueOf(game.wrong));
				SmileProject.randomImages();
				BufferedImage img1;
				BufferedImage img2;
				BufferedImage img3;
				try {
					img1 = ImageIO.read(new File(SmileProject.path1));
					img2 = ImageIO.read(new File(SmileProject.path2));
					img3 = ImageIO.read(new File(SmileProject.path3));
					label.setIcon(new ImageIcon(img1));
					label2.setIcon(new ImageIcon(img2));
					label3.setIcon(new ImageIcon(img3));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnReload = new JButton("Reload");
		btnReload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SmileProject.randomImages();
				BufferedImage img1;
				BufferedImage img2;
				BufferedImage img3;
				try {
					img1 = ImageIO.read(new File(SmileProject.path1));
					img2 = ImageIO.read(new File(SmileProject.path2));
					img3 = ImageIO.read(new File(SmileProject.path3));
					label.setIcon(new ImageIcon(img1));
					label2.setIcon(new ImageIcon(img2));
					label3.setIcon(new ImageIcon(img3));
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		northPanel.add(btnReload, "12, 4, default, top");


		frmSmileGame.getContentPane().add(centerPanel);


		frmSmileGame.pack();
		frmSmileGame.setVisible(true);
		//frmSmileGame.setLocationRelativeTo(null);
	}
	
	@SuppressWarnings("deprecation")
	public void play() {
		frmSmileGame.show();
	}


}
