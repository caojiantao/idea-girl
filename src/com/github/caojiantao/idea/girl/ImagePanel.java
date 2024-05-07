package com.github.caojiantao.idea.girl;

import org.jsoup.Jsoup;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    public void setImage(String imageUrl) {
        try {
            InputStream is = Jsoup.connect(imageUrl)
                    .ignoreContentType(true)
                    .execute()
                    .bodyStream();
            this.image = ImageIO.read(is);
            this.setSize(image.getWidth(), image.getHeight());
            this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

            System.out.println("------------------------ setImage ------------------------");
            System.out.println(imageUrl);
            System.out.println(image.getWidth() + "," + image.getHeight());
            System.out.println(getWidth() + "," + getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (Objects.nonNull(image)) {
            g.drawImage(image, 0, 0, this);
            System.out.println("------------------------ paintComponent ------------------------");
            System.out.println(image.getWidth() + "," + image.getHeight());
            System.out.println(getWidth() + "," + getHeight());
            System.out.println(getParent().getWidth() + "," + getParent().getHeight());
        }
    }
}
