# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\DIXON\AppData\Local\Android\sdk2/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-ignorewarnings
#-dontwarn org.apache.**
#-keep class com.google.ads.mediation.admob.AdMobAdapter {
#    *;
#}

#-keep class com.google.ads.mediation.AdUrlAdapter {
#    *;
#}
#
#-keep class com.flurry.** { *; }
#-dontwarn com.flurry.**

-keepattributes *Annotation*,EnclosingMethod,Signature
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keep  class * extends java.util.ListResourceBundle {
  protected Object[][] getContents(); }


-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
public static final *** NULL; }


-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}


# The Maps API uses custom Parcelables.
# Use this rule (which is slightly broader than the standard recommended one)
# to avoid obfuscating them


-keepclassmembers class * implements android.os.Parcelable {
    static *** CREATOR;
}



# The Maps API uses serialization.


-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
  static final java.io.ObjectStreamField[] serialPersistentFields;

  private void writeObject(java.io.ObjectOutputStream);

    private void readObject(java.io.ObjectInputStream);
   java.lang.Object writeReplace();
 java.lang.Object readResolve();
}
