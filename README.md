# WindownsApplicationDriver

Windows Application Driver is a service to support Selenium-like UI Test Automation on Windows Applications. This service supports testing **Universal Windows Platform (UWP)** and **Classic Windows (Win32)** apps on **Windows 10 PCs**. Windows Application Driver complies to the [JSON Wire Protocol](https://github.com/SeleniumHQ/selenium/wiki/JsonWireProtocol) standard and some application management functionalities defined by **Appium**. If you've been looking for better support for using [Appium](http://appium.io) to test Windows Applications, then this service is for you!

# Table of Contents

* [System Requirements](#system-requirements)
* [Installing and Running](#installing-and-running)
* [Other Locators](#other-locators-to-find-ui-elements)
* [References](#references)

## System Requirements

* Windown 10
* Any Appium test runner

## Installing and Running
You have two way to install it. If you have already installed the Appium then you do not need to install anymore!

### 1. Installing and Running Windows Application Driver

1. Download Windows Application Driver installer from <https://github.com/Microsoft/WinAppDriver/releases>
2. Run the installer on a Windows 10 machine where your application under test is installed and will be tested
3. Run `WinAppDriver.exe` from the installation directory (E.g. `C:\Program Files (x86)\Windows Application Driver`)

Windows Application Driver will then be running on the test machine listening to requests on the default IP address and port (`127.0.0.1:4723`). `WinAppDriver.exe` can be configured to listen to a different IP address and port as follows:

```
WinAppDriver.exe 4727
WinAppDriver.exe 10.0.0.10 4725
WinAppDriver.exe 10.0.0.10 4723/wd/hub
```

> **Note**: You must run `WinAppDriver.exe` as **administrator** to listen to a different IP address and port.

### 2. Installing and Running Appium

Appium can be installed in one of two ways: via [NPM](https://www.npmjs.com/) or by downloading [Appium Desktop](https://github.com/appium/appium-desktop/releases/), which is a graphical, desktop-based way to launch the Appium server.

**Installation via NPM**

First, make sure you installed Node in your enviroment, then type this command

`$ npm install -g appium`

One you open command prompt, you can simply run command `$ appium --session-override`

**Installation via Desktop App Download**

Simply download the latest version of Appium Desktop from the releases page and then run it.

> **Note**: Windows Application Driver is integrated with Appium, meaning if you use Appium as part of the test runner then it will launch WinAppDriver.exe and proxy the requests for you.
> 1. Appium will install **Windows Application Driver** for you on Windows if you don't already have it.  Every release of Appium is linked to a specific release of WinAppDriver and will not proxy to a different version of WinAppDriver. The easiest way to manage this is to let Appium install WinAppDriver for you.
> 2. To create multiple sessions with one Appium server you need Appium 1.6.4 or newer
> 3. When pointing a test at Appium you need to include `/wd/hub` on the server URI. E.g. `http://127.0.0.1:4723/wd/hub`

## Other Locators to Find UI Elements

Windows Application Driver supports various locators to find UI element in the application session. The table below shows all supported locator strategies with their corresponding UI element attributes shown in **inspect.exe**.

| Client API                   	| Locator Strategy 	| Matched Attribute in inspect.exe       	| Example      	|
|------------------------------	|------------------	|----------------------------------------	|--------------	|
| FindElementByAccessibilityId 	| accessibility id 	| AutomationId                           	| AppNameTitle 	|
| FindElementByClassName       	| class name       	| ClassName                              	| TextBlock    	|
| FindElementById              	| id               	| RuntimeId (decimal)                    	| 42.333896.3.1	|
| FindElementByName            	| name             	| Name                                   	| Calculator   	|
| FindElementByTagName         	| tag name         	| LocalizedControlType (upper camel case)	| Text         	|
| FindElementByXPath           	| xpath            	| Any                                    	| //Button[0]  	|

## References

* <https://github.com/Microsoft/WinAppDriver>
* <https://appium.io/>
