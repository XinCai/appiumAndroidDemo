**The Star app Android Appium Automation Test Framework**

Test Automation appium guide

---

## Pre-requisite

You’ll need to install/download those softwares to start use this automation framework 

1. node v10.2.1
2. java version 1.8.0_171
3. npm v6.1.0
		npm -g list --depth=0
		/usr/local/lib
		├── appium@1.8.1
		├── appium-doctor@1.4.3
		├── ios-deploy@1.9.2
		├── npm@6.1.0
		└── wd@1.7.0
4. appium under node module appium 1.8.1
5. standalone version Appium mac version 1.10.0 (1.10.0.20181230.2)
	 Desired Capabilities
	    {
	      "platformName": "Android",
	      "deviceName": "Android Emulator",
	      "app": "/Users/hostapp/Downloads/app-alphaFlavor-debug.apk",
	      "deviceName": "Android Emulator"
	    }

6. application under test: 
	 https://rink.hockeyapp.net/manage/dashboard
	 android : app-alphaFlavor-debug.apk
7. development env 
	Maven home: /usr/local/Cellar/maven/3.5.3/libexec
	Java version: 1.8.0_171, vendor: Oracle Corporation
	Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre
	Default locale: en_AU, platform encoding: UTF-8
	OS name: "mac os x", version: "10.13.6", arch: "x86_64", family: "mac"

---

## Test Execution

User need to setup emulator or real device to run those tests.

1. Check out maven project with those dependencies 
	TestNg (v 6.14.3), Selenium (v 3.141.5), Appium (v7.0.0)
2. Test environment: UAT (configue from the star club app settings)
3. Android Emulator 
	CPU/ABI: Google Play Intel Atom (x86)
              Path: /Users/hostapp/.android/avd/Nexus_5_API_28.avd
              Target: google_apis_playstore [Google Play] (API level 28)
              Skin: nexus_5
              SD Card: 100M
              hw.dPad: no
              hw.lcd.height: 1920
              runtime.network.speed: full
              hw.accelerometer: yes
              hw.device.name: Nexus 5
              vm.heapSize: 128
              skin.dynamic: yes
              hw.device.manufacturer: Google
              hw.lcd.width: 1080
              hw.gps: yes
              hw.initialOrientation: Portrait
              image.androidVersion.api: 28
              hw.audioInput: yes
              image.sysdir.1: system-images/android-28/google_apis_playstore/x86/
              tag.id: google_apis_playstore
              showDeviceFrame: yes
              hw.camera.back: virtualscene
              hw.mainKeys: no
              AvdId: Nexus_5_API_28
              hw.camera.front: emulated
              hw.lcd.density: 480
              avd.ini.displayname: Nexus 5 API 28
              hw.arc: false
              hw.gpu.mode: auto
              hw.device.hash2: MD5:1c925b9117dd9f33c5128dac289a0d68
              hw.ramSize: 1536
              hw.trackBall: no
              PlayStore.enabled: true
              fastboot.forceColdBoot: no
              hw.battery: yes
              hw.cpu.ncore: 2
              hw.sdCard: yes
              tag.display: Google Play
              runtime.network.latency: none
              hw.keyboard: yes
              hw.sensors.proximity: yes
              disk.dataPartition.size: 6442450944
              hw.sensors.orientation: yes
              avd.ini.encoding: UTF-8
              hw.gpu.enabled: yes

4. Run/Debug from Intellij IDE v2018.1 community.
5. Go back to the **Source** page.

Before you move on, go ahead and explore the repository. You've already seen the **Source** page, but check out the **Commits**, **Branches**, and **Settings** pages.

---

## Framework Features

1. PageObject design pricipal.
2. Data Driven test, **data.json file**
3. End to End UI tests.
4. Run from testng.xml.
5. Can be integrated with CI server, such as Jenkins. 

## Issues and TODO

