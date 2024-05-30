plugins {
    id("java")
}

group = "co.com.yellowpepper"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.rest-assured:rest-assured:4.3.3")
    testImplementation("io.cucumber:cucumber-java:6.10.4")
    testImplementation("io.cucumber:cucumber-junit:6.10.4")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.json:json:20210307")
}

tasks.test {
    useJUnitPlatform()
}

sourceSets {
    test {
        java.srcDir("src/test/java")
    }
}
