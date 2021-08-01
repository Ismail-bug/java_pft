package ru.stqa.pft.rest.tests;
import io.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.Issue;

import java.util.Set;

import static org.testng.Assert.*;

public class RestAssuredTests extends TestBase {

    @BeforeClass
    public void init() {
        RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
    }

    @Test
    public void testCreateIssue() {
        try {
            skipIfNotFixed(1311);
        } catch (SkipException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        Set<Issue> oldIssues = app.restAssured().getIssues();
        Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
        int issueId = app.restAssured().createIssue(newIssue);
        Set<Issue> newIssues = app.restAssured().getIssues();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues, oldIssues);
    }
}