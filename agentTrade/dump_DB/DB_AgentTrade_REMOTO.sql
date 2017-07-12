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
-- Name: agentTrade_REMOTO; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "agentTrade_REMOTO" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Italian_Italy.1252' LC_CTYPE = 'Italian_Italy.1252';


ALTER DATABASE "agentTrade_REMOTO" OWNER TO postgres;

\connect "agentTrade_REMOTO"

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


--
-- Name: pg_stat_statements; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS pg_stat_statements WITH SCHEMA public;


--
-- Name: EXTENSION pg_stat_statements; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pg_stat_statements IS 'track execution statistics of all SQL statements executed';


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
    livello integer NOT NULL,
    cell character varying(255),
    email character varying(255),
    cap character varying(255),
    attivo integer
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
-- Name: azienda_idazienda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE azienda_idazienda_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE azienda_idazienda_seq OWNER TO postgres;

--
-- Name: azienda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE azienda (
    idazienda integer DEFAULT nextval('azienda_idazienda_seq'::regclass) NOT NULL,
    ragionesociale character varying(255),
    codicefiscale character varying(255),
    partitaiva character varying(255),
    citta character varying(255),
    cap character varying(255),
    indirizzo character varying(255),
    email character varying(255),
    telefono character varying(255),
    fax character varying(255),
    url character varying(255) DEFAULT NULL::character varying,
    tipoprodotto character varying(255) NOT NULL,
    versione integer
);


ALTER TABLE azienda OWNER TO postgres;

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
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cliente (
    idcliente integer DEFAULT nextval('cliente_idcliente_seq'::regclass) NOT NULL,
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
    cell character varying(255),
    attivo integer DEFAULT 1 NOT NULL,
    sconto integer DEFAULT 0,
    versione integer,
    idclienteagente integer,
    versione_download integer
);


ALTER TABLE cliente OWNER TO postgres;

--
-- Name: mandante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE mandante (
    idmandante integer NOT NULL,
    nome character varying(255),
    cognome character varying(255),
    username character varying(255),
    password character varying(255)
);


ALTER TABLE mandante OWNER TO postgres;

--
-- Name: mandante_idmandante_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE mandante_idmandante_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mandante_idmandante_seq OWNER TO postgres;

--
-- Name: mandante_idmandante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE mandante_idmandante_seq OWNED BY mandante.idmandante;


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
-- Name: prodotto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE prodotto (
    idprodotto integer DEFAULT nextval('prodotto_idprodotto_seq'::regclass) NOT NULL,
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
    discriminator character varying(255) NOT NULL,
    sconto real,
    versione integer,
    idprodottoazienda integer,
    idazienda integer NOT NULL
);


ALTER TABLE prodotto OWNER TO postgres;

--
-- Name: sconto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sconto (
    id integer NOT NULL,
    "Percent" real,
    quantita integer,
    scontofisso real,
    discriminator character varying(255) NOT NULL,
    versione integer,
    "Column" real
);


ALTER TABLE sconto OWNER TO postgres;

--
-- Name: sconto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sconto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sconto_id_seq OWNER TO postgres;

--
-- Name: sconto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sconto_id_seq OWNED BY sconto.id;


--
-- Name: idagente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY agente ALTER COLUMN idagente SET DEFAULT nextval('agente_idagente_seq'::regclass);


