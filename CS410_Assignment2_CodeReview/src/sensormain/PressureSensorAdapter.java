/*
 * Lauren Kearney
 * CS 410
 * 
 * Adapter class for pressure sensor
 * 
 * */

package sensormain;

import sensor.PressureSensor;

public class PressureSensorAdapter implements Sensor {

	private PressureSensor pressureSensorAdaptee;
	
	public PressureSensorAdapter(PressureSensor sensor) {
		this.pressureSensorAdaptee = sensor;
	}
	
	@Override
	public double value() {
		return pressureSensorAdaptee.readValue();
	}
	
	@Override
	public String status() {
		return pressureSensorAdaptee.getReport();
	}
	
	@Override
	public String name() {
		return pressureSensorAdaptee.getSensorName();
	}

}
