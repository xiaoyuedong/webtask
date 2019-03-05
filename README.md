# webtask
## MACOS環境
### Spring Tool Suite 4 ダンロード
https://spring.io/tools
### Java環境
1.ダンロード　[Java SE Development Kit 11.0.2](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)<br>
2.JAVA環境変数設定
> export JAVA_HOME=$(/usr/libexec/java_home -v 11)<br>
### MavenはすでにSTS４に埋め込んでいる
### 自分でMavenを配置したい場合
1.ダンロード　[apache-maven-3.6.0-bin.zip](https://maven.apache.org/download.cgi)<br>
2.任意の場所に解凍<br>
3.Maven環境変数設定
>export M2_HOME=/yourfilelocation/apache-maven-3.6.0 <br>
export PATH=$PATH:$M2_HOME/bin 
### DB環境
1.ダンロード　[mysql-8.0.15-macos10.14-x86_64.dmg](https://dev.mysql.com/downloads/mysql/)<br>
2.MySQL環境変数設定
>export PATH=$PATH:/usr/local/mysql/bin
### Import Existing Maven Project
### Run As Spring Boot App
## 定義書のswaggerでの見方
Appを起動して下記のURLをアクセス
* http://localhost:8080/swagger-ui.html
