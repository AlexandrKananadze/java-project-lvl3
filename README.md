# java-project-lvl3

[![hexlet-check](https://github.com/AlexandrKananadze/java-project-lvl3/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/AlexandrKananadze/java-project-lvl3/actions/workflows/hexlet-check.yml)
[![Java CI](https://github.com/AlexandrKananadze/java-project-lvl3/actions/workflows/main.yml/badge.svg)](https://github.com/AlexandrKananadze/java-project-lvl3/actions/workflows/main.yml)
<a href="https://codeclimate.com/github/AlexandrKananadze/java-project-lvl3/maintainability"><img src="https://api.codeclimate.com/v1/badges/a34f670a340d5ac2b6d5/maintainability" /></a>
<a href="https://codeclimate.com/github/AlexandrKananadze/java-project-lvl3/test_coverage"><img src="https://api.codeclimate.com/v1/badges/a34f670a340d5ac2b6d5/test_coverage" /></a>


Цель
Валидатор данных – проект, направленный на прокачку проектирования архитектуры в объектно-ориентированном стиле. Здесь вам понадобится применять практически все, чему вы научились в курсах по ООП: проектирование структуры классов, композиция объектов, возможно наследование и, обязательно, fluent-интерфейс. Вам придется задумываться о глобальном и локальном состоянии, думать о расширяемости кода без его переписывания, соблюдать SOLID принципы.

Описание
Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных. Подобных библиотек множество в каждом языке, так как практически все программы работают с внешними данными, которые нужно проверять на корректность. В первую очередь речь идет про данные форм заполняемых пользователями. За основу для проекта взята библиотека yup.

Пример использования:

import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// объект Map с поддержкой проверки структуры
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false

Предметно-ориентированные языки (DSL)
Интерфейс библиотеки для валидации – яркий пример DSL, специализированного языка, позволяющего декларативно (описательно) описывать то, что вы хотите от кода. Код, написанный в таком стиле, читается значительно легче, чем работа с прямым созданием объектов. Во многом этот подход базируется на паттерне fluent-интерфейс.

Архитектура
Ключевая часть внутренней архитектуры – организация валидаторов. Эту задачу можно решить множеством разных способов, но только некоторые из них дают по-настоящему удобную и расширяемую структуру без излишней сложности. Проектируя архитектуру, крайне легко перестараться и сделать что-то очень сложное.

Тестирование и Отладка
Автоматизированные тесты – неотъемлемая часть профессиональной разработки. Валидатор данных – идеальный проект для прокачки навыка тестирования. Он достаточно простой и удобный для написания тестов, и достаточно сложный для того, чтобы прочувствовать важность этих тестов во время рефакторинга и отладки. В отличие от практики Хекслета, здесь предстоит писать тесты самостоятельно. Причем это можно делать до кода, практикуя TDD.

Для написания тестов используется фреймворк JUnit
