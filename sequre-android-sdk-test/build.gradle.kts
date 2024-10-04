plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    `maven-publish`
}

apply {
    plugin("maven-publish")
}

android {
    namespace = "id.fh.sequre_android_sdk_test"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        aarMetadata {
            minCompileSdk = 29
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    publishing {
        singleVariant("release"){
            withSourcesJar()
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

group = "id.fh"
version = "1.0.6"


/// for local repository testing
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven"){
                groupId = "id.fh"
                artifactId = "sequre-android-sdk-test"
                version = "1.0.6"

                from(components["release"])
            }
        }
//        repositories {
//            mavenLocal()
//        }
    }
}