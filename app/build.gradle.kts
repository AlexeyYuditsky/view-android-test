plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    kotlin("plugin.serialization")
    id("com.apollographql.apollo") version "4.1.1"
    id ("com.google.dagger.hilt.android")
    id ("kotlin-parcelize")
}

apollo {
    service("service") {
        packageName.set("com.alexeyyuditsky")
    }
}

android {
    namespace = "com.alexeyyuditsky.test"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.alexeyyuditsky.test"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
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
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.16.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.fragment:fragment-ktx:1.8.6")

    implementation("androidx.test.uiautomator:uiautomator:2.3.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.2")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")

    implementation("com.gu.android:toolargetool:0.3.2")

    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("androidx.work:work-runtime-ktx:2.10.0")

    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("junit:junit:4.13.2")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

    implementation ("com.github.tomakehurst:wiremock-jre8-standalone:3.0.1")

    implementation("com.apollographql.apollo:apollo-runtime:4.1.1")

    implementation ("com.google.dagger:hilt-android:2.56.1")
    ksp ("com.google.dagger:hilt-compiler:2.56.1")
}