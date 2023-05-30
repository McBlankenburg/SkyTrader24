## Customer Microservice:
- Manages customer registration, login, and account management.
- Provides authentication and authorization for other microservices.
- Supplies user information to other microservices such as Trade Microservice and Notification Microservice.
- Depends on the Notification Microservice for sending notifications to customers.

## Weather Microservice:
- Collects data from an external weather API.
- Analyzes and processes the weather data.

## Trade Microservice:
- Handles trade-related functionalities, such as creating and managing trade offers.
- Relies on the Weather Microservice for weather information.

## Payment Microservice:
- Integrates with a payment gateway service, such as Przelewy24, for processing customer payments.
- Communicates with the Order Microservice for order-related payment transactions.

## Order Microservice:
- Manages customer orders and order processing.
- Coordinates with the Payment Microservice for payment processing.

## Notification Microservice:
- Sends notifications to customers.
- Receives information from other microservices, such as Trade Microservice and Customer Microservice, to deliver relevant notifications.
- Notifies customers about changes in trade offers.