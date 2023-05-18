package Controller;

import java.util.HashMap;

import javax.swing.JPanel;

import java.util.ArrayList;

public class DataUnitConverter {
	private Double b;
	private Double kb;
	private Double mb;
	private Double gb;
	private Double tb;
	private Double B;
	private Double KB;
	private Double MB;
	private Double GB;
	private Double TB;
	public ArrayList<Double> units = new ArrayList<Double>();
	public StringBuilder sb = new StringBuilder();
	
	public DataUnitConverter(final String theNumber, final String theUnit) {
		switch(theUnit) {
			case "bits (b)": this.b = Double.parseDouble(theNumber);
							 this.kb = this.b / 1000;
							 this.mb = this.kb / 1000;
							 this.gb = this.kb / 1000;
							 this.tb = this.gb / 1000;
							 this.B = this.b / 8;
							 this.KB = this.B / 1000;
							 this.MB = this.KB / 1000;
							 this.GB = this.MB / 1000;
							 this.TB = this.GB / 1000;
							 break;
			case "kilobits (kb)": this.kb = Double.parseDouble(theNumber);
							 	  this.b = this.kb * 1000;
							 	  this.mb = this.kb / 1000;
							 	  this.gb = this.mb / 1000;
							 	  this.tb = this.gb / 1000;
							 	  this.B = this.b / 8;
							 	  this.KB = this.B / 1000;
							 	  this.MB = this.KB / 1000;
								  this.GB = this.MB / 1000;
								  this.TB = this.GB / 1000;
								  break;
			case "megabits (mb)": this.mb = Double.parseDouble(theNumber);
								  this.b = this.mb * 1000000;
								  this.kb = this.b / 1000;
								  this.gb = this.mb / 1000;
								  this.tb = this.gb / 1000;
								  this.B = this.b / 8;
								  this.KB = this.B / 1000;
								  this.MB = this.KB / 1000;
								  this.GB = this.MB / 1000;
								  this.TB = this.GB / 1000;
								  break;
			case "gigabits (gb)": this.gb = Double.parseDouble(theNumber);
								  this.tb = this.gb / 1000;
								  this.mb = this.gb * 1000;
								  this.kb = this.mb * 1000;
								  this.b = this.kb * 1000;
								  this.B = this.b / 8;
								  this.KB = this.B / 1000;
								  this.MB = this.KB / 1000;
								  this.GB = this.MB / 1000;
								  this.TB = this.GB / 1000;
								  break;
			case "terabits (tb)": this.tb = Double.parseDouble(theNumber);
								  this.gb = this.tb * 1000;
								  this.mb = this.gb * 1000;
								  this.kb = this.mb * 1000;
								  this.b = this.kb * 1000;
								  this.B = this.b / 8;
								  this.KB = this.B / 1000;
								  this.MB = this.KB / 1000;
								  this.GB = this.MB / 1000;
								  this.TB = this.GB / 1000;
								  break;
			case "Bytes (B)": this.B = Double.parseDouble(theNumber);
							  this.KB = this.B / 1000;
							  this.MB = this.KB / 1000;
							  this.GB = this.MB / 1000;
							  this.TB = this.GB / 1000;
							  this.b = this.B * 8;
							  this.kb = this.b / 1000;
							  this.mb = this.kb / 1000;
							  this.gb = this.mb / 1000;
							  this.tb = this.gb / 1000;
							  break;
			case "KiloBytes (KB)": this.KB = Double.parseDouble(theNumber);
							 	   this.B = this.KB * 1000;
							 	   this.MB = this.KB / 1000;
							 	   this.GB = this.MB / 1000;
							 	   this.TB = this.GB / 1000;
							 	   this.b = this.B * 8;
							 	   this.kb = this.b / 1000;
							 	   this.mb = this.kb / 1000;
							 	   this.gb = this.mb / 1000;
							 	   this.tb = this.gb / 1000;
							 	   break;
			case "MegaBytes (MB)": this.MB = Double.parseDouble(theNumber);
							 	   this.KB = this.MB * 1000;
							 	   this.B = this.KB * 1000;
							 	   this.GB = this.MB / 1000;
							 	   this.TB = this.GB / 1000;
							 	   this.b = this.B / 8;
							 	   this.kb = this.b / 1000;
							 	   this.mb = this.kb / 1000;
							 	   this.gb = this.mb / 1000;
							 	   this.tb = this.gb / 1000;
							 	   break;
			case "GigaBytes (GB)": this.GB = Double.parseDouble(theNumber);
							 	   this.TB = this.GB / 1000;
							 	   this.MB = this.GB * 1000;
							 	   this.KB = this.MB * 1000;
							 	   this.B = this.KB * 1000;
							 	   this.b = this.B * 8;
							 	   this.kb = this.b / 1000;
							 	   this.mb = this.kb / 1000;
							 	   this.gb = this.mb / 1000;
							 	   this.tb = this.gb / 1000;
							 	   break;
			case "TeraBytes (TB)": this.TB = Double.parseDouble(theNumber);
							 	   this.GB = this.TB * 1000;
							 	   this.MB = this.GB * 1000;
							 	   this.KB = this.MB * 1000;
							 	   this.B = this.KB * 1000;
							 	   this.b = this.B * 8;
							 	   this.kb = this.b / 1000;
							 	   this.mb = this.kb / 1000;
							 	   this.gb = this.mb / 1000;
							 	   this.tb = this.gb / 1000;
							 	   break;
		}
		convertedUnits();
	}
	
	public void convertedUnits() {
		units.add(this.b);
		units.add(this.kb);
		units.add(this.mb);
		units.add(this.gb);
		units.add(this.tb);
		units.add(this.B);
		units.add(this.KB);
		units.add(this.MB);
		units.add(this.GB);
		units.add(this.TB);
	}

}