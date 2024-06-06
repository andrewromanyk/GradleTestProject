plugins {
    id("java")
}

group = "ua.edu.ukma"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":Turingmachine"))
    implementation(project(":CaesarCipher"))
    implementation(project(":WriteToFile"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
tasks.wrapper {
    gradleVersion = "9.0"
    distributionType = Wrapper.DistributionType.ALL
}

tasks.register("CheckIfExists") {
    if (file("test.txt").exists()){
        println("File exists")
    }
}

tasks.named("build") {
    dependsOn("CheckIfExists")
}

tasks.register("AddExampleFile") {
    var fileEx = file("./src/main/resources/example.txt")
    if (!fileEx.exists()){
        fileEx.createNewFile()
        fileEx.writeText("This is an example file. When startign the program, you will be prompted to enter your" +
                "text.\nThen it will be added to turing machine and later ciphered with Caesar's Cipher and added as" +
                " a pair to json handler.")
    }
}