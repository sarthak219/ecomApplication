# CPSC-210 Personal Project

## E-Commerce Application for Fashion

### <ins>Summary of the app-</ins>
This is an app where you can find everything you need to look cool like t-shirts, jackets, shoes, etc.
<ins>The app when opened, loads 2 databases from files, one is the user database which stores the list of all the users and,
a collection database which stores all the list of all the products in the store.</ins>
The app has multiple screens. The user is first met with a Welcome page where he has 
an option to either login as an admin, or an existing user, or he can simply create a new account.
**The user must enter a special username and password in order to login as an admin (they can be found in the Admin class).**
Admin, or the *SuperUser* has various powers which sets him apart from any normal user. His job is mainly to manage the
stocks of the shop and user database.
All user accounts are also password protected and after logging in as a registered user, the user is 
directed to the homepage where he sees everything he can 
do such as view the products, search for products, etc. He can also place an order (it's just a simulation as of now 
which says order placed and will be delivered in 2 days). <ins>When the user exits the app, his/her changes are automatically
saved, and he would be able to view the products in his cart, wishlist and Order History whenever he/she will open the app
again. Also, when the app is closed, the collection database gets saved automatically. </ins>

**Once logged in as an admin, the admin can:**

- Add or remove items/products to the collection <ins>which get saved in a file</ins>
- View all the products in the store
- View the list of all the users who have an account along with all their credentials
- Search for products by their names or a part of their names
- Search for users by their names or a part of their names
- Logout from admin account

**As a normal user, one should be able to:**
- Create a new account <ins>which gets saved in the user database file</ins>
- Log into his/her existing account with a <ins>**unique**</ins> username and a password
- View the list of all the products
- Search for products by their names or a part of their names
- Add/remove products from his wishlist
- Add/remove products from his cart
- View items in his/her wishlist
- View items in his/her cart
- Order all the items in his cart
- Return items
- View the history of all the orders he has ever placed
- Logout from his/her account
- Quit the application at any time


## Phase-4: Task-2
I have chosen to implement a <ins>Type Hierarchy</ins> in my project. The following hierarhcies are present in my project:

### In model package:
- Admin class is a sub-class of User

### In ui package:
- ProductCard class is a sub-class of Card. A card is just a JButton of a specific dimension and appearance which 
  matches the template of the app, but a product card is a Card specifically designed to show details of items in the 
  store on the card.
  
- #### In tabs package:
    - SmallTab is an abstract class with LoginScreenTab and WelcomeScreenTab as its sub-classes. Although the subclasses 
      don't override any methods from SmallTab, SmallTab is declared to be abstract since an object of SmallTab is
      never created. This class just provides the basic layout and appearance to match the template of the app.
      
    - BigTab is an abstract class that implements the class CaretListener. UserTab and Admin tab are the sub-classes 
      of BigTab and both classes override the caretUpdate() method from the CaretListener Interface differently.
        
    - #### In forms package:
        - FormTab is an abstract class with NewAccountFormTab and NewProductFormTab as its sub-classes. Both sub-classes
          override the addFields() method.
    
    - #### In options package:
        - OptionTab is an abstract class which has 5 sub-classes namely- ShowCartTab, ShowOrderHistoryTab, 
          ShowProductsTab, ShowUsersTab, ShowWishlistTab. OptionTab also implements the Observer
          interface and therefore all its sub-classes override the update() method.