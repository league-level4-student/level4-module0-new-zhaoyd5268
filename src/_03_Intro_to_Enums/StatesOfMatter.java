package _03_Intro_to_Enums;

public enum StatesOfMatter {	

SOLID(0), LIQUID(22.55), GAS(100);


double CelsiusTemp;

private StatesOfMatter(double CelsiusTemp) {
	this.CelsiusTemp = CelsiusTemp;
}

public double ConvertToFahrenheit(double convert) {
	double newconvert;
	newconvert = convert * 9.5;
	newconvert+=32;
	return newconvert;
	
}

}
