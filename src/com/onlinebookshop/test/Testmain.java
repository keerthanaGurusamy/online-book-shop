package com.onlinebookshop.test;

import java.util.List;
import java.util.Scanner;

import com.onlinebookshop.dao.BookdetailsDao;
import com.onlinebookshop.dao.UserDao;
import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.User;

public class Testmain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("\tWelcome to Online Book Shop");
		System.out.println("\n1.Register\n2.Login\nEnter your Choice :");
		int choice = Integer.parseInt(scan.nextLine());

		UserDao userDao = null;
		switch (choice) 
		{
		case 1:

			userDao = new UserDao();

			// name
			System.out.print("Enter user Name:");
			String name = scan.nextLine();
			int flag = 0;
			do {
				if (name.matches("[A-Za-z]{5,}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid name ");
				name = scan.nextLine();
				flag = 1;
			} while (flag == 1);

			// phone number
			System.out.print("Enter Phone Number:");
			String phno = scan.nextLine();
			do {
				if (phno.matches("[6-9][0-9]{9}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid Phone no:");
				phno = scan.nextLine();
				flag = 1;
			} while (flag == 1);
			long phoneNo = Long.parseLong(phno);

			// Address
			System.out.print("Enter address");
			String address = scan.nextLine();
			do {
				if (address.matches("[A-Za-z0-9]{4,}+[,][A-Za-z]{4,}+[,][0-9]{6}+{20,}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid address");
				address = scan.nextLine();
				flag = 1;
			} while (flag == 1);

			// Email ID
			System.out.print("Enter email ID:");
			String email = scan.nextLine();
			do {
				if (email.matches("[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid email ");
				email = scan.nextLine();
				flag = 1;
			} while (flag == 1);

			// Password
			System.out.print("Enter password:");
			String password = scan.nextLine();
			do {
				if (password.matches("[A-Za-z0-9]{8,10}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid password pattern");
				password = scan.nextLine();
				flag = 1;
			} while (flag == 1);
			User user = new User(name, phoneNo, address, email, password);
			userDao.insertUser(user);
			break;
        //LOG IN
		case 2:
			userDao = new UserDao();
			System.out.println("User Login "); 
			System.out.print("Enter the registered mail ID: ");
			String email_id = scan.nextLine();
			do {
				if (email_id.matches("[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid email ");
				email = scan.nextLine();
				flag = 1;
			} while (flag == 1);
			System.out.print("Enter password: ");
			password=scan.nextLine();
			do {
				if (password.matches("[A-Za-z0-9]{8,10}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid password ");
				password = scan.nextLine();
				flag = 1;
			} while (flag == 1);
			do {
			User currentUser = userDao.validateUser(email_id, password);
			User validAdmin=userDao.admin(email_id, password);
			// Admin Login
			if(validAdmin!=null) {
				System.out.println("Welcome admin");
				System.out.println("\n1.view users\n2.Add Books\n3.Delete Books\n4.Update books\nEnter your choice");
				int choices = Integer.parseInt(scan.nextLine());
				switch(choices)
				{
				case 1:
					userDao=new UserDao();
					List<User> userList = userDao.viewUser();
					for(int i=0;i<userList.size();i++) {
						System.out.println(userList.get(i));
					}
				    break;
				case 2:
				System.out.print("Category :");
				String category = scan.nextLine();
				do{
					if(category.matches("[A-Z a-z]{6,}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid category : ");
						category = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				System.out.print("Description :");
				String description = scan.nextLine();
				do{
					if(description.matches("[A-Z a-z]{6,}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid Description : ");
						description = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				System.out.print("Publisher_id :");
				String publisher = scan.nextLine();
				do{
					if(publisher.matches("[0-9]{2,5}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid Publisher_id : ");
						publisher = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				int publisher_id=Integer.parseInt(publisher);
				System.out.print("book_title :");
				String book_title = scan.nextLine();
				do{
					if(book_title.matches("[A-z a-z]{5,}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid booktitle : ");
						book_title = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				System.out.print("book_code :");
				String book_code = scan.nextLine();
				do{
					if(book_code.matches("[A-Z]+[0-9]{2,5}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid bookcode : ");
						book_code = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				System.out.print("price :");
				String prc = scan.nextLine();
				do{
					if(prc.matches("[0-9]+"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid price : ");
						prc = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				int price = Integer.parseInt(prc);
				System.out.print("publish_date :");
				String publish_date = scan.nextLine();
				do{
					if(publish_date.matches("[0-9]{2}+[-][0-9]{2}+[-][0-9]{4}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid publishdate : ");
						publish_date = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				System.out.print("Condition :");
				String condition = scan.nextLine();
				do{
					if(condition.matches("[A-Za-z]{3,10}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid Condition : ");
						condition = scan.nextLine();
						flag = 1;
					}
					
				}while( flag == 1); 
					BookdetailsDao prodao=new BookdetailsDao();
					Bookdetails product = new Bookdetails(category, description, publisher_id, book_title, book_code,
							price, publish_date, condition);
					prodao.insertBooks(product);
					break;
				case 3:
					prodao=new BookdetailsDao();
					System.out.print("Enter books to delete");
					String delete=scan.nextLine();
					prodao.deleteBooks(delete);
					break;
				case 4:
					prodao=new BookdetailsDao();
					System.out.print("Enter update details ");
					String update=scan.nextLine();
					prodao.updateBooks(update);
					break;
			}
				}
			//Customer Login
				else if(currentUser!=null) {
				System.out.println("Welcome\t"+currentUser.getName());
				flag=1;
				System.out.println("\n1.Show Products\n2.update details\n3.Delete Profile\n4.Find user ID");
			    int userChoice=Integer.parseInt(scan.nextLine());
			    
			    switch(userChoice)
			    {
			    //Show Products
			    case 1:
			    
			    BookdetailsDao proDao=new BookdetailsDao();
			    List<Bookdetails> l_pro =proDao.showProduct();
				for(int i=0;i<l_pro.size();i++)
				{
					System.out.println(l_pro.get(i));
				}
				break;
				//UPDATE Profile
			    case 2:
			    	
					System.out.println("Enter update details");
					String updates=scan.nextLine();
					userDao.update(updates);
					break;
			    case 3:
					//DELETE DETAILS
				    userDao=new UserDao();
					System.out.println("Enter delete Details");
					String delete=scan.nextLine();
					userDao.deletedDetails(delete);
						
			    case 4:
			    	userDao=new UserDao();
			    	System.out.println("Enter email id :");
			    	String emailId =scan.nextLine();
			    	int id =userDao.findUserId(emailId);
			    	System.out.println("Customer id :"+ id);
			    }		
			}
			else
				flag=0;
			}while(flag==0);
		
				
				break;
		
			    
//				System.out.println("\n1.Order Product\n2.View Orders");
//				int orderChoice=Integer.parseInt(scan.nextLine());
//				switch(orderChoice)
//				{
//				case 1:
//					do {
//						for(int i=0;i<l_pro.size();i++)
//							
//						{
//							System.out.println(l_pro.get(i));
//						}
//					System.out.println("Enter the Product Name");
//					String proName=scan.nextLine();
//					for(int i=0;i<l_pro.size();i++)
//					{
//							if(l_pro.get(i).getBook_code().equals(proName))
//							{
//								Products product=l_pro.get(i);
//							}
//					}
//					System.out.println("Enter no of Products needed");
//					int noOf=Integer.parseInt(scan.nextLine());
//					
//					}
			  
			}
		}
}