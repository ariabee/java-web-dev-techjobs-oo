package org.launchcode.techjobs_oo.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.main.*;

import static org.junit.Assert.*;

public class JobTest {
//    private Job job1, job2;
//
//    @Before
//    public void createJobsToTest() {
//        job1 = new Job();
//        job2 = new Job();
//    }
    private static Job job1, job2, job3, job4;

    @BeforeClass
    public static void createJobsToTest() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        assertEquals(1, job2.getId() - job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(job3 instanceof Job);
        assertEquals(3, job3.getId());
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        char firstChar = job3.toString().charAt(0);
        char lastChar = job3.toString().charAt( job3.toString().length()-1 );
        assertTrue(firstChar == lastChar && lastChar == '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String correctOutput = "\nID: " + job3.getId() +
                "\nName: " + job3.getName() +
                "\nEmployer: " + job3.getEmployer() +
                "\nLocation: " + job3.getLocation() +
                "\nPosition Type: " + job3.getPositionType() +
                "\nCore Competency: " + job3.getCoreCompetency() + "\n";
        assertEquals(correctOutput, job3.toString());
    }

    @Test
    public void testToStringHandlesEmptyJobField() {
        job4.getEmployer().setValue("");
        job4.getLocation().setValue("");
        String correctOutput = "\nID: " + job4.getId() +
                "\nName: " + job4.getName() +
                "\nEmployer: " + "Data not available" +
                "\nLocation: " + "Data not available" +
                "\nPosition Type: " + job4.getPositionType() +
                "\nCore Competency: " + job4.getCoreCompetency() + "\n";
        assertEquals(correctOutput, job4.toString());
    }

}
