package com.samjin.stackandqueue;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

class SnakeGame {
    // 记录自己的位置,包括全部的身体
    // 因此也可以从这个set来判断是不是撞到了自己
    HashSet<Integer> set;
    // 当前蛇的情况,全部坐标
    Deque<Integer> deque;
    // 当前得分
    int score;
    // 第几个食物
    int foodIndex;
    int width;
    int height;
    // 食物坐标
    int[][] food;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        deque = new LinkedList<>();
        score = 0;
        foodIndex = 0;
        set.add(0);
        deque.offerLast(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        // 当前头部的坐标
        int rowHead = deque.peekFirst() / width;
        int colHead = deque.peekFirst() % width;

        switch(direction){
            case "U": rowHead--;
                break;
            case "D":rowHead++;
                break;
            case "L":colHead--;
                break;
            default : colHead++;
        }

        // 新头部的位置
        int head = rowHead * width + colHead;
        // 删除尾部,因为马上要走下一步了,尾部会往前移动
        // 尾部不可能有食物
        set.remove(deque.peekLast());
        // 1. 撞到墙或者自己
        if(rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)){
            return -1;
        }

        // 2. 吃东西或者走路
        // 加入head
        set.add(head);
        deque.offerFirst(head);

        // 是不是吃到了食物
        // foodIndex记录了第几个food
        // foodIndex < food.length表示还有食物可以吃
        // 并且此时新的头部还正好在食物的位置
        if(foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]){
            foodIndex++;
            score++;
            // 身体有增长了!!
            // 在set中再把尾部加上
            // 同时不对deque进行poll()
            set.add(deque.peekLast());
            return score;
        }

        // 只走路,没吃东西
        deque.pollLast();
        return score;
    }
}
