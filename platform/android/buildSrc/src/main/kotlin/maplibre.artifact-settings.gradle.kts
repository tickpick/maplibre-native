extra["mapLibreArtifactGroupId"] = "org.maplibre.gl"
extra["mapLibreArtifactId"] = "android-sdk"
extra["mapLibreArtifactTitle"] = "MapLibre Android"
extra["mapLibreArtifactDescription"] = "MapLibre Android"
extra["mapLibreDeveloperName"] = "MapLibre"
extra["mapLibreDeveloperId"] = "maplibre"
extra["mapLibreArtifactUrl"] = "https://github.com/maplibre/maplibre-native"
extra["mapLibreArtifactScmUrl"] = "scm:git@github.com:maplibre/maplibre-native.git"
extra["mapLibreArtifactLicenseName"] = "BSD"
extra["mapLibreArtifactLicenseUrl"] = "https://opensource.org/licenses/BSD-2-Clause"

val versionFilePath = rootDir.resolve("VERSION")

// Allow CI to override the artifact version without rewriting platform/android/VERSION.
// Used by tickpick-release.yml to tag fork builds (e.g. 13.1.0-tickpick.1) without
// polluting the source-controlled VERSION file with our pre-release suffix.
val versionOverride = (project.findProperty("mapLibreVersionOverride") as String?)?.trim()

val versionName = when {
    !versionOverride.isNullOrEmpty() -> versionOverride
    versionFilePath.exists() -> versionFilePath.readText().trim()
    else -> throw GradleException("VERSION file not found at ${versionFilePath.absolutePath}")
}

extra["versionName"] = versionName
