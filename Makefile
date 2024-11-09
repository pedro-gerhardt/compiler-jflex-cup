all: compile test

compile: 
	mkdir -p gen/classes

	jflex -d gen/classes lex.flex

	java -jar util/java-cup-11b-20160615.jar -interface -expect 100 < sin.cup

	mv parser.java sym.java gen/classes/

	javac -cp util/java-cup-11b-20160615.jar:gen -d gen *.java gen/classes/*.java

clean:
	rm -rf gen

test: 
	java -cp util/java-cup-11b-20160615.jar:gen Main tests/code.in > tests/ast.out
	
	cat tests/ast.out
