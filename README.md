# SBProject
RestFull приложение 


CRUD операции для всех моделей с использованием Generics. 
Используется подход с мапперами.
Примечание:
● Данные из связанных таблиц выводятся без информации друг о друге (только в виде
коллекций с ID), чтобы избежать рекурсии.

Помимо CRUD операций реализованы следующие бизнес операции:
1. Добавление режиссера к фильму и наоборот
2. Возможность взять фильм в аренду/купить
3. Отображение всех заказов у пользователя

API обеспечивает защиту конфиденциальности пользовательских данных с помощью хэширование паролей.
Удаление любых сущностей возможно только с ролью ADMIN и предоставлением JWT.
Просмотр всех заказов пользователя возможен с любой ролью и предоставлением JWT.
Для создания JWT в проекте используется библиотека jjwt (в других проектах используется oauth2).

API задокументировано с использованием Swagger.

#### Технологии : Gradle, Spring-boot, Jpa (Hibernate), PostgreSQL, Lombok, Swagger, Flyway. 
