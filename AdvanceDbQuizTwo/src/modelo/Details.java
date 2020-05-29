package modelo;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.io.Serializable;

public class Details implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5302830493777198637L;

	private int userId;

	private String lastName;

	private String firstName;

	private String middleName;

	private int edad;

	public Details() {}

	public Details(int userId, String lastName, String firstName, 
			String middleName, int course) {
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.edad = edad;
	}




	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	int array;
	int a = 0;
	int b = 0;
	int c = 1;



	int Age;
	int Age2;

	public  int AgeCheck(int edadIns) {
		if(a % 2==0){
			System.out.println("The last number is even " + a);
		}

		else  {
			Age = (edadIns / 4 * 3);
			System.out.println("The last number is odd " + a);
		}
		return Age;
	}



	public int fibo(int edadIns) {
		// TODO Auto-generated method stub
		System.out.print("Fibonacci Series:");
		array = edadIns;
		int[] series = new int[array];
		for(int i = 1; i <= array; i++)
		{
			a = b;
			b = c;
			c = a + b;
			System.out.print(a+ " ");
		} 
		return array;
	}



	public void check(int arr[] , int toCheckValue, int toCheckValue1) {
		boolean test = IntStream.of(arr).anyMatch(x -> x == toCheckValue); 
		System.out.println("Length of the Lastname And Middlename " + toCheckValue + " exists in the Fibonacci Sequence: " + test); 

		boolean test1 = IntStream.of(arr).anyMatch(x -> x == toCheckValue1); 
		System.out.println("Length of Lastname + Middlename + Firstname " + toCheckValue1 + " exists in the Fibonacci Sequence: " + test1); 

		if(test == true) {
			System.out.println("");
			System.out.println("**************");
			System.out.println("Inserting");
			System.out.println("Lastname: " + lastName);
			System.out.println("Middlename: " + middleName);
			System.out.println("Firstname: " + firstName);
			System.out.println("**************");
			System.out.println("");
		}
		else if (test1 == true) {
			System.out.println("");
			System.out.println("**************");
			System.out.println("Reverse:");
			String reverse = new StringBuffer(lastName).reverse().toString();
			String reverse1 = new StringBuffer(middleName).reverse().toString();
			String reverse2 = new StringBuffer(firstName).reverse().toString();
			System.out.println("Lastname: "+ reverse);
			System.out.println("Middlename: " + reverse1);
			System.out.println("Firstname: " + reverse2);
			System.out.println("Age: " + Age);
			System.out.println("**************");
			System.out.println("");
		}
		else if(test1 == false) {
			String mname = null;
			this.middleName = mname;
			System.out.println("");
			System.out.println("**************");
			System.out.println("Insert all the details without middlename");
			System.out.println("Lastname " + lastName);
			System.out.println("Firstname " + firstName);
			System.out.println("Age " + Age);
			System.out.println("**************");
			System.out.println("");
		}
	}



}
