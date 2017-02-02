--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: agentTrade; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE agentTrade WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Italian_Italy.1252' LC_CTYPE = 'Italian_Italy.1252';


ALTER DATABASE agentTrade OWNER TO postgres;

\connect agentTrade

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: agente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE agente (
    idagente integer NOT NULL,
    nome character varying(255),
    cognome character varying(255),
    password character varying(255),
    username character varying(255),
    citta character varying(255),
    indirizzo character varying(255),
    livello integer,
    cell character varying(255),
    email character varying(255),
    cap character varying(255)
);


ALTER TABLE agente OWNER TO postgres;

--
-- Name: agente_idagente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE agente_idagente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE agente_idagente_seq OWNER TO postgres;

--
-- Name: agente_idagente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE agente_idagente_seq OWNED BY agente.idagente;


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cliente (
    idcliente integer NOT NULL,
    m_agenteidagente integer NOT NULL,
    nome character varying(255),
    cognome character varying(255),
    codice_fiscale character varying(255),
    indirizzo character varying(255),
    email character varying(255),
    partita_iva character varying(255),
    telefono character varying(255),
    fax character varying(255),
    citta character varying(255),
    cap character varying(255),
    cell character varying(255)
);


ALTER TABLE cliente OWNER TO postgres;

--
-- Name: cliente_idcliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cliente_idcliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliente_idcliente_seq OWNER TO postgres;

--
-- Name: cliente_idcliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cliente_idcliente_seq OWNED BY cliente.idcliente;


--
-- Name: preventivo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE preventivo (
    idpreventivo integer NOT NULL,
    m_clienteidcliente integer,
    m_agenteidagente integer,
    data date
);


ALTER TABLE preventivo OWNER TO postgres;

--
-- Name: preventivo_idpreventivo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE preventivo_idpreventivo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE preventivo_idpreventivo_seq OWNER TO postgres;

--
-- Name: preventivo_idpreventivo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE preventivo_idpreventivo_seq OWNED BY preventivo.idpreventivo;


--
-- Name: preventivo_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE preventivo_item (
    idpreventivo_item integer NOT NULL,
    m_prodottoidprodotto integer NOT NULL,
    m_preventivoidpreventivo integer NOT NULL,
    quantita integer NOT NULL,
    sconto real,
    m_preventivoindex integer
);


ALTER TABLE preventivo_item OWNER TO postgres;

--
-- Name: preventivo_item_idpreventivo_item_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE preventivo_item_idpreventivo_item_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE preventivo_item_idpreventivo_item_seq OWNER TO postgres;

--
-- Name: preventivo_item_idpreventivo_item_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE preventivo_item_idpreventivo_item_seq OWNED BY preventivo_item.idpreventivo_item;


--
-- Name: prodotto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE prodotto (
    idprodotto integer NOT NULL,
    nome character varying(255),
    prezzo real NOT NULL,
    categoria character varying(255),
    iddescrizioneprodotto character varying(255),
    stagionatura integer,
    tipo character varying(255),
    provenienza character varying(255),
    taglio character varying(255),
    "Column" character varying(255),
    colore character varying(255),
    indicazione_geografica character varying(255),
    cantina character varying(255),
    artigianale boolean,
    free_gluten boolean,
    discriminator character varying(255) NOT NULL
);


ALTER TABLE prodotto OWNER TO postgres;

--
-- Name: prodotto_idprodotto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE prodotto_idprodotto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE prodotto_idprodotto_seq OWNER TO postgres;

--
-- Name: prodotto_idprodotto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE prodotto_idprodotto_seq OWNED BY prodotto.idprodotto;


--
-- Name: idagente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY agente ALTER COLUMN idagente SET DEFAULT nextval('agente_idagente_seq'::regclass);


--
-- Name: idcliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente ALTER COLUMN idcliente SET DEFAULT nextval('cliente_idcliente_seq'::regclass);


--
-- Name: idpreventivo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preventivo ALTER COLUMN idpreventivo SET DEFAULT nextval('preventivo_idpreventivo_seq'::regclass);


--
-- Name: idpreventivo_item; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preventivo_item ALTER COLUMN idpreventivo_item SET DEFAULT nextval('preventivo_item_idpreventivo_item_seq'::regclass);


--
-- Name: idprodotto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prodotto ALTER COLUMN idprodotto SET DEFAULT nextval('prodotto_idprodotto_seq'::regclass);


--
-- Data for Name: agente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY agente (idagente, nome, cognome, password, username, citta, indirizzo, livello, cell, email, cap) FROM stdin;
1	Antonio	Fraticelli	asd	antofrat	San Giovanni Rotondo	via Foggia 271/c	3	3207239078	fraticelli.antonio@gmail.com	71013
3	Martina	Castrioti	asd	martcast	\N	\N	3	\N	\N	\N
4	Mirco	D'Andrea	asd	mircdan	\N	\N	3	\N	\N	\N
\.


--
-- Name: agente_idagente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('agente_idagente_seq', 4, true);


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente (idcliente, m_agenteidagente, nome, cognome, codice_fiscale, indirizzo, email, partita_iva, telefono, fax, citta, cap, cell) FROM stdin;
2	1	higuain	Gonzalo	hgigzl89f15g421d	via vittorio emanuele	pipita@juve.it	01234567896	0824578596	0526478596	torino	12457	3204578984
1	1	Paulo	Dybala 	pludfr56t76t543e	via padova 10	paulino@juve.it	01234567894	0882457898	0882457898	Torino	12345	3201452879
4	1	Rossi	Mario	mrirss56t76h867b	via mazzini 3	mross@google.com	01234567898	0825457898	1234658797	cagliari	12345	3215498657
5	3	Marco	Bianchi	mdtsyu76y65n987h	via roma 13	bianchimarco@gmail.com	01234567899	3216549876	1245658798	pescara	12345	1235465987
6	4	Barbosa	Matteo	asdwer45t67u574h	piazza di spagna	barb@gmail.com	01472589632	2548785421	4567985465	roma	74152	3214578987
\.


