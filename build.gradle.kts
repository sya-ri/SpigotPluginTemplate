import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.minecrell.pluginyml.bukkit.BukkitPluginDescription
import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
    kotlin("jvm") version "1.4.30"
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.3.0"
}

version = "1.0.0"

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

val shadowImplementation: Configuration by configurations.creating
configurations["implementation"].extendsFrom(shadowImplementation)

dependencies {
    shadowImplementation(kotlin("stdlib"))
    implementation("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
    shadowImplementation("com.github.sya-ri:EasySpigotAPI:1.3.0") {
        exclude(group = "org.spigotmc", module = "spigot-api")
    }
}

configure<KtlintExtension> {
    version.set("0.40.0")
}

tasks.withType<ShadowJar> {
    configurations = listOf(shadowImplementation)
    archiveClassifier.set("")
}

configure<BukkitPluginDescription> {
    name = project.name
    version = project.version.toString()
    main = "sample.Main" // TODO JavaPlugin を継承したクラスとパッケージを入力する
    apiVersion = "1.16"
}
