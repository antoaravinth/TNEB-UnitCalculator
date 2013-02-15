A Android App which is used to calculate the bill amount for the given input(in Units).

How To Build:
-----------------
The project can be built using the command:

    ant release

Note that you have set up a proper android environment. You need to add your sdk location in 
`local.properties` file like:

    sdk.dir=path-to-your-android-sdk

Once that is done you can issue `ant` commands to build the projects. The list of `ant` commands 
can be found [here][1].

[1]: http://developer.android.com/tools/building/building-cmdline.html#AntReference

To release the *signed* app, set up the key in our local machine and add its path details to
`local.properties` like:

    key.store=path-to-key-store
    key.alias=your-alias-name

Then you can issue `ant release`. Provide the key password when it prompted.


Download The App From Play Store:
----------------------------------

The app can be downloaded from google play store from [here][2]

[2]: https://play.google.com/store/apps/details?id=in.tneb.calculator#?t=W251bGwsMSwxLDIxMiwiaW4udG5lYi5jYWxjdWxhdG9yIl0.

This project is released under [MIT license see here][3].
[3]:

        