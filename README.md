Daniel Silalahi

Instalation :
1.	Create your database
2.	Input the name of the database you created earlier
3.	Run the application
Admin Account :
email : admin@gmail.com
password : admin
Functions that have been implemented:
1. User Registration
2. Login
3. User Management
4.Use of Middleware 
5. Databases (MySql)
6. Unit Testing
Endpoint (test use Postman):
1.	Signup 
- URL: http://localhost:8080/api/v1/auth/signup
- Method: POST
- Body: (choose raw dan format JSON)

{ 
"name": "Test User",
 "email": "testuser@example.com", 
"password": "password123" 
}

- Send
- You should get a response containing the details of the user you just created.

2.	Signin
- URL: http://localhost:8080/api/v1/auth/signin
- Method: POST
- Body: (choose raw and format JSON)

{
    "email": "testuser@example.com",
    "password": "password123"
}

- Send
- You should get a response containing the JWT token and refresh token. Copy the JWT token for the next steps.

3.	Get All Users (Admin Access)
- URL: http://localhost:8080/api/v1/user/all
- Method: GET
- Headers: Tambahkan header berikut:
- Key: Authorization
Value: Bearer Token <JWT_TOKEN> (replace <JWT_TOKEN> with the admin token, you may need to create a user with the ADMIN role first)
- Send
- You should get a response with a list of all users.




4.	Update User (Admin Access)
- URL: http://localhost:8080/api/v1/user/{id}
- Method: PUT
- Headers: Add the following headers:
Key: Authorization
Value: Bearer <JWT_TOKEN> (replace <JWT_TOKEN> with admin token)
- Body: (select raw and JSON format)
{
    "name": "Updated Name",
    "email": "updatedemail@example.com"
}
- Send
- You should get a response containing the updated user details.
