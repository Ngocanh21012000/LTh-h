package org.tutorial.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
 
import org.tutorial.rmi.Constants;
import org.tutorial.rmi.WeatherData;
import org.tutorial.rmi.WeatherService;
 
public class Client {
 
   // Host or IP of Server
   private static final String HOST = "localhost";
   private static final int PORT = 1099;
   private static Registry registry;
 
   public static void main(String[] args) throws Exception {
 
       // tim kiem dăng kí trên máy chủ,cổng cụ thể
       registry = LocateRegistry.getRegistry(HOST, PORT);
 
       // tra cuu  WeatherService in the Registry.
       WeatherService service = (WeatherService) registry
               .lookup(WeatherService.class.getSimpleName());
 
       Date today = new Date();
 
       // nhận thông tin thời tiết chicago
       WeatherData chicagoWeather = service.getWeather(today,
               Constants.LOCATION_CHICAGO);
 
       System.out.println("Chicago weather today: "
               + chicagoWeather.getWeather());
        
       // nhán thông tin thời tiết hà nội
       WeatherData hanoiWeather = service.getWeather(today,
               Constants.LOCATION_HANOI);
 
       System.out.println("Hanoi weather today: " + hanoiWeather.getWeather());
 
   }
}
