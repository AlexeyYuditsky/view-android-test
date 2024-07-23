import com.android.builder.core.BuilderConstants

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.alexeyyuditsky.test"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.alexeyyuditsky.test"
        minSdk = 21
        targetSdk = 34
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
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.fragment:fragment-ktx:1.8.1")

    implementation("androidx.test.uiautomator:uiautomator:2.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")

    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.1")

    implementation("com.gu.android:toolargetool:0.3.0")

    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.work:work-runtime-ktx:2.9.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
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