# roche-products

drug-record-details-rest-api project was created for fetching Drug Record Application Details. REST API end-point;  
- Get one product 

## Technology stack
* The project uses `JDK 1.8`, you have to install it first on your local machine if you want to develop the API.
* The API is implemented via `Spring Boot` - `2.7.7.RELEASE`.
* The project build tool is `maven`. 

## Running locally
* Clone project to local machine and open it in your favorite editor, and Run main spring-boot class `DrugRecordDetailApplication`
OR
* Install `Docker`. locally and Once you have it, execute the following commands in the project root folder:
    - `./gradlew clean && ./gradlew build --info`
    - `docker build -t roche-products:latest .`
    - `docker-compose up`

* Docker will start containers for Roche-products and DB. 
The API port exposed to 8082 of your localhost.

##  Api documentation 
* Swagger documentation can be found here:
- `http://localhost:8082/swagger-ui/index.html`

## Testing
* API endpoints integration/component tests are inside project.

## Info
* App info via standard actuator here: 
- `http://localhost:8082/api.fda.gov/drug/drugsfda.json?manufacturerName=`


