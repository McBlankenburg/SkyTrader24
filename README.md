# SkyTrader24

SkyTrader24 is a microservices-based application built with 
-Java,
-maven
-Spring (Boot, Cloud, Data JPA, Security)
-Apache Kafka
-Docker
-Kubernetes

It consists of several services, including Customer, Notification, Order, Payment, Trade, and Weather, providing a platform for trading activities. 
This application is developed as part of my portfolio as a demonstration application.

## Directory Structure

The directory structure of the project is as follows:
```shell
├── microservices
│ ├── customer # registration, authentication, and profile management.
│ ├── notification # email, sms, pop-up notification
│ ├── order # creation, modification and tracking of orders placed by customers., inventory management, order status.
│ ├── payment # including payment gateway integration, transaction management, and handling various payment methods.
│ ├── trade # buying and selling of financial assets. It handles order matching, trade execution, and trade history management.
│ ├── weather # It integrates with external weather APIs to fetch real-time weather data and provides weather forecasts and current conditions.
├── docker # Docker configuration
├── kubernetes # Kubernetes YAML configuration files
├── .github/workflows # Git Actions configuration files
├── docs # Project documentation in markdown and diagrams
├── 
```
| Microservices | 1st Stage Status | 2nd Stage Status |
|---------------|-----------------|-----------------|
| customer      | In Progress     |                 |
| notification  |                 |                 |
| order         |                 |                 |
| payment       |                 |                 |
| trade         |                 |                 |
| weather       |                 |                 |

## Installation and Setup

To install and run the SkyTrader24 application, follow the instructions below:

### Prerequisites

Make sure you have the following tools installed:

- JDK 17
- Maven (optional)
- Docker
- Kubernetes cluster
- Postman

### Clone the Repository

```shell
git clone https://github.com/McBlankenburg/SkyTrader24.git
cd SkyTrader24
```

### Building the Project
To build all the projects at once from the microservices module, you can use the Maven wrapper. 
Run the following command from the root directory of the project:

```shell
cd microservices
./mvnw clean install
```
This command will build all the microservices and their dependencies.


### Running microservices in kubernetes
Instructions for running the services in kubernetes will be added in the future.

