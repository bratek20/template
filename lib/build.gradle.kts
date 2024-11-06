plugins {
    alias(libs.plugins.bratek20.internal.kotlin.library.conventions)
}

dependencies {
    api(libs.bratek20.architecture)
    testFixturesApi(testFixtures(libs.bratek20.architecture))

    api(libs.bratek20.logs)
    testFixturesApi(testFixtures(libs.bratek20.logs.logback))

    //TODO-REF generate web layer in app?
    api(libs.bratek20.infrastructure)
    testFixturesApi(testFixtures(libs.bratek20.infrastructure))
    api(libs.spring.web) // for web server to compile

    //TODO-REF generate web layer in app?
    api(libs.bratek20.spring)
}