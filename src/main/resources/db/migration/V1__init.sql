CREATE SEQUENCE clientes_seq START 1;
CREATE SEQUENCE transacoes_seq START 1;

CREATE TABLE CLIENTES (
  id SERIAL PRIMARY KEY,
  limite INTEGER NOT NULL,
  saldo INTEGER
);

CREATE TABLE TRANSACOES (
  id SERIAL PRIMARY KEY,
  cliente_id INTEGER,
  valor INTEGER NOT NULL,
  tipo VARCHAR(1),
  descricao VARCHAR(10),
  data DATE
);

CREATE INDEX idx_cliente_id ON clientes (id);
CREATE INDEX idx_transacoes_id ON transacoes (id);
CREATE INDEX idx_transacoes_cliente_id ON transacoes (cliente_id);

DO $$
BEGIN
  INSERT INTO CLIENTES (limite, saldo)
  VALUES
    (1000 * 100, 0),
    (800 * 100, 0),
    (10000 * 100, 0),
    (100000 * 100, 0),
    (5000 * 100, 0);
END; $$