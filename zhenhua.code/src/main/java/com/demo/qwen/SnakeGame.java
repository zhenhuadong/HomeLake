package com.demo.qwen;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

// 贪吃蛇游戏实现带界面的贪吃蛇游戏
public class SnakeGame {
    private int[][] board;
    private Deque<int[]> snake; // 蛇身，头部在队列尾部
    private int direction;
    private Random random;
    private int score;
    private boolean gameOver;

    private static final int EMPTY = 0;
    private static final int SNAKE = 1;
    private static final int FOOD = 2;

    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;

    public SnakeGame(int width, int height) {
        board = new int[height][width];
        snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0});
        board[0][0] = SNAKE;
        direction = RIGHT;
        random = new Random();
        score = 0;
        gameOver = false;
        generateFood();
    }

    public void move(int dx, int dy) {
        int[] head = snake.peekLast();
        int newX = head[0] + dx;
        int newY = head[1] + dy;

        // 检查越界
        if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
            gameOver = true;
            return;
        }

        // 检查是否撞到自己
        if (board[newX][newY] == SNAKE) {
            gameOver = true;
            return;
        }

        // 添加新头部
        snake.addLast(new int[]{newX, newY});

        // 检查是否吃到食物
        if (board[newX][newY] == FOOD) {
            score++;
            generateFood();
        } else {
            // 移除尾部
            int[] tail = snake.pollFirst();
            board[tail[0]][tail[1]] = EMPTY;
        }

        board[newX][newY] = SNAKE;
    }

    public void turn(int direction) {
        // 防止反向移动
        if ((this.direction == RIGHT && direction == LEFT) ||
                (this.direction == LEFT && direction == RIGHT) ||
                (this.direction == UP && direction == DOWN) ||
                (this.direction == DOWN && direction == UP)) {
            return;
        }
        this.direction = direction;
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void generateFood() {
        int x, y;
        do {
            x = random.nextInt(board.length);
            y = random.nextInt(board[0].length);
        } while (board[x][y] != EMPTY);
        board[x][y] = FOOD;
    }

    public void update() {
        int dx = 0, dy = 0;
        switch (direction) {
            case UP:    dx = -1; break;
            case DOWN:  dx = 1;  break;
            case LEFT:  dy = -1; break;
            case RIGHT: dy = 1;  break;
        }
        move(dx, dy);
    }

    public void render() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == SNAKE) {
                    System.out.print("*");
                } else if (board[i][j] == FOOD) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // 换行
        }
    }

    public static void main(String[] args) throws IOException {
        SnakeGame snakeGame = new SnakeGame(5, 5);
        while (!snakeGame.isGameOver()) {
            snakeGame.update();
            snakeGame.render();
            try {
                Thread.sleep(500); // 控制游戏速度
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Game Over!");
        System.out.println("Your score is: " + snakeGame.getScore());
        System.out.println("Press any key to exit...");
        System.in.read();
        System.exit(0);
    }
}