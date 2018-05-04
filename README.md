# UnityAndroidSpeechRecognition
This repository is a Unity plugin for Android Speech Recognition (based on Java implementation). This is just a basic implementation which uses the inbuilt Android Speech Recognition. I have implemented some additional functions to give some basic functionality. 

## Features

* Set Recognition Language
* Set the max number of results
* Set the prompt question

## Usage

* You can first test out the `SpeechRecognition.apk` from [here](https://github.com/gsssrao/UnityAndroidSpeechRecognition/releases/download/2.1/SpeechPlugin.apk). You need a minimum of Android Lollipop (API Level 21) to use this apk.
* Next, import `SpeechRecognition.unitypackage` into your Unity project. (Tested latest on `Unity 2018.1.0f2`)
* To include SpeechReconginition in your own project copy the contents of `Plugins/Android/` into the same folder in your project and have a look at `Test.cs` and `ReceiveResult.cs` for an example usage. `Test.cs` has function for calling the speech recognition popoup whereas `ReceiveResult.cs` has function which receives the recognized text.
* When you press the button, a speech recognition itent should pop up. This intent sends the recognized text to 'void onActivityResult(string recognizedText)' function of the object 'Main Camera' (You can change the object to which `ReceiveResult.cs` should be attached by changing the object name in `Test.cs`. The default return object is set to 'Main Camera').
* You can change the following line `pluginClass.CallStatic("setLanguage", "en_US")` in `Test.cs` to change the language. A list of languages along with their tags is present in the `languages.txt` file. This file is **not exhaustive**.
* Similarly you can also manipulate other features like maximum number of results etc (In case of the max number of results, this is literally maximum and the number of results you get may not always be this number, but it would be definitely less than this number).

## Experimenting

* You can import `SpeechPlugin` to Android Studio to experiment with it (`pluginlibrary` module is only important).
* Once you make changes and build the module you should have a `pluginlibrary-release.aar` file in `SpeechPlugin/pluginlibrary/build/outputs/aar` folder. Rename this to `speechassist-debug.zip` and then unzip it. On unzipping you will get a `classes.jar` file which you will have to copy into `Plugins/Android` folder in Unity along with the `AndroidManifest.xml`. The manifest specifies the activity class which extends the `UnityPlayerActivity` and hence is necessary. If you already have a manifest in plugins folder, I would recommend against copying this manifest as it can cause confilict. Instead, you can modify the manifest which you already have to specify the activity class which extends the `UnityPlayerActivity`.
* One more thing to observe is that I have `classes.jar` in my libs folder of my AndroidStudio project. Have a look at [this](http://answers.unity3d.com/questions/182912/location-of-playbackenginesandroidplayerbin-on-a-m.html) post to know where you can find it.

## Note

* I have extended `UnityPlayerActivity` with my custom activity and forced to subsitute it by changing the manifest file. Though, this works it is undesirable when you want to make/use multiple plugins. An ideal way would be to create a custom activity that will be short-lived and its sole purpose would be to get created, do the job (user picks photo from gallery e.g.), deliver result (picked image) into `onActivityResult` and terminate itself. Please refer [this](https://medium.com/@tarasleskiv/unity-android-plugins-and-onactivityresult-callback-abef4b6bbc87#.v81an68si) post for more details on this approach. I will update the plugin once I have more free time.

* On experiencing a problem, feel free to create an issue.

* If you want any additional features too, feel free to create an issue.