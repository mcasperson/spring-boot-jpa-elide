This code is part of a tutorial that can be read at https://dzone.com/articles/create-a-json-api-rest-service-with-spring-boot-an

* https://elide-test.herokuapp.com/parent will display a list of the parent entities
* https://elide-test.herokuapp.com/parent/1 will display the details of a single parent entity
* https://elide-test.herokuapp.com/parent/1/relationships/children will display the type and id of the children assigned to a single parent
* https://elide-test.herokuapp.com/parent/1/children will display the cimplete details of the children assigned to a single parent
* https://elide-test.herokuapp.com/parent?fields[parent]=name will display only the name attribute of the parent entities (this is known as sparse fieldsets in the JSON API spec)
* https://elide-test.herokuapp.com/parent?filter[parent.id]=2 will return the parent entity with the id of 2
* https://elide-test.herokuapp.com/parent?filter[parent.name][prefix]=Jane will return the parent entities with the name attribute starting with “Jane”
* https://elide-test.herokuapp.com/parent?sort=-name will return the parent entities sorted by the name attribute in descending order

To run locally:

    install java
    $ ./gradlew build
    $ ./gradlew bootRun
