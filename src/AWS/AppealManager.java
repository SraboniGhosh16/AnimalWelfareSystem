package AWS;

/**
 *
 * @author Sraboni
 */
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
public class AppealManager 
{
    public ArrayList<DonationAppeal> donationAppeals;
    public ArrayList<AdoptionAppeal> adoptionAppeals;
    private ArrayList<DonationAppeal> donateappeal,foundD;
    private ArrayList<AdoptionAppeal> adoptappeal,foundA;
    private AppealManager myAppeal;
    private AdoptionManager myAdopt;
    private DonationManager myDonate;
    
    public void initial(AppealManager myAppeal,AdoptionManager myAdopt,DonationManager myDonate) 
    {
    	this.myAppeal = myAppeal;
    	this.myAdopt = myAdopt;
    	this.myDonate = myDonate;    	
	}
	public AdoptionManager getAdoptionManager()
	{
		return myAdopt;
	}
	public DonationManager getDonationManager()
	{
		return myDonate;
	}
    public List<DonationAppeal> initDA(String filename){
        donationAppeals = new ArrayList<DonationAppeal>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            while((line = br.readLine()) !=  null)
            {
                double amount = 0; String cause = null, spUsername = null;
                int c=0;
                
                StringTokenizer st = new StringTokenizer(line,"|");
                while(st.hasMoreTokens())
                {
                    switch(c)
                    {
                        case 0:
                            amount = Double.valueOf(st.nextToken());
                            c++;
                            break;
                        case 1:
                            cause = st.nextToken();
                            c++;
                            break;
                        case 2:
                            spUsername = st.nextToken();
                            c++;
                            break;
                        default:
                            break;
                    }
                }
                DonationAppeal da = new DonationAppeal(amount, cause, spUsername);
                donationAppeals.add(da);
            } 
            br.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error : File Not Found");
        }
        catch (IOException e)
        {
            System.out.println("Error : IO Exception");
        }
        //System.out.println(donationAppeals);
        return donationAppeals;
    }
    public boolean addDonationAppeal(String filename, double amount, String cause, String spUsername)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
            DonationAppeal newDA = new DonationAppeal(amount, cause, spUsername);
            donationAppeals.add(newDA);
            String str = newDA.toString();
            bw.write(str);
            bw.close();
        }
        catch(IOException e){
            System.out.println("Error : IO Exception");
        }
        return true;
    }
    public List<DonationAppeal> getDonationDetails() {
        List<DonationAppeal> result;
        result = Collections.unmodifiableList(this.donationAppeals);
        return result;
    }
    public boolean HouseKeepingDA()
    {
    	boolean result = false;
    	
    	return result;
    }
    public List<AdoptionAppeal> initAA(String filename){
        adoptionAppeals = new ArrayList<AdoptionAppeal>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            while((line = br.readLine()) !=  null)
            {
                String animal = null, location = null, needs = null, diseases = null, criteria = null, spUsername = null;
                int age = 0, c=0;
                StringTokenizer st = new StringTokenizer(line,"|");
                while(st.hasMoreTokens())
                {
                    switch(c){
                        case 0:
                            animal = st.nextToken();
                            c++;
                            break;
                        case 1:
                            spUsername = st.nextToken();
                            c++;
                            break;
                        case 2:
                            location = st.nextToken();
                            c++;
                            break;
                        case 3:
                            age = Integer.valueOf(st.nextToken());
                            c++;
                            break;
                        case 4:
                            needs = st.nextToken();
                            c++;
                            break;
                        case 5:
                            diseases = st.nextToken();
                            c++;
                            break;
                        case 6:
                            criteria = st.nextToken();
                            c++;
                            break;
                        default:
                            break;
                    }
                }
                AdoptionAppeal aa = new AdoptionAppeal(animal, spUsername, location, age, needs, diseases, criteria);
                adoptionAppeals.add(aa);
            } 
            br.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error : File Not Found");
        }
        catch (IOException e)
        {
            System.out.println("Error : IO Exception");
        }
        //System.out.println(adoptionAppeals);
        return adoptionAppeals;
    }
    public boolean addAdoptionAppeal(String filename, String animal, String spUsername, int age, String location, String needs, String diseases, String criteria)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
            AdoptionAppeal newAA = new AdoptionAppeal(animal, spUsername, location, age, needs, diseases, criteria);
            adoptionAppeals.add(newAA);
            String str = newAA.toString();
            bw.write(str);
            bw.close();
        }
        catch(IOException e)
        {
            System.out.println("Error : IO Exception");
        }
        return true;
    }
    public List<AdoptionAppeal> getAdoptionDetails() 
    {
        return this.adoptionAppeals;
    }
    public boolean doHousekeeping() 
    {
    	boolean result = false;
    	try
        {
    		BufferedWriter bw = new BufferedWriter(new FileWriter("adoptionlist.csv"));
    		bw.flush();
    		bw.close();
    		bw = new BufferedWriter(new FileWriter("donationlist.csv"));
    		bw.flush();
    		bw.close();
    		/*bw = new BufferedWriter(new FileWriter("adoptappeal.csv"));
    		bw.flush();
    		bw.close();
    		bw = new BufferedWriter(new FileWriter("donateappeal.csv"));
    		bw.flush();
    		bw.close();*/
    		result = true;
        }
    	catch(IOException e)
        {
            System.out.println("Error : IO Exception");
        }
		return result;
	}
    public static void main(String args[])
    {

    	//Instantiate Manager
    	AppealManager myAppeal = new AppealManager();
    	AdoptionManager myAdopt = new AdoptionManager(myAppeal);
    	DonationManager myDonate = new DonationManager(myAppeal);	
    	myAppeal.initial(myAppeal,myAdopt,myDonate);
    	DisplayManager mgr = new DisplayManager(myAppeal);
    	
    	
    	//Initialise
    	myAdopt.init("adoptappeal.csv");
    	myDonate.init("donateappeal.csv");
    	myAppeal.initAA("adoptappeal.csv");
    	myAppeal.initDA("donateappeal.csv");
    	
		
    	//Work with Screens
    	mgr.createScreens();
    	mgr.showScreen1();
		//mgr.showScreen2();
		//mgr.showScreen3();
		//mgr.showScreen4();
		//mgr.exitAWS();
      	
    	/*
    	//Unit Tests Appeal Manager
        assert(myAppeal.getDonationDetails().size() == 9);
        myAppeal.addDonationAppeal("donateappeal.csv", 5000.0, "Caring", "VET");
        assert(myAppeal.getDonationDetails().size() == 10);
        
        assert(myAppeal.getAdoptionDetails().size() == 9);
        myAppeal.addAdoptionAppeal("adoptappeal.csv", "Dog", "Saltlake", 1, "Care", "NA", "NA", "Blue");
        assert(myAppeal.getAdoptionDetails().size() == 10);
        
        //Unit Tests Adoption Manager
      	assert(myAdopt.getDetails().size()==10);
      		
      	AdoptionAppeal ap = myAdopt.find(0);
      	assert(ap.getAnimal().equals("Dog"));
      		
      	ArrayList<AdoptionAppeal> aa  = myAdopt.searchAdoptionAppeal("Cat","NGO","Kolkata",5);
      	assert(aa.get(0).getAnimal().equals("Cat"));
      	assert(aa.get(0).getSpUsername().equals("NGO"));
      	assert(aa.get(0).getLocation().equals("Kolkata"));
      	assert(aa.get(0).getAge() == 5);
      		
      	ArrayList<AdoptionAppeal> ab  = myAdopt.searchAdoptionAppeal("Cat","NGO","Kolkata");
      	assert(ab.get(0).getAnimal().equals("Cat"));
      	assert(ab.get(0).getSpUsername().equals("NGO"));
      	assert(ab.get(0).getLocation().equals("Kolkata"));
      		
      	myAdopt.save("adoptiontionlist.csv");
      	assert(myAdopt.getSearchDetails().size()==3);
      	
        //Unit Tests Donation Manager
      	assert(myDonate.getDetails().size()==10);
      		
      	ArrayList<DonationAppeal>db=myDonate.searchDonationAppeal("Feeding","NGO");
      	assert(db.get(1).getCause().equals("Feeding"));
      	assert(db.get(1).getServiceProvider().equals("NGO"));
      		
      	DonationAppeal dp=myDonate.find(0);
      	assert(dp.getCause().equals("Feeding"));
      	ArrayList<DonationAppeal>da=myDonate.searchDonationAppeal("Feeding");
      	assert(da.get(0).getCause().equals("Feeding"));
      		
      	myDonate.save("donationlist.csv");
      	assert(myDonate.getSearchDetails().size()==2);
        */
    }
}