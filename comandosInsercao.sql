# Inserção de faculdades na tabela Faculdade, principais faculdades da UNESP
insert into Faculdade(codigo_facul, nome_facul) values ( 1, 'FCT' ); # Presidente Prudente
insert into Faculdade(codigo_facul, nome_facul) values ( 2, 'FCL' ); # Assis
insert into Faculdade(codigo_facul, nome_facul) values ( 3, 'FC' ); # Bauru
insert into Faculdade(codigo_facul, nome_facul) values ( 4, 'RC' ); # Rio Claro
insert into Faculdade(codigo_facul, nome_facul) values ( 5, 'IBILCE' ); # São José do Rio Preto

# Inserção de departamentos na tabela Departamento, faculdade FCT
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (1, 1, 'DMC');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (2, 1, 'GEOGRAFIA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (3, 1, 'EDUCACAO');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (4, 1, 'QUIMICA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (5, 1, 'FISIOTERAPIA');

# Inserção de departamentos na tabela Departamento, faculdade FCL
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (6, 2, 'LETRAS');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (7, 2, 'PSICOLOGIA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (8, 2, 'EDUCACAO');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (9, 2, 'LITERATURA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (10, 2, 'HISTORIA');

# Inserção de departamentos na tabela Departamento, faculdade FC
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (11, 3, 'COMPUTACAO');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (12, 3, 'FISICA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (13, 3, 'EDUCACAO');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (14, 3, 'MATEMATICA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (15, 3, 'QUIMICA');

# Inserção de departamentos na tabela Departamento, faculdade RC
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (16, 4, 'COMPUTACAO');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (17, 4, 'ECOLOGIA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (18, 4, 'EDUCACAO');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (19, 4, 'GEOGRAFIA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (20, 4, 'GEOLOGIA');

# Inserção de departamentos na tabela Departamento, faculdade IBILCE
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (21, 5, 'COMPUTACAO');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (22, 5, 'BIOLOGIA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (23, 5, 'FISICA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (24, 5, 'ZOOLOGIA');
insert into Departamento(codigo_depart, codigo_facul, nome_depart) values (25, 5, 'MATEMATICA');

# Inserção de docentes na tabela Docente, departamento DMC
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (1, 1, 'Piteri', 'piteri@fct.unesp.br', '1234');
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (2, 1, 'Ronaldo', 'ronaldo@fct.unesp.br', '1234');
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (3, 1, 'Almir', 'almir@fct.unesp.br', '1234' );
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (4, 1, 'Danilo', 'danilo@fct.unesp.br', '1234');
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (5, 1, 'Rogério' , 'rogerio@fct.unesp.br', '1234');
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (6, 1, 'Maurício', 'mauricio@fct.unesp.br', '1234');

# Inserção de docentes na tabela Docente, departamento Geografia
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (7, 2, 'Thomás', 'thomas@fct.unesp.br', '1234');
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (8, 2, 'João Osvaldo', 'joao_osvaldo@fct.unesp.br', '1234');
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (9, 2, 'Carminha', 'carminha@fct.unesp.br', '1234');
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (10, 2, 'João Lima', 'joao_lima@fct.unesp.br', '1234');
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (11, 2, 'Magauldi', 'magauldi@fct.unesp.br', '1234');
insert into Docente(codigo_docente, codigo_depart, nome_docente, email, senha) values (12, 2, 'Bernardo', 'bernardo@fct.unesp.br', '1234');

# Inserção de cursos na tabela Curso
insert into Curso(codigo_curso, codigo_depart, nome_curso, horario_curso) values (1, 1, 'Ciência da Computação', 'Vespertino');
insert into Curso(codigo_curso, codigo_depart, nome_curso, horario_curso) values (2, 1, 'Matemática', 'Nortuno');
insert into Curso(codigo_curso, codigo_depart, nome_curso, horario_curso) values (3, 2, 'Geografia', 'Nortuno');
insert into Curso(codigo_curso, codigo_depart, nome_curso, horario_curso) values (4, 3, 'Pedagogia', 'Nortuno');
insert into Curso(codigo_curso, codigo_depart, nome_curso, horario_curso) values (5, 4, 'Química', 'Diurno');

# Inserção de disciplinas na tabela Disciplina 
insert into Disciplina(codigo_disciplina, codigo_curso, nome_disciplina, descricao, carga_horaria) values ( 1, 1, 'ATP', 'Algoritmos e técnicas de Programação', '90 horas');
insert into Disciplina(codigo_disciplina, codigo_curso, nome_disciplina, descricao, carga_horaria) values ( 2, 1, 'Engenharia de Software I', 'Projetar Sistemas', '60 horas');
insert into Disciplina(codigo_disciplina, codigo_curso, nome_disciplina, descricao, carga_horaria) values ( 3, 1, 'Sistemas Operacionais I', 'Estudar Sistemas Operacionais', '60 horas');
insert into Disciplina(codigo_disciplina, codigo_curso, nome_disciplina, descricao, carga_horaria) values ( 4, 1, 'Banco de Dados I', 'Estudar teoria e prática de Banco de Dados', '60 horas');
insert into Disciplina(codigo_disciplina, codigo_curso, nome_disciplina, descricao, carga_horaria) values ( 5, 1, 'Estrutura de Dados I', 'Estudar estrutura de dados', '60 horas');

# Inserção de turmas na tabela Turma
insert into Turma(codigo_turma, codigo_disciplina, codigo_docente, nome_turma) values (1, 1, 1,'Turma ATP');
insert into Turma(codigo_turma, codigo_disciplina, codigo_docente, nome_turma) values (2, 2, 5,'Turma ES I');
insert into Turma(codigo_turma, codigo_disciplina, codigo_docente, nome_turma) values (3, 3, 6,'Turma SO I');
insert into Turma(codigo_turma, codigo_disciplina, codigo_docente, nome_turma) values (4, 4, 2,'Turma BD I'); 
insert into Turma(codigo_turma, codigo_disciplina, codigo_docente, nome_turma) values (5, 5, 2,'Turma ED I');

# Inserção de Avaliações na tabela Avaliação
insert into Avaliacao(codigo_avaliacao, codigo_turma, descricao_avaliacao, data_avaliacao) values ( 1, 1, 'P1', 20/08/2015);
insert into Avaliacao(codigo_avaliacao, codigo_turma, descricao_avaliacao, data_avaliacao) values ( 2, 2, 'P1', 21/08/2015);
insert into Avaliacao(codigo_avaliacao, codigo_turma, descricao_avaliacao, data_avaliacao) values ( 3, 3, 'P1', 22/08/2015);
insert into Avaliacao(codigo_avaliacao, codigo_turma, descricao_avaliacao, data_avaliacao) values ( 4, 4, 'P1', 24/08/2015);
insert into Avaliacao(codigo_avaliacao, codigo_turma, descricao_avaliacao, data_avaliacao) values ( 5, 5, 'P1', 25/08/2015);

# Inserção de Aulas na tabela Aula
insert into Aula(codigo_aula, codigo_turma, horario_aula, local) values (1, 1, 'Vespertino', 'Anf I');
insert into Aula(codigo_aula, codigo_turma, horario_aula, local) values (2, 2, 'Vespertino', 'Lab 6b');
insert into Aula(codigo_aula, codigo_turma, horario_aula, local) values (3, 3, 'Noturno', 'Lab 5b');
insert into Aula(codigo_aula, codigo_turma, horario_aula, local) values (4, 4, 'Noturno', 'Lab 6');
insert into Aula(codigo_aula, codigo_turma, horario_aula, local) values (5, 5, 'Noturno', 'Lab 5');

# Inserção de Alunos na tabela Discente
insert into Discente(ra, nome_discente, email, senha) values (1, 'Wallyson', 'wallyson.nunes@hotmail.com', '1234');
insert into Discente(ra, nome_discente, email, senha) values (2, 'Victor', 'victorVicentine@hotmail.com', '1234');
insert into Discente(ra, nome_discente, email, senha) values (3, 'Thiago', 'almeida.thiago@live.com', '1234');
insert into Discente(ra, nome_discente, email, senha) values (4, 'Luiz Haines', 'luisHaines@hotmail.com', '1234');
insert into Discente(ra, nome_discente, email, senha) values (5, 'Carol', 'carol@hotmail.com', '1234');

# Inserção de Notas na tabela Nota
insert into Nota(ra, codigo_avaliacao, nota) values (1, 1, 7.5);
insert into Nota(ra, codigo_avaliacao, nota) values (1, 2, 5);
insert into Nota(ra, codigo_avaliacao, nota) values (1, 3, 9);
insert into Nota(ra, codigo_avaliacao, nota) values (1, 4, 4);
insert into Nota(ra, codigo_avaliacao, nota) values (1, 5, 2);

# Inserção de Notas na tabela Nota
insert into Nota(ra, codigo_avaliacao, nota) values (2, 1, 7.5);
insert into Nota(ra, codigo_avaliacao, nota) values (2, 2, 5);
insert into Nota(ra, codigo_avaliacao, nota) values (2, 3, 9);
insert into Nota(ra, codigo_avaliacao, nota) values (2, 4, 4);
insert into Nota(ra, codigo_avaliacao, nota) values (2, 5, 2);

# Inserção de Notas na tabela Nota
insert into Nota(ra, codigo_avaliacao, nota) values (3, 1, 7.5);
insert into Nota(ra, codigo_avaliacao, nota) values (3, 2, 5);
insert into Nota(ra, codigo_avaliacao, nota) values (3, 3, 9);
insert into Nota(ra, codigo_avaliacao, nota) values (3, 4, 4);
insert into Nota(ra, codigo_avaliacao, nota) values (3, 5, 2);

# Inserção de Notas na tabela Nota
insert into Nota(ra, codigo_avaliacao, nota) values (4, 1, 7.5);
insert into Nota(ra, codigo_avaliacao, nota) values (4, 2, 5);
insert into Nota(ra, codigo_avaliacao, nota) values (4, 3, 9);
insert into Nota(ra, codigo_avaliacao, nota) values (4, 4, 4);
insert into Nota(ra, codigo_avaliacao, nota) values (4, 5, 2);

# Inserção de Presença na tabela Presenca
insert into Presenca(codigo_aula, ra, presenca) values (1, 1, 'Presente');
insert into Presenca(codigo_aula, ra, presenca) values (1, 2, 'Presente');
insert into Presenca(codigo_aula, ra, presenca) values (1, 3, 'Faltou');
insert into Presenca(codigo_aula, ra, presenca) values (1, 4, 'Faltou');
insert into Presenca(codigo_aula, ra, presenca) values (1, 5, 'Presente');