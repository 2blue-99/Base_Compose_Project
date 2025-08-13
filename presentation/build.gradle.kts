import java.util.Properties

plugins {
    kotlin("kapt")
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
}

val properties = Properties()
properties.load(project.rootProject.file("local.properties").inputStream())

android {
    namespace = "com.example.base_compose_project"
    compileSdk = 35

    lint {
        // androidx.lifecycle.lint.NonNullableMutableLiveDataDetector 버전 차이 이슈로 우회 처리
        disable += "NullSafeMutableLiveData"
    }

    defaultConfig {
        applicationId = "com.example.base_compose_project"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val nativeAppKey = properties.getProperty("TEST_ID") ?: ""
        manifestPlaceholders["TEST_ID"] = nativeAppKey

        buildConfigField("String", "COMMON_KEY", properties.getProperty("COMMON_KEY"))
    }

    buildTypes {
        debug {
            buildConfigField("String", "TEST_KEY", properties.getProperty("DEV_KEY"))

            applicationIdSuffix = "dev"
        }

        release {
            buildConfigField("String", "TEST_KEY", properties.getProperty("RELEASE_KEY"))

            // 난독화
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(projects.domain)
    implementation(projects.data)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.foundation)

    /* hilt */
    implementation(libs.hilt)
    kapt (libs.dagger.hilt.compiler)
    kapt (libs.androidx.hilt.compiler)

    // Hilt + Compose hiltViewModel()
    implementation(libs.androidx.hilt.navigation.compose)

    // Log
    implementation(libs.timber)

    // 애드몹 광고
//    implementation(libs.play.services.ads)
//    implementation(libs.play.services.ads.api)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Truth - 테스트 로그 라이브러리
    implementation(libs.truth)
    implementation(libs.truth.java8.extension) // Truth가 Java 8에 도입된 기능을 이용해 테스트하도록 만들어주는 추가 라이브러리
}