import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>(); // Список покупок
        String product; // Добавить продукт

        while (true) {
            System.out.println("Выберите операцию введя её номер: \n"
                    + "1. Добавить.\n"
                    + "2. Показать.\n"
                    + "3. Удалить. \n"
                    + "4. Найти. \n"
                    + "5. Выход из программы или введите end");
            String resultSelect = in.nextLine().trim();
            if (isExit(resultSelect)) { // проверка на выход
                break;
            }
            if (isInteger(resultSelect) || (isByte(resultSelect))) {
                System.out.println("------------------------\n" +
                        "Неправильный выбор. \n" +
                        "Введите цифру от 1 до 4.\n" +
                        "------------------------");
            } else {
                switch (Byte.parseByte(resultSelect)) {
                    case (1):
                        System.out.println("Какую покупку хотите добавить?");
                        product = in.nextLine();
                        if (isExit(product)) { // проверка на выход
                            break;
                        }
                        if (isEmpty(product)) { // проверка на пустое значание
                            actionList(list, product, "add");
                        }
                        break;
                    case (2):
                        outputList(list); // вывод списка продуктов
                        break;
                    case (3):
                        System.out.println("Какую хотите удалить? Введите номер или название");
                        outputList(list); // вывод списка продуктов
                        product = in.nextLine();
                        if (isExit(product)) { // проверка на выход
                            break;
                        }
                        if (isEmpty(product)) { // проверка на пустое значание
                            if (isInteger(product)) { // проверка на числовое значание
                                actionList(list, product, "delete by name"); // удаляем по индексу
                            } else {
                                actionList(list, product, "delete by index"); // удаляем по имени
                            }
                        }
                        outputList(list); // вывод списка продуктов
                        break;
                    case (4):
                        System.out.println("Введите текст для поиска?");
                        product = in.nextLine();
                        if (isExit(product)) { // проверка на выход
                            break;
                        }
                        if (isEmpty(product)) { // проверка на пустое значание
                            actionList(list, product, "find"); // поиск значения
                        }
                        break;
                    case (5):
                        isExit("end");
                        break;
                }
            }
        }
        in.close();
    }

    public static boolean isInteger(String str) { // проверка соотвествия типу данных
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isByte(String str) { // проверка соотвествия типу данных
        try {
            Byte.parseByte(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isExit(String str) { //проверка на значение выхода из программы
        if (str.trim().equals("end")) {
            System.out.println("Программа завершилась.");
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        if (str.isEmpty()) {
            System.out.println("Пустое значение добавить в список нелья");
            return false;
        }
        return true;
    }

    public static void outputList(List<String> list) {
        System.out.println("Список покупок: ");
        list.forEach((c) -> System.out.println(list.indexOf(c) + 1 + ". " + c));
    }

    public static void actionList(List<String> list, String product, String action) {
        if (action.equals("add")) {
            list.add(product);
        }
        if (action.equals("delete by index")) {
            list.remove(list.get(Integer.parseInt(product) - 1));
        }
        if (action.equals("delete by name")) {
            list.remove(product);
        }
        if (action.equals("find")) {
            for (Object lang : list) {
                if (lang.toString().toLowerCase().contains(product.toLowerCase())) {
                    System.out.println("Найдено: " + (list.indexOf(lang) + 1) + ". " + lang);

                }
            }
            return;
        }
        System.out.println(action.equals("add") ? "Добавлен" : "Удален" + " "
                + product + "\nИтого в списке: "
                + list.size());
    }
}
