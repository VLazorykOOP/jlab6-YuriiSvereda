import java.util.Random;

public class RandomStringMovement {
    public static void test() throws InterruptedException {
        String[] strings = {"Hello", "World", "Java", "Programming", "Example"};
        Random random = new Random();

        int screenWidth = 100; // Ширина екрану (можна змінити)
        int screenHeight = 30; // Висота екрану (можна змінити)

        while (true) {
            // Очистка екрану
            for (int i = 0; i < screenHeight; i++) {
                System.out.println();
            }

            // Випадковий вибір рядка і напрямку руху
            int randomStringIndex = random.nextInt(strings.length);
            String selectedString = strings[randomStringIndex];
            int direction = random.nextBoolean() ? 1 : -1; // 1 - рух вправо, -1 - рух вліво

            // Відступ від краю екрану
            int startingPosition = direction == 1 ? 0 : screenWidth - selectedString.length();

            // Рух рядка по екрану
            for (int i = 0; i <= screenWidth - selectedString.length(); i++) {
                // Відступи для рядка
                for (int j = 0; j < i + startingPosition; j++) {
                    System.out.print(" ");
                }
                System.out.print(selectedString);
                Thread.sleep(100); // Затримка для візуалізації
                System.out.print("\r"); // Переміщення курсора назад
            }
        }
    }
}
