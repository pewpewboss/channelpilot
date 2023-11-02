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

- How do i know if my Controller is Swagger-UI-compatible  (code convention?) ? []
	-> https://swagger.io/docs/specification/about/

-Does "'product' endpoint shall be versioned mean there should be different versions deployed?
	-> no probably just having 2 methods

- What is "rabbitmq" ?


- Can i be creative concerning the Data Types and meaning of  x,y,z ? 

- "The second endpoint is to receive product data in a JSON payload." Who recieves ? They recieve from our service or we recieve data ? ^.^

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


TODOS:
- create meaningful package Structure []
- create a controller & try out simple index GETRequest & try to send simple HTTP-PostRequest []
- Download Swagger []
- See if i can get Swagger UI to show a documentation of my index page & endpoint methods
}

Helpful Resources:
- https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
- https://www.baeldung.com/spring-rest-openapi-documentation
- https://springdoc.org
- https://github.com/springdoc/springdoc-openapi-gradle-plugin