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

CREATE DATABASE "agentTrade" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Italian_Italy.1252' LC_CTYPE = 'Italian_Italy.1252';


ALTER DATABASE "agentTrade" OWNER TO postgres;

\connect "agentTrade"

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
    cap character varying(255),
    attivo integer DEFAULT 1 NOT NULL
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
-- Name: azienda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE azienda (
    idazienda integer NOT NULL,
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
    cell character varying(255),
    attivo integer DEFAULT 1 NOT NULL,
    sconto integer DEFAULT 0,
    versione integer,
    versione_download integer
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
    discriminator character varying(255) NOT NULL,
    sconto real DEFAULT 0 NOT NULL,
    idprodottoazienda integer,
    versione integer,
    idazienda integer
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
-- Data for Name: agente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY agente (idagente, nome, cognome, password, username, citta, indirizzo, livello, cell, email, cap, attivo) FROM stdin;
19	D'Andrea	Mirco	asd	mircdan	asd	asd 12	5	1231232131	asd@asd.it	12312	1
1	Antonio	Fraticelli	asd	antofrat	sgr	via foggia 217	3	3204578987	fratic@asd.it	71013	1
\.


--
-- Name: agente_idagente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('agente_idagente_seq', 18, true);


--
-- Data for Name: azienda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY azienda (idazienda, ragionesociale, codicefiscale, partitaiva, citta, cap, indirizzo, email, telefono, fax, url, tipoprodotto, versione) FROM stdin;
21	Rivera	12345678901	12345678901	Firenze	60002	via mah	azienda2@asd.it	3283456540	3283456540	http://pianetaverdesgr.altervista.org/rivera.php	vini	1
22	Beverage	12345678901	12312312312	Roma	60001	via bo	azienda1@asd.it	3201314598	3201314598	http://fratic.altervista.org/beverage.php	vini	1
23	Lem	34534123123	34534512312	Roma	34534	via Roma	asd@asd.it	3455342789	0851234523	http://pianetaverdesgr.altervista.org/lem.php	carni	1
\.


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente (idcliente, m_agenteidagente, nome, cognome, codice_fiscale, indirizzo, email, partita_iva, telefono, fax, citta, cap, cell, attivo, sconto, versione, versione_download) FROM stdin;
26	19	Alessandro	Del Piero	dlplss80d23w123r	Via Roma 12	alex.dp@asd.ds	10012344465	0812539044	0812539044	Torino	60045	3474320383	1	21	1	0
27	19	Claudio	Marchisio	mrccld85f01r123w	Via toto 123		10019834654			Torino	60044	3248761946	1	21	1	0
28	1	Franceco	Totti	tttfrn83e30w123r	Via Colosseo 1		12365433601	0642549068	0642549068	Roma	10001	3335937565	1	21	1	0
29	1	Angelo	Peruzzi	przngl76a13q543p	Via Tevere 10	peruzzi_angelo76@as.asd	90001236183			Roma	10001	3206592311	1	21	1	0
\.


--
-- Name: cliente_idcliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cliente_idcliente_seq', 29, true);


--
-- Data for Name: preventivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY preventivo (idpreventivo, m_clienteidcliente, m_agenteidagente, data) FROM stdin;
\.


--
-- Name: preventivo_idpreventivo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preventivo_idpreventivo_seq', 177, true);


--
-- Data for Name: preventivo_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY preventivo_item (idpreventivo_item, m_prodottoidprodotto, m_preventivoidpreventivo, quantita, sconto, m_preventivoindex) FROM stdin;
\.


--
-- Name: preventivo_item_idpreventivo_item_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preventivo_item_idpreventivo_item_seq', 268, true);


--
-- Data for Name: prodotto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prodotto (idprodotto, nome, prezzo, categoria, iddescrizioneprodotto, stagionatura, tipo, provenienza, taglio, "Column", colore, indicazione_geografica, cantina, artigianale, free_gluten, discriminator, sconto, idprodottoazienda, versione, idazienda) FROM stdin;
341	Montepulciano	9	vini	bla bla bla	\N	\N	\N	\N	\N	rosso	abruzzo	vignone	\N	\N	M_Vini	77	1	4	22
342	Falanghina	12	vini	descrizion di prova	\N	\N	\N	\N	\N	bianco	friuli	visol	\N	\N	M_Vini	77	2	2	22
343	Primitivo Manduria "Sessant' anni" Doc	9	Vini	bal bla bla 	\N	\N	\N	\N	\N	bianco	Puglia, salento	San Marzano	\N	\N	M_Vini	78	3	3	22
344	Malvasia Nera 	7	Vini	Malvasia Nera Igt Talo' Selezione Sud	\N	\N	\N	\N	\N	Rosso	Puglia, salento	San Marzano	\N	\N	M_Vini	24	4	1	22
345	Primitivo Manduria "dieci anni" Doc	8.69999981	Vini	Dieci anni di maturazione in botti di rovere	\N	\N	\N	\N	\N	bianco	Puglia, salento	San Marzano	\N	\N	M_Vini	77	5	2	22
346	Malvasia Rose	12.3999996	Vini	Malvasia Nera Igt Talo' Selezione Sud	\N	\N	\N	\N	\N	Rosso	Puglia, salento	San Marzano	\N	\N	M_Vini	24	6	1	22
347	Costera Cannonau Doc	8	Vini	bal bla bla balbalbal	\N	\N	\N	\N	\N	Rosso	Sardegna, Serdianca	ARGIOLAS	\N	\N	M_Vini	77	7	2	22
348	Perle Rose Doc Magnum 	18.3999996	Vini	Perle Rose Doc Magnum (Pinot N./ Chard.) astucciate	\N	\N	\N	\N	\N	Rosso	Trento	Ferrari	\N	\N	M_Vini	24	8	1	22
349	Valpolicella 	8.69999981	Vini	Dop Superiore Monte Lodoletta	\N	\N	\N	\N	\N	Rosso	Lazio	DAL FORNO ROMANO	\N	\N	M_Vini	79	9	1	22
350	Amarone Sant'Urbano DOCG	19	Vini	Amarone Sant'Urbano DOCG bla bla bla 	\N	\N	\N	\N	\N	rosso	Veneto	Speri	\N	\N	M_Vini	80	10	1	22
351	Pinot Grigio Doc	13.5	Vini	bau bua bua	\N	\N	\N	\N	\N	Bianco	Capriva del Friuli	VILLA RUSSIZ	\N	\N	M_Vini	24	11	1	22
352	Raboso Frizzante 	12.5	Vini	Linea Giovane Igt	\N	\N	\N	\N	\N	Rosso	Campodipietra TV	ORNELLA MOLON	\N	\N	M_Vini	81	12	1	22
353	Passimento 	13.5	Vini	Passimento Rosso Sp. Edition Romeo & Giulietta	\N	\N	\N	\N	\N	Rosso	Verona	PASQUA	\N	\N	M_Vini	82	13	1	22
354	GRAPPA INVECCHIATA IL FALCONE	45	Vini	Colore dorato brillante. bouquet intenso\ned elegante. gusto complesso con finale\nmorbido e lungo.	\N	\N	\N	\N	\N	Trasparente	Castel del Monte Riserva D.O.C.G.	Rivera	\N	\N	M_Vini	83	221	5	21
355	FURFANTE BIANCO	23	Vini	Colore bianco paglierino; perlage intenso,bouquet fresco e fruttato; palato fresco, morbido e delicato. Frizzante	\N	\N	\N	\N	\N	Bianco	Puglia I.G.T.\r\n	Rivera	\N	\N	M_Vini	84	220	3	21
356	PRELUDIO N1 Chardonnay	17.3999996	Vini	Giallo paglierino intenso;\nbouquet complesso e fruttato\ncon note di pera e fiori\ndi pesco; palato fresco e\nfruttato, di buona lunghezza e\ncomplessita.	\N	\N	\N	\N	\N	Bianco	Chardonnay\r\nCastel del Monte D.O.C.	Rivera	\N	\N	M_Vini	85	219	2	21
357	PIANI DI TUFARA	21.3999996	Vini	Colore giallo carico e\nbrillante; bouquet di fiori\ndi acacia, albicocca, ananas,\nbuccia d arancia candita;\npalato ricco e complesso,\ndolce, ma con finale asciutto	\N	\N	\N	\N	\N	Bianco	Moscato di Trani D.O.C.	Rivera	\N	\N	M_Vini	86	218	2	21
358	TRIUSCO	20	Vini	Violaceo impenetrabile; bouquet intenso\ndi confettura di ribes e more; molto\npieno, caldo e morbido in bocca con\nnote di prugna, confettura di ribes e\ncioccolato.	\N	\N	\N	\N	\N	Rosso	Primitivo\r\nPuglia I.G.T.	Rivera	\N	\N	M_Vini	77	217	1	21
359	Puer Apuliae	18.3999996	Vini	Rosso violaceo impenetrabile; bouquet intenso di piccoli frutti neri con note di viola e ance stellato.	\N	\N	\N	\N	\N	Rosso	Castel del Monte - nero di Troia	Rivera	\N	\N	M_Vini	87	213	2	21
360	Chianina	22	Carni	Ottima qualita della carne (marezzate e tenere).Tagli piu pregiati soprattutto la regione dorso-lombare dalla quale si ottengono le rinomate bistecche alla fiorentina\n	\N	\N	Toscana	Noce	Vitello	\N	\N	\N	\N	\N	M_Carni	82	311	3	23
361	Romagnola	22	Carni	Produzione di latte tendenzialmente scarsa per il vitello. \nOttima qualita della carne (giusta marezzatura e tenera)	\N	\N	Emilia Romagna	Lombata	Manzo	\N	\N	\N	\N	\N	M_Carni	88	1057	3	23
362	Bufalo	21.5	Carne	La carne di bufalo e' tenera e succosa e contiene meno grassi rispetto a quella di manzo 	\N	\N	Campania	Girello di spalla	Bufalo	\N	\N	\N	\N	\N	M_Carni	24	1058	1	23
363	Blackgold	27.5	Carni	 bla bla bla	\N	\N	Irlanda	Girello di spalla	Manzo - Blackgold	\N	\N	\N	\N	\N	M_Carni	24	1059	1	23
364	Warta	26.5	Carne	  bla bla bla	\N	\N	Polonia	Cappello del prete	Manzo - Warta	\N	\N	\N	\N	\N	M_Carni	24	1060	1	23
365	Angus	31.5	Carne	  bla bla bla	\N	\N	Argentina	Filetto	Vitellone	\N	\N	\N	\N	\N	M_Carni	77	1061	1	23
366	Fassona	24.5	Carne	  bla bla bla	\N	\N	Italia	Biancostato di reale	Manzo	\N	\N	\N	\N	\N	M_Carni	24	1062	1	23
367	Blackgold	18	Carni	  bla bla bla	\N	\N	Irlanda	Punta di petto	Manzo - Blackgold	\N	\N	\N	\N	\N	M_Carni	24	1063	1	23
368	Warta	22.5	Carne	 bla bla bla	\N	\N	Polonia	Scamone	Manzo - Warta	\N	\N	\N	\N	\N	M_Carni	24	1064	1	23
369	Angus	27.5	Carne	  bla bla bla	\N	\N	Argentina	Copertina di spalla	Vitellone	\N	\N	\N	\N	\N	M_Carni	24	1065	1	23
370	Fassona	10	Carne	  bla bla bla	\N	\N	Italia	Fesa	Manzo	\N	\N	\N	\N	\N	M_Carni	89	1066	3	23
\.


--
-- Name: prodotto_idprodotto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prodotto_idprodotto_seq', 9, true);


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
21	0	\N	\N	ScontoCliente	1	\N
\.


--
-- Name: sconto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sconto_id_seq', 12, true);


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
-- Name: sconto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sconto
    ADD CONSTRAINT sconto_pkey PRIMARY KEY (id);


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

