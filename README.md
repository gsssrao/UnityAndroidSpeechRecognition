# UnityAndroidSpeechRecognition
This repository is a Unity plugin for Android Speech Recognition (based on Java implementation). This is just a basic implementation which uses the inbuilt Android Speech Recognition. I have not implemented any functions to change any properties of speech recognition. I plan to add more things once I get more free time. 

## Usage

* You can first test out the `SpeechRecognition.apk` from [here](https://github.com/gsssrao/UnityAndroidSpeechRecognition/releases/tag/1.0). You need a minimum of Android Lollipop to use this apk.
* Next, import `SpeechRecognition.unitypackage` into your Unity project. (Tested on `Unity 5.1.1.f1`)
* To include SpeechReconginition in your own project copy the contents of `Plugins/Android/` into the same folder in your project.
* Have a look at `TestPlugin.cs` for an example usage.
* When you press the button, a speech recognition itent should pop up. This intent sends the recognized text to 'void onActivityResult(string Translation)' function of the object 'MainCamera' (it calls 'MainCamera' and not 'Main Camera'). 
* You can import `TestSpeech` to Android Studio to experiment with it (`speechassist` module is only important).
* Once you make changes and build the module you should have a `speechassist-debug.aar` file in `TestSpeech/speechassist/build/outputs/aar` folder. Rename this to `speechassist-debug.zip` and then unzip it. On unzipping you will get a `classes.jar` file which you will have to copy into `Plugins/Android` folder in Unity. 
* If you make any changes to Andriod activites like `UnityPlayerActivity` please copy the manifest of `speechassist` module as well to `Plugins/Android` folder.
* One more thing to observe is that I have `classes.jar` in my libs folder of my AndroidStudio project. Have a look at [this](http://answers.unity3d.com/questions/182912/location-of-playbackenginesandroidplayerbin-on-a-m.html) post to know where you can find it.

## Note

* I have extended `UnityPlayerActivity` with my custom activity and forced to subsitute it by changing the manifest file. Though, this works it is undesirable when you want to make/use multiple plugins. An ideal way would be to create a custom activity that will be short-lived and its sole purpose would be to get created, do the job (user picks photo from gallery e.g.), deliver result (picked image) into `onActivityResult` and terminate itself. Please refer [this](https://medium.com/@tarasleskiv/unity-android-plugins-and-onactivityresult-callback-abef4b6bbc87#.v81an68si) post for more details on this approach. I will update the plugin once I have more free time.

* On experiecing a problem, feel free to create an issue.

