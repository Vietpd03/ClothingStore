plugins {
    id("com.android.application")

    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.clothingstore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.clothingstore"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
    implementation("com.google.firebase:firebase-auth")


    implementation("com.google.firebase:firebase-analytics")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //implementation("com.paypal.sdk:paypal-android-sdk:2.16.0")


//    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
//    implementation("com.github.bumptech.glide:glide:4.14.2")
//    annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")
//    implementation("com.github.clans:fab:1.6.4")
//    implementation("com.jakewharton:butterknife:10.2.3")
//    annotationProcessor("com.jakewharton:butterknife-compiler:10.2.3")
//    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
//    implementation ("org.jetbrains:annotations:20.1.0")
//    implementation ("com.jakewharton:butterknife:10.2.3")
//    annotationProcessor ("com.jakewharton:butterknife-compiler:10.2.3")
//
//
//    implementation("com.google.firebase:firebase-database")
//    implementation("com.google.firebase:firebase-storage")
//
//    implementation("com.github.mikephil:charting:3.1.0")

}