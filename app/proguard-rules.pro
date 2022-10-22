# CUSTOM
-keepclassmembers class data.dto.** {*;}

# FIREBASE
-keepattributes Signature
-keepattributes *Annotation*
-keep class persistence.** {*;}
-keep class com.firebase.** { *; }
-keep class org.apache.** { *; }
-keepnames class com.fasterxml.jackson.** { *; }
-keepnames class javax.servlet.** { *; }
-keepnames class org.ietf.jgss.** { *; }
-dontwarn org.apache.**
-dontwarn org.w3c.dom.**
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**
-dontwarn com.squareup.okhttp.**
