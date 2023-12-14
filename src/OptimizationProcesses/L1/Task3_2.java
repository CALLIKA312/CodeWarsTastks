package OptimizationProcesses.L1;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Task3_2 {
    //6. В приюте для животных есть только собаки и кошки, а работа осуществляется в порядке очереди.
    // Люди должны каждый раз забирать «самое старое» (по времени пребывания в питомнике) животное, но могут выбрать кошку или собаку (животное в любом случае будет «самым старым»).
    // Нельзя выбрать любое понравившееся животное. Создайте структуру данных, которая обеспечивает функционирование этой системы и реализует операции enqueue, dequeueAny, dequeueDog и dequeueCat.
    // Разрешается использование встроенной структуры данных LinkedList


    private static class Queue {
        private class Node {
            Animal data;
            Node next;
            Node prev;

            public Node(Animal data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        private Node front;
        private Node rear;
        private int size;

        public Queue() {
            front = null;
            rear = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void enqueue(Animal data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                newNode.prev = rear;
                rear = newNode;
            }
            size++;
        }

        public Animal dequeue() {
            if (isEmpty()) throw new IllegalStateException("Queue is empty");
            Animal data = front.data;
            front = front.next;
            if (front != null) front.prev = null;
            else rear = null; // Если удаляемый элемент был последним
            size--;
            return data;
        }

        public Animal peek() {
            if (isEmpty()) throw new IllegalStateException("Queue is empty");
            return front.data;
        }


        public Animal dequeueDog() {
            if (isEmpty()) throw new IllegalStateException("Queue is empty");
            Node x = front;
            boolean isFound = false;
            for (int i = 0; i < size; i++) {
                if (x.data.type.equalsIgnoreCase(ANIMAL_TYPE[0])) {
                    isFound = true;
                    break;
                }
                x = x.next;
            }
            if (isFound) return dequeueAnimal(x);
            else throw new NoSuchElementException("Queue not contains any dog");
        }


        public Animal dequeueCat() {
            if (isEmpty()) throw new IllegalStateException("Queue is empty");
            Node x = front;
            boolean isFound = false;
            for (int i = 0; i < size; i++) {
                if (x.data.type.equalsIgnoreCase(ANIMAL_TYPE[1])) {
                    isFound = true;
                    break;
                }
                x = x.next;
            }
            if (isFound) return dequeueAnimal(x);
            else throw new NoSuchElementException("Queue not contains any cat");
        }

        private Animal dequeueAnimal(Node x) {
            size--;
            if (isEmpty()) {
                front = null;
                rear = null;
            } else if (x == front) {
                front = front.next;
                front.prev = null;
            } else if (x == rear) {
                rear = rear.prev;
                rear.next = null;
            } else {
                x.prev.next = x.next;
                x.next.prev = x.prev;
            }
            return x.data;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node x;
            if (size > 0) x = front;
            else return "Empty queue";
            for (int i = 0; i < size; i++) {
                sb.append('\t').append(x.data).append('\n');
                x = x.next;
            }
            return "Queue{" + '\n' +
                    sb.toString() +
                    "size=" + size +
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
        Queue queue = new Queue();
        queue.enqueue(new Animal("Cat", "Kesha"));
        queue.enqueue(new Animal("Cat", "Alfa"));
        queue.enqueue(new Animal("Dog", "Silver"));
        System.out.println(queue.dequeueDog());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeueCat());
//        queue.dequeueDog();
//        queue.dequeueCat();
        System.out.println(queue);


    }
}
