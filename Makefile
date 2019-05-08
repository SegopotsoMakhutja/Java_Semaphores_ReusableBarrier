# Java MAKEFILE
# Segopotso Makhutja

JC		= javac
JF		= -g
VM		= java
MAIN	= RunSimulation
PACKAGE	= molecule

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JF) $*.java

CLASSES=	Carbon.java\
				Hydrogen.java\
				Methane.java\
				BarrierReusable.java\
				RunSimulation.java

default: class_files

class_files:$(CLASSES:.java=.class)

def:
	$(VM) $(MAIN)

run:
	$(VM) $(PACKAGE)/$(MAIN) $(ARGS)

clean:
	rm -f *.class

	