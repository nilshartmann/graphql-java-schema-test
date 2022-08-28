package nh.graphql.schematest;

import org.junit.jupiter.api.Test;

public class SchemaTest {

  private final static String SCHEMA_LOCATION = "/graphql/hello-graphql-java.graphqls";

  private GraphQLSchemaAssertions.GraphQLSchemaAssertion assertGraphQLSchema() {
    return GraphQLSchemaAssertions.assertGraphQLSchema(SCHEMA_LOCATION);
  }

  @Test
  void memberTypeIsCorrect() {
    assertGraphQLSchema()
      .withType("Member")
          .withField("id").ofType("ID!")
          .and().withField("profileImage").ofType("String!")
    ;
  }

  @Test
  void storyTypeIsCorrect() {
    assertGraphQLSchema()
      .withType("Story")
        .withField("id").ofType("ID!")
        .and().withField("title").ofType("String!")
        .and().withField("body").ofType("String!")
        .and().withField("writtenBy").ofType("Member!")
    ;
  }


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

  @Test
  void mutationIsCorrect() {
    assertGraphQLSchema()
      .withType("Mutation")
        .withField("addStory").ofType("Story!")
        .withArgument("input").ofType("StoryInput!")
      .schema()
      .withInputType("StoryInput")
    ;
  }

}
