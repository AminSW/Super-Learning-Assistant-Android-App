// Top-level build file where you can add configuration options common to all sub-projects/modules.
//buildscript {
//    dependencies {
//        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
//    }
//}//

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.8.10" apply true
    id("com.google.gms.google-services") version "4.4.2" apply false

}

