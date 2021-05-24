# PROJETO-POO
Desenvolva uma aplicação Web Rest API com Spring Boot para Cadastrar  Eventos:     A entidade EVENT possui:  id name description place start date end date start time end time email contact.    Atenção, para data usar o LocalDate e para o horário usar o LocalTime:  Para mais informações veja: https://medium.com/@racc.costa/data-e-hora-no-java-8-e-no-java-9-5f1e3fd8d560 (Links para um site externo.)     Construir um CRUD Rest para gerenciar eventos seguindo o modelo apresentado até o momento com três profiles: TEST, DEV e PROD.     Pontuação por Tarefa concluída:  Cadastro  - 1 Ponto. Alteração -  1 Ponto. Remoção - 1 Ponto. Listagem Paginada - 1 Ponto. Pesquisa Por Id - 1 Ponto. Pesquisas Diversas Paginadas (filtros): Nome, Por Local do Evento, Data de Início e Descrição  - 2 pontos. Publicação no Heroku: 1 Ponto usando o PostgreSQL. Arquitetura em Camadas Usando DTOs - 1 ponto. Git Hub PRIVADO: 1 Ponto - Fazer pelo menos um commit para cada tarefa acima.  Não esquecer de enviar o convite do GitHub para: glauco.todesco@gmail.com.
#Stéfany Lima - RA 190144

POST ADMIN
{
      "name": "Augusto",
      "email": "augustofernando@gmail.com",
      "phoneNumber": "1199756759"
}

POST EVENTS
{
      "name": "Evento para Gamerssetimo",
      "description": "Evento para Gamers 07",
      "startDate": "2021-03-25",
      "endDate": "2021-04-07",
      "startTime": "11:00",
      "endTime": "22:30",
      "emailContact": "gamerhtjt@gmail.com",
      "amountFreeTickets": 25,
      "amountPayedTickets": 1250,
      "priceTicket": 15.99,
      "idAdmin": 3
}
POST ATTEND
{
      "name": "Bryan",
      "email": "bryan-igor@gmail.com",
      "balance": 0.0
}
POST PLACE
{
      "name": "São Pedro",
      "address": "Rua Stevaux, Centro"
}
    
