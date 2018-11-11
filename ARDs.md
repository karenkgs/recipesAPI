***Title***
Responsibility separation.

***Context***
Spring has its own way to separate the responsibilities, but each person has an understanding of it.

***Decision***
I decided to have `Repository` classes to retry data from the JSON files. The `Service` classes hold the business logic that brings together the `Repository` and `Controller`. The `Controller` has the HTTP methods/requests.

- - -

***Title***
Wrapper classes.

***Context***
`Spring Data REST` has some interesting ways of dealing with `POJOs` and data itself, but it can be hard to use it with JSONs. 

***Decision***
I decided to just convert the JSON file directly to my `Model` classes using `Jackson`, instead of using the `Spring Data REST` project, where I could do `@Entity` classes, `JpaRepository` and so on.

***Status*** 
accepted.

***Consequences***
The JSON to `Model` conversion is easier and faster for me to do, but the code can be a bit messy. The `Wrapper` classes for the `Models` solve the problem of the JSON format.

- - -

***Title***
Factories to get the data from.

***Context***
A simple way to get the data without worrying to much is to have `Factory` classes that will only generate the `Java objects` based on what and how you need it.

***Decision***
I decided to have `Factory` classes so I could work more on the logic of the API.

***Status*** 
deprecated.

***Consequences***
The code does not reflect the real functioning of the API.