1. Emulator is not stable 

 Most occurred error message, it happens when newly start Android emulator (need to fix this):

    **[UiAutomator] UiAutomator exited unexpectedly with code 255, signal null
    Unhandled rejection Error: UiAUtomator shut down unexpectedly
        at AndroidBootstrap.callee$2$0$ (/usr/local/lib/node_modules/android/node_modules/android-android-bootstrap/lib/bootstrap.js:177:42)
        at tryCatch (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:67:40)
        at GeneratorFunctionPrototype.invoke [as _invoke] (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:315:22)
        at GeneratorFunctionPrototype.prototype.(anonymous function) [as next] (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:100:21)
        at invoke (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:136:37)
        at enqueueResult (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:185:17)
        at new Promise (<anonymous>)
        at new F (/usr/local/lib/node_modules/android/node_modules/core-js/library/modules/$.export.js:30:36)
        at AsyncIterator.enqueue (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:184:12)
        at AsyncIterator.prototype.(anonymous function) [as next] (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:100:21)
        at Object.runtime.async (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:209:12)
        at UiAutomator.callee$2$0 (/usr/local/lib/node_modules/android/node_modules/android-android-bootstrap/build/lib/bootstrap.js:357:42)
        at UiAutomator.emit (events.js:182:13)
        at UiAutomator.changeState (/usr/local/lib/node_modules/android/node_modules/android-uiautomator/lib/uiautomator.js:85:10)
        at SubProcess.<anonymous> (/usr/local/lib/node_modules/android/node_modules/android-uiautomator/lib/uiautomator.js:47:14)
        at SubProcess.emit (events.js:182:13)
        at ChildProcess.<anonymous> (/usr/local/lib/node_modules/android/node_modules/teen_process/lib/subprocess.js:130:14)
        at ChildProcess.emit (events.js:182:13)
        at Process.ChildProcess._handle.onexit (internal/child_process.js:237:12)
    [Appium] Received SIGINT - shutting down

	Unexpected error generated (emulator related ??)
	[debug] [UiAutomator] Moving to state 'stopped'[UiAutomator] UiAutomator exited unexpectedly with code 255, signal null
	Unhandled rejection Error: UiAUtomator shut down unexpectedly
	    at AndroidBootstrap.callee$2$0$ (/usr/local/lib/node_modules/android/node_modules/android-android-bootstrap/lib/bootstrap.js:177:42)
	    at tryCatch (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:67:40)
	    at GeneratorFunctionPrototype.invoke [as _invoke] (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:315:22)
	    at GeneratorFunctionPrototype.prototype.(anonymous function) [as next] (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:100:21)
	    at invoke (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:136:37)
	    at enqueueResult (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:185:17)
	    at new Promise (<anonymous>)
	    at new F (/usr/local/lib/node_modules/android/node_modules/core-js/library/modules/$.export.js:30:36)
	    at AsyncIterator.enqueue (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:184:12)
	    at AsyncIterator.prototype.(anonymous function) [as next] (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:100:21)
	    at Object.runtime.async (/usr/local/lib/node_modules/android/node_modules/babel-runtime/regenerator/runtime.js:209:12)
	    at UiAutomator.callee$2$0 (/usr/local/lib/node_modules/android/node_modules/android-android-bootstrap/build/lib/bootstrap.js:357:42)
	    at UiAutomator.emit (events.js:182:13)
	    at UiAutomator.changeState (/usr/local/lib/node_modules/android/node_modules/android-uiautomator/lib/uiautomator.js:85:10)
	    at SubProcess.<anonymous> (/usr/local/lib/node_modules/android/node_modules/android-uiautomator/lib/uiautomator.js:47:14)
	    at SubProcess.emit (events.js:182:13)
	    at ChildProcess.<anonymous> (/usr/local/lib/node_modules/android/node_modules/teen_process/lib/subprocess.js:130:14)
	    at ChildProcess.emit (events.js:182:13)
	    at Process.ChildProcess._handle.onexit (internal/child_process.js:237:12)
	[Appium] Received SIGINT - shutting down
	[Logcat] Logcat terminated with code null, signal SIGINT

	Process finished with exit code 130 (interrupted by signal 2: SIGINT)**

	2. test data has been changed sometimes

    for example :
    java.lang.AssertionError: expected [ernest.test6@bluebatgames.com] but found [ernest.test7@bluebatgames.com]
    Expected :ernest.test6@bluebatgames.com
    Actual   :ernest.test7@bluebatgames.com

