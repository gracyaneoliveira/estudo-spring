## Estudo Spring

### Introdução

- Instalação Java 17
- Spring Initilizer
- Maven
- Controller
- Api Context Path
- XML/Json
- Accept/Content-Type


### **Api Context Path**
````properties
server.servlet.context-path=/api
````

### **XML**
````xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
````

### Install Java
````bash
# Opção 1
sudo apt update
java -version
sudo apt install openjdk-17-jre-headless

# Configurando JAVA_HOME
sudo vim /etc/environment
JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
source /etc/environment
echo $JAVA_HOME

# Testando
# Criar um arquivo MeuPrograma.java com o conteudo:
public class MeuPrograma {

    public static void main(String[] args) {
        System.out.println("Java Hello!");
    }
}

# Compilar:
javac Main.java
# Executar
java Main


# Opção 2 - SDKMAN
sudo apt update
sudo apt install unzip
sudo apt install zip
sudo apt install curl

curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"

sdk version
sdk java list
sdk install java 17.0.10-tem
sdk current java

cd /home/{user}/
vim /home/{user}/.bashrc

# Conteúdo do arquivo .bashrc
export JAVA_HOME="$HOME/.sdkman/candidates/java/17.0.10-tem"
# ou
export JAVA_HOME="$SDKMAN_CANDIDATES_DIR/java/17.0.10-tem"
# ou
export JAVA_HOME="$SDKMAN_CANDIDATES_DIR/java/current"

source .bashrc

# Trocar versão do Java instalado
sdk install java 22-oracle
sdk default java 22-oracle

sdk list java | grep installed
````
