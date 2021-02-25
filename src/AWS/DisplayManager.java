package AWS;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class DisplayManager 
{
    private HomeUI screen0;
	private AdoptUI screen1;
	private DonateUI screen2;
	private AdoptionAppealUI screen3;
	private DonationAppealUI screen4;
	
	private AppealManager myAppeal;
	
	public DisplayManager(AppealManager myAppeal) 
	{
		this.myAppeal = myAppeal;
	}
	public AppealManager getAppealManager()
	{
		return myAppeal;
	}
	
	public void createScreens() 
	{
            screen0 = new HomeUI(this);
		screen1 = new AdoptUI(this);
		screen2 = new DonateUI(this); 
		screen3 = new AdoptionAppealUI(this); 
		screen4 = new DonationAppealUI(this);
    }
        public void showScreen0()
	{
            screen0.setVisible(true);
		screen1.frm_adopt.setVisible(false);
		screen2.setVisible(false);
		screen3.setVisible(false);
		screen4.setVisible(false);
	}
	
	/*public void showScreen1()
	{
		screen1.frm_adopt.setVisible(true);
		screen2.setVisible(false);
		screen3.setVisible(false);
		screen4.setVisible(false);
	}
	
	public void showScreen2()
	{
		screen1.frm_adopt.setVisible(false);
		screen2.setVisible(true);
		screen3.setVisible(false);
		screen4.setVisible(false);
	}
	
	public void showScreen3()
	{
		screen1.frm_adopt.setVisible(false);
		screen2.setVisible(false);
		screen3.setVisible(true);
		screen4.setVisible(false);
	}
	
	public void showScreen4()
	{
		screen1.frm_adopt.setVisible(false);
		screen2.setVisible(false);
		screen3.setVisible(false);
		screen4.setVisible(true);
	}*/
	
	public void exitAWS()
	{
		screen1.frm_adopt.setVisible(false);
		screen2.setVisible(false);
		screen3.setVisible(false);
		screen4.setVisible(false);
		
        if (myAppeal.doHousekeeping()) 
            System.out.println("System shuts down gracefully");
        else 
            System.out.println("System shuts down with error");
		System.exit(0);
	}
	
}
