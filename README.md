## Задача 1 (обязательная)

Эту задачу следует выполнять в одном классе - классе `Main`.

Мы будем писать список покупок. Программа должна будет общаться с пользователем в следующем формате:

1. В цикле предлагать ему на выбор одну из операций: добавить, показать, удалить.
2. Пользователь вводит номер операции
3. Программа запрашивает дополнительные данные для совершения операции, эти данные вводятся одной строкой
4. Программа выполняет операцию, выводит информацию на экран и переходит обратно к пункту вывода меню

### Операция добавить
Операция запрашивает какую покупку добавить в список, добавляет и выводит на экран информацию об итоговом количестве покупок. Пример:
```text
Выберите операцию:
1

Какую покупку хотите добавить?
Сыр
Итого в списке покупок: 4
```

### Операция показать
Операция не запрашивает дополнительных данных и выводит все покупки с их нумерацией. При этом для пользователя мы нумеруем с 1.

```text
Выберите операцию:
2

Список покупок:
1. Молоко
2. Хлеб
3. Сыр
```

### Операция удалить
Операция выводит на экран все покупки и предлагает ввести либо номер покупки для удаления (для пользователя нумерация с 1!), либо название самой покупки.
Формат вывода должен быть такой:

```text
Выберите операцию:
3

Список покупок:
1. Молоко
2. Хлеб
3. Сыр
Какую хотите удалить? Введите номер или название

2

Покупка "Хлеб" удалена, список покупок:
1. Молоко
2. Сыр
```

или по названию:

```text
Выберите операцию:
3

Список покупок:
1. Молоко
2. Хлеб
3. Сыр
Какую хотите удалить? Введите номер или название

Хлеб

Покупка "Хлеб" удалена, список покупок:
1. Молоко
2. Сыр
```

Для реализации этой операции попробуйте сперва распарсить введённые данные как число через `Integer.parseInt`.
Если получится - пользователь ввёл номер для удаления, если нет - название.
Для удаления воспользуйтесь методом `remove` у списка - если передадите туда примитивный `int`, то он удалит по номеру, если объект - найдёт ячейку в которой будет такой же объект и удалит её.
