# Cucumber Extent Reporter

This java project helps you to generate the custom cucumber-jvm report using ExtentReports plugin.

The [ExtentReports](http://extentreports.relevantcodes.com/) plugin is developed by Anshoo Arora. This is one of the best reporting plugin available for testing world. This plugin can be used with any Test Apis.

## Usage
If you are using a maven based project, you can directly add this library as a dependency:

```
<dependency>
    <groupId>com.vimalselvam</groupId>
    <artifactId>cucumber-extentsreport</artifactId>
    <version>1.0.0</version>
</dependency>
```

If not, download the jar from [here](http://search.maven.org/remotecontent?filepath=com/vimalselvam/cucumber-extentsreport/1.0.0/cucumber-extentsreport-1.0.0.jar).

## Cucumber runner class
By default in case you don't pass any arguments to the ExtentCucumberFormatter, it will create output/Run_<unique timestamp>/report.html file in your project directory.

**Example**:
```java
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"})
public class RunCukesTest {
}
```

*Note*: Ensure you have `:` at the end of the plugin class. This is mandatory by Cucumber.

In case you want a report in some other location, then you can make your choice like this:

```java
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"})
public class RunCukesTest {
}
```

The above will generate the `report.html` in the `output` folder.