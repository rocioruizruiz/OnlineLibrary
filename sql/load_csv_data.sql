LOAD DATA
INFILE '/Users/rocioruizruiz/Documentos/Segundo/AmpliacionProgramacion/WorkspaceJava/PracticasProgramacion/Employees.csv'
INTO TABLE workbenchtesting.tasks 
FIELDS TERMINATED BY ';'
ENCLOSED BY '"' 
LINES TERMINATED BY '\n';