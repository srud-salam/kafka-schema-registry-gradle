plugins {
    id("java")
    id("com.github.davidmc24.gradle.plugin.avro") version "1.2.0"
}

group = "come.dmi.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://packages.confluent.io/maven/")
}

avro {
    setFieldVisibility("PRIVATE")
    isCreateSetters = false
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.5")
    implementation("org.projectlombok:lombok:1.18.32")
    implementation("org.springframework.kafka:spring-kafka:3.1.4")
    implementation("org.springframework.kafka:spring-kafka-test:3.1.4")
    implementation("org.springframework.boot:spring-boot-maven-plugin:3.2.5")
    implementation("org.wso2.orbit.io.confluent:kafka-avro-serializer:7.6.0.wso2v1")
    implementation("org.wso2.orbit.io.confluent:kafka-schema-registry-client:7.6.0.wso2v1")
    implementation("org.apache.avro:avro:1.11.3")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}