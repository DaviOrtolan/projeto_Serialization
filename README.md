# Serialização em Java
 
Repositório de estudo sobre **Serialização e Desserialização de objetos em Java**, com um exemplo prático de agenda de contatos.
 
---
 
## Sobre o projeto
 
Este projeto demonstra o uso da API de serialização do Java para persistir uma lista de objetos em arquivo e recuperá-los posteriormente. O exemplo utiliza uma agenda simples com objetos do tipo `Contato`, salvos no arquivo `agenda.ser`.
 
---
 
## Conceitos abordados
 
- **Serialização** — processo de converter um objeto Java em uma sequência de bytes para armazenamento ou transmissão
- **Desserialização** — processo inverso: reconstruir o objeto a partir dos bytes salvos
- **`ObjectOutputStream`** — stream usado para escrever objetos serializados em um arquivo
- **`ObjectInputStream`** — stream usado para ler e reconstruir objetos a partir de um arquivo
- **`try-with-resources`** — garante o fechamento automático dos streams, evitando vazamento de recursos
- **`@SuppressWarnings("unchecked")`** — suprime avisos de casting não verificado ao desserializar coleções genéricas
- **Alternativa sem `@SuppressWarnings`** — uso de `instanceof` com `List<?>` para verificação segura de tipos
---
 
## Estrutura do projeto
 
```
├── Contato.java               # Classe Contato (deve implementar Serializable)
├── ExemploSerializacao.java   # Classe principal com lógica de serialização
└── agenda.ser                 # Arquivo gerado após a execução (binário)
```
 
---
 
## Como executar
 
**Pré-requisitos:** JDK 8 ou superior instalado.
 
```bash
# Compilar
javac Contato.java ExemploSerializacao.java
 
# Executar
java ExemploSerializacao
```
 
**Saída esperada:**
```
Contatos serializados e salvos com sucesso!
Nome: João, Telefone: (17) 99325-5456
Nome: Jorge, Telefone: (15) 96552-5523
Nome: Maria, Telefone: (1) 3388-6216
```
 
---
 
## ⚠️ Ponto de atenção
 
Para que a serialização funcione, a classe `Contato` **precisa implementar a interface `Serializable`**:
 
```java
import java.io.Serializable;
 
public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;
    // ...
}
```
 
---
