## DESCRIPTION
- This Maven archetype is an extension of Spring Boot.
- This archetype aim to support basic Java function, such as data interaction, simple input/output conversion, etc. Then, quickly convert the basic function to a restful API.
- Serveral components are included, such as: Spring-boot, mysql-connector, fastjson and etc.
- 该框架致力于将主要做数据处理的代码片段快速输出成可独立部署的服务，对外通过Api的形式输入处理能力。
- 框架目前内置集成了Spring-boot, mysql-connector, fastjson等组件。

## PREREQUISITES
- Java 8
- Maven 3.2.2


## HOW TO **INSTALL**
1. Clone this project to your local directory.
```
git clone git@gitlab.alibaba-inc.com:wanghan.wh/java-api-archetype.git
```


2. step into this magic folder.
```
cd java-api-archetype
```


3. run maven command to install this archetype to your local repository.
```
mvn clean install
```


## HOW TO __CREATE__ PROJECT FROM A LOCAL ARCHETYPE
1. run maven command to create a project from local repository.
```
$ mvn archetype:generate -DarchetypeCatalog=local
```


2. by running this command you will see following questions to define which archetype you about to use:
```
$ [INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
$ Choose archetype:
$ 1: local -> com.aliyun.java.api.framework:java-api-framework-archetype (AliExpress Parent POM for SpringBoot and Java 8 application.)
$ Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 1
```


3. you will be asked to define several necessary properties of maven project:
```
$ Define value for property 'groupId': : com.aliyun.test
$ Define value for property 'artifactId': : testApp
$ Define value for property 'version':  1.0-SNAPSHOT: : 1.0-SNAPSHOT
$ Define value for property 'package':  com.aliyun.test: : com.aliyun.test
$ Confirm properties configuration:
$ groupId: com.aliyun.test
$ artifactId: testApp
$ version: 1.0-SNAPSHOT
$ package: com.aliyun.test
```


4. after confirmation, project will be automatically generated as the following structure.
```
 testApp
 ├── bin
 │   └── template
 ├── lib
 └── src
     └── main
         ├── java
         │   └── com
         │       └── aliyun
         │           └── test
         │               ├── controller
         │               └── demo
         └── resources
 12 directories
```


## HOW TO **DEVELOP**
1. under src/main/java to create your own package and function.

```
package com.aliyun.test.demo;

public class App {

	public static void main (String[] args) {
		System.out.println(testRun("lol"));
	}

	public static String testRun (String input) {
		return input;
	}
}
```


2. after develop your function, you need to edit lib/package.json file to define your router.
```
{
  "AppName": "testApp",
  "version": "1.0",
  "build": "1",
  "router": [
    {
      "path": "/userFunc/{input}",
      "method": "get",
      "package": "com.aliyun.test.demo",
      "class": "App",
      "function": "testRun",
      "params": [
        {
          "name": "input",
          "type": "String"
        }
      ]
    }
  ]
}
```


3. run bin/build command based on your package.json. This builder will help you to generate Controller.java
```
$ bin/build.sh lib/package.json
```


4. Finally you can run your app.
```
$ mvn spring-boot:run
```


5. test your api.
```
http://localhost:7001/userFunc/program
```


6. you can easily package you project.
```
$ mvn clean package
```


7. run your project or publish your jar file.
```
java -jar target/testApp.jar
```

## HOW TO **TEST**

1. In src/test/java, there is a example about how to test your Controller.
```
@Test
public void testRootController() {
 String apiResponse = restTemplate.getForObject("http://localhost:7001/", String.class);
 assertNotNull(apiResponse);
 assertEquals("Hello World!", apiResponse.toString());
}
```

2. After defined serveral test-cases, run maven command to test your project.
```
mvn test
```

3. You will see the test report afterwards.
```
 -------------------------------------------------------
  T E S T S
 -------------------------------------------------------
 Running com.aliyun.java.api.framework.test.ControllerTest
 17:19:40.051 [main] DEBUG org.springframework.web.client.RestTemplate - Created GET request for "http://localhost:7001/"
 17:19:40.059 [main] DEBUG org.springframework.web.client.RestTemplate - Setting request Accept header to [text/plain, application/json, application/*+json, */*]
 17:19:40.100 [main] DEBUG org.springframework.web.client.RestTemplate - GET request for "http://localhost:7001/" resulted in 200 (OK)
 17:19:40.103 [main] DEBUG org.springframework.web.client.RestTemplate - Reading [java.lang.String] as "text/plain;charset=UTF-8" using [org.springframework.http.converter.StringHttpMessageConverter@7f9fcf7f]
 Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.851 sec
 Results :
 Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```

## HOW TO **SET ENVIRONMENT VARIABLES**

1. In the src/main/resources directory, we have list of *application-{env}.properties* files, you can define your own variables for different environment deployment.

2. You have to define a YAML file to describe the relationship between each profile and environment.

```
spring:
    application:
        name: [AppName]
server:
    port: 7001
---
spring:
    profiles: daily
    application:
        name: [AppName]
server:
    port: 8080
```

## ADDITIONAL INFORMATION

1. Request body parameters are accepted by "raw" format.
```
{
   "type":"news"
}
```

2. If you want to pass KV parameters to your router, you have to declared that in package.json
