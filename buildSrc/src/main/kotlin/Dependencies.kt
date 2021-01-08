object Testing {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.1"
    const val room = "androidx.room:room-testing:2.2.5"
    const val jUnit = "junit:junit:4.13"
    const val extJUnit = "androidx.test.ext:junit:1.1.1"
    const val espresso = "androidx.test.espresso:espresso-core:3.2.0"
    const val okHttp = "com.squareup.okhttp3:mockwebserver:4.4.0"
    const val core = "androidx.arch.core:core-testing:2.1.0"
}

object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:1.4.20"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.20"
    const val gradle = "com.android.tools.build:gradle:4.1.1"
    const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
    const val ktLint = "org.jlleitschuh.gradle:ktlint-gradle:9.2.1"
    const val materialDesign = "com.google.android.material:material:1.2.0"
    const val materialDialog = "com.shreyaspatil:MaterialDialog:2.1"
    const val coil = "io.coil-kt:coil:1.0.0"
}

object Lifecycle {
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
    const val ext = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val navigation = "androidx.navigation:navigation-fragment-ktx:2.3.1"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:2.3.1"
}

object Hilt {
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:2.28-alpha"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
    const val hiltAndroid = "com.google.dagger:hilt-android:2.28-alpha"
}

object Binding {
    const val binding = "com.android.databinding:compiler:3.1.4"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    const val ext = "androidx.lifecycle:lifecycle-extensions:2.2.0"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:4.11.0"
    const val annotation = "com.github.bumptech.glide:annotations:4.11.0"
    const val integration = "com.github.bumptech.glide:okhttp3-integration:4.11.0"
    const val kapt = "com.github.bumptech.glide:compiler:4.11.0"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:2.8.1"
    const val moshiRetrofitConverter = "com.squareup.retrofit2:converter-moshi:2.7.2"
    const val logging = "com.squareup.okhttp3:logging-interceptor:4.9.0"
    const val Gson = "com.squareup.retrofit2:converter-gson:2.5.0"
    const val jackson =
        "group: 'com.squareup.retrofit2', name: 'converter-jackson', version: '2.4.0'"
}

object Android {
    const val appcompat = "com.android.support:appcompat-v7:28.0.0"
    const val coreKtx = "androidx.core:core-ktx:1.2.0"
    const val constraintLayout = "com.android.support.constraint:constraint-layout:2.0.2"
    const val androidx = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val design = "com.android.support:design:28.0.0"
    const val vector = "com.android.support:support-vector-drawable:28.0.0"

}

object Room {
    const val compiler = "androidx.room:room-compiler:2.2.5"
    const val ktx = "androidx.room:room-ktx:2.2.5"
    const val runtime = "androidx.room:room-runtime:2.2.5"
    const val rxJava = "android.arch.persistence.room:rxjava2:2.2.4"
    const val rxJava2 = "androidx.room:room-rxjava2:2.2.5"
}

object RxJava {
    const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.19"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    const val adapter = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0"
    const val logging = "com.squareup.okhttp3:logging-interceptor:4.9.0"
}

object Jackson {
    const val core = "com.fasterxml.jackson.core:jackson-core:2.10.1"
    const val annotation = "com.fasterxml.jackson.core:jackson-annotations:2.10.1"
    const val dataBind = "com.fasterxml.jackson.core:jackson-databind:2.10.1"
}

object Navigation {
    const val navigation = "android.arch.navigation:navigation-fragment-ktx:1.0.0"
    const val ui = "android.arch.navigation:navigation-ui-ktx:1.0.0"
}
object Location {
    const val location = "com.google.android.gms:play-services-location:17.1.0"
    const val gcm = "com.google.android.gms:play-services-gcm:17.0.0"
}