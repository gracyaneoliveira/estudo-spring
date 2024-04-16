## Introdução a Arquitetura REST

**Representational State Transfer**, ou simplesmente **REST**, é um estilo de arquitetura para sistemas distribuídos que permitir a comunicação entre sistemas de forma simples, escalável e padronizada. Essa arquitetura é amplamente utilizada para a criação de **APIs (Application Programming Interface)** e serviços web, permitindo que diferentes aplicativos se comuniquem e compartilhem recursos entre si. O REST enfatiza a interoperabilidade entre diferentes sistemas e a separação de preocupações entre servidor e cliente, tornando os sistemas mais flexíveis, fáceis de manter e evoluir.

O estilo arquitetural REST foi criado pelo cientista da computação **Roy Fielding** durante seu doutorado pela Universidade da Califórnia. É importante destacar que API REST não é a única nomenclatura aceita, embora seja a mais utilizada, podemos ver referências citando API RESTful ou Web Service REST.

## O que é API REST?
Uma **API REST** é um tipo de API baseado na arquitetura REST que permite a comunicação entre diferentes sistemas de softwares. Ela define um conjunto de operações (métodos HTTP) que podem ser usadas para criar, ler, atualizar e excluir recursos (dados) em um servidor web. Uma API REST usa **URIs (Identificadores Uniformes de Recursos)** para identificar os recursos e o formato **JSON** ou **XML** para representar dados transferidos entre os sistemas. Com uma API REST, diferentes aplicativos podem se comunicar e compartilhar recursos entre si de forma padronizada.

### URI -  Uniform Resource Identifier 

O URI (**Identificador Uniforme de Recursos**) é usado para identificar e localizar recursos na internet.
- Um URI é uma cadeia de caracteres que identifica de forma exclusiva um recurso, seja um documento, uma imagem, um serviço, etc.
- Um URI pode ser uma URL ou um URN (Nome de Recurso Uniforme). URNs são uma forma de nomear recursos sem especificar como acessá-los, enquanto URLs especificam como acessar o recurso.

**Exemplo:** `https://corporation.com/cursos/`
- A URI une o Protocolo (**`https://`**);
- A localização do recurso (URL - **`corporation.com`**);
- E o nome do recurso (URN - **`/cursos/`**)

### URL -  Uniform Resource Locator

- Uma **URL(Localizador Uniforme de Recurso)** é um tipo de URI que fornece o meio para localizar um recurso na web e especifica como acessá-lo.
- Uma URL contém informações sobre o **protocolo de comunicação** a ser usado (como HTTP, HTTPS, FTP), o **nome de domínio** do servidor onde o recurso está localizado e o **caminho para o recurso** no servidor.

**Exemplo**: `https://www.example.com/index.html`
- Esquema: **`https://`**
- Nome de domínio: **`www.example.com`** 
- Caminho para o recurso: **`/index.html`**

### Métodos HTTP
Os **métodos HTTP** são comandos que indicam a ação a ser realizada em um recurso identificado por uma **URI**. Eles definem o tipo de operação que será realizada em um recurso quando uma solicitação HTTP é feita a um servidor web. 

> Um método HTTP **idempotente** é um **método HTTP** que pode ser chamado várias vezes **sem alterar os resultados**. Não importa se o método é chamado apenas uma vez ou dezenas de vezes. O resultado deve ser o mesmo.

Os métodos HTTP mais comuns são:

- **GET** 

    É usado para recuperar um recurso do servidor. É uma operação segura e **idempotente**, ou seja, várias solicitações para o mesmo recurso retornarão o mesmo resultado e não modificará o estado do recurso no servidor.
    
  **Alguns casos de uso do GET:**
  - Recuperar uma página da web 
  - Buscar a lista de postagens de um blog 
  - Download de arquivo de um servidor


- **POST**
    
    É usado para criar um novo recurso no servidor. **Não é considerado um método idempotente**, o que significa que várias solicitações para criar o mesmo recurso resultará em vários recursos sendo criados. As solicitações POST também podem modificar o estado do recurso no servidor.

  **Alguns casos de uso do POST:**
  - Criação de uma nova conta de usuário 
  - Carregar uma nova imagem ou arquivo 
  - Enviar um formulário a um servidor para criar um novo recurso


- **PUT**
    
    É usado para atualizar um recurso existente no servidor. **É considerado idempotente**, o que significa que várias solicitações para atualizar o mesmo recurso resultarão em o mesmo estado do recurso no servidor. O PUT também pode criar um novo recurso se o recurso que está sendo atualizado não existe.
  
  **Casos de uso para PUT:**
  - Atualizar o conteúdo de uma postagem de blog 
  - Modificar os detalhes de uma conta de usuário 
  - Substituir um arquivo ou imagem em um servidor por um nova versão 
  - Atualizar todo o endereço de um contato


- **PATCH**
    
    O método PATCH é usado para fazer uma atualização parcial em um recurso existente no servidor. O objetivo é realizar atualizações em campos ou propriedades específicas de um recurso, sem exigir que todo o recurso seja enviado ao servidor.

  **Casos em que o PATCH é usado:**
  - Atualizar somente o título ou descrição de uma postagem de blog 
  - Alterar a senha ou endereço de e-mail associado a uma conta de usuário


- **DELETE**
    
    O verbo **DELETE** é usado para excluir um recurso do servidor. **É considerado idempotente**, o que significa que várias solicitações para excluir o mesmo recurso resultarão no mesmo estado do servidor. Isso parece estranho e gera muitas dúvidas. Mas na verdade, ao executar a primeira solicitações de DELETE para o recurso, ele será excluído e a resposta será 200 (OK) ou 204 (No Content). As próximas solicitações para o mesmo recurso (já excluído) retornarão 404 (não encontrado). Claramente, a resposta é diferente da primeira solicitação, mas não há mudança de estado para nenhum recurso do lado do servidor porque o recurso original já foi excluído.
  
  **Usar casos para DELETE incluem:**
  - Remover uma postagem de blog 
  - Excluir uma conta de usuário 
  - Remover um arquivo ou imagem

  **Nota:** Podemos destacar que uma operação de exclusão pode ser física ou lógica. A física é quando o recurso é realmente excluído da base de dados e a lógica quando uma coluna na tabela do recurso indica que ele foi excluído, mesmo ainda estando presente na tabela. A exclusão lógica é muito usada para manter dados históricos.

### Demais métodos HTTP
O protocolo HTTP tem mais alguns métodos além dos citados. Caso queira conhecer outros métodos, como HEAD, OPTIONS, TRACE, etc, acesse - [Métodos de requisição HTTP](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Methods).