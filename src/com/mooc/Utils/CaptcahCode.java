package com.mooc.Utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class CaptcahCode {

    public static String drawImag(HttpServletResponse response){
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<4;i++){
            builder.append(randomChar());
        }
        String code = builder.toString();
        int width = 60;
        int height = 20;
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = bi.createGraphics();
        Font font = new Font("微软雅黑",Font.PLAIN,20);
        Color color = new Color(0,0,255);
        g.setFont(font);
        g.setColor(color);
        g.setBackground(new Color(255,255,255));
        g.clearRect(0,0,width,height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code,context);
        double x = (width - bounds.getWidth()) / 2 ;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int)x,(int)baseY);
        g.dispose();
        try {
            ImageIO.write(bi,"jpg",response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    public static String getCaptcah(int n){
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<n;i++){
            builder.append(randomChar());
        }
        String code = builder.toString();
        return code;
    }
    public static char randomChar(){
        String string="QWERTYUIOPASDFGHJKLZXCVBNM0123456789";
        Random random = new Random();
        return string.charAt(random.nextInt(string.length()));
    }

}