--
-- Name: cliente_idcliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cliente_idcliente_seq', 6, true);


--
-- Data for Name: preventivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY preventivo (idpreventivo, m_clienteidcliente, m_agenteidagente, data) FROM stdin;
54	2	1	2017-02-02
53	1	1	2017-02-01
55	1	1	2017-02-02
56	4	1	2017-02-02
57	4	1	2017-02-02
58	2	1	2017-02-02
59	5	3	2017-02-02
62	6	4	2017-02-02
63	4	1	2017-02-02
\.


--
-- Name: preventivo_idpreventivo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preventivo_idpreventivo_seq', 64, true);


--
-- Data for Name: preventivo_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY preventivo_item (idpreventivo_item, m_prodottoidprodotto, m_preventivoidpreventivo, quantita, sconto, m_preventivoindex) FROM stdin;
99	2	56	2	1	0
100	3	56	3	1	1
101	4	56	4	1	2
102	5	56	5	1	3
103	6	56	6	1	4
104	7	56	7	1	5
105	3	57	100	1	0
106	1	58	5	1	0
107	3	58	3	1	1
108	6	58	10	1	2
109	8	58	8	1	3
79	1	54	15	1	0
80	3	54	15	1	1
82	7	54	15	1	2
84	9	54	15	1	3
74	2	53	20	1	0
75	4	53	20	1	1
76	7	53	20	1	2
78	3	53	20	1	3
110	2	59	7	1	0
111	4	59	7	1	1
112	7	59	17	1	2
113	9	59	5	1	3
115	2	62	1	0	0
116	5	62	1	0	1
117	8	62	1	0	2
90	2	55	2	1	0
91	4	55	4	1	1
92	6	55	6	1	2
93	8	55	8	1	3
94	1	55	1	1	4
95	3	55	3	1	5
96	5	55	5	1	6
97	7	55	7	1	7
98	9	55	9	1	8
118	3	62	1	0	3
119	1	63	8	0	0
\.


--
-- Name: preventivo_item_idpreventivo_item_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preventivo_item_idpreventivo_item_seq', 119, true);


--
-- Data for Name: prodotto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prodotto (idprodotto, nome, prezzo, categoria, iddescrizioneprodotto, stagionatura, tipo, provenienza, taglio, "Column", colore, indicazione_geografica, cantina, artigianale, free_gluten, discriminator) FROM stdin;
1	vino 1	2	VINI	vino bla bla	\N	\N	\N	\N	\N	rosso	Abruzzo	tollo	\N	\N	M_Vini
2	vino 2	2	VINI	vino fuluppone bla bla	\N	\N	\N	\N	\N	bianco	salerno	furmella	\N	\N	M_Vini
3	vino 3	3	VINI	vino rossiccio bla	\N	\N	\N	\N	\N	rosso	puglia	prim	\N	\N	M_Vini
4	carne di manzo	4	CARNI	bla bla bla	\N	\N	\N	cat2	tipo1	\N	\N	\N	\N	\N	M_Carni
5	carne di pollo	3	CARNI	bla bla bla	\N	\N	\N	cat1	tipo3	\N	\N	\N	\N	\N	M_Carni
6	mozzarella fresca	2	LATTICINI	bla bla bla	12	mozzarelle	\N	\N	\N	\N	\N	\N	\N	\N	M_Latticini
7	ricotta del giorno	1	LATTICINI	bla bla bla	0	ricotta	\N	\N	\N	\N	\N	\N	\N	\N	M_Latticini
8	Crostata	6	DOLCI	bla bla bla	\N	\N	\N	\N	\N	\N	\N	\N	t	f	M_Dolci
9	Torta di mele	7	DOLCI	bla bla bla	\N	\N	\N	\N	\N	\N	\N	\N	t	t	M_Dolci
\.


--
-- Name: prodotto_idprodotto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prodotto_idprodotto_seq', 9, true);


--
-- Name: agente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY agente
    ADD CONSTRAINT agente_pkey PRIMARY KEY (idagente);


--
-- Name: cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (idcliente);


--
-- Name: preventivo_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preventivo_item
    ADD CONSTRAINT preventivo_item_pkey PRIMARY KEY (idpreventivo_item);


--
-- Name: preventivo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preventivo
    ADD CONSTRAINT preventivo_pkey PRIMARY KEY (idpreventivo);


--
-- Name: prodotto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prodotto
    ADD CONSTRAINT prodotto_pkey PRIMARY KEY (idprodotto);


--
-- Name: fkcliente88690; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT fkcliente88690 FOREIGN KEY (m_agenteidagente) REFERENCES agente(idagente);


--
-- Name: fkpreventivo14065; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preventivo
    ADD CONSTRAINT fkpreventivo14065 FOREIGN KEY (m_clienteidcliente) REFERENCES cliente(idcliente);


--
-- Name: fkpreventivo166346; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preventivo_item
    ADD CONSTRAINT fkpreventivo166346 FOREIGN KEY (m_preventivoidpreventivo) REFERENCES preventivo(idpreventivo);


--
-- Name: fkpreventivo386074; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preventivo
    ADD CONSTRAINT fkpreventivo386074 FOREIGN KEY (m_agenteidagente) REFERENCES agente(idagente);


--
-- Name: fkpreventivo947002; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preventivo_item
    ADD CONSTRAINT fkpreventivo947002 FOREIGN KEY (m_prodottoidprodotto) REFERENCES prodotto(idprodotto);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

