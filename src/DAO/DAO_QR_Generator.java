/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;
import javax.imageio.ImageIO;
import org.json.JSONObject;

/**
 *
 * @author Long
 */
public class DAO_QR_Generator {
    public boolean QRGenerator(String data, String timestamp) throws FileNotFoundException, IOException{
        boolean result = false;
        
        BufferedReader br = new BufferedReader(new FileReader("Components/Settings.json"));
        String json = "";
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            json = sb.toString();
        } finally {
            br.close();
        }
        
        JSONObject obj = new JSONObject(json);
        
        String filepath = "";
        int sizeX = obj.getJSONObject("qr_data_settings").getInt("file_width");
        int sizeY = obj.getJSONObject("qr_data_settings").getInt("file_height");
        String filetype = obj.getJSONObject("qr_data_settings").getString("filetype");
        filepath = obj.getJSONObject("qr_data_settings").getString("saving_folder")+timestamp+"."+filetype;
        
        File newFile = new File(filepath);
        
        try {
            Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			
            // Now with zxing version 3.2.1 you could change border size (white border size to just 1)
            hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
 
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix byteMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, sizeX, sizeY, hintMap);
            int width = byteMatrix.getWidth();
            int height = byteMatrix.getHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            image.createGraphics();
 
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
 
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(image, filetype, newFile);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        
        return result;
    }
}
