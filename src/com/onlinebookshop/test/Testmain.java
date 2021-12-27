package com.onlinebookshop.test;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import com.onlinebookshop.dao.AuthorDetailsDao;
import com.onlinebookshop.dao.BookdetailsDao;
import com.onlinebookshop.dao.OrderDetailsDao;
import com.onlinebookshop.dao.Ratingdao;
import com.onlinebookshop.dao.UserdetailsDao;
import com.onlinebookshop.model.AuthorDetails;
import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.OrderDetails;
import com.onlinebookshop.model.Rating;
import com.onlinebookshop.model.Userdetails;

public class Testmain {

	public static void main(String[] args) throws Exception {
		
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
							"\n1.view users\n2.Delete users\n3.Add Books\n4.Delete Books\n5.Update books\n6.Add authors\n7.update authors\n8.Show authors\n9.Find user id\n10.Find product id\n11.view cart\nEnter your choice");
					int choices = Integer.parseInt(scan.nextLine());
					switch (choices) {
					case 1:                                                                       // Show All users
						userDao = new UserdetailsDao();
						List<Userdetails> userList = userDao.viewUser();
						for (int i = 0; i < userList.size(); i++) {
							System.out.println(userList.get(i));
						}
						break;
					case 2:                                                                        // DELETE User DETAILS
						userDao = new UserdetailsDao();
						System.out.println("Enter delete Details");
						String deleteuser = scan.nextLine();
						userDao.deletedDetails(deleteuser);
						break;
					case 3:                                                                         // Add Books
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
					case 9:                                                                         // Find userId
						userDao = new UserdetailsDao();
						System.out.print("Enter email id :");
						String email_Id = scan.nextLine();
						int id = userDao.findUserId(email_Id);
						System.out.println("Customer id :" + id);
						break;
					case 10:                                                                           // Find Books
						prodao = new BookdetailsDao();
						System.out.print("Enter book title ");
						String find = scan.nextLine();
						int books = prodao.findProductid(find);
						System.out.println("book id is :" + books);
						break;
					case 11:       // View Cart
						 OrderDetailsDao cart=new OrderDetailsDao();
						 List<OrderDetails> cart_list = cart.viewCart();
						 for (int i = 0; i < cart_list.size(); i++) {
					   	System.out.println(cart_list.get(i));
						}
						 break;
					}
				}
				// Customer Login
				else if (currentUser != null) {
					System.out.println("Welcome\t" + currentUser.getName());
					flag = 1;
					boolean flag1 = true;
					while(flag1) {
					System.out.println(
							"\n1.Show Products\n2.update Profile\n3.Delete Profile\n4.filter by price\n5.Filter by condition\n6.Add Ratings\n7.View Ratings\nEnter your choice");
					int userChoice = Integer.parseInt(scan.nextLine());

					switch (userChoice) {
					
					case 1:                                                                             // Show Products
						BookdetailsDao prodao = null;
						prodao = new BookdetailsDao();
						List<Bookdetails> l_pro = prodao.showProduct();
						for (int i = 0; i < l_pro.size(); i++) {
							System.out.println(l_pro.get(i));
						}
						
						System.out.println("\n1.Order Product\n2.My orders\n3.update order\n4.delete order\nEnter your choice");
						int orderChoice=Integer.parseInt(scan.nextLine());
						
						switch(orderChoice)
						{
					   case 1:
							String userName = currentUser.getEmail_id();
							int id1 = userDao.findUserId(userName);
							System.out.println("user_id :"+id1);
							
							System.out.print("Enter the Product Name");
							String proName=scan.nextLine();
							int id=prodao.findProductid(proName);
							System.out.println("Book ID :"+id);
							int price=prodao.findPrice(id);
							
							System.out.print("Enter no of Products needed");
							int quantity=Integer.parseInt(scan.nextLine());
							System.out.println("1.confirm order" + "\n" +"2.Cancel Order" );
							int placeorder = scan.nextInt();
							scan.nextLine();
							switch(placeorder) {
							
							case 1:
							int totalprice=(quantity*price);
							int wallet =userDao.walletbal(id1);
							int dedwallbal = wallet - totalprice;
							
							if(totalprice<=wallet) {
							 OrderDetails order=new OrderDetails(id,id1,quantity,totalprice);
							 OrderDetailsDao cartDao=new OrderDetailsDao();
							 
							cartDao.insertOrder(order);
							Userdetails userdetails = new Userdetails(id1,dedwallbal);
						int upd = userDao.updatewall(userdetails);
						if(upd > 0) {
							flag1 = false;
						
							System.out.println("ordered sucessfully!!");
						}
							}else {
								System.out.println("insufficient amount");
							}
							break;
							
							case 2:
								break;
							}
							break;
							
					   case 2: 
						   
						   String email1=currentUser.getEmail_id();
						   int useid=userDao.findUserId(email1);
						   
							 
						   
					   case 3:     //Update cart Quantity
						   OrderDetailsDao cart=new OrderDetailsDao();
						   cart=new OrderDetailsDao();
						   System.out.println("Enter the Product name");
						   String proname=scan.nextLine();
						   int proid=prodao.findProductid(proname);
						   System.out.println("Book ID"+proid);
						   System.out.println("Enter quantity");
						   int updatequantity=scan.nextInt();
						   int cartquantity=cart.updateCart(updatequantity, proid);
						   break;
					   case 4:
						    cart = new OrderDetailsDao();
							System.out.print("Enter books to delete");
							String deletebooks = scan.nextLine();
							int bookid=prodao.findProductid(deletebooks);
							System.out.println("Book ID"+bookid);
							int cardelete =cart.deleteCart(bookid);
							break;
					   
						 }
						break;
				case 2:                                                                            // UPDATE Profile
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
			  case 4:
				  System.out.println("ënter the price range");
				  int pricerange = scan.nextInt();
				  scan.nextLine();
						prodao = new BookdetailsDao();
						ResultSet rs = prodao.filterPrice(pricerange);
						while(rs.next())
						{
							System.out.println(rs.getString(2)+rs.getString(3)+rs.getInt(4)+rs.getString(5)+rs.getString(6)+rs.getInt(7)+rs.getString(8)+rs.getString(9)+"");
						}
						break;
			 case 5:
						prodao = new BookdetailsDao();
						List<Bookdetails> conList = prodao.filterCondition();
						for (int i = 0; i < conList.size(); i++) {
							System.out.println(conList.get(i));
						}
			 case 6:
				 BookdetailsDao prodao1 = new BookdetailsDao();
				 Ratingdao ratingdao = new Ratingdao();
				 System.out.println("Enter book name to add rating ");
				 String bookname = scan.nextLine();
				 System.out.println("Enter the rating ");
				 double rating = scan.nextDouble();
				 scan.nextLine();
				 String email1=currentUser.getEmail_id();
				 int useid=userDao.findUserId(email1);
				 
				   int proid=prodao1.findProductid(bookname);
				   Rating ratingmodel = new Rating(useid,proid,rating);
				   int result =ratingdao.insertrating(ratingmodel);
				   if(result>0) {
					   System.out.println("Your rating is sucessfully added ");
					   
				   }
				   break;
			 case 7:
				 BookdetailsDao prodao2 = new BookdetailsDao();
				 Ratingdao ratingdao1 = new Ratingdao();
				 System.out.println("Enter the book name ");
				 String bookname1 =scan.nextLine();
				 int proid2=prodao2.findProductid(bookname1);
				 Rating ratingmodel1 = new Rating(proid2);
				double rate= ratingdao1.fetchrating(ratingmodel1);
				if(rate>0) {
					System.out.println(bookname1 + ":" + rate);
				}else {
				   System.out.println("No ratings ");	
				}
				break;
			}
		}
				} else
					flag = 0;
				break;
			} while (flag == 0);

			break;

		}
}
}