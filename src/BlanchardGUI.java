import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.DateFormatter;

public final class BlanchardGUI extends JPanel{


    JTextField studentName;
    JTextField studentPassword;
    JTextField staffName;
    JTextField staffPassword;
    JButton studentLoginButton;
    JButton staffLoginButton;
    JLabel menuLabel;
    String menu;
    JPanel menuPanel;
    JCheckBox honeyMonkey;
    JCheckBox flufferNutter;
    String[] sandwichMenu = {"Honey Monkey","Fluffer Nutter","Egg Salad Sandwich","Peanut Butter & Jelly Sandwich","Tofu Caprese Sandwich","Caprese Sandwich","Vegan Triple Play","Vegetarian Triple Play","Monterey Jack Cheese Quesadilla","Chicken Cheese Quesadilla","Classic Turkey Club Sandwich","BLT"};
    String[] grillMenu = {"Baked Potatoes","Baked Sweet Potatoes","Double Vegan Boca Burger on a Roll","Double Cheese Burger","Falafel Wrap","Grain Du Jour","Grilled Vegetable Wrap","Kale Steamed w/Garlic","Sweet Potato Fries","Vegan Boca Burger on a Roll","Vegan Nuggets","Fried Eggs", "Grilled Cheese & Tomato Sandwich","Grilled Cheese Sandwich","Grilled Portabella Sandwich","Mozzarella Stix","Tofu Parmesan Wrap Sandwich","Vegetarian Mount Holyokes","Buffalo Chicken Wrap","Chicken Caesar Wrap","Chicken Finger Grinder","Chicken Tenders","Double Cheeseburger","Mary Lyon Sandwich","Spicy Fries","Tuna Meltdown","Philly Steak Sandwich","Meltdown Grinder"};
    String[] pizzaMenu = {"Sauce","Cheese","Chicken","Tomatoes","Mozzarella","Pepperoni","Olive","Broccoli","Red Pepper","Onion"};
    String[] saladMenu = {"Romaine","Spinach","Spring Mix","Garlic Wrap","Spinach Wrap","Whole Grain Wrap","Cranberry","Red Pepper","Broccoli","Tomatoes","Onions","Bean Sprouts","Chic Peas","Black Beans","Pinto Beans","Edamame","Grilled Chicken","Salmon","Teriyaki Tofu","Shrimp","Turkey","Smoked Ham","Eggs","Fresh Mozzeralla","Feta Cheese","Parmesan Cheese"};
    JCheckBox[] sandwichArray = new JCheckBox[sandwichMenu.length]; 
    JCheckBox[] grillArray = new JCheckBox[grillMenu.length];
    JCheckBox[] saladArray = new JCheckBox[saladMenu.length];
    JCheckBox[] pizzaArray = new JCheckBox[pizzaMenu.length];
    JSpinner jSpinner1;
    JSpinner jSpinner2;
    JSpinner jSpinner3;
    JSpinner jSpinner4;
    JLabel byeLabel;
    GrillHandler grillHandler;
    PizzaHandler pizzaHandler;
    static JTextArea timeArea;
    static JTextArea orderArea;
    SandwichHandler sandwichHandler;
    SaladHandler saladHandler;
    public BlanchardGUI(){
	initPanel();
    }


    public static void setTimeText(String time){
	timeArea.setText(time);
    }

    public static void setOrderText(String order){
	orderArea.setText(order);
    }
    public void secondPanel(){
	setLayout(new BorderLayout());
	add(northPanel(),BorderLayout.NORTH);
	add(secondCenterPanel(),BorderLayout.CENTER);
	add(secondSouthPanel(),BorderLayout.SOUTH);

    }


    private JPanel secondCenterPanel(){
	menuLabel.setText("<html><br>Welcome " + studentName.getText() + "!<br><br>What would you like to order today?</html>");
	JPanel centerPanel = new JPanel(new GridLayout(1,0));
	centerPanel.add(grillPanel());
	centerPanel.add(sandwichPanel());
	return centerPanel;
    }

