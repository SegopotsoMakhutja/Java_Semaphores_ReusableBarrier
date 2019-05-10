# makefile for java
# author: Segopotso Makhutja
# date: april 2019

BINDIR 	= bin
PACKDIR = molecule
JAVAC 	= javac
JFLAGS 	= -g -d $(BINDIR)
VM 		= java
MAIN	= RunSimulation

# define general build rule for java sources
.SUFFIXES:  .java  .class

SOURCES=$(shell find $(PACKDIR) -name '*.java' -type f)
CLASSES=$(SOURCES:$(PACKDIR)/%.java=$(BINDIR)/%.class)

$(BINDIR)/%.class:$(PACKDIR)/%.java
	$(JAVAC)  $(JFLAGS) $<

all:$(CLASSES)

def:
	$(VM) -cp $(BINDIR) $(PACKDIR).$(MAIN) 12 3

run:
	$(VM) -cp $(BINDIR) $(PACKDIR).$(MAIN) $(ARGS)

clean:
	@rm -f  $(BINDIR)/$(PACKDIR)/*.class