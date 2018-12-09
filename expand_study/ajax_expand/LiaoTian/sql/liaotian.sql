/*
SQLyog Ultimate v9.20 
MySQL - 5.1.37-community : Database - liaotian
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`liaotian` /*!40100 DEFAULT CHARACTER SET gb2312 */;

USE `liaotian`;

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `MESSAGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MESSAGE_CONTENT` char(255) DEFAULT NULL,
  `MESSAGE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`MESSAGE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=306 DEFAULT CHARSET=gb2312;

/*Data for the table `message` */

insert  into `message`(`MESSAGE_ID`,`MESSAGE_CONTENT`,`MESSAGE_TIME`) values (1,'ABC','2015-02-05 21:45:53'),(2,'AAA','2015-02-05 22:16:31'),(3,'BBB','2015-02-05 22:16:34'),(4,'CCC','2015-02-05 22:16:36'),(5,'DDD','2015-02-05 22:16:37'),(6,'EEE','2015-02-05 22:16:40'),(7,'hello','2015-02-05 00:00:00'),(8,'aaaaaa','2015-02-05 22:45:35'),(9,'bbbbbbbbbb','2015-02-05 22:45:59'),(10,'cccccccccc','2015-02-05 22:47:12'),(11,'sss','2015-02-05 22:51:28'),(12,'ddd','2015-02-05 22:51:34'),(13,'eeeeeeee','2015-02-05 22:52:04'),(14,'fffffffffffff','2015-02-05 22:53:07'),(15,'gggggggggg','2015-02-05 22:57:18'),(16,'hhhhhhhhh','2015-02-05 22:59:17'),(17,'iiiiiiiii','2015-02-05 23:00:50'),(18,'jjjjjjjjjjj','2015-02-05 23:01:10'),(19,'kkkkkkkkkkk','2015-02-05 23:06:25'),(20,'lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll','2015-02-05 23:08:02'),(21,'mmmmmmmmmmmmm','2015-02-05 23:16:40'),(22,'oooooooooo','2015-02-05 23:17:59'),(23,'\nppppppppppp','2015-02-05 23:18:02'),(24,'\nqqqqqqqqqqqqqq','2015-02-05 23:18:04'),(25,'rrrrrrrr','2015-02-05 23:18:11'),(26,'\nsssssssss','2015-02-05 23:18:13'),(27,'\ntttttttttt','2015-02-05 23:18:15'),(28,'\nu','2015-02-05 23:18:16'),(29,'\n','2015-02-05 23:18:16'),(30,'\n','2015-02-05 23:18:16'),(31,'\nvvvvvvvvvv','2015-02-05 23:18:19'),(32,'\nwwwwwwwwwww','2015-02-05 23:18:21'),(33,'\nxxxxxxxxx','2015-02-05 23:18:24'),(34,'\ny','2015-02-05 23:18:25'),(35,'\n','2015-02-05 23:18:25'),(36,'\n','2015-02-05 23:18:25'),(37,'\n','2015-02-05 23:18:25'),(38,'\n','2015-02-05 23:18:26'),(39,'\n','2015-02-05 23:18:26'),(40,'\nzz','2015-02-05 23:18:27'),(41,'1111111111111','2015-02-05 23:18:59'),(42,'\n2222222222222222','2015-02-05 23:19:02'),(43,'\n3','2015-02-05 23:19:03'),(44,'\n','2015-02-05 23:19:04'),(45,'\n444444444444444','2015-02-05 23:19:06'),(46,'\n55555555','2015-02-05 23:19:08'),(47,'\n666666666666','2015-02-05 23:19:10'),(48,'\n7777777777','2015-02-05 23:19:13'),(49,'88888888888','2015-02-05 23:20:03'),(50,'\r\n99999999999','2015-02-05 23:20:05'),(51,'1110000000','2015-02-05 23:20:19'),(52,'22222222222222','2015-02-05 23:20:29'),(53,'33333333333','2015-02-05 23:21:20'),(54,'\r\n4444444444444','2015-02-05 23:21:22'),(55,'\r\n555555555555','2015-02-05 23:21:24'),(56,'\r\n6','2015-02-05 23:21:26'),(57,'777777777777','2015-02-05 23:22:41'),(58,'dddddddddddddd','2015-02-05 23:24:22'),(59,'sss','2015-02-05 23:25:18'),(60,'asdfsadfsdf','2015-02-05 23:26:04'),(61,'werewttt','2015-02-05 23:26:06'),(62,'woewkdslfkds','2015-02-05 23:26:08'),(63,'sadlfjdslf','2015-02-05 23:26:09'),(64,'lwkejrklsdjfds','2015-02-05 23:26:10'),(65,'lasdjf','2015-02-05 23:26:12'),(66,'aaaaaaaaaaaa','2015-02-05 23:30:03'),(67,'dddddddddddd','2015-02-05 23:30:05'),(68,'wwwwwwwwww','2015-02-05 23:30:06'),(69,'vvvvvvvvvvvvvvvv','2015-02-05 23:30:08'),(70,'yyyyyyyyyy','2015-02-05 23:30:10'),(71,'qqqqqqqqqqqqqq','2015-02-05 23:30:16'),(72,'weeeeeeeee','2015-02-05 23:30:34'),(73,'eeeeeeeeeeee','2015-02-05 23:31:18'),(74,'pppppp','2015-02-05 23:31:26'),(75,'qqqqqqqqq','2015-02-05 23:31:53'),(76,'vbbbbbbbbbb','2015-02-05 23:32:56'),(77,'qqqqqqq','2015-02-05 23:33:01'),(78,'yyyyyyyyy','2015-02-05 23:33:14'),(79,'cccccccccc','2015-02-05 23:33:36'),(80,'ttttttt','2015-02-05 23:33:52'),(81,'eeeeeeeeee','2015-02-05 23:33:59'),(82,'qqqqqqqqq','2015-02-05 23:34:08'),(83,'xxxxxxxxxx','2015-02-05 23:34:33'),(84,'uuuuuuuu','2015-02-05 23:34:41'),(85,'ttttttttt','2015-02-05 23:34:46'),(86,'lllllllll','2015-02-05 23:34:54'),(87,'ppppppp','2015-02-05 23:35:12'),(88,'ppppppp','2015-02-05 23:35:21'),(89,'ccccccc','2015-02-05 23:35:28'),(90,'ooooooo','2015-02-05 23:35:37'),(91,'sdfsd','2015-02-05 23:46:59'),(92,'wwwwwwwwwwwww','2015-02-05 23:47:08'),(93,'sdf','2015-02-05 23:47:20'),(94,'sdfds','2015-02-05 23:47:47'),(95,'qqqqqqqqqwwwwwwwww','2015-02-05 23:47:52'),(96,'ggggggggggg','2015-02-05 23:48:18'),(97,'asdfsdf','2015-02-06 05:11:17'),(98,'qwwwwwwwwwwww','2015-02-06 07:17:55'),(99,'pppppppp','2015-02-06 07:17:59'),(100,'zzzzzzzzzzzz','2015-02-06 07:18:02'),(101,'vvvvvvvvvvvvv','2015-02-06 07:18:05'),(102,'zzzzzzzzzz','2015-02-06 07:18:07'),(103,'fffffffffffffff','2015-02-06 12:10:44'),(104,'wwwwwwwwwwww','2015-02-06 12:11:04'),(105,'dddddddddddd','2015-02-06 13:08:12'),(106,'pppppppppp','2015-02-06 13:08:50'),(107,'xxxxxxxxx','2015-02-06 13:09:43'),(108,'ttttttttt','2015-02-06 13:09:47'),(109,'ppppppppp','2015-02-06 13:09:51'),(110,'qqqqqqqqqqq','2015-02-06 13:09:53'),(111,'eeeeeeeeee','2015-02-06 13:09:56'),(112,'wwwwwwwwwww','2015-02-06 13:09:59'),(113,'vvvvvvvvvvvv','2015-02-06 13:10:02'),(114,'qqqqqqqqqq','2015-02-07 16:52:00'),(115,'1','2015-02-07 16:52:32'),(116,'#132','2015-02-07 16:52:37'),(117,'�������������','2015-02-07 16:52:38'),(118,'aaaaaaaaaaaaaa','2015-02-07 16:52:38'),(119,'hah','2015-02-07 16:52:38'),(120,'yyyy','2015-02-07 16:52:40'),(121,'dfdf','2015-02-07 16:52:40'),(122,'ss','2015-02-07 16:52:41'),(123,'������','2015-02-07 16:52:41'),(124,'erqwrqw','2015-02-07 16:52:43'),(125,'gdggfddgdggdf','2015-02-07 16:52:43'),(126,'qwe','2015-02-07 16:52:43'),(127,'qw','2015-02-07 16:52:43'),(128,'��','2015-02-07 16:52:43'),(129,'�ð�','2015-02-07 16:52:43'),(130,'e','2015-02-07 16:52:43'),(131,'ahahah','2015-02-07 16:52:44'),(132,'itn','2015-02-07 16:52:47'),(133,'��ʦ��Ǯ','2015-02-07 16:52:47'),(134,'+1','2015-02-07 16:52:48'),(135,'�������������','2015-02-07 16:52:49'),(136,'HH','2015-02-07 16:52:49'),(137,'wqe','2015-02-07 16:52:49'),(138,'haha','2015-02-07 16:52:50'),(139,'����','2015-02-07 16:52:50'),(140,'��һ��~','2015-02-07 16:52:50'),(141,'��ʦ ����һ��Է�','2015-02-07 16:52:53'),(142,'��������','2015-02-07 16:52:53'),(143,'��ID','2015-02-07 16:52:53'),(144,'���� ������','2015-02-07 16:52:53'),(145,'�������������','2015-02-07 16:52:54'),(146,'+1','2015-02-07 16:52:55'),(147,'����ʦҲ���','2015-02-07 16:52:55'),(148,'��','2015-02-07 16:52:56'),(149,'�������ս�ջ���','2015-02-07 16:52:58'),(150,'�����','2015-02-07 16:52:58'),(151,'������','2015-02-07 16:52:58'),(152,'Сʱ��ʾ�е�С����','2015-02-07 16:52:59'),(153,'�������','2015-02-07 16:52:59'),(154,'����� �Ұ���','2015-02-07 16:53:00'),(155,'����� �Ұ���','2015-02-07 16:53:08'),(156,'��������ս�ջ���','2015-02-07 16:53:08'),(157,'������ �Ұ���','2015-02-07 16:53:08'),(158,'�������','2015-02-07 16:53:13'),(159,'�󲨶���','2015-02-07 16:53:14'),(160,'����� �Ұ���','2015-02-07 16:53:17'),(161,'������','2015-02-07 16:53:17'),(162,'- -','2015-02-07 16:53:19'),(163,'��Ҳ����','2015-02-07 16:53:23'),(164,'��ô����������','2015-02-07 16:53:25'),(165,'�����ǣ��� ����������','2015-02-07 16:53:29'),(166,'�Ұ�����','2015-02-07 16:53:30'),(167,'�������������','2015-02-07 16:53:32'),(168,'�����¾����ü�','2015-02-07 16:53:33'),(169,'�������������','2015-02-07 16:53:34'),(170,'�ջ���Ӯ��','2015-02-07 16:53:35'),(171,'�������������','2015-02-07 16:53:35'),(172,'�������������','2015-02-07 16:53:35'),(173,'�������������','2015-02-07 16:53:36'),(174,'�������������','2015-02-07 16:53:36'),(175,'�������������','2015-02-07 16:53:36'),(176,'�������������','2015-02-07 16:53:37'),(177,'�����������','2015-02-07 16:53:37'),(178,'�������������','2015-02-07 16:53:37'),(179,'�������������','2015-02-07 16:53:37'),(180,'�������������','2015-02-07 16:53:38'),(181,'�������������','2015-02-07 16:53:38'),(182,'�������������','2015-02-07 16:53:38'),(183,'�������������','2015-02-07 16:53:39'),(184,'�������������','2015-02-07 16:53:39'),(185,'�������������','2015-02-07 16:53:39'),(186,'�������������','2015-02-07 16:53:39'),(187,'�������������','2015-02-07 16:53:40'),(188,'����ˢ��','2015-02-07 16:53:41'),(189,'ʲôʱ��','2015-02-07 16:53:42'),(190,'Ӵ�������˸�','2015-02-07 16:53:44'),(191,'9494','2015-02-07 16:53:45'),(192,'�Ҹɣ�����','2015-02-07 16:53:46'),(193,'�ϱ�ɽ �ٺϻ��� �ĸо�','2015-02-07 16:53:46'),(194,'1','2015-02-07 16:53:47'),(195,'1','2015-02-07 16:53:47'),(196,'1','2015-02-07 16:53:47'),(197,'1','2015-02-07 16:53:48'),(198,'1','2015-02-07 16:53:48'),(199,'��Ҫˢ��','2015-02-07 16:53:48'),(200,'1','2015-02-07 16:53:48'),(201,'11','2015-02-07 16:53:48'),(202,'1','2015-02-07 16:53:48'),(203,'1','2015-02-07 16:53:48'),(204,'1','2015-02-07 16:53:49'),(205,'11','2015-02-07 16:53:49'),(206,'1','2015-02-07 16:53:49'),(207,'1','2015-02-07 16:53:50'),(208,'1','2015-02-07 16:53:50'),(209,'2','2015-02-07 16:53:54'),(210,'��','2015-02-07 16:53:56'),(211,'1','2015-02-07 16:53:56'),(212,'1','2015-02-07 16:53:57'),(213,'1','2015-02-07 16:53:57'),(214,'1','2015-02-07 16:53:57'),(215,'����','2015-02-07 16:53:57'),(216,'ˢ���� ��Ҫ','2015-02-07 16:53:57'),(217,'����','2015-02-07 16:53:59'),(218,'t�Ұ�','2015-02-07 16:54:01'),(219,'����','2015-02-07 16:54:04'),(220,'��t','2015-02-07 16:54:05'),(221,'��������ʱ������','2015-02-07 16:54:05'),(222,'2015��02��07�� HH:53:56 ��\n\n2015��02��07�� HH:53:56 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 ����\n\n2015��02��07�� HH:53:57 ˢ���� ��Ҫ','2015-02-07 16:54:09'),(223,'������һ��ʲôʱ���ܰ���ʦ�ĵ��Կ���','2015-02-07 16:54:13'),(224,'��˹��','2015-02-07 16:54:17'),(225,'������','2015-02-07 16:54:24'),(226,'2015��2��7��16:55:07','2015-02-07 16:54:30'),(227,'��ͯЬ�ĵ�����','2015-02-07 16:54:31'),(228,'�� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 ������','2015-02-07 16:54:32'),(229,'�� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 ������','2015-02-07 16:54:32'),(230,'����200M����','2015-02-07 16:54:32'),(231,'��������','2015-02-07 16:54:33'),(232,'�� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 �������� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 �������� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 ������','2015-02-07 16:54:33'),(233,'��������','2015-02-07 16:54:34'),(234,'�� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 �������� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 �������� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 ������','2015-02-07 16:54:34'),(235,'�� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 �������� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 ������','2015-02-07 16:54:35'),(236,'�� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 ������','2015-02-07 16:54:35'),(237,'��������������ظ�','2015-02-07 16:54:35'),(238,'�� HH:54:17 ��˹��\n2015��02��07�� HH:54:17 ��˹��\n2015��02��07�� HH:54:24 ������','2015-02-07 16:54:36'),(239,'o(��_��)o ����','2015-02-07 16:54:36'),(240,'��','2015-02-07 16:54:42'),(241,'a','2015-02-07 16:54:44'),(242,'(*^__^*) ����','2015-02-07 16:54:45'),(243,'����������','2015-02-07 16:54:45'),(244,'��','2015-02-07 16:54:45'),(245,'2015��02��07�� HH:53:56 ��\n\n2015��02��07�� HH:53:56 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 ����\n\n2015��02��07�� HH:53:57 ˢ���� ��Ҫv','2015-02-07 16:54:50'),(246,'2015��02��07�� HH:53:56 ��\n\n2015��02��07�� HH:53:56 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 ����\n\n2015��02��07�� HH:53:57 ˢ���� ��Ҫv','2015-02-07 16:54:51'),(247,'�������� ��Ҫ��������','2015-02-07 16:54:51'),(248,'2015��02��07�� HH:53:56 ��\n\n2015��02��07�� HH:53:56 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 ����\n\n2015��02��07�� HH:53:57 ˢ���� ��Ҫ','2015-02-07 16:54:51'),(249,'v2015��02��07�� HH:53:56 ��\n\n2015��02��07�� HH:53:56 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 1\n\n2015��02��07�� HH:53:57 ����\n\n2015��02��07�� HH:53:57 ˢ���� ��Ҫ','2015-02-07 16:54:53'),(250,'��ʵ�ⶼ���������� ������','2015-02-07 16:54:53'),(251,'�Ͻ�������','2015-02-07 16:54:56'),(252,'ttttttttttttt','2015-02-07 16:55:02'),(253,'1s��','2015-02-07 16:55:03'),(254,'HH:53:57  HH:53:57  HH:53:57  HH:53:57  HH:53:57','2015-02-07 16:55:06'),(255,'HH:53:57','2015-02-07 16:55:06'),(256,'v HH:53:57  HH:53:57  HH:53:57  HH:53:57  HH:53:57','2015-02-07 16:55:07'),(257,'HH:53:57  HH:53:57  HH:53:57  HH:53:57','2015-02-07 16:55:08'),(258,'11111111111111111111111111111111111','2015-02-07 16:55:08'),(259,'eeeeeeeeeeeeeeeeeeeeeeeee','2015-02-07 16:55:09'),(260,'��Ҫˢ��','2015-02-07 16:55:14'),(261,'������','2015-02-07 16:55:16'),(262,'asdf','2015-02-07 16:55:16'),(263,'�ȷ���ʡ�ݵط���','2015-02-07 16:55:17'),(264,'2¥����','2015-02-07 16:55:18'),(265,'ad','2015-02-07 16:55:18'),(266,'111','2015-02-07 16:55:21'),(267,'adsfadsfadf','2015-02-07 16:55:21'),(268,'11','2015-02-07 16:55:21'),(269,'11','2015-02-07 16:55:22'),(270,'1','2015-02-07 16:55:22'),(271,'11','2015-02-07 16:55:22'),(272,'1','2015-02-07 16:55:22'),(273,'1','2015-02-07 16:55:22'),(274,'1','2015-02-07 16:55:23'),(275,'����ֱ��','2015-02-07 16:55:23'),(276,'asdafsdfasfasdf','2015-02-07 16:55:23'),(277,'asdf','2015-02-07 16:55:24'),(278,'adsfasd','2015-02-07 16:55:25'),(279,'asdfasdfasdf','2015-02-07 16:55:26'),(280,'asdfasdfadfasdf','2015-02-07 16:55:28'),(281,'dfgsdfhsd','2015-02-07 16:55:29'),(282,'fuck','2015-02-07 16:55:29'),(283,'¥��sb','2015-02-07 16:55:30'),(284,'3¥����','2015-02-07 16:55:31'),(285,'����','2015-02-07 16:55:37'),(286,'¥�� ¥�� 2B','2015-02-07 16:55:39'),(287,'fuck me deep','2015-02-07 16:55:41'),(288,'.....','2015-02-07 16:55:49'),(289,'˵�˻�','2015-02-07 16:55:52'),(290,'�����ǵػ�','2015-02-07 16:55:54'),(291,'��Ҷ�������Ц��','2015-02-07 16:55:58'),(292,'��ѧ���ߡ�','2015-02-07 16:56:00'),(293,'С����Ģ��','2015-02-07 16:56:00'),(294,'.....','2015-02-07 16:56:01'),(295,'С����ƨ��','2015-02-07 16:56:03'),(296,'С����Ģ��','2015-02-07 16:56:05'),(297,'��Ϊʲô��','2015-02-07 16:56:08'),(298,'��������','2015-02-07 16:56:14'),(299,'��������','2015-02-07 16:56:17'),(300,'����Ϊʲô������','2015-02-07 16:56:19'),(301,'�������','2015-02-07 16:56:23'),(302,'��Ľ�������ļ�','2015-02-07 16:56:25'),(303,'���Ϊʲô������ɧ��','2015-02-07 16:56:27'),(304,'��4��͵ı��� ���㡣��','2015-02-07 16:56:31'),(305,'dsfds','2015-02-07 16:56:35');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;