    private JPanel secondSouthPanel(){
	JPanel southPanel = new JPanel(new GridLayout(1,0));
	southPanel.add(saladPanel());
	southPanel.add(pizzaPanel());
	return southPanel;
    }


    private JPanel grillPanel(){
	JPanel grillPanel = new JPanel(new GridLayout(1,0));
	JLabel grillPic = new JLabel();
	grillPic.setIcon(new ImageIcon("hotOffTheGrill.jpg"));
	grillPanel.add(grillPic);
	grillPanel.add(grillButton());
	return grillPanel;

    }


    private JButton grillButton() {
	String buttonText = new String("<html><u>Hot Off the Grill</u><html>");
	JButton grillButton = new JButton(buttonText);
	grillButton.setOpaque(true);
	grillButton.setBorderPainted(false);
	Font myFont = new Font("Times New Roman",Font.ROMAN_BASELINE, 20);
	grillButton.setFont(myFont);
	grillButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		grillMenu();
		revalidate();
		repaint();
	    }

	});
	return grillButton;
    }

    private JPanel pizzaPanel(){
	JPanel pizzaPanel = new JPanel(new GridLayout(1,0));
	JLabel pizzaPic = new JLabel();
	pizzaPic.setIcon(new ImageIcon("personalPizza.jpg"));
	pizzaPanel.add(pizzaPic);
	pizzaPanel.add(pizzaButton());
	return pizzaPanel;

    }


    private JButton pizzaButton() {
	String buttonText = new String("<html><u>Personal Pizza</u><html>");
	JButton pizzaButton = new JButton(buttonText);
	pizzaButton.setOpaque(true);
	pizzaButton.setBorderPainted(false);
	Font myFont = new Font("Times New Roman",Font.ROMAN_BASELINE, 20);
	pizzaButton.setFont(myFont);
	pizzaButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		pizzaMenu();
		revalidate();
		repaint();
	    }

	});
	return pizzaButton;
    }


    private JPanel saladPanel(){
	JPanel saladPanel = new JPanel(new GridLayout(1,0));
	JLabel saladPic = new JLabel();
	saladPic.setIcon(new ImageIcon("salad.jpg"));
	saladPanel.add(saladPic);
	saladPanel.add(saladButton());
	return saladPanel;

    }


    private JButton saladButton() {
	String buttonText = new String("<html><u>Salad Station</u><html>");
	JButton saladButton = new JButton(buttonText);
	saladButton.setOpaque(true);
	saladButton.setBorderPainted(false);
	Font myFont = new Font("Times New Roman",Font.ROMAN_BASELINE, 20);
	saladButton.setFont(myFont);
	saladButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		saladMenu();
		revalidate();
		repaint();
	    }

	});
	return saladButton;
    }



    private JPanel sandwichPanel(){
	JPanel sandwichPanel = new JPanel(new GridLayout(1,0));
	JLabel sandwichPic = new JLabel();
	sandwichPic.setIcon(new ImageIcon("sandwich.jpg"));
	sandwichPanel.add(sandwichPic);
	sandwichPanel.add(sandwichButton());
	return sandwichPanel;

    }


    private JButton sandwichButton() {
	String buttonText = new String("<html><u>Sandwich Station</u><html>");
	JButton sandwichButton = new JButton(buttonText);
	sandwichButton.setOpaque(true);
	sandwichButton.setBorderPainted(false);
	Font myFont = new Font("Times New Roman",Font.ROMAN_BASELINE, 20);
	sandwichButton.setFont(myFont);
	sandwichButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		sandwichMenu();
		revalidate();
		repaint();
	    }

	});
	return sandwichButton;
    }

    /**
     * Layouts the whole Frame
     */
    public void initPanel(){
	//setting a border layout
	setLayout(new BorderLayout());
	add(northPanel(),BorderLayout.NORTH);
	add(centerPanel(),BorderLayout.CENTER);
	add(southPanel(),BorderLayout.SOUTH);
	validate();
    }


    private JPanel northPanel(){
	JPanel northPanel = new JPanel(new BorderLayout());
	northPanel.add(picPanel(),BorderLayout.WEST);
	northPanel.add(menuPanel(),BorderLayout.CENTER);
	return northPanel;

    }

    /**
     * A Panel that holds the image
     * @return JPanel
     */
    private JPanel picPanel(){
	//initialize JPanel called northPanel
	JPanel picPanel = new JPanel(new GridLayout(1,2));
	//initialize JLabel called mhcLabel
	JLabel mhcLabel = new JLabel();
	//adding image to mhcLabel
	mhcLabel.setIcon(new ImageIcon("diningLogo.jpg"));
	picPanel.add(mhcLabel);
	validate();
	return picPanel;
    }

    /**
     * An overview of what the application does
     * @return
     */
    private JPanel menuPanel(){
	menuLabel = new JLabel();
	//initialize
	menuPanel = new JPanel();
	//initialize myFont and set it to a desired font
	Font myFont = new Font("Couirer",Font.BOLD, 22);
	//setting the font of the menuLabel to myFont
	menuLabel.setFont(myFont);
	menuPanel.add(menuLabel);
	return menuPanel;
    }

    private JPanel centerPanel(){
	JPanel centerPanel = new JPanel(new BorderLayout());
	centerPanel.add(studentPanel(),BorderLayout.NORTH);
	return centerPanel;
    }


    private JPanel southPanel(){
	JPanel southPanel = new JPanel(new BorderLayout());
	southPanel.add(staffPanel(),BorderLayout.NORTH);
	return southPanel;
    }
    /**
     * A panel that has guesses for the user and hint
     * @return
     */
    private JPanel studentPanel(){
	JPanel studentPanel = new JPanel(new GridLayout(4,2));
	JLabel studentLabel = new JLabel();
	JLabel blankLabel = new JLabel();
	Font myFont = new Font("Times New Roman",Font.BOLD, 30);
	Font myOtherFont = new Font("Times New Roman",Font.PLAIN,20);
	studentLabel.setText("Student Login");
	blankLabel.setText("");
	studentLabel.setFont(myFont);
	JLabel nameLabel = new JLabel();
	JLabel passwordLabel = new JLabel();
	nameLabel.setText("Username");
	nameLabel.setFont(myOtherFont);
	passwordLabel.setFont(myOtherFont);
	passwordLabel.setText("MHC ID");
	studentName = new JTextField(20);
	studentPassword = new JTextField(20);
	studentPanel.add(studentLabel);
	studentPanel.add(blankLabel);
	studentPanel.add(nameLabel);
	studentPanel.add(studentName);
	studentPanel.add(passwordLabel);
	studentPanel.add(studentPassword);
	studentPanel.add(studentLoginButton());
	return studentPanel;
    }

    /**
     * A panel that has guesses for the user and hint
     * @return
     */
    private JPanel staffPanel(){
	JPanel staffPanel = new JPanel(new GridLayout(4,2));
	JLabel staffLabel = new JLabel();
	JLabel blankLabel = new JLabel();
	Font myFont = new Font("Times New Roman",Font.BOLD, 30);
	Font myOtherFont = new Font("Times New Roman",Font.PLAIN,20);
	staffLabel.setText("Staff Login");
	blankLabel.setText("");
	staffLabel.setFont(myFont);
	JLabel nameLabel = new JLabel();
	JLabel passwordLabel = new JLabel();
	nameLabel.setText("Username");
	passwordLabel.setText("Staff ID");
	nameLabel.setFont(myOtherFont);
	passwordLabel.setFont(myOtherFont);
	staffName = new JTextField(20);
	staffPassword = new JTextField(20);
	staffPanel.add(staffLabel);
	staffPanel.add(blankLabel);
	staffPanel.add(nameLabel);
	staffPanel.add(staffName);
	staffPanel.add(passwordLabel);
	staffPanel.add(staffPassword);
	staffPanel.add(staffLoginButton());
	return staffPanel;
    }


    private JButton studentLoginButton() {
	studentLoginButton = new JButton("Place Order");
	studentLoginButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		secondPanel();
		revalidate();
		repaint();
	    }

	});
	return studentLoginButton;
    }


    private JButton staffLoginButton() {
	staffLoginButton = new JButton("Take Order");
	staffLoginButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		orderPanel();
		DataSaveRestore.readFromFile1("SaveDataExample.txt");
		revalidate();
		repaint();
	    }

	});
	return staffLoginButton;
    }

    public void orderPanel(){
	setLayout(new BorderLayout());
	add(northPanel(),BorderLayout.NORTH);
	add(secondStaffPanel(),BorderLayout.CENTER);
    }





    public void sandwichMenu(){
	setLayout(new BorderLayout());
	add(sandwichMenuPanel(),BorderLayout.CENTER);
	add(sandwichBottomPanel(),BorderLayout.SOUTH);
    }


    /**
     * not done
     * @return
     */
    private JPanel secondStaffPanel(){
	menuLabel.setText("<html><br>Welcome " + staffName.getText() + "!<br><br>Thank you for your work</html>"); 
	JPanel orderPanel = new JPanel(new GridLayout(1,2));
	timeArea = new JTextArea();
	orderArea = new JTextArea();
	orderPanel.add(timeArea);
	orderPanel.add(orderArea);
	return orderPanel;
    }


    private JButton sandwichOrderButton() {
	JButton sandwichButton = new JButton("Order");
	sandwichButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		Date d = (Date)jSpinner1.getValue();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.get(Calendar.HOUR);
		c.get(Calendar.MINUTE);
		Order order = new Order();
		order.setTime(order.convertTime(comboBox.getSelectedItem().toString(), Integer.toString(c.get(Calendar.HOUR)), Integer.toString(c.get(Calendar.MINUTE))));
		order.setText(mySandwichArrayList.toString());
		DataSaveRestore.saveOrder(order);
		last();
		revalidate();
		repaint();
	    }

	});
	return sandwichButton;
    }

    private JPanel sandwichMenuPanel(){
	JPanel sandwichMenuPanel = new JPanel(new GridLayout(sandwichArray.length-1,0));
	for(int i = 0;i<sandwichMenu.length;i++){
	    sandwichArray[i] = new JCheckBox(sandwichMenu[i]);
	    sandwichHandler = new SandwichHandler();
	    sandwichArray[i].addItemListener(sandwichHandler);
	    sandwichMenuPanel.add(sandwichArray[i]);
	}
	return sandwichMenuPanel;
    }


    ArrayList mySandwichArrayList = new ArrayList();

    private class SandwichHandler implements ItemListener{
	public void itemStateChanged(ItemEvent event){
	    for(int i = 0;i<sandwichArray.length;i++){
		if(sandwichArray[i].isSelected()){
		    if(!mySandwichArrayList.contains(sandwichArray[i].getText())){
			menu = sandwichArray[i].getText();
			mySandwichArrayList.add(menu);
		    }	    
		}
		else if(mySandwichArrayList.contains(sandwichArray[i].getText())){
		    mySandwichArrayList.remove(sandwichArray[i].getText());
		}

	    }

	    System.out.println(mySandwichArrayList.toString());
	}
    }

    ArrayList myPizzaArrayList;
    private class PizzaHandler implements ItemListener{
	public void itemStateChanged(ItemEvent event){
	    myPizzaArrayList = new ArrayList();
	    for(int i = 0;i<pizzaArray.length;i++){
		if(pizzaArray[i].isSelected()){
		    if(!myPizzaArrayList.contains(pizzaArray[i].getText())){
			menu = pizzaArray[i].getText();
			myPizzaArrayList.add(menu);
		    }	    
		}
		else if(myPizzaArrayList.contains(pizzaArray[i].getText())){
		    myPizzaArrayList.remove(pizzaArray[i].getText());
		}

	    }
	}
    }

    ArrayList myGrillArrayList;
    private class GrillHandler implements ItemListener{
	public void itemStateChanged(ItemEvent event){
	    myGrillArrayList = new ArrayList();
	    for(int i = 0;i<grillArray.length;i++){
		if(grillArray[i].isSelected()){
		    if(!myGrillArrayList.contains(grillArray[i].getText())){
			menu = grillArray[i].getText();
			myGrillArrayList.add(menu);
		    }	    
		}
		else if(myGrillArrayList.contains(grillArray[i].getText())){
		    myGrillArrayList.remove(grillArray[i].getText());
		}

	    }
	}
    }

    ArrayList mySaladArrayList;
    private class SaladHandler implements ItemListener{
	public void itemStateChanged(ItemEvent event){
	    mySaladArrayList = new ArrayList();

	    for(int i = 0;i<saladArray.length;i++){
		if(saladArray[i].isSelected()){
		    if(!mySaladArrayList.contains(saladArray[i].getText())){
			menu = saladArray[i].getText();
			mySaladArrayList.add(menu);
		    }	    
		}
		else if(mySaladArrayList.contains(saladArray[i].getText())){
		    mySaladArrayList.remove(saladArray[i].getText());
		}

	    }
	}
    }

    public void saladMenu(){
	setLayout(new BorderLayout());
	add(northPanelSalad(),BorderLayout.NORTH);
	add(saladMenuPanel(),BorderLayout.CENTER);
	add(saladBottomPanel(),BorderLayout.SOUTH);

    }
    private JPanel northPanelSalad(){
	JPanel northPanel = new JPanel(new BorderLayout());
	JLabel saladLabel = new JLabel();
	saladLabel.setText("Select what you would like to put on your salad");
	Font myFont = new Font("Times New Roman",Font.BOLD, 25);
	saladLabel.setFont(myFont);
	northPanel.add(saladLabel);
	return northPanel;
    }
    
    private JPanel saladMenuPanel(){
	JPanel saladMenuPanel = new JPanel(new GridLayout(0,3));
	
	for(int i = 0;i<saladMenu.length;i++){
	    saladHandler = new SaladHandler();
	    saladArray[i] = new JCheckBox(saladMenu[i]);
	    saladArray[i].addItemListener(saladHandler);
	    saladMenuPanel.add(saladArray[i]);
	}
	return saladMenuPanel;
    }

    public void grillMenu(){
	setLayout(new BorderLayout());
	add(grillMenuPanel(),BorderLayout.CENTER);
	add(grillBottomPanel(),BorderLayout.SOUTH);
    }

    private JPanel grillMenuPanel(){
	JPanel grillMenuPanel = new JPanel(new GridLayout(grillArray.length-1,0));
	for(int i = 0;i<grillMenu.length;i++){
	    grillHandler = new GrillHandler();
	    grillArray[i] = new JCheckBox(grillMenu[i]);
	    grillArray[i].addItemListener(grillHandler);
	    grillMenuPanel.add(grillArray[i]);
	}
	return grillMenuPanel;
    }

    public void pizzaMenu(){
	setLayout(new BorderLayout());
	add(pizzaMenuPanel(),BorderLayout.CENTER);
	add(pizzaBottomPanel(),BorderLayout.SOUTH);
    }


    private JPanel pizzaMenuPanel(){
	JPanel pizzaMenuPanel = new JPanel(new GridLayout(pizzaArray.length+1,0));
	JLabel menuLabel = new JLabel();
	JLabel blankLabel = new JLabel();
	menuLabel.setText("Personal Pizza");
	Font myFont = new Font("Times New Roman",Font.BOLD, 25);
	menuLabel.setFont(myFont);
	blankLabel.setText("");
	pizzaMenuPanel.add(menuLabel);
	pizzaMenuPanel.add(blankLabel);
	for(int i = 0;i<pizzaMenu.length;i++){
	    pizzaHandler = new PizzaHandler();
	    pizzaArray[i] = new JCheckBox(pizzaMenu[i]);
	    pizzaArray[i].addItemListener(pizzaHandler);
	    pizzaMenuPanel.add(pizzaArray[i]);
	}
	return pizzaMenuPanel;
    }



    private JButton returnButton() {
	JButton returnButton = new JButton("Back");
	returnButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		secondPanel();
		revalidate();
		repaint();
	    }
	});
	return returnButton;
    }



    private JButton saladOrderButton() {
	JButton saladOrderButton = new JButton("Order");
	saladOrderButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		Date d = (Date)jSpinner3.getValue();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.get(Calendar.HOUR);
		c.get(Calendar.MINUTE);
		Order order = new Order();
		order.setTime(order.convertTime(comboBox1.getSelectedItem().toString(), Integer.toString(c.get(Calendar.HOUR)), Integer.toString(c.get(Calendar.MINUTE))));
		order.setText(mySaladArrayList.toString());
		DataSaveRestore.saveOrder(order);
		last();
		revalidate();
		repaint();
	    }

	});
	return saladOrderButton;
    }
    
    JComboBox comboBox1;
    private JPanel saladBottomPanel(){
	jSpinner3 = new JSpinner();
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date(0));
	Date earliestDate = calendar.getTime();
	calendar.add(Calendar.MINUTE, 1439); // number of minutes in a day - 1
	Date latestDate = calendar.getTime();
	SpinnerDateModel model = new SpinnerDateModel(earliestDate,
		earliestDate,
		latestDate,
		Calendar.MINUTE);
	jSpinner3.setModel(model);
	jSpinner3.setEditor(new JSpinner.DateEditor(jSpinner3, "HH:mm"));
	JLabel pickUpLabel = new JLabel();
	pickUpLabel.setText("Pick up Time");
	comboBox1 = new JComboBox();
	comboBox1.addItem("AM");
	comboBox1.addItem("PM");
	Font myFont = new Font("Times New Roman",Font.BOLD, 20);
	pickUpLabel.setFont(myFont);
	JLabel blankLabel = new JLabel();
	blankLabel.setText("");
	JPanel combinedPanel = new JPanel(new GridLayout(3,2));
	combinedPanel.add(pickUpLabel);
	combinedPanel.add(blankLabel);
	combinedPanel.add(jSpinner3);
	combinedPanel.add(comboBox1);
	combinedPanel.add(returnButton());
	combinedPanel.add(saladOrderButton());
	return combinedPanel;
    }


    private JButton pizzaOrderButton() {
	JButton pizzaButton = new JButton("Order");
	pizzaButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		Date d = (Date)jSpinner2.getValue();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.get(Calendar.HOUR);
		c.get(Calendar.MINUTE);
		Order order = new Order();
		order.setTime(order.convertTime(comboBox2.getSelectedItem().toString(), Integer.toString(c.get(Calendar.HOUR)), Integer.toString(c.get(Calendar.MINUTE))));
		order.setText(myPizzaArrayList.toString());
		DataSaveRestore.saveOrder(order);
		last();
		revalidate();
		repaint();
	    }

	});
	return pizzaButton;
    }
    
    JComboBox comboBox2;
    private JPanel pizzaBottomPanel(){
	jSpinner2 = new JSpinner();
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date(0));
	Date earliestDate = calendar.getTime();
	calendar.add(Calendar.MINUTE, 1439); // number of minutes in a day - 1
	Date latestDate = calendar.getTime();
	SpinnerDateModel model = new SpinnerDateModel(earliestDate,
		earliestDate,
		latestDate,
		Calendar.MINUTE);
	jSpinner2.setModel(model);
	jSpinner2.setEditor(new JSpinner.DateEditor(jSpinner2, "hh:mm"));
	JLabel pickUpLabel = new JLabel();
	pickUpLabel.setText("Pick up Time");
	comboBox2 = new JComboBox();
	comboBox2.addItem("AM");
	comboBox2.addItem("PM");
	Font myFont = new Font("Times New Roman",Font.BOLD, 20);
	pickUpLabel.setFont(myFont);
	JLabel blankLabel = new JLabel();
	blankLabel.setText("");
	JPanel combinedPanel = new JPanel(new GridLayout(3,2));
	combinedPanel.add(pickUpLabel);
	combinedPanel.add(blankLabel);
	combinedPanel.add(jSpinner2);
	combinedPanel.add(comboBox2);
	combinedPanel.add(returnButton());
	combinedPanel.add(pizzaOrderButton());
	return combinedPanel;
    }


    private JButton grillOrderButton() {
	JButton grillButton = new JButton("Order");
	grillButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		removeAll();
		Date d = (Date)jSpinner4.getValue();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.get(Calendar.HOUR);
		c.get(Calendar.MINUTE);
		Order order = new Order();
		order.setTime(order.convertTime(comboBox3.getSelectedItem().toString(), Integer.toString(c.get(Calendar.HOUR)), Integer.toString(c.get(Calendar.MINUTE))));
		order.setText(myGrillArrayList.toString());
		DataSaveRestore.saveOrder(order);
		last();
		revalidate();
		repaint();
	    }

	});
	return grillButton;
    }
    
    JComboBox comboBox3;
    private JPanel grillBottomPanel(){
	jSpinner4 = new JSpinner();
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date(0));
	Date earliestDate = calendar.getTime();
	calendar.add(Calendar.MINUTE, 1439); // number of minutes in a day - 1
	Date latestDate = calendar.getTime();
	SpinnerDateModel model = new SpinnerDateModel(earliestDate,
		earliestDate,
		latestDate,
		Calendar.MINUTE);
	jSpinner4.setModel(model);
	jSpinner4.setEditor(new JSpinner.DateEditor(jSpinner4, "hh:mm"));

	JLabel pickUpLabel = new JLabel();
	pickUpLabel.setText("Pick up Time");
	comboBox3 = new JComboBox();
	comboBox3.addItem("AM");
	comboBox3.addItem("PM");
	Font myFont = new Font("Times New Roman",Font.BOLD, 20);
	pickUpLabel.setFont(myFont);
	JLabel blankLabel = new JLabel();
	blankLabel.setText("");
	JPanel combinedPanel = new JPanel(new GridLayout(3,2));
	combinedPanel.add(pickUpLabel);
	combinedPanel.add(blankLabel);
	combinedPanel.add(jSpinner4);
	combinedPanel.add(comboBox3);
	combinedPanel.add(returnButton());
	combinedPanel.add(grillOrderButton());
	return combinedPanel;
    }


    public void last(){
	setLayout(new BorderLayout());
	add(lastPanel(),BorderLayout.CENTER);

    }
    public JPanel lastPanel(){
	JPanel lastPanel = new JPanel();
	byeLabel = new JLabel();
	byeLabel.setText("Thank you for placing your order!");
	Font myFont = new Font("Times New Roman",Font.BOLD, 20);
	byeLabel.setFont(myFont);
	lastPanel.add(byeLabel);
	return lastPanel;
    }
    public JPanel timePanel(){
	JPanel timePanel = new JPanel();
	return timePanel;
    }

    JComboBox comboBox;
    private JPanel sandwichBottomPanel(){
	jSpinner1 = new JSpinner();
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date(0));
	Date earliestDate = calendar.getTime();
	calendar.add(Calendar.MINUTE, 1439); // number of minutes in a day - 1
	Date latestDate = calendar.getTime();
	SpinnerDateModel model = new SpinnerDateModel(earliestDate,
		earliestDate,
		latestDate,
		Calendar.MINUTE);
	jSpinner1.setModel(model);
	jSpinner1.setEditor(new JSpinner.DateEditor(jSpinner1, "hh:mm"));

	JLabel pickUpLabel = new JLabel();
	pickUpLabel.setText("Pick up Time");
	comboBox = new JComboBox();
	comboBox.addItem("AM");
	comboBox.addItem("PM");
	Font myFont = new Font("Times New Roman",Font.BOLD, 20);
	pickUpLabel.setFont(myFont);
	JLabel blankLabel = new JLabel();
	blankLabel.setText("");
	JPanel combinedPanel = new JPanel(new GridLayout(3,2));
	combinedPanel.add(pickUpLabel);
	combinedPanel.add(blankLabel);
	combinedPanel.add(jSpinner1);
	combinedPanel.add(comboBox);
	combinedPanel.add(returnButton());
	combinedPanel.add(sandwichOrderButton());

	return combinedPanel;
    }


    public static void main(String[] args){
	//initialize a new JFrame 
	JFrame blanch = new JFrame("Blanchard Pre-order Application");
	blanch.add(new BlanchardGUI());
	//set the size of the frame
	blanch.setSize(755,800);
	brlanch.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	blanch.setVisible( true );
    }
}
