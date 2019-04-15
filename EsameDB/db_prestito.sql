-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: prestito_libri
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_anag_bambini`
--

DROP TABLE IF EXISTS `t_anag_bambini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_anag_bambini` (
  `id_anag_bambino` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `mail` varchar(60) NOT NULL,
  `data_nascita` date DEFAULT NULL,
  PRIMARY KEY (`id_anag_bambino`),
  KEY `idx_Cognome` (`cognome`),
  KEY `idx_nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_anag_bambini`
--

LOCK TABLES `t_anag_bambini` WRITE;
/*!40000 ALTER TABLE `t_anag_bambini` DISABLE KEYS */;
INSERT INTO `t_anag_bambini` VALUES (1,'Mario','Rossi','0125/22556','mail.mario@gmail.com','2008-05-01'),(2,'Giovanni','Bianchi','0125/556699','mail.gio@libero.it','2007-04-06'),(3,'Rosanna','Bertetto','11225588','mail.rosa@libero.it','2008-05-02'),(4,'maria','cicci','01244','mail','2007-10-22');
/*!40000 ALTER TABLE `t_anag_bambini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_libri`
--

DROP TABLE IF EXISTS `t_libri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_libri` (
  `id_libro` int(11) NOT NULL AUTO_INCREMENT,
  `nr_protocollo` varchar(45) NOT NULL,
  `titolo` varchar(45) NOT NULL,
  `autore` varchar(45) NOT NULL,
  PRIMARY KEY (`id_libro`),
  KEY `idx_titolo` (`titolo`),
  KEY `idx_autore` (`autore`),
  KEY `idx_prot` (`nr_protocollo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_libri`
--

LOCK TABLES `t_libri` WRITE;
/*!40000 ALTER TABLE `t_libri` DISABLE KEYS */;
INSERT INTO `t_libri` VALUES (1,'c1244','Dalla terra alla luna','Verne'),(2,'a4588','IT','King'),(3,'5588a5','Le avventure di Topolino','Disney'),(4,'c1245','Dalla terra alla luna','Verne'),(5,'c225588','assassinio sul Nilo','Agata Christie');
/*!40000 ALTER TABLE `t_libri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_prestiti`
--

DROP TABLE IF EXISTS `t_prestiti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_prestiti` (
  `id_prestito` int(11) NOT NULL AUTO_INCREMENT,
  `id_anag_bambino` int(11) NOT NULL,
  `id_libro` int(11) NOT NULL,
  `data_prestito` date NOT NULL,
  `data_reso` date DEFAULT NULL,
  PRIMARY KEY (`id_prestito`),
  KEY `idx_bamb` (`id_anag_bambino`),
  KEY `idx_libro` (`id_libro`),
  CONSTRAINT `fk_bambino` FOREIGN KEY (`id_anag_bambino`) REFERENCES `t_anag_bambini` (`id_anag_bambino`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro` FOREIGN KEY (`id_libro`) REFERENCES `t_libri` (`id_libro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_prestiti`
--

LOCK TABLES `t_prestiti` WRITE;
/*!40000 ALTER TABLE `t_prestiti` DISABLE KEYS */;
INSERT INTO `t_prestiti` VALUES (2,1,3,'2018-12-02','2019-01-15'),(4,3,2,'2019-03-15',NULL),(5,2,1,'2019-03-01',NULL),(6,2,1,'2018-09-12','2018-10-01');
/*!40000 ALTER TABLE `t_prestiti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_classifica_bambini`
--

DROP TABLE IF EXISTS `v_classifica_bambini`;
/*!50001 DROP VIEW IF EXISTS `v_classifica_bambini`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_classifica_bambini` (
  `nr_prest` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `id_anag_bambino` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_classifica_prestiti`
--

DROP TABLE IF EXISTS `v_classifica_prestiti`;
/*!50001 DROP VIEW IF EXISTS `v_classifica_prestiti`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_classifica_prestiti` (
  `id_libro` tinyint NOT NULL,
  `nr_prest` tinyint NOT NULL,
  `titolo` tinyint NOT NULL,
  `autore` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_elenco_bambini`
--

DROP TABLE IF EXISTS `v_elenco_bambini`;
/*!50001 DROP VIEW IF EXISTS `v_elenco_bambini`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_elenco_bambini` (
  `cognome` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `telefono` tinyint NOT NULL,
  `mail` tinyint NOT NULL,
  `data_nascita` tinyint NOT NULL,
  `id_anag_bambino` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_elenco_libri`
--

DROP TABLE IF EXISTS `v_elenco_libri`;
/*!50001 DROP VIEW IF EXISTS `v_elenco_libri`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_elenco_libri` (
  `titolo` tinyint NOT NULL,
  `autore` tinyint NOT NULL,
  `id_libro` tinyint NOT NULL,
  `nr_protocollo` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_elenco_prestiti`
--

DROP TABLE IF EXISTS `v_elenco_prestiti`;
/*!50001 DROP VIEW IF EXISTS `v_elenco_prestiti`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_elenco_prestiti` (
  `nome` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `titolo` tinyint NOT NULL,
  `autore` tinyint NOT NULL,
  `data_prestito` tinyint NOT NULL,
  `data_reso` tinyint NOT NULL,
  `id_anag_bambino` tinyint NOT NULL,
  `id_prestito` tinyint NOT NULL,
  `id_libro` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_elenco_prestiti_fuori`
--

DROP TABLE IF EXISTS `v_elenco_prestiti_fuori`;
/*!50001 DROP VIEW IF EXISTS `v_elenco_prestiti_fuori`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_elenco_prestiti_fuori` (
  `nome` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `titolo` tinyint NOT NULL,
  `autore` tinyint NOT NULL,
  `data_prestito` tinyint NOT NULL,
  `id_anag_bambino` tinyint NOT NULL,
  `id_prestito` tinyint NOT NULL,
  `id_libro` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_classifica_bambini`
--

/*!50001 DROP TABLE IF EXISTS `v_classifica_bambini`*/;
/*!50001 DROP VIEW IF EXISTS `v_classifica_bambini`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_classifica_bambini` AS select count(`v_elenco_prestiti`.`id_anag_bambino`) AS `nr_prest`,`v_elenco_prestiti`.`nome` AS `nome`,`v_elenco_prestiti`.`cognome` AS `cognome`,`v_elenco_prestiti`.`id_anag_bambino` AS `id_anag_bambino` from `v_elenco_prestiti` group by `v_elenco_prestiti`.`id_anag_bambino` order by count(`v_elenco_prestiti`.`id_anag_bambino`) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_classifica_prestiti`
--

/*!50001 DROP TABLE IF EXISTS `v_classifica_prestiti`*/;
/*!50001 DROP VIEW IF EXISTS `v_classifica_prestiti`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_classifica_prestiti` AS select `l`.`id_libro` AS `id_libro`,count(`l`.`id_libro`) AS `nr_prest`,`l`.`titolo` AS `titolo`,`l`.`autore` AS `autore` from (`v_elenco_prestiti` `el` join `t_libri` `l` on((`el`.`id_libro` = `l`.`id_libro`))) group by `l`.`id_libro` order by count(`l`.`id_libro`) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_elenco_bambini`
--

/*!50001 DROP TABLE IF EXISTS `v_elenco_bambini`*/;
/*!50001 DROP VIEW IF EXISTS `v_elenco_bambini`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_elenco_bambini` AS select `t_anag_bambini`.`cognome` AS `cognome`,`t_anag_bambini`.`nome` AS `nome`,`t_anag_bambini`.`telefono` AS `telefono`,`t_anag_bambini`.`mail` AS `mail`,`t_anag_bambini`.`data_nascita` AS `data_nascita`,`t_anag_bambini`.`id_anag_bambino` AS `id_anag_bambino` from `t_anag_bambini` order by `t_anag_bambini`.`cognome`,`t_anag_bambini`.`nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_elenco_libri`
--

/*!50001 DROP TABLE IF EXISTS `v_elenco_libri`*/;
/*!50001 DROP VIEW IF EXISTS `v_elenco_libri`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_elenco_libri` AS select `t_libri`.`titolo` AS `titolo`,`t_libri`.`autore` AS `autore`,`t_libri`.`id_libro` AS `id_libro`,`t_libri`.`nr_protocollo` AS `nr_protocollo` from `t_libri` order by `t_libri`.`titolo`,`t_libri`.`autore` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_elenco_prestiti`
--

/*!50001 DROP TABLE IF EXISTS `v_elenco_prestiti`*/;
/*!50001 DROP VIEW IF EXISTS `v_elenco_prestiti`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_elenco_prestiti` AS select `b`.`nome` AS `nome`,`b`.`cognome` AS `cognome`,`l`.`titolo` AS `titolo`,`l`.`autore` AS `autore`,`p`.`data_prestito` AS `data_prestito`,`p`.`data_reso` AS `data_reso`,`b`.`id_anag_bambino` AS `id_anag_bambino`,`p`.`id_prestito` AS `id_prestito`,`l`.`id_libro` AS `id_libro` from ((`t_anag_bambini` `b` join `t_prestiti` `p` on((`b`.`id_anag_bambino` = `p`.`id_anag_bambino`))) join `t_libri` `l` on((`p`.`id_libro` = `l`.`id_libro`))) order by `p`.`data_prestito` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_elenco_prestiti_fuori`
--

/*!50001 DROP TABLE IF EXISTS `v_elenco_prestiti_fuori`*/;
/*!50001 DROP VIEW IF EXISTS `v_elenco_prestiti_fuori`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_elenco_prestiti_fuori` AS select `b`.`nome` AS `nome`,`b`.`cognome` AS `cognome`,`l`.`titolo` AS `titolo`,`l`.`autore` AS `autore`,`p`.`data_prestito` AS `data_prestito`,`b`.`id_anag_bambino` AS `id_anag_bambino`,`p`.`id_prestito` AS `id_prestito`,`l`.`id_libro` AS `id_libro` from ((`t_anag_bambini` `b` join `t_prestiti` `p` on((`b`.`id_anag_bambino` = `p`.`id_anag_bambino`))) join `t_libri` `l` on((`p`.`id_libro` = `l`.`id_libro`))) where isnull(`p`.`data_reso`) order by `p`.`data_prestito` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-04 15:29:21
