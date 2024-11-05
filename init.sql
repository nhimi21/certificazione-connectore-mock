--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0 (Debian 16.0-1.pgdg120+1)
-- Dumped by pg_dump version 16.3

-- Started on 2024-07-24 16:53:34 CEST

/*
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE eng_cert;
--
-- TOC entry 3720 (class 1262 OID 18450)
-- Name: eng_cert; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE eng_cert WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE eng_cert OWNER TO postgres;

\connect eng_cert

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

*/

--
-- TOC entry 6 (class 2615 OID 18451)
-- Name: certificazione; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA certificazione;


--ALTER SCHEMA certificazione OWNER TO postgres;

--SET default_tablespace = '';

--SET default_table_access_method = heap;


--
-- TOC entry 216 (class 1259 OID 18452)
-- Name: t_cod_programmi; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_cod_programmi (
                                                id_programma integer NOT NULL,
                                                cod_programma character varying(10) NOT NULL,
                                                de_programma character varying(200) NOT NULL,
                                                fg_tipo_programma character varying(4) NOT NULL,
                                                cod_programmazione character varying(5) NOT NULL
);

ALTER TABLE certificazione.t_cod_programmi OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_cod_programmi.fg_tipo_programma IS 'Per identificare le macro categorie di gestione per le stampe (inizialmente FSE o FESR)';

CREATE SEQUENCE certificazione.t_cod_programmi_id_programma_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_cod_programmi_id_programma_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_cod_programmi_id_programma_seq OWNED BY certificazione.t_cod_programmi.id_programma;

ALTER TABLE ONLY certificazione.t_cod_programmi
    ADD CONSTRAINT t_cod_programmi_pk PRIMARY KEY (id_programma);

ALTER TABLE ONLY certificazione.t_cod_programmi ALTER COLUMN id_programma SET DEFAULT nextval('certificazione.t_cod_programmi_id_programma_seq'::regclass);

INSERT INTO certificazione.t_cod_programmi VALUES (1, 'FESR2127', 'FESR 2021-2027', 'FESR', '21-27');
INSERT INTO certificazione.t_cod_programmi VALUES (2, 'FSE+2127', 'FSE+ 2021-2027', 'FSE', '21-27');

SELECT pg_catalog.setval('certificazione.t_cod_programmi_id_programma_seq', 3, true);


--
-- TOC entry 219 (class 1259 OID 18463)
-- Name: t_cod_stati_certificazione; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_cod_stati_certificazione (
                                                           id_stato_cert integer NOT NULL,
                                                           cod_stato_cert character varying(10) NOT NULL,
                                                           de_stato_cert character varying(100) NOT NULL,
                                                           fg_chiusura character varying(1) NOT NULL
);

ALTER TABLE certificazione.t_cod_stati_certificazione OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_cod_stati_certificazione.fg_chiusura IS 'S/N';

CREATE SEQUENCE certificazione.t_cod_stati_certificazione_id_stato_cert_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_cod_stati_certificazione_id_stato_cert_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_cod_stati_certificazione_id_stato_cert_seq OWNED BY certificazione.t_cod_stati_certificazione.id_stato_cert;

ALTER TABLE ONLY certificazione.t_cod_stati_certificazione
    ADD CONSTRAINT t_cod_stati_certificazione_pk PRIMARY KEY (id_stato_cert);

ALTER TABLE ONLY certificazione.t_cod_stati_certificazione ALTER COLUMN id_stato_cert SET DEFAULT nextval('certificazione.t_cod_stati_certificazione_id_stato_cert_seq'::regclass);

INSERT INTO certificazione.t_cod_stati_certificazione VALUES (0, '0', 'In Elaborazione', 'N');
INSERT INTO certificazione.t_cod_stati_certificazione VALUES (1, '1', 'In Lavorazione AdG', 'N');
INSERT INTO certificazione.t_cod_stati_certificazione VALUES (2, '2', 'Inviata all''AC', 'N');
INSERT INTO certificazione.t_cod_stati_certificazione VALUES (3, '3', 'In Lavorazione AC', 'N');
INSERT INTO certificazione.t_cod_stati_certificazione VALUES (4, '4', 'Conclusa', 'S');
INSERT INTO certificazione.t_cod_stati_certificazione VALUES (5, '5', 'Comunicata SFC', 'S');

SELECT pg_catalog.setval('certificazione.t_cod_stati_certificazione_id_stato_cert_seq', 6, true);


--
-- TOC entry 223 (class 1259 OID 18477)
-- Name: t_cod_periodi_contabili; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_cod_periodi_contabili (
                                                        id_periodo_contabile integer NOT NULL,
                                                        cod_periodo_contabile character varying(10) NOT NULL,
                                                        de_periodo_contabile character varying(200) NOT NULL,
                                                        data_inizio date NOT NULL,
                                                        data_fine date NOT NULL,
                                                        cod_programmazione character varying(5) NOT NULL
);

ALTER TABLE certificazione.t_cod_periodi_contabili OWNER TO postgres;

CREATE SEQUENCE certificazione.t_cod_periodi_contabili_id_periodo_contabile_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_cod_periodi_contabili_id_periodo_contabile_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_cod_periodi_contabili_id_periodo_contabile_seq OWNED BY certificazione.t_cod_periodi_contabili.id_periodo_contabile;

ALTER TABLE ONLY certificazione.t_cod_periodi_contabili
    ADD CONSTRAINT t_cod_periodi_contabili_pk PRIMARY KEY (id_periodo_contabile);

ALTER TABLE ONLY certificazione.t_cod_periodi_contabili ALTER COLUMN id_periodo_contabile SET DEFAULT nextval('certificazione.t_cod_periodi_contabili_id_periodo_contabile_seq'::regclass);

INSERT INTO certificazione.t_cod_periodi_contabili VALUES (1, 'I', 'I Periodo', '2021-07-01', '2022-06-30', '21-27');
INSERT INTO certificazione.t_cod_periodi_contabili VALUES (2, 'II', 'II Periodo', '2022-07-01', '2023-06-30', '21-27');
INSERT INTO certificazione.t_cod_periodi_contabili VALUES (3, 'III', 'III Periodo', '2023-07-01', '2024-06-30', '21-27');
INSERT INTO certificazione.t_cod_periodi_contabili VALUES (4, 'IV', 'IV Periodo', '2024-07-01', '2025-06-30', '21-27');
INSERT INTO certificazione.t_cod_periodi_contabili VALUES (5, 'V', 'V Periodo', '2025-07-01', '2026-06-30', '21-27');

SELECT pg_catalog.setval('certificazione.t_cod_periodi_contabili_id_periodo_contabile_seq', 6, true);

--
-- TOC entry 227 (class 1259 OID 18579)
-- Name: t_certificazioni; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_certificazioni (
                                                 id_certificazione integer NOT NULL,
                                                 fk_programma integer NOT NULL,
                                                 fk_stato_certificazione integer NOT NULL,
                                                 fk_periodo_contabile integer NOT NULL,
                                                 data_certificazione date NOT NULL,
                                                 fg_tipo_certificazione character varying(1) NOT NULL,
                                                 cod_certificazione character varying(10) NOT NULL,
                                                 de_certificazione character varying(200) NOT NULL,
                                                 note_adg character varying(4000),
                                                 note_ac character varying(4000),
                                                 cod_regis character varying(50),
                                                 data_invio_sfc date,
                                                 num_nota_adg character varying(50),
                                                 data_nota_adg date,
                                                 fk_certificazione_prec integer,
                                                 fk_certificazione_delta integer,
                                                 ut_ins character varying(100) NOT NULL
);

ALTER TABLE certificazione.t_certificazioni OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_certificazioni.fg_tipo_certificazione IS 'I,F,C,B,S -> Intermedia, Intermedia Finale, Conti, Bozza dei Conti, SIMULAZIONE';

CREATE SEQUENCE certificazione.t_certificazioni_id_certificazione_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_certificazioni_id_certificazione_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_certificazioni_id_certificazione_seq OWNED BY certificazione.t_certificazioni.id_certificazione;

ALTER TABLE ONLY certificazione.t_certificazioni ALTER COLUMN id_certificazione SET DEFAULT nextval('certificazione.t_certificazioni_id_certificazione_seq'::regclass);

ALTER TABLE ONLY certificazione.t_certificazioni
    ADD CONSTRAINT t_certificazioni_pk PRIMARY KEY (id_certificazione);

ALTER TABLE ONLY certificazione.t_certificazioni
    ADD CONSTRAINT t_certificazioni_t_cod_programmi_fk FOREIGN KEY (fk_programma) REFERENCES certificazione.t_cod_programmi(id_programma);

ALTER TABLE ONLY certificazione.t_certificazioni
    ADD CONSTRAINT t_certificazioni_t_cod_stati_certificazione_fk FOREIGN KEY (fk_stato_certificazione) REFERENCES certificazione.t_cod_stati_certificazione(id_stato_cert);

ALTER TABLE ONLY certificazione.t_certificazioni
    ADD CONSTRAINT t_certificazioni_t_cod_periodi_contabili_fk FOREIGN KEY (fk_periodo_contabile) REFERENCES certificazione.t_cod_periodi_contabili(id_periodo_contabile);

