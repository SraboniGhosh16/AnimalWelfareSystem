package AWS;
/**
 * @author Aadriza Sen Sharma
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.border.MatteBorder;

public class AdoptUI 
{

	JFrame frm_adopt;
	private JTextField txt_age;
	private DisplayManager mgr;
	JPanel panel_show = new JPanel();
	JPanel panel_find = new JPanel();
	JLabel lbl_no_match = new JLabel("");
	DefaultTableModel model;
	private JTable table = new JTable();
	JScrollPane scrollPane = new JScrollPane();
	ArrayList<AdoptionAppeal> res = new ArrayList<AdoptionAppeal>();;
	
	public AdoptUI(DisplayManager mgr) 
	{
		this.mgr = mgr;
		panel_show.setBackground(Color.WHITE);
		panel_show.setVisible(false);
		initialize();
	}

	private void initialize() 
	{
		frm_adopt = new JFrame();
		frm_adopt.setForeground(Color.BLACK);
		frm_adopt.setIconImage(Toolkit.getDefaultToolkit().getImage(AdoptUI.class.getResource("/img/logo.png")));
		frm_adopt.setFont(new Font("Arial", Font.PLAIN, 13));
		frm_adopt.setTitle("ADOPT_Aadriza_Sen_Sharma_183");
		frm_adopt.setBounds(100, 100, 929, 610);
		frm_adopt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_adopt.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		frm_adopt.getContentPane().add(layeredPane);													
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		for (int i = 0; i <table.getColumnCount(); i++) 
		     table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		model = new DefaultTableModel();
		model.addColumn((Object)"Animal");
        model.addColumn((Object)"Provider");
        model.addColumn((Object)"Location");
        model.addColumn((Object)"Age");
        model.addColumn((Object)"Needs");
        model.addColumn((Object)"Diseases");
        model.addColumn((Object)"Criteria");
		
		panel_find.setBorder(null);
		panel_find.setBackground(new Color(255, 255, 255));
		panel_find.setBounds(0, -12, 929, 610);
		frm_adopt.getContentPane().add(panel_find);
		panel_find.setLayout(null);
		
		JLabel error_lbl_location = new JLabel("");
		error_lbl_location.setForeground(Color.RED);
		error_lbl_location.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		error_lbl_location.setBounds(365, 182, 414, 14);
		panel_find.add(error_lbl_location);
		
		JLabel error_lbl_animal = new JLabel("");
		error_lbl_animal.setForeground(Color.RED);
		error_lbl_animal.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		error_lbl_animal.setBounds(365, 273, 414, 14);
		panel_find.add(error_lbl_animal);
		
		JLabel error_lbl_serviceP = new JLabel("");
		error_lbl_serviceP.setForeground(Color.RED);
		error_lbl_serviceP.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		error_lbl_serviceP.setBounds(365, 364, 414, 14);
		panel_find.add(error_lbl_serviceP);
		
		JComboBox cbox_location = new JComboBox();
		cbox_location.setForeground(new Color(255, 204, 0));
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
		error_lbl_age.setBounds(365, 455, 414, 14);
		panel_find.add(error_lbl_age);
		
		cbox_location.setBackground(Color.DARK_GRAY);
		cbox_location.setBounds(365, 155, 414, 22);
		panel_find.add(cbox_location);
		cbox_location.setFont(new Font("Arial", Font.PLAIN, 13));
		cbox_location.setModel(new DefaultComboBoxModel(new String[] {"- - - select - - -", "Kolkata", "Dum Dum", "Salt Lake", "New Town", "Alipurduar", "Bankura", "Birbhum", "Cooch Behar", "Dakshin Dinajpur (South Dinajpur)", "Darjeeling", "Hooghly", "Howrah", "Jalpaiguri", "Jhargram", "Kalimpong", "Kolkata", "Malda", "Murshidabad", "Nadia", "North 24 Parganas", "Paschim Medinipur (West Medinipur)", "Paschim (West) ", "Burdwan (Bardhaman)", "Purba Burdwan (Bardhaman)", "Purba Medinipur (East Medinipur)", "Purulia", "South 24 Parganas", "Uttar Dinajpur (North Dinajpur)"}));
		
		JComboBox cbox_animal = new JComboBox();
		cbox_animal.setForeground(new Color(255, 204, 0));
		cbox_animal.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (cbox_animal.getSelectedIndex() == 0)
					error_lbl_animal.setText("*Please select Animal");
				else
					error_lbl_animal.setText("");
			}
		});
		
		cbox_animal.setBackground(Color.DARK_GRAY);
		cbox_animal.setBounds(365, 246, 414, 22);
		panel_find.add(cbox_animal);
		cbox_animal.setFont(new Font("Arial", Font.PLAIN, 13));
		cbox_animal.setModel(new DefaultComboBoxModel(new String[] {"- - - select - - -", "Bird", "Cat", "Dog", "Hamster", "Rabbit", "Fish"}));
		
		JComboBox cbox_serviceP = new JComboBox();
		cbox_serviceP.setForeground(new Color(255, 204, 0));
		cbox_serviceP.setBackground(Color.DARK_GRAY);
		cbox_serviceP.setBounds(365, 337, 414, 22);
		panel_find.add(cbox_serviceP);
		cbox_serviceP.setFont(new Font("Arial", Font.PLAIN, 13));
		cbox_serviceP.setModel(new DefaultComboBoxModel(new String[] {"- - - select - - -", "NGO", "VET", "PARAVET", "GROMMER"}));
		cbox_serviceP.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (cbox_serviceP.getSelectedIndex() == 0)
					error_lbl_serviceP.setText("*Please select Service Provider");
				else
					error_lbl_serviceP.setText("");
			}
		});
		
		txt_age = new JTextField();
		txt_age.setForeground(new Color(255, 204, 0));
		txt_age.setBackground(Color.DARK_GRAY);
		txt_age.setBounds(365, 428, 414, 22);
		panel_find.add(txt_age);
		txt_age.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_age.setColumns(10);
		
		JLabel lbl_location = new JLabel("Select Location : ");
		lbl_location.setIcon(new ImageIcon(AdoptUI.class.getResource("/img/location5.png")));
		lbl_location.setForeground(new Color(153, 0, 0));
		lbl_location.setBounds(152, 155, 150, 22);
		panel_find.add(lbl_location);
		lbl_location.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lbl_animal = new JLabel("Select Animal : ");
		lbl_animal.setIcon(new ImageIcon(AdoptUI.class.getResource("/img/animal.png")));
		lbl_animal.setForeground(new Color(153, 0, 0));
		lbl_animal.setBounds(152, 246, 136, 22);
		panel_find.add(lbl_animal);
		lbl_animal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lbl_serviceP = new JLabel("Select Service Provider : ");
		lbl_serviceP.setIcon(new ImageIcon(AdoptUI.class.getResource("/img/sp2.png")));
		lbl_serviceP.setForeground(new Color(153, 0, 0));
		lbl_serviceP.setBounds(152, 337, 217, 22);
		panel_find.add(lbl_serviceP);
		lbl_serviceP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lbl_age = new JLabel("Enter Age : ");
		lbl_age.setIcon(new ImageIcon(AdoptUI.class.getResource("/img/age.png")));
		lbl_age.setForeground(new Color(153, 0, 0));
		lbl_age.setBounds(152, 428, 115, 22);
		panel_find.add(lbl_age);
		lbl_age.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel heading_lbl = new JLabel("ADOPT");
		heading_lbl.setForeground(new Color(204, 0, 0));
		heading_lbl.setBounds(416, 50, 96, 22);
		panel_find.add(heading_lbl);
		heading_lbl.setFont(new Font("Dialog", Font.BOLD, 25));
		
		JButton btn_find = new JButton("FIND");
		btn_find.setForeground(new Color(204, 0, 0));
		btn_find.setBackground(new Color(255, 255, 204));
		btn_find.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_find.setBounds(407, 511, 115, 38);
		panel_find.add(btn_find);
		btn_find.setIcon(new ImageIcon(AdoptUI.class.getResource("/img/find6.png")));
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
                                        //Issue #1
				        //Title - 2.4 : Adopt -> 2 : Adopt Page - Release 0.1 #1
					//-------------------------------------------- Handled by Aadriza Sen Sharma
					else if(txt_age.getText().isEmpty()==false && (Integer.parseInt(txt_age.getText())<=0 || Integer.parseInt(txt_age.getText())>=20))
						error_lbl_age.setText("*Please Enter Age correctly (it must be within 0 and 20)");
					else if(error_lbl_serviceP.getText().equals("") && error_lbl_animal.getText().equals("") && error_lbl_location.getText().equals(""))
					{
						panel_find.setVisible(false);
						panel_show.setVisible(true);
                                                error_lbl_age.setText("");
					}
                                        else
						error_lbl_age.setText("");
																			
					String animal = null, location = null, spUsername = null;
					int age = 0;
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
					model.setRowCount(0);															
					if(res.isEmpty()==false) 
					{
						model.addRow(new Object[]{});
						for (int i = 0; i < res.size(); i++)
						{
							model.addRow(new Object[]{
						                res.get(i).getAnimal(),
						                res.get(i).getSpUsername(),
						                res.get(i).getLocation(),
						                res.get(i).getAge(),
						                res.get(i).getNeeds(),
						                res.get(i).getDiseases(),
						                res.get(i).getCriteria()
						                });
						}
						lbl_no_match.setVisible(false);
					}
					else
						lbl_no_match.setVisible(true);
					mgr.getAppealManager().getAdoptionManager().save("adoptionlist.csv");
				}
				catch(NumberFormatException ex)
				{		
					error_lbl_age.setText("*Please Enter Age correctly (It must be a number)");
				}
			}
		});
		JSeparator sept_find = new JSeparator();
		sept_find.setForeground(new Color(153, 0, 0));
		sept_find.setBounds(0, 102, 919, 2);
		panel_find.add(sept_find);
		
		JLabel lbl_bg_find = new JLabel("");
		lbl_bg_find.setIcon(new ImageIcon(AdoptUI.class.getResource("/img/bg6.PNG")));
		lbl_bg_find.setBounds(-23, 11, 942, 586);
		panel_find.add(lbl_bg_find);
		
		panel_show.setLayout(null);
		panel_show.setBounds(-30, -12, 973, 610);
		frm_adopt.getContentPane().add(panel_show);
		
		JLabel lbl_matches = new JLabel("MATCHES FOUND");
		lbl_matches.setForeground(new Color(204, 0, 0));
		lbl_matches.setFont(new Font("Dialog", Font.BOLD, 25));
		lbl_matches.setBounds(377, 50, 218, 21);
		panel_show.add(lbl_matches);
		
		JButton btn_ok = new JButton("Exit");
		btn_ok.setForeground(new Color(0, 153, 0));
		btn_ok.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_ok.setBackground(new Color(255, 255, 204));
		btn_ok.setBounds(691, 469, 84, 35);
		panel_show.add(btn_ok);
		btn_ok.setIcon(new ImageIcon(AdoptUI.class.getResource("/img/yes.png")));
		btn_ok.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frm_adopt.setVisible(false);
			}
		});
		
		JButton btn_back = new JButton("Back");
		btn_back.setForeground(new Color(204, 0, 0));
		btn_back.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_back.setBackground(new Color(255, 255, 204));
		btn_back.setBounds(183, 469, 84, 35);
		panel_show.add(btn_back);	
		btn_back.setIcon(new ImageIcon(AdoptUI.class.getResource("/img/back.png")));
		btn_back.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				panel_find.setVisible(true);
                                //Issue #2
				//Title - 2.4 : Adopt -> 4 : Back - Release 0.1 #2
				//-------------------------------------------- Handled by Aadriza Sen Sharma
				for (int i = 0; i < table.getRowCount()-1; i++)
				{
					table.setValueAt((Object)"",i+1,0);
					table.setValueAt((Object)"",i+1,1);
					table.setValueAt((Object)"",i+1,2);																								
					table.setValueAt((Object)"",i+1,3);
					table.setValueAt((Object)"",i+1,4);
					table.setValueAt((Object)"",i+1,5);
					table.setValueAt((Object)"",i+1,6);
				}
				res.clear();
				panel_show.setVisible(false);
			}
		});															
		
		JSeparator sept_find_1 = new JSeparator();
		sept_find_1.setForeground(new Color(153, 0, 0));
		sept_find_1.setBounds(27, 102, 919, 2);
		panel_show.add(sept_find_1);
		
		lbl_no_match.setIcon(new ImageIcon(AdoptUI.class.getResource("/img/6.png")));
		lbl_no_match.setBounds(-40, 11, 1003, 573);
		panel_show.add(lbl_no_match);
		lbl_no_match.setVisible(false);
		
		JSeparator sept_find_2 = new JSeparator();
		sept_find_2.setForeground(new Color(153, 0, 0));
		sept_find_2.setBounds(122, 225, 728, 2);
		panel_show.add(sept_find_2);
		
		
		scrollPane.setBounds(139, 202, 694, 233);
		panel_show.add(scrollPane);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		table.setBorder(null);
		table.setSelectionBackground(new Color(255, 99, 71));
		table.setShowHorizontalLines(false);
		table.setModel(model);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(73);
		table.getColumnModel().getColumn(1).setPreferredWidth(74);
		table.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(new Color(255,204,0));
		//table.getTableHeader().setDefaultRenderer(renderer);
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.getTableHeader().setForeground(new Color(128, 0, 0));
		table.getTableHeader().setBackground(new Color(255, 255, 204));
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(128, 0, 0));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(122, 181, 728, 45);
		panel_show.add(panel);
		
		JLabel lbl_bg_show = new JLabel("");
		lbl_bg_show.setIcon(new ImageIcon(AdoptUI.class.getResource("/img/bg6.PNG")));
		lbl_bg_show.setBounds(13, 11, 947, 588);
		panel_show.add(lbl_bg_show);							
	}
}