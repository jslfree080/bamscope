/*
 * MIT License
 *
 * Copyright (c) 2023 Jungsoo Lee
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    application
    kotlin("kapt") version "1.8.0" // kotlin.kapt
}

group = "com.jslfree080"
version = "0.5.2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("info.picocli:picocli:4.7.0") // picocli library
    kapt("info.picocli:picocli-codegen:4.7.0") // picocli-codegen as kapt

    implementation("org.jetbrains.lets-plot:lets-plot-batik:3.0.0")
    implementation("org.jetbrains.lets-plot:lets-plot-jfx:3.0.0")
    implementation("org.jetbrains.lets-plot:lets-plot-common:3.0.0")
    implementation("org.jetbrains.lets-plot:lets-plot-kotlin-jvm:4.2.0")
    implementation("org.jetbrains.lets-plot:lets-plot-image-export:3.0.0")
    implementation("org.slf4j:slf4j-simple:2.0.6") // dependencies for lets-plot library
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11" // version of jvmTarget
}

kapt { // kapt block with the argument project
    arguments {
        arg("project", "${project.group}/${project.name}")
    }
}

application {
    mainClass.set("RunBAMScopeKt")
}

tasks.withType<Jar> {
    // Otherwise you'll get a "No main manifest attribute" error
    manifest {
        attributes["Main-Class"] = "com.jslfree080.bamscope.RunBAMScopeKt"
    }

    // To avoid the duplicate handling strategy error
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // To add all of the dependencies
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

// ./gradlew build |or| ./gradlew clean build (Delete all the previous version of the dependencies)
// java -jar build/libs/bamscope-X.X.X.jar 18:53253385 ~/Downloads/sample_CD005_tcf4.bam -r ~/Downloads/human_g1k_v37_decoy.fasta