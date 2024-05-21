## Estudo Spring

### Introdução

- Instalação Java 17
- Spring Initializer
- Maven
- Controller
- Api Context Path
- XML/Json
- Accept/Content-Type


### Tools

- IntelliJ Community
- Postman

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
- **OPÇÃO 1**
````bash
# Opção 1
sudo apt update
sudo apt install openjdk-17-jdk
java -version

# NOTA 1: Exibe uma lista de versões do Java disponíveis
apt-cache search openjdk

# NOTA 2: A configuração abaixo não é necessária para instalação do Java.
# No entanto algumas aplicações que dependem do Java, requerem a variável
# de ambiente JAVA_HOME que indica o caminho de instalação dele.

# Passo 1: Configurando JAVA_HOME, edite o arquivo .bashrc
sudo vim ~/.bashrc

# Passo 2: Adicione esse trecho ao final do arquivo .bashrc
export JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64
export PATH=$PATH:$JAVA_HOME/bin

# Passo 3: Reload
source ~/.bashrc
echo $JAVA_HOME
````

- **OPÇÃO 2**
````bash
# Opção 2 - SDKMAN
sudo apt update
sudo apt install unzip
sudo apt install zip
sudo apt install curl

curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"

sdk version
sdk list java
sdk install java 17.0.10-tem
sdk current java

# NOTA: A configuração abaixo não é necessária para instalação do Java.
# No entanto algumas aplicações que dependem do Java, requerem a variável
# de ambiente JAVA_HOME que indica o caminho de instalação dele.

# Passo 1: Edite o arquivo .bashrc
cd /home/{user}/
vim /home/{user}/.bashrc

# Passo 2: Adicione esse trecho ao final do arquivo .bashrc
export JAVA_HOME="$HOME/.sdkman/candidates/java/17.0.10-tem"
# ou
export JAVA_HOME="$SDKMAN_CANDIDATES_DIR/java/17.0.10-tem"
# ou
export JAVA_HOME="$SDKMAN_CANDIDATES_DIR/java/current"

# Passo 3: Reload
source .bashrc

# Trocar versão do Java instalado
sdk install java 22-oracle
sdk default java 22-oracle

# Ver versão do java instalado
sdk list java | grep installed
````

- **Executando um programa Java**
````bash
# Criar um arquivo MeuPrograma.java com o conteúdo:
public class MeuPrograma {

    public static void main(String[] args) {
        System.out.println("Java Hello!");
    }
}

# Compilar
javac Main.java
# Executar
java Main
````

### JDK E JRE

O JDK (Java Development Kit) e o JRE (Java Runtime Environment) são duas partes fundamentais da plataforma Java, cada uma com um propósito específico:

**1. JDK (Java Development Kit):**

O JDK é um conjunto de ferramentas de desenvolvimento completo para criar aplicativos Java. Ele inclui o JRE, bem como compiladores, depuradores e outras ferramentas úteis para o desenvolvimento de software em Java. As principais componentes do JDK incluem:
   - **Compilador Java (javac):** Usado para compilar código-fonte Java em bytecode Java.
   - **JRE (Java Runtime Environment):** O JDK inclui o JRE, que é necessário para executar aplicativos Java.
   - **Ferramentas de depuração (jdb):** Usadas para depurar aplicativos Java.
   - **Ferramentas de documentação (javadoc):** Usadas para gerar documentação a partir de código-fonte Java.
   - **Outras ferramentas de desenvolvimento:** O JDK também inclui várias outras ferramentas úteis para o desenvolvimento de software em Java.

**2. JRE (Java Runtime Environment):**

O JRE é um ambiente de tempo de execução para executar aplicativos Java. Ele inclui a JVM (Java Virtual Machine) e bibliotecas de classes Java necessárias para executar aplicativos Java. No entanto, não inclui as ferramentas de desenvolvimento disponíveis no JDK. As principais componentes do JRE incluem:

   - **JVM (Java Virtual Machine):** Executa o bytecode Java em hardware específico e sistema operacional.
   - **Bibliotecas de classes Java:** Conjunto de bibliotecas que fornecem funcionalidades comuns para desenvolvimento de aplicativos Java.
   - **Outros componentes necessários para executar aplicativos Java:** O JRE inclui todos os componentes necessários para executar aplicativos Java, mas não inclui as ferramentas de desenvolvimento disponíveis no JDK.
   
Em resumo, o JDK é usado para desenvolver aplicativos Java, enquanto o JRE é usado para executar aplicativos Java. O JDK inclui o JRE, além de ferramentas de desenvolvimento adicionais, enquanto o JRE inclui apenas o ambiente de tempo de execução necessário para executar aplicativos Java.

### JVM
A JVM (Java Virtual Machine - Máquina Virtual Java) é um componente fundamental da plataforma Java. Ela é uma máquina virtual que fornece um ambiente de execução para programas Java. A principal função da JVM é interpretar o bytecode Java e executá-lo em um hardware específico.

Aqui estão algumas características importantes da JVM:

- **Portabilidade:** A JVM é projetada para ser independente de plataforma. Isso significa que um programa Java compilado para bytecode pode ser executado em qualquer dispositivo ou sistema operacional que tenha uma implementação da JVM disponível.

- **Gerenciamento de Memória:** A JVM gerencia automaticamente a alocação e desalocação de memória para objetos Java. Ela possui um coletor de lixo (garbage collector) embutido que remove objetos não utilizados da memória, liberando espaço para novos objetos.

- **Segurança:** A JVM implementa um modelo de segurança robusto que protege contra ameaças como acesso não autorizado a recursos do sistema, execução de código malicioso e violações de integridade de dados.

- **Just-In-Time (JIT) Compiler:** A JVM utiliza um compilador JIT para melhorar o desempenho. O compilador JIT traduz partes do bytecode Java em código nativo da máquina durante a execução, o que pode resultar em uma execução mais rápida do programa.

- **Suporte a Multithreading:** A JVM oferece suporte a programação multithread, permitindo que os desenvolvedores criem aplicativos Java que podem executar várias tarefas simultaneamente.

Em resumo, a JVM é o coração da plataforma Java, fornecendo um ambiente de execução portável, seguro e eficiente para programas Java. Ela desempenha um papel crucial na popularidade e sucesso da linguagem Java, tornando-a uma das plataformas de desenvolvimento mais amplamente utilizadas em todo o mundo.

### Nota
````text
O arquivo .class é um arquivo de bytecode gerado pelo javac e a JVM consegue interpretar esse arquivo.

OlaMergulhado.java (arquivo de codigo fonte)
OlaMergulhado.class (arquivo de bytecode) Só preciso desse arquivo para rodar o código.

# Executar:
java OlaMergulhado

A JVM executa códigos pre-compilados. Faz o gerenciamento de memória, processos, de segurança, de arquivos.
A JVM faz uma interpretação desse arquivo.

JIT Just in time compiler- compilador: Ele pode transformar instruções do bytecode em código nativo de máquina durante a execução do programa
se ele assim achar necessário, como um código é executado repetidas vezes.  
````

### Cursos
````text
Lambda Java 8 - Playlist
https://www.youtube.com/playlist?list=PLuYctAHjg89ZkhgOQo0zcTtmHY5nuRYud

Spring Academy
https://spring.academy/courses

Kotlin e Spring do ZERO ao Avançado
https://www.udemy.com/course/kotlin-spring

API REST e Spring Boot: Aprenda do Zero e na Prática
https://www.udemy.com/course/api-rest-e-spring-boot-aprenda-do-zero-e-na-pratica
````