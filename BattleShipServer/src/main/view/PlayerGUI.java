package main.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JMenuItem;
import java.awt.Font;

public class PlayerGUI {

	private JFrame frmWarOfShips;
	private JMenuBar menuBar;
	private JMenu mnGame;
	private JMenu mnHelp;
	private JPanel panelEast;
	private JPanel panelCentar;
	private JPanel panelSouth;
	private JLabel lblName;
	private JTextField textField;
	private static JButton btn11;
	private static JButton btn12;
	private static JButton btn13;
	private JButton btn14;
	private JButton btn15;
	private JButton btn16;
	private JButton btn17;
	private JButton btn18;
	private JButton btn21;
	private JButton btn22;
	private JButton btn23;
	private JButton btn31;
	private JButton btn41;
	private JButton btn32;
	private JButton btn42;
	private JButton btn24;
	private JButton btn75;
	private JButton btn87;
	private JButton btn78;
	private JButton btn66;
	private JButton btn64;
	private JButton btn81;
	private JButton btn71;
	private JButton btn51;
	private JButton btn61;
	private JButton btn28;
	private JButton btn27;
	private JButton btn26;
	private JButton btn25;
	private JButton btn33;
	private JButton btn52;
	private JButton btn62;
	private JButton btn72;
	private JButton btn82;
	private JButton btn83;
	private JButton btn84;
	private JButton btn85;
	private JButton btn86;
	private JButton btn88;
	private JButton btn38;
	private JButton btn37;
	private JButton btn36;
	private JButton btn35;
	private JButton btn34;
	private JButton btn43;
	private JButton btn53;
	private JButton btn63;
	private JButton btn73;
	private JButton btn74;
	private JButton btn76;
	private JButton btn77;
	private JButton btn68;
	private JButton btn58;
	private JButton btn48;
	private JButton btn47;
	private JButton btn46;
	private JButton btn45;
	private JButton btn44;
	private JButton btn54;
	private JButton btn55;
	private JButton btn65;
	private JButton btn56;
	private JButton btn57;
	private JButton btn67;
	private JLabel lblIzborBrodova;
	@SuppressWarnings("rawtypes")
	private JComboBox cbShipSize;
	private JLabel lblOrientation;
	private JRadioButton rdbtnV;
	private JRadioButton rdbtnH;
	private JButton btnNextShip;

	private static JButton[] matrica = new JButton[100];
	private JMenu mnAbout;
	private JMenuItem mntmNewGame;
	private JMenuItem mntmExit;
	private JMenuItem mntmHowtoplay;
	private JMenuItem mntmHistoryofbattleships;
	private JMenuItem mntmAboutDevelopers;
	private JButton btnNewButton;
	
	public void populateTheArray(){
		Field[] fields = JButton.class.getDeclaredFields();
		int i=0;
		
		for(Field field: fields){
			if (field.getType().equals(JButton.class)) {
                try {
                    matrica[i] = (JButton) field.get(this);
                    i++;
                } catch (IllegalArgumentException | IllegalAccessException
                        | SecurityException e) {
                    e.printStackTrace();
                }
            }
		}
	}
	
	int elementsInArray(){
		int counter =0;
		for (int i = 0; i < matrica.length; i++) {
			if(matrica[i] != null){
				counter++;
			}
		}
		return counter;
	}
	
