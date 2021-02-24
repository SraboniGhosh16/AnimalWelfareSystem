package demo;

/**
*
* @author PROTTASHA
*/
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
public class DonationManager
{
	private ArrayList<DonationAppeal> donateappeal,found;
	private AppealManager myAppeal;
	public DonationManager(AppealManager myAppeal)
	{
		this.myAppeal = myAppeal;
	}
	//getdetails()
	public boolean init(String filename)
	{
		boolean result=false;
		try
		{
			donateappeal = new ArrayList<DonationAppeal>();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			while((line=br.readLine())!=null)
			      {
			String serviceprovider = null, cause = null;
			double amount =0.0;
			int c=0;
			StringTokenizer st = new StringTokenizer(line,"|");
			while(st.hasMoreTokens())
			{
			switch (c)
			       {
			           case 0:
			           amount=Double.parseDouble(st.nextToken());
			           c++;
			           break;
			           case 1:
			           cause=st.nextToken();
			           c++;
			           break;
			           case 2:
			           serviceprovider=st.nextToken();    
			           c=0;
			           break;
			           default:break;
			       }
			}
			donateappeal.add( new DonationAppeal(amount,cause,serviceprovider));
			}
			br.close();
			result=true;
		}
		catch (FileNotFoundException e)
		{
		    System.out.println("Error : File Not Found");
		}
		catch (IOException e)
		{
			System.out.println("Error : IO Exception");              
		}
		//System.out.println("Printing donate:\n"+donateappeal);
		return result;
	}
	
	public DonationAppeal find(int c)
	{
	    return new DonationAppeal(donateappeal.get(c).getAmount(),donateappeal.get(c).getCause(),donateappeal.get(c).getServiceProvider());
	}
	
	//search()
	public ArrayList<DonationAppeal>searchDonationAppeal(String ca)
	{
		found=new ArrayList<DonationAppeal>();    
		for(int i=0;i<donateappeal.size();i++)
		{
			if(donateappeal.get(i).getCause().equals(ca))
			found.add(find(i));
		}
		System.out.println("\nPrinting donationlist:\n"+found);
		
		return found;
	}
	public ArrayList<DonationAppeal>searchDonationAppeal(String ca,String sp)
	{
	   found=new ArrayList<DonationAppeal>();
	   for(int i=0;i<donateappeal.size();i++)
	   {
	       if(donateappeal.get(i).getCause().equals(ca)&& donateappeal.get(i).getServiceProvider().equals(sp))
	       found.add(find(i));
	   }
	   System.out.println("\nPrinting donationlist:\n"+found);
	   
	   return found;
	   
	}
	public List<DonationAppeal> getDetails() 
    {
        return this.donateappeal;
    }
	public List<DonationAppeal> getSearchDetails()
    {
        return this.found;
    }
	//updateList()
	public boolean save(String filename)
	{
		boolean result=false;
		try
		{
			BufferedWriter bw=new BufferedWriter(new FileWriter(filename));
			bw.write("Matches Found:");
			bw.write(found.toString().replaceAll("\\p{P}",""));
			bw.close();
			result=true;
		}
	   catch (FileNotFoundException e)
       {
		   System.out.println("Error : File Not Found");
	   }
	   catch (IOException e)
	   {
		   System.out.println("Error : IO Exception");              
       }
	   return result;
	}
}





