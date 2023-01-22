# drug-record-detail-application finder:

drug-record-details-rest-api project was created for fetching Drug Record Application Details. REST API end-point;  
- Get all matched record details based on search fields.

## Technology stack
* The project uses `JDK 1.8`, you have to install it first on your local machine if you want to develop the API.
* The API is implemented via `Spring Boot` - `2.7.7.RELEASE`.
* The project build tool is `maven`.
* Use Swagger for Graphical repesentation of REST API. 
* Junit test cases based on mokito framework.


## Running locally
Run below command to launch backend rest api locally:

java -jar drug-record-details-rest-api-0.0.1-SNAPSHOT.jar

## App info via standard actuator here: 
http://localhost:8082/api.fda.gov/drug/drugsfda.json?manufacturerName=`

http://localhost:8082/api.fda.gov/drug/drugsfda.json?manufacturerName=&brandName=

##
The Rest API port exposed to 8082 of your localhost.

##  Api documentation 
* Swagger documentation can be found here:
- `http://localhost:8082/swagger-ui/index.html`

## Testing
* API endpoints integration/component tests are inside project.

