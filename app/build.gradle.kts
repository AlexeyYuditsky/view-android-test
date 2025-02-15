import com.android.builder.core.BuilderConstants

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.alexeyyuditsky.test"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.alexeyyuditsky.test"
        minSdk = 21
        targetSdk = 35
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
            isMinifyEnabled = true
            isShrinkResources = true
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
    sourceSets {
        getByName("main") {
            assets {
                srcDirs("src\\main\\assets", "src\\main\\assets")
            }
        }
    }

    afterEvaluate {
        test()
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.fragment:fragment-ktx:1.8.6")

    implementation("androidx.test.uiautomator:uiautomator:2.3.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.1")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    implementation("com.gu.android:toolargetool:0.3.0")

    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("androidx.work:work-runtime-ktx:2.10.0")

    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("junit:junit:4.13.2")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    implementation ("com.github.tomakehurst:wiremock-jre8-standalone:2.35.1")
}

fun test() {
    val debugBuildType = project
        .extensions
        .getByType<com.android.build.gradle.AppExtension>()
        .buildTypes
        .getByName(BuilderConstants.DEBUG)
    val releaseBuildType = project
        .extensions
        .getByType<com.android.build.gradle.AppExtension>()
        .buildTypes
        .getByName(BuilderConstants.RELEASE)

    if (!debugBuildType.isMinifyEnabled || !debugBuildType.isShrinkResources) {
        throw GradleException("Debug buildType does not have minifyEnabled or shrinkResources set to true")
    }
    if (!releaseBuildType.isMinifyEnabled || !releaseBuildType.isShrinkResources) {
        throw GradleException("Release buildType does not have minifyEnabled or shrinkResources set to true")
    }
}