/*
 * Lauren Kearney
 * CS 410
 * 
 * Adapter class for radiation sensor
 * 
 * */

package sensormain;

import sensor.RadiationSensor;

public class RadiationSensorAdapter implements Sensor {
	
	private RadiationSensor radiationSensorAdaptee;
	
	public RadiationSensorAdapter(RadiationSensor sensor) {
		this.radiationSensorAdaptee = sensor;
	}
	
	@Override
	public double value() {
		return radiationSensorAdaptee.getRadiationValue();
	}
	
	@Override
	public String status() {
		return radiationSensorAdaptee.getStatusInfo();
	}
	
	@Override
	public String name() {
		return radiationSensorAdaptee.getName();
	}
}
