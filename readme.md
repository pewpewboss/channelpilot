#How do you approach this project ?
-Try to understand the assignment
-Write down questions that pop into mind.
-Write down thoughts that come up.
-Actually think how to approach the project given limited time & unknown APIs
-Write down Problems/TODO's to solve.
- make sure c0ffee-supply is rdy 4 awesome 1337 coding session :)
- Prioritize Tasks (Do Cherry-Picking == low hanging fruits first -> better to have something running than nothing)

Questions:

-What is swagger UI ?
	-> swagger is a toolset
	-> after sum research to Bing-A-i & Swagger-Homepage, it seems to be an api / specification that is able to create e. g.
		 controller-code that has been defined via xml/yaml according to a swagger standard.
	-> a well written API should be able to be automatically documented in Swagger UI.

- How do i know if my Controller is Swagger-UI-compatible  (code convention?) ? [x]
	-> https://swagger.io/docs/specification/about/

-Does "'product' endpoint shall be versioned mean there should be different versions deployed?
	-> no probably just having 2 methods

- What is "rabbitmq" ?

- How to intercept Errors so that i can have detailed info on what went wrong [] ?


- Can i be creative concerning the Data Types and meaning of  x,y,z ? 

- "The second endpoint is to receive product data in a JSON payload." Who recieves ? They recieve from our service or we recieve data ? ^.^

- How do i version the two Post Requests ?
 ->Versioning can be done in different ways: URI Versioning, Request Param Versioning, Header Versioning
   https://www.springboottutorial.com/spring-boot-versioning-for-rest-services
- How do i change the default JDBC URL when connecting to H2 console (localhost:8080/h2-console) ? [x]
	-> on first startup shows "jdbc:h2:~/test" but it should be "jdbc:h2:~/testdb"
	 
Thoughts:
- I have created web/micro-services before & done it using the Spring-Framework
- Create Git-Repo on Github & init git locally [x]
- Get an empty Spring-Starter-Project [x]
- Download Swagger
- Use Postman for sending HTTP Requests
- I've seen that "rabbitmq"-dependencies can be added via Spring-Startes
- I remember i can add annotations to ensure arguments are not null
- Remember there are multiple ways to create a mapping, e.g. @GetMapping @RequestMapping(value = "/index", method = RequestMethod.GET)
- In real world i'd probably have commit-messages start with a commit number
- I thought about using the model as request parameters, which is also debatable, since DTO encapsulate, but produce overhead / but probably go for DTO since 2 versions are requested.
- I'll go with URI versioning for now in one Controller for the sake of getting something running - think of having even 2 controllers (each vor a base URL ("/V1/V2") []
- I should write a service now that is capable of writing a Product into a DB
	-> Since they talk about a "local store" i'd guess going with the H2 (volatile) in memory DB is good enough 4 proof of concept

TODOS:
- create meaningful package Structure [x]
- create a controller & try out simple index GETRequest & try to send simple HTTP-PostRequest [x]
- Download Swagger [x]
- See if i can get Swagger UI to show a documentation of my index page & endpoint methods [x]
	->http://localhost:8080/swagger-ui/index.html
	->http://localhost:8080/v3/api-docs
- Change default JDBC URL on initial connect to H2 console (localhost:8080/h2-console)  [x]
- Not sure yet about final design when it comes to DTOs & Entitys... Is it okay to create a Product within the controller (while doing the mapping) ?
	Should the ProductService take "Products" to save ore ProductDTO's which internally in the ProductService are being mapped to Entities ?[]
	...i guess the controller should be relative dumb and just recieve and return DTOs... do some research[]
- Implement Authentication [x]
- Implemnt rabbitMQ [x]
- introduce interface IProduct [] (low prio for now)
- you might want some different Messaging Queues / Topics in the future

Import the Shopsystem.postman_collection into ur postman in order to test the API. Bear in mind (see what i did there?!) that u need to update the jwt token in ur request's body.

Helpful Resources:
- https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
- https://www.baeldung.com/spring-rest-openapi-documentation
- https://springdoc.org
- https://github.com/springdoc/springdoc-openapi-gradle-plugin
- https://spring.io/guides/gs/messaging-rabbitmq/
- https://docs.spring.io/spring-security/reference/features/authentication/password-storage.html
- https://www.baeldung.com/spring-security-5-oauth2-login
- 