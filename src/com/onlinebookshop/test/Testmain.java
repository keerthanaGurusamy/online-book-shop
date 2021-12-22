package com.onlinebookshop.test;

import java.util.List;
import java.util.Scanner;

import com.onlinebookshop.dao.AuthorDetailsDao;
import com.onlinebookshop.dao.BookdetailsDao;
import com.onlinebookshop.dao.CartDao;
import com.onlinebookshop.dao.UserdetailsDao;
import com.onlinebookshop.model.AuthorDetails;
import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.Cart;
import com.onlinebookshop.model.Userdetails;

public class Testmain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("\tWelcome to Online Book Shop");
		System.out.println("\n1.Register\n2.Login\nEnter your Choice :");
		int choice = Integer.parseInt(scan.nextLine());

		UserdetailsDao userDao = null;
		switch (choice) {
		case 1:
			userDao = new UserdetailsDao();
			// name
			System.out.print("Enter user Name:");     
			String name = scan.nextLine();
			int flag = 0;
			do {
				if (name.matches("[A-Za-z]{5,}")) 
				{
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
				if (phno.matches("[6-9][0-9]{9}")) 
				{
					flag = 0;
					break;
				} else
					System.out.println("Enter valid Phone no:");
				    phno = scan.nextLine();
				    flag = 1;
			} while (flag == 1);
			long phoneNo = Long.parseLong(phno);
			// Address
			System.out.print("Enter address:");
			String address = scan.nextLine();
			do {
				if (address.matches("[A-Za-z0-9]{4,}+[,][A-Za-z]{4,}+[,][0-9]{6}+{20,}")) 
				{
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
			Userdetails user = new Userdetails(name, phoneNo, address, email, password);
			userDao.insertUser(user);
			break;
		// LOG IN
		case 2:
			userDao = new UserdetailsDao();
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
			password = scan.nextLine();
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
				Userdetails currentUser = userDao.validateUser(email_id, password);
				Userdetails validAdmin = userDao.admin(email_id, password);
				// Admin Login
				if (validAdmin != null) {
					System.out.println("Welcome admin");
					System.out.println(
							"\n1.view users\n2.Delete users\n3.Add Books\n4.Delete Books\n5.Update books\n6.Add authors\n7.update authors\n8.Show authors\nEnter your choice");
					int choices = Integer.parseInt(scan.nextLine());
					switch (choices) {
					case 1:                                                                            					// Show All users
						userDao = new UserdetailsDao();
						List<Userdetails> userList = userDao.viewUser();
						for (int i = 0; i < userList.size(); i++) {
							System.out.println(userList.get(i));
						}
						break;
					case 2:                                                                                             // DELETE User DETAILS
						userDao = new UserdetailsDao();
						System.out.println("Enter delete Details");
						String deleteuser = scan.nextLine();
						userDao.deletedDetails(deleteuser);
						break;
					case 3:                                                                                             // Add Books
						System.out.print("Category :");
						String category = scan.nextLine();
						do {
							if (category.matches("[A-Z a-z]{6,}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid category : ");
								category = scan.nextLine();
								flag = 1;
							}
						} while (flag == 1);
						System.out.print("Description :");
						String description = scan.nextLine();
						do {
							if (description.matches("[A-Z a-z ,]{6,}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid Description : ");
								description = scan.nextLine();
								flag = 1;
							}
						} while (flag == 1);
						System.out.print("Publisher_id :");
						String publisher = scan.nextLine();
						do {
							if (publisher.matches("[0-9]{2,5}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid Publisher_id : ");
								publisher = scan.nextLine();
								flag = 1;
							}
						} while (flag == 1);
						int publisher_id = Integer.parseInt(publisher);
						System.out.print("book_title :");
						String book_title = scan.nextLine();
						do {
							if (book_title.matches("[A-z a-z,]{5,}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid booktitle : ");
								book_title = scan.nextLine();
								flag = 1;
							}
						} while (flag == 1);
						System.out.print("book_code :");
						String book_code = scan.nextLine();
						do {
							if (book_code.matches("[A-Z]+[0-9]{2,5}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid bookcode : ");
								book_code = scan.nextLine();
								flag = 1;
							}
						} while (flag == 1);
						System.out.print("price :");
						String prc = scan.nextLine();
						do {
							if (prc.matches("[0-9]+")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid price : ");
								prc = scan.nextLine();
								flag = 1;
							}
						} while (flag == 1);
						int price = Integer.parseInt(prc);
						System.out.print("publish_date :");
						String publish_date = scan.nextLine();
						do {
							if (publish_date.matches("[0-9]{2}+[-][0-9]{2}+[-][0-9]{4}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid publishdate : ");
								publish_date = scan.nextLine();
								flag = 1;
							}
						} while (flag == 1);
						System.out.print("Condition :");
						String condition = scan.nextLine();
						do {
							if (condition.matches("[A-Za-z]{3,10}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid Condition : ");
								condition = scan.nextLine();
								flag = 1;
							}

						} while (flag == 1);
						BookdetailsDao prodao = new BookdetailsDao();
						Bookdetails product = new Bookdetails(category, description, publisher_id, book_title,
								book_code, price, publish_date, condition);
						prodao.insertBooks(product);
						break;
					case 4:                                                                                // Delete Books
						prodao = new BookdetailsDao();
						System.out.print("Enter books to delete");
						String deletebooks = scan.nextLine();
						prodao.deleteBooks(deletebooks);
						break;
					case 5:                                                                               // Update Books
						prodao = new BookdetailsDao();
						System.out.print("Enter book_title to update details ");
						String bookstitle = scan.nextLine();
						System.out.print("Enter price ");
						int price1 = scan.nextInt();
						prodao.updateBooks(price1, bookstitle);
						break;
					case 6:                                                                                //Author insert
						System.out.print("Enter author name :");
						String author=scan.nextLine();
						
						do {
							if (author.matches("[A-Za-z]{5,}")) 
							{
								flag = 0;
								break;
							} else
								System.out.println("Enter valid name ");
							    author = scan.nextLine();
							    flag = 1;
						} while (flag == 1);
						System.out.print("Enter email_id :");
						String emailId=scan.nextLine();
						do {
							if (emailId.matches("[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}")) {
								flag = 0;
								break;
							} else
								System.out.println("Enter valid email ");
							    emailId = scan.nextLine();
							    flag = 1;
						} while (flag == 1);
						System.out.print("Enter Book id :");
						String bookid=scan.nextLine();
						do {
							if (bookid.matches("[0-9]{2,5}")) {
								flag = 0;
								break;
							} else {
								System.out.println("Enter valid Book_id : ");
								bookid = scan.nextLine();
								flag = 1;
							}
						} while (flag == 1);
						AuthorDetailsDao authordao=new AuthorDetailsDao();
						AuthorDetails authordetails=new AuthorDetails(author,emailId,bookid);
						authordao.insertAuthor(authordetails);
						break;
					case 7:                                                                                 //Author Update
						authordao = new AuthorDetailsDao();
						System.out.print("Enter author name to update :");
						String authorname=scan.nextLine();
						System.out.println("Enter email");
						String authoremail=scan.nextLine();
						authordao.updateAuthor(authoremail, authorname);
						break;
					case 8:                                                                                 //Show Authors
						authordao = new AuthorDetailsDao();
						List<AuthorDetails>  authorList = authordao.showAuthor();
						for (int i = 0; i < authorList.size(); i++) {
							System.out.println(authorList.get(i));
						}
						break;
					}
				}
				// Customer Login
				else if (currentUser != null) {
					System.out.println("Welcome\t" + currentUser.getName());
					flag = 1;
					System.out.println(
							"\n1.Show Products\n2.update Profile\n3.Delete Profile\n4.Find user ID\n5.Find product");
					int userChoice = Integer.parseInt(scan.nextLine());

					switch (userChoice) {
					
					case 1:                                                                             // Show Products
						BookdetailsDao prodao = null;
						prodao = new BookdetailsDao();
						List<Bookdetails> l_pro = prodao.showProduct();
						for (int i = 0; i < l_pro.size(); i++) {
							System.out.println(l_pro.get(i));
						}
						System.out.println("\n1.Order Product\n2.View Orders");
						int orderChoice=Integer.parseInt(scan.nextLine());
						
						switch(orderChoice)
						{
					case 1:
						
							System.out.println("Enter the Product Name");
							String proName=scan.nextLine();
							int id=prodao.findProductid(proName);
							System.out.println("Book ID"+id);
							int price=prodao.findPrice(id);
							
							System.out.println("Enter no of Products needed");
							int quantity=Integer.parseInt(scan.nextLine());
							double totalprice=(double)(quantity*price);
							Cart order=new Cart(id,quantity,totalprice);
							CartDao cartDao=new CartDao();
							cartDao.insertOrder(order);
							break;
							}
						break;
					case 2:                                                                             // UPDATE Profile
						System.out.println("Enter emailid to update password");
						String emailid = scan.nextLine();
						System.out.println("Enter password ");
						String passWord = scan.nextLine();
						userDao.update(email_id, passWord);
						break;
					case 3:                                                                             // DELETE user details
						userDao = new UserdetailsDao();
						System.out.println("Enter delete Details");
						String delete = scan.nextLine();
						userDao.deletedDetails(delete);
						break;
					case 4:                                                                            // Find userId
						userDao = new UserdetailsDao();
						System.out.print("Enter email id :");
						String emailId = scan.nextLine();
						int id = userDao.findUserId(emailId);
						System.out.println("Customer id :" + id);
						break;
					case 5:                                                                           // Find Books
						prodao = new BookdetailsDao();
						System.out.print("Enter book title ");
						String find = scan.nextLine();
						int books = prodao.findProductid(find);
						System.out.println("book id is :" + books);
						break;
					}
				} else
					flag = 0;
				break;
			} while (flag == 0);

			break;
		case 3:
			BookdetailsDao prodao = null;
				System.out.println("\n1.Order Product\n2.View Orders");
				int orderChoice=Integer.parseInt(scan.nextLine());
				CartDao cartDao=null;
				switch(orderChoice)
				{
				case 1:
						
						prodao = new BookdetailsDao();
						List<Bookdetails> l_pro = prodao.showProduct();
						for (int i = 0; i < l_pro.size(); i++) 
						{
							System.out.println(l_pro.get(i));
						}	
					System.out.println("Enter the Product Name");
					String proName=scan.nextLine();
					int id=prodao.findProductid(proName);
					System.out.println("Book ID"+id);
					int price=prodao.findPrice(id);
					
					System.out.println("Enter no of Products needed");
					int quantity=Integer.parseInt(scan.nextLine());
					double totalprice=(double)(quantity*price);
					Cart order=new Cart(id,quantity,totalprice);
					cartDao.insertOrder(order);
					break;
					}

		}
	}
}