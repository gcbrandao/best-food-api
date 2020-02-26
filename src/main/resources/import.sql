insert into cozinha (id, nome) values (1, 'thailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');


insert into restaurante (nome, taxa_frete, cozinha_id) values ('Habbibs', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('McDonalds', 18, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Spolleto', 5, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Bobs', 20, 2);


insert into forma_pagamento (id, descricao) values (1, 'Dinheiro');
insert into forma_pagamento (id, descricao) values (2, 'Cartao de credito');
insert into forma_pagamento (id, descricao) values (3, 'Vale Refeição');

insert into estado (id, nome) values (1, 'SAO PAULO');
insert into estado (id, nome) values (2, 'MINAS GERAIS');
insert into estado (id, nome) values (3, 'BAHIA');

insert into cidade (id, nome, estado_id) values (1, 'SAO PAULO', 1);
insert into cidade (id, nome, estado_id) values (2, 'BELO HORIZONTE', 2);
insert into cidade (id, nome, estado_id) values (3, 'SALVADOR', 3);


insert into permissao (id, nome, descricao) values (1, 'ADMIN', 'ADMINISTRADORES');
insert into permissao (id, nome, descricao) values (2, 'GUEST', 'VIZUALIZAÇÃO');
insert into permissao (id, nome, descricao) values (3, 'OPERADOR', 'OPERADORES DE LOJA');



