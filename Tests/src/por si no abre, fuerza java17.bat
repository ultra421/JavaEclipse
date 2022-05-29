@Echo OFF

SET BINDIR=%~dp0

CD /C "%BINDIR%"

"%ProgramFiles%\Java\jdk-17.0.1\bin\java.exe" -Xmx2G -Xms2G -jar library.jar

PAUSE