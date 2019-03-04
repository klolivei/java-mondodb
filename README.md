# API de uma plataforma de receitas

Neste desafio você criará uma API para uma plataforma de receitas.

## Tópicos

Neste desafio você aprenderá:

* Java
* Spring MVC
* MongoDB

## Requisitos

Para este desafio você precisará de:

- Java 8 (ou superior)
- Git
- MongoDB 4.0 (ou superior)

## MongoDB

Instalar o MongoDB e rodar na porta padrão `27017`

https://docs.mongodb.com/manual/installation

## Detalhes

A receita deve ser salva na collection `recipe` e seguir o seguinte esquema:

```json
{
  "_id": "5bc698399531146718e31220",
  "title": "Bolo de chocolate",
  "description": "Bolo de chocolate caseiro",
  "likes": [
    "123",
    "456"
  ],
  "ingredients": [
    "ovo",
    "chocolate"
  ],
  "comments": [
    {
      "_id": "5bc6a737953114503ce9cd7f",
      "comment": "Muito gostoso!"
    }
  ]
}
```

---

A API deve responder pelas seguintes URLs:

## POST /recipe

Adiciona uma nova receita.
* Deve retornar o objeto adicionado com o `id` gerado.

##### Request body
```json
{
  "title": "Bolo de chocolate",
  "description": "Bolo de chocolate caseiro",
  "ingredients": [
    "ovo",
    "chocolate"
  ]
}
```

##### Response body
```json
{
  "id": "5bc698399531146718e31220",
  "title": "Bolo de chocolate",
  "description": "Bolo de chocolate caseiro",
  "ingredients": [
    "ovo",
    "chocolate"
  ]
}
```

## PUT /recipe/{id}

Atualiza uma receita.
* Somente os campos `title`, `description` e `ingredients` devem ser atualizados.
* Os demais campos devem continuar iguais.

##### Request body:
```json
{
  "title": "Bolo de chocolate",
  "description": "Bolo de chocolate caseiro",
  "ingredients": [
    "ovo",
    "chocolate"
  ]
}
```

## DELETE /recipe/{id}

Remove uma receita.

## GET /recipe/{id}

Retorna uma receita.

##### Response body
```json
{
  "id": "5bc698399531146718e31220",
  "title": "Bolo de chocolate",
  "description": "Bolo de chocolate caseiro",
  "likes": [
    "123",
    "456"
  ],
  "ingredients": [
    "ovo",
    "chocolate"
  ],
  "comments": [
    {
      "id": "5bc6a737953114503ce9cd7f",
      "comment": "Muito gostoso!"
    }
  ]
}
```

## GET /recipe/ingredient

Lista as receitas que possuem determinado ingrediente.
* Ordenar pelo campo `title` em ordem alfabética ascendente.
* Ex: /recipe/ingredient?ingredient=ovo

##### Request param
* `ingredient` 

##### Response body
```json
[
  {
    "id": "5bc698399531146718e31220",
    "title": "Bolo de chocolate",
    "description": "Bolo de chocolate caseiro",
    "likes": [
      "123",
      "456"
    ],
    "ingredients": [
      "ovo",
      "chocolate"
    ],
    "comments": [
      {
        "id": "5bc6a737953114503ce9cd7f",
        "comment": "Muito gostoso!"
      }
    ]
  },
  {
    "id": "5bc932af9531144888cc2bd2",
    "title": "Sopa de legumes",
    "description": "Sopa de legumas com ovo e lentilha ",
    "ingredients": [
      "cenoura",
      "cebola",
      "ovo"
    ]
  }
]
```

## GET /recipe/search

Pesquisa de receitas.
* Deve pesquisar nos campos `title` e `description`
* Deve pesquisar em qualquer lugar do texto
* Deve pesquisar usando `case-insensitive`
* Ordenar pelo campo `title` em ordem alfabética ascendente.
* Ex: /recipe/search?search=choco

##### Request param
* `search` 

##### Response body
```json
[
  {
    "id": "5bc698399531146718e31220",
    "title": "Bolo de chocolate",
    "description": "Bolo de chocolate caseiro",
    "likes": [
      "123",
      "456"
    ],
    "ingredients": [
      "ovo",
      "chocolate"
    ],
    "comments": [
      {
        "id": "5bc6a737953114503ce9cd7f",
        "comment": "Muito gostoso!"
      }
    ]
  },
  {
    "id": "5bc932949531144888cc2bd1",
    "title": "Torta de chocolate",
    "description": "Torta de chocolate com morango",
    "ingredients": [
      "chocolate",
      "morango"
    ]
  }
]
```

## POST /recipe/{id}/like/{userId}

Curtir uma receita.
* Deve ser enviado um `userId` arbitrário para dizer qual usuário está curtindo a receita.
	* *Obs: Em uma aplicação real, o `userId` seria pego do usuário autenticado.*
* O `userId` deve ser inserido na última posição do array do campo `likes`

## DELETE /recipe/{id}/like/{userId}

"Descurtir" uma receita.
* Deve ser enviado um `userId` arbitrário para dizer qual usuário está "descurtindo" a receita.
	* *Obs: Em uma aplicação real, o `userId` seria pego do usuário autenticado.*

## POST /recipe/{id}/comment

Adiciona um comentário em uma receita.
* Gerar um `ObjectId` antes de salvar
* Deve retornar o objeto adicionado com o `id` gerado.
* O comentário deve ser inserido na última posição do array do campo `comments`

##### Request body
```json
{
  "comment": "Muito gostoso!"
}
```

##### Response body
```json
{
  "id": "5bcbef8b9531144334eaec8e",
  "comment": "Muito gostoso!"
}
```

## PUT /recipe/{id}/comment/{commentId}

Atualiza um comentário de uma receita.

##### Request body
```json
{
  "comment": "Muito gostoso!"
}
```

## DELETE /recipe/{id}/comment/{commentId}

Remove um comentário de uma receita.

---

#### Rodando a aplicação

Executar o comando `gradlew bootRun`

A aplicação estará disponível em `http://localhost:8080`
# java-mondodb
