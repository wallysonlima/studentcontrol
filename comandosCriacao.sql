#Cria a tabela Faculdade
create table Faculdade(
	codigo_facul int not null primary key, # chave primária
    nome_facul varchar(40)
);

#Cria a tabela Departamento
create table Departamento(
	codigo_depart int not null primary key, # chave primária
    codigo_facul int,
    nome_depart varchar(40),
    foreign Key (codigo_facul) references Faculdade (codigo_facul) # chave Estrangeira
);

#Cria a tabela Docente
create table Docente(
	codigo_docente int not null primary key, # chave primária
    codigo_depart int,
    nome_docente varchar(40),
	email varchar(40),
	senha varchar(40),
    foreign key (codigo_depart) references Departamento (codigo_depart) # chave Estrangeira
);

#Cria a tabela Curso
create table Curso(
	codigo_curso int not null primary key, # chave primária
    codigo_depart int,
    nome_curso varchar(40),
    horario_curso varchar(15),
    foreign key (codigo_depart) references Departamento (codigo_depart) # chave Estrangeira
);

#Cria a tabela Disciplina
create table Disciplina(
	codigo_disciplina int not null primary key, # chave primária
    codigo_curso int,
    nome_disciplina varchar(40),
    descricao varchar(40),
    carga_horaria varchar(40),
    foreign key (codigo_curso) references Curso (codigo_curso) # chave Estrangeira
);

#Cria a tabela Turma
create table Turma(
	codigo_turma int not null primary key,
    codigo_disciplina int,
    codigo_docente int,
    nome_turma varchar(40),
    foreign key (codigo_disciplina) references Disciplina (codigo_disciplina), # chave Estrangeira
	foreign key (codigo_docente) references Docente (codigo_docente) # chave Estrangeira
);

#Cria a tabela Avaliacao
create table Avaliacao(
	codigo_avaliacao int not null primary key, # chave primária
    codigo_turma int,
    descricao_avaliacao varchar(40),
    data_avaliacao date,
    foreign key (codigo_turma) references Turma (codigo_turma) # chave Estrangeira
);


#Cria a tabela Aula
create table Aula(
	codigo_aula int not null primary key, # chave primária
    codigo_turma int,
    horario_aula varchar(20),
    local varchar(40),
    foreign key (codigo_turma) references Turma (codigo_turma) # chave Estrangeira
);

#Cria a tabela Discente
create table Discente(
	ra varchar(10) not null primary key, # chave primária
    nome_discente varchar(40),
    email varchar(40),
    senha varchar(40)
);

#Cria a tabela Discente_Turma, que é um relacionamento muitos para muitos entre Discente e Turma    
create table Discente_Turma (
	ra varchar(10),
    codigo_turma int,
    primary key(ra, codigo_turma), # chave primária
    foreign key (ra) references Discente(ra), # chave Estrangeira
    foreign key (codigo_turma) references Turma (codigo_turma) # chave Estrangeira
);

#Cria a tabela Nota
create table Nota (
    ra varchar(10),
    codigo_avaliacao int,
    nota float,
    primary key(ra, codigo_avaliacao), # chave primária
    foreign key (ra) references Discente (ra), # chave Estrangeira
    foreign key (codigo_avaliacao) references Avaliacao (codigo_avaliacao) # chave Estrangeira
);

#Cria a tabela Presenca  
create table Presenca (
	codigo_aula int,
    ra varchar(10),
    presenca varchar(40),
    primary key (codigo_aula, ra), # chave primária
    foreign key (ra) references Discente (ra), # chave Estrangeira
    foreign key (codigo_aula) references Aula (codigo_aula) # chave Estrangeira
);