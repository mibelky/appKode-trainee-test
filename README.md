# Тестовое задание для KODE
Этот проект - реализация тестового [задания](https://github.com/appKODE/trainee-test-android).
Дизайн-проект в [Figma](https://www.figma.com/file/GRRKONipVClULsfdCAuVs1/KODE-Trainee-Dev-%D0%9E%D1%81%D0%B5%D0%BD%D1%8C'21?node-id=1-410&t=QBlvco1AutF9YUXp-0).
## Стэк

## Декомпозиция и планирование

1. Создание okHTTP и Retrofit сервиса - 2 часа
   _ Создание класса employee, повторяющего структуру ответа от API 
   _ Создание клиента okHTTP
   _ Создание retrofit интерфейса с Moshi конвертером
2. Создание ViewModel - 1 час
   _ При инициализации запрос листа от API, если успех, сохранение в лайвдату, иначе переход на фрагмент ошибки - 1/2 часа
3. Создание пустых фрагментов и задание навигации - 1 час
   _ Создание action
     _ Action mainFragment to profileFragment
     _ Action mainFragment to errorFragment
4. Добавление стилей для типографики (в процессе добавления текста) 1 час 
5. Создание главного фрагмента 6 часов
   _ Добавление Swipe to refresh Layout 1 час 
   _ Добавление RecyclerView 1 час 
   _ Добавление строки поиска 2 час 
     _ Добавление кнопки сортировка
       _ Добавление боттом шит
         _ Добавить сортировку по алфавиту
         _ Добавить сортировку по дате рождения
         _ Добавить разделитель в рейсаклервью
   _ Добавление панели вкладок 1 час 
     _ Добавление фильтрации списка по отделам
   _ Добавление поиска 1 час
     _ Добавление алгоритма фильтрации списка по содержимому строки поиска
     _ Добавление заглушки в случае пустого списка
6. Создание экрана профиля 3 часа
   _ Добавление интента для звонка
   _ Добавление и обработка кастомной кнопки back (action bar или кнопка?)
7. Разобраться с иконками - 2 часа
   _ Что нужно? 1/2 часа
   _ Как это делается? 1/2 часа
   _ Добавить нужные иконки для нужных разрешений 1 час