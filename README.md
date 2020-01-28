"# TestAssignment" 
1. Чтобы скачать проект запускаем команду:
git clone https://github.com/ffellie/TestAssignment.git
2. Заходим в папку TestAssignment:
cd TestAssignment
3. Собираем проект командой:
mvn package
4. Запускаем jar:
    java -jar target/test-assignment-1.0-SNAPSHOT.jar
    ( java -jar target\test-assignment-1.0-SNAPSHOT.jar для Windows)
5. Ждём когда запустится сервер. После запуска сервера заходим в браузере по адресу:
    http://locahost:8080/index
6. Чтобы поменять сообщение заходим в браузере по адресу:
    http://locahost:8080/h2-console
Выбираем Generic H2 (Embedded)
Вводим если не введено:
    Driver Class:	org.h2.Driver
    JDBC URL:	jdbc:h2:mem:testdb
    User Name:	sa
Password оставляем пустым

В появившемся поле вводим команду:
    UPDATE MESSAGES SET message='<Новое сообщение>' WHERE ID=1;
 нажимаем Run
7. Обновляем страничку http://locahost:8080/index и любуемся результатом
