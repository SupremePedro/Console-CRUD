# Console-CRUD

Консольное CRUD приложение, которое имеет следующие сущности:

Developer
Skill
Account
AccountStatus (enum ACTIVE, BANNED, DELETED)

Developer -> Set<Skill> skills + Account account
Account -> AccountStatus

В качестве хранилища использоються текстовые файлы:
developers.txt, skills.txt, accounts.txt

Пользователь в консоли имеет возможность создания, получения, редактирования и удаления данных.

Слои:
model - POJO класы
repository - классы, реализующие доступ к текстовым файлам
controller - обработка запросов от пользователя
view - все данные, необходимые для работы с консолью
