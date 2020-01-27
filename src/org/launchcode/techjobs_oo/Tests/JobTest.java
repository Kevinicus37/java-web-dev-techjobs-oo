package org.launchcode.techjobs_oo.Tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

public class JobTest {
    private Job job1;
    private Job job2;

    @Before
    public void createJobs(){
        job1 = new Job();
        job2 = new Job();
    }

    @Test
    public void testSettingJobId(){
        Assert.assertTrue(Math.abs(job1.getId() - job2.getId()) == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertTrue(job3.getName() instanceof String && job3.getName().equals("Product tester"));
        Assert.assertTrue(job3.getEmployer() instanceof Employer && job3.getEmployer().getValue().equals("ACME"));
        Assert.assertTrue(job3.getLocation() instanceof Location && job3.getLocation().getValue().equals("Desert"));
        Assert.assertTrue(job3.getPositionType() instanceof PositionType && job3.getPositionType().getValue().equals("Quality control"));
        Assert.assertTrue(job3.getCoreCompetency() instanceof  CoreCompetency && job3.getCoreCompetency().getValue().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertFalse(job4.equals(job5));
    }
}
