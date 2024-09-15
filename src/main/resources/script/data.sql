-- PERFIL
INSERT INTO perfil_acesso (id, nome) VALUES (1, 'ADMINISTRADOR');
INSERT INTO perfil_acesso (id, nome) VALUES (2, 'RECEPCAO');

-- PERMISSAO
INSERT INTO permissao (id, nome) VALUES (1, 'CADASTRAR_USUARIO');
INSERT INTO permissao (id, nome) VALUES (2, 'EDITAR_USUARIO');
INSERT INTO permissao (id, nome) VALUES (3, 'EXCLUIR_USUARIO');
INSERT INTO permissao (id, nome) VALUES (4, 'VISUALIZAR_USUARIO');

-- PERFIL - USUARIO
INSERT  INTO perfil_acesso_permissoes (perfil_acesso_id, permissao_id) VALUES (1, 1);
INSERT  INTO perfil_acesso_permissoes (perfil_acesso_id, permissao_id) VALUES (1, 2);
INSERT  INTO perfil_acesso_permissoes (perfil_acesso_id, permissao_id) VALUES (1, 3);
INSERT  INTO perfil_acesso_permissoes (perfil_acesso_id, permissao_id) VALUES (1, 4);
INSERT  INTO perfil_acesso_permissoes  (perfil_acesso_id, permissao_id) VALUES (2, 4);

-- ADMIN
INSERT INTO usuario (username, password, perfil_acesso_id, primeiro_acesso) VALUES  ('admin', '$2a$10$dv8Hg/2GJ7hiBLfA5iEE2uThd66wlZbO1YQM6eaj0GAKQDxMwGwqq', 1, false);
INSERT INTO persona (dtype,  nome, sobrenome, data_nascimento, sexo, email, ddd, numero_telefone,  inativo)
    VALUES  ('Colaborador', 'admin', 'admin', '2021-01-01', 'MASCULINO', 'admin@gmail.com', '69', '99999999', false);