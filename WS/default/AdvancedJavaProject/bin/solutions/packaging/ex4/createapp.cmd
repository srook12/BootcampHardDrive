call ../../../../setenv.cmd
cd ../../../../bin
jar -cvmf ../src/solutions/packaging/ex4/manifest.txt ../src/solutions/packaging/ex4/customerapp.jar solutions/packaging/ex1/*
cd ../src/solutions/packaging/ex4
java -jar customerapp.jar