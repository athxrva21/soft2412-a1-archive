JAVAC = javac
JAVA = java
MAIN_SRC = src/main/java
TEST_SRC = src/test/java
OUT = build/make-classes
TEST_OUT = build/make-test-classes
JUNIT = lib/junit-platform-console-standalone-1.14.4.jar

.PHONY: compile test clean

compile: $(OUT)/App.class $(OUT)/UserInterface.class \
         $(OUT)/CurrencyConverter.class $(OUT)/DataValidator.class

$(OUT):
	mkdir -p $(OUT)

$(TEST_OUT):
	mkdir -p $(TEST_OUT)

$(OUT)/CurrencyConverter.class: $(MAIN_SRC)/CurrencyConverter.java | $(OUT)
	$(JAVAC) -d $(OUT) -cp $(OUT) $<

$(OUT)/DataValidator.class: $(MAIN_SRC)/DataValidator.java | $(OUT)
	$(JAVAC) -d $(OUT) -cp $(OUT) $<

$(OUT)/UserInterface.class: $(MAIN_SRC)/UserInterface.java \
		$(OUT)/CurrencyConverter.class $(OUT)/DataValidator.class | $(OUT)
	$(JAVAC) -d $(OUT) -cp $(OUT) $(MAIN_SRC)/UserInterface.java

$(OUT)/App.class: $(MAIN_SRC)/App.java $(OUT)/UserInterface.class | $(OUT)
	$(JAVAC) -d $(OUT) -cp $(OUT) $(MAIN_SRC)/App.java

$(TEST_OUT)/.compiled: $(TEST_SRC)/AppTest.java \
		$(TEST_SRC)/CurrencyConverterTest.java \
		$(TEST_SRC)/UserInterfaceTest.java \
		$(TEST_SRC)/DataValidatorTest.java \
		compile | $(TEST_OUT)
	$(JAVAC) -d $(TEST_OUT) -cp $(OUT):$(JUNIT) $(TEST_SRC)/*.java
	touch $@

test: $(TEST_OUT)/.compiled
	$(JAVA) -jar $(JUNIT) execute -cp $(OUT):$(TEST_OUT) --scan-classpath=$(TEST_OUT)

clean:
	rm -rf $(OUT) $(TEST_OUT)
