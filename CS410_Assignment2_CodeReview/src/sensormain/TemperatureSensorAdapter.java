/*
 * Lauren Kearney
 * CS 410
 * 
 * Adapter class for temperature sensor
 * 
 * */

package sensormain;

import sensor.TemperatureSensor;

public class TemperatureSensorAdapter implements Sensor {
	
	private TemperatureSensor tempSensorAdaptee;
	
	public TemperatureSensorAdapter(TemperatureSensor sensor) {
		this.tempSensorAdaptee = sensor;
	}
	
	@Override
	public double value() {
		return tempSensorAdaptee.senseTemperature();
	}
	
	@Override
	public String status() {
		return tempSensorAdaptee.getTempReport();
	}
	
	@Override
	public String name() {
		return tempSensorAdaptee.getSensorType();
	}
	

}
