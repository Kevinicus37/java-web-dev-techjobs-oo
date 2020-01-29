package org.launchcode.techjobs_oo.Tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import java.util.Scanner;

public class JobTest {
    private Job emptyJob1;
    private Job emptyJob2;

    @Before
    public void createJobs(){
        emptyJob1 = new Job();
        emptyJob2 = new Job();
    }

    @Test
    public void testSettingJobId(){
        Assert.assertTrue(Math.abs(emptyJob1.getId() - emptyJob2.getId()) == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertTrue(job.getName() instanceof String && job.getName().equals("Product tester"));
        Assert.assertTrue(job.getEmployer() instanceof Employer && job.getEmployer().getValue().equals("ACME"));
        Assert.assertTrue(job.getLocation() instanceof Location && job.getLocation().getValue().equals("Desert"));
        Assert.assertTrue(job.getPositionType() instanceof PositionType && job.getPositionType().getValue().equals("Quality control"));
        Assert.assertTrue(job.getCoreCompetency() instanceof  CoreCompetency && job.getCoreCompetency().getValue().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobDos = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertFalse(job.equals(jobDos));
    }

    @Test
    public void toStringStartsAndEndsWithBlankLines(){
        Job job = new Job();
        Scanner scanner = new Scanner(job.toString());
        String firstLine = scanner.nextLine();
        String lastLine = "";
        while (scanner.hasNextLine()){
            lastLine = scanner.nextLine();
        }
        scanner.close();

        Assert.assertTrue(firstLine.equals("") && lastLine.equals(""));
    }

    @Test
    public void toStringIncludesJobData(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "\n" +
                "ID: " + job.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n" +
                "\n";
        String actual = job.toString();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void toStringChecksEmptyFields(){
        emptyJob1.setEmployer(new Employer("LaunchCode"));
        emptyJob1.setPositionType(new PositionType("Testing"));
        String expected = "\n" +
                "ID: " + emptyJob1.getId() + "\n" +
                "Name: Data not available\n" +
                "Employer: LaunchCode\n" +
                "Location: Data not available\n" +
                "Position Type: Testing\n" +
                "Core Competency: Data not available\n" +
                "\n";
        String actual = emptyJob1.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringChecksIfJobExists(){
        String expected = "\nOOPS! This job does not seem to exist.\n\n";
        String actual = emptyJob1.toString();
        Assert.assertEquals(expected, actual);
    }
}
