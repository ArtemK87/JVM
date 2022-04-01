public class JvmComprehension { // Происходит компиляция исходного кода в JvmComprehension.class

    public static void main(String[] args) {
        //  ClassLoader передает класс в JVM и загружается в метаспейс. Создается фрейм main в стэке.
        int i = 1;                      // 1 - В фрейм main помещается переменная int.
        Object o = new Object();        // 2 - Объект с названием "О" сохраняется в хипе. В стэке фрейм main сохраняется ссылка на этот объект.
        Integer ii = 2;                 // 3 - Объект с названием "ii" сохраняется в хипе. В стэке фрейм main сохраняется ссылка на этот объект.
        printAll(o, i, ii);             // 4 - Для метода printAll() в стэке создается новый фрейм.
        System.out.println("finished"); // 7 - В стэке создается фрейм со ссылкой на строку со значением "finished".
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 - Объект с названием "uselessVar" сохраняется в хипе. В стэке фрейм printAll сохраняется ссылка на этот объект.
        System.out.println(o.toString() + i + ii);  // 6 - В стэке создается фрейм со ссылкой на объект "ii" и значение "i". В стэке создается фрейм метода toString().
    }
} // После завершения метода фрейм уничтожается.
// Запускается сборщик мусора и удаляет неиспользуемые в хипе объекты по завершении программы.