	public void selectionOfPlaces(String row,String column,String size,String orientation){
		if(orientation.equals("H")){
			for (int i = 0; i < Integer.parseInt(size); i++) {
				btn11.setEnabled(false);
			}
			
		}
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerGUI window = new PlayerGUI();
					window.frmWarOfShips.setVisible(true);
					window.populateTheArray();
					
					System.out.println(window.elementsInArray());
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWarOfShips = new JFrame();
		frmWarOfShips.setFont(new Font("Monospaced", Font.BOLD, 16));
		frmWarOfShips.setTitle("War of Ships");
		frmWarOfShips.setBounds(100, 100, 466, 369);
		frmWarOfShips.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWarOfShips.setJMenuBar(getMenuBar());
		frmWarOfShips.getContentPane().setLayout(new BorderLayout(0, 0));
		frmWarOfShips.getContentPane().add(getPanelEast(), BorderLayout.EAST);
		frmWarOfShips.getContentPane().add(getPanelCentar(), BorderLayout.CENTER);
		frmWarOfShips.getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
	}
	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnGame());
			menuBar.add(getMnHelp());
			menuBar.add(getMnAbout());
		}
		return menuBar;
	}
	private JMenu getMnGame() {
		if (mnGame == null) {
			mnGame = new JMenu("Game");
			mnGame.setFont(new Font("Monospaced", Font.BOLD, 12));
			mnGame.add(getMntmNewGame());
			mnGame.add(getMntmExit());
		}
		return mnGame;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setFont(new Font("Monospaced", Font.BOLD, 12));
			mnHelp.add(getMntmHowtoplay());
		}
		return mnHelp;
	}
	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setPreferredSize(new Dimension(140, 10));
			panelEast.setLayout(new MigLayout("", "[50px]", "[14px][20px][14px][20px][14px][23px][25px][grow][37px]"));
			panelEast.add(getLblName(), "cell 0 0,alignx center,growy");
			panelEast.add(getTextField(), "cell 0 1,alignx center,growy");
			panelEast.add(getLblIzborBrodova(), "cell 0 2,alignx center,growy");
			panelEast.add(getCbShipSize(), "cell 0 3");
			panelEast.add(getLblOrientation(), "cell 0 4,alignx center,growy");
			panelEast.add(getRdbtnV(), "flowx,cell 0 5,alignx center,growy");
			panelEast.add(getButton_6_1(), "cell 0 6,alignx center,growy");
			panelEast.add(getBtnNewButton(), "cell 0 8,alignx center,growy");
			panelEast.add(getRdbtnH(), "cell 0 5,alignx center,growy");
		}
		return panelEast;
	}
	private JPanel getPanelCentar() {
		if (panelCentar == null) {
			panelCentar = new JPanel();
			panelCentar.setPreferredSize(new Dimension(260, 260));
			panelCentar.setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][][][][]"));
			panelCentar.add(getBtn11(), "cell 0 0");
			panelCentar.add(getBtn12(), "cell 1 0");
			panelCentar.add(getBtn13(), "cell 2 0");
			panelCentar.add(getBtn14(), "cell 3 0");
			panelCentar.add(getBtn15(), "cell 4 0");
			panelCentar.add(getBtn16(), "cell 5 0");
			panelCentar.add(getBtn17(), "cell 6 0");
			panelCentar.add(getBtn18(), "cell 7 0");
			panelCentar.add(getBtn21(), "cell 0 1");
			panelCentar.add(getBtn22(), "cell 1 1");
			panelCentar.add(getBtn23(), "cell 2 1");
			panelCentar.add(getBtn24(), "cell 3 1");
			panelCentar.add(getBtn25(), "cell 4 1");
			panelCentar.add(getBtn26(), "cell 5 1");
			panelCentar.add(getBtn27(), "cell 6 1");
			panelCentar.add(getBtn28(), "cell 7 1");
			panelCentar.add(getBtn31(), "cell 0 2");
			panelCentar.add(getBtn32(), "cell 1 2");
			panelCentar.add(getBtn33(), "cell 2 2");
			panelCentar.add(getBtn34(), "cell 3 2");
			panelCentar.add(getBtn35(), "cell 4 2");
			panelCentar.add(getBtn36(), "cell 5 2");
			panelCentar.add(getBtn37(), "cell 6 2");
			panelCentar.add(getBtn38(), "cell 7 2");
			panelCentar.add(getBtn41(), "cell 0 3");
			panelCentar.add(getBtn42(), "cell 1 3");
			panelCentar.add(getBtn43(), "cell 2 3");
			panelCentar.add(getBtn44(), "cell 3 3");
			panelCentar.add(getBtn45(), "cell 4 3");
			panelCentar.add(getBtn46(), "cell 5 3");
			panelCentar.add(getBtn47(), "cell 6 3");
			panelCentar.add(getBtn48(), "cell 7 3");
			panelCentar.add(getBtn51(), "cell 0 4");
			panelCentar.add(getBtn52(), "cell 1 4");
			panelCentar.add(getBtn53(), "cell 2 4");
			panelCentar.add(getBtn54(), "cell 3 4");
			panelCentar.add(getBtn55(), "cell 4 4");
			panelCentar.add(getBtn56(), "cell 5 4");
			panelCentar.add(getBtn57(), "cell 6 4");
			panelCentar.add(getBtn58(), "cell 7 4");
			panelCentar.add(getBtn61(), "cell 0 5");
			panelCentar.add(getBtn62(), "cell 1 5");
			panelCentar.add(getBtn63(), "cell 2 5");
			panelCentar.add(getBtn64(), "cell 3 5");
			panelCentar.add(getBtn65(), "cell 4 5");
			panelCentar.add(getBtn66(), "cell 5 5");
			panelCentar.add(getBtn67(), "cell 6 5");
			panelCentar.add(getBtn68(), "cell 7 5");
			panelCentar.add(getBtn71(), "cell 0 6");
			panelCentar.add(getBtn72(), "cell 1 6");
			panelCentar.add(getBtn73(), "cell 2 6");
			panelCentar.add(getBtn74(), "cell 3 6");
			panelCentar.add(getBtn75(), "cell 4 6");
			panelCentar.add(getBtn76(), "cell 5 6");
			panelCentar.add(getBtn77(), "cell 6 6");
			panelCentar.add(getBtn78(), "cell 7 6");
			panelCentar.add(getBtn81(), "cell 0 7");
			panelCentar.add(getBtn82(), "cell 1 7");
			panelCentar.add(getBtn83(), "cell 2 7");
			panelCentar.add(getBtn84(), "cell 3 7");
			panelCentar.add(getBtn85(), "cell 4 7");
			panelCentar.add(getBtn86(), "cell 5 7");
			panelCentar.add(getBtn87(), "cell 6 7");
			panelCentar.add(getBtn88(), "cell 7 7");
		}
		return panelCentar;
	}
	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
		}
		return panelSouth;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Admiral:");
			lblName.setFont(new Font("Monospaced", Font.BOLD, 12));
		}
		return lblName;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtn11() {
		if (btn11 == null) {
			btn11 = new JButton("");
			btn11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btn11.setMinimumSize(new Dimension(10, 10));
			btn11.setPreferredSize(new Dimension(33, 33));
			btn11.setName("btn11");
		}
		return btn11;
	}
	private JButton getBtn12() {
		if (btn12 == null) {
			btn12 = new JButton("");
			btn12.setMinimumSize(new Dimension(10, 10));
			btn12.setPreferredSize(new Dimension(33, 33));
			btn12.setName("btn12");
		}
		return btn12;
	}
	private JButton getBtn13() {
		if (btn13 == null) {
			btn13 = new JButton("");
			btn13.setMinimumSize(new Dimension(10, 10));
			btn13.setPreferredSize(new Dimension(33, 33));
			btn13.setName("btn13");
		}
		return btn13;
	}
	private JButton getBtn14() {
		if (btn14 == null) {
			btn14 = new JButton("");
			btn14.setMinimumSize(new Dimension(10, 10));
			btn14.setPreferredSize(new Dimension(33, 33));
			btn14.setName("btn14");
		}
		return btn14;
	}
	private JButton getBtn15() {
		if (btn15 == null) {
			btn15 = new JButton("");
			btn15.setMinimumSize(new Dimension(10, 10));
			btn15.setPreferredSize(new Dimension(33, 33));
			btn15.setName("btn15");
		}
		return btn15;
	}
	private JButton getBtn16() {
		if (btn16 == null) {
			btn16 = new JButton("");
			btn16.setMinimumSize(new Dimension(10, 10));
			btn16.setPreferredSize(new Dimension(33, 33));
			btn16.setName("btn16");
		}
		return btn16;
	}
	private JButton getBtn17() {
		if (btn17 == null) {
			btn17 = new JButton("");
			btn17.setMinimumSize(new Dimension(10, 10));
			btn17.setPreferredSize(new Dimension(33, 33));
			btn17.setName("btn17");
		}
		return btn17;
	}
	private JButton getBtn18() {
		if (btn18 == null) {
			btn18 = new JButton("");
			btn18.setMinimumSize(new Dimension(1, 10));
			btn18.setPreferredSize(new Dimension(33, 33));
			btn18.setName("btn18");
		}
		return btn18;
	}
	private JButton getBtn21() {
		if (btn21 == null) {
			btn21 = new JButton("");
			btn21.setPreferredSize(new Dimension(33, 33));
			btn21.setName("btn21");
		}
		return btn21;
	}
	private JButton getBtn22() {
		if (btn22 == null) {
			btn22 = new JButton("");
			btn22.setPreferredSize(new Dimension(33, 33));
			btn22.setName("btn22");
		}
		return btn22;
	}
	private JButton getBtn23() {
		if (btn23 == null) {
			btn23 = new JButton("");
			btn23.setPreferredSize(new Dimension(33, 33));
			btn23.setName("btn23");
		}
		return btn23;
	}
	private JButton getBtn31() {
		if (btn31 == null) {
			btn31 = new JButton("");
			btn31.setPreferredSize(new Dimension(33, 33));
			btn31.setName("btn31");
		}
		return btn31;
	}
	private JButton getBtn41() {
		if (btn41 == null) {
			btn41 = new JButton("");
			btn41.setPreferredSize(new Dimension(33, 33));
			btn41.setName("btn41");
		}
		return btn41;
	}
	private JButton getBtn32() {
		if (btn32 == null) {
			btn32 = new JButton("");
			btn32.setPreferredSize(new Dimension(33, 33));
			btn32.setName("btn32");
		}
		return btn32;
	}
	private JButton getBtn42() {
		if (btn42 == null) {
			btn42 = new JButton("");
			btn42.setPreferredSize(new Dimension(33, 33));
			btn42.setName("btn42");
		}
		return btn42;
	}
	private JButton getBtn24() {
		if (btn24 == null) {
			btn24 = new JButton("");
			btn24.setPreferredSize(new Dimension(33, 33));
			btn24.setName("btn24");
		}
		return btn24;
	}
	private JButton getBtn75() {
		if (btn75 == null) {
			btn75 = new JButton("");
			btn75.setPreferredSize(new Dimension(33, 33));
			btn75.setName("btn75");
		}
		return btn75;
	}
	private JButton getBtn87() {
		if (btn87 == null) {
			btn87 = new JButton("");
			btn87.setPreferredSize(new Dimension(33, 33));
			btn87.setName("btn87");
		}
		return btn87;
	}
	private JButton getBtn78() {
		if (btn78 == null) {
			btn78 = new JButton("");
			btn78.setPreferredSize(new Dimension(33, 33));
			btn78.setName("btn78");
		}
		return btn78;
	}
	private JButton getBtn66() {
		if (btn66 == null) {
			btn66 = new JButton("");
			btn66.setPreferredSize(new Dimension(33, 33));
			btn66.setName("btn66");
		}
		return btn66;
	}
	private JButton getBtn64() {
		if (btn64 == null) {
			btn64 = new JButton("");
			btn64.setPreferredSize(new Dimension(33, 33));
			btn64.setName("btn64");
		}
		return btn64;
	}
	private JButton getBtn81() {
		if (btn81 == null) {
			btn81 = new JButton("");
			btn81.setPreferredSize(new Dimension(33, 33));
			btn81.setName("btn81");
		}
		return btn81;
	}
	private JButton getBtn71() {
		if (btn71 == null) {
			btn71 = new JButton("");
			btn71.setPreferredSize(new Dimension(33, 33));
			btn71.setName("btn71");
		}
		return btn71;
	}
	private JButton getBtn51() {
		if (btn51 == null) {
			btn51 = new JButton("");
			btn51.setPreferredSize(new Dimension(33, 33));
			btn51.setName("btn51");
		}
		return btn51;
	}
	private JButton getBtn61() {
		if (btn61 == null) {
			btn61 = new JButton("");
			btn61.setPreferredSize(new Dimension(33, 33));
			btn61.setName("btn61");
		}
		return btn61;
	}
	private JButton getBtn28() {
		if (btn28 == null) {
			btn28 = new JButton("");
			btn28.setPreferredSize(new Dimension(33, 33));
			btn28.setName("btn28");
		}
		return btn28;
	}
	private JButton getBtn27() {
		if (btn27 == null) {
			btn27 = new JButton("");
			btn27.setPreferredSize(new Dimension(33, 33));
			btn27.setName("btn27");
		}
		return btn27;
	}
	private JButton getBtn26() {
		if (btn26 == null) {
			btn26 = new JButton("");
			btn26.setPreferredSize(new Dimension(33, 33));
			btn26.setName("btn26");
		}
		return btn26;
	}
	private JButton getBtn25() {
		if (btn25 == null) {
			btn25 = new JButton("");
			btn25.setPreferredSize(new Dimension(33, 33));
			btn25.setName("btn25");
		}
		return btn25;
	}
	private JButton getBtn33() {
		if (btn33 == null) {
			btn33 = new JButton("");
			btn33.setPreferredSize(new Dimension(33, 33));
			btn33.setName("btn33");
		}
		return btn33;
	}
	private JButton getBtn52() {
		if (btn52 == null) {
			btn52 = new JButton("");
			btn52.setPreferredSize(new Dimension(33, 33));
			btn52.setName("btn52");
		}
		return btn52;
	}
	private JButton getBtn62() {
		if (btn62 == null) {
			btn62 = new JButton("");
			btn62.setPreferredSize(new Dimension(33, 33));
			btn62.setName("btn62");
		}
		return btn62;
	}
	private JButton getBtn72() {
		if (btn72 == null) {
			btn72 = new JButton("");
			btn72.setPreferredSize(new Dimension(33, 33));
			btn72.setName("btn72");
		}
		return btn72;
	}
	private JButton getBtn82() {
		if (btn82 == null) {
			btn82 = new JButton("");
			btn82.setPreferredSize(new Dimension(33, 33));
			btn82.setName("btn82");
		}
		return btn82;
	}
	private JButton getBtn83() {
		if (btn83 == null) {
			btn83 = new JButton("");
			btn83.setPreferredSize(new Dimension(33, 33));
			btn83.setName("btn83");
		}
		return btn83;
	}
	private JButton getBtn84() {
		if (btn84 == null) {
			btn84 = new JButton("");
			btn84.setPreferredSize(new Dimension(33, 33));
			btn84.setName("btn84");
		}
		return btn84;
	}
	private JButton getBtn85() {
		if (btn85 == null) {
			btn85 = new JButton("");
			btn85.setPreferredSize(new Dimension(33, 33));
			btn85.setName("btn85");
		}
		return btn85;
	}
	private JButton getBtn86() {
		if (btn86 == null) {
			btn86 = new JButton("");
			btn86.setPreferredSize(new Dimension(33, 33));
		}
		return btn86;
	}
	private JButton getBtn88() {
		if (btn88 == null) {
			btn88 = new JButton("");
			btn88.setPreferredSize(new Dimension(33, 33));
			btn88.setName("btn88");
		}
		return btn88;
	}
	private JButton getBtn38() {
		if (btn38 == null) {
			btn38 = new JButton("");
			btn38.setPreferredSize(new Dimension(33, 33));
			btn38.setName("btn38");
		}
		return btn38;
	}
	private JButton getBtn37() {
		if (btn37 == null) {
			btn37 = new JButton("");
			btn37.setPreferredSize(new Dimension(33, 33));
			btn37.setName("btn37");
		}
		return btn37;
	}
	private JButton getBtn36() {
		if (btn36 == null) {
			btn36 = new JButton("");
			btn36.setPreferredSize(new Dimension(33, 33));
			btn36.setName("btn36");
		}
		return btn36;
	}
	private JButton getBtn35() {
		if (btn35 == null) {
			btn35 = new JButton("");
			btn35.setPreferredSize(new Dimension(33, 33));
			btn35.setName("btn35");
		}
		return btn35;
	}
	private JButton getBtn34() {
		if (btn34 == null) {
			btn34 = new JButton("");
			btn34.setPreferredSize(new Dimension(33, 33));
			btn34.setName("btn34");
		}
		return btn34;
	}
	private JButton getBtn43() {
		if (btn43 == null) {
			btn43 = new JButton("");
			btn43.setPreferredSize(new Dimension(33, 33));
			btn43.setName("btn43");
		}
		return btn43;
	}
	private JButton getBtn53() {
		if (btn53 == null) {
			btn53 = new JButton("");
			btn53.setPreferredSize(new Dimension(33, 33));
			btn53.setName("btn53");
		}
		return btn53;
	}
	private JButton getBtn63() {
		if (btn63 == null) {
			btn63 = new JButton("");
			btn63.setPreferredSize(new Dimension(33, 33));
			btn63.setName("btn63");
		}
		return btn63;
	}
	private JButton getBtn73() {
		if (btn73 == null) {
			btn73 = new JButton("");
			btn73.setPreferredSize(new Dimension(33, 33));
			btn73.setName("btn73");
		}
		return btn73;
	}
	private JButton getBtn74() {
		if (btn74 == null) {
			btn74 = new JButton("");
			btn74.setPreferredSize(new Dimension(33, 33));
			btn74.setName("btn74");
		}
		return btn74;
	}
	private JButton getBtn76() {
		if (btn76 == null) {
			btn76 = new JButton("");
			btn76.setPreferredSize(new Dimension(33, 33));
			btn76.setName("btn76");
		}
		return btn76;
	}
	private JButton getBtn77() {
		if (btn77 == null) {
			btn77 = new JButton("");
			btn77.setPreferredSize(new Dimension(33, 33));
			btn77.setName("btn77");
		}
		return btn77;
	}
	private JButton getBtn68() {
		if (btn68 == null) {
			btn68 = new JButton("");
			btn68.setPreferredSize(new Dimension(33, 33));
			btn68.setName("btn68");
		}
		return btn68;
	}
	private JButton getBtn58() {
		if (btn58 == null) {
			btn58 = new JButton("");
			btn58.setPreferredSize(new Dimension(33, 33));
			btn58.setName("btn58");
		}
		return btn58;
	}
	private JButton getBtn48() {
		if (btn48 == null) {
			btn48 = new JButton("");
			btn48.setPreferredSize(new Dimension(33, 33));
			btn48.setName("btn48");
		}
		return btn48;
	}
	private JButton getBtn47() {
		if (btn47 == null) {
			btn47 = new JButton("");
			btn47.setPreferredSize(new Dimension(33, 33));
			btn47.setName("btn47");
		}
		return btn47;
	}
	private JButton getBtn46() {
		if (btn46 == null) {
			btn46 = new JButton("");
			btn46.setPreferredSize(new Dimension(33, 33));
			btn46.setName("btn46");
		}
		return btn46;
	}
	private JButton getBtn45() {
		if (btn45 == null) {
			btn45 = new JButton("");
			btn45.setPreferredSize(new Dimension(33, 33));
			btn45.setName("btn45");
		}
		return btn45;
	}
	private JButton getBtn44() {
		if (btn44 == null) {
			btn44 = new JButton("");
			btn44.setPreferredSize(new Dimension(33, 33));
			btn44.setName("btn44");
		}
		return btn44;
	}
	private JButton getBtn54() {
		if (btn54 == null) {
			btn54 = new JButton("");
			btn54.setPreferredSize(new Dimension(33, 33));
			btn54.setName("btn54");
		}
		return btn54;
	}
	private JButton getBtn55() {
		if (btn55 == null) {
			btn55 = new JButton("");
			btn55.setPreferredSize(new Dimension(33, 33));
			btn55.setName("btn55");
		}
		return btn55;
	}
	private JButton getBtn65() {
		if (btn65 == null) {
			btn65 = new JButton("");
			btn65.setPreferredSize(new Dimension(33, 33));
			btn65.setName("btn65");
		}
		return btn65;
	}
	private JButton getBtn56() {
		if (btn56 == null) {
			btn56 = new JButton("");
			btn56.setPreferredSize(new Dimension(33, 33));
			btn56.setName("btn56");
		}
		return btn56;
	}
	private JButton getBtn57() {
		if (btn57 == null) {
			btn57 = new JButton("");
			btn57.setPreferredSize(new Dimension(33, 33));
			btn57.setName("btn57");
		}
		return btn57;
	}
	private JButton getBtn67() {
		if (btn67 == null) {
			btn67 = new JButton("");
			btn67.setPreferredSize(new Dimension(33, 33));
			btn67.setName("btn67");
		}
		return btn67;
	}
	private JLabel getLblIzborBrodova() {
		if (lblIzborBrodova == null) {
			lblIzborBrodova = new JLabel("Ship(size):");
			lblIzborBrodova.setFont(new Font("Monospaced", Font.BOLD, 12));
		}
		return lblIzborBrodova;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getCbShipSize() {
		if (cbShipSize == null) {
			cbShipSize = new JComboBox();
			cbShipSize.setFont(new Font("Monospaced", Font.BOLD, 12));
			cbShipSize.addItem("Patrol(2)");
			cbShipSize.addItem("Patrol(2)");
			cbShipSize.addItem("Patrol(2)");
			cbShipSize.addItem("Patrol(2)");
			cbShipSize.addItem("Frigate(3)");
			cbShipSize.addItem("Frigate(3)");
			cbShipSize.addItem("Destroyer(4)");
			cbShipSize.addItem("Battleship(5)");
		}
		return cbShipSize;
	}
	private JLabel getLblOrientation() {
		if (lblOrientation == null) {
			lblOrientation = new JLabel("Ship orientation:");
			lblOrientation.setFont(new Font("Monospaced", Font.BOLD, 12));
		}
		return lblOrientation;
	}
	private JRadioButton getRdbtnV() {
		if (rdbtnV == null) {
			rdbtnV = new JRadioButton("V");
			rdbtnV.setFont(new Font("Monospaced", Font.BOLD, 12));
		}
		return rdbtnV;
	}
	private JRadioButton getRdbtnH() {
		if (rdbtnH == null) {
			rdbtnH = new JRadioButton("H");
			rdbtnH.setFont(new Font("Monospaced", Font.BOLD, 12));
		}
		return rdbtnH;
	}
	private JButton getButton_6_1() {
		if (btnNextShip == null) {
			btnNextShip = new JButton("Next Ship");
			btnNextShip.setFont(new Font("Monospaced", Font.BOLD, 12));
		}
		return btnNextShip;
	}
	private JMenu getMnAbout() {
		if (mnAbout == null) {
			mnAbout = new JMenu("About");
			mnAbout.setFont(new Font("Monospaced", Font.BOLD, 12));
			mnAbout.add(getMntmHistoryofbattleships());
			mnAbout.add(getMntmAboutDevelopers());
		}
		return mnAbout;
	}
	private JMenuItem getMntmNewGame() {
		if (mntmNewGame == null) {
			mntmNewGame = new JMenuItem("New Game");
			mntmNewGame.setFont(new Font("Monospaced", Font.PLAIN, 12));
		}
		return mntmNewGame;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setFont(new Font("Monospaced", Font.PLAIN, 12));
		}
		return mntmExit;
	}
	private JMenuItem getMntmHowtoplay() {
		if (mntmHowtoplay == null) {
			mntmHowtoplay = new JMenuItem("How To Play");
			mntmHowtoplay.setFont(new Font("Monospaced", Font.PLAIN, 12));
		}
		return mntmHowtoplay;
	}
	private JMenuItem getMntmHistoryofbattleships() {
		if (mntmHistoryofbattleships == null) {
			mntmHistoryofbattleships = new JMenuItem("History of Battleships");
			mntmHistoryofbattleships.setFont(new Font("Monospaced", Font.PLAIN, 12));
		}
		return mntmHistoryofbattleships;
	}
	private JMenuItem getMntmAboutDevelopers() {
		if (mntmAboutDevelopers == null) {
			mntmAboutDevelopers = new JMenuItem("About Developers");
			mntmAboutDevelopers.setFont(new Font("Monospaced", Font.PLAIN, 12));
		}
		return mntmAboutDevelopers;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("READY");
			btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 17));
			btnNewButton.setMaximumSize(new Dimension(85, 50));
			btnNewButton.setPreferredSize(new Dimension(85, 50));
			btnNewButton.setMinimumSize(new Dimension(85, 50));
		}
		return btnNewButton;
	}
}
