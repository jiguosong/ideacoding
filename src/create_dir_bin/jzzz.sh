#!/bin/sh

MYCM=$1
pwdname=${PWD##*/}

bpath='/home/songjiguo/IdeaProjects/interviewCode/src/'

mkdir $MYCM

sed -e s/XXX/$MYCM/g $bpath/java_template.txt > $MYCM/$MYCM.java
sed -e s/XXX/$MYCM/g $bpath/junit_template.txt > $MYCM/$MYCM\_test.java

sed -i s/YYY/$pwdname/g $MYCM/$MYCM.java
sed -i s/YYY/$pwdname/g $MYCM/$MYCM\_test.java
