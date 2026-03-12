# Автоматизация тестирования SauceDemo (UI)

Проект по практике в автоматизации тестирования веб-приложения  
https://www.saucedemo.com/

Проект реализует фреймворк для автоматизации UI-тестов с использованием Java, Selenium WebDriver и TestNG.

Цель проекта — продемонстрировать практические навыки в:

- автоматизации UI-тестирования
- работе с Selenium WebDriver
- использовании TestNG
- построении поддерживаемых тестовых фреймворков
- интеграции с CI/CD

[![Build](https://github.com/f0stery/SauceDemo/actions/workflows/maven.yml/badge.svg)](https://github.com/f0stery/SauceDemo/actions/workflows/maven.yml)
![img.png](src/test/resources/screenshots/img.png)

---

## Технологический стек

- Java
- Selenium WebDriver
- TestNG
- Maven
- Allure Reports
- Log4j2
- Jenkins
- GitHub Actions

---

## Особенности фреймворка

- Паттерн Page Object Model (POM)
- Кросс браузерное тестирование
- Повторный запуск упавших тестов (Retry)
- Listeners в TestNG
- Логирование с Log4j2
- Формирование отчётов Allure
- Интеграция с CI/CD: GitHub Actions и Jenkins

---

## Тестовые сценарии

Фреймворк покрывает следующую функциональность:

### Авторизация
- Вход с валидными учётными данными

### Сортировка товаров
- Сортировка по имени (А → Я)
- Сортировка по имени (Я → А)
- Сортировка по цене (возрастание)
- Сортировка по цене (убывание)

### Корзина
- Добавление товара в корзину
- Удаление товара из корзины

### Оформление заказа
- Проверка процесса оформления заказа
- Проверка расчёта итоговой суммы

Полный чек-лист тестовых сценариев доступен в файле:

TEST_CHECKLIST.md

---

## Запуск тестов

Запуск всех тестов: mvn clean test

Запуск конкретного набора тестов: mvn test -DsuiteXmlFile=SmokeTest.xml

---

## Отчёты Allure

После каждого запуска тестов формируется подробный отчёт Allure с графиками, шагами и вложениями.

Последний сгенерированный отчёт доступен по ссылке:




Отчёт обновляется автоматически после каждого прогона тестов в CI.

Детали теста
![img_1.png](src/test/resources/screenshots/img_1.png)

Как сгенерировать локально

mvn allure:serve

---

## CI/CD

Тесты автоматически запускаются при каждом пуше в основную ветку с помощью:

GitHub Actions — для автоматического прогона

Jenkins Pipeline — для демонстрации гибкости CI/CD

---

## Автор

Evgeny Khainiuk

GitHub: https://github.com/f0stery  
LinkedIn: https://www.linkedin.com/in/evgeny-khainiuk/