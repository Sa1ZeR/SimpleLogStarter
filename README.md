## Описание проекта:
Простое SpringBoot приложение с использование Spring OAP, для логирования операций в приложении.
Данное приложение имитирует управление пользователями и их заказами. Используемый стек технологий: 
- SpringBoot
- Spring Data Jpa
- Spring Web
- Spring OAP
- PostgreSQl
- Swagger

## Инструкция по запуску
- Если у вас не установлен postgre или желаете запустить СУБД с созданной бд, то выполните команду docker-compose up для поднятия образа с postgre
- Запустите приложение через вашу среду разработки или же воспользуйтесь готовыми тестами контроллеров, которые расположены тут: https://github.com/Sa1ZeR/SimpleSpringOAP/tree/master/src/test/java/com/sa1zer/webapp/api

## Информация по endpoint'ам доступна здесь:
http://localhost:3000/swagger-ui/index.html#/
