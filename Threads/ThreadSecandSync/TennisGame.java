package ThreadSecandSync;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TennisGame {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean ballInPlay = true;
    private static String currentPlayer = "Player 1";  // Player 1 starts

    public static void main(String[] args) {
        Thread player1 = new Thread(new Player("Player 1"));
        Thread player2 = new Thread(new Player("Player 2"));

        player1.start();
        player2.start();

        try {
            player1.join();
            player2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Game Over!");
    }

    static class Player implements Runnable {
        private final String name;
        private final Random random = new Random();

        public Player(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (ballInPlay) {
                lock.lock();
                try {
                    // Wait for your turn to hit the ball
                    while (!currentPlayer.equals(name) && ballInPlay) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // Simulate hitting the ball
                    if (ballInPlay) {
                        if (random.nextInt(10) < 2) {  // 20% chance of missing the ball
                            System.out.println(name + " missed the ball! The other player wins!");
                            ballInPlay = false;
                        } else {
                            System.out.println(name + " hits the ball!");
                            // Simulate some delay between hits
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // Switch turns
                            currentPlayer = currentPlayer.equals("Player 1") ? "Player 2" : "Player 1";
                        }
                        // Signal the other player
                        condition.signalAll();
                    }
                } finally {
                    lock.unlock();
                }

              
            }
        }
    }
}
