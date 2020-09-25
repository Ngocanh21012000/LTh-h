package org.tutorial.rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface WeatherService extends Remote {
	// Method lấy về đối tượng thông tin thời tiết.
	 // Tham số truyền vào ngày & địa điểm.
	 public WeatherData getWeather(Date date, String location)
	         throws RemoteException;

}
