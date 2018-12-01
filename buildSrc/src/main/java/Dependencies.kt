object Versions {
    const val androidPlugin = "3.2.1"
    const val compileSdk = 28
    const val minSdk = 21
    const val targetSdk = 28
    const val kotlin = "1.3.10"
    const val appcompat = "1.0.2"
    const val archComponentsLifeCycle = "2.0.0"
    const val dagger = "2.10"
}

object Libs {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinJre7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val archExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.archComponentsLifeCycle}"
    const val archCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.archComponentsLifeCycle}"
    const val daggerMain = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAnnotations = "javax.annotation:javax.annotation-api:1.2"
}