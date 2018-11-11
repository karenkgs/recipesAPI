# Recipes API
A Java API to return recipes based on what ingredients you have on your fridge.
- - -

## Importing the Project
* Make sure you have:
    * `Java (min. version 8)` installed
    * `Maven` installed

### Installing using IntelliJ
* Import the project -> Select the `root` folder -> Next
    ![import project](https://cldup.com/gPZ5HR2rB_-3000x3000.png)
* Select ***Import project from external model*** -> Select ***Maven*** line -> Next
* Select ***use auto-import*** checkbox -> Finish
    ![auto import](https://cldup.com/pc6JNIJgvD-3000x3000.png)
    > **Note:**
    > If the code is not working, open the ***Maven tab***
    > Press ***Reimport all Maven projects***

### Running the code
* The `Application.java` class is the main class. Run its `main` method.

#### Running with the terminal
* On the project `root` folder run `mvn spring-boot:run`
    ```
    cd /yourFolder/rootProjectFolder
    mvn spring-boot:run
    ```

### Running the tests
* Open the `src/test` folder
* Right-click on `java` folder -> ***Run all tests***
    ![run tests](https://cldup.com/HOoCf-d03J-3000x3000.png)

#### Running with the terminal
* On the project `root` folder run `mvn test`
    ```
    cd /yourFolder/rootProjectFolder
    mvn test
    ```

### Downloads
* [Maven](https://maven.apache.org/download.cgi)
* [Java](https://java.com/en/download/)
* [IntelliJ](https://www.jetbrains.com/idea/download/)

## Using the API
`/lunch?ingredients={ingredients}`

* If you pass any valid ingredient, the return will the recipes with it.
* If an ingredient is past its use-by date, recipes with it will not appear.
* If an ingredient is past its best-before date but not the use-by date, recipes with it will appear at the bottom of the response.

## About the Solution
For the development, I tried my best to follow some software development best practices such as OOP, SOLID, TDD and Language(Java) conventions and patterns, I used the  [Google style guide](​https://google.github.io/styleguide/javaguide.html​)  and the [Spring boot framework](https://spring.io/guides/gs/spring-boot/​).
When separating the classes, I chose to do it by domain. I created some packages as described below, the tests packages reflects it.


* ***ingredient***
Contains the `models(POJOs)` and `repository` classes for the Ingredient domain.

* ***recipe***
Contains the `models(POJOs)` and `repository` classes the Recipe domain.

* ***lunch***
Contains the `controller` and `service` classes, which contains the API requests/routing and brings the business rules and logic together.

* ***`Application` & `ApplicationConfig`***
These are the runner classes for the API.

### Architectural Decisions
   > **Note:**
   > I like to follow [this template](http://thinkrelevance.com/blog/2011/11/15/documenting-architecture-decisions) for documenting my architectural decisions.

[Here](ARDs.md) I documented the ARDs for this project.
