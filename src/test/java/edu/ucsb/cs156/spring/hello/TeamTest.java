package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_withNull_returnsFalse() {
        assertEquals(false, team.equals(null));
    }

    @Test
    public void equals_differentClass_returnsFalse() {
        Object differentClassObject = new Object();
        assertEquals(false, team.equals(differentClassObject));
    }
    @Test
    public void equals_identicalTeams_returnsTrue() {
        Team anotherTeam = new Team("test-team");
        assertEquals(true, team.equals(anotherTeam));
    }

    @Test
    public void equals_teamsWithSameNameDifferentMembers_returnsFalse() {
        Team otherTeam = new Team("test-team");
        team.addMember("Alice");
        otherTeam.addMember("Bob");
        assertEquals(false, team.equals(otherTeam));
    }

    @Test
    public void equals_teamsWithDifferentNamesSameMembers_returnsFalse() {
        Team otherTeam = new Team("another-team");
        team.addMember("Alice");
        otherTeam.addMember("Alice");
        assertEquals(false, team.equals(otherTeam));
    }
    

    @Test
    public void hashCode_equalObjectsHaveSameHashCode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");

        assertEquals(t1.hashCode(), t2.hashCode(), "Hash codes should be equal for identical teams");
    }
}