--
-- Name: idmandante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mandante ALTER COLUMN idmandante SET DEFAULT nextval('mandante_idmandante_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sconto ALTER COLUMN id SET DEFAULT nextval('sconto_id_seq'::regclass);


--
-- Data for Name: agente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY agente (idagente, nome, cognome, password, username, citta, indirizzo, livello, cell, email, cap, attivo) FROM stdin;
1	Antonio	Fraticelli	asd	antofrat	sgr	via foggia 217	3	3204578987	fratic@asd.it	71013	1
6	Dino	Sauro	asd	dinsau	Torino	via roma	4	3475689755	asd@asd.it	23456	1
19	D'Andrea	Mirco	asd	mircdan	asd	asd 12	5	1231232131	asd@asd.it	12312	1
\.


--
-- Name: agente_idagente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('agente_idagente_seq', 28, true);


--
-- Data for Name: azienda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY azienda (idazienda, ragionesociale, codicefiscale, partitaiva, citta, cap, indirizzo, email, telefono, fax, url, tipoprodotto, versione) FROM stdin;
25	AziendaDolci	12321312312	12312312312	milano	60004	via milano 32	asd@asd.it	1231231231	1231231233	\N	dolci	1
21	Rivera	12345678901	12345678901	Firenze	60002	via mah	azienda2@asd.it	3283456540	3283456540	http://pianetaverdesgr.altervista.org/rivera.php	vini	1
22	Beverage	12345678901	12312312312	Roma	60001	via bo	azienda1@asd.it	3201314598	3201314598	http://fratic.altervista.org/beverage.php	vini	1
23	Lem	34534123123	34534512312	Roma	34534	via Roma	asd@asd.it	3455342789	0851234523	http://pianetaverdesgr.altervista.org/lem.php	carni	1
26	AziendaLatticini	65456554677	65456554677	napoli	12345	via napoli	asad@asd.it	3476582459	3476582459	\N	latticini	1
\.


--
-- Name: azienda_idazienda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('azienda_idazienda_seq', 4, true);


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente (idcliente, m_agenteidagente, nome, cognome, codice_fiscale, indirizzo, email, partita_iva, telefono, fax, citta, cap, cell, attivo, sconto, versione, idclienteagente, versione_download) FROM stdin;
\.


--
-- Name: cliente_idcliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cliente_idcliente_seq', 19, true);


--
-- Data for Name: mandante; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY mandante (idmandante, nome, cognome, username, password) FROM stdin;
1	Antonio	Fraticelli	king	asd
\.


--
-- Name: mandante_idmandante_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('mandante_idmandante_seq', 1, true);


--
-- Data for Name: prodotto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prodotto (idprodotto, nome, prezzo, categoria, iddescrizioneprodotto, stagionatura, tipo, provenienza, taglio, "Column", colore, indicazione_geografica, cantina, artigianale, free_gluten, discriminator, sconto, versione, idprodottoazienda, idazienda) FROM stdin;
341	Montepulciano	9	vini	bla bla bla	\N	\N	\N	\N	\N	rosso	abruzzo	vignone	\N	\N	M_Vini	77	4	1	22
342	Falanghina	12	vini	descrizion di prova	\N	\N	\N	\N	\N	bianco	friuli	visol	\N	\N	M_Vini	77	2	2	22
343	Primitivo Manduria "Sessant' anni" Doc	9	Vini	bal bla bla 	\N	\N	\N	\N	\N	bianco	Puglia, salento	San Marzano	\N	\N	M_Vini	78	3	3	22
344	Malvasia Nera 	7	Vini	Malvasia Nera Igt Talo' Selezione Sud	\N	\N	\N	\N	\N	Rosso	Puglia, salento	San Marzano	\N	\N	M_Vini	24	1	4	22
345	Primitivo Manduria "dieci anni" Doc	8.69999981	Vini	Dieci anni di maturazione in botti di rovere	\N	\N	\N	\N	\N	bianco	Puglia, salento	San Marzano	\N	\N	M_Vini	77	2	5	22
346	Malvasia Rose	12.3999996	Vini	Malvasia Nera Igt Talo' Selezione Sud	\N	\N	\N	\N	\N	Rosso	Puglia, salento	San Marzano	\N	\N	M_Vini	24	1	6	22
347	Costera Cannonau Doc	8	Vini	bal bla bla balbalbal	\N	\N	\N	\N	\N	Rosso	Sardegna, Serdianca	ARGIOLAS	\N	\N	M_Vini	77	2	7	22
348	Perle Rose Doc Magnum 	18.3999996	Vini	Perle Rose Doc Magnum (Pinot N./ Chard.) astucciate	\N	\N	\N	\N	\N	Rosso	Trento	Ferrari	\N	\N	M_Vini	24	1	8	22
349	Valpolicella 	8.69999981	Vini	Dop Superiore Monte Lodoletta	\N	\N	\N	\N	\N	Rosso	Lazio	DAL FORNO ROMANO	\N	\N	M_Vini	79	1	9	22
350	Amarone Sant'Urbano DOCG	19	Vini	Amarone Sant'Urbano DOCG bla bla bla 	\N	\N	\N	\N	\N	rosso	Veneto	Speri	\N	\N	M_Vini	80	1	10	22
351	Pinot Grigio Doc	13.5	Vini	bau bua bua	\N	\N	\N	\N	\N	Bianco	Capriva del Friuli	VILLA RUSSIZ	\N	\N	M_Vini	24	1	11	22
352	Raboso Frizzante 	12.5	Vini	Linea Giovane Igt	\N	\N	\N	\N	\N	Rosso	Campodipietra TV	ORNELLA MOLON	\N	\N	M_Vini	81	1	12	22
353	Passimento 	13.5	Vini	Passimento Rosso Sp. Edition Romeo & Giulietta	\N	\N	\N	\N	\N	Rosso	Verona	PASQUA	\N	\N	M_Vini	82	1	13	22
354	GRAPPA INVECCHIATA IL FALCONE	45	Vini	Colore dorato brillante. bouquet intenso\ned elegante. gusto complesso con finale\nmorbido e lungo.	\N	\N	\N	\N	\N	Trasparente	Castel del Monte Riserva D.O.C.G.	Rivera	\N	\N	M_Vini	83	5	221	21
355	FURFANTE BIANCO	23	Vini	Colore bianco paglierino; perlage intenso,bouquet fresco e fruttato; palato fresco, morbido e delicato. Frizzante	\N	\N	\N	\N	\N	Bianco	Puglia I.G.T.\r\n	Rivera	\N	\N	M_Vini	84	3	220	21
356	PRELUDIO N1 Chardonnay	17.3999996	Vini	Giallo paglierino intenso;\nbouquet complesso e fruttato\ncon note di pera e fiori\ndi pesco; palato fresco e\nfruttato, di buona lunghezza e\ncomplessita.	\N	\N	\N	\N	\N	Bianco	Chardonnay\r\nCastel del Monte D.O.C.	Rivera	\N	\N	M_Vini	85	2	219	21
357	PIANI DI TUFARA	21.3999996	Vini	Colore giallo carico e\nbrillante; bouquet di fiori\ndi acacia, albicocca, ananas,\nbuccia d arancia candita;\npalato ricco e complesso,\ndolce, ma con finale asciutto	\N	\N	\N	\N	\N	Bianco	Moscato di Trani D.O.C.	Rivera	\N	\N	M_Vini	86	2	218	21
358	TRIUSCO	20	Vini	Violaceo impenetrabile; bouquet intenso\ndi confettura di ribes e more; molto\npieno, caldo e morbido in bocca con\nnote di prugna, confettura di ribes e\ncioccolato.	\N	\N	\N	\N	\N	Rosso	Primitivo\r\nPuglia I.G.T.	Rivera	\N	\N	M_Vini	77	1	217	21
359	Puer Apuliae	18.3999996	Vini	Rosso violaceo impenetrabile; bouquet intenso di piccoli frutti neri con note di viola e ance stellato.	\N	\N	\N	\N	\N	Rosso	Castel del Monte - nero di Troia	Rivera	\N	\N	M_Vini	87	2	213	21
360	Chianina	22	Carni	Ottima qualita della carne (marezzate e tenere).Tagli piu pregiati soprattutto la regione dorso-lombare dalla quale si ottengono le rinomate bistecche alla fiorentina\n	\N	\N	Toscana	Noce	Vitello	\N	\N	\N	\N	\N	M_Carni	82	3	311	23
361	Romagnola	22	Carni	Produzione di latte tendenzialmente scarsa per il vitello. \nOttima qualita della carne (giusta marezzatura e tenera)	\N	\N	Emilia Romagna	Lombata	Manzo	\N	\N	\N	\N	\N	M_Carni	88	3	1057	23
362	Bufalo	21.5	Carne	La carne di bufalo e' tenera e succosa e contiene meno grassi rispetto a quella di manzo 	\N	\N	Campania	Girello di spalla	Bufalo	\N	\N	\N	\N	\N	M_Carni	24	1	1058	23
363	Blackgold	27.5	Carni	 bla bla bla	\N	\N	Irlanda	Girello di spalla	Manzo - Blackgold	\N	\N	\N	\N	\N	M_Carni	24	1	1059	23
364	Warta	26.5	Carne	  bla bla bla	\N	\N	Polonia	Cappello del prete	Manzo - Warta	\N	\N	\N	\N	\N	M_Carni	24	1	1060	23
365	Angus	31.5	Carne	  bla bla bla	\N	\N	Argentina	Filetto	Vitellone	\N	\N	\N	\N	\N	M_Carni	77	1	1061	23
366	Fassona	24.5	Carne	  bla bla bla	\N	\N	Italia	Biancostato di reale	Manzo	\N	\N	\N	\N	\N	M_Carni	24	1	1062	23
367	Blackgold	18	Carni	  bla bla bla	\N	\N	Irlanda	Punta di petto	Manzo - Blackgold	\N	\N	\N	\N	\N	M_Carni	24	1	1063	23
368	Warta	22.5	Carne	 bla bla bla	\N	\N	Polonia	Scamone	Manzo - Warta	\N	\N	\N	\N	\N	M_Carni	24	1	1064	23
369	Angus	27.5	Carne	  bla bla bla	\N	\N	Argentina	Copertina di spalla	Vitellone	\N	\N	\N	\N	\N	M_Carni	24	1	1065	23
370	Fassona	10	Carne	  bla bla bla	\N	\N	Italia	Fesa	Manzo	\N	\N	\N	\N	\N	M_Carni	89	3	1066	23
376	Parmigiano	2.29999995	Latticini		12		\N	\N	\N	\N	\N	\N	\N	\N	M_Latticini	24	1	0	26
371	Tiramisù	4.5	Dolci		\N	\N	\N	\N	\N	\N	\N	\N	t	f	M_Dolci	90	2	0	25
372	Crostata	10	Dolci	Crostata con nutella	\N	\N	\N	\N	\N	\N	\N	\N	f	t	M_Dolci	24	1	0	25
373	Torta	15	Dolci		\N	\N	\N	\N	\N	\N	\N	\N	t	f	M_Dolci	88	3	0	25
374	Ricotta	2	Latticini		0	latte di mucca	\N	\N	\N	\N	\N	\N	\N	\N	M_Latticini	78	2	0	26
375	Mozzarella di bufala	3.5	Latticini		0	latte di bufala	\N	\N	\N	\N	\N	\N	\N	\N	M_Latticini	91	2	0	26
\.


--
-- Name: prodotto_idprodotto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prodotto_idprodotto_seq', 376, true);


--
-- Data for Name: sconto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sconto (id, "Percent", quantita, scontofisso, discriminator, versione, "Column") FROM stdin;
24	\N	\N	\N	ScontoPercent	1	0
77	\N	\N	\N	ScontoPercent	1	0.150000006
78	\N	\N	\N	ScontoPercent	1	0.200000003
79	\N	\N	\N	ScontoPercent	1	0.129999995
80	\N	\N	\N	ScontoPercent	1	0.230000004
81	\N	\N	\N	ScontoPercent	1	0.0700000003
82	\N	\N	\N	ScontoPercent	1	0.0799999982
83	\N	\N	\N	ScontoPercent	1	0.0399999991
84	\N	\N	\N	ScontoPercent	1	0.0599999987
85	\N	\N	\N	ScontoPercent	1	0.189999998
86	\N	\N	\N	ScontoPercent	1	0.0250000004
87	\N	\N	\N	ScontoPercent	1	0.0299999993
88	\N	\N	\N	ScontoPercent	1	0.100000001
89	\N	\N	\N	ScontoPercent	1	0.119999997
90	\N	10	15	ScontoQuantita	1	\N
91	\N	20	30	ScontoQuantita	1	\N
21	0	\N	\N	ScontoCliente	1	\N
\.


--
-- Name: sconto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sconto_id_seq', 91, true);


--
-- Name: agente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY agente
    ADD CONSTRAINT agente_pkey PRIMARY KEY (idagente);


--
-- Name: azienda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY azienda
    ADD CONSTRAINT azienda_pkey PRIMARY KEY (idazienda);


--
-- Name: cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (idcliente);


--
-- Name: mandante_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mandante
    ADD CONSTRAINT mandante_pkey PRIMARY KEY (idmandante);


--
-- Name: prodotto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prodotto
    ADD CONSTRAINT prodotto_pkey PRIMARY KEY (idprodotto);


--
-- Name: sconto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sconto
    ADD CONSTRAINT sconto_pkey PRIMARY KEY (id);


--
-- Name: cliente_m_agenteidagente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_m_agenteidagente_fkey FOREIGN KEY (m_agenteidagente) REFERENCES agente(idagente);


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

