plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android") version "2.51.1" apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.8.10" apply true
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.learningassistant"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.learningassistant"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

//        annotationProcessorOptions {
//            arguments = ["room.schemaLocation": "$projectDir/schemas".toString()]
//        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.media3.common)
    implementation(libs.androidx.media3.ui)
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.exoplayer.dash)
    implementation(libs.androidx.media3.exoplayer.smoothstreaming)
    implementation(libs.androidx.media3.exoplayer.hls)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)




    implementation("com.pierfrancescosoffritti.androidyoutubeplayer:chromecast-sender:0.28")


    implementation ("androidx.media3:media3-exoplayer:1.0.0-beta02")
    implementation ("androidx.media3:media3-ui:1.0.0-beta02")

    val hiltVersion = "2.51.1"

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    //kapt("androidx.hilt:hilt-compiler:1.1.0") // Remains the same
    //implementation("androidx.hilt:hilt-navigation-compose:1.1.0")


    implementation ("com.google.dagger:hilt-android:$hiltVersion")
    kapt ("com.google.dagger:hilt-compiler:$hiltVersion")

    // For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:$hiltVersion")
    kaptAndroidTest ("com.google.dagger:hilt-compiler:$hiltVersion")

    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:$hiltVersion")
    kaptTest ("com.google.dagger:hilt-compiler:$hiltVersion")

    // Material extend Icons

    implementation (libs.androidx.material.icons.extended)


    implementation (libs.ktor.client.core)
    implementation (libs.ktor.client.android)
    implementation (libs.ktor.client.serialization)
    implementation (libs.ktor.client.logging)
    implementation (libs.logback.classic)


    implementation(libs.kotlinx.serialization.json)



    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.1.1"))


    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")


    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries
}