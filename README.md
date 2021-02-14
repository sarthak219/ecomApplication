# CPSC-210 Personal Project

## E-Commerce Application for Fashion

### <ins>Summary of the app-</ins>
This is an app where you can find everything you need to look cool like t-shirts, jackets, shoes, etc.
The app has multiple screens. The user is first met with a Welcome page where he has 
an option to either login as an admin, or an existing user, or he can simply create a new account or login as a guest.
**The user must enter a username and password in order to login as an admin (they can be found in the Admin class).**
Admin, or the *SuperUser* various powers which sets him apart from any normal user. His job is mainly to manage the
stocks of the shop and user database.
All user accounts are also password protected and after logging in as a registered user, or a guest, the user is 
directed to the homepage where he sees everything he can 
do such as view the products, search for products, etc. He can also place an order (it's just a simulation as of now 
which says order placed and will be delivered in 2 days).

**Once logged in as an admin, the admin can:**

- Add or remove items/products to the stock
- View all the products in the store
- View the list of all the users who have an account along with all their credentials
- Delete any user's account
- Logout from admin account

**As a normal user, one should be able to:**
- Create a new account
- Log into his/her existing account with his <ins>**unique**</ins> username and a password
- Use the app as a guest if he's lazy to create a new account
- View the list of all the products
- Search for products by their names or a part of their names
- Add/remove products from his wishlist
- Add/remove products from his cart
- View items in his/her wishlist
- View items in his/her cart
- Place order of all the items in his cart
- View the history of all the orders he has ever placed
- Logout from his/her account
- Quit the application at any time

### <ins>Note for the instructors:</ins>
Since this version doesn't have data persistence, you must first, login as an admin and add a few products to the 
list of all products in order to be able to use the features of a normal user such as searching products, adding them 
to cart or wishlist, etc.