# Cucumber Extent Reporter

This java project helps you to generate the custom cucumber-jvm report using ExtentReports plugin.

The ExtentReports plugin is developed by Anshoo Arora. This is one of the best reporting plugin available for testing world. This plugin can be used with any Test Apis.

## Usage
To use this reporting plugin, your runner class should look like this:

```java
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.demo.example.listener.ExtentCucumberFormatter:output"})
public class RunCukesTest {
}
```
