package Test;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by guofengrui on 2017/7/26.
 */
public class ImageUtil {
    /**
     *
     * @param originalFile  原文件
     * @param resizedFile  压缩目标文件
     * @param newWidth  压缩后的图片宽度
     * @param quality  压缩质量（0到1之间，越高质量越好）
     * @throws java.io.IOException
     */
    public static void resize(File originalFile, File resizedFile,
                              int newWidth, float quality) throws IOException {

        if (quality > 1) {
            throw new IllegalArgumentException(
                    "Quality has to be between 0 and 1");
        }

        ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
        Image i = ii.getImage();
        Image resizedImage = null;

        int iWidth = i.getWidth(null);
        System.out.println("iWidth:"+iWidth);
        newWidth = iWidth;
        int iHeight = i.getHeight(null);
        System.out.println("iHeight:"+iHeight);
        if (iWidth > iHeight) {
            resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)
                    / iWidth, Image.SCALE_SMOOTH);
        } else {
            resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight,
                    newWidth, Image.SCALE_SMOOTH);
        }

        // 获取图片中的所有像素
        Image temp = new ImageIcon(resizedImage).getImage();

        // 创建缓冲
        BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
                temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

        // 复制图片到缓冲流中
        Graphics g = bufferedImage.createGraphics();

        // 清除背景并开始画图
        g.setColor(Color.white);
        g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
        g.drawImage(temp, 0, 0, null);
        g.dispose();

        // 柔和图片.
        float softenFactor = 0.05f;
        float[] softenArray = { 0, softenFactor, 0, softenFactor,
                1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
        Kernel kernel = new Kernel(3, 3, softenArray);
        ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        bufferedImage = cOp.filter(bufferedImage, null);

        FileOutputStream out = new FileOutputStream(resizedFile);

        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

        JPEGEncodeParam param = encoder
                .getDefaultJPEGEncodeParam(bufferedImage);

        param.setQuality(quality, true);

        encoder.setJPEGEncodeParam(param);
        encoder.encode(bufferedImage);
        bufferedImage.flush();
        out.close();
    }

    //测试
    public static void main(String[] args) throws IOException {
        File originalImage = new File("D:\\ceshi.jpg");
        resize(originalImage, new File("D:\\new0.7f.jpg"),500, 0.1f);
        resize(originalImage, new File("D:\\new1f.jpg"),500, 1f);
    }
}
