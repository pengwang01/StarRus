#!/bin/bash
case $1 in
C)	javac src/com/cs174/starrus/*/* -d bin -cp ojdbc5.jar
	;;
R)	java -cp bin:ojdbc5.jar com.cs174.starrus.controller.RunApp
	;;
S)  sqlplus64 cs174a_pengwang01/5891775@uml.cs.ucsb.edu
	;;
*)	javac src/com/cs174/starrus/*/* -d bin -cp ojdbc5.jar
	java -cp bin:ojdbc5.jar com.cs174.starrus.controller.RunApp
	;;
esac