ALTER TABLE ONLY certificazione.t_certificazioni
    ADD CONSTRAINT t_certificazioni_t_certificazioni_fk_1 FOREIGN KEY (fk_certificazione_delta) REFERENCES certificazione.t_certificazioni(id_certificazione);

ALTER TABLE ONLY certificazione.t_certificazioni
    ADD CONSTRAINT t_certificazioni_t_certificazioni_fk FOREIGN KEY (fk_certificazione_prec) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_certificazioni VALUES (1, 1, 1, 2, '2024-06-27', 'I', '2023.2', 'Secondo semestre 2023', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Nicola.Forni');
INSERT INTO certificazione.t_certificazioni VALUES (-1, 1, 0, 2, '2024-06-27', 'S', '2023.2 SIM', 'SIMULAZIONE', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Nicola.Forni');

SELECT pg_catalog.setval('certificazione.t_certificazioni_id_certificazione_seq', 2, true);


--
-- TOC entry 225 (class 1259 OID 18484)
-- Name: t_cod_origine_decertificazioni; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_cod_origine_decertificazioni (
                                                               id_origine_decert integer NOT NULL,
                                                               cod_origine_decert character varying(10) NOT NULL,
                                                               de_origine_decert character varying(200) NOT NULL
);

ALTER TABLE certificazione.t_cod_origine_decertificazioni OWNER TO postgres;

CREATE SEQUENCE certificazione.t_cod_origine_decertificazioni_id_origine_decert_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_cod_origine_decertificazioni_id_origine_decert_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_cod_origine_decertificazioni_id_origine_decert_seq OWNED BY certificazione.t_cod_origine_decertificazioni.id_origine_decert;

ALTER TABLE ONLY certificazione.t_cod_origine_decertificazioni
    ADD CONSTRAINT t_cod_origine_decertificazioni_pk PRIMARY KEY (id_origine_decert);

ALTER TABLE ONLY certificazione.t_cod_origine_decertificazioni ALTER COLUMN id_origine_decert SET DEFAULT nextval('certificazione.t_cod_origine_decertificazioni_id_origine_decert_seq'::regclass);

INSERT INTO certificazione.t_cod_origine_decertificazioni VALUES (1, 'ADA', 'Autorità di Audit');
INSERT INTO certificazione.t_cod_origine_decertificazioni VALUES (2, 'SRA', 'Struttura Responsabile di Azione');
INSERT INTO certificazione.t_cod_origine_decertificazioni VALUES (3, 'ADG', 'Autorità di Gestione');
INSERT INTO certificazione.t_cod_origine_decertificazioni VALUES (4, 'AC', 'Autorità Contabile');
INSERT INTO certificazione.t_cod_origine_decertificazioni VALUES (5, 'ENTE', 'Ente Intermedio');
INSERT INTO certificazione.t_cod_origine_decertificazioni VALUES (6, 'ALTRO', 'Altro');

SELECT pg_catalog.setval('certificazione.t_cod_origine_decertificazioni_id_origine_decert_seq', 6, true);


--
-- TOC entry 235 (class 1259 OID 18669)
-- Name: t_storico_decertificazioni; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_decertificazioni (
                                                           key_decertificazione character varying(50) NOT NULL,
                                                           fk_certificazione integer NOT NULL,
                                                           key_fonte character varying(50) NOT NULL,
                                                           key_progetto character varying(50) NOT NULL,
                                                           key_giustificativo character varying(50),
                                                           key_voce_spesa character varying(50),
                                                           key_rich_rimborso character varying(50),
                                                           fg_tipo_decertificazione character varying(2) NOT NULL,
                                                           fk_origine_decert integer NOT NULL,
                                                           imp_errato numeric(17,2),
                                                           imp_decertificazione numeric(17,2) NOT NULL,
                                                           fk_certificazione_rif integer NOT NULL,
                                                           note character varying(1000),
                                                           fg_irregolarita character varying(2) NOT NULL,
                                                           fg_conferma_sosp character varying(1) DEFAULT 'N'::character varying
);

ALTER TABLE certificazione.t_storico_decertificazioni OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_storico_decertificazioni.key_giustificativo IS 'Obbligatorio per i tagli sui giustificativi';

COMMENT ON COLUMN certificazione.t_storico_decertificazioni.key_voce_spesa IS 'Obbligatorio per i tagli sui giustificativi';

COMMENT ON COLUMN certificazione.t_storico_decertificazioni.key_rich_rimborso IS 'Obbligatorio per i tagli sugli anticipi';

COMMENT ON COLUMN certificazione.t_storico_decertificazioni.fg_tipo_decertificazione IS 'G/P/A/R -> Su giustificativi, progetto, anticipi o revoca';

COMMENT ON COLUMN certificazione.t_storico_decertificazioni.fg_irregolarita IS 'S/N';

COMMENT ON COLUMN certificazione.t_storico_decertificazioni.fg_conferma_sosp IS 'S/N';

ALTER TABLE ONLY certificazione.t_storico_decertificazioni
    ADD CONSTRAINT t_storico_decertificazioni_pk PRIMARY KEY (key_decertificazione, fk_certificazione);

ALTER TABLE ONLY certificazione.t_storico_decertificazioni
    ADD CONSTRAINT t_storico_decertificazioni_t_cod_origine_decertificazioni_fk FOREIGN KEY (fk_origine_decert) REFERENCES certificazione.t_cod_origine_decertificazioni(id_origine_decert);

ALTER TABLE ONLY certificazione.t_storico_decertificazioni
    ADD CONSTRAINT t_storico_decertificazioni_t_certificazioni_fk_1 FOREIGN KEY (fk_certificazione_rif) REFERENCES certificazione.t_certificazioni(id_certificazione);

ALTER TABLE ONLY certificazione.t_storico_decertificazioni
    ADD CONSTRAINT t_storico_decertificazioni_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_storico_decertificazioni VALUES ('10058181-1', 1, 'SIU', '10058181', '1234567891', 'B1.2', '987', 'G', 2, 1000.00, 1000.00, 1, NULL, 'S', 'N');


--
-- TOC entry 232 (class 1259 OID 18646)
-- Name: t_certificazioni_decert; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_certificazioni_decert (
                                                        key_decertificazione character varying(50) NOT NULL,
                                                        fk_certificazione integer NOT NULL,
                                                        key_fonte character varying(50) NOT NULL,
                                                        key_progetto character varying(50) NOT NULL,
                                                        key_rich_rimborso character varying(50),
                                                        key_giustificativo character varying(50),
                                                        key_voce_spesa character varying(50) NOT NULL,
                                                        fg_irregolarita character varying(1) NOT NULL,
                                                        fg_modalita character varying(3) NOT NULL,
                                                        fg_tipo_decertificazione character varying(1) NOT NULL,
                                                        fk_origine_decert integer NOT NULL,
                                                        rif_documento character varying(500),
                                                        imp_ammesso_errato numeric(17,2),
                                                        imp_errato numeric(17,2) NOT NULL,
                                                        imp_decertificazione numeric(17,2) NOT NULL,
                                                        fk_certificazione_rif integer NOT NULL,
                                                        motivazione_decert character varying(4000) NOT NULL,
                                                        note character varying(4000),
                                                        fg_conferma_sosp character varying(1) NOT NULL,
                                                        rif_scheda_olaf character varying(1000),
                                                        note_ac_interne character varying(4000),
                                                        note_ac_pubbliche character varying(4000)
);

ALTER TABLE certificazione.t_certificazioni_decert OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_certificazioni_decert.fg_irregolarita IS 'Irregolarità S/N';

COMMENT ON COLUMN certificazione.t_certificazioni_decert.fg_modalita IS 'RIT = Ritiro, REC = Recupero';

COMMENT ON COLUMN certificazione.t_certificazioni_decert.fg_tipo_decertificazione IS 'G/P/A/R -> Su giustificativi, progetto, anticipi, revoca/rinuncia/ritiro dal programma';

COMMENT ON COLUMN certificazione.t_certificazioni_decert.imp_ammesso_errato IS 'Quota di importo ammesso errata (tagliata)';

COMMENT ON COLUMN certificazione.t_certificazioni_decert.imp_errato IS 'Quota di importo maturato errato (tagliata)';

COMMENT ON COLUMN certificazione.t_certificazioni_decert.imp_decertificazione IS 'Quota da decertificare (<= imp_errato)';

COMMENT ON COLUMN certificazione.t_certificazioni_decert.fg_conferma_sosp IS 'S/N, Indica se è una decertificazione usata per confermare una Sospensione AC';

COMMENT ON COLUMN certificazione.t_certificazioni_decert.note_ac_interne IS 'Note da esporre nel registro debitori se lo stampa l''AC (se la stampa è visibile solo all''AC non serve discriminare)';

COMMENT ON COLUMN certificazione.t_certificazioni_decert.note_ac_pubbliche IS 'Note da esporre nel registro debitori indipendentemente dal profilo';

ALTER TABLE ONLY certificazione.t_certificazioni_decert
    ADD CONSTRAINT t_certificazioni_decert_pk PRIMARY KEY (fk_certificazione, key_decertificazione);

ALTER TABLE ONLY certificazione.t_certificazioni_decert
    ADD CONSTRAINT t_certificazioni_decert_t_cod_origine_decertificazioni_fk FOREIGN KEY (fk_origine_decert) REFERENCES certificazione.t_cod_origine_decertificazioni(id_origine_decert);

ALTER TABLE ONLY certificazione.t_certificazioni_decert
    ADD CONSTRAINT t_certificazioni_decert_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

ALTER TABLE ONLY certificazione.t_certificazioni_decert
    ADD CONSTRAINT t_certificazioni_decert_t_storico_decertificazioni_fk FOREIGN KEY (fk_certificazione, key_decertificazione) REFERENCES certificazione.t_storico_decertificazioni(fk_certificazione, key_decertificazione);

ALTER TABLE ONLY certificazione.t_certificazioni_decert
    ADD CONSTRAINT t_certificazioni_decert_t_certificazioni_fk_1 FOREIGN KEY (fk_certificazione_rif) REFERENCES certificazione.t_certificazioni(id_certificazione);


--
-- TOC entry 229 (class 1259 OID 18620)
-- Name: t_certificazioni_det; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_certificazioni_det (
                                                     fk_certificazione integer NOT NULL,
                                                     key_progetto character varying(50) NOT NULL,
                                                     cod_progetto character varying(50) NOT NULL,
                                                     cod_priorita character varying(10) NOT NULL,
                                                     cod_obiettivo character varying(10) NOT NULL,
                                                     cod_azione character varying(10) NOT NULL,
                                                     imp_certificabile numeric(17,2) NOT NULL,
                                                     imp_certificato_adg numeric(17,2) NOT NULL,
                                                     imp_ue_adg numeric(17,2) NOT NULL,
                                                     imp_stato_adg numeric(17,2) NOT NULL,
                                                     imp_regione_adg numeric(17,2) NOT NULL,
                                                     imp_certificato_ac numeric(17,2) NOT NULL,
                                                     imp_ue_ac numeric(17,2) NOT NULL,
                                                     imp_stato_ac numeric(17,2) NOT NULL,
                                                     imp_regione_ac numeric(17,2) NOT NULL,
                                                     imp_anticipo_cert_adg numeric(17,2) NOT NULL,
                                                     imp_anticipo_cert_ac numeric(17,2) NOT NULL,
                                                     fg_sospensione character varying(1) NOT NULL,
                                                     imp_decert_ant numeric(17,2),
                                                     imp_decert_tot numeric(17,2),
                                                     imp_decert_ada numeric(17,2),
                                                     imp_decert_rev numeric(17,2),
                                                     fg_assistenza_tecnica character varying(1) NOT NULL,
                                                     imp_strum_finanz_tot numeric(17,2),
                                                     imp_strum_finanz_pubb numeric(17,2)
);

ALTER TABLE certificazione.t_certificazioni_det OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_certificazioni_det.cod_priorita IS 'Dettaglio di primo livello';

COMMENT ON COLUMN certificazione.t_certificazioni_det.cod_obiettivo IS 'Dettaglio di secondo livello';

COMMENT ON COLUMN certificazione.t_certificazioni_det.cod_azione IS 'Dettaglio di terzo livello';

COMMENT ON COLUMN certificazione.t_certificazioni_det.fg_sospensione IS 'S/N';

COMMENT ON COLUMN certificazione.t_certificazioni_det.fg_assistenza_tecnica IS 'S/N';

ALTER TABLE ONLY certificazione.t_certificazioni_det
    ADD CONSTRAINT t_certificazioni_det_pk PRIMARY KEY (fk_certificazione, key_progetto);

ALTER TABLE ONLY certificazione.t_certificazioni_det
    ADD CONSTRAINT t_certificazioni_det_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_certificazioni_det VALUES (1, '10058181', '10058181', '01', '01.1', '4B23F', 40000.00, 40000.00, 20000.00, 15000.00, 5000.00, 40000.00, 20000.00, 15000.00, 5000.00, 20000.00, 20000.00, 'N', 3000.00, 3000.00, NULL, NULL, 'N', NULL, NULL);


--
-- TOC entry 221 (class 1259 OID 18470)
-- Name: t_cod_parametri; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_cod_parametri (
                                                id_parametro integer NOT NULL,
                                                cod_parametro character varying(10) NOT NULL,
                                                de_parametro character varying(200) NOT NULL
);

ALTER TABLE certificazione.t_cod_parametri OWNER TO postgres;

CREATE SEQUENCE certificazione.t_cod_parametri_id_parametro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_cod_parametri_id_parametro_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_cod_parametri_id_parametro_seq OWNED BY certificazione.t_cod_parametri.id_parametro;

ALTER TABLE ONLY certificazione.t_cod_parametri
    ADD CONSTRAINT t_cod_parametri_pk PRIMARY KEY (id_parametro);

ALTER TABLE ONLY certificazione.t_cod_parametri
    ADD CONSTRAINT t_cod_parametri_unique UNIQUE (cod_parametro);

ALTER TABLE ONLY certificazione.t_cod_parametri ALTER COLUMN id_parametro SET DEFAULT nextval('certificazione.t_cod_parametri_id_parametro_seq'::regclass);

INSERT INTO certificazione.t_cod_parametri VALUES (1, 'CertNewAnt', 'Certificabilità dei nuovi anticipi per i progetti di aiuto');
INSERT INTO certificazione.t_cod_parametri VALUES (2, 'CertPreSal', 'Certificabilità prima del saldo finale');
INSERT INTO certificazione.t_cod_parametri VALUES (3, 'CertZero', 'Certificazione con avanzamento "a zero"');
INSERT INTO certificazione.t_cod_parametri VALUES (4, 'ConfSosp', 'Conferma delle eventuali sospensioni dei Conti in caso di Certificazioni "a zero"');
INSERT INTO certificazione.t_cod_parametri VALUES (5, 'CertParz', 'Certificabilità delle quote parziali in caso di copertura dei parziale pagamenti per i progetti di aiuto');
INSERT INTO certificazione.t_cod_parametri VALUES (6, 'ObblCopPag', 'Obbligo di copertura dei pagamenti ai beneficiari per i progetti di aiuto *');
INSERT INTO certificazione.t_cod_parametri VALUES (7, 'NonDichCam', 'Non dichiarabilità in caso di progetto campionato *');
INSERT INTO certificazione.t_cod_parametri VALUES (8, 'FidNonScad', 'Presenza di una fidejussione valida non scaduta per certificare nuove quote di anticipo *');
INSERT INTO certificazione.t_cod_parametri VALUES (9, 'Max40Ant', 'Massimale del 40% del contributo totale previsto per la quota di anticipo da certificare *');
INSERT INTO certificazione.t_cod_parametri VALUES (10, 'NonDichPrj', 'Non dichiarabilità della nuova spesa in caso di controlli in corso sul progetto');

SELECT pg_catalog.setval('certificazione.t_cod_parametri_id_parametro_seq', 11, true);


--
-- TOC entry 233 (class 1259 OID 18653)
-- Name: t_certificazione_parametri; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_certificazione_parametri (
                                                           fk_certificazione integer NOT NULL,
                                                           fk_parametro integer NOT NULL,
                                                           fg_attivo character varying(1) NOT NULL
);

ALTER TABLE certificazione.t_certificazione_parametri OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_certificazione_parametri.fg_attivo IS 'S/N';

ALTER TABLE ONLY certificazione.t_certificazione_parametri
    ADD CONSTRAINT t_certificazione_parametri_pk PRIMARY KEY (fk_certificazione, fk_parametro);

ALTER TABLE ONLY certificazione.t_certificazione_parametri
    ADD CONSTRAINT t_certificazione_parametri_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

ALTER TABLE ONLY certificazione.t_certificazione_parametri
    ADD CONSTRAINT t_certificazione_parametri_t_cod_parametri_fk FOREIGN KEY (fk_parametro) REFERENCES certificazione.t_cod_parametri(id_parametro);


--
-- TOC entry 274 (class 1259 OID 19079)
-- Name: t_cod_bandi; Type: TABLE; Schema: certificazione; Owner: postgres
--

--CREATE TABLE certificazione.t_cod_bandi (
--    key_bando character varying(50),
--    cod_bando character varying(50),
--    de_bando character varying(500),
--    key_progetto character varying(50),
--    cod_progetto character varying(50),
--    titolo_progetto character varying(500),
--    fk_programma integer NOT NULL
--);

--ALTER TABLE certificazione.t_cod_bandi OWNER TO postgres;


--
-- TOC entry 231 (class 1259 OID 18636)
-- Name: t_progetti_certificati_periodi; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_progetti_certificati_periodi (
                                                               key_progetto character varying(50) NOT NULL,
                                                               fk_periodo_contabile integer NOT NULL,
                                                               fk_programma integer NOT NULL,
                                                               cod_priorita character varying(10) NOT NULL,
                                                               cod_obiettivo character varying(10) NOT NULL,
                                                               cod_azione character varying(10) NOT NULL,
                                                               imp_certificato numeric(17,2) NOT NULL,
                                                               imp_ue numeric(17,2) NOT NULL,
                                                               imp_stato numeric(17,2) NOT NULL,
                                                               imp_regione numeric(17,2) NOT NULL
);

ALTER TABLE certificazione.t_progetti_certificati_periodi OWNER TO postgres;

ALTER TABLE ONLY certificazione.t_progetti_certificati_periodi
    ADD CONSTRAINT t_progetti_certificati_periodi_pk PRIMARY KEY (key_progetto, fk_periodo_contabile, fk_programma);

ALTER TABLE ONLY certificazione.t_progetti_certificati_periodi
    ADD CONSTRAINT t_progetti_certificati_periodi_t_cod_periodi_contabili_fk FOREIGN KEY (fk_periodo_contabile) REFERENCES certificazione.t_cod_periodi_contabili(id_periodo_contabile);


--
-- TOC entry 240 (class 1259 OID 18762)
-- Name: t_conf_checklist_ac; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_conf_checklist_ac (
                                                    id_checklist_conf integer NOT NULL,
                                                    fk_programma integer NOT NULL,
                                                    de_checklist character varying(500) NOT NULL,
                                                    data_inizio_validita date NOT NULL,
                                                    data_fine_validita date,
                                                    fg_tipo_checklist character varying(1) NOT NULL
);

ALTER TABLE certificazione.t_conf_checklist_ac OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_conf_checklist_ac.fg_tipo_checklist IS 'I,C,T -> Specifiche per le certificazioni: Intermedie, Conti, Tutte';

CREATE SEQUENCE certificazione.t_conf_checklist_ac_id_checklist_conf_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_conf_checklist_ac_id_checklist_conf_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_conf_checklist_ac_id_checklist_conf_seq OWNED BY certificazione.t_conf_checklist_ac.id_checklist_conf;

ALTER TABLE ONLY certificazione.t_conf_checklist_ac
    ADD CONSTRAINT t_conf_checklist_ac_pk PRIMARY KEY (id_checklist_conf);

ALTER TABLE ONLY certificazione.t_conf_checklist_ac ALTER COLUMN id_checklist_conf SET DEFAULT nextval('certificazione.t_conf_checklist_ac_id_checklist_conf_seq'::regclass);

SELECT pg_catalog.setval('certificazione.t_conf_checklist_ac_id_checklist_conf_seq', 1, false);


--
-- TOC entry 242 (class 1259 OID 18776)
-- Name: t_conf_checklist_ac_sezioni; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_conf_checklist_ac_sezioni (
                                                            id_checklist_sez_conf integer NOT NULL,
                                                            fk_checklist_conf integer NOT NULL,
                                                            de_sezione character varying(500) NOT NULL
);

ALTER TABLE certificazione.t_conf_checklist_ac_sezioni OWNER TO postgres;

CREATE SEQUENCE certificazione.t_conf_checklist_ac_sezioni_id_checklist_sez_conf_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_conf_checklist_ac_sezioni_id_checklist_sez_conf_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_conf_checklist_ac_sezioni_id_checklist_sez_conf_seq OWNED BY certificazione.t_conf_checklist_ac_sezioni.id_checklist_sez_conf;

ALTER TABLE ONLY certificazione.t_conf_checklist_ac_sezioni
    ADD CONSTRAINT t_conf_checklist_ac_sezioni_pk PRIMARY KEY (id_checklist_sez_conf);

ALTER TABLE ONLY certificazione.t_conf_checklist_ac_sezioni
    ADD CONSTRAINT t_conf_checklist_ac_sezioni_t_conf_checklist_ac_fk FOREIGN KEY (fk_checklist_conf) REFERENCES certificazione.t_conf_checklist_ac(id_checklist_conf);

ALTER TABLE ONLY certificazione.t_conf_checklist_ac_sezioni ALTER COLUMN id_checklist_sez_conf SET DEFAULT nextval('certificazione.t_conf_checklist_ac_sezioni_id_checklist_sez_conf_seq'::regclass);

SELECT pg_catalog.setval('certificazione.t_conf_checklist_ac_sezioni_id_checklist_sez_conf_seq', 1, false);


--
-- TOC entry 244 (class 1259 OID 18790)
-- Name: t_conf_checklist_ac_domande; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_conf_checklist_ac_domande (
                                                            id_checklist_dom_conf integer NOT NULL,
                                                            fk_checklist_sez_conf integer NOT NULL,
                                                            de_domanda character varying(500) NOT NULL,
                                                            fg_tipo_risposta character varying(3) NOT NULL
);

ALTER TABLE certificazione.t_conf_checklist_ac_domande OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_conf_checklist_ac_domande.fg_tipo_risposta IS 'SN, SNA, TXT -> S/N, S/N/NA, Testo libero';

CREATE SEQUENCE certificazione.t_conf_checklist_ac_domande_id_checklist_dom_conf_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_conf_checklist_ac_domande_id_checklist_dom_conf_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_conf_checklist_ac_domande_id_checklist_dom_conf_seq OWNED BY certificazione.t_conf_checklist_ac_domande.id_checklist_dom_conf;

ALTER TABLE ONLY certificazione.t_conf_checklist_ac_domande
    ADD CONSTRAINT t_conf_checklist_ac_domande_pk PRIMARY KEY (id_checklist_dom_conf);

ALTER TABLE ONLY certificazione.t_conf_checklist_ac_domande
    ADD CONSTRAINT t_conf_checklist_ac_domande_t_conf_checklist_ac_sezioni_fk FOREIGN KEY (fk_checklist_sez_conf) REFERENCES certificazione.t_conf_checklist_ac_sezioni(id_checklist_sez_conf);

ALTER TABLE ONLY certificazione.t_conf_checklist_ac_domande ALTER COLUMN id_checklist_dom_conf SET DEFAULT nextval('certificazione.t_conf_checklist_ac_domande_id_checklist_dom_conf_seq'::regclass);

SELECT pg_catalog.setval('certificazione.t_conf_checklist_ac_domande_id_checklist_dom_conf_seq', 1, false);


--
-- TOC entry 237 (class 1259 OID 18733)
-- Name: t_cert_checklist_ac; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_cert_checklist_ac (
                                                    id_checklist_cert integer NOT NULL,
                                                    fk_certificazione integer NOT NULL,
                                                    fk_checklist_conf integer NOT NULL,
                                                    note character varying(1000)
);

ALTER TABLE certificazione.t_cert_checklist_ac OWNER TO postgres;

CREATE SEQUENCE certificazione.t_cert_checklist_ac_id_checklist_cert_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_cert_checklist_ac_id_checklist_cert_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_cert_checklist_ac_id_checklist_cert_seq OWNED BY certificazione.t_cert_checklist_ac.id_checklist_cert;

ALTER TABLE ONLY certificazione.t_cert_checklist_ac ALTER COLUMN id_checklist_cert SET DEFAULT nextval('certificazione.t_cert_checklist_ac_id_checklist_cert_seq'::regclass);

SELECT pg_catalog.setval('certificazione.t_cert_checklist_ac_id_checklist_cert_seq', 1, false);

ALTER TABLE ONLY certificazione.t_cert_checklist_ac
    ADD CONSTRAINT t_cert_checklist_ac_pk PRIMARY KEY (id_checklist_cert);

ALTER TABLE ONLY certificazione.t_cert_checklist_ac
    ADD CONSTRAINT t_cert_checklist_ac_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

ALTER TABLE ONLY certificazione.t_cert_checklist_ac
    ADD CONSTRAINT t_cert_checklist_ac_t_conf_checklist_ac_fk FOREIGN KEY (fk_checklist_conf) REFERENCES certificazione.t_conf_checklist_ac(id_checklist_conf);


--
--
-- Name: t_cert_checklist_ac_domande; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_cert_checklist_ac_domande (
                                                            id_checklist_dom_cert integer NOT NULL,
                                                            fk_checklist_dom_conf integer NOT NULL,
                                                            risposta character varying(1000)
);

ALTER TABLE certificazione.t_cert_checklist_ac_domande OWNER TO postgres;

CREATE SEQUENCE certificazione.t_cert_checklist_ac_domande_id_checklist_dom_cert_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_cert_checklist_ac_domande_id_checklist_dom_cert_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_cert_checklist_ac_domande_id_checklist_dom_cert_seq OWNED BY certificazione.t_cert_checklist_ac_domande.id_checklist_dom_cert;

ALTER TABLE ONLY certificazione.t_cert_checklist_ac_domande ALTER COLUMN id_checklist_dom_cert SET DEFAULT nextval('certificazione.t_cert_checklist_ac_domande_id_checklist_dom_cert_seq'::regclass);

SELECT pg_catalog.setval('certificazione.t_cert_checklist_ac_domande_id_checklist_dom_cert_seq', 1, false);

ALTER TABLE ONLY certificazione.t_cert_checklist_ac_domande
    ADD CONSTRAINT t_cert_checklist_ac_domande_pk PRIMARY KEY (id_checklist_dom_cert);

ALTER TABLE ONLY certificazione.t_cert_checklist_ac_domande
    ADD CONSTRAINT t_cert_checklist_ac_domande_t_conf_checklist_ac_domande_fk FOREIGN KEY (fk_checklist_dom_conf) REFERENCES certificazione.t_conf_checklist_ac_domande(id_checklist_dom_conf);


--
-- TOC entry 246 (class 1259 OID 18804)
-- Name: t_cert_checklist_sezioni; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_cert_checklist_sezioni (
                                                         id_checklist_sez_cert integer NOT NULL,
                                                         fk_checklist_sez_conf integer NOT NULL
);

ALTER TABLE certificazione.t_cert_checklist_sezioni OWNER TO postgres;

CREATE SEQUENCE certificazione.t_cert_checklist_sezioni_id_checklist_sez_cert_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_cert_checklist_sezioni_id_checklist_sez_cert_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_cert_checklist_sezioni_id_checklist_sez_cert_seq OWNED BY certificazione.t_cert_checklist_sezioni.id_checklist_sez_cert;

ALTER TABLE ONLY certificazione.t_cert_checklist_sezioni ALTER COLUMN id_checklist_sez_cert SET DEFAULT nextval('certificazione.t_cert_checklist_sezioni_id_checklist_sez_cert_seq'::regclass);

SELECT pg_catalog.setval('certificazione.t_cert_checklist_sezioni_id_checklist_sez_cert_seq', 1, false);

ALTER TABLE ONLY certificazione.t_cert_checklist_sezioni
    ADD CONSTRAINT t_cert_checklist_sezioni_pk PRIMARY KEY (id_checklist_sez_cert);

ALTER TABLE ONLY certificazione.t_cert_checklist_sezioni
    ADD CONSTRAINT t_cert_checklist_sezioni_t_conf_checklist_ac_sezioni_fk FOREIGN KEY (fk_checklist_sez_conf) REFERENCES certificazione.t_conf_checklist_ac_sezioni(id_checklist_sez_conf);


--
-- TOC entry 238 (class 1259 OID 18746)
-- Name: t_conf_parametri; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_conf_parametri (
                                                 fk_programma integer NOT NULL,
                                                 fk_parametro integer NOT NULL,
                                                 fg_attivo character varying(1) NOT NULL
);

ALTER TABLE certificazione.t_conf_parametri OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_conf_parametri.fg_attivo IS 'S/N';

ALTER TABLE ONLY certificazione.t_conf_parametri
    ADD CONSTRAINT t_conf_parametri_pk PRIMARY KEY (fk_programma, fk_parametro);

ALTER TABLE ONLY certificazione.t_conf_parametri
    ADD CONSTRAINT t_conf_parametri_t_cod_parametri_fk FOREIGN KEY (fk_parametro) REFERENCES certificazione.t_cod_parametri(id_parametro);

ALTER TABLE ONLY certificazione.t_conf_parametri
    ADD CONSTRAINT t_conf_parametri_t_cod_programmi_fk FOREIGN KEY (fk_programma) REFERENCES certificazione.t_cod_programmi(id_programma);


--
-- TOC entry 271 (class 1259 OID 19036)
-- Name: t_filtri_certificazione; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_filtri_certificazione (
                                                        id_filtro integer NOT NULL,
                                                        fk_programma integer NOT NULL,
                                                        key_bando character varying(50),
                                                        cod_bando character varying(50),
                                                        de_bando character varying(500),
                                                        key_progetto character varying(50),
                                                        cod_progetto character varying(50),
                                                        titolo_progetto character varying(500),
                                                        fg_tipo_filtro character varying(3)
);

ALTER TABLE certificazione.t_filtri_certificazione OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_filtri_certificazione.fg_tipo_filtro IS 'AdG / AC per identificare chi ha applicato il filtro';

CREATE SEQUENCE certificazione.t_filtri_certificazione_id_filtro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_filtri_certificazione_id_filtro_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_filtri_certificazione_id_filtro_seq OWNED BY certificazione.t_filtri_certificazione.id_filtro;

ALTER TABLE ONLY certificazione.t_filtri_certificazione
    ADD CONSTRAINT t_filtri_certificazione_pk PRIMARY KEY (id_filtro);

ALTER TABLE ONLY certificazione.t_filtri_certificazione
    ADD CONSTRAINT t_filtri_certificazione_t_cod_programmi_fk FOREIGN KEY (fk_programma) REFERENCES certificazione.t_cod_programmi(id_programma);

ALTER TABLE ONLY certificazione.t_filtri_certificazione ALTER COLUMN id_filtro SET DEFAULT nextval('certificazione.t_filtri_certificazione_id_filtro_seq'::regclass);

SELECT pg_catalog.setval('certificazione.t_filtri_certificazione_id_filtro_seq', 1, false);


--
-- TOC entry 264 (class 1259 OID 18983)
-- Name: t_log_certificazione; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_log_certificazione (
                                                     id_log integer NOT NULL,
                                                     fk_certificazione integer NOT NULL,
                                                     data_log date NOT NULL,
                                                     key_progetto character varying(50) NOT NULL,
                                                     cod_progetto character varying(50) NOT NULL,
                                                     de_log character varying(1000) NOT NULL
);

ALTER TABLE certificazione.t_log_certificazione OWNER TO postgres;

CREATE SEQUENCE certificazione.t_log_certificazione_id_log_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_log_certificazione_id_log_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_log_certificazione_id_log_seq OWNED BY certificazione.t_log_certificazione.id_log;

ALTER TABLE ONLY certificazione.t_log_certificazione
    ADD CONSTRAINT t_log_certificazione_pk PRIMARY KEY (id_log);

ALTER TABLE ONLY certificazione.t_log_certificazione
    ADD CONSTRAINT t_log_certificazione_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

ALTER TABLE ONLY certificazione.t_log_certificazione ALTER COLUMN id_log SET DEFAULT nextval('certificazione.t_log_certificazione_id_log_seq'::regclass);

SELECT pg_catalog.setval('certificazione.t_log_certificazione_id_log_seq', 1, false);


--
-- TOC entry 230 (class 1259 OID 18631)
-- Name: t_progetti_certificati; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_progetti_certificati (
                                                       key_progetto character varying(50) NOT NULL,
                                                       fk_programma integer NOT NULL,
                                                       cod_priorita character varying(10) NOT NULL,
                                                       cod_obiettivo character varying(10) NOT NULL,
                                                       cod_azione character varying(10) NOT NULL,
                                                       imp_certificato numeric(17,2) NOT NULL,
                                                       imp_ue numeric(17,2) NOT NULL,
                                                       imp_stato numeric(17,2) NOT NULL,
                                                       imp_regione numeric(17,2) NOT NULL,
                                                       imp_anticipo numeric(17,2) NOT NULL
);

ALTER TABLE certificazione.t_progetti_certificati OWNER TO postgres;

ALTER TABLE ONLY certificazione.t_progetti_certificati
    ADD CONSTRAINT t_progetti_certificati_pk PRIMARY KEY (key_progetto, fk_programma);


--
-- TOC entry 265 (class 1259 OID 19001)
-- Name: t_simulazione_cert; Type: TABLE; Schema: certificazione; Owner: postgres
--

--CREATE TABLE certificazione.t_simulazione_cert (
--    fk_programma integer NOT NULL,
--    key_progetto integer NOT NULL,
--    data_simulazione date NOT NULL,
--    imp_certificato numeric(17,2) NOT NULL,
--    imp_ue numeric(17,2) NOT NULL,
--    imp_stato numeric(17,2) NOT NULL,
--    imp_regione numeric(17,2) NOT NULL,
--    imp_decert_ant numeric(17,2) NOT NULL,
--    imp_decert_tot numeric(17,2) NOT NULL,
--    imp_decert_ada numeric(17,2) NOT NULL,
--    fg_sospensione character varying(1) NOT NULL
--);

--ALTER TABLE certificazione.t_simulazione_cert OWNER TO postgres;

--COMMENT ON COLUMN certificazione.t_simulazione_cert.fg_sospensione IS 'S/N';


--
-- TOC entry 267 (class 1259 OID 19012)
-- Name: t_sospensioni_ac; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_sospensioni_ac (
                                                 id_sospensione integer NOT NULL,
                                                 fk_certificazione integer NOT NULL,
                                                 key_progetto character varying(50) NOT NULL,
                                                 fg_stato_sospensione character varying(2) NOT NULL
);

ALTER TABLE certificazione.t_sospensioni_ac OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_sospensioni_ac.fg_stato_sospensione IS 'A,N,C -> Attiva, Non attiva (annullata), Confermata';

CREATE SEQUENCE certificazione.t_sospensioni_ac_id_sospensione_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_sospensioni_ac_id_sospensione_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_sospensioni_ac_id_sospensione_seq OWNED BY certificazione.t_sospensioni_ac.id_sospensione;

ALTER TABLE ONLY certificazione.t_sospensioni_ac
    ADD CONSTRAINT t_sospensioni_ac_pk PRIMARY KEY (id_sospensione);

ALTER TABLE ONLY certificazione.t_sospensioni_ac
    ADD CONSTRAINT t_sospensioni_ac_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

ALTER TABLE ONLY certificazione.t_sospensioni_ac ALTER COLUMN id_sospensione SET DEFAULT nextval('certificazione.t_sospensioni_ac_id_sospensione_seq'::regclass);

SELECT pg_catalog.setval('certificazione.t_sospensioni_ac_id_sospensione_seq', 1, false);


--
-- TOC entry 269 (class 1259 OID 19024)
-- Name: t_sospensioni_ac_det; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_sospensioni_ac_det (
                                                     id_sospensione_det integer NOT NULL,
                                                     fk_sospensione integer NOT NULL,
                                                     key_rich_rimborso character varying(50),
                                                     key_giustificativo character varying(50),
                                                     key_voce_spesa character varying(50),
                                                     imp_sospeso numeric(17,2) NOT NULL
);

ALTER TABLE certificazione.t_sospensioni_ac_det OWNER TO postgres;

CREATE SEQUENCE certificazione.t_sospensione_ac_det_id_sospensione_det_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE certificazione.t_sospensione_ac_det_id_sospensione_det_seq OWNER TO postgres;

ALTER SEQUENCE certificazione.t_sospensione_ac_det_id_sospensione_det_seq OWNED BY certificazione.t_sospensioni_ac_det.id_sospensione_det;

ALTER TABLE ONLY certificazione.t_sospensioni_ac_det
    ADD CONSTRAINT t_sospensione_ac_dett_pk PRIMARY KEY (id_sospensione_det);

ALTER TABLE ONLY certificazione.t_sospensioni_ac_det
    ADD CONSTRAINT t_sospensione_ac_det_t_sospensioni_ac_fk FOREIGN KEY (fk_sospensione) REFERENCES certificazione.t_sospensioni_ac(id_sospensione);

ALTER TABLE ONLY certificazione.t_sospensioni_ac_det ALTER COLUMN id_sospensione_det SET DEFAULT nextval('certificazione.t_sospensione_ac_det_id_sospensione_det_seq'::regclass);

SELECT pg_catalog.setval('certificazione.t_sospensione_ac_det_id_sospensione_det_seq', 1, false);


--
-- TOC entry 260 (class 1259 OID 18946)
-- Name: t_storico_controlli; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_controlli (
                                                    fk_certificazione integer NOT NULL,
                                                    key_controllo character varying(50) NOT NULL,
                                                    key_fonte character varying(50) NOT NULL,
                                                    key_progetto character varying(50) NOT NULL,
                                                    key_rich_rimborso character varying(50),
                                                    data_inizio date NOT NULL,
                                                    data_fine date,
                                                    soggetto_controllore character varying(200) NOT NULL,
                                                    fg_esito_controllo character varying(2),
                                                    tipo_controllo character varying(100),
                                                    note character varying(2000)
);

ALTER TABLE certificazione.t_storico_controlli OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_storico_controlli.key_rich_rimborso IS 'Per tracciare se il controllo è su una specifica richiesta di rimborso';

COMMENT ON COLUMN certificazione.t_storico_controlli.fg_esito_controllo IS 'P/N/PR -> Positivo, Negativo, Positivo con riserva (con tagli parziali)';

COMMENT ON COLUMN certificazione.t_storico_controlli.tipo_controllo IS 'Tipo di controllo, secondo quanto previsto nei sistemi gestionali (es.: Verifica rendicontale, Controllo in loco, ecc.)';

ALTER TABLE ONLY certificazione.t_storico_controlli
    ADD CONSTRAINT t_storico_controlli_pk PRIMARY KEY (fk_certificazione, key_controllo);

ALTER TABLE ONLY certificazione.t_storico_controlli
    ADD CONSTRAINT t_storico_controlli_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_storico_controlli VALUES (1, '10058181-1', 'SIU', '10058181', NULL, '2024-02-10', '2024-06-24', 'Regione Veneto', 'P', 'Verifica rendicontale', NULL);


--
-- TOC entry 261 (class 1259 OID 18958)
-- Name: t_storico_fidejussioni; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_fidejussioni (
                                                       fk_certificazione integer NOT NULL,
                                                       key_fidejussione character varying(50) NOT NULL,
                                                       key_fonte character varying(50) NOT NULL,
                                                       key_progetto character varying(50) NOT NULL,
                                                       key_rich_rimborso character varying(50),
                                                       cod_fidejussione character varying(50) NOT NULL,
                                                       data_fidejussione date NOT NULL,
                                                       data_inizio_validita date NOT NULL,
                                                       data_fine_validita date NOT NULL,
                                                       de_soggetto_emitt character varying(200) NOT NULL,
                                                       ind_soggetto_emitt character varying(200),
                                                       de_soggetto_contr character varying(200) NOT NULL,
                                                       ind_soggetto_contr character varying(200),
                                                       imp_coperto numeric(17,2) NOT NULL
);

ALTER TABLE certificazione.t_storico_fidejussioni OWNER TO postgres;

ALTER TABLE ONLY certificazione.t_storico_fidejussioni
    ADD CONSTRAINT t_storico_fidejussioni_pk PRIMARY KEY (fk_certificazione, key_fidejussione);

ALTER TABLE ONLY certificazione.t_storico_fidejussioni
    ADD CONSTRAINT t_storico_fidejussioni_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);


--
-- TOC entry 252 (class 1259 OID 18852)
-- Name: t_storico_rich_rimborso; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_rich_rimborso (
                                                        fk_certificazione integer NOT NULL,
                                                        key_progetto character varying(50) NOT NULL,
                                                        key_rich_rimborso character varying(50) NOT NULL,
                                                        key_fonte character varying(50) NOT NULL,
                                                        data_rich_rimborso date NOT NULL,
                                                        cod_protocollo character varying(20) NOT NULL,
                                                        data_protocollo date NOT NULL,
                                                        cf_richiedente character varying(20),
                                                        de_richiedente character varying(200),
                                                        imp_anticipo numeric(17,2),
                                                        fg_tipo_rich_rimborso character varying(2) NOT NULL
);

ALTER TABLE certificazione.t_storico_rich_rimborso OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_storico_rich_rimborso.imp_anticipo IS 'Per le richieste di anticipo';

COMMENT ON COLUMN certificazione.t_storico_rich_rimborso.fg_tipo_rich_rimborso IS 'A,I,S,P -> Anticipo, Intermedia, Saldo, Saldo Parziale';

ALTER TABLE ONLY certificazione.t_storico_rich_rimborso
    ADD CONSTRAINT t_storico_rich_rimborso_pk PRIMARY KEY (fk_certificazione, key_progetto, key_rich_rimborso);

ALTER TABLE ONLY certificazione.t_storico_rich_rimborso
    ADD CONSTRAINT t_storico_rich_rimborso_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_storico_rich_rimborso VALUES (1, '10058181', '555', 'SIU', '2024-06-10', '5413', '2025-06-20', 20000.00, NULL, NULL, 'A');
INSERT INTO certificazione.t_storico_rich_rimborso VALUES (1, '10058181', '987', 'SIU', '2024-06-30', '5413', '2024-07-12', NULL, NULL, NULL, 'I');


--
-- TOC entry 255 (class 1259 OID 18886)
-- Name: t_storico_giustificativi; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_giustificativi (
                                                         fk_certificazione integer NOT NULL,
                                                         key_progetto character varying(50) NOT NULL,
                                                         key_rich_rimborso character varying(50) NOT NULL,
                                                         key_giustificativo character varying(50) NOT NULL,
                                                         key_fonte character varying(50) NOT NULL,
                                                         data_quietanza date NOT NULL,
                                                         cf_fornitore character varying(20),
                                                         de_fornitore character varying(200),
                                                         cod_documento character varying(100),
                                                         data_documento date,
                                                         tipo_documento character varying(200),
                                                         note character varying(1000)
);

ALTER TABLE certificazione.t_storico_giustificativi OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_storico_giustificativi.tipo_documento IS 'Un''indicazione testuale tipo: bonifico, fattura, ecc.';

ALTER TABLE ONLY certificazione.t_storico_giustificativi
    ADD CONSTRAINT t_storico_giustificativi_pk PRIMARY KEY (fk_certificazione, key_progetto, key_rich_rimborso, key_giustificativo);

ALTER TABLE ONLY certificazione.t_storico_giustificativi
    ADD CONSTRAINT t_storico_giustificativi_t_storico_rich_rimborso_fk FOREIGN KEY (fk_certificazione, key_progetto, key_rich_rimborso) REFERENCES certificazione.t_storico_rich_rimborso(fk_certificazione, key_progetto, key_rich_rimborso);

ALTER TABLE ONLY certificazione.t_storico_giustificativi
    ADD CONSTRAINT t_storico_giustificativi_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_storico_giustificativi VALUES (1, '10058181', '555', '1234567890', 'SIU', '2024-06-24', '012345678912', 'FRATELLI BANDIERA SRL', '324564', '2024-06-24', 'Bonifico', NULL);
INSERT INTO certificazione.t_storico_giustificativi VALUES (1, '10058181', '987', '1234567891', 'SIU', '2024-06-24', '012345678912', 'FRATELLI BANDIERA SRL', '324565', '2024-06-24', 'Bonifico', NULL);


--
-- TOC entry 257 (class 1259 OID 18905)
-- Name: t_storico_giustificativi_d; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_giustificativi_d (
                                                           fk_certificazione integer NOT NULL,
                                                           key_progetto character varying(50) NOT NULL,
                                                           key_rich_rimborso character varying(50) NOT NULL,
                                                           key_giustificativo character varying(50) NOT NULL,
                                                           key_voce_spesa character varying(50) NOT NULL,
                                                           key_fonte character varying(50) NOT NULL,
                                                           cod_voce_spesa character varying(50) NOT NULL,
                                                           de_voce_spesa character varying(500) NOT NULL,
                                                           imp_presentato numeric(17,2) NOT NULL,
                                                           imp_ammesso numeric(17,2) NOT NULL,
                                                           imp_maturato numeric(17,2) NOT NULL,
                                                           imp_certificato_adg numeric(17,2),
                                                           imp_certificato_ac numeric(17,2),
                                                           costo_standard numeric(17,2),
                                                           quantita integer,
                                                           tipo_voce character varying(10) NOT NULL,
                                                           fg_art_91_4_a_b character varying(1) NOT NULL
);

ALTER TABLE certificazione.t_storico_giustificativi_d OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_storico_giustificativi_d.imp_certificato_adg IS 'Calcolato dalla procedura di certificazione partendo dal dettaglio di giustificativo più vecchio fino ad esaurire l''importo certificato ADG del progetto';

COMMENT ON COLUMN certificazione.t_storico_giustificativi_d.imp_certificato_ac IS 'Calcolato dalla procedura di certificazione partendo dal dettaglio di giustificativo più vecchio fino ad esaurire l''importo certificato AC del progetto';

COMMENT ON COLUMN certificazione.t_storico_giustificativi_d.costo_standard IS 'Se la voce è a costi standard';

COMMENT ON COLUMN certificazione.t_storico_giustificativi_d.quantita IS 'Se la voce è a costi standard';

COMMENT ON COLUMN certificazione.t_storico_giustificativi_d.tipo_voce IS 'S = Costi Standard (unitari) / R = Costi Reali / F = Somme forfettarie / T = Tasso forfettario';

COMMENT ON COLUMN certificazione.t_storico_giustificativi_d.fg_art_91_4_a_b IS 'S/N. Indica se la voce di spesa è a norma dell''articolo 91, paragrafo 4, lettere a) e b)';

ALTER TABLE ONLY certificazione.t_storico_giustificativi_d
    ADD CONSTRAINT t_storico_giustificativi_d_pk PRIMARY KEY (fk_certificazione, key_progetto, key_rich_rimborso, key_giustificativo, key_voce_spesa);

--ALTER TABLE ONLY certificazione.t_storico_giustificativi_d
--    ADD CONSTRAINT t_storico_giustificativi_d_t_storico_giustificativi_fk FOREIGN KEY (fk_giustificativo) REFERENCES certificazione.t_storico_giustificativi(id_giustificativo);

ALTER TABLE ONLY certificazione.t_storico_giustificativi_d
    ADD CONSTRAINT t_storico_giustificativi_d_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_storico_giustificativi_d VALUES (1, '10058181', '555', '1234567890', 'A12', 'SIU', 'A12', 'Spese per il personale', 30000.00, 30000.00, 24000.00, NULL, NULL, NULL, NULL, 'R', 'N');
INSERT INTO certificazione.t_storico_giustificativi_d VALUES (1, '10058181', '987', '1234567891', 'B1.2', 'SIU', 'B1.2', 'Ore di docenza', 11000.00, 10000.00, 8000.00, NULL, NULL, 400.00, 25, 'S', 'N');


--
-- TOC entry 250 (class 1259 OID 18843)
-- Name: t_storico_pagamenti_ai_benef; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_pagamenti_ai_benef (
                                                             fk_certificazione integer NOT NULL,
                                                             key_progetto character varying(50) NOT NULL,
                                                             key_pagamento character varying(50) NOT NULL,
                                                             key_fonte character varying(50) NOT NULL,
                                                             key_rich_rimborso character varying(50) NOT NULL,
                                                             imp_pagamento numeric(17,2) NOT NULL,
                                                             imp_pagamento_cert_adg numeric(17,2) NOT NULL,
                                                             imp_pagamento_cert_ac numeric(17,2) NOT NULL,
                                                             data_pagamento date NOT NULL,
                                                             soggetto_pagamento character varying(100) NOT NULL,
                                                             ae_mandato character varying(4),
                                                             mandato character varying(10),
                                                             id_riga_mandato character varying(4),
                                                             cod_pagamento character varying(50),
                                                             fg_tipo_pagamento character varying(1) NOT NULL,
                                                             note character varying(1000)
);

ALTER TABLE certificazione.t_storico_pagamenti_ai_benef OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_storico_pagamenti_ai_benef.imp_pagamento_cert_adg IS 'SERVE SOLO A TOSCANA: Calcolato dalla procedura di certificazione partendo dal pagamento più vecchio fino ad esaurire l''importo certificato ADG del progetto.';

COMMENT ON COLUMN certificazione.t_storico_pagamenti_ai_benef.imp_pagamento_cert_ac IS 'SERVE SOLO A TOSCANA: Calcolato dalla procedura di certificazione partendo dal pagamento più vecchio fino ad esaurire l''importo certificato AC del progetto.';

COMMENT ON COLUMN certificazione.t_storico_pagamenti_ai_benef.ae_mandato IS 'Se regionale';

COMMENT ON COLUMN certificazione.t_storico_pagamenti_ai_benef.mandato IS 'Se regionale';

COMMENT ON COLUMN certificazione.t_storico_pagamenti_ai_benef.id_riga_mandato IS 'Se regionale';

COMMENT ON COLUMN certificazione.t_storico_pagamenti_ai_benef.cod_pagamento IS 'Se non regionale';

COMMENT ON COLUMN certificazione.t_storico_pagamenti_ai_benef.fg_tipo_pagamento IS 'R/N -> Regionale/Non regionale';

ALTER TABLE ONLY certificazione.t_storico_pagamenti_ai_benef
    ADD CONSTRAINT t_storico_pagamenti_ai_benef_pk PRIMARY KEY (fk_certificazione, key_progetto, key_pagamento);

ALTER TABLE ONLY certificazione.t_storico_pagamenti_ai_benef
    ADD CONSTRAINT t_storico_pagamenti_ai_benef_t_storico_rich_rimborso_fk FOREIGN KEY (fk_certificazione, key_progetto, key_rich_rimborso) REFERENCES certificazione.t_storico_rich_rimborso(fk_certificazione, key_progetto, key_rich_rimborso);

ALTER TABLE ONLY certificazione.t_storico_pagamenti_ai_benef
    ADD CONSTRAINT t_storico_pagamenti_ai_benef_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_storico_pagamenti_ai_benef VALUES (1, '10058181', '10058181', 'SIU', '555', 30000.00, -1.00, -1.00, '2024-06-24', 'REGIONE DEL VENETO', '2024', '12345', '001', NULL, 'R', NULL);


--
-- TOC entry 258 (class 1259 OID 18923)
-- Name: t_storico_pagamenti_attuali; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_pagamenti_attuali (
                                                            fk_certificazione integer NOT NULL,
                                                            key_progetto character varying(50) NOT NULL,
                                                            key_rich_rimborso character varying(50) NOT NULL,
                                                            key_pagamento character varying(50) NOT NULL,
                                                            key_fonte character varying(50) NOT NULL,
                                                            cod_pagamento character varying(50),
                                                            data_pagamento date,
                                                            imp_pagamento numeric(17,2),
                                                            cod_protocollo character varying(50),
                                                            data_protocollo date,
                                                            imp_rich_rimborso numeric(17,2) NOT NULL,
                                                            fg_tipo_rich_rimborso character varying(2) NOT NULL
);

ALTER TABLE certificazione.t_storico_pagamenti_attuali OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_storico_pagamenti_attuali.cod_protocollo IS 'codice protocollo della richiesta di rimborso';

COMMENT ON COLUMN certificazione.t_storico_pagamenti_attuali.data_protocollo IS 'data di protocollo della richiesta di rimborso';

COMMENT ON COLUMN certificazione.t_storico_pagamenti_attuali.imp_rich_rimborso IS 'Importo di contributo sulla richiesta di rimborso';

COMMENT ON COLUMN certificazione.t_storico_pagamenti_attuali.fg_tipo_rich_rimborso IS 'A,I,S,P -> Anticipo, Intermedia, Saldo, Saldo Parziale';

ALTER TABLE ONLY certificazione.t_storico_pagamenti_attuali
    ADD CONSTRAINT t_storico_pagamenti_attuali_pk PRIMARY KEY (fk_certificazione, key_progetto, key_rich_rimborso, key_pagamento, data_protocollo);

ALTER TABLE ONLY certificazione.t_storico_pagamenti_attuali
    ADD CONSTRAINT t_storico_pagamenti_attuali_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_storico_pagamenti_attuali VALUES (1, '10058181', '987', '10058181-555', 'SIU', '6598742', '2024-06-24', 30000.00, '5413', '2024-07-12', 40000.00, 'A');
INSERT INTO certificazione.t_storico_pagamenti_attuali VALUES (1, '10058181', '987', '10058181-999', 'SIU', '6453742', '2024-06-24', 10000.00, '5413', '2024-07-12', 40000.00, 'A');


--
--
-- Name: t_storico_piani_finanziari; Type: TABLE; Schema: certificazione; Owner: postgres
--

--CREATE TABLE certificazione.t_storico_piani_finanziari (
--);


--ALTER TABLE certificazione.t_storico_piani_finanziari OWNER TO postgres;

--
-- TOC entry 249 (class 1259 OID 18829)
-- Name: t_storico_progetti; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_progetti (
                                                   fk_certificazione integer NOT NULL,
                                                   key_progetto character varying(50) NOT NULL,
                                                   key_fonte character varying(50) NOT NULL,
                                                   cod_progetto character varying(50) NOT NULL,
                                                   cod_regionale character varying(50),
                                                   titolo_progetto character varying(500) NOT NULL,
                                                   priorita_progetto character varying(10) NOT NULL,
                                                   obiettivo_specifico character varying(10) NOT NULL,
                                                   azione character varying(10) NOT NULL,
                                                   cod_bando character varying(50) NOT NULL,
                                                   dgr_bando character varying(10),
                                                   de_bando character varying(200),
                                                   dgr_graduatoria character varying(10),
                                                   de_localizzazione character varying(200),
                                                   imp_costo_previsto numeric(17,2) NOT NULL,
                                                   imp_ammissibile numeric(17,2) NOT NULL,
                                                   imp_erogabile numeric(17,2) NOT NULL,
                                                   imp_presentato numeric(17,2) NOT NULL,
                                                   imp_ammesso numeric(17,2) NOT NULL,
                                                   imp_maturato numeric(17,2) NOT NULL,
                                                   de_struttura_resp character varying(200) NOT NULL,
                                                   cod_tipo_aiuto character varying(2) NOT NULL,
                                                   fg_aiuto_parziale character varying(1) NOT NULL,
                                                   imp_aiuto_concesso numeric(17,2),
                                                   imp_aiuto_maturato numeric(17,2),
                                                   codice_cup character varying(20),
                                                   imp_anticipo_totale numeric(17,2) NOT NULL,
                                                   imp_quota_abilitante numeric(17,2) NOT NULL,
                                                   imp_finanz_quota_ue numeric(17,2) NOT NULL,
                                                   imp_finanz_quota_stato numeric(17,2) NOT NULL,
                                                   imp_finanz_quota_regione numeric(17,2) NOT NULL,
                                                   imp_finanz_quota_altri_pubb numeric(17,2) NOT NULL,
                                                   imp_finanz_quota_privati numeric(17,2) NOT NULL,
                                                   fg_assistenza_tecnica character varying(1),
                                                   imp_strum_finanz_tot numeric(17,2),
                                                   imp_strum_finanz_pubb numeric(17,2),
                                                   fg_campionato character varying(1),
                                                   de_beneficiario character varying(200),
                                                   cf_beneficiario character varying(20),
                                                   fg_cert_intermedie character varying(1),
                                                   fg_cert_anticipi character varying(1),
                                                   fg_cert_saldi_parziali character varying(1),
                                                   fg_certificabile character varying(1)
);

ALTER TABLE certificazione.t_storico_progetti OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_storico_progetti.fg_aiuto_parziale IS 'S/N';

COMMENT ON COLUMN certificazione.t_storico_progetti.fg_assistenza_tecnica IS 'S/N';

COMMENT ON COLUMN certificazione.t_storico_progetti.fg_campionato IS 'S/N';

COMMENT ON COLUMN certificazione.t_storico_progetti.fg_cert_intermedie IS 'S/N';

COMMENT ON COLUMN certificazione.t_storico_progetti.fg_cert_anticipi IS 'S/N';

COMMENT ON COLUMN certificazione.t_storico_progetti.fg_cert_saldi_parziali IS 'S/N';

COMMENT ON COLUMN certificazione.t_storico_progetti.fg_certificabile IS 'S/N';

ALTER TABLE ONLY certificazione.t_storico_progetti
    ADD CONSTRAINT t_storico_progetti_pk PRIMARY KEY (fk_certificazione, key_progetto);

ALTER TABLE ONLY certificazione.t_storico_progetti
    ADD CONSTRAINT t_storico_progetti_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_storico_progetti VALUES (1, '10058181', 'SIU', '10058181', '44-0002-1094-2017', 'Tecnico del restauro di beni culturali', '01', '01.1', '4B23F', '978', '654/2024', 'DGR 877/15- INTERVENTI 3° SEZIONE SERVIZI DEL BENESSERE - ASSE III', '5/2024', 'PADOVA', 100000.00, 100000.00, 80000.00, 100000.00, 50000.00, 40000.00, 'DIREZIONE FORMAZIONE E ISTRUZIONE', 'C', 'N', NULL, NULL, 'H17D17000270009', 20000.00, 40000.00, 40000.00, 42000.00, 18000.00, 0.00, 0.00, 'N', 0.00, 0.00, 'N', NULL, NULL, 'N', 'N', 'N', 'N');



--
-- TOC entry 259 (class 1259 OID 18931)
-- Name: t_storico_quote_ripartizione; Type: TABLE; Schema: certificazione; Owner: postgres
--

--CREATE TABLE certificazione.t_storico_quote_ripartizione (
--    fk_certificazione integer NOT NULL,
--    key_progetto character varying(50) NOT NULL,
--    fk_periodo_contabile integer NOT NULL,
--    perc_quota_ue numeric(5,2) NOT NULL,
--    perc_quota_stato numeric(5,2) NOT NULL,
--    perc_quota_regione numeric(5,2) NOT NULL
--);

--ALTER TABLE certificazione.t_storico_quote_ripartizione OWNER TO postgres;

--INSERT INTO certificazione.t_storico_quote_ripartizione VALUES (1, '10058181', 2, 40.00, 42.00, 18.00);


--
-- TOC entry 253 (class 1259 OID 18873)
-- Name: t_storico_recuperi_dai_benef; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_recuperi_dai_benef (
                                                             fk_certificazione integer NOT NULL,
                                                             key_progetto character varying(50) NOT NULL,
                                                             key_recupero character varying(50) NOT NULL,
                                                             key_fonte character varying(50) NOT NULL,
                                                             imp_recupero numeric(17,2) NOT NULL,
                                                             data_recupero date NOT NULL,
                                                             soggetto_recupero character varying(100) NOT NULL,
                                                             ae_reversale character varying(4),
                                                             reversale character varying(10),
                                                             id_riga_reversale character varying(4),
                                                             cod_recupero character varying(50),
                                                             fg_tipo_recupero character varying(1) NOT NULL,
                                                             note character varying(1000)
);

ALTER TABLE certificazione.t_storico_recuperi_dai_benef OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_storico_recuperi_dai_benef.ae_reversale IS 'Se regionale';

COMMENT ON COLUMN certificazione.t_storico_recuperi_dai_benef.reversale IS 'Se regionale';

COMMENT ON COLUMN certificazione.t_storico_recuperi_dai_benef.id_riga_reversale IS 'Se regionale';

COMMENT ON COLUMN certificazione.t_storico_recuperi_dai_benef.cod_recupero IS 'Se non regionale';

COMMENT ON COLUMN certificazione.t_storico_recuperi_dai_benef.fg_tipo_recupero IS 'R/N -> Regionale/Non regionale';

ALTER TABLE ONLY certificazione.t_storico_recuperi_dai_benef
    ADD CONSTRAINT t_storico_recuperi_dai_benef_pk PRIMARY KEY (fk_certificazione, key_progetto, key_recupero);

ALTER TABLE ONLY certificazione.t_storico_recuperi_dai_benef
    ADD CONSTRAINT t_storico_recuperi_dai_benef_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);

