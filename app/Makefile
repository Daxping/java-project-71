build:
	./gradlew clean
	./gradlew installDist

check:
	gradle checkstyleMain
	gradle checkstyleTest


.DEFAULT_GOAL := build-run

clean:
	./gradlew clean

install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app build/resources/main/file1.yml build/resources/main/file2.yml


run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

update-deps:
	./gradlew useLatestVersions


build-run: build run

.PHONY: build
