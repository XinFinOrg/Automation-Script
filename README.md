# **Infactor Auto Testing Script**

## Installation Guide

## Step 1 - Install Java on your computer
Download and install the Java Software Development Kit (JDK) 
https://www.oracle.com/technetwork/java/javase/downloads/index.html

## Step 2 - Install Eclipse IDE

## Step 3 - Download the Selenium Java Client Driver

You can download the Selenium Java Client Driver :  https://www.seleniumhq.org/download/ 

You will find client drivers for other languages there, but only choose the one for Java. This directory contains all the JAR files that we would later import on Eclipse.


## Step 4 - Download Selenium Standalone Server, Browser Drivers, POI jar files

The Selenium Server is needed in order to run Remote Selenium WebDriver. 

Visit: https://www.seleniumhq.org/download/ and Download the latest version 3.141.59

**Browser Drivers:**


Mozilla GeckoDriver	: https://github.com/mozilla/geckodriver/releases

Google Chrome Driver : https://sites.google.com/a/chromium.org/chromedriver/downloads

**POI jar files for Read & Write Data from Excel File**:
https://poi.apache.org/download.html

**Preconditions for Write Excel Files Using Apache POI In Selenium WebDriver:**

Create an xlsx file and save it at particular location. Enter some data to read using Selenium. Close the created excel file before executing the script. Go to option “Format Cells” and under Number Tab option, select Text and click on OK.  By default it will be general, you need to make it as Number. If you don’t make it as text, there is a chance of NullPointerException error.

## Step 5 - Configure Eclipse IDE with WebDriver

1. Launch the "eclipse.exe" file inside the "eclipse" folder that we extracted in "step 2". If you followed "step 2" correctly, the executable should be located on "C:\eclipse\eclipse.exe"
2. When asked to select for a workspace, just accept the default location. 
3. Create a new project through File > New > Java Project. Name the project as "newproject". A new pop-up window will open enter details as follow:

* Project Name
* Location to save project
* Select an execution JRE
* Select layout project option
* Click on Finish button

4. In this step,

   Right-click on the newly created project and Select New > Package, and name that package as "newpackage". 
   A pop-up window will open to name the package,
   Enter the name of the package
   Click on Finish button

5. Create a new Java class under newpackage by right-clicking on it and then selecting- New > Class, and then name it as "MyClass". Your Eclipse IDE should look like the image below.

   When you click on Class, a pop-up window will open, enter details as

*  Name of the class
*  Click on Finish button

Now selenium WebDriver's into Java Build Path

In this step, Right-click on "newproject" and select Properties. On the Properties dialog, click on "Java Build Path".
Click on the Libraries tab, and then Click on "Add External JARs.." 

When you click on "Add External JARs.." It will open a pop-up window. 

Add all the JAR files inside and outside the "libs" folder. 

After selecting jar files, click on OK button.
