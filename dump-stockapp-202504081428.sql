-- MySQL dump 10.13  Distrib 9.2.0, for macos14.7 (arm64)
--
-- Host: localhost    Database: stockapp
-- ------------------------------------------------------
-- Server version	9.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `stock_symbol` varchar(10) NOT NULL,
  `date` date DEFAULT NULL,
  `open` decimal(10,2) DEFAULT NULL,
  `close` decimal(10,2) DEFAULT NULL,
  `high` decimal(10,2) DEFAULT NULL,
  `low` decimal(10,2) DEFAULT NULL,
  `volume` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `stock_symbol` (`stock_symbol`)
) ENGINE=InnoDB AUTO_INCREMENT=1865 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1736,'Apple Inc.','AAPL',NULL,NULL,NULL,NULL,NULL,NULL),(1737,'Microsoft Corporation','MSFT',NULL,NULL,NULL,NULL,NULL,NULL),(1738,'Amazon.com Inc.','AMZN',NULL,NULL,NULL,NULL,NULL,NULL),(1739,'Alphabet Inc.','GOOGL',NULL,NULL,NULL,NULL,NULL,NULL),(1740,'Tesla Inc.','TSLA',NULL,NULL,NULL,NULL,NULL,NULL),(1741,'Meta Platforms Inc.','META',NULL,NULL,NULL,NULL,NULL,NULL),(1742,'NVIDIA Corporation','NVDA',NULL,NULL,NULL,NULL,NULL,NULL),(1743,'JPMorgan Chase & Co.','JPM',NULL,NULL,NULL,NULL,NULL,NULL),(1744,'Visa Inc.','V',NULL,NULL,NULL,NULL,NULL,NULL),(1745,'Walmart Inc.','WMT',NULL,NULL,NULL,NULL,NULL,NULL),(1746,'Mastercard Incorporated','MA',NULL,NULL,NULL,NULL,NULL,NULL),(1747,'Procter & Gamble Company','PG',NULL,NULL,NULL,NULL,NULL,NULL),(1748,'The Walt Disney Company','DIS',NULL,NULL,NULL,NULL,NULL,NULL),(1749,'Netflix Inc.','NFLX',NULL,NULL,NULL,NULL,NULL,NULL),(1750,'Adobe Inc.','ADBE',NULL,NULL,NULL,NULL,NULL,NULL),(1751,'PayPal Holdings Inc.','PYPL',NULL,NULL,NULL,NULL,NULL,NULL),(1752,'Intel Corporation','INTC',NULL,NULL,NULL,NULL,NULL,NULL),(1753,'Cisco Systems Inc.','CSCO',NULL,NULL,NULL,NULL,NULL,NULL),(1754,'PepsiCo Inc.','PEP',NULL,NULL,NULL,NULL,NULL,NULL),(1755,'The Coca-Cola Company','KO',NULL,NULL,NULL,NULL,NULL,NULL),(1756,'Exxon Mobil Corporation','XOM',NULL,NULL,NULL,NULL,NULL,NULL),(1757,'Bank of America Corporation','BAC',NULL,NULL,NULL,NULL,NULL,NULL),(1758,'Salesforce Inc.','CRM',NULL,NULL,NULL,NULL,NULL,NULL),(1759,'Advanced Micro Devices Inc.','AMD',NULL,NULL,NULL,NULL,NULL,NULL),(1760,'NIKE Inc.','NKE',NULL,NULL,NULL,NULL,NULL,NULL),(1761,'United Parcel Service Inc.','UPS',NULL,NULL,NULL,NULL,NULL,NULL),(1762,'Thermo Fisher Scientific Inc.','TMO',NULL,NULL,NULL,NULL,NULL,NULL),(1763,'Costco Wholesale Corporation','COST',NULL,NULL,NULL,NULL,NULL,NULL),(1764,'Starbucks Corporation','SBUX',NULL,NULL,NULL,NULL,NULL,NULL),(1765,'Pfizer Inc.','PFE',NULL,NULL,NULL,NULL,NULL,NULL),(1766,'Merck & Co. Inc.','MRK',NULL,NULL,NULL,NULL,NULL,NULL),(1767,'Johnson & Johnson','JNJ',NULL,NULL,NULL,NULL,NULL,NULL),(1768,'Verizon Communications Inc.','VZ',NULL,NULL,NULL,NULL,NULL,NULL),(1769,'AT&T Inc.','T',NULL,NULL,NULL,NULL,NULL,NULL),(1770,'Home Depot Inc.','HD',NULL,NULL,NULL,NULL,NULL,NULL),(1771,'Lowe\'s Companies Inc.','LOW',NULL,NULL,NULL,NULL,NULL,NULL),(1772,'Boeing Company','BA',NULL,NULL,NULL,NULL,NULL,NULL),(1773,'3M Company','MMM',NULL,NULL,NULL,NULL,NULL,NULL),(1774,'IBM Common Stock','IBM',NULL,NULL,NULL,NULL,NULL,NULL),(1775,'Goldman Sachs Group Inc.','GS',NULL,NULL,NULL,NULL,NULL,NULL),(1776,'Morgan Stanley','MS',NULL,NULL,NULL,NULL,NULL,NULL),(1777,'Citigroup Inc.','C',NULL,NULL,NULL,NULL,NULL,NULL),(1778,'Wells Fargo & Company','WFC',NULL,NULL,NULL,NULL,NULL,NULL),(1779,'Chevron Corporation','CVX',NULL,NULL,NULL,NULL,NULL,NULL),(1780,'ConocoPhillips','COP',NULL,NULL,NULL,NULL,NULL,NULL),(1781,'Valero Energy Corporation','VLO',NULL,NULL,NULL,NULL,NULL,NULL),(1782,'Lockheed Martin Corporation','LMT',NULL,NULL,NULL,NULL,NULL,NULL),(1783,'Raytheon Technologies Corporation','RTX',NULL,NULL,NULL,NULL,NULL,NULL),(1784,'General Electric Company','GE',NULL,NULL,NULL,NULL,NULL,NULL),(1785,'FedEx Corporation','FDX',NULL,NULL,NULL,NULL,NULL,NULL),(1786,'Target Corporation','TGT',NULL,NULL,NULL,NULL,NULL,NULL),(1787,'Best Buy Co. Inc.','BBY',NULL,NULL,NULL,NULL,NULL,NULL),(1788,'Dell Technologies Inc.','DELL',NULL,NULL,NULL,NULL,NULL,NULL),(1789,'HP Inc.','HPQ',NULL,NULL,NULL,NULL,NULL,NULL),(1790,'Oracle Corporation','ORCL',NULL,NULL,NULL,NULL,NULL,NULL),(1791,'QUALCOMM Incorporated','QCOM',NULL,NULL,NULL,NULL,NULL,NULL),(1792,'Texas Instruments Incorporated','TXN',NULL,NULL,NULL,NULL,NULL,NULL),(1793,'Micron Technology Inc.','MU',NULL,NULL,NULL,NULL,NULL,NULL),(1794,'Applied Materials Inc.','AMAT',NULL,NULL,NULL,NULL,NULL,NULL),(1795,'Broadcom Inc.','AVGO',NULL,NULL,NULL,NULL,NULL,NULL),(1796,'Lam Research Corporation','LRCX',NULL,NULL,NULL,NULL,NULL,NULL),(1797,'KLA Corporation','KLAC',NULL,NULL,NULL,NULL,NULL,NULL),(1798,'ASML Holding N.V.','ASML',NULL,NULL,NULL,NULL,NULL,NULL),(1799,'NXP Semiconductors N.V.','NXPI',NULL,NULL,NULL,NULL,NULL,NULL),(1800,'Analog Devices Inc.','ADI',NULL,NULL,NULL,NULL,NULL,NULL),(1801,'Skyworks Solutions Inc.','SWKS',NULL,NULL,NULL,NULL,NULL,NULL),(1802,'Marvell Technology Inc.','MRVL',NULL,NULL,NULL,NULL,NULL,NULL),(1803,'Monolithic Power Systems Inc.','MPWR',NULL,NULL,NULL,NULL,NULL,NULL),(1804,'Microchip Technology Incorporated','MCHP',NULL,NULL,NULL,NULL,NULL,NULL),(1805,'ON Semiconductor Corporation','ON',NULL,NULL,NULL,NULL,NULL,NULL),(1806,'Qorvo Inc.','QRVO',NULL,NULL,NULL,NULL,NULL,NULL),(1807,'Teradyne Inc.','TER',NULL,NULL,NULL,NULL,NULL,NULL),(1808,'Cadence Design Systems Inc.','CDNS',NULL,NULL,NULL,NULL,NULL,NULL),(1809,'Synopsys Inc.','SNPS',NULL,NULL,NULL,NULL,NULL,NULL),(1810,'Autodesk Inc.','ADSK',NULL,NULL,NULL,NULL,NULL,NULL),(1811,'Intuit Inc.','INTU',NULL,NULL,NULL,NULL,NULL,NULL),(1812,'Zoom Video Communications Inc.','ZM',NULL,NULL,NULL,NULL,NULL,NULL),(1813,'Shopify Inc.','SHOP',NULL,NULL,NULL,NULL,NULL,NULL),(1814,'Square Inc.','SQ',NULL,NULL,NULL,NULL,NULL,NULL),(1815,'Twilio Inc.','TWLO',NULL,NULL,NULL,NULL,NULL,NULL),(1816,'CrowdStrike Holdings Inc.','CRWD',NULL,NULL,NULL,NULL,NULL,NULL),(1817,'Zscaler Inc.','ZS',NULL,NULL,NULL,NULL,NULL,NULL),(1818,'Palo Alto Networks Inc.','PANW',NULL,NULL,NULL,NULL,NULL,NULL),(1819,'Fortinet Inc.','FTNT',NULL,NULL,NULL,NULL,NULL,NULL),(1820,'Datadog Inc.','DDOG',NULL,NULL,NULL,NULL,NULL,NULL),(1821,'ServiceNow Inc.','NOW',NULL,NULL,NULL,NULL,NULL,NULL),(1822,'Workday Inc.','WDAY',NULL,NULL,NULL,NULL,NULL,NULL),(1823,'Snowflake Inc.','SNOW',NULL,NULL,NULL,NULL,NULL,NULL),(1824,'MongoDB Inc.','MDB',NULL,NULL,NULL,NULL,NULL,NULL),(1825,'Unity Software Inc.','U',NULL,NULL,NULL,NULL,NULL,NULL),(1826,'Roblox Corporation','RBLX',NULL,NULL,NULL,NULL,NULL,NULL),(1827,'Coinbase Global Inc.','COIN',NULL,NULL,NULL,NULL,NULL,NULL),(1828,'Robinhood Markets Inc.','HOOD',NULL,NULL,NULL,NULL,NULL,NULL),(1829,'Palantir Technologies Inc.','PLTR',NULL,NULL,NULL,NULL,NULL,NULL),(1830,'Airbnb Inc.','ABNB',NULL,NULL,NULL,NULL,NULL,NULL),(1831,'Uber Technologies Inc.','UBER',NULL,NULL,NULL,NULL,NULL,NULL),(1832,'Lyft Inc.','LYFT',NULL,NULL,NULL,NULL,NULL,NULL),(1833,'DoorDash Inc.','DASH',NULL,NULL,NULL,NULL,NULL,NULL),(1834,'General Motors Company','GM',NULL,NULL,NULL,NULL,NULL,NULL),(1835,'Ford Motor Company','F',NULL,NULL,NULL,NULL,NULL,NULL),(1836,'Toyota Motor Corporation','TM',NULL,NULL,NULL,NULL,NULL,NULL),(1837,'Honda Motor Co. Ltd.','HMC',NULL,NULL,NULL,NULL,NULL,NULL),(1838,'Rivian Automotive Inc.','RIVN',NULL,NULL,NULL,NULL,NULL,NULL),(1839,'Lucid Group Inc.','LCID',NULL,NULL,NULL,NULL,NULL,NULL),(1840,'Nikola Corporation','NKLA',NULL,NULL,NULL,NULL,NULL,NULL),(1841,'Ferrari N.V.','RACE',NULL,NULL,NULL,NULL,NULL,NULL),(1842,'Porsche Automobil Holding SE','POAHY',NULL,NULL,NULL,NULL,NULL,NULL),(1843,'Bayerische Motoren Werke AG','BMWYY',NULL,NULL,NULL,NULL,NULL,NULL),(1844,'Volkswagen AG','VWAGY',NULL,NULL,NULL,NULL,NULL,NULL),(1845,'Stellantis N.V.','STLA',NULL,NULL,NULL,NULL,NULL,NULL),(1846,'Harley-Davidson Inc.','HOG',NULL,NULL,NULL,NULL,NULL,NULL),(1847,'Caterpillar Inc.','CAT',NULL,NULL,NULL,NULL,NULL,NULL),(1848,'Deere & Company','DE',NULL,NULL,NULL,NULL,NULL,NULL),(1849,'Honeywell International Inc.','HON',NULL,NULL,NULL,NULL,NULL,NULL),(1850,'General Dynamics Corporation','GD',NULL,NULL,NULL,NULL,NULL,NULL),(1851,'Northrop Grumman Corporation','NOC',NULL,NULL,NULL,NULL,NULL,NULL),(1852,'Bristol-Myers Squibb Company','BMY',NULL,NULL,NULL,NULL,NULL,NULL),(1853,'Amgen Inc.','AMGN',NULL,NULL,NULL,NULL,NULL,NULL),(1854,'Gilead Sciences Inc.','GILD',NULL,NULL,NULL,NULL,NULL,NULL),(1855,'Moderna Inc.','MRNA',NULL,NULL,NULL,NULL,NULL,NULL),(1856,'BioNTech SE','BNTX',NULL,NULL,NULL,NULL,NULL,NULL),(1857,'Novavax Inc.','NVAX',NULL,NULL,NULL,NULL,NULL,NULL),(1858,'Regeneron Pharmaceuticals Inc.','REGN',NULL,NULL,NULL,NULL,NULL,NULL),(1859,'Vertex Pharmaceuticals Incorporated','VRTX',NULL,NULL,NULL,NULL,NULL,NULL),(1860,'Illumina Inc.','ILMN',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'artem','artem@gmail.com','password'),(2,'adrian','adrian@gmail.com','password');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'stockapp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-08 14:28:42
