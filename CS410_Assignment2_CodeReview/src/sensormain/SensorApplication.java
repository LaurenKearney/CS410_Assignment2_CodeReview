/*
 * Lauren Kearney
 * CS 410
 * 
 * three panel GUI for Sensor application
 * 
 * */

package sensormain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

import sensor.PressureSensor;
import sensor.RadiationSensor;
import sensor.TemperatureSensor;

public class SensorApplication extends JFrame {
	
	public PressureSensorAdapter pressure = new PressureSensorAdapter(new PressureSensor());
	public RadiationSensorAdapter radiation = new RadiationSensorAdapter(new RadiationSensor());
	public TemperatureSensorAdapter temperature = new TemperatureSensorAdapter(new TemperatureSensor());
	
	public SensorApplication() {
		
		int pressureLength = (int) (pressure.value());
		pressureLength *= 10;
		int radiationLength = (int) (radiation.value());
		radiationLength *= 10;
		int temperatureLength = (int) (temperature.value());
		temperatureLength /= 4;
		
		
		Dimension dimPressure = new Dimension();
		dimPressure.height = 50;
		dimPressure.width = pressureLength;
		
		Dimension dimRadiation = new Dimension();
		dimRadiation.height = 50;
		dimRadiation.width = radiationLength;
		
		Dimension dimTemperature = new Dimension();
		dimTemperature.height = 50;
		dimTemperature.width = temperatureLength;
		
		Dimension dimMax = new Dimension();
		dimMax.height = 50;
		dimMax.width = 100;
		
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
		
	//Pressure Panel
		JPanel pressurePnl = new JPanel(new FlowLayout(FlowLayout.LEADING));
		pressurePnl.setBorder(new TitledBorder("Pressure Sensor"));
		
		if (pressure.status().toLowerCase().equals("ok")) {
			GreenTracker green = new GreenTracker();
			green.setPreferredSize(dimPressure);
			pressurePnl.add(green);
		}
		else if (pressure.status().toLowerCase().equals("critical")) {
			YellowTracker yellow = new YellowTracker();
			yellow.setPreferredSize(dimPressure);
			pressurePnl.add(yellow);
		}
		else if (pressure.status().toLowerCase().equals("danger")) {
			RedTracker red = new RedTracker();
			red.setPreferredSize(dimPressure);
			pressurePnl.add(red);
		} else {	//Fail safe
			BlueTracker blue = new BlueTracker();
			blue.setPreferredSize(dimMax);
			pressurePnl.add(blue);
		}
		
		JLabel pressureLabel = new JLabel((pressure.status()+ "---->" + pressure.value()), JLabel.RIGHT);
		pressurePnl.setLayout(new FlowLayout());
		pressurePnl.add(pressureLabel);
		add(pressurePnl);
		
	//RadiationPanel
		JPanel  radiationPnl = new JPanel(new FlowLayout(FlowLayout.LEADING));
		radiationPnl.setBorder(new TitledBorder("Radiation Sensor"));
		
		if (radiation.status().toLowerCase().equals("ok")) {
			GreenTracker green = new GreenTracker();
			green.setPreferredSize(dimRadiation);
			radiationPnl.add(green);
		}
		else if (radiation.status().toLowerCase().equals("critical")) {
			YellowTracker yellow = new YellowTracker();
			yellow.setPreferredSize(dimPressure);
			radiationPnl.add(yellow);
		}
		else if (radiation.status().toLowerCase().equals("danger")) {
			RedTracker red = new RedTracker();
			red.setPreferredSize(dimRadiation);
			radiationPnl.add(red);
			
		} else { //Failsafe
			BlueTracker blue = new BlueTracker();
			blue.setPreferredSize(dimRadiation);
			radiationPnl.add(blue);
		}
		
		JLabel radiationLabel = new JLabel((radiation.status()+ "---->" + radiation.value()), JLabel.RIGHT);
		radiationPnl.setLayout(new FlowLayout());
		radiationPnl.add(radiationLabel);
		add(radiationPnl);
		
	//temperature Panel
		JPanel  temperaturePnl = new JPanel(new FlowLayout(FlowLayout.LEADING));
		temperaturePnl.setBorder(new TitledBorder("Temperature Sensor"));
		if (temperature.status().toLowerCase().equals("ok")) {
			GreenTracker green = new GreenTracker();
			green.setPreferredSize(dimTemperature);
			temperaturePnl.add(green);
		}
		else if (temperature.status().toLowerCase().equals("critical")) {
			YellowTracker yellow = new YellowTracker();
			yellow.setPreferredSize(dimTemperature);
			temperaturePnl.add(yellow);
		}
		else if (temperature.status().toLowerCase().equals("danger")) {
			RedTracker red = new RedTracker();
			red.setPreferredSize(dimTemperature);
			temperaturePnl.add(red);
			
		} else {	//Failsafe
			BlueTracker blue = new BlueTracker();
			blue.setPreferredSize(dimTemperature);
			temperaturePnl.add(blue);
		}
		
		JLabel temperatureLabel = new JLabel((temperature.status()+ "---->" + temperature.value()), JLabel.RIGHT);
		temperaturePnl.setLayout(new FlowLayout());
		temperaturePnl.add(temperatureLabel);
		add(temperaturePnl);
		
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
		
		
	}
	
	
	
//Rectangle color classes

class GreenTracker extends JPanel {
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GREEN);
		g.fillRect(0,0,500,500);
	}
}
class RedTracker extends JPanel {
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.fillRect(0,0,500,500);
	}
}
class YellowTracker extends JPanel {
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0,0,500,500);
	}
}

//Fail Safe
class BlueTracker extends JPanel {
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 500);
	}
}

}


