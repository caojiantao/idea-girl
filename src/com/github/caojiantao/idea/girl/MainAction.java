package com.github.caojiantao.idea.girl;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // 创建对话框实例
        MainDialog dialog = new MainDialog();
        // 设置对话框的固定大小
        dialog.setSize(new Dimension(800, 600)); // 宽度为300，高度为200
        // 使对话框大小不可改变（可选）
        dialog.setResizable(false);
        // 将对话框居中显示
        dialog.setLocationRelativeTo(null); // null 表示相对于屏幕
        // 设置对话框可见
        dialog.setVisible(true);
    }
}
