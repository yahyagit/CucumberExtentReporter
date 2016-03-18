package com.cucumber.runner;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

/**
 * Created by vimalraj on 11/02/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"com.cucumber.stepdefinitions"},
                    plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"})
public class RunCukesTest {
}
