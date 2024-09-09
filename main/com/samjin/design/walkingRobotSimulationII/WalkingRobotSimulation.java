package com.samjin.design.walkingRobotSimulationII;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        // 定义四个方向：北(0,1), 东(1,0), 南(0,-1), 西(-1,0)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 将障碍物放入set中，以便快速查找
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        // 初始位置和方向（朝北）
        int x = 0, y = 0, direction = 0;
        int maxDistSquare = 0;

        // 遍历命令数组
        for (int command : commands) {
            if (command == -1) {  // 右转90度
                direction = (direction + 1) % 4;
            } else if (command == -2) {  // 左转90度
                direction = (direction + 3) % 4;
            } else {  // 前进
                for (int i = 0; i < command; i++) {
                    // 计算新位置
                    int newX = x + dx[direction];
                    int newY = y + dy[direction];

                    // 如果新位置是障碍物，则停止前进
                    if (obstacleSet.contains(newX + "," + newY)) {
                        break;
                    }

                    // 更新位置
                    x = newX;
                    y = newY;

                    // 更新最大距离平方
                    maxDistSquare = Math.max(maxDistSquare, x * x + y * y);
                }
            }
        }

        return maxDistSquare;
    }
}
