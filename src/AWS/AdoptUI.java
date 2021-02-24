package AWS;
/**
 * @author Aadriza Sen Sharma
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class AdoptUI 
{

	JFrame frm_adopt;
	private JTextField txt_age;
	private DisplayManager mgr;
	JPanel panel_show = new JPanel();
	JPanel panel_find = new JPanel();
	private JTable table = new JTable();
	

	/**
	 * Create the application.
	 */
	public AdoptUI(DisplayManager mgr) 
	{
		this.mgr = mgr;
		panel_show.setVisible(false);
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm_adopt = new JFrame();
		frm_adopt.setIconImage(Toolkit.getDefaultToolkit().getImage(AdoptUI.class.getResource("/demo/1.png")));
		frm_adopt.setFont(new Font("Arial", Font.PLAIN, 13));
		frm_adopt.setTitle("ADOPT_Aadriza_Sen_Sharma_183");
		frm_adopt.setBounds(100, 100, 500, 700);
		frm_adopt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_adopt.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		frm_adopt.getContentPane().add(layeredPane);
												
												
												panel_find.setBorder(null);
												panel_find.setBackground(new Color(255, 255, 255));
												panel_find.setBounds(0, 0, 484, 661);
												frm_adopt.getContentPane().add(panel_find);
												panel_find.setLayout(null);
												
												JLabel error_lbl_location = new JLabel("");
												error_lbl_location.setForeground(Color.RED);
												error_lbl_location.setFont(new Font("Times New Roman", Font.PLAIN, 10));
												error_lbl_location.setBounds(228, 160, 194, 14);
												panel_find.add(error_lbl_location);
												
												JLabel error_lbl_animal = new JLabel("");
												error_lbl_animal.setForeground(Color.RED);
												error_lbl_animal.setFont(new Font("Times New Roman", Font.PLAIN, 10));
												error_lbl_animal.setBounds(228, 268, 194, 14);
												panel_find.add(error_lbl_animal);
												
												JLabel error_lbl_serviceP = new JLabel("");
												error_lbl_serviceP.setForeground(Color.RED);
												error_lbl_serviceP.setFont(new Font("Times New Roman", Font.PLAIN, 10));
												error_lbl_serviceP.setBounds(228, 376, 194, 14);
												panel_find.add(error_lbl_serviceP);
												
												JComboBox cbox_location = new JComboBox();
												cbox_location.addActionListener(new ActionListener() 
												{
													public void actionPerformed(ActionEvent e) 
													{
														if (cbox_location.getSelectedIndex() == 0)
												            error_lbl_location.setText("*Please select Location");
														else
															error_lbl_location.setText("");
													}
												});
												
												JLabel error_lbl_age = new JLabel("");
												error_lbl_age.setForeground(Color.RED);
												error_lbl_age.setFont(new Font("Times New Roman", Font.PLAIN, 10));
												error_lbl_age.setBounds(228, 484, 225, 14);
												panel_find.add(error_lbl_age);
												
													cbox_location.setBackground(new Color(204, 204, 204));
													cbox_location.setBounds(228, 133, 194, 22);
													panel_find.add(cbox_location);
													cbox_location.setFont(new Font("Arial", Font.PLAIN, 13));
													cbox_location.setModel(new DefaultComboBoxModel(new String[] {"- - - select - - -", "Kolkata", "Dum Dum", "Salt Lake", "New Town", "Alipurduar", "Bankura", "Birbhum", "Cooch Behar", "Dakshin Dinajpur (South Dinajpur)", "Darjeeling", "Hooghly", "Howrah", "Jalpaiguri", "Jhargram", "Kalimpong", "Kolkata", "Malda", "Murshidabad", "Nadia", "North 24 Parganas", "Paschim Medinipur (West Medinipur)", "Paschim (West) ", "Burdwan (Bardhaman)", "Purba Burdwan (Bardhaman)", "Purba Medinipur (East Medinipur)", "Purulia", "South 24 Parganas", "Uttar Dinajpur (North Dinajpur)"}));
													
													JComboBox cbox_animal = new JComboBox();
													cbox_animal.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) 
														{
															if (cbox_animal.getSelectedIndex() == 0)
													            error_lbl_animal.setText("*Please select Animal");
															else
																error_lbl_animal.setText("");
														}
													});
													cbox_animal.setBackground(new Color(204, 204, 204));
													cbox_animal.setBounds(228, 241, 194, 22);
													panel_find.add(cbox_animal);
													cbox_animal.setFont(new Font("Arial", Font.PLAIN, 13));
													cbox_animal.setModel(new DefaultComboBoxModel(new String[] {"- - - select - - -", "Bird", "Cat", "Dog", "Hamster", "Rabbit", "Fish"}));
													
													JComboBox cbox_serviceP = new JComboBox();
													cbox_serviceP.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) 
														{
															if (cbox_serviceP.getSelectedIndex() == 0)
													            error_lbl_serviceP.setText("*Please select Service Provider");
															else
																error_lbl_serviceP.setText("");
														}
													});
													cbox_serviceP.setBackground(new Color(204, 204, 204));
													cbox_serviceP.setBounds(228, 349, 194, 22);
													panel_find.add(cbox_serviceP);
													cbox_serviceP.setFont(new Font("Arial", Font.PLAIN, 13));
													cbox_serviceP.setModel(new DefaultComboBoxModel(new String[] {"- - - select - - -", "NGO", "VET", "PARAVET", "GROMMER"}));
													
													txt_age = new JTextField();
													txt_age.setBackground(new Color(204, 204, 204));
													txt_age.setBounds(228, 457, 86, 22);
													panel_find.add(txt_age);
													txt_age.setFont(new Font("Arial", Font.PLAIN, 13));
													txt_age.setColumns(10);
													
													JLabel lbl_location = new JLabel("Select Location : ");
													lbl_location.setIcon(new ImageIcon(AdoptUI.class.getResource("/demo/location5.png")));
													lbl_location.setForeground(new Color(0, 0, 153));
													lbl_location.setBounds(60, 133, 115, 22);
													panel_find.add(lbl_location);
													lbl_location.setFont(new Font("Times New Roman", Font.PLAIN, 14));
													
													JLabel lbl_animal = new JLabel("Select Animal : ");
													lbl_animal.setIcon(new ImageIcon(AdoptUI.class.getResource("/demo/animal.png")));
													lbl_animal.setForeground(new Color(0, 0, 153));
													lbl_animal.setBounds(60, 241, 115, 22);
													panel_find.add(lbl_animal);
													lbl_animal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
													
													JLabel lbl_serviceP = new JLabel("Select Service Provider : ");
													lbl_serviceP.setIcon(new ImageIcon(AdoptUI.class.getResource("/demo/sp2.png")));
													lbl_serviceP.setForeground(new Color(0, 0, 153));
													lbl_serviceP.setBounds(60, 349, 169, 22);
													panel_find.add(lbl_serviceP);
													lbl_serviceP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
													
													JLabel lbl_age = new JLabel("Enter Age : ");
													lbl_age.setIcon(new ImageIcon(AdoptUI.class.getResource("/demo/age.png")));
													lbl_age.setForeground(new Color(0, 0, 153));
													lbl_age.setBounds(60, 457, 115, 22);
													panel_find.add(lbl_age);
													lbl_age.setFont(new Font("Times New Roman", Font.PLAIN, 14));
													
													JLabel heading_lbl = new JLabel("ADOPT");
													heading_lbl.setForeground(new Color(0, 0, 153));
													heading_lbl.setBounds(229, 48, 70, 22);
													panel_find.add(heading_lbl);
													heading_lbl.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 20));
													
													JLabel lbl_findImg = new JLabel("");
													lbl_findImg.setIcon(new ImageIcon(AdoptUI.class.getResource("/demo/form3.png")));
													lbl_findImg.setBounds(181, 35, 38, 55);
													panel_find.add(lbl_findImg);
													
													JButton btn_find = new JButton("FIND");
													btn_find.setIcon(new ImageIcon(AdoptUI.class.getResource("/demo/find6.png")));
													btn_find.addActionListener(new ActionListener() 
													{
														public void actionPerformed(ActionEvent e) 
														{
															try
															{
																if (cbox_location.getSelectedIndex() == 0)
														            error_lbl_location.setText("*Please select Location");
																if (cbox_animal.getSelectedIndex() == 0)
														            error_lbl_animal.setText("*Please select Animal");
																if (cbox_serviceP.getSelectedIndex() == 0)
														            error_lbl_serviceP.setText("*Please select Service Provider");
																if(txt_age.getText().isEmpty()==false && Integer.parseInt(txt_age.getText())<0)
														        	error_lbl_age.setText("*Please Enter Age correctly (It cannot be negative)");
														        else if(error_lbl_serviceP.getText().equals("") && error_lbl_animal.getText().equals("") && error_lbl_location.getText().equals("") && error_lbl_age.getText().equals(""))
														        	panel_find.setVisible(false);
														        else
														        	error_lbl_age.setText("");
																
																String animal = null, location = null, spUsername = null;
													            int age = 0;
													            ArrayList<AdoptionAppeal> res = new ArrayList<AdoptionAppeal>();
													            animal = (String)cbox_animal.getSelectedItem();
													            spUsername = (String)cbox_serviceP.getSelectedItem();
													            location = (String)cbox_location.getSelectedItem();
													            
																if(txt_age.getText().isEmpty())
																	res = mgr.getAppealManager().getAdoptionManager().searchAdoptionAppeal(animal,spUsername,location);
																else
																{
																	age = Integer.parseInt(txt_age.getText());
																	res = mgr.getAppealManager().getAdoptionManager().searchAdoptionAppeal(animal,spUsername,location,age);
																}
																
																if(res.isEmpty()==false)
																{
																	for (int i = 0; i < res.size(); i++)
																	{
																		table.setValueAt((Object)res.get(i).getAnimal(),i+2,0);
																		table.setValueAt((Object)res.get(i).getSpUsername(),i+2,1);
																		table.setValueAt((Object)res.get(i).getLocation(),i+2,2);
																		table.setValueAt((Object)String.valueOf(res.get(i).getAge()),i+2,3);
																		table.setValueAt((Object)res.get(i).getNeeds(),i+2,4);
																		table.setValueAt((Object)res.get(i).getDiseases(),i+2,5);
																		table.setValueAt((Object)res.get(i).getCriteria(),i+2,6);
																	}
																}
																mgr.getAppealManager().getAdoptionManager().save("adoptionlist.csv");
																panel_show.setVisible(true);
															}
										            catch(NumberFormatException ex)
										            {
										            	error_lbl_age.setText("*Please Enter Age correctly (It must be a number)");
										            }
														}
													});
													btn_find.setForeground(new Color(0, 0, 153));
													btn_find.setBackground(new Color(255, 255, 255));
													
													btn_find.setFont(new Font("Times New Roman", Font.BOLD, 14));
													btn_find.setBounds(184, 579, 115, 38);
													panel_find.add(btn_find);
													
													
													JSeparator sept_find = new JSeparator();
													sept_find.setBounds(60, 532, 362, 8);
													panel_find.add(sept_find);
													
													JSeparator sept_adopt = new JSeparator();
													sept_adopt.setBounds(230, 75, 64, 1);
													panel_find.add(sept_adopt);
													
													panel_show.setLayout(null);
													panel_show.setBounds(0, 0, 484, 661);
													frm_adopt.getContentPane().add(panel_show);
													
													JLabel lbl_adoptImg = new JLabel("");
													lbl_adoptImg.setIcon(new ImageIcon(AdoptUI.class.getResource("/demo/adoption.png")));
													lbl_adoptImg.setBounds(203, 540, 78, 80);
													panel_show.add(lbl_adoptImg);
													
													JLabel lbl_matches = new JLabel("MATCHES FOUND");
													lbl_matches.setForeground(new Color(0, 0, 153));
													lbl_matches.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 20));
													lbl_matches.setBounds(191, 53, 174, 21);
													panel_show.add(lbl_matches);
													
													JLabel lbl_matchesImg = new JLabel("");
													lbl_matchesImg.setIcon(new ImageIcon(AdoptUI.class.getResource("/demo/found3.png")));
													lbl_matchesImg.setBounds(150, 39, 35, 49);
													panel_show.add(lbl_matchesImg);
													
													JButton btn_ok = new JButton("Exit");
													btn_ok.setIcon(new ImageIcon(AdoptUI.class.getResource("/demo/yes.png")));
													btn_ok.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															frm_adopt.setVisible(false);
														}
													});
													btn_ok.setForeground(new Color(0, 204, 0));
													btn_ok.setFont(new Font("Times New Roman", Font.PLAIN, 14));
													btn_ok.setBackground(Color.WHITE);
													btn_ok.setBounds(349, 582, 78, 35);
													panel_show.add(btn_ok);
													
													JButton btn_back = new JButton("Back");
													btn_back.setIcon(new ImageIcon(AdoptUI.class.getResource("/demo/back.png")));
													btn_back.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															panel_find.setVisible(true);
															panel_show.setVisible(false);
														}
													});
													btn_back.setForeground(new Color(204, 0, 0));
													btn_back.setFont(new Font("Times New Roman", Font.PLAIN, 14));
													btn_back.setBackground(Color.WHITE);
													btn_back.setBounds(56, 582, 78, 35);
													panel_show.add(btn_back);
													
													JSeparator sept_find_1 = new JSeparator();
													sept_find_1.setBounds(198, 80, 161, 5);
													panel_show.add(sept_find_1);
													
													
													table.setModel(new DefaultTableModel(
														new Object[][] {
															{"Animal", "Provider", "Location", "Age", "Needs", "Diseases", "Criteria"},
															{null, null, null, null, null, null, null},
															{null, null, null, null, null, null, null},
															{null, null, null, null, null, null, null},
															{null, null, null, null, null, null, null},
															{null, null, null, null, null, null, null},
														},
														new String[] {
															"New column", "New column", "New column", "New column", "New column", "New column", "New column"
														}
													));
													table.getColumnModel().getColumn(0).setPreferredWidth(73);
													table.getColumnModel().getColumn(1).setPreferredWidth(74);
													table.setBounds(10, 116, 464, 402);
													
													panel_show.add(table);
									
									
	}
}