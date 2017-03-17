
public class Person {

	private String name;
	private int age;
	private String jobTitle;

	public Person(String name, int age, String jobTitle) {
		super();
		this.name = name;
		this.age = age;
		this.jobTitle = jobTitle;
	}
	
	public Person(){
		
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getName() {
		return name;
	}

	public String personContents() {
		return "Name: " + this.name + " Age: " + this.age + " JobTitle: "
				+ this.jobTitle;
	}

}

