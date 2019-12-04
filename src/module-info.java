module programacionAvanzada {
	
	requires java.desktop;
	requires java.sql;
	requires junit;
	
	exports tests to junit;
	exports library to InterfaceTest;
}