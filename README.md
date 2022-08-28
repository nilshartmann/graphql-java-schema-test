# GraphQL Schema Test

Very simple initial exploration of a possible DSL to test GraphQL Schemas with graphql-java. Not meant to be a complete,
production-ready solution.

```java
public class SchemaTest {
  @Test
  void queryTypeIsCorrect() {
    assertGraphQLSchema()
      .withType("Query")
        .withField("story").ofType("Story")
          .withDescription("the newest `Story` in")
          .withArgument("storyId").ofType("ID!")
            .and().withArgument("skipTeaser").ofType("Boolean")
          .and()
      .and()
        .withField("stories").ofType("[Story!]!")
    ;
  }
}
```

* Please find more examples in `test/java/nh/graphql/schematest/SchemaTest.java`
* The implementation is in `test/java/nh/graphql/schematest/GraphQLSchemaAssertions.java`
* You can run the example tests in your IDE (import as Gradle project) or `./gradlew test`

* If you find it somehow useful, please use is. Otherwise don't 😊


# Contact

You can reach me on [Twitter](https://twitter.com/nilshartmann) or via my [Homepage](https://nilshartmann.net).


