package OptimizationProcesses.L1;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Task3_1 {

    //6. В приюте для животных есть только собаки и кошки, а работа осуществляется в порядке очереди.
    // Люди должны каждый раз забирать «самое старое» (по времени пребывания в питомнике) животное, но могут выбрать кошку или собаку (животное в любом случае будет «самым старым»).
    // Нельзя выбрать любое понравившееся животное. Создайте структуру данных, которая обеспечивает функционирование этой системы и реализует операции enqueue, dequeueAny, dequeueDog и dequeueCat.
    // Разрешается использование встроенной структуры данных LinkedList


    private static class Queue {
        private Animal[] arr;
        private int front;
        private int rear;
        private int capacity;
        private int count;

        Queue(int size) {
            arr = new Animal[size];
            capacity = size;
            front = 0;
            rear = -1;
            count = 0;
        }

        public void enqueue(Animal item) {
            if (isFull()) {
                System.out.println("Overflow");
                System.exit(-1);
            }
            System.out.println("Inserting " + item);

            rear = (rear + 1) % capacity;
            arr[rear] = item;
            count++;
        }

        public Animal dequeueAny() {
            if (isEmpty()) {
                System.out.println("Underflow");
                System.exit(-1);
            }
            Animal x = arr[front];
            System.out.println("Removing " + x.getName());
            front = (front + 1) % capacity;
            count--;
            return x;
        }

        public Animal dequeueDog() {
            if (isEmpty()) {
                System.out.println("Underflow");
                System.exit(-1);
            }
            Animal x = null;
            if (front + size() > capacity) {
                for (int i = front; i < size(); i++) {
                    if (arr[i].getType().equalsIgnoreCase("dog")) {
                        x = arr[i];
                        break;
                    }
                }
                if (x == null) {
                    for (int i = 0; i < rear + 1; i++) {
                        if (arr[i].getType().equalsIgnoreCase("dog")) {
                            x = arr[i];
                            break;
                        }
                    }
                }
            } else {
                for (int i = front; i < rear + 1; i++) {
                    if (arr[i].getType().equalsIgnoreCase("dog")) {
                        x = arr[i];
                        break;
                    }
                }
            }
            if (x == null) {
                System.out.println("Cannot find dog");
                return null;
            }
            System.out.println("Removing " + x.getName());
            front = (front + 1) % capacity;
            count--;
            return x;
        }

        public Animal dequeueCat() {
            if (isEmpty()) {
                System.out.println("Underflow");
                System.exit(-1);
            }
            Animal x = null;
            if (front + size() > capacity) {
                for (int i = front; i < size(); i++) {
                    if (arr[i].getType().equalsIgnoreCase("cat")) {
                        x = arr[i];
                        break;
                    }
                }
                if (x == null) {
                    for (int i = 0; i < rear + 1; i++) {
                        if (arr[i].getType().equalsIgnoreCase("cat")) {
                            x = arr[i];
                            break;
                        }
                    }
                }
            } else {
                for (int i = front; i < rear + 1; i++) {
                    if (arr[i].getType().equalsIgnoreCase("cat")) {
                        x = arr[i];
                        break;
                    }
                }
            }
            if (x == null) {
                System.out.println("Cannot find cat");
                return null;
            }
            System.out.println("Removing " + x.getName());
            front = (front + 1) % capacity;
            count--;
            return x;
        }

        public int size() {
            return count;
        }

        public boolean isEmpty() {
            return (size() == 0);
        }

        public boolean isFull() {
            return (size() == capacity);
        }

        @Override
        public String toString() {
            return "Queue{" +
                    "arr=" + Arrays.toString(arr) +
                    ", count=" + count +
                    '}';
        }
    }

    private static final String[] ANIMAL_TYPE = new String[]{
            "dog",
            "cat"
    };


    private static class Animal {
        private final String type;
        private final String name;
        private final LocalDateTime stayTime;

        public Animal(String type, String name) throws Exception {
            this.type = checkType(type);
            this.name = name;
            this.stayTime = LocalDateTime.now();
        }


        @Override
        public String toString() {
            return "Animal{" +
                    "type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", stayTime=" + stayTime +
                    '}';
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        private String checkType(String type) throws Exception {
            if (Arrays.stream(ANIMAL_TYPE).anyMatch(s -> s.equals(type.toLowerCase()))) return type;
            else throw new Exception("Wrong animal type");
        }
    }


    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(5);
//        queue.enqueue(new Animal("Dog", "Silver"));
//        queue.enqueue(new Animal("Cat", "Kesha"));
//        queue.enqueue(new Animal("Cat", "Alfa"));
//        queue.dequeueDog();
//        queue.dequeueAny();
//        queue.dequeueCat();
//        queue.enqueue(new Animal("Dog", "Sharik"));
//        queue.enqueue(new Animal("Cat", "Murka"));
//        queue.dequeueDog();
//        queue.dequeueCat();
//        queue.enqueue(new Animal("Dog", "test"));
//        queue.enqueue(new Animal("Dog", "test"));
//        queue.enqueue(new Animal("Dog", "test"));
//        System.out.println(queue);



    }
}
