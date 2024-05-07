package com.github.caojiantao.idea.girl;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class MainDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JScrollPane scrollPaneImage;

    private ImagePanel paneImage;

    public MainDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        paneImage = new ImagePanel();
        scrollPaneImage.setViewportView(paneImage);
    }

    private void onOK() {
        try {
            int page = ThreadLocalRandom.current().nextInt(100);
            String result = Jsoup.connect("https://api.pexels.com/v1/search?query=girl&size=1&page=" + page)
                    .header("Authorization", "VPk4DcECbltzTvTzJ0yq6isHn8g24Q3UQHWRGPth2BPzMi9eDx5wDHJF")
                    .ignoreContentType(true)
                    .get()
                    .text();
            System.out.println(result);
            ApiResult apiResult = JSON.parseObject(result, ApiResult.class);

            String url = apiResult.getPhotos().get(0).getSrc().getOriginal();
            paneImage.setImage(url);

            // 重绘
            paneImage.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
