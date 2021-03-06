package AWS;
/**
 * @author Aadriza Sen Sharma, Sraboni Ghosh
 */

public class AdoptionAppeal 
{

	private String animal;
	private String spUsername;
	private String location;
	private int age;
	private String needs;
	private String diseases;
	private String criteria;
	
	public String getAnimal()
	{
		return this.animal;
	}
	public String getSpUsername()
	{
		return this.spUsername;
	}
	public String getLocation()
	{
		return this.location;
	}
	public int getAge()
	{
		return this.age;
	}
	public String getNeeds(){
        return needs;
    }
    public String getDiseases()
    {
        return diseases;
    }
    public String getCriteria()
    {
        return criteria;
    }
	//constructor
	public AdoptionAppeal(String animal, String spUsername, String location, int age, String needs, String diseases, String criteria) 
	{
		this.animal = animal;
		this.spUsername = spUsername;
		this.location = location;
		this.age = age;
		this.needs = needs;
		this.diseases = diseases;
		this.criteria = criteria;
	}
	//toString
	public String toString() 
	{
		return  "\n"+animal + "|" + spUsername + "|" + location + "|" + age+ "|" + needs + "|" + diseases + "|" + criteria;
	}
	
}