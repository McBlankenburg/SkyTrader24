# SkyTrader24
SkyTrader24 is a microservices-based application built with

- Java 17
- maven
- Spring (Boot, Cloud, Data JPA, Security)
- Hibernate
- Apache Kafka
- Docker
- Kubernetes

## Directory Structure
The directory structure of the project is as follows:

```yaml
├── microservices
│     ├── eureka-discovery #
│     ├── identity-management #registration, authorization, authentication, and profile management
│     ├── weather-data-collector #collecting data from external weather APIs, data processing and distribution
│     ├── stock-inventory #sharing of stock and price data
│     ├── shopping-cart #adding, deleting and saving a shopping cart assigned to a user profile
│     ├── payments #integration with external payment APIs
│     ├── orders-and-delivery-management #collecting information about orders and delivery
│     ├── notifications #sending email notifications
│
├── .github
│     ├── workflows # Git Actions configuration files

├── docker # Docker configuration
├── kubernetes # Kubernetes YAML configuration files
├── docs # Project documentation in markdown and diagrams
```
| Microservices                  | 1st Stage Status | 2nd Stage Status |
|--------------------------------|-----------------|------------------|
| eureka-discovery               | In Progress     |                  |
| identity-management            | In Progress     |                  |
| weather-data-collector         | In Progress     |                  |
| stock-inventory                |                 |                  |
| shopping-cart                  |                 |                  |
| payments                       |                 |                  |
| orders-and-delivery-management |                 |                  |
| notifications                  |                 |                  |

## Installation and Setup

To install and run the SkyTrader24 application, follow the instructions below:

### Prerequisites

Make sure you have the following tools installed:
<font color="green">
- JDK 17
- Maven (optional)
- Docker
- Kubernetes cluster
- Postman
  </font>
### Clone the Repository

```shell
git clone https://github.com/McBlankenburg/SkyTrader24.git
```
```shell
cd SkyTrader24
```

### Building the Project
To build all the projects at once from the microservices module, you can use the Maven wrapper. 
Run the following command from the root directory of the project:

```shell
cd microservices
```
```shell
./mvnw clean install
```
This command will build all the microservices and their dependencies.


### Running microservices in kubernetes
Instructions for running the services in kubernetes will be added in the future.

