plugins {
    alias(libs.plugins.kotlin.serialization)
    kotlin("jvm")
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.json)
    implementation(libs.ktor.client.encoding)
    implementation(libs.brotli)
    implementation(libs.newpipe.extractor)
    testImplementation(libs.junit)

    // Adding missing dependencies for unresolved references
    implementation("com.example:library-for-gridrenderer:1.0.0") // Replace with actual library
    implementation("com.example:library-for-artistitems:1.0.0") // Replace with actual library
}
