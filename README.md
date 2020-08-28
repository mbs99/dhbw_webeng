# Beispielprogramme zur Vorleseung

# Benötigte SW
- JDK-11
- Maven
- Java-IDE mit Maven-Plugin (IntelliJ, VisualStudio Code, ...)
 
## Installation
### Windows
- Download OpenJdk 11 (https://jdk.java.net/archive/)
- Zip-Archiv entpacken
- Umgebungsvariable JAVA_HOME auf Verzeichnis setzen
- Pfad JAVA_HOME\bin in die Umgebungsvariable PATH aufnehmen
- Maven Download + Installation https://maven.apache.org/install.html
- IDE nach Wahl
```sh
$ export JAVA_HOME=...
$ export MAVEN_HOME=...
$ export PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%
```
### Linux
- je nach Distribution
```sh
$ sudo apt install openjdk maven
$ sudo yum install openjdk maven
$ ...
```
### Mac
- Homebrew-Paketmanager (https://brew.sh/index_de)
```sh
$ brew update
$ brew install openjdk@11 maven
```
