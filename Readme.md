## Предисловия
Проект выполнил Четвергов К.Ю., студент ПГУТИ. 3-4 курс.

Дискорд - Четвергов Кирилл.

## О чем проект?
Проект был сделан по тестовому заданию Java "Банк" (описание задания находится по пути "src/task/Задание ЦБ РФ").

В данном проекте была реализована загрузка файла ED807.xml, создание, редактирование его сущностей(по типу BICDirectoryEntry, partinfo и тд).
Ещё была реалзиованы справочники для ED807,их создание, изменение и удаление( по типу AccountStatus)
Также была релизованна базовая Аунтификация.

Для демаршеринга были сгенерированы dto классы из xsd схем скаченных https://www.cbr.ru/development/formats/ (Версия 2024.2.1, действующая с 18.03.2024 г.)

В проекте использовались:
Spring Boot ,Spring Web, SWAGGER, Spring Security, H2-database;
## Запуск проекта
Если запускать через IDEA то запустите класс [Application.java](main%2Fjava%2Fcom%2Fbank%2FApplication.java)


## Команда для запуска:


SWAGGER: http://localhost:8080/swagger-ui/index.html#/