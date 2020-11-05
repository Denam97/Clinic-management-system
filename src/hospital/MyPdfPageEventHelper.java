/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author Neel
 */
public class MyPdfPageEventHelper extends PdfPageEventHelper {

    String fName;

    public MyPdfPageEventHelper(String imageName) {
        fName = imageName;

    }

    @Override
    public void onEndPage(PdfWriter pdfWriter, Document document) {

        // System.out.println("Creating Waterwark Image in PDF");
        try {

            //Use this method if you want to get image from your Local system
            Image waterMarkImage = Image.getInstance("" + fName + "");

            //Get waterMarkImage from some URL
            //Image waterMarkImage = Image.getInstance(new URL(urlOfWaterMarKImage));
            //Get width and height of whole page
            float pdfPageWidth = document.getPageSize().getWidth();
            float pdfPageHeight = document.getPageSize().getHeight();

            //Set waterMarkImage on whole page
            pdfWriter.getDirectContentUnder().addImage(waterMarkImage,
                    pdfPageWidth, 0, 0, pdfPageHeight, 0, 0);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
