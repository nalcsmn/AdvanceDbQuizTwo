package Main;


import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;


import modelo.Details;


public class MainProgram {
	static	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {

		boolean check = true;



		while (check == true) {


			System.out.println("	");
			System.out.println("INSERT THE FOLLOWING DETAILS!!");

			System.out.println("Enter Lastname:");
			String lastname = scan.next();
			System.out.println("Enter Firstname:");
			String firstname = scan.next();
			System.out.println("Enter Middlename:");
			String middlename = scan.next();
			System.out.println("Enter Age:");
			int agerz = scan.nextInt();

			Session session = dbutil.getSession();
			Transaction tx = null;

			try {

				tx = session.beginTransaction();
				Details dits = new Details();

				dits.setLastName(lastname);
				dits.setFirstName(firstname);
				dits.setMiddleName(middlename);
				dits.setEdad(agerz);

				Integer id = (Integer) session.save(dits);
				System.out.println(id);
				tx.commit();

			} catch(Exception ex) {

				if(tx != null) {
					tx.rollback();
				}
				ex.printStackTrace();
			}  
			System.out.println("Do you want to add more details [Y/N]");
			String answer = scan.next();

			if (answer.equalsIgnoreCase("Y")) {
				check=true;
			} else {
				Session session1 = dbutil.getSession();
				try {

					String sql = "select * from details";

					Query query = session1.createSQLQuery(sql);
					query.setResultTransformer(Transformers.aliasToBean(Details.class));

					List<Details> studentList = query.list();

					for(Details dits : studentList) {
						System.out.println("Student id: " + dits.getUserId());
						System.out.println("Last Name: " + dits.getLastName());
						System.out.println("First Name: " + dits.getFirstName());
						System.out.println("Middle Name: " + dits.getMiddleName());
						System.out.println("Age: " + dits.getEdad());
						System.out.println();
					}
				} catch(Exception ex) {
					ex.printStackTrace();
				}  
				System.out.println("What do you want to do [Update, Delete or Select]");
				String option = scan.next();

				if (option.equalsIgnoreCase("Update")) {

					System.out.println("What do you want to update (lastname, firstname, middlename, age)");
					String option2 = scan.next();
					System.out.println("Enter the id number");
					int idnum = scan.nextInt();
					System.out.println("Please input new value");
					String value = scan.next();


					if (option2.equalsIgnoreCase("lastname")) {
						Session session2 = dbutil.getSession();
						Transaction tx1 = null;

						try {

							String sql = "select * from details where userId = :userId";
							Query query = session2.createSQLQuery(sql);
							query.setParameter("userId", idnum);
							query.setResultTransformer(Transformers.aliasToBean(Details.class));

							Details studResult = (Details) query.uniqueResult();


							tx1 = session2.beginTransaction();
							studResult.setLastName(value);
							session2.update(studResult);
							// or
							// Student stud = (Student) session.get(Student.class, 1);
							// stud.setMiddleName("Matalino");
							// session.update(stud);
							tx1.commit();

						} catch(Exception ex) {

							if(tx1 != null) {
								tx1.rollback();
							}
							System.out.println("NO record Found");
							main(args);
							ex.printStackTrace();
						}  finally {
							System.out.println("DONE UPDATING");
							main(args);
							session2.close();
						}


					}else if(option2.equalsIgnoreCase("firstname")) {
						Session session3 = dbutil.getSession();
						Transaction tx2 = null;

						try {

							String sql = "select * from details where userId = :userId";
							Query query = session3.createSQLQuery(sql);
							query.setParameter("userId", idnum);
							query.setResultTransformer(Transformers.aliasToBean(Details.class));

							Details studResult = (Details) query.uniqueResult();


							tx2 = session3.beginTransaction();
							studResult.setFirstName(value);
							session3.update(studResult);
							// or
							// Student stud = (Student) session.get(Student.class, 1);
							// stud.setMiddleName("Matalino");
							// session.update(stud);
							tx2.commit();

						} catch(Exception ex) {

							if(tx2 != null) {
								tx2.rollback();
							}
							System.out.println("NO record Found");
							main(args);
							ex.printStackTrace();

						}  finally {
							System.out.println("DONE UPDATING");
							main(args);
							session3.close();
						}

					}else if(option2.equalsIgnoreCase("middlename")) {
						Session session4 = dbutil.getSession();
						Transaction tx3 = null;

						try {

							String sql = "select * from details where userId = :userId";
							Query query = session4.createSQLQuery(sql);
							query.setParameter("userId", idnum);
							query.setResultTransformer(Transformers.aliasToBean(Details.class));

							Details studResult = (Details) query.uniqueResult();


							tx3 = session4.beginTransaction();
							studResult.setMiddleName(value);
							session4.update(studResult);
							// or
							// Student stud = (Student) session.get(Student.class, 1);
							// stud.setMiddleName("Matalino");
							// session.update(stud);
							tx3.commit();

						} catch(Exception ex) {

							if(tx3 != null) {
								tx3.rollback();
							}
							System.out.println("NO record Found");
							main(args);
							ex.printStackTrace();
						}  finally {
							System.out.println("DONE UPDATING");
							main(args);
							session4.close();
						}

					}else if(option2.equalsIgnoreCase("age")) {
						Session session5 = dbutil.getSession();
						Transaction tx4 = null;
						System.out.println("Please input new age");
						int valuez = scan.nextInt();
						try {

							String sql = "select * from details where userId = :userId";
							Query query = session5.createSQLQuery(sql);
							query.setParameter("userId", idnum);
							query.setResultTransformer(Transformers.aliasToBean(Details.class));

							Details studResult = (Details) query.uniqueResult();


							tx4 = session5.beginTransaction();
							studResult.setEdad(valuez);
							session5.update(studResult);
							// or
							// Student stud = (Student) session.get(Student.class, 1);
							// stud.setMiddleName("Matalino");
							// session.update(stud);
							tx4.commit();

						} catch(Exception ex) {

							if(tx4 != null) {
								tx4.rollback();
							}
							System.out.println("NO record Found");
							main(args);
							ex.printStackTrace();
						}  finally {
							System.out.println("DONE UPDATING");
							main(args);
							session5.close();
						}

					}
					return;


				}else if(option.equalsIgnoreCase("delete")){
					Session session6= dbutil.getSession();
					Transaction tx5 = null;
					System.out.println("Enter the id number you want to delete");
					int idnum = scan.nextInt();

					try {

						String sql = "select * from details where userId = :userId";
						Query query = session6.createSQLQuery(sql);
						query.setParameter("userId", idnum);
						query.setResultTransformer(Transformers.aliasToBean(Details.class));

						Details studResult = (Details) query.uniqueResult();

						System.out.println("fetched id: " + studResult.getUserId());

						tx5 = session.beginTransaction();
						session.delete(studResult);
						// or
						// Student stud = (Student) session.get(Student.class, 10);
						// session.delete(stud);
						tx5.commit();

					} catch(Exception ex) {

						if(tx != null) {
							tx.rollback();
						}
						ex.printStackTrace();
					}  finally {
						System.out.println("done delete");
						main(args);
						session6.close();
					}





				}else if(option.equalsIgnoreCase("select")){
					Session session5 = dbutil.getSession();
					try {

						String sql = "select * from details";

						Query query = session5.createSQLQuery(sql);
						query.setResultTransformer(Transformers.aliasToBean(Details.class));

						List<Details> ditsList = query.list();

						for(Details dits : ditsList) {
							System.out.println("Student id: " + dits.getUserId());
							System.out.println("Last Name: " + dits.getLastName());
							System.out.println("First Name: " + dits.getFirstName());
							System.out.println("Middle Name: " + dits.getMiddleName());
							System.out.println("Age: " + dits.getEdad());
							System.out.println();
						}
					} catch(Exception ex) {
						ex.printStackTrace();
					}  finally {

						main(args);
						session5.close();
					}

				}else {
					System.out.println("wrong input!!");
					System.out.println("Re run!!");
					main(args);


				}

			}


		}

	}
}

