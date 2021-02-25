package AWS;
import java.awt.EventQueue;
import java.io.*;
import java.util.*;
/**
 * @author Aadriza Sen Sharma
 */


public class AdoptionManager 
{
	private ArrayList<AdoptionAppeal> adoptappeal,found;
	AppealManager myAppeal;
	public AdoptionManager(AppealManager myAppeal)
	{
		adoptappeal = new ArrayList<AdoptionAppeal>();
		found = new ArrayList<AdoptionAppeal>();
		this.myAppeal = myAppeal;
	}
	
	//getdetails()
	public boolean init(String filename)
	{
		boolean result = false;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			while((line=br.readLine())!=null)
	        {
				String animal = null, spUsername = null, location = null, needs = null, diseases = null, criteria = null; 
				int age = 0,c=0;
				StringTokenizer st = new StringTokenizer(line,"|");
				while(st.hasMoreTokens())
				{
					switch (c) 
        			{ 
            			case 0:
            				animal=st.nextToken();
            				c++;
            				break;
            			case 1:
            				spUsername=st.nextToken();
            				c++;
            				break; 
            			case 2:
            				location=st.nextToken();
            				c++;
            				break; 
            			case 3:
            				age=Integer.valueOf(st.nextToken()); 
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
                            c=0;
                            break;
            			default:break;
        			}
				}
				adoptappeal.add(new AdoptionAppeal(animal,spUsername,location,age,needs,diseases,criteria));
			}
			br.close();
			result  = true;
		}
		catch (FileNotFoundException e) 
        {
                System.out.println("Error : File Not Found");
        } 
        catch (IOException e) 
        {
                System.out.println("Error : IO Exception");              
        }
		//System.out.println("Printing adopt : \n"+adoptappeal);
		return result;
	}
	
	public AdoptionAppeal find(int a) 
	{
		return new AdoptionAppeal(adoptappeal.get(a).getAnimal(),adoptappeal.get(a).getSpUsername(),adoptappeal.get(a).getLocation(),adoptappeal.get(a).getAge(),adoptappeal.get(a).getNeeds(),adoptappeal.get(a).getDiseases(),adoptappeal.get(a).getCriteria());
	}
	
	//search()
	public ArrayList<AdoptionAppeal>  searchAdoptionAppeal(String an,String sp,String l,int a)
	{
		found = new ArrayList<AdoptionAppeal>();
		for(int i=0;i<adoptappeal.size();i++)
		{
			if(adoptappeal.get(i).getAnimal().equals(an) && adoptappeal.get(i).getSpUsername().equals(sp) && adoptappeal.get(i).getLocation().equals(l) && adoptappeal.get(i).getAge()==a)
				found.add(find(i));
		}
		//System.out.println("\nPrinting adoptionlist : \n"+found);
		return found;
	}
	public ArrayList<AdoptionAppeal>  searchAdoptionAppeal(String an,String sp,String l)
	{
		for(int i=0;i<adoptappeal.size();i++)
		{
			if(adoptappeal.get(i).getAnimal().equals(an) && adoptappeal.get(i).getSpUsername().equals(sp) && adoptappeal.get(i).getLocation().equals(l))
				found.add(find(i));
		}
		//System.out.println("\nPrinting adoptionlist : \n"+found);
		return found;
	}
	public List<AdoptionAppeal> getDetails() 
    {
        return this.adoptappeal;
    }
	public List<AdoptionAppeal> getSearchDetails()
    {
        return this.found;
    }
	//updateList()
	public boolean  save(String filename)
	{
		boolean result = false;
		try
		{
			BufferedWriter bw=new BufferedWriter(new FileWriter(filename));
			bw.write("Matches Found : ");
			bw.write(found.toString().replaceAll("\\p{P}", ""));
			bw.close();
			result = true;
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