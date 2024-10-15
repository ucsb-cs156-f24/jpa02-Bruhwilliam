package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("William", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getGithubId_returns_correct_GithubID(){
        assertEquals("BruhWilliam", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correctname(){
        Team t = Developer.getTeam();
        assertEquals("f24-05", t.getName());
    }

     @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Ishan"),"Team should contain Ishan");
        assertTrue(t.getMembers().contains("Alex"),"Team should contain Alex");
        assertTrue(t.getMembers().contains("Ryan"),"Team should contain Ryan");
        assertTrue(t.getMembers().contains("William"),"Team should contain William");
        assertTrue(t.getMembers().contains("Baige"),"Team should contain Baige");
        assertTrue(t.getMembers().contains("Ben"),"Team should contain Ben");
    }

}
