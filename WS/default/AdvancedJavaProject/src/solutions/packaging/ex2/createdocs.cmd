call ../../../../setenv.cmd
rmdir /S /Q docs
mkdir docs
javadoc -d docs ../ex1/*
exit