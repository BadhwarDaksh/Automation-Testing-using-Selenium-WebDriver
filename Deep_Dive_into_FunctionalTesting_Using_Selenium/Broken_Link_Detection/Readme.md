**#Broken Links Detection**

**#Introduction and Prerequisites:**
Detecting broken links on a website using Selenium WebDriver with Java is essential for ensuring a seamless user experience. Broken links can lead to a poor user experience and negatively impact a website's SEO. To achieve this, you'll need the following prerequisites:

i)   A working knowledge of Java and Selenium WebDriver.
ii)  Selenium WebDriver and ChromeDriver set up in your environment.
iii) The Java code provided below.
iv)  Dependencies added to your Maven pom.xml file to manage Selenium and other required libraries.

**#Given/Input:**
The given code is a Java program that uses Selenium WebDriver to identify broken links on a website. In this specific example, the code checks the "https://rahulshettyacademy.com/AutomationPractice/" website for broken links. It does so by locating all the links on the page (located under "li" elements with a specific class) and then sending HTTP HEAD requests to each URL to check their status codes. Links with a status code greater than or equal to 400 are considered broken.

**#Output:**
The output of this code is a list of status codes for each link found on the webpage. If a link is broken (status code >= 400), an error message is displayed indicating which link is broken and the corresponding status code. The SoftAssert is used to collect all the results and assert that no broken links are found. If any broken links are detected, the test will fail. The overall outcome will help identify and fix broken links on the website, improving its reliability and user experience.


