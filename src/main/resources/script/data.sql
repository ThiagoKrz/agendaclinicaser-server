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