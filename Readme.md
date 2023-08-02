## Rest Assured Syntax
`given()` => Prepare the scenario configuration, headers and
parameters.

`.when()` => Action to be executed, like GET or POST.

`.then()` => Assertions, extract data and check response.

The basic configuration, as shown in the TestConfig class, 
uses the RestAssured object. Most basic example of what you can
predefine to apply "beforeClass" (remember TestNG and JUnit)
is the basic url and the base path inside that url. You can
define a specific port too if the API needs it, and remember:
those are declared as variables.

`RestAssured.baseURI` => Defines the base url.

`RestAssured.basePath` => Defines the default path inside that url.

`RestAssured.port` => Defines the port to be used.

---
### Request and Response specification

The configuration can include the specification and expected 
behavior of the request information and the response one. Both
are build in a very similar way, and have several options to 
determine our desired output. 

```
RestAssured.requestSpecification = new RequestSpecBuilder()
    .setContentType("application/json")
    .build();
    
RestAssured.responseSpecification = new ResponseSpecBuilder()
    .expectStatusCode(200)
    .build();
```

In both case you have to `.build()` your specifications at
the end. You can write more than one specification just breaking
it in a new line before `.build()` without any issue.

---
## Endpoints interface

It's recommended to create an interface to store the API endpoints
as variables, so in case some of them changes you don't have
to update it in a hundred test cases. You can get the 
interface information in any class using the code below.

`(InterfaceName.VariableName)`

---
## Object Serialization

To serialize an object you first need the object itself! One way
to get it is through the JSON using JSON2Pojo, or similar
tools. The same happens to validate a JSON schema, you need
the schema in your files, for example the "VideoGameJsonSchema"
in resources (made by Jsonschema).
