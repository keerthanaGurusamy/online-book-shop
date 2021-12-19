package com.onlinebookshop.test;

import java.util.List;
import java.util.Scanner;

import com.onlinebookshop.dao.ProductsDao;
import com.onlinebookshop.dao.UserDao;
import com.onlinebookshop.model.Products;
import com.onlinebookshop.model.User;

public class Testmain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("\tWelcome to Online Book Shop");
		System.out.println("\n1.Register\n2.Login\n3.Delete\nEnter your Choice :");
		int choice = Integer.parseInt(scan.nextLine());

		UserDao userDao = null;
		switch (choice) 
		{
		case 1:

			userDao = new UserDao();

			// name
			System.out.println("Enter user Name:");
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
			System.out.println("Enter Phone Number:");
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
			System.out.println("Enter address");
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
			System.out.println("Enter email ID:");
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
			System.out.println("Enter password:");
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
			
        //LOG IN
		case 2:
			userDao = new UserDao();
			System.out.println("User Login ");
			System.out.println("Enter the registered mail ID");
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
			System.out.println("Enter password:");
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
			
			if(validAdmin!=null) {
				System.out.println("Welcome admin");
				System.out.println("\n1.Add Books");
				
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
				String Description = scan.nextLine();
				do{
					if(Description.matches("[A-Z a-z]{6,}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid Description : ");
						category = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				System.out.print("Publisher_id :");
				String Publisher_id = scan.nextLine();
				do{
					if(Publisher_id.matches("[0-9]{2,5}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid Publisher_id : ");
						category = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				int publisher=Integer.parseInt(Publisher_id);
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
						System.out.println("Enter valid book_title : ");
						category = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				System.out.print("book_code :");
				String book_code = scan.nextLine();
				do{
					if(book_title.matches("[A_Z]+[0-9]{2,5}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid book_title : ");
						category = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				System.out.print("price :");
				String price = scan.nextLine();
				do{
					if(price.matches("[0-9]+"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid price : ");
						category = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				System.out.print("publish_date :");
				String publish_date = scan.nextLine();
				do{
					if(publish_date.matches("[0-9]{8,10}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid publish_date : ");
						category = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				System.out.print("Condition :");
				String Condition = scan.nextLine();
				do{
					if(Condition.matches("[A-Za-z]{3,10}"))
					{
						flag = 0;
						break;
					}
					else
					{
						System.out.println("Enter valid Condition : ");
						category = scan.nextLine();
						flag = 1;
					}
				}while( flag == 1); 
				
					ProductsDao prodao=new ProductsDao();
					Products product = new Products();
					prodao.insertBooks(product);
					
				}
			else if(currentUser!=null) {
				System.out.println("Welcome\t"+currentUser.getName());
				flag=1;
				
				System.out.println("\n1.Show Products\n2.update details");
			    int userChoice=Integer.parseInt(scan.nextLine());
			    
			    switch(userChoice)
			    {
			    case 1:
			    
			    ProductsDao proDao=new ProductsDao();
			    List<Products> l_pro =proDao.showProduct();
				for(int i=0;i<l_pro.size();i++)
				{
					System.out.println(l_pro.get(i));
					
				}
			    case 2:
			    	//UPDATE DETAILS
					System.out.println("Enter update details");
					String updates=scan.nextLine();
					userDao.update(updates);
			    }		
			}
				else
					flag=0;
			}while(flag==0);
		
				
				
		case 3:
				//DELETE DETAILS
				System.out.println("Enter delete Details");
				String delete=scan.nextLine();
				userDao.deletedDetails(delete);
				
			    
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