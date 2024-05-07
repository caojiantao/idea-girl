package com.github.caojiantao.idea.girl;

import javax.swing.*;
import java.awt.*;

public class ScrollPaneWithPanelExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 创建 JFrame
            JFrame frame = new JFrame("ScrollPane with JPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 创建一个 JPanel
            JPanel panel = new JPanel();
            panel.setBackground(Color.RED);

            // 设置面板的偏好大小，确保它大于滚动窗格的视口
            panel.setPreferredSize(new Dimension(1200, 1000));

            // 创建 JScrollPane 并将其滚动条策略设置为按需显示
            JScrollPane scrollPane = new JScrollPane();

            scrollPane.setViewportView(panel);

            // 将 JScrollPane 添加到 JFrame 中
            frame.add(scrollPane);

            // 设置窗口的初始位置
            frame.setLocationRelativeTo(null);

            frame.setSize(new Dimension(800, 600)); // 宽度为300，高度为200
            // 显示窗口
            frame.setVisible(true);
        });
    }
}