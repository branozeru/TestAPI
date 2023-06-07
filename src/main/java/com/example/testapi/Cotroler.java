package com.example.testapi;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class Cotroler {

    @GetMapping("/whatsTheTime")

    public String getMasssage() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String response = "The current date and time is: " + formatter.format(date);
        return response;

    }

    @GetMapping("/getData")

    public Data getData(HttpServletRequest request){

        String ip = request.getRemoteAddr();
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentTime = LocalDateTime.now();

        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        int second = currentTime.getSecond();

        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();

        String date = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(day);
        String time = String.valueOf(hour) + ":" + String.valueOf(minute) + ":" + String.valueOf(second);

        return new Data(date, time, ip);

    }

    @GetMapping("/getVImage")

    public void getVImage(HttpServletResponse response) throws IOException {
        File imageFile = new File("C:\\Users\\brano\\.aJavaProjects\\TestAPI\\src\\main\\java\\com\\example\\testapi\\img.png");
        FileInputStream fileInputStream = new FileInputStream(imageFile);
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        outputStream.close();
        fileInputStream.close();
    }









}
