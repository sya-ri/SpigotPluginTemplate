# SpigotPluginTemplate
[![EasySpigotAPI](https://img.shields.io/badge/EasySpigotAPI-%E2%AC%85-4D4.svg)](https://github.com/sya-ri/EasySpigotAPI)

[EasySpigotAPI](https://github.com/sya-ri/EasySpigotAPI) を使って簡単にプラグインを作ることができます。

## TODO
変更が必要なところがあります。

パッケージ名を設定しましょう。 ドメインを逆さにするのが定石になります。もしも自分のドメインを持っていない時は GitHub のアカウントを使いましょう。

### [Main.kt](src/main/kotlin/sample/Main.kt)

```kotlin
package sample // TODO 固有のパッケージ名を設定する
```

> e.g. GitHub のユーザー名が `abcdef` で、作るプラグインの名前が `Sample` だったら
>
> ```kotlin
> package com.github.abcdef.sample
> ```

### [build.gradle.kts](build.gradle.kts)

```kotlin
configure<BukkitPluginDescription> {
    // ...
    main = "sample.Main" // TODO JavaPlugin を継承したクラスとパッケージを入力する
    // ...
}
```
> e.g. GitHub のユーザー名が `abcdef` で、作るプラグインの名前が `Sample` だったら
>
> ```kotlin
> configure<BukkitPluginDescription> {
>     // ...
>     main = "com.github.abcdef.sample.Main"
>     // ...
> }
> ```

### plugin.yml

[build.gradle.kts](build.gradle.kts) の中で設定できます。必要であれば設定しましょう。

```kotlin
configure<BukkitPluginDescription> {
    // plugin.yml の中身
}
```

## Gradle Task

### ktlintFormat
```
gradle ktlintFormat
```

ソースコードを綺麗にすることができます。

### addKtlintFormatGitPreCommitHook
```
gradle addKtlintFormatGitPreCommitHook
```

Git Commit する時に `ktlintFormat` を実行します。やっておくことで必ずフォーマットしてくれるようになるので忘れがちな人にオススメです。

### shadowJar
```
gradle shadowJar
```

Jar ファイルを生成します。`build/libs` フォルダの中に生成されます。