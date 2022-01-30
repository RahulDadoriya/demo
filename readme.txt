----------------------------------------------------
		Set up Details
----------------------------------------------------
To run: 
	Inside demo folder and than use "mvn clean install"
	e.g. C:\Users\DummyUser\demo> mvn clean install 

	This will generate a demo-0.0.1-SNAPSHOT.jar file inside target folder
	Navigate to target folder and run java -jar demo-0.0.1-SNAPSHOT.jar

	e.g. C:\Users\DummyUser\demo\target> java -jar demo-0.0.1-SNAPSHOT.jar

	This will start application on port 8081

-------------------------------------------------------
		API Details
-------------------------------------------------------
1. To add item in cart:
	Method POST
		localhost:8081/api/cart/add
	Body
		{
    			"itemId": 6,
    			"itemQuantity": 1
		}

2. To get cart details:
	Method GET
		localhost:8081/api/cart/getCart

3. To remove item from cart:
	Method DELETE
		localhost:8081/api/cart/remove
	Body
		{
    			"itemId": 3,
    			"itemQuantity": 1
		}


4. To checkout cart from cart:
	Method GET
		localhost:8081/api/cart/checkout

5. To check inventory:
	Method GET
		localhost:8081/api/item/all





















