package ssa.employee;

public class Mainline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Mickey Mouse");
		employee.setGradeLevel("GS-5");
		System.out.println("Name is " + employee.getName() + " grade is " + employee.getGradeLevel());
		
		Manager manager = new Manager();
		manager.setId(2);
		manager.setName("Donald Duck");
		manager.setGradeLevel("GS-15");
		manager.getHasParkingPriv();
		System.out.println("Manager " + manager.getName() + " has parking priv " + manager.getHasParkingPriv()
							+ " grade is " + manager.getGradeLevel());
		
		manager.print();
	}

	
}
