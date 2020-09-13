import MyConfig.publicationName
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    id("com.timhuang.gradleplu")
    `maven-publish`
    id("com.jfrog.bintray")
}


val androidSourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}

publishing {
    publications {
        create<MavenPublication>(publicationName) {
            artifact(androidSourcesJar.get())
            artifact("$buildDir/outputs/aar/cropper-release.aar")
            groupId = "com.timhuang"
            artifactId = "croppableimageview"
            version = "1.0.4"

        }
    }

}


bintray {

    user = gradleLocalProperties(rootDir).getProperty("BINTRAY_USER")
    key = gradleLocalProperties(rootDir).getProperty("BINTRAY_API_KEY")
    dryRun = false
    publish = true
    setPublications(publicationName)

    pkg(delegateClosureOf<com.jfrog.bintray.gradle.BintrayExtension.PackageConfig> {
        repo = publicationName
        name = "com.timhuang.CroppableImageView"
        desc = "Croppable ImageView in Kotlin"
        publicDownloadNumbers = true
        version.apply {
            name = "1.0.4"
            vcsTag = "1.0.4"
            released = MyConfig.today
        }

    })
}
