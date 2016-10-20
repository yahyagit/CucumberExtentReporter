package com.cucumber.stepdefinitions;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by vimalraj on 12/02/16.
 */
public class MyStepdefs {

    @Given("I have (\\d+) cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        System.out.format("Cukes: %n\n", cukes);
//        Assert.assertTrue(false);
        ExtentCucumberFormatter.setTestRunnerOutput("I_have_cukes_in_my_belly");
    }

    @Given("I have (\\d+) cukes in my bellies")
    public void I_have_cukes_in_my_bellies(int cukes) {
        System.out.format("Cukes: %n\n", cukes);
        ExtentCucumberFormatter.setTestRunnerOutput("I_have_cukes_in_my_bellies");
    }

    @Then("^I print$")
    public void iPrint() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	ExtentCucumberFormatter.setTestRunnerOutput("iPrint");
    }
}
