package bai1;

public class DiningPhilosophers {
	public static void main(String[] args) {
        int numPhilosophers = 5;
        Chopstick[] chopsticks = new Chopstick[numPhilosophers];
        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            chopsticks[i] = new Chopstick();
        }

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % numPhilosophers]);
            philosophers[i].start();
        }
    }

}
