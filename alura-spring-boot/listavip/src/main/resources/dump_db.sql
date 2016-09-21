CREATE SEQUENCE convidado_id_seq;
CREATE TABLE convidado (
  id bigint NOT NULL DEFAULT nextval('convidado_id_seq'),
  nome varchar(500) DEFAULT NULL,
  email varchar(500) DEFAULT NULL,
  telefone varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);
ALTER SEQUENCE convidado_id_seq OWNED BY convidado.id;

INSERT INTO convidado VALUES 
(1,'Lazaro Prates Junior','lazaro@alura.com.br','99998888'),
(2,'Maria do Carmo','maria@gmail.com','33442233'),
(4,'Antonio da Silva','toni@alura.com.br','99997777'),
(5,'Luis','luis@alura.com','55554444'),
(6,'Pedro','pedro@alura.com','44555544'),
(7,'João da Silva','springbootalura@gmail.com','98899887');