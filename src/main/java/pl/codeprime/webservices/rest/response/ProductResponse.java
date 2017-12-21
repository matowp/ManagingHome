/**
 * 
 */
package pl.codeprime.webservices.rest.response;

/**
 * @author MOwsians
 *
 */
public class ProductResponse {
	
	
	public static ProductResponse createEmpty() {
		return new ProductResponse("", "");
	}
	
	private String name;
	private String department;
	
	public ProductResponse(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
