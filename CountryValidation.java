package SeleniumPackage;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CountryValidation 
{
	String Country = "CountryName"; // Please provide country name here
	
	public static void main(String[] args) 
	{
		CountryValidation CV = new CountryValidation();
		CV.testCounty();
	}
	
	public void testCounty()
	{	
		RestAssured.basePath = "http://restcountries.eu/rest/v1";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "http://restcountries.eu/rest/v1/name/"+Country);
		String responseBody = response.getBody().asString();
		if(response.getStatusCode() == 404)
		{ 
			System.out.println(Country + " Country doesn't exist.");
		}
		else {
			if (responseBody.contains("\"name\":"+"\""+Country+"\""))
			{
				System.out.println(Country + " Country exist.");
			}
			else
			{
				System.out.println(Country + " is not a valid Country name however "+ Country + " word contain in the following Country.");
			}
			System.out.println("\n"+responseBody.toString());				
		}
	} 
}