package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelBet extends JPanel implements ActionListener {
	InterfazClient interfazClient;
	public final static String BET = "BET";
	public final static String CANCEL = "CANCEL";
	public final static String REGISTRATION = "REGISTRATION";
	public final static String CREATE_USER = "CREATE USER";
	public final static String LOG = "LOG";
	public final static String LOG_IN = "LOG IN";
	private JButton butBet;
	private JButton butCancel;
	private JLabel labBet;
	private JLabel labMoney;
	EnumHorse enumHorse;
	private JComboBox listHorses;
	private JTextField txtMoney;
	private JLabel labChooseHorse;
	private JButton butColorChoose;

	private JButton butRegistrer;
	private JButton butIntSesion;
	
	JButton butMakeLogIn;
	JButton butMakeReg;
	JTextField txtID;
	JTextField txtPassword;

	public PanelBet(InterfazClient interfazClient) {
		this.interfazClient = interfazClient;
		setLayout(new GridLayout(1, 2));
		butRegistrer = new JButton(REGISTRATION);
		butRegistrer.addActionListener(this);
		butRegistrer.setActionCommand(REGISTRATION);
		add(butRegistrer);

		butIntSesion = new JButton(LOG_IN);
		butIntSesion.addActionListener(this);
		butIntSesion.setActionCommand(LOG_IN);
		add(butIntSesion);

	}

	public void optionRegistration() {
		removeAll();
		setLayout(new GridLayout(3, 2));
		JLabel labID = new JLabel("ID");
		add(labID);

		txtID = new JTextField();
		add(txtID);

		JLabel labPassword = new JLabel("Password");
		add(labPassword);

		txtPassword = new JTextField();
		add(txtPassword);

		
		butMakeReg = new JButton(CREATE_USER);
		butMakeReg.addActionListener(this);
		butMakeReg.setActionCommand(CREATE_USER);
		add(butMakeReg);
		
	}
	
	public void optionlogIn() {
		removeAll();
		setLayout(new GridLayout(3, 2));
		JLabel labID = new JLabel("ID");
		add(labID);

		txtID = new JTextField();
		add(txtID);

		JLabel labPassword = new JLabel("Password");
		add(labPassword);

		txtPassword = new JTextField();
		add(txtPassword);

		
		butMakeLogIn = new JButton(LOG);
		butMakeLogIn.addActionListener(this);
		butMakeLogIn.setActionCommand(LOG);
		add(butMakeLogIn);
	}

	public String buildBDUser() {
		String lineRegis = "";
		lineRegis = txtID.getText() + "|" + txtPassword.getText();
		return lineRegis;
	}

	public void optionMakeBet() {
		removeAll();
		String ID = txtID.getText();
		setLayout(new GridLayout(5, 2));

		TitledBorder borde = BorderFactory.createTitledBorder("Bet");
		setBorder(borde);
		JLabel labWelcomeUser = new JLabel("Welcome user " + ID);
		add(labWelcomeUser);

		JLabel labEmpy = new JLabel("");
		add(labEmpy);

		labBet = new JLabel("horse do you want to bet on?");
		add(labBet);
		listHorses = new JComboBox(enumHorse.values());
		add(listHorses);
		labMoney = new JLabel("how much you want to bet?");
		add(labMoney);
		txtMoney = new JTextField();
		add(txtMoney);
		labChooseHorse = new JLabel("The horse you choose is colored");
		add(labChooseHorse);
		butColorChoose = new JButton("None");
		add(butColorChoose);

		butCancel = new JButton(CANCEL);
		butCancel.addActionListener(this);
		butCancel.setActionCommand(CANCEL);
		add(butCancel);

		butBet = new JButton(BET);
		butBet.addActionListener(this);
		butBet.setActionCommand(BET);
		add(butBet);
	}

	public void colorHorseChoose(String numHorse) {
		Color color = new Color(0, 0, 0);

		switch (numHorse) {

		case "1":
			color = new Color(80, 76, 73);
			break;
		case "2":
			color = new Color(157, 36, 15);
			break;
		case "3":
			color = new Color(159, 117, 57);
			break;
		case "4":
			color = new Color(248, 174, 0);
			break;
		case "5":
			color = new Color(216, 217, 219);
			break;
		case "6":
			color = new Color(26, 22, 47);
			break;

		}
		butColorChoose.setBackground(color);
		butColorChoose.setText("");
		repaint();
	}

	public void disableButBet() {
		butBet.setEnabled(false);
	}

	public JTextField getTxtMoney() {
		return txtMoney;
	}

	public void setTxtMoney(JTextField txtMoney) {
		this.txtMoney = txtMoney;
	}

	public String getNumbHorse(String numHorse) {
		switch (numHorse) {
		case "Horse_1":
			return "1";
		case "Horse_2":
			return "2";
		case "Horse_3":
			return "3";
		case "Horse_4":
			return "4";
		case "Horse_5":
			return "5";
		case "Horse_6":
			return "6";
		default:
			return "0";

		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals(REGISTRATION)) {
			optionRegistration();
			updateUI();
		}
		if (command.equals(CREATE_USER)) {
			interfazClient.findBDUser(buildBDUser());
			interfazClient.writeBDUser(buildBDUser());
			optionMakeBet();
			updateUI();
		}
		
		if (command.equals(LOG_IN)) {
			optionlogIn();
			repaint();
		}
		
		if(command.equals(LOG)) {
			interfazClient.checkBDUser(buildBDUser());
			 optionMakeBet();
			 updateUI();
		}
		if (command.equals(BET)) {
			String numbHorse = getNumbHorse(listHorses.getSelectedItem().toString());
			colorHorseChoose(numbHorse);
			disableButBet();
			String money = getTxtMoney().getText();
			interfazClient.makeBet(numbHorse, money);
		} else if (command.equals(CANCEL)) {

		}

	}

}
