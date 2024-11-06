
# Проект по автоматизации тестирования для мобильного приложения [Wikipedia](https://wikipedia.com/) для Android

> Википедия — это свободная онлайн-энциклопедия, редактируемая пользователями со всего мира, которая предоставляет бесплатный доступ к информации по множеству тем.

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>   
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>    
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
</p>

____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
____
- ✓ *Успешный поиск*
- ✓ *Неуспешный поиск*
- ✓ *Пропуск онбординга нового пользователя*
- ✓ *Успешное прохождение онбординга*
____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/029-anastasia-yildirim-qa_guru_java-wikipedia_mobile_tests/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/029-anastasia-yildirim-qa_guru_java-wikipedia_mobile_tests/"><img src="images/screen/jenkins_build.png" alt="Jenkins" width="950"/></a>  
</p>

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***

Для запуска через Browserstack:
```bash  
gradle clean browserstack -DdeviceHost=browserstack -Dusername=ЛОГИН -Dpassword=ПАРОЛЬ
```
Чтобы получить ЛОГИН и ПАРОЛЬ, можно зарегистрироваться на [BrowserStack](https://www.browserstack.com/)


Для запуска через эмулятор:
```bash  
gradle clean emulator -DdeviceHost=emulator -DdeviceName=ДЕВАЙС -DplatformVersion=ВЕРСИЯ
```
По умолчанию:
deviceName=Pixel 4 API 30
platformVersion=11.0

***Удалённый запуск через Jenkins:***
```bash  
clean browserstack -DdeviceHost=browserstack
```

___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/029-anastasia-yildirim-qa_guru_java-wikipedia_mobile_tests/3/allure)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/allure_overview.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screen/allure_tests.png" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/screen/allure_graphs.png" width="850">

<img title="Allure Graphics" src="images/screen/allure_graphs2.png" width="850">  
</p>

____
<a id="telegram"></a>
## <img alt="Telegram" height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Telegram Notification" src="images/screen/telegram.png" width="550">  
</p>

____
<a id="video"></a>
## <img alt="BrowserStack" height="25" src="images/logo/BrowserStack.svg" width="25"/></a> Примеры видео выполнения тестов на BrowserStack
____
<p align="center">
<img title="BrowserStack Video" src="images/video/browserstack_video.mp4" width="200" alt="video">   
</p>

____
<a id="video"></a>
## Пример видео выполнения тестов локально через эмулятор
____
<p align="center">
<img title="Emulator Video" src="images/video/emulator_video.mp4" width="200" alt="video">   
</p>
