import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	id("com.thinkimi.gradle.MybatisGenerator") version "2.4"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.yoridori"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.mybatis:mybatis:3.5.11")
	implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.4.0")
	implementation("mysql:mysql-connector-java:8.0.30")
	mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

mybatisGenerator {
	verbose = true
	configFile = "${projectDir}/src/main/resources/generatorConfig.xml"
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
