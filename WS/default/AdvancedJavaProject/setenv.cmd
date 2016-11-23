@ECHO OFF
REM SET Lab Specific Environment Variables
set LABDIR=C:\AdvancedJavaProject
set SOURCE=%LABDIR%\src
set CLASSES=%LABDIR%\bin
set DOCS=%LABDIR%\docs

REM SET PATH and CLASSPATH Environment Variables
set JAVA_HOME="C:\Program Files\Java\jdk1.8.0_66"
set PATH=%JAVA_HOME%\bin;%PATH%
set CLASSPATH=%LABDIR%\bin