INSERT INTO certificazione.t_storico_recuperi_dai_benef VALUES (1, '10058181', '10058181/598743/2024', 'SIU', 10000.00, '2024-06-25', 'REGIONE VENETO', '2024', '598743', '001', NULL, 'R', NULL);


--
-- TOC entry 262 (class 1259 OID 18970)
-- Name: t_storico_tagli; Type: TABLE; Schema: certificazione; Owner: postgres
--

CREATE TABLE certificazione.t_storico_tagli (
                                                fk_certificazione integer NOT NULL,
                                                key_taglio character varying(50) NOT NULL,
                                                key_fonte character varying(50) NOT NULL,
                                                key_progetto character varying(50) NOT NULL,
                                                key_giustificativo character varying(50),
                                                key_voce_spesa character varying(50),
                                                fg_tipo_taglio character varying(10) NOT NULL,
                                                imp_amm_taglio numeric(17,2) NOT NULL,
                                                imp_mat_taglio numeric(17,2) NOT NULL,
                                                note character varying(2000)
);

ALTER TABLE certificazione.t_storico_tagli OWNER TO postgres;

COMMENT ON COLUMN certificazione.t_storico_tagli.fg_tipo_taglio IS 'S/P/A -> Su giustificativi, progetto o anticipi';

ALTER TABLE ONLY certificazione.t_storico_tagli
    ADD CONSTRAINT t_storico_tagli_pk PRIMARY KEY (fk_certificazione, key_taglio);

ALTER TABLE ONLY certificazione.t_storico_tagli
    ADD CONSTRAINT t_storico_tagli_t_certificazioni_fk FOREIGN KEY (fk_certificazione) REFERENCES certificazione.t_certificazioni(id_certificazione);
