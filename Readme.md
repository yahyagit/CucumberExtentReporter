# Cucumber Extent Reporter

This tool helps you to generate the custom cucumber-jvm report using ExtentReports plugin.

The [ExtentReports](http://extentreports.relevantcodes.com/) plugin is developed by Anshoo Arora. This is one of the best reporting plugin available for testing world. This plugin can be used with any Test Apis.

## Build Status
[![Build Status](https://travis-ci.org/email2vimalraj/CucumberExtentReporter.svg?branch=master)](https://travis-ci.org/email2vimalraj/CucumberExtentReporter)

## Usage
If you are using a maven based project, you can directly add this library as a dependency:

```
<dependency>
    <groupId>com.vimalselvam</groupId>
    <artifactId>cucumber-extentsreport</artifactId>
    <version>1.1.1</version>
</dependency>
```

If not, download the jar from [here](http://search.maven.org/#search%7Cga%7C1%7Ccucumber-extentsreport).

## Release Notes
### v1.1.1
- User now can add test runner log from anywhere. The output will be displayed under the Log tab in the report. Refer the example.
- All the step keywords from cucumber is now displayed.
- Fixed to list the feature tags in the Categories section.

### v1.1.0
- User now can add system information to the report.
- User now can load the extent report config xml to customize the report.
- Fixed the scenario outline, now each scenario in the scenario outline will be properly displayed in the report.

### v1.0.0
- Initial release with basic support of extent report.

## Cucumber runner class

**Example**:
```java
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.cucumber.listener.ExtentCucumberFormatter"})
public class RunCukesTest {

    @BeforeClass
    public static void setup() {
        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
        ExtentCucumberFormatter.initiateExtentCucumberFormatter();

        // Loads the extent config xml to customize on the report.
        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

        // User can add the system information as follows
        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Firefox");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "v31.0");
        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

        // Also you can add system information using a hash map
        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.1");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
    }

}
```

## Initializing report
User can intialize the extent cucumber report in any one of the following ways. Make sure the initialization should happen before your cucumber test start. Ideally, you would be initializing the report in the junit `@BeforeClass` method:

```
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting, DisplayOrder displayOrder, NetworkMode networkMode, Locale locale)
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting, DisplayOrder displayOrder, NetworkMode networkMode)
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting, DisplayOrder displayOrder, Locale locale)
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting, DisplayOrder displayOrder)
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting, NetworkMode networkMode, Locale locale)
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting, NetworkMode networkMode)
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath, NetworkMode networkMode)
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting, Locale locale)
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting)
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath, Locale locale)
ExtentCucumberFormatter.initiateExtentCucumberFormatter(File filePath)
ExtentCucumberFormatter.initiateExtentCucumberFormatter()
```
* filePath - path of the file, in .htm or .html format
* replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
    * True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
    * False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
* displayOrder
    * OLDEST_FIRST (default) - oldest test at the top, newest at the end
    * NEWEST_FIRST - newest test at the top, oldest at the end
* networkMode
    * ONLINE (default): creates a single report file with all artifacts
    * OFFLINE - all report artifacts will be stored locally in %reportFolder%/extentreports and report will be accessible without internet connectivity
* locale - locale of the HTML report, see list of supported locales [here](http://extentreports.relevantcodes.com/java/#localized-versions). To add a localized version of report, create a new .properties file as shown [here](https://github.com/anshooarora/extentreports/blob/master/java/extentreports/src/main/resources/com/relevantcodes/extentreports/view/resources/localized.properties).

## Adding System Information
User can add system information in one of the two ways as follows:

```
ExtentCucumberFormatter.addSystemInfo("BrowserName", "Firefox");
ExtentCucumberFormatter.addSystemInfo("BrowserVersion", "v33.0");
```

or

```
Map systemInfo = new HashMap();
systemInfo.put("Cucumber version", "v1.2.3");
systemInfo.put("Extent Cucumber Reporter version", "v1.1.1");
ExtentCucumberFormatter.addSystemInfo(systemInfo);
```

## Loading configuration file
Refer here to create the config xml file: [ExtentReports Configuration](http://extentreports.relevantcodes.com/java/#configuration)
To load the config file:

```
ExtentCucumberFormatter.loadConfig(new File("your config xml file path"));
```

## Add Test Runner Logs
To add the test runner log from any of your step, you can do this:

```
@Given("^I am on Google home page$")
public void iAmOnGoogleHomePage() {
    open("http://www.google.com");
    ExtentCucumberFormatter.setTestRunnerOutput("Your log goes here");
}
```
