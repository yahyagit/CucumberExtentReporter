package com.demo.example.runner;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

/**
 * Created by vimalraj on 11/02/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"com.demo.example.stepdefinitions"},
                    plugin = {"com.demo.example.listener.ExtentCucumberFormatter:output"})
public class RunCukesTest {
}
